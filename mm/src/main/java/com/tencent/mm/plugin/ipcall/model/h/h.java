package com.tencent.mm.plugin.ipcall.model.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class h extends MAutoStorage<g> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(g.info, "IPCallMsg")};
    private static final String[] ysI = {"*", "rowid"};
    public static int ysJ = 0;
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(25550);
        AppMethodBeat.o(25550);
    }

    public h(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, g.info, "IPCallMsg", null);
        this.db = iSQLiteDatabase;
    }

    public final Cursor Pf(int i2) {
        AppMethodBeat.i(25549);
        Cursor query = this.db.query("IPCallMsg", ysI, null, null, null, null, "pushTime desc limit ".concat(String.valueOf(i2)));
        AppMethodBeat.o(25549);
        return query;
    }
}
