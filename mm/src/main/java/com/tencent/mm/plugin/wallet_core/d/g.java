package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;

public final class g extends MAutoStorage<ad> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(ad.info, "WalletKindInfo")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(70616);
        AppMethodBeat.o(70616);
    }

    public g(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, ad.info, "WalletKindInfo", null);
        this.db = iSQLiteDatabase;
    }

    public final ArrayList<ad> fSs() {
        ArrayList<ad> arrayList = null;
        AppMethodBeat.i(70615);
        Cursor rawQuery = this.db.rawQuery("select * from WalletKindInfo", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(70615);
        } else {
            if (rawQuery.moveToFirst()) {
                arrayList = new ArrayList<>();
                do {
                    ad adVar = new ad();
                    adVar.convertFrom(rawQuery);
                    arrayList.add(adVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.o(70615);
        }
        return arrayList;
    }
}
