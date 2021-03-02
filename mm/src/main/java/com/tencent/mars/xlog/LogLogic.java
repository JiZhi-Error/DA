package com.tencent.mars.xlog;

import android.os.Debug;
import android.os.Process;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.InputStream;

public class LogLogic {
    public static native int getAppenderModeFromCfg();

    public static native int getIPxxLogLevel();

    public static native int getLogLevelFromCfg();

    public static native void initIPxxLogInfo();

    public static native void setIPxxLogML(int i2, int i3);

    public static String appendMemLog(String str) {
        return str;
    }

    public static long getDalvikHeap() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / 1024;
    }

    public static long getNativeHeap() {
        return Debug.getNativeHeapAllocatedSize() / 1024;
    }

    public static String getVmSize() {
        try {
            String[] split = getStringFromFile(String.format("/proc/%s/status", Integer.valueOf(Process.myPid()))).trim().split("\n");
            for (String str : split) {
                if (str.startsWith("VmSize")) {
                    return str;
                }
            }
            return split[12];
        } catch (Exception e2) {
            return "";
        }
    }

    public static String getVmStatus() {
        String format = String.format("/proc/%s/status", Integer.valueOf(Process.myPid()));
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(getStringFromFile(format).trim());
            return sb.toString();
        } catch (Exception e2) {
            return sb.toString();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String convertStreamToString(java.io.InputStream r4) {
        /*
            r2 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x002f }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x002f }
            r3.<init>(r4)     // Catch:{ all -> 0x002f }
            r1.<init>(r3)     // Catch:{ all -> 0x002f }
        L_0x0010:
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x0027
            java.lang.StringBuilder r2 = r0.append(r2)     // Catch:{ all -> 0x0020 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0020:
            r0 = move-exception
        L_0x0021:
            if (r1 == 0) goto L_0x0026
            r1.close()
        L_0x0026:
            throw r0
        L_0x0027:
            r1.close()
            java.lang.String r0 = r0.toString()
            return r0
        L_0x002f:
            r0 = move-exception
            r1 = r2
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mars.xlog.LogLogic.convertStreamToString(java.io.InputStream):java.lang.String");
    }

    public static String getStringFromFile(String str) {
        InputStream inputStream = null;
        try {
            inputStream = s.ao(new o(str));
            return convertStreamToString(inputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
