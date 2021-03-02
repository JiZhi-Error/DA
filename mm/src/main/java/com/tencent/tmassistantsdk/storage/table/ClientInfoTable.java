package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import com.tencent.tmassistantsdk.storage.model.ClientInfo;

public class ClientInfoTable implements ITableBase {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists clientinfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, clientId TEXT , taskId INTEGER, taskUrl TEXT);";
    public static final String QUERY_CLIENTINFO = "select * from clientinfo where clientId = ?";
    public static final String QUERY_CLIENTINFO_ALL = "select * from clientinfo";
    public static final String TABLE_NAME = "clientinfo";
    private static final String TAG = "ClientInfoTable";

    private static void fillValues(ContentValues contentValues, ClientInfo clientInfo) {
        AppMethodBeat.i(102430);
        if (clientInfo != null) {
            contentValues.put(Columns.CLIENTID, clientInfo.clientId);
            contentValues.put("taskId", Integer.valueOf(clientInfo.taskId));
            contentValues.put("taskUrl", clientInfo.taskUrl);
        }
        AppMethodBeat.o(102430);
    }

    private static ClientInfo cursor2object(Cursor cursor) {
        AppMethodBeat.i(102431);
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.clientId = cursor.getString(cursor.getColumnIndex(Columns.CLIENTID));
        clientInfo.taskId = cursor.getInt(cursor.getColumnIndex("taskId"));
        clientInfo.taskUrl = cursor.getString(cursor.getColumnIndex("taskUrl"));
        AppMethodBeat.o(102431);
        return clientInfo;
    }

    public static void save(ClientInfo clientInfo) {
        AppMethodBeat.i(102432);
        if (clientInfo != null) {
            try {
                SQLiteDatabase writableDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
                if (update(clientInfo, writableDatabase) <= 0) {
                    ContentValues contentValues = new ContentValues();
                    fillValues(contentValues, clientInfo);
                    writableDatabase.insert(TABLE_NAME, null, contentValues);
                }
                AppMethodBeat.o(102432);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102432);
    }

    public static void save(String str, String str2) {
        AppMethodBeat.i(102433);
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.clientId = str;
        clientInfo.taskUrl = str2;
        save(clientInfo);
        AppMethodBeat.o(102433);
    }

    private static int update(ClientInfo clientInfo, SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(102434);
        if (clientInfo == null) {
            AppMethodBeat.o(102434);
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues();
            fillValues(contentValues, clientInfo);
            int update = sQLiteDatabase.update(TABLE_NAME, contentValues, "clientId = ? and taskUrl = ?", new String[]{clientInfo.clientId, clientInfo.taskUrl});
            if (update > 0) {
                AppMethodBeat.o(102434);
                return update;
            }
            AppMethodBeat.o(102434);
            return 0;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102434);
            return -2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.tencent.tmassistantsdk.storage.model.ClientInfo> query(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 104
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.storage.table.ClientInfoTable.query(java.lang.String):java.util.ArrayList");
    }

    public static void delete(String str, String str2) {
        AppMethodBeat.i(102436);
        if (!(str == null || str2 == null)) {
            try {
                AstSDKDBHelper_V2.getInstance().getWritableDatabase().delete(TABLE_NAME, "clientId = ? and taskUrl = ?", new String[]{str, str2});
                AppMethodBeat.o(102436);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102436);
    }

    public static void deleteItemsByURL(String str) {
        AppMethodBeat.i(102437);
        if (!TextUtils.isEmpty(str)) {
            try {
                AstSDKDBHelper_V2.getInstance().getWritableDatabase().delete(TABLE_NAME, "taskUrl = ?", new String[]{str});
                AppMethodBeat.o(102437);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102437);
    }

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
        return null;
    }

    @Override // com.tencent.tmassistantsdk.storage.table.ITableBase
    public SqliteHelper getHelper() {
        AppMethodBeat.i(102438);
        SqliteHelper instance = AstSDKDBHelper_V2.getInstance();
        AppMethodBeat.o(102438);
        return instance;
    }

    public class Columns {
        public static final String CLIENTID = "clientId";
        public static final String TASKID = "taskId";
        public static final String TASKURL = "taskUrl";

        public Columns() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    @Override // com.tencent.tmassistantsdk.storage.table.ITableBase
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dataMovement(android.database.sqlite.SQLiteDatabase r7, android.database.sqlite.SQLiteDatabase r8) {
        /*
            r6 = this;
            r1 = 0
            r5 = 102439(0x19027, float:1.43548E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            if (r8 == 0) goto L_0x0042
            if (r7 == 0) goto L_0x0042
            r8.beginTransaction()
            java.lang.String r0 = "select * from clientinfo"
            r2 = 0
            android.database.Cursor r1 = r7.rawQuery(r0, r2)     // Catch:{ Exception -> 0x0046 }
            if (r1 == 0) goto L_0x0037
            boolean r0 = r1.moveToFirst()     // Catch:{ Exception -> 0x0046 }
            if (r0 == 0) goto L_0x0037
        L_0x001e:
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ Exception -> 0x0046 }
            r0.<init>()     // Catch:{ Exception -> 0x0046 }
            com.tencent.tmassistantsdk.storage.model.ClientInfo r2 = cursor2object(r1)     // Catch:{ Exception -> 0x0046 }
            fillValues(r0, r2)     // Catch:{ Exception -> 0x0046 }
            java.lang.String r2 = "clientinfo"
            r3 = 0
            r8.insert(r2, r3, r0)     // Catch:{ Exception -> 0x0046 }
            boolean r0 = r1.moveToNext()     // Catch:{ Exception -> 0x0046 }
            if (r0 != 0) goto L_0x001e
        L_0x0037:
            if (r1 == 0) goto L_0x003c
            r1.close()
        L_0x003c:
            r8.setTransactionSuccessful()
            r8.endTransaction()
        L_0x0042:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return
        L_0x0046:
            r0 = move-exception
            java.lang.String r2 = "ClientInfoTable"
            java.lang.String r3 = ""
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0059 }
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(r2, r0, r3, r4)     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x003c
            r1.close()
            goto L_0x003c
        L_0x0059:
            r0 = move-exception
            if (r1 == 0) goto L_0x005f
            r1.close()
        L_0x005f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.storage.table.ClientInfoTable.dataMovement(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase):void");
    }
}
