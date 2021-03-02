package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class a extends MAutoStorage<n> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(n.info, "LoanEntryInfo")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(70581);
        AppMethodBeat.o(70581);
    }

    public a(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, n.info, "LoanEntryInfo", null);
        this.db = iSQLiteDatabase;
    }

    public final n fSm() {
        n nVar = null;
        AppMethodBeat.i(70579);
        Cursor rawQuery = this.db.rawQuery("select * from LoanEntryInfo", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(70579);
        } else {
            if (rawQuery.moveToFirst()) {
                nVar = new n();
                nVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(70579);
        }
        return nVar;
    }

    public final boolean bnU() {
        AppMethodBeat.i(70580);
        boolean execSQL = this.db.execSQL("LoanEntryInfo", "delete from LoanEntryInfo");
        AppMethodBeat.o(70580);
        return execSQL;
    }
}
