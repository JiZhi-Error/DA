package com.tencent.mm.plugin.shake.d.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class o extends MAutoStorage<n> {
    public static final String[] INDEX_CREATE = new String[0];
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(n.info, "shaketvhistory")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(28349);
        AppMethodBeat.o(28349);
    }

    public o(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, n.info, "shaketvhistory", SQL_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final Cursor eUR() {
        AppMethodBeat.i(28348);
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM shaketvhistory ORDER BY createtime DESC", null);
        AppMethodBeat.o(28348);
        return rawQuery;
    }
}
