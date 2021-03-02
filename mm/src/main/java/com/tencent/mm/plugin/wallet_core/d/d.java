package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d extends MAutoStorage<Bankcard> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(Bankcard.info, "WalletBankcard")};
    public ISQLiteDatabase db;
    private List<Object> listeners = new LinkedList();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(Bankcard bankcard, String[] strArr) {
        AppMethodBeat.i(70609);
        if (super.delete(bankcard, strArr)) {
            Iterator<Object> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(70609);
            return true;
        }
        AppMethodBeat.o(70609);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(Bankcard bankcard) {
        AppMethodBeat.i(70610);
        boolean g2 = g(bankcard);
        AppMethodBeat.o(70610);
        return g2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(Bankcard bankcard, String[] strArr) {
        AppMethodBeat.i(70608);
        if (super.update(bankcard, strArr)) {
            Iterator<Object> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(70608);
            return true;
        }
        AppMethodBeat.o(70608);
        return false;
    }

    static {
        AppMethodBeat.i(70611);
        AppMethodBeat.o(70611);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, Bankcard.info, "WalletBankcard", null);
        AppMethodBeat.i(70600);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(70600);
    }

    public final ArrayList<Bankcard> fRE() {
        ArrayList<Bankcard> arrayList = null;
        AppMethodBeat.i(70601);
        Cursor rawQuery = this.db.rawQuery("select * from WalletBankcard where cardType <= 7 OR cardType & " + Bankcard.HVv + " != 0", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(70601);
        } else {
            if (rawQuery.moveToFirst()) {
                arrayList = new ArrayList<>();
                do {
                    Bankcard bankcard = new Bankcard();
                    bankcard.convertFrom(rawQuery);
                    arrayList.add(bankcard);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.o(70601);
        }
        return arrayList;
    }

    public final Bankcard fSo() {
        Bankcard bankcard = null;
        AppMethodBeat.i(70602);
        Cursor rawQuery = this.db.rawQuery("select * from WalletBankcard where cardType & " + Bankcard.HVr + " != 0 ", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(70602);
        } else {
            if (rawQuery.moveToFirst()) {
                bankcard = new Bankcard();
                bankcard.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(70602);
        }
        return bankcard;
    }

    public final Bankcard fSp() {
        Bankcard bankcard = null;
        AppMethodBeat.i(70603);
        Cursor rawQuery = this.db.rawQuery("select * from WalletBankcard where cardType & " + Bankcard.HVu + " != 0 ", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(70603);
        } else {
            if (rawQuery.moveToFirst()) {
                bankcard = new Bankcard();
                bankcard.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(70603);
        }
        return bankcard;
    }

    public final ArrayList<Bankcard> fSq() {
        ArrayList<Bankcard> arrayList = null;
        AppMethodBeat.i(70604);
        Cursor rawQuery = this.db.rawQuery("select * from WalletBankcard where cardType & " + Bankcard.HVq + " != 0 ", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(70604);
        } else {
            if (rawQuery.moveToFirst()) {
                arrayList = new ArrayList<>();
                do {
                    Bankcard bankcard = new Bankcard();
                    bankcard.convertFrom(rawQuery);
                    arrayList.add(bankcard);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.o(70604);
        }
        return arrayList;
    }

    public final Bankcard fSr() {
        Bankcard bankcard = null;
        AppMethodBeat.i(70605);
        Cursor rawQuery = this.db.rawQuery("select * from WalletBankcard where cardType & " + Bankcard.HVs + " != 0 ", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(70605);
        } else {
            if (rawQuery.moveToNext()) {
                bankcard = new Bankcard();
                bankcard.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(70605);
        }
        return bankcard;
    }

    public final boolean ib(List<Bankcard> list) {
        AppMethodBeat.i(70606);
        for (Bankcard bankcard : list) {
            super.insert(bankcard);
        }
        Iterator<Object> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(70606);
        return true;
    }

    public final boolean g(Bankcard bankcard) {
        AppMethodBeat.i(70607);
        if (super.insert(bankcard)) {
            Iterator<Object> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(70607);
            return true;
        }
        AppMethodBeat.o(70607);
        return false;
    }
}
