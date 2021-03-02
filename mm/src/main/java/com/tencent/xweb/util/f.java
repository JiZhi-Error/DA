package com.tencent.xweb.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.reflect.Method;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

public final class f {
    public static String htT() {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Object oj;
        AppMethodBeat.i(219086);
        if (Build.VERSION.SDK_INT < 28 || (oj = g.oj("android.app.Application", "getProcessName")) == null) {
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                String str = invoke instanceof String ? (String) invoke : null;
                AppMethodBeat.o(219086);
                return str;
            } catch (Exception e2) {
                Context applicationContext = XWalkEnvironment.getApplicationContext();
                int myPid = Process.myPid();
                if (!(applicationContext == null || (activityManager = (ActivityManager) applicationContext.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)) == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.isEmpty())) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == myPid) {
                            String str2 = runningAppProcessInfo.processName;
                            AppMethodBeat.o(219086);
                            return str2;
                        }
                    }
                }
                AppMethodBeat.o(219086);
                return null;
            }
        } else {
            String obj = oj.toString();
            AppMethodBeat.o(219086);
            return obj;
        }
    }
}
