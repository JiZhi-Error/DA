package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class e extends MAutoStorage<y> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(y.info, "WalletBulletin")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(70612);
        AppMethodBeat.o(70612);
    }

    public e(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, y.info, "WalletBulletin", null);
        this.db = iSQLiteDatabase;
    }
}
