package com.tencent.mm.plugin.selectrecord.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;

public final class b extends MAutoStorage<a> {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS SelectRecord_historyIdIndex ON SelectRecord ( historyId )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "SelectRecord")};
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(a aVar) {
        AppMethodBeat.i(187926);
        boolean a2 = a(aVar);
        AppMethodBeat.o(187926);
        return a2;
    }

    static {
        AppMethodBeat.i(187927);
        AppMethodBeat.o(187927);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "SelectRecord", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(187924);
        if (aVar == null) {
            AppMethodBeat.o(187924);
            return false;
        }
        boolean insert = super.insert(aVar);
        AppMethodBeat.o(187924);
        return insert;
    }

    public final ca aNb(String str) {
        AppMethodBeat.i(187925);
        ca caVar = new ca();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(187925);
            return caVar;
        }
        Cursor query = this.db.query("SelectRecord", a.info.columns, "historyId=?", new String[]{str}, null, null, null, 2);
        if (query == null) {
            AppMethodBeat.o(187925);
            return caVar;
        }
        try {
            ArrayList arrayList = new ArrayList();
            while (query.moveToNext()) {
                a aVar = new a();
                aVar.convertFrom(query);
                arrayList.add(aVar);
            }
            if (arrayList.size() == 0) {
                return caVar;
            }
            ca Hb = ((l) g.af(l.class)).eiy().Hb(((a) arrayList.get(0)).field_msgId);
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(187925);
            return Hb;
        } finally {
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(187925);
        }
    }
}
