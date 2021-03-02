package com.tencent.mm.plugin.scanner.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class a extends MAutoStorage<com.tencent.mm.plugin.scanner.history.a.a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.scanner.history.a.a.info, "ScanHistoryItem")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(51671);
        AppMethodBeat.o(51671);
    }

    public a(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, com.tencent.mm.plugin.scanner.history.a.a.info, "ScanHistoryItem", null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final Cursor getAll() {
        AppMethodBeat.i(51670);
        Cursor rawQuery = this.db.rawQuery("select * from ScanHistoryItem order by ScanTime desc", null);
        AppMethodBeat.o(51670);
        return rawQuery;
    }
}
