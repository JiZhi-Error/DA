package com.tencent.recovery.service;

import android.app.IntentService;
import android.content.Intent;
import com.tencent.recovery.log.RecoveryLog;

public class RecoveryReportService extends IntentService {
    private static final String TAG = "Recovery.RecoveryReportService";

    public RecoveryReportService() {
        super(RecoveryReportService.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        handle(intent);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r3.equals(com.tencent.recovery.ConstantsRecovery.ReportType.HandleStatus) != false) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void handle(android.content.Intent r9) {
        /*
        // Method dump skipped, instructions count: 134
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.service.RecoveryReportService.handle(android.content.Intent):void");
    }

    public void onDestroy() {
        RecoveryLog.appendLog();
        super.onDestroy();
    }
}
