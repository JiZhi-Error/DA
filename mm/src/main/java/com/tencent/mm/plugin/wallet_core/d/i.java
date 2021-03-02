package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class i extends MAutoStorage<ag> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(ag.info, "WalletPrefInfo")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(70623);
        AppMethodBeat.o(70623);
    }

    public i(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, ag.info, "WalletPrefInfo", null);
        this.db = iSQLiteDatabase;
    }

    public final ag aVD(String str) {
        ag agVar = null;
        AppMethodBeat.i(70621);
        if (!Util.isNullOrNil(str)) {
            Cursor rawQuery = this.db.rawQuery("select * from WalletPrefInfo where pref_key=?", new String[]{str}, 2);
            if (rawQuery == null) {
                AppMethodBeat.o(70621);
            } else {
                if (rawQuery.moveToFirst()) {
                    agVar = new ag();
                    agVar.convertFrom(rawQuery);
                }
                rawQuery.close();
                AppMethodBeat.o(70621);
            }
        } else {
            AppMethodBeat.o(70621);
        }
        return agVar;
    }

    public final boolean aVE(String str) {
        AppMethodBeat.i(70622);
        if (!Util.isNullOrNil(str)) {
            boolean execSQL = this.db.execSQL("WalletPrefInfo", "delete from WalletPrefInfo where pref_key='" + str + "'");
            AppMethodBeat.o(70622);
            return execSQL;
        }
        AppMethodBeat.o(70622);
        return false;
    }
}
