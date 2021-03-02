package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cg;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.storage.ap;
import com.tencent.mm.plugin.finder.storage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;

public final class b extends MAutoStorage<cg> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(g.info, "FinderDraftItem")};
    public static final a vGL = new a((byte) 0);
    public final String TABLE = "FinderDraftItem";
    public final ISQLiteDatabase db;
    private final ArrayList<Integer> vDL;
    public String vGK;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, g.info, "FinderDraftItem", cg.INDEX_CREATE);
        p.h(iSQLiteDatabase, "_db");
        g.a aVar = g.vDm;
        AppMethodBeat.i(252058);
        this.db = iSQLiteDatabase;
        ap.a aVar2 = ap.vFv;
        this.vDL = ap.a.eu(j.listOf((Object) 1));
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        Iterator<Integer> it = this.vDL.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if ((next.intValue() & 1) != 0) {
                arrayList.add(next);
            }
        }
        ap.a aVar3 = ap.vFv;
        this.vGK = ap.a.k(arrayList, "localFlag");
        Log.i("Finder.FinderDraftStorage", "DRAFT " + this.vGK);
        AppMethodBeat.o(252058);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(252059);
        g.a aVar = g.vDm;
        AppMethodBeat.o(252059);
    }

    public final long b(g gVar) {
        AppMethodBeat.i(252056);
        p.h(gVar, "draftItem");
        e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        long a2 = aAh.azQ().a(ar.a.USERINFO_FINDER_FINDERITEM_MAXID_LONG_SYNC, 1);
        e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_FINDER_FINDERITEM_MAXID_LONG_SYNC, Long.valueOf(1 + a2));
        gVar.field_localId = a2;
        Log.i("Finder.FinderDraftStorage", "new draft rowId " + this.db.insert(this.TABLE, ch.COL_LOCALID, gVar.convertTo()) + ' ' + com.tencent.mm.ac.g.bN(gVar) + " localID: " + a2);
        AppMethodBeat.o(252056);
        return a2;
    }

    public static /* synthetic */ boolean a(b bVar, long j2) {
        AppMethodBeat.i(252057);
        if (bVar.db.delete("FinderDraftItem", "localId=?", new String[]{String.valueOf(j2)}) > 0) {
            AppMethodBeat.o(252057);
            return true;
        }
        AppMethodBeat.o(252057);
        return false;
    }
}
