package com.tencent.recovery.wx;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.tinker.loader.hotplug.EnvConsts;

public class RecoveryTinkerManager {
    private static final int MIN_SDKVER_TO_USE_JOBSCHEDULER = 26;
    public static final int OTHER_ERROR = -1;
    public static final int PATCH_SERVICE_RUNNING = -2;
    private static final String TAG = "Recovery.RecoveryTinkerManager";
    public static final String TINKER_PATCH_INTENT_SERVICE = "com.tencent.tinker.lib.service.IntentServiceRunner";
    public static final String TINKER_PATCH_JOB_SERVICE = "com.tencent.tinker.lib.service.JobServiceRunner";

    public static int startToPatch(Context context, String str) {
        if (isProcessRunning(context, getServiceProcessName(context))) {
            return -2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return startPatchByIntentService(context, str);
        }
        return startPatchByJobScheduler(context, str);
    }

    private static String getExpectedServiceRunnerClassName() {
        if (Build.VERSION.SDK_INT < 26) {
            return TINKER_PATCH_INTENT_SERVICE;
        }
        return TINKER_PATCH_JOB_SERVICE;
    }

    private static int startPatchByIntentService(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setClassName(context, TINKER_PATCH_INTENT_SERVICE);
            intent.putExtra("patch_path_extra", str);
            intent.putExtra("patch_result_class", "com.tencent.mm.modelrecovery.RecoveryTinkerResultService");
            context.startService(intent);
            return 0;
        } catch (Throwable th) {
            RecoveryLog.e(TAG, "start patch service fail, exception:".concat(String.valueOf(th)), new Object[0]);
            return -1;
        }
    }

    @TargetApi(21)
    private static int startPatchByJobScheduler(Context context, String str) {
        try {
            JobInfo.Builder builder = new JobInfo.Builder(-252579085, new ComponentName(context, TINKER_PATCH_JOB_SERVICE));
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("patch_path_extra", str);
            persistableBundle.putString("patch_result_class", "com.tencent.mm.modelrecovery.RecoveryTinkerResultService");
            builder.setExtras(persistableBundle);
            builder.setOverrideDeadline(5);
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                RecoveryLog.e(TAG, "fail to get job scheduler service.", new Object[0]);
                return -1;
            } else if (jobScheduler.schedule(builder.build()) == 1) {
                return 0;
            } else {
                RecoveryLog.e(TAG, "fail to schedule job.", new Object[0]);
                return -1;
            }
        } catch (Throwable th) {
            RecoveryLog.e(TAG, "start patch service fail, exception:".concat(String.valueOf(th)), new Object[0]);
            return -1;
        }
    }

    private static String getServiceProcessName(Context context) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, getExpectedServiceRunnerClassName()), 0).processName;
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean isProcessRunning(Context context, String str) {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.equals(str)) {
                    return true;
                }
            }
        } catch (Exception e2) {
        }
        return false;
    }
}
