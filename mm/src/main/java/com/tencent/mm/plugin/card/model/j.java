package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class j extends MAutoStorage<i> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(i.info, "CardQrCodeConfi")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(112783);
        AppMethodBeat.o(112783);
    }

    public j(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, i.info, "CardQrCodeConfi", null);
        this.db = iSQLiteDatabase;
    }

    public final i ajl(String str) {
        AppMethodBeat.i(112782);
        i iVar = new i();
        iVar.field_card_id = str;
        if (get(iVar, new String[0])) {
            AppMethodBeat.o(112782);
            return iVar;
        }
        AppMethodBeat.o(112782);
        return null;
    }
}
