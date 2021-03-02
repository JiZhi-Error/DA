package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import java.util.List;

public abstract class BaseLogTable implements ITableBase {
    private static final String TAG = "BaseLogTable";

    public static class DataWrapper {
        public List<byte[]> dataList;
        public List<Long> idList;
    }

    /* access modifiers changed from: protected */
    public abstract String[] getAlterSQL(int i2);

    /* access modifiers changed from: protected */
    public abstract String getCreateTableSQL();

    /* access modifiers changed from: protected */
    public abstract String getInsertSQL();

    /* access modifiers changed from: protected */
    public abstract String getTableName();

    public boolean save(byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("logData", bArr);
        return getHelper().getWritableDatabase().insert(getTableName(), null, contentValues) > 0;
    }

    public boolean save(List<byte[]> list) {
        SQLiteDatabase writableDatabase = getHelper().getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            SQLiteStatement compileStatement = writableDatabase.compileStatement(getInsertSQL());
            for (byte[] bArr : list) {
                compileStatement.bindBlob(1, bArr);
                compileStatement.executeInsert();
            }
            writableDatabase.setTransactionSuccessful();
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            return false;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public boolean delete(List<Long> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer("(");
        for (Long l : list) {
            stringBuffer.append(l);
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        stringBuffer.append(")");
        getHelper().getWritableDatabase().delete(getTableName(), "_id in ".concat(String.valueOf(stringBuffer)), null);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.tmassistantsdk.storage.table.BaseLogTable.DataWrapper getDatas(int r12) {
        /*
        // Method dump skipped, instructions count: 148
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.storage.table.BaseLogTable.getDatas(int):com.tencent.tmassistantsdk.storage.table.BaseLogTable$DataWrapper");
    }

    @Override // com.tencent.tmassistantsdk.storage.table.ITableBase
    public String tableName() {
        return getTableName();
    }

    @Override // com.tencent.tmassistantsdk.storage.table.ITableBase
    public String createTableSQL() {
        return getCreateTableSQL();
    }

    @Override // com.tencent.tmassistantsdk.storage.table.ITableBase
    public String[] getAlterSQL(int i2, int i3) {
        return getAlterSQL(i3);
    }

    @Override // com.tencent.tmassistantsdk.storage.table.ITableBase
    public SqliteHelper getHelper() {
        return AstSDKDBHelper_V2.getInstance();
    }

    @Override // com.tencent.tmassistantsdk.storage.table.ITableBase
    public void dataMovement(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
    }
}
