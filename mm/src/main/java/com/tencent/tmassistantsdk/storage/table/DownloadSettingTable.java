package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import java.util.HashMap;

public class DownloadSettingTable implements ITableBase {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists settingInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, settingField TEXT , value TEXT,type TEXT);";
    public static final String QUERY_SQL = "select * from settingInfo";
    public static final String TABLE_NAME = "settingInfo";
    private static final String TAG = "DownloadSettingTable";

    public static void save(String str, String str2, String str3) {
        AppMethodBeat.i(102451);
        if (!(str == null || str2 == null)) {
            try {
                SQLiteDatabase writableDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
                if (update(str, str2, str3, writableDatabase) <= 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Columns.SETTINGFIELD, str);
                    contentValues.put("value", str2);
                    contentValues.put("type", str3);
                    writableDatabase.insert(TABLE_NAME, null, contentValues);
                }
                AppMethodBeat.o(102451);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102451);
    }

    private static int update(String str, String str2, String str3, SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(102452);
        if (str == null || str2 == null) {
            AppMethodBeat.o(102452);
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Columns.SETTINGFIELD, str);
            contentValues.put("value", str2);
            contentValues.put("type", str3);
            int update = sQLiteDatabase.update(TABLE_NAME, contentValues, "settingField = ?", new String[]{str});
            if (update > 0) {
                return update;
            }
            AppMethodBeat.o(102452);
            return 0;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            return -2;
        } finally {
            AppMethodBeat.o(102452);
        }
    }

    public static HashMap<String, String> query() {
        Cursor cursor = null;
        AppMethodBeat.i(102453);
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Cursor rawQuery = AstSDKDBHelper_V2.getInstance().getReadableDatabase().rawQuery(QUERY_SQL, null);
            if (rawQuery == null || !rawQuery.moveToFirst()) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(102453);
                return hashMap;
            }
            do {
                hashMap.put(rawQuery.getString(rawQuery.getColumnIndex(Columns.SETTINGFIELD)), rawQuery.getString(rawQuery.getColumnIndex("value")));
            } while (rawQuery.moveToNext());
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.o(102453);
            return hashMap;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(102453);
            throw th;
        }
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
        AppMethodBeat.i(102454);
        SqliteHelper instance = AstSDKDBHelper_V2.getInstance();
        AppMethodBeat.o(102454);
        return instance;
    }

    public class Columns {
        public static final String SETTINGFIELD = "settingField";
        public static final String TYPE = "type";
        public static final String VALUE = "value";

        public Columns() {
        }
    }

    @Override // com.tencent.tmassistantsdk.storage.table.ITableBase
    public void dataMovement(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
    }
}
