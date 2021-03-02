package com.facebook.device.yearclass;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;

public class DeviceInfo {
    private static final FileFilter CPU_FILTER = new FileFilter() {
        /* class com.facebook.device.yearclass.DeviceInfo.AnonymousClass1 */

        public final boolean accept(File file) {
            AppMethodBeat.i(133638);
            String name = file.getName();
            if (name.startsWith("cpu")) {
                for (int i2 = 3; i2 < name.length(); i2++) {
                    if (!Character.isDigit(name.charAt(i2))) {
                        AppMethodBeat.o(133638);
                        return false;
                    }
                }
                AppMethodBeat.o(133638);
                return true;
            }
            AppMethodBeat.o(133638);
            return false;
        }
    };
    public static final int DEVICEINFO_UNKNOWN = -1;

    public static int getNumberOfCPUCores() {
        int i2;
        AppMethodBeat.i(133639);
        if (Build.VERSION.SDK_INT <= 10) {
            AppMethodBeat.o(133639);
            return 1;
        }
        try {
            i2 = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
            if (i2 == -1) {
                i2 = getCoresFromFileInfo("/sys/devices/system/cpu/present");
            }
            if (i2 == -1) {
                i2 = getCoresFromCPUFileList();
            }
        } catch (SecurityException e2) {
            i2 = -1;
        } catch (NullPointerException e3) {
            i2 = -1;
        }
        AppMethodBeat.o(133639);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c A[SYNTHETIC, Splitter:B:11:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039 A[SYNTHETIC, Splitter:B:17:0x0039] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getCoresFromFileInfo(java.lang.String r5) {
        /*
            r4 = 133640(0x20a08, float:1.8727E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            r0 = 0
            java.io.InputStream r1 = com.tencent.mm.vfs.s.openRead(r5)     // Catch:{ IOException -> 0x0029, all -> 0x0034 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
            java.lang.String r2 = r0.readLine()     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
            r0.close()     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
            int r0 = getCoresFromFileString(r2)     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
            if (r1 == 0) goto L_0x0025
            r1.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0025:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0028:
            return r0
        L_0x0029:
            r1 = move-exception
        L_0x002a:
            if (r0 == 0) goto L_0x002f
            r0.close()     // Catch:{ IOException -> 0x0042 }
        L_0x002f:
            r0 = -1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0028
        L_0x0034:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L_0x0037:
            if (r3 == 0) goto L_0x003c
            r3.close()     // Catch:{ IOException -> 0x0044 }
        L_0x003c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r2
        L_0x0040:
            r1 = move-exception
            goto L_0x0025
        L_0x0042:
            r0 = move-exception
            goto L_0x002f
        L_0x0044:
            r0 = move-exception
            goto L_0x003c
        L_0x0046:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L_0x0037
        L_0x004a:
            r0 = move-exception
            r0 = r1
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.yearclass.DeviceInfo.getCoresFromFileInfo(java.lang.String):int");
    }

    static int getCoresFromFileString(String str) {
        AppMethodBeat.i(133641);
        if (str == null || !str.matches("0-[\\d]+$")) {
            AppMethodBeat.o(133641);
            return -1;
        }
        int i2 = Util.getInt(str.substring(2), 0) + 1;
        AppMethodBeat.o(133641);
        return i2;
    }

    private static int getCoresFromCPUFileList() {
        AppMethodBeat.i(133642);
        int length = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        AppMethodBeat.o(133642);
        return length;
    }

    static {
        AppMethodBeat.i(133647);
        AppMethodBeat.o(133647);
    }

    public static int getCPUMaxFreqKHz() {
        AppMethodBeat.i(133643);
        int i2 = -1;
        for (int i3 = 0; i3 < getNumberOfCPUCores(); i3++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    InputStream openRead = s.openRead(file.getPath());
                    try {
                        openRead.read(bArr);
                        int i4 = 0;
                        while (Character.isDigit(bArr[i4]) && i4 < 128) {
                            i4++;
                        }
                        Integer valueOf = Integer.valueOf(Util.safeParseInt(new String(bArr, 0, i4)));
                        if (valueOf.intValue() > i2) {
                            i2 = valueOf.intValue();
                        }
                        openRead.close();
                    } catch (NumberFormatException e2) {
                        openRead.close();
                    } catch (Throwable th) {
                        openRead.close();
                        AppMethodBeat.o(133643);
                        throw th;
                    }
                }
            } catch (IOException e3) {
                i2 = -1;
            }
        }
        if (i2 == -1) {
            InputStream openRead2 = s.openRead("/proc/cpuinfo");
            try {
                int parseFileForValue = parseFileForValue("cpu MHz", openRead2) * 1000;
                if (parseFileForValue > i2) {
                    i2 = parseFileForValue;
                }
                openRead2.close();
            } catch (Throwable th2) {
                openRead2.close();
                AppMethodBeat.o(133643);
                throw th2;
            }
        }
        AppMethodBeat.o(133643);
        return i2;
    }

    @TargetApi(16)
    public static long getTotalMemory(Context context) {
        long j2;
        AppMethodBeat.i(133644);
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getMemoryInfo(memoryInfo);
            long j3 = memoryInfo.totalMem;
            AppMethodBeat.o(133644);
            return j3;
        }
        try {
            InputStream openRead = s.openRead("/proc/meminfo");
            try {
                j2 = ((long) parseFileForValue("MemTotal", openRead)) * 1024;
                try {
                    openRead.close();
                } catch (IOException e2) {
                }
            } catch (Throwable th) {
                openRead.close();
                AppMethodBeat.o(133644);
                throw th;
            }
        } catch (IOException e3) {
            j2 = -1;
        }
        AppMethodBeat.o(133644);
        return j2;
    }

    private static int parseFileForValue(String str, InputStream inputStream) {
        AppMethodBeat.i(177010);
        byte[] bArr = new byte[1024];
        try {
            int read = inputStream.read(bArr);
            int i2 = 0;
            while (i2 < read) {
                if (bArr[i2] == 10 || i2 == 0) {
                    if (bArr[i2] == 10) {
                        i2++;
                    }
                    for (int i3 = i2; i3 < read; i3++) {
                        int i4 = i3 - i2;
                        if (bArr[i3] != str.charAt(i4)) {
                            continue;
                            break;
                        } else if (i4 == str.length() - 1) {
                            int extractValue = extractValue(bArr, i3);
                            AppMethodBeat.o(177010);
                            return extractValue;
                        }
                    }
                    continue;
                }
                i2++;
            }
        } catch (IOException | NumberFormatException e2) {
        }
        AppMethodBeat.o(177010);
        return -1;
    }

    private static int extractValue(byte[] bArr, int i2) {
        AppMethodBeat.i(133646);
        while (i2 < bArr.length && bArr[i2] != 10) {
            if (Character.isDigit(bArr[i2])) {
                int i3 = i2 + 1;
                while (i3 < bArr.length && Character.isDigit(bArr[i3])) {
                    i3++;
                }
                int safeParseInt = Util.safeParseInt(new String(bArr, 0, i2, i3 - i2));
                AppMethodBeat.o(133646);
                return safeParseInt;
            }
            i2++;
        }
        AppMethodBeat.o(133646);
        return -1;
    }
}
