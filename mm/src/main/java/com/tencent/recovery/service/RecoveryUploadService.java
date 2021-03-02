package com.tencent.recovery.service;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.recovery.ConstantsRecovery;
import com.tencent.recovery.log.RecoveryFileLog;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.util.Util;

public class RecoveryUploadService extends IntentService {
    private static final String TAG = "Recovery.RecoveryUploadService";

    public RecoveryUploadService() {
        super(RecoveryUploadService.class.getName());
    }

    public static synchronized void startAlarm(Context context, String str) {
        synchronized (RecoveryUploadService.class) {
            if (!Util.isNullOrNil(str)) {
                CommonOptions commonOptions = OptionFactory.getCommonOptions(context);
                SharedPreferences sharedPreferences = context.getSharedPreferences(ConstantsRecovery.RECOVERY_INFO_CONF_NAME, 0);
                long j2 = sharedPreferences.getLong(ConstantsRecovery.SpKeys.KeyLastUploadTime, 0);
                long currentTimeMillis = System.currentTimeMillis();
                RecoveryLog.i(TAG, "startAlarm %s lastUploadTime %s", str, Util.getTimeFormat(j2));
                Intent intent = new Intent();
                intent.setClassName(context, str);
                intent.putExtra(ConstantsRecovery.IntentKeys.KeyReportUploadClassName, str);
                PendingIntent service = PendingIntent.getService(context, 1000001, intent, 536870912);
                if (service == null || currentTimeMillis - j2 > commonOptions.getUploadInterval()) {
                    if (service != null) {
                        service.cancel();
                        RecoveryLog.i(TAG, "startAlarm cancel preIntent", new Object[0]);
                    }
                    sharedPreferences.edit().putLong(ConstantsRecovery.SpKeys.KeyLastUploadTime, currentTimeMillis).commit();
                    PendingIntent service2 = PendingIntent.getService(context, 1000001, intent, 134217728);
                    long uploadInterval = (commonOptions.getUploadInterval() + currentTimeMillis) - 2000;
                    try {
                        ((AlarmManager) context.getSystemService("alarm")).set(0, uploadInterval, service2);
                    } catch (Exception e2) {
                        RecoveryLog.printErrStackTrace(TAG, e2, "alarmManager.setAlarm", new Object[0]);
                    }
                    RecoveryLog.i(TAG, "startAlarm pendingIntent success: %d will report %s", Integer.valueOf(service2.hashCode()), Util.getTimeFormat(uploadInterval));
                } else {
                    RecoveryLog.i(TAG, "already set alarm", new Object[0]);
                }
            }
        }
    }

    public static void cancelAlarm(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(context, str);
        intent.putExtra(ConstantsRecovery.IntentKeys.KeyReportUploadClassName, str);
        PendingIntent service = PendingIntent.getService(context, 1000001, intent, 536870912);
        if (service != null) {
            service.cancel();
        }
    }

    public static void startAlarmAfter(Context context, String str, long j2) {
        if (!Util.isNullOrNil(str)) {
            RecoveryLog.i(TAG, "startAlarmAfter %s %d", str, Long.valueOf(j2));
            Intent intent = new Intent();
            intent.setClassName(context, str);
            intent.putExtra(ConstantsRecovery.IntentKeys.KeyReportUploadClassName, str);
            PendingIntent service = PendingIntent.getService(context, 1000001, intent, 536870912);
            if (service != null) {
                service.cancel();
            }
            long currentTimeMillis = (System.currentTimeMillis() + j2) - 2000;
            PendingIntent service2 = PendingIntent.getService(context, 1000001, intent, 134217728);
            try {
                ((AlarmManager) context.getSystemService("alarm")).set(0, currentTimeMillis, service2);
            } catch (Exception e2) {
                RecoveryLog.printErrStackTrace(TAG, e2, "alarmManager.setAlarm", new Object[0]);
            }
            RecoveryLog.i(TAG, "startAlarmAfter pendingIntent:%d %s", Integer.valueOf(service2.hashCode()), Util.getTimeFormat(currentTimeMillis));
        }
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        RecoveryLog.i(TAG, "RecoveryUploadReceiver.onHandleIntent", new Object[0]);
        boolean tryToUploadData = tryToUploadData();
        String stringExtra = intent.getStringExtra(ConstantsRecovery.IntentKeys.KeyReportUploadClassName);
        if (Util.isNullOrNil(stringExtra)) {
            stringExtra = getClass().getName();
        }
        cancelAlarm(this, stringExtra);
        if (!tryToUploadData) {
            startAlarmAfter(this, stringExtra, OptionFactory.getCommonOptions(this).getUploadInterval());
        }
        RecoveryLog.i(TAG, "RecoveryUploadReceiver.uploadDataResult %b", Boolean.valueOf(tryToUploadData));
        if (RecoveryLog.getLogImpl() instanceof RecoveryFileLog) {
            RecoveryLog.i(TAG, "send broadcast action", new Object[0]);
            RecoveryLog.appendLog();
            Intent intent2 = new Intent();
            intent2.setPackage(getPackageName());
            intent2.setAction(ConstantsRecovery.IntentAction.ACTION_LOG);
            sendBroadcast(intent2);
        }
        stopSelf();
    }

    /* access modifiers changed from: protected */
    public boolean tryToUploadData() {
        return true;
    }
}
