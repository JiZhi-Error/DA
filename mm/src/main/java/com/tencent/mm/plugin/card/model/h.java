package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class h extends MAutoStorage<g> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(g.info, "CardMsgInfo")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(112780);
        AppMethodBeat.o(112780);
    }

    public h(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, g.info, "CardMsgInfo", null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final Cursor getAll() {
        AppMethodBeat.i(112777);
        Cursor rawQuery = this.db.rawQuery("select * from CardMsgInfo order by time desc", null);
        AppMethodBeat.o(112777);
        return rawQuery;
    }

    public final int ctM() {
        int i2 = 0;
        AppMethodBeat.i(112778);
        Cursor rawQuery = this.db.rawQuery(" select count(*) from CardMsgInfo where read_state = ? ", new String[]{"1"}, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(112778);
        } else {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.o(112778);
        }
        return i2;
    }

    public final boolean ctN() {
        AppMethodBeat.i(112779);
        boolean execSQL = this.db.execSQL("CardMsgInfo", " update CardMsgInfo set read_state = 0  where read_state = 1");
        AppMethodBeat.o(112779);
        return execSQL;
    }
}
