package com.tencent.matrix.g;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public final class a {
    private static final FileFilter CPU_FILTER = new FileFilter() {
        /* class com.tencent.matrix.g.a.AnonymousClass1 */

        public final boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    };
    private static EnumC0223a deJ = null;
    private static long deK = 0;
    private static long deL = 0;
    private static int deM = 0;

    /* renamed from: com.tencent.matrix.g.a$a  reason: collision with other inner class name */
    public enum EnumC0223a {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);
        
        public int value;

        private EnumC0223a(int i2) {
            this.value = i2;
        }
    }

    public static JSONObject a(JSONObject jSONObject, Application application) {
        try {
            jSONObject.put("machine", bj(application));
            jSONObject.put("cpu_app", TL());
            jSONObject.put("mem", getTotalMemory(application));
            jSONObject.put("mem_free", bn(application));
        } catch (JSONException e2) {
            c.e("Matrix.DeviceUtil", "[JSONException for stack, error: %s", e2);
        }
        return jSONObject;
    }

    public static EnumC0223a bj(Context context) {
        if (deJ != null) {
            return deJ;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long totalMemory = getTotalMemory(context);
        int TM = TM();
        c.i("Matrix.DeviceUtil", "[getLevel] totalMemory:%s coresNum:%s", Long.valueOf(totalMemory), Integer.valueOf(TM));
        if (totalMemory >= 8589934592L) {
            deJ = EnumC0223a.BEST;
        } else if (totalMemory >= 6442450944L) {
            deJ = EnumC0223a.HIGH;
        } else if (totalMemory >= 4294967296L) {
            deJ = EnumC0223a.MIDDLE;
        } else if (totalMemory >= 2147483648L) {
            if (TM >= 4) {
                deJ = EnumC0223a.MIDDLE;
            } else if (TM >= 2) {
                deJ = EnumC0223a.LOW;
            } else if (TM > 0) {
                deJ = EnumC0223a.LOW;
            }
        } else if (0 > totalMemory || totalMemory >= TPAudioFrame.TP_CH_STEREO_RIGHT) {
            deJ = EnumC0223a.UN_KNOW;
        } else {
            deJ = EnumC0223a.BAD;
        }
        c.i("Matrix.DeviceUtil", "getLevel, cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", level:" + deJ, new Object[0]);
        return deJ;
    }

    public static long bk(Context context) {
        if (0 != deL) {
            return deL;
        }
        getTotalMemory(context);
        return deL;
    }

    public static int bl(Context context) {
        if (deM != 0) {
            return deM * 1024;
        }
        getTotalMemory(context);
        return deM * 1024;
    }

    public static long getTotalMemory(Context context) {
        if (0 != deK) {
            return deK;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT < 16) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        activityManager.getMemoryInfo(memoryInfo);
        deK = memoryInfo.totalMem;
        deL = memoryInfo.threshold;
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (maxMemory == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            deM = activityManager.getMemoryClass();
        } else {
            deM = (int) (maxMemory / 1048576);
        }
        c.i("Matrix.DeviceUtil", "getTotalMemory cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", total_mem:" + deK + ", LowMemoryThresold:" + deL + ", Memory Class:" + deM, new Object[0]);
        return deK;
    }

    public static boolean bm(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    public static long TK() {
        return Runtime.getRuntime().freeMemory() / 1024;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008d A[SYNTHETIC, Splitter:B:25:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8 A[SYNTHETIC, Splitter:B:32:0x00a8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long bn(android.content.Context r12) {
        /*
        // Method dump skipped, instructions count: 195
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.g.a.bn(android.content.Context):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00fd A[SYNTHETIC, Splitter:B:29:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x011c A[SYNTHETIC, Splitter:B:37:0x011c] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x015e A[SYNTHETIC, Splitter:B:49:0x015e] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x017c A[SYNTHETIC, Splitter:B:56:0x017c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double TL() {
        /*
        // Method dump skipped, instructions count: 414
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.g.a.TL():double");
    }

    public static Debug.MemoryInfo bo(Context context) {
        try {
            Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getProcessMemoryInfo(new int[]{Process.myPid()});
            if (processMemoryInfo.length > 0) {
                return processMemoryInfo[0];
            }
        } catch (Exception e2) {
            c.i("Matrix.DeviceUtil", "getProcessMemoryInfo fail, error: %s", e2.toString());
        }
        return null;
    }

    private static int TM() {
        int i2 = 0;
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            int eR = eR("/sys/devices/system/cpu/possible");
            if (eR == 0) {
                eR = eR("/sys/devices/system/cpu/present");
            }
            if (eR == 0) {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER);
                if (listFiles != null) {
                    i2 = listFiles.length;
                }
            } else {
                i2 = eR;
            }
        } catch (Exception e2) {
        }
        if (i2 == 0) {
            i2 = 1;
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078 A[SYNTHETIC, Splitter:B:24:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0094 A[SYNTHETIC, Splitter:B:32:0x0094] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int eR(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 175
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.g.a.eR(java.lang.String):int");
    }

    public static long getDalvikHeap() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / 1024;
    }

    public static long getNativeHeap() {
        return Debug.getNativeHeapAllocatedSize() / 1024;
    }

    public static long TN() {
        try {
            String[] split = getStringFromFile(String.format("/proc/%s/status", Integer.valueOf(Process.myPid()))).trim().split("\n");
            for (String str : split) {
                if (str.startsWith("VmSize")) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(str);
                    if (matcher.find()) {
                        return Long.parseLong(matcher.group());
                    }
                }
            }
            if (split.length <= 12) {
                return -1;
            }
            Matcher matcher2 = Pattern.compile("\\d+").matcher(split[12]);
            if (matcher2.find()) {
                return Long.parseLong(matcher2.group());
            }
            return -1;
        } catch (Exception e2) {
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String convertStreamToString(java.io.InputStream r5) {
        /*
            r2 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0032 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0032 }
            java.lang.String r4 = "UTF-8"
            r3.<init>(r5, r4)     // Catch:{ all -> 0x0032 }
            r1.<init>(r3)     // Catch:{ all -> 0x0032 }
        L_0x0013:
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0023 }
            if (r2 == 0) goto L_0x002a
            java.lang.StringBuilder r2 = r0.append(r2)     // Catch:{ all -> 0x0023 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0023 }
            goto L_0x0013
        L_0x0023:
            r0 = move-exception
        L_0x0024:
            if (r1 == 0) goto L_0x0029
            r1.close()
        L_0x0029:
            throw r0
        L_0x002a:
            r1.close()
            java.lang.String r0 = r0.toString()
            return r0
        L_0x0032:
            r0 = move-exception
            r1 = r2
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.g.a.convertStreamToString(java.io.InputStream):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getStringFromFile(java.lang.String r3) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            r2 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0013 }
            r1.<init>(r0)     // Catch:{ all -> 0x0013 }
            java.lang.String r0 = convertStreamToString(r1)     // Catch:{ all -> 0x001b }
            r1.close()
            return r0
        L_0x0013:
            r0 = move-exception
            r1 = r2
        L_0x0015:
            if (r1 == 0) goto L_0x001a
            r1.close()
        L_0x001a:
            throw r0
        L_0x001b:
            r0 = move-exception
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.g.a.getStringFromFile(java.lang.String):java.lang.String");
    }

    public static boolean is64BitRuntime() {
        String str = Build.CPU_ABI;
        return XWalkEnvironment.RUNTIME_ABI_ARM64_STR.equalsIgnoreCase(str) || "x86_64".equalsIgnoreCase(str) || "mips64".equalsIgnoreCase(str);
    }
}
