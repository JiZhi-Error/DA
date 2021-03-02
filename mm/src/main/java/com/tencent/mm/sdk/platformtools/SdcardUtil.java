package com.tencent.mm.sdk.platformtools;

import android.os.Environment;
import android.os.StatFs;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SdcardUtil {
    public static final String ID_EMULATED_INTERNAL = "emulated";
    private static final String TAG = "MicroMsg.SdcardUtil";
    static String[] excludeSpecialFileSystems = {"sysfs", "rootfs", "binfmt_misc", "anon_inodefs", "bdev", "proc", "cgroup", "tmpfs", "debugfs", "sockfs", "pipefs", "rpc_pipefs", "devpts", "ramfs", "fuseblk", "fusectl", "selinuxfs"};
    static String[] excludeStorageMountDirs = {"/mnt/secure", "/mnt/asec", "/mnt/obb", "/dev/mapper", "/data/"};
    static String[] includeDeviceNames = {"/dev/block/vold"};
    static String[] includeStorageFileSystems = {"vfat", "exfat", "fuse", "sdcardfs"};

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051 A[SYNTHETIC, Splitter:B:16:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073 A[SYNTHETIC, Splitter:B:23:0x0073] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<com.tencent.mm.sdk.platformtools.SdcardUtil.StatMountParse> parseProcMounts() {
        /*
        // Method dump skipped, instructions count: 171
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.SdcardUtil.parseProcMounts():java.util.ArrayList");
    }

    private static void filterSpecialFileSystems(ArrayList<StatMountParse> arrayList) {
        AppMethodBeat.i(230388);
        int size = arrayList.size();
        List asList = Arrays.asList(excludeSpecialFileSystems);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            if (asList.contains(arrayList.get(i2).fileSystem)) {
                arrayList.remove(i2);
            }
        }
        AppMethodBeat.o(230388);
    }

    public static ArrayList<StatMountParse> getStatMountParseExcludeSpecialFileSystems() {
        AppMethodBeat.i(230389);
        ArrayList<StatMountParse> parseProcMounts = parseProcMounts();
        filterSpecialFileSystems(parseProcMounts);
        AppMethodBeat.o(230389);
        return parseProcMounts;
    }

    public static void statFsForStatMountParse(StatMountParse statMountParse) {
        AppMethodBeat.i(157814);
        try {
            StatFs statFs = new StatFs(statMountParse.mountDir);
            statMountParse.blockSize = (long) statFs.getBlockSize();
            statMountParse.availableBlocks = (long) statFs.getAvailableBlocks();
            statMountParse.totalBlocks = (long) statFs.getBlockCount();
            statMountParse.freeBlocks = (long) statFs.getFreeBlocks();
            AppMethodBeat.o(157814);
        } catch (IllegalArgumentException e2) {
            Log.e(TAG, "statFsForStatMountParse", e2);
            AppMethodBeat.o(157814);
        }
    }

    private static boolean testPermissionForStatMountParse(StatMountParse statMountParse) {
        boolean z;
        AppMethodBeat.i(157815);
        o oVar = new o(statMountParse.mountDir, "test_writable");
        OutputStream outputStream = null;
        try {
            oVar.createNewFile();
            outputStream = s.ap(oVar);
            outputStream.write(APMidasPayAPI.ENV_TEST.getBytes());
            outputStream.flush();
            outputStream.close();
            z = oVar.delete();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                }
            }
        } catch (IOException e3) {
            Log.e(TAG, "createNewFile: " + e3.getMessage() + " dir: " + statMountParse.mountDir);
            if (outputStream != null) {
                try {
                    outputStream.close();
                    z = false;
                } catch (IOException e4) {
                    Log.printErrStackTrace(TAG, e4, "", new Object[0]);
                    z = false;
                }
            } else {
                z = false;
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                    Log.printErrStackTrace(TAG, e5, "", new Object[0]);
                }
            }
            AppMethodBeat.o(157815);
            throw th;
        }
        statMountParse.canWrite = z;
        AppMethodBeat.o(157815);
        return z;
    }

    public static StatMountParse getDataDirectoryStatMountParse() {
        StatMountParse statMountParse;
        AppMethodBeat.i(157816);
        ArrayList<StatMountParse> parseProcMounts = parseProcMounts();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        Iterator<StatMountParse> it = parseProcMounts.iterator();
        while (true) {
            if (!it.hasNext()) {
                statMountParse = null;
                break;
            }
            statMountParse = it.next();
            if (statMountParse.mountDir.equals(absolutePath)) {
                break;
            }
        }
        if (statMountParse == null) {
            statMountParse = new StatMountParse();
            statMountParse.mountDir = absolutePath;
            statMountParse.devName = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            statMountParse.fileSystem = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        statFsForStatMountParse(statMountParse);
        AppMethodBeat.o(157816);
        return statMountParse;
    }

    private static StatMountParse getSdcardDirectoryStatMountParse() {
        StatMountParse statMountParse;
        AppMethodBeat.i(157817);
        ArrayList<StatMountParse> parseProcMounts = parseProcMounts();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator<StatMountParse> it = parseProcMounts.iterator();
        while (true) {
            if (!it.hasNext()) {
                statMountParse = null;
                break;
            }
            statMountParse = it.next();
            if (statMountParse.mountDir.equals(absolutePath)) {
                break;
            }
        }
        if (statMountParse == null) {
            statMountParse = new StatMountParse();
            statMountParse.mountDir = absolutePath;
            statMountParse.devName = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            statMountParse.fileSystem = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        statFsForStatMountParse(statMountParse);
        AppMethodBeat.o(157817);
        return statMountParse;
    }

    private static void filterStatMountParseForStorage(ArrayList<StatMountParse> arrayList, boolean z) {
        boolean z2;
        AppMethodBeat.i(230390);
        int size = arrayList.size();
        List asList = Arrays.asList(includeStorageFileSystems);
        List<String> asList2 = Arrays.asList(excludeStorageMountDirs);
        List<String> asList3 = Arrays.asList(includeDeviceNames);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            StatMountParse statMountParse = arrayList.get(i2);
            if (!asList.contains(statMountParse.fileSystem)) {
                arrayList.remove(i2);
                Log.d(TAG, "Remove with filesystem mismatch: " + statMountParse.fileSystem);
            } else {
                boolean z3 = false;
                for (String str : asList2) {
                    z3 = statMountParse.mountDir.startsWith(str) | z3;
                }
                if (z3) {
                    arrayList.remove(i2);
                    Log.d(TAG, "Remove with bad mount dir1: " + statMountParse.mountDir);
                } else if (statMountParse.fileSystem.equals("fuse") || statMountParse.fileSystem.equals("sdcardfs")) {
                    if (statMountParse.devName.startsWith("/data/")) {
                        arrayList.remove(i2);
                        Log.d(TAG, "Remove with bad mount dir2: " + statMountParse.devName);
                    }
                } else if (!statMountParse.fileSystem.equals("fuse") && !statMountParse.fileSystem.equals("sdcardfs")) {
                    boolean z4 = false;
                    for (String str2 : asList3) {
                        z4 = statMountParse.devName.startsWith(str2) | z4;
                    }
                    if (!z4) {
                        arrayList.remove(i2);
                        Log.d(TAG, "Remove with bad device name: " + statMountParse.devName);
                    }
                }
            }
        }
        String path = Environment.getExternalStorageDirectory().getPath();
        int size2 = arrayList.size() - 1;
        while (true) {
            if (size2 < 0) {
                z2 = false;
                break;
            }
            StatMountParse statMountParse2 = arrayList.get(size2);
            if (statMountParse2.mountDir.equals(path)) {
                arrayList.remove(size2);
                arrayList.add(0, statMountParse2);
                z2 = true;
                break;
            }
            size2--;
        }
        if (!z2) {
            StatMountParse statMountParse3 = new StatMountParse();
            statMountParse3.mountDir = path;
            statMountParse3.fileSystem = "unknown";
            statMountParse3.devName = "unknown";
            arrayList.add(0, statMountParse3);
        }
        for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
            StatMountParse statMountParse4 = arrayList.get(size3);
            o oVar = new o(statMountParse4.mountDir);
            if (!oVar.exists() || !oVar.isDirectory()) {
                Log.d(TAG, "Directory verify failed: ".concat(String.valueOf(statMountParse4)));
                arrayList.remove(size3);
            }
        }
        if (z) {
            for (int size4 = arrayList.size() - 1; size4 >= 0; size4--) {
                StatMountParse statMountParse5 = arrayList.get(size4);
                if (!testPermissionForStatMountParse(statMountParse5)) {
                    Log.d(TAG, "Directory testPermissionForStatMountParse failed: ".concat(String.valueOf(statMountParse5)));
                    arrayList.remove(size4);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        while (!arrayList.isEmpty()) {
            int size5 = arrayList.size() - 1;
            StatMountParse remove = arrayList.remove(0);
            while (size5 >= 0) {
                StatMountParse statMountParse6 = arrayList.get(size5);
                if (remove.devName.equals(statMountParse6.devName)) {
                    arrayList.remove(size5);
                    Log.d(TAG, "Duplicate with same DevName:" + remove.devName);
                    if (!remove.canWrite && statMountParse6.canWrite) {
                        Log.d(TAG, "Keep the writable one, discard the unwritable one");
                        size5--;
                        remove = statMountParse6;
                    }
                }
                statMountParse6 = remove;
                size5--;
                remove = statMountParse6;
            }
            arrayList2.add(remove);
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            statFsForStatMountParse((StatMountParse) it.next());
        }
        arrayList.clear();
        while (!arrayList2.isEmpty()) {
            StatMountParse statMountParse7 = (StatMountParse) arrayList2.remove(0);
            arrayList.add(statMountParse7);
            for (int size6 = arrayList2.size() - 1; size6 >= 0; size6--) {
                StatMountParse statMountParse8 = (StatMountParse) arrayList2.get(size6);
                if (statMountParse7.equals(statMountParse8)) {
                    Log.d(TAG, "Duplicate:" + statMountParse7.toString() + "---" + statMountParse8.toString());
                    arrayList2.remove(size6);
                }
            }
        }
        AppMethodBeat.o(230390);
    }

    private static void postProcess(StatMountParse statMountParse, ArrayList<StatMountParse> arrayList) {
        AppMethodBeat.i(230391);
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            StatMountParse statMountParse2 = arrayList.get(size);
            if (statMountParse2.equals(statMountParse)) {
                statMountParse.sharedStatMountParse = statMountParse2;
                arrayList.remove(size);
            }
        }
        AppMethodBeat.o(230391);
    }

    public static ArrayList<StatMountParse> getWritableStatMountParseForStorage() {
        AppMethodBeat.i(157818);
        ArrayList<StatMountParse> parseProcMounts = parseProcMounts();
        filterStatMountParseForStorage(parseProcMounts, true);
        AppMethodBeat.o(157818);
        return parseProcMounts;
    }

    public static StatMountParse getDataStatMountParse() {
        AppMethodBeat.i(230392);
        StatMountParse dataDirectoryStatMountParse = getDataDirectoryStatMountParse();
        postProcess(dataDirectoryStatMountParse, getWritableStatMountParseForStorage());
        AppMethodBeat.o(230392);
        return dataDirectoryStatMountParse;
    }

    public static ArrayList<StatMountParse> getStoragesStatMountParse() {
        AppMethodBeat.i(230393);
        StatMountParse dataDirectoryStatMountParse = getDataDirectoryStatMountParse();
        ArrayList<StatMountParse> writableStatMountParseForStorage = getWritableStatMountParseForStorage();
        postProcess(dataDirectoryStatMountParse, writableStatMountParseForStorage);
        AppMethodBeat.o(230393);
        return writableStatMountParseForStorage;
    }

    public static ArrayList<String> getStorageDirectories() {
        AppMethodBeat.i(230394);
        ArrayList<StatMountParse> parseProcMounts = parseProcMounts();
        filterStatMountParseForStorage(parseProcMounts, false);
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<StatMountParse> it = parseProcMounts.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().mountDir);
        }
        AppMethodBeat.o(230394);
        return arrayList;
    }

    public static ArrayList<String> getWritableStorageDirectories() {
        AppMethodBeat.i(230395);
        ArrayList<StatMountParse> writableStatMountParseForStorage = getWritableStatMountParseForStorage();
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<StatMountParse> it = writableStatMountParseForStorage.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().mountDir);
        }
        AppMethodBeat.o(230395);
        return arrayList;
    }

    public static long getTotalInternalMemorySize() {
        AppMethodBeat.i(230396);
        StatMountParse dataDirectoryStatMountParse = getDataDirectoryStatMountParse();
        long j2 = dataDirectoryStatMountParse.blockSize * dataDirectoryStatMountParse.totalBlocks;
        AppMethodBeat.o(230396);
        return j2;
    }

    public static long getAvailableInternalMemorySize() {
        AppMethodBeat.i(157819);
        StatMountParse dataDirectoryStatMountParse = getDataDirectoryStatMountParse();
        long j2 = dataDirectoryStatMountParse.blockSize * dataDirectoryStatMountParse.availableBlocks;
        AppMethodBeat.o(157819);
        return j2;
    }

    public static long getTotalExternalMemorySize() {
        AppMethodBeat.i(230397);
        long j2 = 0;
        Iterator<StatMountParse> it = getStoragesStatMountParse().iterator();
        while (it.hasNext()) {
            StatMountParse next = it.next();
            j2 = (next.blockSize * next.totalBlocks) + j2;
        }
        AppMethodBeat.o(230397);
        return j2;
    }

    public static long getAvailableExternalMemorySize() {
        AppMethodBeat.i(230398);
        long j2 = 0;
        Iterator<StatMountParse> it = getStoragesStatMountParse().iterator();
        while (it.hasNext()) {
            StatMountParse next = it.next();
            j2 = (next.blockSize * next.availableBlocks) + j2;
        }
        AppMethodBeat.o(230398);
        return j2;
    }

    public static long getAvailableExternalMemorySize2() {
        AppMethodBeat.i(157820);
        StatMountParse sdcardDirectoryStatMountParse = getSdcardDirectoryStatMountParse();
        long j2 = sdcardDirectoryStatMountParse.blockSize * sdcardDirectoryStatMountParse.availableBlocks;
        AppMethodBeat.o(157820);
        return j2;
    }

    public static boolean hasUnRemovableStorage() {
        StatMountParse statMountParse;
        boolean z;
        AppMethodBeat.i(157821);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<StatMountParse> parseProcMounts = parseProcMounts();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        String absolutePath2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        StatMountParse statMountParse2 = null;
        Iterator<StatMountParse> it = parseProcMounts.iterator();
        StatMountParse statMountParse3 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StatMountParse next = it.next();
            if (statMountParse3 == null && next.mountDir.equals(absolutePath)) {
                if (statMountParse2 != null) {
                    statMountParse3 = next;
                    break;
                }
                statMountParse3 = next;
            } else {
                if (statMountParse2 == null && next.mountDir.equals(absolutePath2)) {
                    if (statMountParse3 != null) {
                        statMountParse2 = next;
                        break;
                    }
                } else {
                    next = statMountParse2;
                }
                statMountParse2 = next;
            }
        }
        if (statMountParse3 != null && statMountParse2 == null && !Util.isNullOrNil(absolutePath2) && absolutePath2.contains(ID_EMULATED_INTERNAL)) {
            String substring = absolutePath2.substring(absolutePath2.lastIndexOf(47) + 1);
            int i2 = Util.getInt(substring, -1);
            Log.i(TAG, "hasUnRemovableStorage multiuser uid[%s][%d]", substring, Integer.valueOf(i2));
            if (i2 != -1) {
                String substring2 = absolutePath2.substring(0, (absolutePath2.length() - substring.length()) - 1);
                if (!Util.isNullOrNil(substring2)) {
                    Iterator<StatMountParse> it2 = parseProcMounts.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        statMountParse = it2.next();
                        if (statMountParse.mountDir.equals(substring2)) {
                            break;
                        }
                    }
                }
            }
        }
        statMountParse = statMountParse2;
        if (!(statMountParse3 == null || statMountParse == null)) {
            statFsForStatMountParse(statMountParse3);
            statFsForStatMountParse(statMountParse);
            Log.d(TAG, "hasUnRemovableStorage stats dataStatMountParse[%s] storageStatMountParse[%s]", statMountParse3, statMountParse);
            if ((statMountParse.fileSystem.equals("fuse") || statMountParse.fileSystem.equals("sdcardfs") || statMountParse.fileSystem.equals("esdfs")) && statMountParse3.totalBlocks >= statMountParse.totalBlocks && statMountParse.totalBlocks > 0 && statMountParse3.blockSize >= statMountParse.blockSize && statMountParse.blockSize > 0 && statMountParse3.availableBlocks >= statMountParse.availableBlocks) {
                z = true;
                Log.i(TAG, "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(157821);
                return z;
            }
        }
        z = false;
        Log.i(TAG, "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(157821);
        return z;
    }

    public static String getFileSystem(String str) {
        AppMethodBeat.i(157822);
        String str2 = "";
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(157822);
        } else {
            ArrayList<StatMountParse> parseProcMounts = parseProcMounts();
            if (parseProcMounts != null) {
                Iterator<StatMountParse> it = parseProcMounts.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    StatMountParse next = it.next();
                    if (str.equals(next.mountDir)) {
                        str2 = next.fileSystem;
                        break;
                    }
                }
            }
            Log.i(TAG, "getFileSystem[%s] is [%s]", str, str2);
            if (Util.isNullOrNil(str2) && str.contains(ID_EMULATED_INTERNAL)) {
                String substring = str.substring(str.lastIndexOf(47) + 1);
                int i2 = Util.getInt(substring, -1);
                Log.i(TAG, "getFileSystem multiuser uid[%s][%d]", substring, Integer.valueOf(i2));
                if (i2 != -1) {
                    String substring2 = str.substring(0, (str.length() - substring.length()) - 1);
                    if (!Util.isNullOrNil(substring2)) {
                        Iterator<StatMountParse> it2 = parseProcMounts.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            StatMountParse next2 = it2.next();
                            if (substring2.equals(next2.mountDir)) {
                                str2 = next2.fileSystem;
                                Log.i(TAG, "getFileSystem[%s] fix[%s] is [%s]", str, substring2, str2);
                                break;
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(157822);
        }
        return str2;
    }

    public static class StatMountParse {
        private static final int DIFF_THRESHOLD = 4;
        public long availableBlocks;
        public long blockSize;
        public boolean canWrite;
        public String devName;
        public String fileSystem;
        public long freeBlocks;
        public String mountDir;
        StatMountParse sharedStatMountParse;
        public long totalBlocks;

        public String toString() {
            AppMethodBeat.i(157811);
            String str = "{DevName=" + this.devName + ", MountDir=" + this.mountDir + ", FileSystem=" + this.fileSystem + ", TotalBlocks=" + this.totalBlocks + ", FreeBlocks=" + this.freeBlocks + ", AvailableBlocks=" + this.availableBlocks + ", BlockSize=" + this.blockSize + ", Shared=" + (this.sharedStatMountParse != null) + "}";
            AppMethodBeat.o(157811);
            return str;
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(157812);
            StatMountParse statMountParse = (StatMountParse) obj;
            if (this.blockSize != statMountParse.blockSize) {
                AppMethodBeat.o(157812);
                return false;
            }
            long j2 = this.totalBlocks - statMountParse.totalBlocks;
            long j3 = this.freeBlocks - statMountParse.freeBlocks;
            long j4 = this.availableBlocks - statMountParse.availableBlocks;
            if (Math.abs(j2 - j3) > 4 || Math.abs(j2 - j4) > 4 || Math.abs(j3 - j4) > 4) {
                AppMethodBeat.o(157812);
                return false;
            }
            AppMethodBeat.o(157812);
            return true;
        }
    }
}
