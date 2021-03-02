package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ai extends MAutoStorage<ah> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(ah.kLR, "PkgUsageLRURecord")};
    final ISQLiteDatabase db;

    public ai(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, ah.kLR, "PkgUsageLRURecord", ah.INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    static {
        AppMethodBeat.i(44317);
        AppMethodBeat.o(44317);
    }

    public final void aS(String str, int i2) {
        AppMethodBeat.i(44316);
        ah ahVar = new ah();
        ahVar.field_appId = str;
        ahVar.field_type = i2;
        super.delete(ahVar, ah.kJX);
        AppMethodBeat.o(44316);
    }
}
