package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class f extends MAutoStorage<e> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(e.iBg, "DynamicMsgCacheData")};
    public static final String[] iBi = new String[0];

    static {
        AppMethodBeat.i(76399);
        AppMethodBeat.o(76399);
    }

    public f(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, e.iBg, "DynamicMsgCacheData", iBi);
    }
}
