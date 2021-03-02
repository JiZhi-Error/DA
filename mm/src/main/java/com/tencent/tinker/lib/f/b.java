package com.tencent.tinker.lib.f;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.os.Process;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.util.List;

public final class b extends ShareTinkerInternals {
    private static String Skr = null;

    public static void ll(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String ln = ln(context);
        if (!(ln == null || (runningAppProcesses = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) == null)) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(ln)) {
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        }
    }

    public static boolean lm(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        String ln = ln(context);
        if (ln == null) {
            return false;
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(ln)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            ShareTinkerLog.e("Tinker.ServiceInternals", "isTinkerPatchServiceRunning Exception: " + e2.toString(), new Object[0]);
            return false;
        } catch (Error e3) {
            ShareTinkerLog.e("Tinker.ServiceInternals", "isTinkerPatchServiceRunning Error: " + e3.toString(), new Object[0]);
            return false;
        }
    }

    private static String ln(Context context) {
        if (Skr != null) {
            return Skr;
        }
        String f2 = f(context, TinkerPatchService.class);
        if (f2 == null) {
            return null;
        }
        Skr = f2;
        return f2;
    }

    public static boolean lo(Context context) {
        String processName = getProcessName(context);
        String ln = ln(context);
        if (ln == null || ln.length() == 0) {
            return false;
        }
        return processName.equals(ln);
    }

    private static String f(Context context, Class<? extends Service> cls) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 0).processName;
        } catch (Throwable th) {
            return null;
        }
    }
}
