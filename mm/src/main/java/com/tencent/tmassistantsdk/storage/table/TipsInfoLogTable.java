package com.tencent.tmassistantsdk.storage.table;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TipsInfoLogTable extends BaseLogTable {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists TipsInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    protected static final String SQL_INSERT = "INSERT INTO TipsInfoLogData logData = ?";
    public static final String TABLE_NAME = "TipsInfoLogData";
    protected static TipsInfoLogTable mInstance = null;

    public static synchronized TipsInfoLogTable getInstance() {
        TipsInfoLogTable tipsInfoLogTable;
        synchronized (TipsInfoLogTable.class) {
            AppMethodBeat.i(102455);
            if (mInstance == null) {
                mInstance = new TipsInfoLogTable();
            }
            tipsInfoLogTable = mInstance;
            AppMethodBeat.o(102455);
        }
        return tipsInfoLogTable;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.storage.table.BaseLogTable
    public String getTableName() {
        return TABLE_NAME;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.storage.table.BaseLogTable
    public String getCreateTableSQL() {
        return CREATE_TABLE_SQL;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.storage.table.BaseLogTable
    public String getInsertSQL() {
        return SQL_INSERT;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.storage.table.BaseLogTable
    public String[] getAlterSQL(int i2) {
        AppMethodBeat.i(102456);
        if (i2 > 1) {
            String[] strArr = {getCreateTableSQL()};
            AppMethodBeat.o(102456);
            return strArr;
        }
        AppMethodBeat.o(102456);
        return null;
    }
}
