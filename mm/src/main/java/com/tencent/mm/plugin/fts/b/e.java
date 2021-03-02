package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.recovery.log.RecoveryFileLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class e extends com.tencent.mm.plugin.fts.a.b {
    private m hgI;
    com.tencent.mm.plugin.fts.c.e wZn;
    HashSet<String> wZo;

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean onCreate() {
        AppMethodBeat.i(52756);
        if (!((n) g.ah(n.class)).isFTSContextReady()) {
            Log.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Fail!");
            AppMethodBeat.o(52756);
            return false;
        }
        Log.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Success!");
        this.wZo = new HashSet<>();
        this.wZn = (com.tencent.mm.plugin.fts.c.e) ((n) g.ah(n.class)).getFTSIndexStorage(1);
        this.hgI = ((n) g.ah(n.class)).getFTSTaskDaemon();
        this.hgI.a(65626, new a(this, (byte) 0));
        AppMethodBeat.o(52756);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean axa() {
        AppMethodBeat.i(52757);
        if (this.wZo != null) {
            this.wZo.clear();
        }
        this.wZn = null;
        this.hgI = null;
        AppMethodBeat.o(52757);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.k, com.tencent.mm.plugin.fts.a.b
    public final com.tencent.mm.plugin.fts.a.a.a a(j jVar) {
        AppMethodBeat.i(52758);
        com.tencent.mm.plugin.fts.a.a.a a2 = this.hgI.a(-65536, new b(jVar));
        AppMethodBeat.o(52758);
        return a2;
    }

    public final void ayF(String str) {
        AppMethodBeat.i(52759);
        if (this.wZo.add(str)) {
            this.wZn.ayJ(str);
        }
        AppMethodBeat.o(52759);
    }

    public final void c(int[] iArr, String str) {
        AppMethodBeat.i(52760);
        this.wZn.a(iArr, str);
        AppMethodBeat.o(52760);
    }

    class b extends i {
        public b(j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchTopHitsTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 8;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(k kVar) {
            AppMethodBeat.i(52753);
            kVar.wWd = h.bE(this.wWO.query, true);
            Log.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "MatchQuery %s", kVar.wWd.dOz().replaceAll(RecoveryFileLog.SPLITTER, ","));
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.wWO.wWX);
            kVar.wXb = new ArrayList();
            HashSet hashSet2 = new HashSet();
            com.tencent.mm.plugin.fts.c.e eVar = e.this.wZn;
            h hVar = kVar.wWd;
            int[] iArr = this.wWO.wWU;
            int i2 = this.wWO.scene;
            int size = this.wWO.wWW + this.wWO.wWX.size();
            Cursor rawQuery = eVar.wUt.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), query, scene FROM %s, %s WHERE %s %s %s %s %s AND %s.docid = %s.rowid ORDER BY score desc %s;", eVar.dOt(), eVar.dOu(), Long.valueOf((long) hVar.wWF.size()), eVar.dOu(), eVar.dOt(), "query LIKE ?", String.format("AND %s MATCH '%s'", eVar.dOu(), hVar.dOz()), "AND type IN " + d.C(iArr), "AND scene=?", "AND status >= 0 AND score >= 3", eVar.dOt(), eVar.dOu(), size > 0 ? "LIMIT ".concat(String.valueOf(size)) : ""), new String[]{hVar.wWB + '%', String.valueOf(i2)});
            while (rawQuery.moveToNext()) {
                try {
                    com.tencent.mm.plugin.fts.a.a.n i3 = new com.tencent.mm.plugin.fts.a.a.n().i(rawQuery);
                    if (hashSet.add(i3.wVX)) {
                        i3.dOC();
                        i3.userData = "";
                        if (i3.type == 262144) {
                            i3.userData = ((com.tencent.mm.plugin.fts.c.b) ((n) g.ah(n.class)).getFTSIndexStorage(17)).Np((int) i3.wXe);
                            if (i3.userData == null) {
                                continue;
                            }
                        } else if (i3.type == 131072 && com.tencent.mm.plugin.fts.c.e.ayK(i3.wVX)) {
                            hashSet2.add(i3.wVX);
                        }
                        kVar.wXb.add(i3);
                        if (kVar.wXb.size() >= this.wWO.wWW) {
                            break;
                        }
                    }
                } catch (Throwable th) {
                    rawQuery.close();
                    AppMethodBeat.o(52753);
                    throw th;
                }
            }
            rawQuery.close();
            Log.d("MicroMsg.FTS.FTS5SearchTopHitsLogic", "History TopHits %s", Integer.valueOf(kVar.wXb.size()));
            if (kVar.wWd.wWD.length > 1) {
                if (kVar.wXb.size() > 2) {
                    kVar.wXb = kVar.wXb.subList(0, 2);
                }
                hashSet.clear();
                for (int i4 = 0; i4 < kVar.wXb.size(); i4++) {
                    hashSet.add(kVar.wXb.get(i4).wVX);
                }
                HashSet hashSet3 = new HashSet();
                com.tencent.mm.plugin.fts.c.e eVar2 = e.this.wZn;
                h hVar2 = kVar.wWd;
                int[] iArr2 = this.wWO.wWU;
                Cursor rawQuery2 = eVar2.wUt.rawQuery(String.format("SELECT aux_index FROM %s, %s WHERE %s.docid = %s.rowid AND query = ? AND scene = " + this.wWO.scene + (" AND type IN " + d.C(iArr2)) + " AND status >= 0 AND score >= 2" + String.format(" AND %s MATCH '%s'", eVar2.dOu(), hVar2.dOz()) + " ORDER BY score desc limit " + (this.wWO.wWW + this.wWO.wWX.size()) + ";", eVar2.dOt(), eVar2.dOu(), eVar2.dOt(), eVar2.dOu(), eVar2.dOt(), eVar2.dOu()), new String[]{"​chatroom_tophits"});
                while (rawQuery2.moveToNext()) {
                    String string = rawQuery2.getString(0);
                    if (!hashSet.contains(string)) {
                        hashSet3.add(string);
                    }
                }
                rawQuery2.close();
                com.tencent.mm.plugin.fts.c.a aVar = (com.tencent.mm.plugin.fts.c.a) ((n) g.ah(n.class)).getFTSIndexStorage(3);
                Iterator it = hashSet3.iterator();
                while (it.hasNext()) {
                    h hVar3 = kVar.wWd;
                    Cursor rawQuery3 = aVar.wUt.rawQuery(String.format(new StringBuilder("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND type = 131075 AND subtype= 38;").toString(), aVar.dOt(), aVar.dOu(), Long.valueOf((long) hVar3.wWF.size()), aVar.dOt(), aVar.dOu(), aVar.dOt(), aVar.dOu(), aVar.dOu(), hVar3.dOz()), new String[]{(String) it.next()});
                    if (rawQuery3.moveToNext()) {
                        com.tencent.mm.plugin.fts.a.a.n i5 = new com.tencent.mm.plugin.fts.a.a.n().i(rawQuery3);
                        i5.userData = "​chatroom_tophits";
                        i5.dOC();
                        kVar.wXb.add(i5);
                        if (kVar.wXb.size() >= this.wWO.wWW) {
                            break;
                        }
                    }
                    rawQuery3.close();
                }
            }
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                e.this.ayF((String) it2.next());
            }
            AppMethodBeat.o(52753);
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public final String getName() {
        return "FTS5SearchTopHitsLogic";
    }

    @Override // com.tencent.mm.plugin.fts.a.k, com.tencent.mm.plugin.fts.a.b
    public final void a(String str, com.tencent.mm.plugin.fts.a.a.m mVar, int i2, HashMap<String, String> hashMap) {
        AppMethodBeat.i(52761);
        c cVar = new c(this, (byte) 0);
        cVar.query = str;
        cVar.wZs = mVar;
        cVar.scene = i2;
        cVar.wVh = hashMap;
        this.hgI.a(65626, cVar);
        AppMethodBeat.o(52761);
    }

    class c extends com.tencent.mm.plugin.fts.a.a.a {
        private String query;
        private int scene;
        private HashMap<String, String> wVh;
        private com.tencent.mm.plugin.fts.a.a.m wZs;

        private c() {
        }

        /* synthetic */ c(e eVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            int i2;
            int i3;
            int i4;
            AppMethodBeat.i(52754);
            com.tencent.mm.plugin.fts.c.e eVar = e.this.wZn;
            String str = this.query;
            com.tencent.mm.plugin.fts.a.a.m mVar = this.wZs;
            int i5 = this.scene;
            HashMap<String, String> hashMap = this.wVh;
            String trim = str.trim();
            hashMap.remove(mVar.wVX);
            long currentTimeMillis = System.currentTimeMillis();
            if ((mVar.type == 131072 || mVar.type == 131075) && com.tencent.mm.plugin.fts.c.e.ayK(mVar.wVX)) {
                Log.i("MicroMsg.FTS.FTS5TopHitsStorage", "last contact msg time older than 60 days");
            } else {
                eVar.wUt.beginTransaction();
                Cursor rawQuery = eVar.wUt.rawQuery(String.format("SELECT docid, score FROM %s WHERE query=? AND aux_index=? AND subtype = ? AND scene=?;", eVar.dOt()), new String[]{trim, mVar.wVX, String.valueOf(mVar.wVW), String.valueOf(i5)});
                if (rawQuery.moveToNext()) {
                    int i6 = rawQuery.getInt(0);
                    i2 = rawQuery.getInt(1);
                    i3 = i6;
                } else {
                    i2 = -1;
                    i3 = -1;
                }
                rawQuery.close();
                String str2 = "";
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    str2 = !entry.getValue().equals("​chatroom_tophits") ? str2 + "'" + entry.getKey() + "'," : str2;
                }
                if (str2.length() > 0) {
                    eVar.wUt.execSQL(String.format("UPDATE %s SET score=CASE WHEN score > 6 THEN 6 WHEN score > 2 THEN (score - 1) ELSE score END WHERE scene = %d %s;", eVar.dOt(), Integer.valueOf(i5), "AND aux_index IN (" + str2.substring(0, str2.length() - 1) + ")"));
                }
                String str3 = "";
                for (Map.Entry<String, String> entry2 : hashMap.entrySet()) {
                    str3 = entry2.getValue().equals("​chatroom_tophits") ? str3 + "'" + entry2.getKey() + "'," : str3;
                }
                if (str3.length() > 0) {
                    eVar.wUt.execSQL(String.format("UPDATE %s SET score=CASE WHEN score = 1 THEN 0 WHEN score < 5 THEN (score - 1) ELSE 4 END WHERE query = ? AND scene = %d %s;", eVar.dOt(), Integer.valueOf(i5), "AND aux_index IN(" + str3.substring(0, str3.length() - 1) + ")"), new String[]{"​chatroom_tophits"});
                }
                if (i3 < 0 || i2 < 0) {
                    eVar.wZL.bindString(1, mVar.content);
                    eVar.wZL.execute();
                    eVar.wZM.bindLong(1, (long) mVar.type);
                    eVar.wZM.bindLong(2, (long) mVar.wVW);
                    eVar.wZM.bindLong(3, mVar.wXe);
                    eVar.wZM.bindString(4, mVar.wVX);
                    eVar.wZM.bindLong(5, currentTimeMillis);
                    eVar.wZM.bindString(6, trim);
                    eVar.wZM.bindLong(7, 3);
                    eVar.wZM.bindLong(8, (long) i5);
                    eVar.wZM.bindString(9, mVar.content);
                    eVar.wZM.execute();
                } else {
                    if (i2 > 6) {
                        i4 = i2 + 1;
                    } else {
                        i4 = i2 + 3;
                    }
                    eVar.wUt.execSQL(String.format("UPDATE %s SET score=?, timestamp=? WHERE docid=?", eVar.dOt()), new String[]{String.valueOf(i4), String.valueOf(currentTimeMillis), String.valueOf(i3)});
                }
                eVar.wUt.commit();
                String[] split = c.a.wVe.split(trim);
                if (split.length > 1 && mVar.type == 131075 && mVar.wVW == 38) {
                    HashSet hashSet = new HashSet();
                    l lVar = new l();
                    Cursor rawQuery2 = eVar.wUt.rawQuery(String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE aux_index=? AND query=?;", eVar.dOt()), new String[]{mVar.wVX, "​chatroom_tophits"});
                    if (rawQuery2.moveToNext()) {
                        lVar.convertFrom(rawQuery2);
                        for (String str4 : c.a.wVa.split(lVar.wXf)) {
                            hashSet.add(str4);
                        }
                    }
                    rawQuery2.close();
                    int i7 = 0;
                    while (i7 < mVar.wXl.size() && i7 < split.length) {
                        com.tencent.mm.plugin.fts.a.a.g gVar = mVar.wXl.get(i7);
                        if (hashSet.add(gVar.content)) {
                            lVar.wXf += gVar.content + RecoveryFileLog.SPLITTER;
                        }
                        i7++;
                    }
                    Log.i("MicroMsg.FTS.FTS5TopHitsStorage", "update tophits content=%s", lVar.wXf);
                    if (lVar.wXc > 0) {
                        eVar.GC(lVar.wXc);
                    }
                    lVar.wXc = 0;
                    lVar.query = "​chatroom_tophits";
                    lVar.wXd++;
                    lVar.igp = (long) i5;
                    lVar.wVX = mVar.wVX;
                    lVar.wXe = mVar.wXe;
                    lVar.type = mVar.type;
                    lVar.wVW = mVar.wVW;
                    lVar.timestamp = currentTimeMillis;
                    eVar.wUt.beginTransaction();
                    eVar.wZL.bindString(1, lVar.wXf);
                    eVar.wZL.execute();
                    eVar.wZM.bindLong(1, (long) lVar.type);
                    eVar.wZM.bindLong(2, (long) lVar.wVW);
                    eVar.wZM.bindLong(3, lVar.wXe);
                    eVar.wZM.bindString(4, lVar.wVX);
                    eVar.wZM.bindLong(5, lVar.timestamp);
                    eVar.wZM.bindString(6, lVar.query);
                    eVar.wZM.bindLong(7, lVar.wXd);
                    eVar.wZM.bindLong(8, lVar.igp);
                    eVar.wZM.bindString(9, lVar.wXf);
                    eVar.wZM.execute();
                    eVar.wUt.commit();
                }
            }
            AppMethodBeat.o(52754);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(52755);
            String format = String.format("%s : query=%s scene=%d", super.toString(), this.query, Integer.valueOf(this.scene));
            AppMethodBeat.o(52755);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "UpdateTopHitsWithQueryTask";
        }
    }

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        int wZp;
        int wZq;

        private a() {
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52751);
            this.wZq = e.this.wZn.dOZ();
            com.tencent.mm.plugin.fts.c.e eVar = e.this.wZn;
            String format = String.format("SELECT docid FROM %s WHERE timestamp < ? OR score = 0;", eVar.dOt());
            Cursor rawQuery = eVar.wUt.rawQuery(format, new String[]{String.valueOf(System.currentTimeMillis() - 5184000000L)});
            LinkedList linkedList = new LinkedList();
            while (rawQuery.moveToNext()) {
                linkedList.add(Long.valueOf(rawQuery.getLong(0)));
            }
            rawQuery.close();
            eVar.eN(linkedList);
            this.wZp = linkedList.size();
            AppMethodBeat.o(52751);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52752);
            String format = String.format("{topHitsUpdateCount: %d deleteExpiredCount: %d}", Integer.valueOf(this.wZq), Integer.valueOf(this.wZp));
            AppMethodBeat.o(52752);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "BuildTopHitsIndexTask";
        }
    }
}
