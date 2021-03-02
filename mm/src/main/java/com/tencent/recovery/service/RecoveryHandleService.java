package com.tencent.recovery.service;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.tencent.recovery.ConstantsRecovery;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryData;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.model.RecoveryHandleResult;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.util.Util;
import java.util.ArrayList;

public class RecoveryHandleService extends IntentService {
    private static final String TAG = "Recovery.RecoveryHandleService";
    private static final int notificationId = -1119860829;
    private static volatile boolean running;

    public RecoveryHandleService() {
        super(RecoveryHandleService.class.getName());
    }

    public void onCreate() {
        RecoveryLog.i(TAG, "onCreate", new Object[0]);
        super.onCreate();
    }

    public void onDestroy() {
        RecoveryLog.i(TAG, "onDestroy", new Object[0]);
        RecoveryLog.appendLog();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void onHandleIntent(Intent intent) {
        RecoveryHandleResult recoveryHandleResult;
        boolean isRetry = isRetry(intent);
        int uuid = Util.getUUID(this);
        String stringExtra = intent.getStringExtra(ConstantsRecovery.IntentKeys.KeyReportUploadClassName);
        String stringExtra2 = intent.getStringExtra(ConstantsRecovery.IntentKeys.KeyReportHandleClassName);
        RecoveryData recoveryData = (RecoveryData) intent.getParcelableExtra(ConstantsRecovery.IntentKeys.KeyRecoveryData);
        if (recoveryData == null || recoveryData.processName == null) {
            RecoveryLog.i(TAG, "recoveryData is null %b %d %s %s", Boolean.valueOf(isRetry), Integer.valueOf(uuid), stringExtra, stringExtra2);
            return;
        }
        ArrayList<RecoveryHandleItem> arrayList = new ArrayList<>();
        cancelAlarm(stringExtra2);
        if (running) {
            RecoveryLog.i(TAG, "handle already running", new Object[0]);
            try {
                alreadyRunning(this, recoveryData, arrayList, uuid, isRetry);
            } catch (Exception e2) {
                RecoveryLog.printErrStackTrace(TAG, e2, "alreadyRunning", new Object[0]);
            }
        } else {
            running = true;
            increasingPriority();
            RecoveryLog.i(TAG, "start to handle %s's exception uuid: %s threadId: %d", recoveryData.processName, recoveryData.uuid, Long.valueOf(Thread.currentThread().getId()));
            RecoveryHandleResult recoveryHandleResult2 = new RecoveryHandleResult();
            try {
                recoveryHandleResult = handleException(this, recoveryData, arrayList, uuid, isRetry);
            } catch (Exception e3) {
                RecoveryLog.printErrStackTrace(TAG, e3, "handle", new Object[0]);
                recoveryHandleResult = recoveryHandleResult2;
            }
            if (recoveryHandleResult.retry && !isRetry) {
                retry(stringExtra, stringExtra2, recoveryData);
            }
            RecoveryLog.i(TAG, "handle recoveryHandleResult %s", recoveryHandleResult);
        }
        RecoveryLogic.startReportService(this, arrayList, stringExtra);
        running = false;
        stopSelf();
    }

    private void retry(String str, String str2, RecoveryData recoveryData) {
        Intent intent = new Intent();
        intent.setClassName(this, str2);
        intent.putExtra(ConstantsRecovery.IntentKeys.KeyReportUploadClassName, str);
        intent.putExtra(ConstantsRecovery.IntentKeys.KeyReportHandleClassName, str2);
        intent.putExtra(ConstantsRecovery.IntentKeys.KeyRecoveryData, recoveryData);
        intent.putExtra(ConstantsRecovery.IntentKeys.KeyIsRetry, true);
        PendingIntent service = PendingIntent.getService(this, 1000002, intent, 536870912);
        if (service != null) {
            service.cancel();
        }
        CommonOptions commonOptions = OptionFactory.getCommonOptions(this);
        PendingIntent service2 = PendingIntent.getService(this, 1000002, intent, 0);
        long handleRetryInterval = (commonOptions.getHandleRetryInterval() + System.currentTimeMillis()) - 2000;
        ((AlarmManager) getSystemService("alarm")).set(0, handleRetryInterval, service2);
        RecoveryLog.i(TAG, "startAlarm pendingIntent success: %d will retry %s", Integer.valueOf(service2.hashCode()), Util.getTimeFormat(handleRetryInterval));
    }

    private void cancelAlarm(String str) {
        Intent intent = new Intent();
        intent.setClassName(this, str);
        PendingIntent service = PendingIntent.getService(this, 1000002, intent, 536870912);
        if (service != null) {
            service.cancel();
        }
    }

    private boolean isRetry(Intent intent) {
        return intent.getBooleanExtra(ConstantsRecovery.IntentKeys.KeyIsRetry, false);
    }

    /* access modifiers changed from: protected */
    public void alreadyRunning(Context context, RecoveryData recoveryData, ArrayList<RecoveryHandleItem> arrayList, int i2, boolean z) {
    }

    /* access modifiers changed from: protected */
    public RecoveryHandleResult handleException(Context context, RecoveryData recoveryData, ArrayList<RecoveryHandleItem> arrayList, int i2, boolean z) {
        return new RecoveryHandleResult();
    }

    private void increasingPriority() {
        RecoveryLog.i(TAG, "try to increase recovery process priority", new Object[0]);
        try {
            Notification notification = new Notification();
            if (Build.VERSION.SDK_INT < 18) {
                startForeground(-1119860829, notification);
                return;
            }
            startForeground(-1119860829, notification);
            startService(new Intent(this, InnerService.class));
        } catch (Throwable th) {
            RecoveryLog.i(TAG, "try to increase recovery process priority error:".concat(String.valueOf(th)), new Object[0]);
        }
    }

    public static class InnerService extends Service {
        public void onCreate() {
            super.onCreate();
            try {
                startForeground(-1119860829, new Notification());
            } catch (Throwable th) {
                RecoveryLog.e(RecoveryHandleService.TAG, "InnerService set service for push exception:%s.", th);
            }
            stopSelf();
        }

        public void onDestroy() {
            stopForeground(true);
            super.onDestroy();
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }
}
