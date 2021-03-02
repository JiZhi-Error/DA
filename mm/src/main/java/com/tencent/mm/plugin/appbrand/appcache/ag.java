package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ag extends MAutoStorage<af> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(af.kLR, "PkgUpdateStats")};

    public ag(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, af.kLR, "PkgUpdateStats", af.INDEX_CREATE);
    }

    static {
        AppMethodBeat.i(44314);
        AppMethodBeat.o(44314);
    }
}
