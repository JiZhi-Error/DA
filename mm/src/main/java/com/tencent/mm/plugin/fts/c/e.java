package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.recovery.log.RecoveryFileLog;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends a {
    public SQLiteStatement wZL;
    public SQLiteStatement wZM;
    private SQLiteStatement wZN;

    @Override // com.tencent.mm.plugin.fts.a.a
    public final String getTableName() {
        return "TopHits";
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final String getName() {
        return "FTS5TopHitsStorage";
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getType() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getPriority() {
        return 768;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final void awY() {
        AppMethodBeat.i(52811);
        if (awZ()) {
            this.wUt.W(-100, 5);
        }
        this.wUt.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_query ON %s(query);", dOt(), dOt()));
        this.wUt.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_score ON %s(score);", dOt(), dOt()));
        this.wZL = this.wUt.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", dOu()));
        this.wZM = this.wUt.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, query, score, scene, meta_content) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?, ?, ?, ?);", dOt()));
        this.wZN = this.wUt.compileStatement(String.format("UPDATE %s SET status=? WHERE aux_index=?", dOt()));
        AppMethodBeat.o(52811);
    }

    public final void ayJ(String str) {
        AppMethodBeat.i(52812);
        this.wZN.bindLong(1, 1);
        this.wZN.bindString(2, str);
        this.wZN.execute();
        AppMethodBeat.o(52812);
    }

    public final int dOZ() {
        i iVar;
        AppMethodBeat.i(52813);
        Cursor rawQuery = this.wUt.rawQuery(String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE status > 0;", dOt()), null);
        ArrayList<l> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            l lVar = new l();
            lVar.convertFrom(rawQuery);
            arrayList.add(lVar);
        }
        rawQuery.close();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (l lVar2 : arrayList) {
            boolean z = false;
            if (lVar2.type == 262144) {
                iVar = ((n) g.ah(n.class)).getFTSIndexStorage(17);
            } else {
                i fTSIndexStorage = ((n) g.ah(n.class)).getFTSIndexStorage(3);
                z = ayK(lVar2.wVX);
                iVar = fTSIndexStorage;
            }
            String str = null;
            if (!z) {
                str = iVar.dX(lVar2.wVX, lVar2.wVW);
            }
            if (Util.isNullOrNil(str)) {
                linkedList2.add(Long.valueOf(lVar2.wXc));
            } else if (lVar2.query.equals("​chatroom_tophits")) {
                String[] split = c.a.wVa.split(lVar2.wXf);
                String str2 = "";
                for (String str3 : split) {
                    if (str.indexOf(str3) >= 0) {
                        str2 = str2 + str3 + RecoveryFileLog.SPLITTER;
                    }
                }
                if (!lVar2.wXf.equals(str2)) {
                    lVar2.wXf = str2;
                    linkedList2.add(Long.valueOf(lVar2.wXc));
                    linkedList3.add(lVar2);
                } else {
                    linkedList.add(Long.valueOf(lVar2.wXc));
                }
            } else if (!lVar2.wXf.equals(str)) {
                lVar2.wXf = str;
                linkedList2.add(Long.valueOf(lVar2.wXc));
                linkedList3.add(lVar2);
            } else {
                linkedList.add(Long.valueOf(lVar2.wXc));
            }
        }
        Log.i("MicroMsg.FTS.FTS5TopHitsStorage", "updateTopHitsDirty deleteDocIdList=%d needToInsertTopHitListSize=%d normalDocIdList=%d", Integer.valueOf(linkedList2.size()), Integer.valueOf(linkedList3.size()), Integer.valueOf(linkedList.size()));
        if (linkedList2.size() > 0) {
            eN(linkedList2);
        }
        if (linkedList3.size() > 0) {
            boolean inTransaction = this.wUt.inTransaction();
            if (!inTransaction) {
                this.wUt.beginTransaction();
            }
            Iterator it = linkedList3.iterator();
            while (it.hasNext()) {
                l lVar3 = (l) it.next();
                if (!Util.isNullOrNil(lVar3.wXf)) {
                    this.wZL.bindString(1, lVar3.wXf);
                    this.wZL.execute();
                    this.wZM.bindLong(1, (long) lVar3.type);
                    this.wZM.bindLong(2, (long) lVar3.wVW);
                    this.wZM.bindLong(3, lVar3.wXe);
                    this.wZM.bindString(4, lVar3.wVX);
                    this.wZM.bindLong(5, lVar3.timestamp);
                    this.wZM.bindString(6, lVar3.query);
                    this.wZM.bindLong(7, lVar3.wXd);
                    this.wZM.bindLong(8, lVar3.igp);
                    this.wZM.bindString(9, lVar3.wXf);
                    this.wZM.execute();
                }
            }
            if (!inTransaction) {
                commit();
            }
        }
        if (linkedList.size() > 0) {
            v(linkedList, 0);
        }
        int size = linkedList2.size();
        AppMethodBeat.o(52813);
        return size;
    }

    public static boolean ayK(String str) {
        AppMethodBeat.i(52814);
        if (((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEQ(str) < System.currentTimeMillis() - 5184000000L) {
            AppMethodBeat.o(52814);
            return true;
        }
        AppMethodBeat.o(52814);
        return false;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final boolean axa() {
        AppMethodBeat.i(52815);
        super.axa();
        this.wZL.close();
        this.wZM.close();
        this.wZN.close();
        AppMethodBeat.o(52815);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final String cVp() {
        AppMethodBeat.i(52816);
        String format = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, query TEXT COLLATE NOCASE, score INT, scene INT, meta_content TEXT);", dOt());
        AppMethodBeat.o(52816);
        return format;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final boolean awZ() {
        AppMethodBeat.i(52817);
        if (!gD(-100, 5)) {
            AppMethodBeat.o(52817);
            return true;
        }
        AppMethodBeat.o(52817);
        return false;
    }
}
