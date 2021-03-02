package com.tencent.mm.f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import dalvik.system.PathClassLoader;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class a {
    private static boolean dBE = false;
    private static String dBF;
    private static String dBG;
    private static String dBH;
    private static Set<C0344a> dBI;
    public static final boolean zF = o(System.getProperty("java.vm.version"));

    static /* synthetic */ Method d(Object obj, String str, Class[] clsArr) {
        AppMethodBeat.i(260049);
        Method findMethod = findMethod(obj, str, clsArr);
        AppMethodBeat.o(260049);
        return findMethod;
    }

    static {
        AppMethodBeat.i(125053);
        AppMethodBeat.o(125053);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.f.a$a  reason: collision with other inner class name */
    public static class C0344a {
        String dBJ;
        String dBK;
        String dBL;

        public C0344a(String str, String str2, String str3) {
            this.dBJ = str;
            this.dBK = str2;
            this.dBL = str3;
        }
    }

    private a() {
    }

    public static void bT(Context context) {
        long j2;
        long j3;
        AppMethodBeat.i(125039);
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j2 = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            try {
                j3 = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            } catch (Exception e2) {
                Log.e("MicroMsg.MultiDex", "get db spare space error");
                j3 = 0;
                Log.i("MicroMsg.MultiDex", "ifRomSpaceEnough available:%d all:%d", Long.valueOf(j2), Long.valueOf(j3));
                String processNameByPid = Util.getProcessNameByPid(context, Process.myPid());
                Log.i("MicroMsg.MultiDex", "space not enough process:%s, available:%d, RESTRICTION_SPACE_SIZE: %d", processNameByPid, Long.valueOf(j2), 31457280L);
                Intent intent = new Intent();
                intent.setClassName(context, "com.tencent.mm.ui.NoRomSpaceDexUI");
                intent.setFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/autodex/MultiDex", "checkRomSpaceEnough", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/autodex/MultiDex", "checkRomSpaceEnough", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.b.a a2 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/autodex/MultiDex", "checkRomSpaceEnough", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                Process.killProcess(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/autodex/MultiDex", "checkRomSpaceEnough", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                AppMethodBeat.o(125039);
            }
        } catch (Exception e3) {
            j2 = 0;
            Log.e("MicroMsg.MultiDex", "get db spare space error");
            j3 = 0;
            Log.i("MicroMsg.MultiDex", "ifRomSpaceEnough available:%d all:%d", Long.valueOf(j2), Long.valueOf(j3));
            String processNameByPid2 = Util.getProcessNameByPid(context, Process.myPid());
            Log.i("MicroMsg.MultiDex", "space not enough process:%s, available:%d, RESTRICTION_SPACE_SIZE: %d", processNameByPid2, Long.valueOf(j2), 31457280L);
            Intent intent2 = new Intent();
            intent2.setClassName(context, "com.tencent.mm.ui.NoRomSpaceDexUI");
            intent2.setFlags(268435456);
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/autodex/MultiDex", "checkRomSpaceEnough", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/autodex/MultiDex", "checkRomSpaceEnough", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.b.a a22 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
            Object obj2 = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(obj2, a22.axQ(), "com/tencent/mm/autodex/MultiDex", "checkRomSpaceEnough", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            Process.killProcess(((Integer) a22.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(obj2, "com/tencent/mm/autodex/MultiDex", "checkRomSpaceEnough", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            AppMethodBeat.o(125039);
        }
        Log.i("MicroMsg.MultiDex", "ifRomSpaceEnough available:%d all:%d", Long.valueOf(j2), Long.valueOf(j3));
        if (j3 != 0 && j2 < 31457280) {
            String processNameByPid22 = Util.getProcessNameByPid(context, Process.myPid());
            Log.i("MicroMsg.MultiDex", "space not enough process:%s, available:%d, RESTRICTION_SPACE_SIZE: %d", processNameByPid22, Long.valueOf(j2), 31457280L);
            if (!processNameByPid22.equals("") && !processNameByPid22.endsWith(":nospace")) {
                Intent intent22 = new Intent();
                intent22.setClassName(context, "com.tencent.mm.ui.NoRomSpaceDexUI");
                intent22.setFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl22 = new com.tencent.mm.hellhoundlib.b.a().bl(intent22);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl22.axQ(), "com/tencent/mm/autodex/MultiDex", "checkRomSpaceEnough", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl22.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/autodex/MultiDex", "checkRomSpaceEnough", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.b.a a222 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                Object obj22 = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj22, a222.axQ(), "com/tencent/mm/autodex/MultiDex", "checkRomSpaceEnough", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                Process.killProcess(((Integer) a222.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(obj22, "com/tencent/mm/autodex/MultiDex", "checkRomSpaceEnough", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            }
        }
        AppMethodBeat.o(125039);
    }

    public static boolean bS(Context context) {
        AppMethodBeat.i(125040);
        if (zF) {
            Log.i("MultiDex", "if need dexopt: VM has multidex support, MultiDex support library is disabled.");
            AppMethodBeat.o(125040);
            return false;
        } else if (dBE) {
            Log.i("MultiDex", "if need dexopt: has inited.");
            AppMethodBeat.o(125040);
            return false;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            cd(context);
            if (dBI == null || dBI.size() <= 0) {
                AppMethodBeat.o(125040);
                return true;
            }
            dBF = context.getDir("cache", 0).getAbsolutePath();
            dBG = context.getDir(ShareConstants.DEX_PATH, 0).getAbsolutePath();
            dBH = context.getDir("cache", 0).getParentFile().getAbsolutePath() + "/dex.lock";
            File file = new File(dBG);
            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                Log.f("MicroMsg.MultiDex", "if need dexopt: extractZipEntryToFile: create target dex directory failed");
                AppMethodBeat.o(125040);
                return true;
            }
            int size = dBI.size();
            File file2 = new File(dBF);
            if ((!file2.exists() || !file2.isDirectory()) && !file2.mkdirs()) {
                Log.f("MicroMsg.MultiDex", "if need dexopt: extractZipEntryToFile: create target dexopt directory failed");
                AppMethodBeat.o(125040);
                return true;
            }
            Log.i("MicroMsg.MultiDex", "if need dexopt: install Build.VERSION: %d, tryLoadDexFileCount: %d, installDir: %d, optDir: %d", Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(size), Integer.valueOf(file.list().length), Integer.valueOf(file2.list().length));
            if (file.list() == null || file.list().length < size || file2.list() == null || file2.list().length < size) {
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(file.list() == null ? -1 : file.list().length);
                objArr[1] = Integer.valueOf(size);
                objArr[2] = Integer.valueOf(file2.list() == null ? -1 : file2.list().length);
                objArr[3] = Integer.valueOf(size);
                Log.i("MicroMsg.MultiDex", "if need dexopt: dex file count not equal, install path: %s vs %s, opt path: %s vs %s", objArr);
                AppMethodBeat.o(125040);
                return true;
            } else if (context.getApplicationInfo() == null) {
                AppMethodBeat.o(125040);
                return false;
            } else {
                for (C0344a aVar : dBI) {
                    synchronized (a.class) {
                        try {
                            Log.i("MicroMsg.MultiDex", "if need dexopt: prepare dex to load, file: %s, md5: %s, loadClass: %s", aVar.dBJ, aVar.dBK, aVar.dBL);
                        } catch (Throwable th) {
                            AppMethodBeat.o(125040);
                            throw th;
                        }
                    }
                    if (a(aVar)) {
                        Log.i("MicroMsg.MultiDex", "if need dexopt: verify dex for check md5: targetFilePath: [%s] time: %d", aVar.dBJ, Long.valueOf(Util.milliSecondsToNow(currentTimeMillis)));
                    } else {
                        Log.e("MicroMsg.MultiDex", "if need dexopt: targetDexFile md5 mismatch or not exists: %s", aVar.dBJ);
                        AppMethodBeat.o(125040);
                        return true;
                    }
                }
                AppMethodBeat.o(125040);
                return false;
            }
        }
    }

    public static synchronized boolean cc(Context context) {
        boolean z;
        synchronized (a.class) {
            AppMethodBeat.i(125041);
            Log.i("MicroMsg.MultiDex", "install multidex hasinit: %b, force: %b", Boolean.valueOf(dBE), Boolean.TRUE);
            if (zF) {
                Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
                z = true;
                AppMethodBeat.o(125041);
            } else if (dBE) {
                z = true;
                AppMethodBeat.o(125041);
            } else {
                if (context.getClassLoader() != null) {
                    Log.i("MicroMsg.MultiDex", "classloader: " + context.getClassLoader().toString());
                } else {
                    Log.e("MicroMsg.MultiDex", "classloader is null");
                }
                long currentTimeMillis = System.currentTimeMillis();
                cd(context);
                if (dBI == null || dBI.size() <= 0) {
                    z = false;
                    AppMethodBeat.o(125041);
                } else {
                    try {
                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                        if (applicationInfo == null) {
                            z = false;
                            AppMethodBeat.o(125041);
                        } else {
                            dBF = context.getDir("cache", 0).getAbsolutePath();
                            dBG = context.getDir(ShareConstants.DEX_PATH, 0).getAbsolutePath();
                            dBH = context.getDir("cache", 0).getParentFile().getAbsolutePath() + "/dex.lock";
                            File file = new File(dBG);
                            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                                Log.f("MicroMsg.MultiDex", "extractZipEntryToFile: create target dex directory failed");
                                z = false;
                                AppMethodBeat.o(125041);
                            } else {
                                int size = dBI.size();
                                File file2 = new File(dBF);
                                if ((!file2.exists() || !file2.isDirectory()) && !file2.mkdirs()) {
                                    Log.f("MicroMsg.MultiDex", "extractZipEntryToFile: create target dexopt directory failed");
                                    z = false;
                                    AppMethodBeat.o(125041);
                                } else {
                                    Log.i("MicroMsg.MultiDex", "install Build.VERSION: %d, tryLoadDexFileCount: %d, installDir: %d, optDir: %d", Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(size), Integer.valueOf(file.list().length), Integer.valueOf(file2.list().length));
                                    ArrayList arrayList = new ArrayList(dBI.size());
                                    int i2 = 0;
                                    boolean z2 = false;
                                    while (true) {
                                        if (i2 >= 5 || z2) {
                                            break;
                                        }
                                        arrayList.clear();
                                        for (C0344a aVar : dBI) {
                                            Log.i("MicroMsg.MultiDex", "prepare dex to load, file: %s, md5: %s, loadClass: %s", aVar.dBJ, aVar.dBK, aVar.dBL);
                                            if (a(aVar)) {
                                                Log.i("MicroMsg.MultiDex", "verify dex for check md5: targetFilePath: [%s] time: %d", aVar.dBJ, Long.valueOf(Util.milliSecondsToNow(currentTimeMillis)));
                                                if (b(context, aVar.dBL, false)) {
                                                    Log.i("MicroMsg.MultiDex", "dex has been loaded, skip. targetFilePath: [%s]", aVar.dBJ);
                                                } else {
                                                    Log.w("MicroMsg.MultiDex", "dex [%s] is not load, it should be reload in further steps.", aVar.dBJ);
                                                }
                                            } else {
                                                Log.e("MicroMsg.MultiDex", "targetDexFile md5 mismatch or not exists: %s, force: %b", aVar.dBJ, Boolean.TRUE);
                                                ZipFile zipFile = new ZipFile(applicationInfo.sourceDir);
                                                boolean a2 = a(zipFile, aVar);
                                                try {
                                                    zipFile.close();
                                                } catch (Exception e2) {
                                                    Log.w("MicroMsg.MultiDex", "base apk file close quietly failed");
                                                }
                                                if (!a2) {
                                                    Exception exc = new Exception("overwriteLocalSecondaryDexFromApk fail");
                                                    AppMethodBeat.o(125041);
                                                    throw exc;
                                                }
                                            }
                                            arrayList.add(new File(dBG + FilePathGenerator.ANDROID_DIR_SEP + aVar.dBJ));
                                        }
                                        if (arrayList.isEmpty()) {
                                            Log.i("MicroMsg.MultiDex", "Nothing needs to be installed.");
                                            z2 = true;
                                            break;
                                        }
                                        b(context, dBF, arrayList);
                                        Iterator<C0344a> it = dBI.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                z2 = true;
                                                break;
                                            }
                                            C0344a next = it.next();
                                            if (!b(context, next.dBL, true)) {
                                                Log.w("MicroMsg.MultiDex", "Failed to load dex [%s] in %d round, retry.", next.dBJ, Integer.valueOf(i2 + 1));
                                                String name = new File(dBG + FilePathGenerator.ANDROID_DIR_SEP + next.dBJ).getName();
                                                if (!name.endsWith(ShareConstants.DEX_SUFFIX)) {
                                                    int lastIndexOf = name.lastIndexOf(".");
                                                    if (lastIndexOf < 0) {
                                                        name = name + ShareConstants.DEX_SUFFIX;
                                                    } else {
                                                        StringBuilder sb = new StringBuilder(lastIndexOf + 4);
                                                        sb.append((CharSequence) name, 0, lastIndexOf);
                                                        sb.append(ShareConstants.DEX_SUFFIX);
                                                        name = sb.toString();
                                                    }
                                                }
                                                File file3 = new File(file2, name);
                                                if (file3.exists()) {
                                                    Log.w("MicroMsg.MultiDex", "Remove perhaps broken odex file: " + file3.getAbsolutePath());
                                                    if (!file3.delete()) {
                                                        Log.w("MicroMsg.MultiDex", "Failed to remove perhaps broken odex file: " + file3.getAbsolutePath());
                                                    }
                                                }
                                                z2 = false;
                                            }
                                        }
                                        i2++;
                                    }
                                    if (!z2) {
                                        RuntimeException runtimeException = new RuntimeException("Some dex is not installed successfully after 5 times retry !!");
                                        AppMethodBeat.o(125041);
                                        throw runtimeException;
                                    }
                                    dBE = true;
                                    Log.i("MicroMsg.MultiDex", "install done");
                                    z = true;
                                    AppMethodBeat.o(125041);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        Log.e("MicroMsg.MultiDex", "Multidex installation failure", th);
                        Log.printErrStackTrace("MicroMsg.MultiDex", th, "Multidex installation failure", new Object[0]);
                        bT(context);
                        RuntimeException runtimeException2 = new RuntimeException("Multi dex installation failed (" + th.getMessage() + ").", th);
                        AppMethodBeat.o(125041);
                        throw runtimeException2;
                    }
                }
            }
        }
        return z;
    }

    private static boolean b(Context context, String str, boolean z) {
        AppMethodBeat.i(125042);
        try {
            if (Class.forName(str, false, context.getClassLoader()) != null) {
                AppMethodBeat.o(125042);
                return true;
            }
        } catch (ClassNotFoundException e2) {
            if (z) {
                Log.printErrStackTrace("MicroMsg.MultiDex", e2, "Failed to load a dex.", new Object[0]);
            }
        }
        if (z) {
            Log.w("MicroMsg.MultiDex", "checkDexLoaded fail.... ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(125042);
        return false;
    }

    private static boolean a(ZipFile zipFile, C0344a aVar) {
        AppMethodBeat.i(125043);
        Log.i("MicroMsg.MultiDex", "enter overwriteLocalSecondaryDexFromApk, please keep concerned at which process calls it.");
        File file = new File(dBH);
        String str = dBG + FilePathGenerator.ANDROID_DIR_SEP + aVar.dBJ;
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            shareFileLockHelper = ShareFileLockHelper.getFileLock(file);
            Log.i("MicroMsg.MultiDex", "extract dex waiting for write lock cost %dms on file: %s", Long.valueOf(Util.milliSecondsToNow(currentTimeMillis)), dBH);
            InputStream inputStream = zipFile.getInputStream(zipFile.getEntry(aVar.dBJ));
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                try {
                    byte[] bArr = new byte[16384];
                    for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.close();
                    closeQuietly(inputStream);
                    Log.i("MicroMsg.MultiDex", "extract dex from apk done: %s", dBH);
                    if (shareFileLockHelper != null) {
                        try {
                            shareFileLockHelper.close();
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.MultiDex", e2, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(125043);
                    return true;
                } catch (Throwable th) {
                    bufferedOutputStream.close();
                    AppMethodBeat.o(125043);
                    throw th;
                }
            } catch (Throwable th2) {
                closeQuietly(inputStream);
                AppMethodBeat.o(125043);
                throw th2;
            }
        } catch (IOException e3) {
            Log.printErrStackTrace("MicroMsg.MultiDex", e3, "", new Object[0]);
            Log.e("MicroMsg.MultiDex", "overwrite local secondary dex failed, cannot lock file: %s", file.getAbsolutePath());
            if (shareFileLockHelper != null) {
                try {
                    shareFileLockHelper.close();
                } catch (Exception e4) {
                    Log.printErrStackTrace("MicroMsg.MultiDex", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.o(125043);
            return false;
        } catch (Throwable th3) {
            if (shareFileLockHelper != null) {
                try {
                    shareFileLockHelper.close();
                } catch (Exception e5) {
                    Log.printErrStackTrace("MicroMsg.MultiDex", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.o(125043);
            throw th3;
        }
    }

    private static boolean o(String str) {
        boolean z = false;
        AppMethodBeat.i(125044);
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException e2) {
                }
            }
        }
        Log.i("MicroMsg.MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        AppMethodBeat.o(125044);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ec A[SYNTHETIC, Splitter:B:36:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010b A[SYNTHETIC, Splitter:B:44:0x010b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.tencent.mm.f.a.C0344a r13) {
        /*
        // Method dump skipped, instructions count: 306
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.f.a.a(com.tencent.mm.f.a$a):boolean");
    }

    private static void b(Context context, String str, List<File> list) {
        AppMethodBeat.i(125046);
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        Log.i("MicroMsg.MultiDex", "before reflectPathClassLoader for debug: ClassLoader ".concat(String.valueOf(pathClassLoader)));
        Collections.sort(list, new Comparator<File>() {
            /* class com.tencent.mm.f.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                AppMethodBeat.i(125037);
                File file3 = file;
                File file4 = file2;
                if (file3 == null || file4 == null) {
                    AppMethodBeat.o(125037);
                    return 0;
                }
                String name = file3.getName();
                String name2 = file4.getName();
                if (!name.contains("classes") || !name2.contains("classes")) {
                    AppMethodBeat.o(125037);
                    return 0;
                }
                int charAt = name.charAt(7) - name2.charAt(7);
                AppMethodBeat.o(125037);
                return charAt;
            }
        });
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            Log.i("MicroMsg.MultiDex", "real reflectPathClassLoader dexname: " + it.next().getName());
        }
        File file = new File(str);
        if (!list.isEmpty()) {
            if (Build.VERSION.SDK_INT >= 19) {
                Object obj = findField(pathClassLoader, "pathList").get(pathClassLoader);
                ArrayList arrayList = new ArrayList();
                expandFieldArray(obj, "dexElements", b.makeDexElements(obj, new ArrayList(list), file, arrayList));
                if (arrayList.size() > 0) {
                    Iterator it2 = arrayList.iterator();
                    if (it2.hasNext()) {
                        IOException iOException = (IOException) it2.next();
                        Log.w("MicroMsg.MultiDex", "Exception in makeDexElement", iOException);
                        AppMethodBeat.o(125046);
                        throw iOException;
                    }
                }
            } else {
                Object obj2 = findField(pathClassLoader, "pathList").get(pathClassLoader);
                ArrayList arrayList2 = new ArrayList(list);
                expandFieldArray(obj2, "dexElements", (Object[]) findMethod(obj2, "makeDexElements", ArrayList.class, File.class).invoke(obj2, arrayList2, file));
            }
        }
        Log.i("MicroMsg.MultiDex", "after reflectPathClassloader for debug: ClassLoader ".concat(String.valueOf(pathClassLoader)));
        AppMethodBeat.o(125046);
    }

    private static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(125047);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                Log.w("MicroMsg.MultiDex", "Failed to close resource", e2);
                AppMethodBeat.o(125047);
                return;
            }
        }
        AppMethodBeat.o(125047);
    }

    private static int cd(Context context) {
        HashSet hashSet;
        String[] split;
        AppMethodBeat.i(125048);
        if (dBI != null) {
            Log.w("MicroMsg.MultiDex", "preloaded dex files not empty, skipped preloading");
            AppMethodBeat.o(125048);
            return 1;
        }
        try {
            String convertStreamToString = Util.convertStreamToString(context.getAssets().open("secondary-program-dex-jars/metadata.txt"));
            if (convertStreamToString == null || convertStreamToString.length() <= 0) {
                hashSet = null;
            } else {
                hashSet = new HashSet();
                String[] split2 = convertStreamToString.split("\n");
                for (String str : split2) {
                    if (str != null && str.length() > 0 && (split = str.split(" ", 3)) != null && split.length >= 3) {
                        String trim = split[0].trim();
                        String trim2 = split[1].trim();
                        String trim3 = split[2].trim();
                        Log.i("MicroMsg.MultiDex", "try parse dexname: %s, dexmd5:%s, classname:%s", trim, trim2, trim3);
                        if (trim != null && trim.length() > 0) {
                            hashSet.add(new C0344a(trim, trim2, trim3));
                        }
                    }
                }
            }
            dBI = hashSet;
        } catch (Exception e2) {
            Log.e("MicroMsg.MultiDex", "load preload libraries failed");
            Log.printErrStackTrace("MicroMsg.MultiDex", e2, "", new Object[0]);
        }
        AppMethodBeat.o(125048);
        return 0;
    }

    private static Field findField(Object obj, String str) {
        AppMethodBeat.i(125049);
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                AppMethodBeat.o(125049);
                return declaredField;
            } catch (NoSuchFieldException e2) {
            }
        }
        NoSuchFieldException noSuchFieldException = new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
        AppMethodBeat.o(125049);
        throw noSuchFieldException;
    }

    private static Method findMethod(Object obj, String str, Class<?>... clsArr) {
        AppMethodBeat.i(125050);
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                AppMethodBeat.o(125050);
                return declaredMethod;
            } catch (NoSuchMethodException e2) {
            }
        }
        NoSuchMethodException noSuchMethodException = new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
        AppMethodBeat.o(125050);
        throw noSuchMethodException;
    }

    private static void expandFieldArray(Object obj, String str, Object[] objArr) {
        AppMethodBeat.i(125051);
        Field findField = findField(obj, str);
        Object[] objArr2 = (Object[]) findField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        findField.set(obj, objArr3);
        AppMethodBeat.o(125051);
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            Method d2;
            AppMethodBeat.i(125038);
            try {
                d2 = a.d(obj, "makeDexElements", new Class[]{ArrayList.class, File.class, ArrayList.class});
            } catch (NoSuchMethodException e2) {
                Log.e("MicroMsg.MultiDex", "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure");
                try {
                    d2 = a.d(obj, "makeDexElements", new Class[]{List.class, File.class, List.class});
                } catch (NoSuchMethodException e3) {
                    Log.e("MicroMsg.MultiDex", "NoSuchMethodException: makeDexElements(List,File,List) failure");
                    try {
                        d2 = a.d(obj, "makePathElements", new Class[]{List.class, File.class, List.class});
                    } catch (NoSuchMethodException e4) {
                        Log.e("MicroMsg.MultiDex", "NoSuchMethodException: makePathElements(List,File,List) failure");
                        AppMethodBeat.o(125038);
                        throw e4;
                    }
                }
            }
            Object[] objArr = (Object[]) d2.invoke(obj, arrayList, file, arrayList2);
            AppMethodBeat.o(125038);
            return objArr;
        }
    }
}
