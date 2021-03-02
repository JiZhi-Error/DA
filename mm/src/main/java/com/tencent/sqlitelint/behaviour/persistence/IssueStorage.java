package com.tencent.sqlitelint.behaviour.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.ArrayList;
import java.util.List;

public class IssueStorage {
    public static final String COLUMN_ADVICE = "advice";
    public static final String COLUMN_CREATE_TIME = "createTime";
    public static final String COLUMN_DB_PATH = "dbPath";
    public static final String COLUMN_DESC = "desc";
    public static final String COLUMN_DETAIL = "detail";
    public static final String COLUMN_EXT_INFO = "extInfo";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LEVEL = "level";
    public static final String COLUMN_SQL_TIME_COST = "sqlTimeCost";
    public static final String[] DB_VERSION_1_CREATE_INDEX = {String.format("CREATE INDEX IF NOT EXISTS %s ON %s(%s)", "DbLabel_Index", TABLE_NAME, "dbPath"), String.format("CREATE INDEX IF NOT EXISTS %s ON %s(%s,%s)", "DbLabel_CreateTime_Index", TABLE_NAME, "dbPath", "createTime")};
    public static final String DB_VERSION_1_CREATE_SQL = String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT PRIMARY KEY NOT NULL, %s TEXT NOT NULL, %s INTEGER, %s TEXT, %s TEXT, %s TEXT, %s INTEGER, %s TEXT, %s INTEGER)", TABLE_NAME, "id", "dbPath", "level", "desc", "detail", "advice", "createTime", COLUMN_EXT_INFO, "sqlTimeCost");
    public static final String TABLE_NAME = "Issue";
    private static final String TAG = "SQLiteLint.IssueStorage";
    private static SQLiteStatement sInsertAllSqlStatement;

    static {
        AppMethodBeat.i(52921);
        AppMethodBeat.o(52921);
    }

    public static boolean saveIssue(SQLiteLintIssue sQLiteLintIssue) {
        AppMethodBeat.i(52911);
        if (hasIssue(sQLiteLintIssue.id)) {
            SLog.i(TAG, "saveIssue already recorded id=%s", sQLiteLintIssue.id);
            AppMethodBeat.o(52911);
            return false;
        }
        boolean doInsertIssue = doInsertIssue(sQLiteLintIssue);
        AppMethodBeat.o(52911);
        return doInsertIssue;
    }

    public static void saveIssues(List<SQLiteLintIssue> list) {
        AppMethodBeat.i(52912);
        SQLiteLintDbHelper.INSTANCE.getDatabase().beginTransaction();
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                saveIssue(list.get(i2));
            } finally {
                SQLiteLintDbHelper.INSTANCE.getDatabase().endTransaction();
                AppMethodBeat.o(52912);
            }
        }
        SQLiteLintDbHelper.INSTANCE.getDatabase().setTransactionSuccessful();
    }

    public static boolean hasIssue(String str) {
        boolean z = true;
        AppMethodBeat.i(52913);
        Cursor rawQuery = SQLiteLintDbHelper.INSTANCE.getDatabase().rawQuery(String.format("SELECT %s FROM %s WHERE %s='%s' limit 1", "id", TABLE_NAME, "id", str), null);
        try {
            if (rawQuery.getCount() <= 0) {
                z = false;
            }
            return z;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(52913);
        }
    }

    private static boolean doInsertIssue(SQLiteLintIssue sQLiteLintIssue) {
        AppMethodBeat.i(52914);
        SQLiteStatement insertAllSqlStatement = getInsertAllSqlStatement();
        insertAllSqlStatement.bindString(1, sQLiteLintIssue.id);
        insertAllSqlStatement.bindString(2, sQLiteLintIssue.dbPath);
        insertAllSqlStatement.bindLong(3, (long) sQLiteLintIssue.level);
        insertAllSqlStatement.bindString(4, SQLiteLintUtil.nullAsNil(sQLiteLintIssue.desc));
        insertAllSqlStatement.bindString(5, SQLiteLintUtil.nullAsNil(sQLiteLintIssue.detail));
        insertAllSqlStatement.bindString(6, SQLiteLintUtil.nullAsNil(sQLiteLintIssue.advice));
        insertAllSqlStatement.bindLong(7, sQLiteLintIssue.createTime);
        insertAllSqlStatement.bindString(8, sQLiteLintIssue.extInfo);
        insertAllSqlStatement.bindLong(9, sQLiteLintIssue.sqlTimeCost);
        long executeInsert = insertAllSqlStatement.executeInsert();
        SLog.d(TAG, "saveIssue insert ret=%s, id=%s", Long.valueOf(executeInsert), sQLiteLintIssue.id);
        if (executeInsert == -1) {
            SLog.e(TAG, "addIssue failed", new Object[0]);
            AppMethodBeat.o(52914);
            return false;
        }
        AppMethodBeat.o(52914);
        return true;
    }

    public static List<SQLiteLintIssue> getIssueListByDb(String str) {
        AppMethodBeat.i(52915);
        ArrayList arrayList = new ArrayList();
        if (SQLiteLintUtil.isNullOrNil(str)) {
            AppMethodBeat.o(52915);
        } else {
            String format = String.format("SELECT * FROM %s where %s=? ORDER BY %s DESC", TABLE_NAME, "dbPath", "createTime");
            Cursor rawQuery = SQLiteLintDbHelper.INSTANCE.getDatabase().rawQuery(format, new String[]{str});
            while (rawQuery.moveToNext()) {
                try {
                    arrayList.add(issueConvertFromCursor(rawQuery));
                } finally {
                    rawQuery.close();
                    AppMethodBeat.o(52915);
                }
            }
        }
        return arrayList;
    }

    public static List<String> getDbPathList() {
        AppMethodBeat.i(52916);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = SQLiteLintDbHelper.INSTANCE.getDatabase().rawQuery(String.format("SELECT DISTINCT(%s) FROM %s", "dbPath", TABLE_NAME), null);
        while (rawQuery.moveToNext()) {
            try {
                arrayList.add(rawQuery.getString(rawQuery.getColumnIndex("dbPath")));
            } finally {
                rawQuery.close();
                AppMethodBeat.o(52916);
            }
        }
        return arrayList;
    }

    public static long getLastRowId() {
        AppMethodBeat.i(52917);
        Cursor rawQuery = SQLiteLintDbHelper.INSTANCE.getDatabase().rawQuery(String.format("SELECT rowid FROM %s order by rowid desc limit 1", TABLE_NAME), null);
        if (rawQuery != null) {
            try {
                if (rawQuery.getCount() > 0) {
                    rawQuery.moveToFirst();
                    return rawQuery.getLong(0);
                }
            } finally {
                rawQuery.close();
                AppMethodBeat.o(52917);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(52917);
        return -1;
    }

    public static void clearData() {
        AppMethodBeat.i(52918);
        SQLiteLintDbHelper.INSTANCE.getDatabase().execSQL(String.format("delete from %s", TABLE_NAME));
        AppMethodBeat.o(52918);
    }

    private static SQLiteStatement getInsertAllSqlStatement() {
        AppMethodBeat.i(52919);
        if (sInsertAllSqlStatement == null) {
            sInsertAllSqlStatement = SQLiteLintDbHelper.INSTANCE.getDatabase().compileStatement(String.format("INSERT INTO %s VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)", TABLE_NAME));
        }
        SQLiteStatement sQLiteStatement = sInsertAllSqlStatement;
        AppMethodBeat.o(52919);
        return sQLiteStatement;
    }

    private static SQLiteLintIssue issueConvertFromCursor(Cursor cursor) {
        AppMethodBeat.i(52920);
        SQLiteLintIssue sQLiteLintIssue = new SQLiteLintIssue();
        sQLiteLintIssue.id = cursor.getString(cursor.getColumnIndex("id"));
        sQLiteLintIssue.dbPath = cursor.getString(cursor.getColumnIndex("dbPath"));
        sQLiteLintIssue.level = cursor.getInt(cursor.getColumnIndex("level"));
        sQLiteLintIssue.desc = cursor.getString(cursor.getColumnIndex("desc"));
        sQLiteLintIssue.detail = cursor.getString(cursor.getColumnIndex("detail"));
        sQLiteLintIssue.advice = cursor.getString(cursor.getColumnIndex("advice"));
        sQLiteLintIssue.createTime = cursor.getLong(cursor.getColumnIndex("createTime"));
        sQLiteLintIssue.extInfo = cursor.getString(cursor.getColumnIndex(COLUMN_EXT_INFO));
        sQLiteLintIssue.sqlTimeCost = cursor.getLong(cursor.getColumnIndex("sqlTimeCost"));
        AppMethodBeat.o(52920);
        return sQLiteLintIssue;
    }
}
