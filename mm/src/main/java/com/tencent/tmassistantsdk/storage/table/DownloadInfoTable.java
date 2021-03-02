package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadInfoTable implements ITableBase {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists downloadInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, taskId INTEGER , uId TEXT, taskUrl TEXT, secondaryUrl TEXT, finalUrl TEXT, requestFileSize INTEGER, fileName TEXT, contentType TEXT, redirectCnt INTEGER, retryCnt INTEGER, totalBytes INTEGER,status INTEGER,receivedBytes INTEGER,priority INTEGER,netType TEXT,downloadFailedErrCode INTEGER,downloadFailedTime INTEGER,headerParams TEXT);";
    public static final String QUERY_ALL = "select * from downloadInfo";
    public static final String QUERY_DOWNLOADINFO_URL = "select * from downloadInfo where taskUrl = ?";
    public static final String QUERY_UNFINISHED_TASK = "select a.taskUrl,a.status,b.clientId from downloadInfo as a left outer join clientinfo as b on a.taskUrl = b.taskUrl where b.clientId is not null and (a.status = 2 or a.status = 1)";
    public static final String TABLE_NAME = "downloadInfo";
    private static final String TAG = "DownloadInfoTable";

    @Override // com.tencent.tmassistantsdk.storage.table.ITableBase
    public String tableName() {
        return TABLE_NAME;
    }

    @Override // com.tencent.tmassistantsdk.storage.table.ITableBase
    public String createTableSQL() {
        return CREATE_TABLE_SQL;
    }

    @Override // com.tencent.tmassistantsdk.storage.table.ITableBase
    public String[] getAlterSQL(int i2, int i3) {
        if (i2 == 1 && i3 == 2) {
            return new String[]{"alter table downloadInfo add column headerParams TEXT;"};
        }
        return new String[]{"alter table downloadInfo add column netType TEXT;", "alter table downloadInfo add column downloadFailedErrCode INTEGER;", "alter table downloadInfo add column downloadFailedTime INTEGER;"};
    }

    @Override // com.tencent.tmassistantsdk.storage.table.ITableBase
    public SqliteHelper getHelper() {
        AppMethodBeat.i(102440);
        SqliteHelper instance = AstSDKDBHelper_V2.getInstance();
        AppMethodBeat.o(102440);
        return instance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.tencent.tmassistantsdk.downloadservice.DownloadInfo> load() {
        /*
            r2 = 0
            r6 = 102441(0x19029, float:1.4355E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.tencent.tmassistantsdk.storage.helper.SqliteHelper r1 = com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2.getInstance()
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()
            java.lang.String r3 = "select * from downloadInfo"
            r4 = 0
            android.database.Cursor r2 = r1.rawQuery(r3, r4)     // Catch:{ Exception -> 0x003a }
            if (r2 == 0) goto L_0x0031
            boolean r1 = r2.moveToFirst()     // Catch:{ Exception -> 0x003a }
            if (r1 == 0) goto L_0x0031
        L_0x0024:
            com.tencent.tmassistantsdk.downloadservice.DownloadInfo r1 = com.tencent.tmassistantsdk.downloadservice.DownloadInfo.readFromCursor(r2)     // Catch:{ Exception -> 0x003a }
            r0.add(r1)     // Catch:{ Exception -> 0x003a }
            boolean r1 = r2.moveToNext()     // Catch:{ Exception -> 0x003a }
            if (r1 != 0) goto L_0x0024
        L_0x0031:
            if (r2 == 0) goto L_0x0036
            r2.close()
        L_0x0036:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x0039:
            return r0
        L_0x003a:
            r1 = move-exception
            java.lang.String r3 = "DownloadInfoTable"
            java.lang.String r4 = ""
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0050 }
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(r3, r1, r4, r5)     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x004c
            r2.close()
        L_0x004c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            goto L_0x0039
        L_0x0050:
            r0 = move-exception
            if (r2 == 0) goto L_0x0056
            r2.close()
        L_0x0056:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.storage.table.DownloadInfoTable.load():java.util.ArrayList");
    }

    public static void save(ArrayList<DownloadInfo> arrayList) {
        AppMethodBeat.i(102442);
        if (arrayList != null) {
            SQLiteDatabase writableDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                Iterator<DownloadInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    DownloadInfo next = it.next();
                    if (update(next, writableDatabase) <= 0) {
                        ContentValues contentValues = new ContentValues();
                        DownloadInfo.writeToContentValues(contentValues, next);
                        writableDatabase.insert(TABLE_NAME, null, contentValues);
                    }
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            } finally {
                writableDatabase.endTransaction();
                AppMethodBeat.o(102442);
            }
        } else {
            AppMethodBeat.o(102442);
        }
    }

    public static void add(DownloadInfo downloadInfo) {
        AppMethodBeat.i(102443);
        if (downloadInfo != null) {
            try {
                SQLiteDatabase writableDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
                if (update(downloadInfo, writableDatabase) <= 0) {
                    ContentValues contentValues = new ContentValues();
                    DownloadInfo.writeToContentValues(contentValues, downloadInfo);
                    writableDatabase.insert(TABLE_NAME, null, contentValues);
                }
                AppMethodBeat.o(102443);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102443);
    }

    public static void del(String str) {
        AppMethodBeat.i(102444);
        if (str != null && str.length() > 0) {
            try {
                AstSDKDBHelper_V2.getInstance().getWritableDatabase().delete(TABLE_NAME, "taskUrl = ?", new String[]{str});
                AppMethodBeat.o(102444);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102444);
    }

    private static int update(DownloadInfo downloadInfo, SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(102445);
        if (downloadInfo == null) {
            AppMethodBeat.o(102445);
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues();
            DownloadInfo.writeToContentValues(contentValues, downloadInfo);
            int update = sQLiteDatabase.update(TABLE_NAME, contentValues, "taskUrl = ?", new String[]{downloadInfo.mURL});
            if (update > 0) {
                AppMethodBeat.o(102445);
                return update;
            }
            AppMethodBeat.o(102445);
            return 0;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102445);
            return -2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.tmassistantsdk.downloadservice.DownloadInfo query(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.storage.table.DownloadInfoTable.query(java.lang.String):com.tencent.tmassistantsdk.downloadservice.DownloadInfo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTask> query() {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.storage.table.DownloadInfoTable.query():java.util.ArrayList");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0042  */
    @Override // com.tencent.tmassistantsdk.storage.table.ITableBase
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dataMovement(android.database.sqlite.SQLiteDatabase r7, android.database.sqlite.SQLiteDatabase r8) {
        /*
        // Method dump skipped, instructions count: 117
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.storage.table.DownloadInfoTable.dataMovement(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase):void");
    }
}
