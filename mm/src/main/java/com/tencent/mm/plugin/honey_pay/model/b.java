package com.tencent.mm.plugin.honey_pay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "HoneyPayMsgRecord")};
    private static final String[] jTH = {"*", "rowid"};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(64646);
        AppMethodBeat.o(64646);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "HoneyPayMsgRecord", null);
        this.db = iSQLiteDatabase;
    }
}
