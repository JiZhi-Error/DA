package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class d extends com.tencent.mm.plugin.fts.a.b {
    private m hgI;
    com.tencent.mm.plugin.fts.c.d wZl;

    @Override // com.tencent.mm.plugin.fts.a.k
    public final String getName() {
        return "FTS5SearchSOSHistoryLogic";
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean onCreate() {
        AppMethodBeat.i(52746);
        if (!((n) g.ah(n.class)).isFTSContextReady()) {
            Log.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Fail!");
            AppMethodBeat.o(52746);
            return false;
        }
        Log.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Success!");
        this.wZl = (com.tencent.mm.plugin.fts.c.d) ((n) g.ah(n.class)).getFTSIndexStorage(1024);
        this.hgI = ((n) g.ah(n.class)).getFTSTaskDaemon();
        AppMethodBeat.o(52746);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.k, com.tencent.mm.plugin.fts.a.b
    public final void addSOSHistory(String str, String str2) {
        AppMethodBeat.i(52747);
        a aVar = new a();
        aVar.key = str;
        aVar.content = str2;
        aVar.timestamp = System.currentTimeMillis();
        if (this.hgI != null) {
            this.hgI.a(132072, aVar);
        }
        AppMethodBeat.o(52747);
    }

    @Override // com.tencent.mm.plugin.fts.a.k, com.tencent.mm.plugin.fts.a.b
    public final void deleteSOSHistory() {
        AppMethodBeat.i(52748);
        b bVar = new b();
        if (this.hgI != null) {
            this.hgI.a(132072, bVar);
        }
        AppMethodBeat.o(52748);
    }

    @Override // com.tencent.mm.plugin.fts.a.k, com.tencent.mm.plugin.fts.a.b
    public final void deleteSOSHistory(String str) {
        AppMethodBeat.i(52749);
        c cVar = new c();
        cVar.key = str;
        if (this.hgI != null) {
            this.hgI.a(132072, cVar);
        }
        AppMethodBeat.o(52749);
    }

    @Override // com.tencent.mm.plugin.fts.a.k, com.tencent.mm.plugin.fts.a.b
    public final com.tencent.mm.plugin.fts.a.a.a a(j jVar) {
        AppMethodBeat.i(52750);
        C1378d dVar = new C1378d(jVar);
        this.hgI.a(-65536, dVar);
        AppMethodBeat.o(52750);
        return dVar;
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.d$d  reason: collision with other inner class name */
    public class C1378d extends i {
        public C1378d(j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(k kVar) {
            AppMethodBeat.i(52745);
            super.a(kVar);
            kVar.wXb = new ArrayList();
            com.tencent.mm.plugin.fts.c.d dVar = d.this.wZl;
            Cursor rawQuery = dVar.wUt.rawQuery(String.format("SELECT content, timestamp FROM %s ORDER BY timestamp desc LIMIT ".concat(String.valueOf(this.wWO.wWW)), com.tencent.mm.plugin.fts.c.d.dOt()), null);
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(0);
                com.tencent.mm.plugin.fts.a.a.n nVar = new com.tencent.mm.plugin.fts.a.a.n();
                nVar.content = string;
                kVar.wXb.add(nVar);
            }
            rawQuery.close();
            kVar.resultCode = 0;
            AppMethodBeat.o(52745);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchSOSHistoryTask";
        }
    }

    public class a extends com.tencent.mm.plugin.fts.a.a.a {
        public String content;
        public String key;
        public long timestamp;

        public a() {
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52742);
            com.tencent.mm.plugin.fts.c.d dVar = d.this.wZl;
            String str = this.key;
            long j2 = this.timestamp;
            String str2 = this.content;
            dVar.wUv.bindString(1, str);
            dVar.wUv.bindLong(2, j2);
            dVar.wUv.bindString(3, str2);
            dVar.wUv.execute();
            AppMethodBeat.o(52742);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "AddSOSHistoryTask";
        }
    }

    public class c extends com.tencent.mm.plugin.fts.a.a.a {
        public String key;

        public c() {
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52744);
            com.tencent.mm.plugin.fts.c.d dVar = d.this.wZl;
            String str = this.key;
            String format = String.format("DELETE FROM %s WHERE key = ?", com.tencent.mm.plugin.fts.c.d.dOt());
            dVar.wUt.execSQL(format, new String[]{str});
            AppMethodBeat.o(52744);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "DeleteSOSHistoryTask";
        }
    }

    public class b extends com.tencent.mm.plugin.fts.a.a.a {
        public b() {
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52743);
            com.tencent.mm.plugin.fts.c.d dVar = d.this.wZl;
            dVar.wUt.execSQL(String.format("DELETE FROM %s ;", com.tencent.mm.plugin.fts.c.d.dOt()));
            dVar.wUt.execSQL(String.format("DELETE FROM %s ;", com.tencent.mm.plugin.fts.c.d.dOu()));
            AppMethodBeat.o(52743);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "DeleteSOSHistoryTask";
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean axa() {
        this.wZl = null;
        this.hgI = null;
        return true;
    }
}
