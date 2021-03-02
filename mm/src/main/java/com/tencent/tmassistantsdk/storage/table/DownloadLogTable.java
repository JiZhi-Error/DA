package com.tencent.tmassistantsdk.storage.table;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DownloadLogTable extends BaseLogTable {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists downloadLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    protected static final String SQL_INSERT = "INSERT INTO downloadLogData logData = ?";
    public static final String TABLE_NAME = "downloadLogData";
    protected static DownloadLogTable mInstance = null;

    public static synchronized DownloadLogTable getInstance() {
        DownloadLogTable downloadLogTable;
        synchronized (DownloadLogTable.class) {
            AppMethodBeat.i(102449);
            if (mInstance == null) {
                mInstance = new DownloadLogTable();
            }
            downloadLogTable = mInstance;
            AppMethodBeat.o(102449);
        }
        return downloadLogTable;
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
        AppMethodBeat.i(102450);
        String[] strArr = {getCreateTableSQL()};
        AppMethodBeat.o(102450);
        return strArr;
    }
}
