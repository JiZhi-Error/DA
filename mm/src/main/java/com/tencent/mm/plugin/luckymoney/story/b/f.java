package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class f extends MAutoStorage<e> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(e.info, "LuckyMoneyDetailOpenRecord")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(213353);
        AppMethodBeat.o(213353);
    }

    public f(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, e.info, "LuckyMoneyDetailOpenRecord", null);
        this.db = iSQLiteDatabase;
    }
}
