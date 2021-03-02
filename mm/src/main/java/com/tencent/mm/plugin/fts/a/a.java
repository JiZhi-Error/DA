package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.d;
import com.tencent.recovery.log.RecoveryFileLog;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class a implements i {
    private volatile boolean dbG;
    private SQLiteStatement wUA;
    protected SQLiteStatement wUB;
    private f<String, String> wUs;
    public volatile h wUt;
    protected SQLiteStatement wUu;
    private SQLiteStatement wUv;
    private SQLiteStatement wUw;
    private SQLiteStatement wUx;
    private SQLiteStatement wUy;
    public SQLiteStatement wUz;

    /* access modifiers changed from: protected */
    public abstract void awY();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(i iVar) {
        i iVar2 = iVar;
        if (getPriority() < iVar2.getPriority()) {
            return -1;
        }
        if (getPriority() > iVar2.getPriority()) {
            return 1;
        }
        return 0;
    }

    public a() {
        Log.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create %s", getName());
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final synchronized void create() {
        boolean z;
        Log.i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnCreate %s | isCreated =%b", getName(), Boolean.valueOf(this.dbG));
        if (!this.dbG) {
            if (!((n) g.ah(n.class)).isFTSContextReady()) {
                Log.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create Fail!");
                z = false;
            } else {
                this.wUt = ((n) g.ah(n.class)).getFTSIndexDB();
                Log.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create Success!");
                String dOu = dOu();
                String dOt = dOt();
                Log.i("MicroMsg.FTS.BaseFTS5NativeStorage", "indexTableName=%s | metaTableName=%s | TableName=%s", dOu, dOt, getTableName());
                if (!this.wUt.ayi(dOu) || !this.wUt.ayi(dOt) || awZ()) {
                    Log.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Table Not Exist, Need To Create");
                    String format = String.format("DROP TABLE IF EXISTS %s;", dOu);
                    String format2 = String.format("DROP TABLE IF EXISTS %s;", dOt);
                    this.wUt.execSQL(format);
                    this.wUt.execSQL(format2);
                    this.wUt.execSQL(String.format("CREATE VIRTUAL TABLE %s USING fts5(content, tokenize='mmSimple', prefix='1 2 3 4 5');", dOu()));
                    this.wUt.execSQL(cVp());
                    this.wUt.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_typeId ON %s(type, entity_id);", dOt, dOt));
                    this.wUt.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_entity_id_subtype ON %s(entity_id, subtype);", dOt, dOt));
                    this.wUt.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_aux_index_subtype ON %s(aux_index, subtype);", dOt, dOt));
                    this.wUt.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", dOt, dOt));
                } else {
                    Log.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Table Exist, Not Need To Create");
                }
                this.wUu = this.wUt.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", dOu));
                this.wUv = this.wUt.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?);", dOt));
                this.wUw = this.wUt.compileStatement(String.format("DELETE FROM %s WHERE rowid=?;", dOu));
                this.wUx = this.wUt.compileStatement(String.format("DELETE FROM %s WHERE docid=?;", dOt));
                this.wUy = this.wUt.compileStatement(String.format("UPDATE %s SET status=? WHERE docid=?;", dOt));
                this.wUz = this.wUt.compileStatement(String.format("UPDATE %s SET status=? WHERE aux_index=? AND status=?", dOt));
                this.wUA = this.wUt.compileStatement(String.format("UPDATE %s SET timestamp=? WHERE aux_index=?", dOt));
                this.wUB = this.wUt.compileStatement("SELECT mm_last_error();");
                this.wUs = new h(100);
                awY();
                z = true;
            }
            if (z) {
                Log.i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetCreated");
                this.dbG = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getTableName() {
        return "Common";
    }

    public final void a(int i2, int i3, long j2, String str, long j3, String str2) {
        String ayp = d.ayp(str2);
        if (!Util.isNullOrNil(ayp)) {
            boolean inTransaction = this.wUt.inTransaction();
            if (!inTransaction) {
                this.wUt.beginTransaction();
            }
            try {
                this.wUu.bindString(1, ayp);
                this.wUu.execute();
                this.wUv.bindLong(1, (long) i2);
                this.wUv.bindLong(2, (long) i3);
                this.wUv.bindLong(3, j2);
                this.wUv.bindString(4, str);
                this.wUv.bindLong(5, j3);
                this.wUv.execute();
                if (!inTransaction) {
                    this.wUt.commit();
                }
                if (dOv()) {
                    this.wUs.put(dW(str, i3), ayp);
                }
            } catch (SQLiteException e2) {
                Log.e("MicroMsg.FTS.BaseFTS5NativeStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), str, Long.valueOf(j3)));
                String simpleQueryForString = this.wUB.simpleQueryForString();
                if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                    Log.e("MicroMsg.FTS.BaseFTS5NativeStorage", ">> ".concat(String.valueOf(simpleQueryForString)));
                }
                throw e2;
            }
        }
    }

    private static String dW(String str, int i2) {
        return str + RecoveryFileLog.SPLITTER + i2;
    }

    public final void a(int[] iArr, String str) {
        ArrayList arrayList = new ArrayList(16);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.C(iArr) + " AND aux_index=?;", dOt());
        Cursor rawQuery = this.wUt.rawQuery(format, new String[]{str});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        eN(arrayList);
    }

    public final void B(int[] iArr) {
        ArrayList arrayList = new ArrayList(2048);
        Cursor rawQuery = this.wUt.rawQuery(String.format("SELECT docid FROM %s WHERE type IN " + d.C(iArr) + ";", dOt()), null);
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        eN(arrayList);
    }

    public final void c(int[] iArr, long j2) {
        ArrayList arrayList = new ArrayList(16);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.C(iArr) + " AND entity_id=?;", dOt());
        Cursor rawQuery = this.wUt.rawQuery(format, new String[]{Long.toString(j2)});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        eN(arrayList);
    }

    public final void eN(List<Long> list) {
        boolean inTransaction = this.wUt.inTransaction();
        if (!inTransaction) {
            this.wUt.beginTransaction();
        }
        for (Long l : list) {
            this.wUw.bindLong(1, l.longValue());
            try {
                this.wUw.execute();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FTS.BaseFTS5NativeStorage", e2, "deleteIndexByDocIdStmt", new Object[0]);
            }
        }
        for (Long l2 : list) {
            try {
                this.wUx.bindLong(1, l2.longValue());
                this.wUx.execute();
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.FTS.BaseFTS5NativeStorage", e3, "deleteMetaByDocIdStmt", new Object[0]);
            }
        }
        if (!inTransaction) {
            commit();
        }
    }

    public final void av(String str, long j2) {
        this.wUA.bindLong(1, j2);
        this.wUA.bindString(2, str);
        this.wUA.execute();
    }

    public final void GC(long j2) {
        boolean inTransaction = this.wUt.inTransaction();
        if (!inTransaction) {
            this.wUt.beginTransaction();
        }
        this.wUw.bindLong(1, j2);
        try {
            this.wUw.execute();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FTS.BaseFTS5NativeStorage", e2, "deleteIndexByDocId", new Object[0]);
        }
        this.wUx.bindLong(1, j2);
        try {
            this.wUx.execute();
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.FTS.BaseFTS5NativeStorage", e3, "deleteMetaByDocIdStmt", new Object[0]);
        }
        if (!inTransaction) {
            commit();
        }
    }

    public final void v(List<Long> list, int i2) {
        boolean inTransaction = this.wUt.inTransaction();
        if (!inTransaction) {
            this.wUt.beginTransaction();
        }
        this.wUy.bindLong(1, (long) i2);
        for (Long l : list) {
            this.wUy.bindLong(2, l.longValue());
            this.wUy.execute();
        }
        if (!inTransaction) {
            this.wUt.commit();
        }
    }

    public final List<Long> b(int[] iArr, String str) {
        String format = String.format("SELECT docid FROM %s WHERE aux_index=? AND type IN " + d.C(iArr) + ";", dOt());
        Cursor rawQuery = this.wUt.rawQuery(format, new String[]{str});
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        v(arrayList, 1);
        return arrayList;
    }

    public final List<b> j(int[] iArr, int i2) {
        Cursor rawQuery = this.wUt.rawQuery(String.format("SELECT docid, type, subtype, aux_index FROM %s WHERE type IN " + d.C(iArr) + ";", dOt()), null);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (rawQuery.moveToNext()) {
            b bVar = new b();
            bVar.f(rawQuery);
            arrayList.add(bVar);
            arrayList2.add(Long.valueOf(bVar.wVV));
        }
        rawQuery.close();
        v(arrayList2, i2);
        return arrayList;
    }

    public final Cursor a(com.tencent.mm.plugin.fts.a.a.h hVar, int[] iArr, int[] iArr2, boolean z, boolean z2) {
        String dOz = hVar.dOz();
        return this.wUt.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp" + (z2 ? ", content" : "") + (z ? String.format(", MMHighlight(%s, %d, type, subtype)", dOu(), Integer.valueOf(hVar.wWF.size())) : "") + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + ((iArr == null || iArr.length <= 0) ? "" : " AND type IN " + d.C(iArr)) + "" + " AND status >= 0" + ((iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + d.C(iArr2)) + ";", dOt(), dOt(), dOu(), dOt(), dOu(), dOu(), dOz), null);
    }

    public final Cursor a(int[] iArr, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!z && !z2 && !z3 && !z4 && !z5) {
            return d.gFu();
        }
        if (iArr == null || iArr.length == 0) {
            return d.gFu();
        }
        StringBuilder sb = new StringBuilder(64);
        if (z) {
            sb.append("docid,");
        }
        if (z2) {
            sb.append("entity_id,");
        }
        if (z3) {
            sb.append("aux_index,");
        }
        if (z4) {
            sb.append("timestamp,");
        }
        if (z5) {
            sb.append("status,");
        }
        sb.setLength(sb.length() - 1);
        String sb2 = sb.toString();
        return this.wUt.rawQuery(String.format("SELECT %s FROM %s WHERE type IN " + d.C(iArr) + ";", sb2, dOt()), null);
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final void destroy() {
        Log.i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnDestroy %s | isCreated %b", getName(), Boolean.valueOf(this.dbG));
        if (this.dbG && axa()) {
            Log.i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetDestroyed");
            this.dbG = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean axa() {
        if (this.wUu != null) {
            this.wUu.close();
        }
        if (this.wUv != null) {
            this.wUv.close();
        }
        if (this.wUw != null) {
            this.wUw.close();
        }
        if (this.wUx != null) {
            this.wUx.close();
        }
        if (this.wUy != null) {
            this.wUy.close();
        }
        if (this.wUB != null) {
            this.wUB.close();
        }
        if (this.wUs != null) {
            this.wUs.clear();
        }
        this.wUt = null;
        return true;
    }

    public final String dOt() {
        return "FTS5Meta" + getTableName();
    }

    public final String dOu() {
        return "FTS5Index" + getTableName();
    }

    public final void beginTransaction() {
        this.wUt.beginTransaction();
    }

    public final void commit() {
        this.wUt.commit();
    }

    public final void W(long j2, long j3) {
        this.wUt.W(j2, j3);
    }

    public final boolean gD(int i2, int i3) {
        return this.wUt.gD(i2, i3);
    }

    /* access modifiers changed from: protected */
    public String cVp() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", dOt());
    }

    /* access modifiers changed from: protected */
    public boolean awZ() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final String dX(String str, int i2) {
        if (dOv()) {
            String dW = dW(str, i2);
            if (this.wUs.check(dW)) {
                Log.i("MicroMsg.FTS.BaseFTS5NativeStorage", "hit lru insert content map");
                return this.wUs.get(dW);
            }
        }
        String format = String.format("SELECT content FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE aux_index=? AND subtype=?", dOt(), dOu(), dOt(), dOu());
        Cursor rawQuery = this.wUt.rawQuery(format, new String[]{str, String.valueOf(i2)});
        String str2 = null;
        if (rawQuery.moveToFirst()) {
            str2 = rawQuery.getString(0);
        }
        rawQuery.close();
        return str2;
    }

    /* access modifiers changed from: protected */
    public boolean dOv() {
        return false;
    }

    public final void ayn(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : this.wUs.keySet()) {
            if (str2.startsWith(str)) {
                hashSet.add(str2);
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.wUs.remove((String) it.next());
        }
    }
}
