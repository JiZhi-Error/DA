package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k extends MAutoStorage<am> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(am.info, "WalletUserInfo")};
    private ISQLiteDatabase db;
    private List<Object> listeners = new LinkedList();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(am amVar, String[] strArr) {
        AppMethodBeat.i(70632);
        if (super.delete(amVar, strArr)) {
            Iterator<Object> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(70632);
            return true;
        }
        AppMethodBeat.o(70632);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(am amVar) {
        AppMethodBeat.i(70633);
        boolean b2 = b(amVar);
        AppMethodBeat.o(70633);
        return b2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(am amVar, String[] strArr) {
        AppMethodBeat.i(70631);
        if (super.update(amVar, strArr)) {
            Iterator<Object> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(70631);
            return true;
        }
        AppMethodBeat.o(70631);
        return false;
    }

    static {
        AppMethodBeat.i(70634);
        AppMethodBeat.o(70634);
    }

    public k(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, am.info, "WalletUserInfo", null);
        AppMethodBeat.i(70627);
        Log.i("MicroMsg.WalletUserInfoStorage", "already call constructor.");
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(70627);
    }

    public final am fRN() {
        AppMethodBeat.i(70628);
        am amVar = new am();
        Cursor rawQuery = this.db.rawQuery("select * from WalletUserInfo", null, 2);
        amVar.field_is_reg = -1;
        if (rawQuery == null) {
            AppMethodBeat.o(70628);
        } else {
            if (rawQuery.moveToNext()) {
                amVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(70628);
        }
        return amVar;
    }

    public final boolean b(am amVar) {
        AppMethodBeat.i(70629);
        if (super.insert(amVar)) {
            Iterator<Object> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(70629);
            return true;
        }
        AppMethodBeat.o(70629);
        return false;
    }

    public final boolean bnU() {
        AppMethodBeat.i(70630);
        boolean execSQL = this.db.execSQL("WalletUserInfo", "delete from WalletUserInfo");
        AppMethodBeat.o(70630);
        return execSQL;
    }
}
