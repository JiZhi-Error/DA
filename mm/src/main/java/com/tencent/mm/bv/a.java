package com.tencent.mm.bv;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static Map<String, Integer> iG(Context context) {
        AppMethodBeat.i(152429);
        HashMap hashMap = new HashMap();
        if (context != null) {
            try {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) {
                    hashMap.put(runningAppProcessInfo.processName, Integer.valueOf(runningAppProcessInfo.pid));
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ProcessOperator", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(152429);
        return hashMap;
    }

    public static boolean f(Context context, String... strArr) {
        AppMethodBeat.i(152431);
        if (context == null) {
            AppMethodBeat.o(152431);
            return false;
        }
        Map<String, Integer> iG = iG(context);
        for (int i2 = 0; i2 < 10; i2++) {
            String str = strArr[i2];
            Integer num = iG.get(str);
            if (num != null) {
                Log.i("MicroMsg.ProcessOperator", "killProcess(pid : %s, process : %s)", num, str);
                try {
                    com.tencent.mm.hellhoundlib.b.a a2 = c.a(num.intValue(), new com.tencent.mm.hellhoundlib.b.a());
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/process/ProcessOperator", "killProcess", "(Landroid/content/Context;[Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    Process.killProcess(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/process/ProcessOperator", "killProcess", "(Landroid/content/Context;[Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                } catch (Throwable th) {
                    Log.e("MicroMsg.ProcessOperator", "killProcess, process[%s] pid[%d], e=%s", str, num, th);
                }
            }
        }
        AppMethodBeat.o(152431);
        return true;
    }

    public static void iH(Context context) {
        AppMethodBeat.i(152432);
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.uid == myUid && runningAppProcessInfo.pid != myPid) {
                com.tencent.mm.hellhoundlib.b.a a2 = c.a(runningAppProcessInfo.pid, new com.tencent.mm.hellhoundlib.b.a());
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                Process.killProcess(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            }
        }
        com.tencent.mm.hellhoundlib.b.a a3 = c.a(myPid, new com.tencent.mm.hellhoundlib.b.a());
        Object obj2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj2, a3.axQ(), "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer) a3.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj2, "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(152432);
    }

    public static boolean cs(Context context, String str) {
        int i2;
        AppMethodBeat.i(152430);
        if (context == null || str == null || str.length() == 0) {
            i2 = 0;
        } else {
            Integer num = iG(context).get(str);
            i2 = num != null ? num.intValue() : 0;
        }
        if (i2 != 0) {
            try {
                com.tencent.mm.hellhoundlib.b.a a2 = c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/process/ProcessOperator", "killProcess", "(Landroid/content/Context;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                Process.killProcess(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/process/ProcessOperator", "killProcess", "(Landroid/content/Context;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                AppMethodBeat.o(152430);
                return true;
            } catch (Throwable th) {
                Log.e("MicroMsg.ProcessOperator", "killProcess, process[%s] pid[%d], e=%s", str, Integer.valueOf(i2), th);
                AppMethodBeat.o(152430);
                return false;
            }
        } else {
            AppMethodBeat.o(152430);
            return false;
        }
    }
}
