package com.tencent.mm.plugin.scanner.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b extends MAutoStorage {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(aj.info, "ScanTranslationResult")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(120862);
        AppMethodBeat.o(120862);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, aj.info, "ScanTranslationResult", null);
        this.db = iSQLiteDatabase;
    }

    public final fx aMG(String str) {
        AppMethodBeat.i(120860);
        aj ajVar = new aj();
        ajVar.field_originMD5 = str;
        if (get(ajVar, new String[0])) {
            AppMethodBeat.o(120860);
            return ajVar;
        }
        AppMethodBeat.o(120860);
        return null;
    }

    public final boolean a(aj ajVar) {
        AppMethodBeat.i(120861);
        if (aMG(ajVar.field_originMD5) != null) {
            boolean replace = replace(ajVar);
            AppMethodBeat.o(120861);
            return replace;
        }
        boolean insert = super.insert(ajVar);
        AppMethodBeat.o(120861);
        return insert;
    }
}
