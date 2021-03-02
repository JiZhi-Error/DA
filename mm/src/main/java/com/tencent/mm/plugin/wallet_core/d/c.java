package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.BankcardScene;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends MAutoStorage<BankcardScene> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(BankcardScene.info, "WalletBankcardScene")};
    public ISQLiteDatabase db;
    private List<Object> listeners = new LinkedList();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(BankcardScene bankcardScene, String[] strArr) {
        AppMethodBeat.i(70597);
        if (super.delete(bankcardScene, strArr)) {
            Iterator<Object> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(70597);
            return true;
        }
        AppMethodBeat.o(70597);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(BankcardScene bankcardScene) {
        AppMethodBeat.i(70598);
        boolean a2 = a(bankcardScene);
        AppMethodBeat.o(70598);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(BankcardScene bankcardScene, String[] strArr) {
        AppMethodBeat.i(70596);
        if (super.update(bankcardScene, strArr)) {
            Iterator<Object> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(70596);
            return true;
        }
        AppMethodBeat.o(70596);
        return false;
    }

    static {
        AppMethodBeat.i(70599);
        AppMethodBeat.o(70599);
    }

    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, BankcardScene.info, "WalletBankcardScene", null);
        AppMethodBeat.i(70591);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(70591);
    }

    public final boolean ib(List<BankcardScene> list) {
        AppMethodBeat.i(70592);
        for (BankcardScene bankcardScene : list) {
            super.insert(bankcardScene);
        }
        Iterator<Object> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(70592);
        return true;
    }

    public final boolean a(BankcardScene bankcardScene) {
        AppMethodBeat.i(70593);
        if (super.insert(bankcardScene)) {
            Iterator<Object> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(70593);
            return true;
        }
        AppMethodBeat.o(70593);
        return false;
    }

    public final boolean bnU() {
        AppMethodBeat.i(70594);
        boolean execSQL = this.db.execSQL("WalletBankcardScene", "delete from WalletBankcardScene");
        AppMethodBeat.o(70594);
        return execSQL;
    }

    public final boolean aeN(int i2) {
        AppMethodBeat.i(70595);
        boolean execSQL = this.db.execSQL("WalletBankcardScene", "delete from WalletBankcardScene where scene=".concat(String.valueOf(i2)));
        AppMethodBeat.o(70595);
        return execSQL;
    }
}
