package com.tencent.mm.plugin.welab.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class a extends MAutoStorage<com.tencent.mm.plugin.welab.d.a.a> {
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(com.tencent.mm.plugin.welab.d.a.a aVar) {
        AppMethodBeat.i(146254);
        boolean d2 = d(aVar);
        AppMethodBeat.o(146254);
        return d2;
    }

    public a(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, com.tencent.mm.plugin.welab.d.a.a.info, "LabAppInfo", null);
        this.db = iSQLiteDatabase;
    }

    public final List<com.tencent.mm.plugin.welab.d.a.a> gjn() {
        AppMethodBeat.i(146250);
        Cursor all = getAll();
        ArrayList arrayList = new ArrayList();
        while (all.moveToNext()) {
            com.tencent.mm.plugin.welab.d.a.a aVar = new com.tencent.mm.plugin.welab.d.a.a();
            aVar.convertFrom(all);
            arrayList.add(aVar);
        }
        all.close();
        AppMethodBeat.o(146250);
        return arrayList;
    }

    public final void ip(List<com.tencent.mm.plugin.welab.d.a.a> list) {
        long j2;
        AppMethodBeat.i(146251);
        h hVar = null;
        if (this.db instanceof h) {
            h hVar2 = (h) this.db;
            j2 = hVar2.beginTransaction(-1);
            hVar = hVar2;
        } else {
            j2 = 0;
        }
        for (com.tencent.mm.plugin.welab.d.a.a aVar : list) {
            c(aVar);
        }
        if (hVar != null) {
            hVar.endTransaction(j2);
        }
        AppMethodBeat.o(146251);
    }

    public final void c(com.tencent.mm.plugin.welab.d.a.a aVar) {
        AppMethodBeat.i(146252);
        if (!d(aVar)) {
            insert(aVar);
        }
        AppMethodBeat.o(146252);
    }

    private boolean d(com.tencent.mm.plugin.welab.d.a.a aVar) {
        AppMethodBeat.i(146253);
        com.tencent.mm.plugin.welab.d.a.a aVar2 = new com.tencent.mm.plugin.welab.d.a.a();
        aVar2.field_LabsAppId = aVar.field_LabsAppId;
        get(aVar2, new String[0]);
        if (aVar.field_expId != aVar2.field_expId || aVar.field_sequence >= aVar2.field_sequence) {
            boolean replace = super.replace(aVar);
            AppMethodBeat.o(146253);
            return replace;
        }
        Log.i("LabAppInfoStorage", "sequence old origin.seq " + aVar2.field_sequence + " old.seq " + aVar.field_sequence);
        AppMethodBeat.o(146253);
        return false;
    }
}
