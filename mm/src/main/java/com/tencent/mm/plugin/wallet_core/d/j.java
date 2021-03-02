package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class j extends MAutoStorage<aj> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(aj.info, "WalletRegionGreyAreaList")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(70626);
        AppMethodBeat.o(70626);
    }

    public j(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, aj.info, "WalletRegionGreyAreaList", null);
        this.db = iSQLiteDatabase;
    }

    public final void a(int i2, daf daf) {
        AppMethodBeat.i(70624);
        aj ajVar = new aj();
        ajVar.field_wallet_region = i2;
        try {
            ajVar.field_wallet_grey_item_buf = daf.toByteArray();
        } catch (Exception e2) {
            Log.e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + e2.getMessage());
        }
        super.replace(ajVar);
        AppMethodBeat.o(70624);
    }

    public final aj aeO(int i2) {
        AppMethodBeat.i(70625);
        String concat = "select * from WalletRegionGreyAreaList where wallet_region = ".concat(String.valueOf(i2));
        Cursor rawQuery = this.db.rawQuery(concat, null, 2);
        Log.i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem ".concat(String.valueOf(concat)));
        if (rawQuery == null) {
            aj ajVar = new aj();
            AppMethodBeat.o(70625);
            return ajVar;
        }
        aj ajVar2 = new aj();
        if (rawQuery.moveToNext()) {
            ajVar2 = new aj();
            ajVar2.convertFrom(rawQuery);
        }
        Log.i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
        rawQuery.close();
        AppMethodBeat.o(70625);
        return ajVar2;
    }
}
