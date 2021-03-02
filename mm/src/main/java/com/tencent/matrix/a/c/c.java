package com.tencent.matrix.a.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import com.tencent.matrix.a.b;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

public final class c {
    public static String getPackageName() {
        b bVar = (b) com.tencent.matrix.b.RG().Y(b.class);
        if (bVar != null) {
            return bVar.getPackageName();
        }
        throw new IllegalStateException("BatteryMonitorPlugin is not yet installed!");
    }

    public static String stackTraceToString(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList(stackTraceElementArr.length);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!className.contains("com.tencent.matrix") && !className.contains("java.lang.reflect") && !className.contains("$Proxy2") && !className.contains("android.os")) {
                arrayList.add(stackTraceElement);
            }
        }
        String packageName = getPackageName();
        if (arrayList.size() > 10 && !TextUtils.isEmpty(packageName)) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (listIterator.hasPrevious()) {
                if (!((StackTraceElement) listIterator.previous()).getClassName().contains(packageName)) {
                    listIterator.remove();
                }
                if (arrayList.size() <= 10) {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((StackTraceElement) it.next()).append('\n');
        }
        return sb.toString();
    }

    public static String getThrowableStack(Throwable th) {
        return stackTraceToString(th.getStackTrace());
    }

    public static int[] Sq() {
        int[] iArr = new int[getNumCores()];
        for (int i2 = 0; i2 < getNumCores(); i2++) {
            iArr[i2] = 0;
            String eu = eu("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/scaling_cur_freq");
            if (!TextUtils.isEmpty(eu)) {
                try {
                    iArr[i2] = Integer.parseInt(eu) / 1000;
                } catch (Exception e2) {
                }
            }
        }
        return iArr;
    }

    private static int getNumCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {
                /* class com.tencent.matrix.a.c.c.AnonymousClass1 */

                public final boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Exception e2) {
            return 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        r2 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String eu(java.lang.String r5) {
        /*
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto L_0x0008
        L_0x0007:
            return r0
        L_0x0008:
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Throwable -> 0x0022 }
            java.lang.String r1 = "r"
            r3.<init>(r5, r1)     // Catch:{ Throwable -> 0x0022 }
            java.lang.String r1 = r3.readLine()     // Catch:{ Throwable -> 0x0019, all -> 0x0039 }
            r3.close()
            r0 = r1
            goto L_0x0007
        L_0x0019:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001b }
        L_0x001b:
            r1 = move-exception
        L_0x001c:
            if (r2 == 0) goto L_0x0035
            r3.close()     // Catch:{ Throwable -> 0x0030 }
        L_0x0021:
            throw r1
        L_0x0022:
            r1 = move-exception
            java.lang.String r2 = "Matrix.battery.Utils"
            java.lang.String r3 = "cat file fail"
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.tencent.matrix.g.c.printErrStackTrace(r2, r1, r3, r4)
            goto L_0x0007
        L_0x0030:
            r3 = move-exception
            r2.addSuppressed(r3)
            goto L_0x0021
        L_0x0035:
            r3.close()
            goto L_0x0021
        L_0x0039:
            r1 = move-exception
            r2 = r0
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.a.c.c.eu(java.lang.String):java.lang.String");
    }

    public static int ba(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return 0;
            }
            return registerReceiver.getIntExtra("temperature", 0);
        } catch (Throwable th) {
            return 0;
        }
    }

    public static int k(Context context, boolean z) {
        if (z) {
            return 1;
        }
        if (bf(context)) {
            return 3;
        }
        return 2;
    }

    public static int bb(Context context) {
        if (bc(context)) {
            return 1;
        }
        if (!bd(context)) {
            return 3;
        }
        if (be(context)) {
            return 4;
        }
        return 2;
    }

    public static boolean bc(Context context) {
        BatteryManager batteryManager;
        if (Build.VERSION.SDK_INT >= 23 && (batteryManager = (BatteryManager) context.getSystemService("batterymanager")) != null) {
            return batteryManager.isCharging();
        }
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return false;
            }
            int intExtra = registerReceiver.getIntExtra("plugged", -1);
            return intExtra == 1 || intExtra == 2 || intExtra == 4;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean bd(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                return Build.VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
            }
        } catch (Exception e2) {
        }
        return false;
    }

    public static boolean be(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    return powerManager.isPowerSaveMode();
                }
            } catch (Exception e2) {
            }
        }
        return false;
    }

    public static boolean bf(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            if (!(activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null)) {
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    if (!TextUtils.isEmpty(runningServiceInfo.process) && runningServiceInfo.process.startsWith(context.getPackageName()) && runningServiceInfo.foreground) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static String K(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("\n\t");
        boolean isEmpty = TextUtils.isEmpty(str2);
        for (String str3 : split) {
            if (!TextUtils.isEmpty(str3)) {
                if (!isEmpty && str3.startsWith(str2)) {
                    isEmpty = true;
                }
                if (isEmpty) {
                    arrayList.add(str3.trim());
                }
            }
        }
        return TextUtils.join(";", arrayList.subList(0, Math.min(5, arrayList.size())));
    }
}
