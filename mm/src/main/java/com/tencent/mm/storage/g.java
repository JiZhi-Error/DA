package com.tencent.mm.storage;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.List;

public final class g extends MAutoStorage<com.tencent.mm.g.c.g> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(com.tencent.mm.g.c.g.ajs(), "AddContactAntispamTicket")};
    SparseArray<String> NOO = new SparseArray<>();
    private h iFy;

    public static class a extends com.tencent.mm.g.c.g {
        @Override // com.tencent.mm.sdk.storage.IAutoDBItem
        public final IAutoDBItem.MAutoDBInfo getDBInfo() {
            AppMethodBeat.i(152793);
            IAutoDBItem.MAutoDBInfo ajs = com.tencent.mm.g.c.g.ajs();
            AppMethodBeat.o(152793);
            return ajs;
        }
    }

    static {
        AppMethodBeat.i(152799);
        AppMethodBeat.o(152799);
    }

    public g(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, com.tencent.mm.g.c.g.ajs(), "AddContactAntispamTicket", null);
        AppMethodBeat.i(152794);
        this.iFy = (h) iSQLiteDatabase;
        AppMethodBeat.o(152794);
    }

    public final void O(String str, int i2, String str2) {
        AppMethodBeat.i(152795);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(152795);
            return;
        }
        a aVar = new a();
        aVar.field_userName = str;
        aVar.field_scene = i2;
        aVar.field_ticket = str2;
        replace(aVar);
        mP(str, str2);
        AppMethodBeat.o(152795);
    }

    public final void iB(List<com.tencent.mm.g.c.g> list) {
        AppMethodBeat.i(152796);
        if (list.size() == 0) {
            AppMethodBeat.o(152796);
            return;
        }
        long beginTransaction = this.iFy.beginTransaction(Thread.currentThread().getId());
        for (com.tencent.mm.g.c.g gVar : list) {
            replace(gVar);
        }
        this.iFy.endTransaction(beginTransaction);
        AppMethodBeat.o(152796);
    }

    public final void mP(String str, String str2) {
        AppMethodBeat.i(152797);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(152797);
            return;
        }
        this.NOO.put(str.hashCode(), str2);
        AppMethodBeat.o(152797);
    }

    public final String biD(String str) {
        AppMethodBeat.i(152798);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(152798);
            return null;
        }
        String str2 = this.NOO.get(str.hashCode());
        if (!Util.isNullOrNil(str2)) {
            AppMethodBeat.o(152798);
            return str2;
        }
        a aVar = new a();
        aVar.field_userName = str;
        if (get(aVar, "userName")) {
            mP(aVar.field_userName, aVar.field_ticket);
            String str3 = aVar.field_ticket;
            AppMethodBeat.o(152798);
            return str3;
        }
        AppMethodBeat.o(152798);
        return null;
    }
}
