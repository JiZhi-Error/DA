package com.tencent.recovery;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.recovery.ConstantsRecovery;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryData;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.service.RecoveryHandleService;
import com.tencent.recovery.service.RecoveryReportService;
import com.tencent.recovery.service.RecoveryUploadService;
import com.tencent.recovery.util.Util;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecoveryLogic {
    private static final String TAG = "Recovery.RecoveryLogic";
    private static String handleServiceProcessName;
    public static int processStartFlag = 17;
    public static Field rProcessStateField = null;

    public static void startReportService(Context context, RecoveryStatusItem recoveryStatusItem, String str) {
        RecoveryLog.i(TAG, "startReportService %s", ConstantsRecovery.ReportType.ProcessStatus);
        Intent intent = new Intent(context, RecoveryReportService.class);
        intent.putExtra(ConstantsRecovery.IntentKeys.KeyReportType, ConstantsRecovery.ReportType.ProcessStatus);
        intent.putExtra(ConstantsRecovery.IntentKeys.KeyReportItem, recoveryStatusItem);
        intent.putExtra(ConstantsRecovery.IntentKeys.KeyReportUploadClassName, str);
        context.startService(intent);
    }

    public static void startReportService(Context context, ArrayList<RecoveryHandleItem> arrayList, String str) {
        RecoveryLog.i(TAG, "startReportService %s", ConstantsRecovery.ReportType.HandleStatus);
        Intent intent = new Intent(context, RecoveryReportService.class);
        intent.putExtra(ConstantsRecovery.IntentKeys.KeyReportType, ConstantsRecovery.ReportType.HandleStatus);
        intent.putExtra(ConstantsRecovery.IntentKeys.KeyReportUploadClassName, str);
        intent.putParcelableArrayListExtra(ConstantsRecovery.IntentKeys.KeyReportItem, arrayList);
        context.startService(intent);
    }

    public static boolean startHandleService(Context context, CommonOptions commonOptions, RecoveryContext recoveryContext) {
        if (commonOptions.getRecoveryHandleService() == null) {
            RecoveryLog.i(TAG, "startRecoveryProcess not set handle service", new Object[0]);
            return false;
        }
        RecoveryLog.i(TAG, "startHandleService %s", Util.getMyProcessName(context));
        String name = Util.isNullOrNil(commonOptions.getRecoveryUploadService()) ? RecoveryUploadService.class.getName() : commonOptions.getRecoveryUploadService();
        String name2 = Util.isNullOrNil(commonOptions.getRecoveryHandleService()) ? RecoveryHandleService.class.getName() : commonOptions.getRecoveryHandleService();
        RecoveryData recoveryData = new RecoveryData();
        recoveryData.processName = Util.getMyProcessName(context);
        recoveryData.uuid = commonOptions.getUUID();
        recoveryData.configUrl = commonOptions.getConfigUrl();
        recoveryData.exceptionItemList = recoveryContext.exceptionItemList;
        recoveryData.clientVersion = commonOptions.getClientVersion();
        Intent intent = new Intent();
        intent.setClassName(context, commonOptions.getRecoveryHandleService());
        intent.putExtra(ConstantsRecovery.IntentKeys.KeyReportUploadClassName, name);
        intent.putExtra(ConstantsRecovery.IntentKeys.KeyReportHandleClassName, name2);
        intent.putExtra(ConstantsRecovery.IntentKeys.KeyRecoveryData, recoveryData);
        context.startService(intent);
        return true;
    }

    public static int getProcessStartFlag(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> list;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        Integer num;
        if (processStartFlag != 17) {
            return processStartFlag;
        }
        processStartFlag = 16;
        if (rProcessStateField == null) {
            try {
                rProcessStateField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
            } catch (Exception e2) {
            }
        }
        if (rProcessStateField != null) {
            try {
                list = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses();
            } catch (Exception e3) {
                list = null;
            }
            if (list == null || list.isEmpty()) {
                RecoveryLog.i(TAG, "can not get running app process", new Object[0]);
            } else {
                Iterator<ActivityManager.RunningAppProcessInfo> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        runningAppProcessInfo = null;
                        break;
                    }
                    runningAppProcessInfo = it.next();
                    if (runningAppProcessInfo != null && runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0) {
                        try {
                            num = Integer.valueOf(rProcessStateField.getInt(runningAppProcessInfo));
                        } catch (Exception e4) {
                            num = null;
                        }
                        if (num != null && num.intValue() == 2) {
                            break;
                        }
                    }
                }
                if (runningAppProcessInfo != null) {
                    RecoveryLog.i(TAG, "%s %s", str, runningAppProcessInfo.processName);
                    if (str.equals(runningAppProcessInfo.processName)) {
                        processStartFlag = 1;
                    }
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 : list) {
                        if (runningAppProcessInfo2 != null) {
                            stringBuffer.append(runningAppProcessInfo2.processName + ":" + runningAppProcessInfo2.importance + " ");
                        }
                    }
                    RecoveryLog.i(TAG, "foregroundInfo is null %s %s", Integer.valueOf(list.size()), stringBuffer.toString());
                }
            }
        }
        return processStartFlag;
    }

    private static String getRecoveryHandleServiceName(Context context, String str) {
        if (handleServiceProcessName != null) {
            return handleServiceProcessName;
        }
        String serviceProcessName = getServiceProcessName(context, str);
        if (serviceProcessName == null) {
            return null;
        }
        handleServiceProcessName = serviceProcessName;
        return serviceProcessName;
    }

    private static String getServiceProcessName(Context context, String str) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, str), 0).processName;
        } catch (PackageManager.NameNotFoundException e2) {
            return null;
        }
    }

    public static boolean isRecoveryProcess() {
        return isRecoveryProcess(Recovery.getContext());
    }

    public static boolean isRecoveryProcess(Context context) {
        if (Util.getMyProcessName(context).equals(context.getPackageName() + ":recovery")) {
            return true;
        }
        return false;
    }
}
