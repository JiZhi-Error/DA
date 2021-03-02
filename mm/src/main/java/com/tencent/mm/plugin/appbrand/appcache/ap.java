package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class ap extends c<ao> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(ao.iBg, "PushWxaPkgDecryptKeyTable")};

    static {
        AppMethodBeat.i(90566);
        AppMethodBeat.o(90566);
    }

    public ap(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, ao.iBg, "PushWxaPkgDecryptKeyTable", ao.INDEX_CREATE);
    }
}
