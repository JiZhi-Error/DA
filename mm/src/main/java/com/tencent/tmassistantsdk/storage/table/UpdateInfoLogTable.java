package com.tencent.tmassistantsdk.storage.table;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class UpdateInfoLogTable extends BaseLogTable {
    private static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists SelfUpdateInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    private static final String INSERT_SQL = "INSERT INTO SelfUpdateInfoLogData logData = ?";
    private static final String TABLE_NAME = "SelfUpdateInfoLogData";
    private static UpdateInfoLogTable mInstance = null;

    public static synchronized UpdateInfoLogTable getInstance() {
        UpdateInfoLogTable updateInfoLogTable;
        synchronized (UpdateInfoLogTable.class) {
            AppMethodBeat.i(102457);
            if (mInstance == null) {
                mInstance = new UpdateInfoLogTable();
            }
            updateInfoLogTable = mInstance;
            AppMethodBeat.o(102457);
        }
        return updateInfoLogTable;
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
        return INSERT_SQL;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tmassistantsdk.storage.table.BaseLogTable
    public String[] getAlterSQL(int i2) {
        AppMethodBeat.i(102458);
        if (i2 > 1) {
            String[] strArr = {getCreateTableSQL()};
            AppMethodBeat.o(102458);
            return strArr;
        }
        AppMethodBeat.o(102458);
        return null;
    }
}
