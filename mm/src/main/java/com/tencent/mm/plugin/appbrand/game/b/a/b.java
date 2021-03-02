package com.tencent.mm.plugin.appbrand.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;

public final class b extends MAutoStorage<a> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(a.info, "WxagGameInfo")};
    private final boolean lsb;

    static {
        AppMethodBeat.i(45098);
        AppMethodBeat.o(45098);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "WxagGameInfo", null);
        AppMethodBeat.i(45096);
        this.lsb = iSQLiteDatabase != null;
        if (!this.lsb) {
            Log.e("MicroMsg.MiniGameInfoStorage", "storage can not work!!!");
        }
        AppMethodBeat.o(45096);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public final void add(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(45097);
        add("MicroMsg.MiniGameInfoStorage.WORKER", iOnStorageChange);
        AppMethodBeat.o(45097);
    }
}
