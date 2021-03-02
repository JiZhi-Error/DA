package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class aj extends MAutoStorage<al> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(al.kLR, "PluginCodeUsageLRURecord")};
    final ISQLiteDatabase db;

    public aj(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, al.kLR, "PluginCodeUsageLRURecord", al.INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    static {
        AppMethodBeat.i(44319);
        AppMethodBeat.o(44319);
    }

    public final void aS(String str, int i2) {
        AppMethodBeat.i(44318);
        al alVar = new al();
        alVar.field_appId = str;
        alVar.field_version = i2;
        super.delete(alVar, al.kJX);
        AppMethodBeat.o(44318);
    }
}
