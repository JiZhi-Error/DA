package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class v extends MAutoStorage<u> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(u.info, "LuckyMoneyEnvelopeResource")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(65224);
        AppMethodBeat.o(65224);
    }

    public v(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, u.info, "LuckyMoneyEnvelopeResource", null);
        this.db = iSQLiteDatabase;
    }
}
