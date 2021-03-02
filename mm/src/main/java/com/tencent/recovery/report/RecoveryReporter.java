package com.tencent.recovery.report;

import android.content.Context;
import com.tencent.recovery.ConstantsRecovery;
import java.io.File;

public class RecoveryReporter {
    private static final int MAX_REPORT_FILE_LENGTH = 2097152;
    private static final String TAG = "Recovery.RecoveryReporter";

    private static File checkRootFile(Context context) {
        File file = new File(context.getFilesDir(), ConstantsRecovery.RECOVERY_CONF_NAME);
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0077 A[SYNTHETIC, Splitter:B:21:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081 A[SYNTHETIC, Splitter:B:27:0x0081] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean addItem(android.content.Context r9, java.lang.String r10, com.tencent.recovery.model.RecoveryPersistentItem r11) {
        /*
        // Method dump skipped, instructions count: 143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.report.RecoveryReporter.addItem(android.content.Context, java.lang.String, com.tencent.recovery.model.RecoveryPersistentItem):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008e A[SYNTHETIC, Splitter:B:20:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009f A[SYNTHETIC, Splitter:B:30:0x009f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean addItemList(android.content.Context r8, java.lang.String r9, java.util.List<? extends com.tencent.recovery.model.RecoveryPersistentItem> r10) {
        /*
        // Method dump skipped, instructions count: 174
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.report.RecoveryReporter.addItemList(android.content.Context, java.lang.String, java.util.List):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e A[SYNTHETIC, Splitter:B:19:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00af A[SYNTHETIC, Splitter:B:31:0x00af] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends com.tencent.recovery.model.RecoveryPersistentItem> java.util.List<T> getItemList(android.content.Context r10, java.lang.String r11, java.lang.Class<T> r12) {
        /*
        // Method dump skipped, instructions count: 195
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.report.RecoveryReporter.getItemList(android.content.Context, java.lang.String, java.lang.Class):java.util.List");
    }

    public static void clearReportFile(Context context, String str) {
        new File(checkRootFile(context), str).delete();
    }
}
