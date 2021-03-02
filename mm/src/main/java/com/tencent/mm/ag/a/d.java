package com.tencent.mm.ag.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class d extends MAutoStorage<c> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(c.iBg, "WxaUpdateableMsg")};
    public static final String[] iBi = new String[0];

    static {
        AppMethodBeat.i(2617);
        AppMethodBeat.o(2617);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.iBg, "WxaUpdateableMsg", iBi);
    }
}
