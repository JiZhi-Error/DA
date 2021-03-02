package com.tencent.wcdb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.wcdb.database.SQLiteDatabaseConfiguration;
import com.tencent.wcdb.support.Log;
import java.io.File;

public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    private static final String[] SUFFIX_TO_BACKUP = {"", "-journal", "-wal", ".sm", ".bak", "-vfslog", "-vfslo1"};
    private static final String TAG = "WCDB.DefaultDatabaseErrorHandler";
    private final boolean mNoCorruptionBackup;

    public DefaultDatabaseErrorHandler() {
        this.mNoCorruptionBackup = false;
    }

    public DefaultDatabaseErrorHandler(boolean z) {
        this.mNoCorruptionBackup = z;
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:403)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // com.tencent.wcdb.DatabaseErrorHandler
    public final void onCorruption(com.tencent.wcdb.database.SQLiteDatabase r5) {
        /*
        // Method dump skipped, instructions count: 189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wcdb.DefaultDatabaseErrorHandler.onCorruption(com.tencent.wcdb.database.SQLiteDatabase):void");
    }

    private void deleteDatabaseFile(String str) {
        int i2 = 0;
        AppMethodBeat.i(2851);
        if (str.equalsIgnoreCase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH) || str.trim().length() == 0) {
            AppMethodBeat.o(2851);
            return;
        }
        Log.e(TAG, "Remove database file: ".concat(String.valueOf(str)));
        if (!this.mNoCorruptionBackup) {
            File file = new File(str);
            File file2 = new File(file.getParentFile(), "corrupted");
            if (!file2.mkdirs()) {
                Log.e(TAG, "Could not create directory for corrupted database. Corruption backup may be unavailable.");
            }
            String str2 = file2.getPath() + FilePathGenerator.ANDROID_DIR_SEP + file.getName();
            String[] strArr = SUFFIX_TO_BACKUP;
            int length = strArr.length;
            while (i2 < length) {
                String str3 = strArr[i2];
                moveOrDeleteFile(str + str3, str2 + str3);
                i2++;
            }
            AppMethodBeat.o(2851);
            return;
        }
        String[] strArr2 = SUFFIX_TO_BACKUP;
        int length2 = strArr2.length;
        while (i2 < length2) {
            deleteFile(str + strArr2[i2]);
            i2++;
        }
        AppMethodBeat.o(2851);
    }

    private static boolean moveOrDeleteFile(String str, String str2) {
        AppMethodBeat.i(2852);
        File file = new File(str);
        boolean renameTo = file.renameTo(new File(str2));
        if (!renameTo) {
            file.delete();
        }
        AppMethodBeat.o(2852);
        return renameTo;
    }

    private static boolean deleteFile(String str) {
        AppMethodBeat.i(2853);
        boolean delete = new File(str).delete();
        AppMethodBeat.o(2853);
        return delete;
    }
}
