package com.tencent.mm.plugin.account.security.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;

public final class e extends MAutoStorage<d> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(d.info, "SafeDeviceInfo")};
    h kiO = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* bridge */ /* synthetic */ boolean insert(d dVar) {
        AppMethodBeat.i(125525);
        boolean insert = super.insert(dVar);
        AppMethodBeat.o(125525);
        return insert;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* bridge */ /* synthetic */ boolean replace(d dVar) {
        AppMethodBeat.i(125524);
        boolean replace = super.replace(dVar);
        AppMethodBeat.o(125524);
        return replace;
    }

    static {
        AppMethodBeat.i(125526);
        AppMethodBeat.o(125526);
    }

    public e(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, d.info, "SafeDeviceInfo", null);
        AppMethodBeat.i(125521);
        if (iSQLiteDatabase instanceof h) {
            this.kiO = (h) iSQLiteDatabase;
        }
        AppMethodBeat.o(125521);
    }

    public final boolean a(d dVar) {
        AppMethodBeat.i(125522);
        boolean insert = super.insert(dVar);
        AppMethodBeat.o(125522);
        return insert;
    }

    public final List<d> boO() {
        AppMethodBeat.i(125523);
        LinkedList linkedList = new LinkedList();
        if (getCount() > 0) {
            Cursor all = super.getAll();
            while (all.moveToNext()) {
                d dVar = new d();
                dVar.convertFrom(all);
                linkedList.add(dVar);
            }
            all.close();
        }
        AppMethodBeat.o(125523);
        return linkedList;
    }
}
