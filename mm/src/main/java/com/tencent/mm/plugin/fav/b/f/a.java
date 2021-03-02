package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a extends MAutoStorage<c> implements q {
    private ISQLiteDatabase db;
    private List<p> listeners = new CopyOnWriteArrayList();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(c cVar, String[] strArr) {
        AppMethodBeat.i(101680);
        boolean b2 = b(cVar, strArr);
        AppMethodBeat.o(101680);
        return b2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(c cVar) {
        AppMethodBeat.i(101681);
        boolean f2 = f(cVar);
        AppMethodBeat.o(101681);
        return f2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(c cVar, String[] strArr) {
        AppMethodBeat.i(101679);
        boolean a2 = a(cVar, strArr);
        AppMethodBeat.o(101679);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final void a(p pVar) {
        AppMethodBeat.i(101662);
        if (pVar != null) {
            this.listeners.add(pVar);
        }
        AppMethodBeat.o(101662);
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final void b(p pVar) {
        AppMethodBeat.i(101663);
        if (pVar != null) {
            this.listeners.remove(pVar);
        }
        AppMethodBeat.o(101663);
    }

    public a(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "FavCdnInfo", null);
        AppMethodBeat.i(101664);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(101664);
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final void startAll() {
        AppMethodBeat.i(101665);
        this.db.execSQL("FavCdnInfo", "update FavCdnInfo set status = 1 where status <> 3");
        AppMethodBeat.o(101665);
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final boolean f(c cVar) {
        AppMethodBeat.i(101666);
        if (cVar == null) {
            AppMethodBeat.o(101666);
            return false;
        } else if (super.insert(cVar)) {
            for (p pVar : this.listeners) {
                if (pVar != null) {
                    pVar.e(cVar);
                }
            }
            AppMethodBeat.o(101666);
            return true;
        } else {
            AppMethodBeat.o(101666);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final boolean a(c cVar, String... strArr) {
        AppMethodBeat.i(101667);
        if (super.update(cVar, strArr)) {
            for (p pVar : this.listeners) {
                if (pVar != null) {
                    pVar.e(cVar);
                }
            }
            AppMethodBeat.o(101667);
            return true;
        }
        AppMethodBeat.o(101667);
        return false;
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final boolean b(c cVar, String... strArr) {
        AppMethodBeat.i(101668);
        if (super.delete(cVar, strArr)) {
            for (p pVar : this.listeners) {
                if (pVar != null) {
                    pVar.e(cVar);
                }
            }
            AppMethodBeat.o(101668);
            return true;
        }
        AppMethodBeat.o(101668);
        return false;
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final c asa(String str) {
        c cVar = null;
        AppMethodBeat.i(101669);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FavCdnStorage", "md5 null");
            AppMethodBeat.o(101669);
        } else {
            Cursor rawQuery = this.db.rawQuery("select * from FavCdnInfo where dataId = '" + str + "'", null, 2);
            if (rawQuery == null) {
                AppMethodBeat.o(101669);
            } else {
                if (rawQuery.moveToFirst()) {
                    cVar = new c();
                    cVar.convertFrom(rawQuery);
                }
                rawQuery.close();
                AppMethodBeat.o(101669);
            }
        }
        return cVar;
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final void y(g gVar) {
        AppMethodBeat.i(101670);
        this.db.execSQL("FavCdnInfo", "update FavCdnInfo set status = 1,modifyTime = " + Util.nowMilliSecond() + " where favLocalId = " + gVar.field_localId + " and type = 0 and status <> 3");
        AppMethodBeat.o(101670);
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final LinkedList<c> cUK() {
        LinkedList<c> linkedList = null;
        AppMethodBeat.i(101671);
        Cursor rawQuery = this.db.rawQuery("select * from FavCdnInfo where status = 1 order by modifyTime asc " + " limit 1", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(101671);
        } else if (!rawQuery.moveToFirst()) {
            rawQuery.close();
            AppMethodBeat.o(101671);
        } else {
            linkedList = new LinkedList<>();
            do {
                c cVar = new c();
                cVar.convertFrom(rawQuery);
                linkedList.add(cVar);
            } while (rawQuery.moveToNext());
            rawQuery.close();
            AppMethodBeat.o(101671);
        }
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final List<c> DT(long j2) {
        AppMethodBeat.i(101672);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery("select * from FavCdnInfo where favLocalId = ".concat(String.valueOf(j2)), null, 2);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                c cVar = new c();
                cVar.convertFrom(rawQuery);
                arrayList.add(cVar);
            }
            rawQuery.close();
        }
        Log.v("MicroMsg.FavCdnStorage", "getInfos size:%d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(101672);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0045  */
    @Override // com.tencent.mm.plugin.fav.a.q
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.plugin.fav.a.c> DU(long r8) {
        /*
            r7 = this;
            r6 = 101673(0x18d29, float:1.42474E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "select * from FavCdnInfo where favLocalId = "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r2 = " and type = 0 and status = 3"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.tencent.mm.sdk.storage.ISQLiteDatabase r2 = r7.db
            r3 = 0
            r4 = 2
            android.database.Cursor r1 = r2.rawQuery(r1, r3, r4)
            if (r1 == 0) goto L_0x0043
            boolean r2 = r1.moveToFirst()
            if (r2 == 0) goto L_0x0043
        L_0x0032:
            com.tencent.mm.plugin.fav.a.c r2 = new com.tencent.mm.plugin.fav.a.c
            r2.<init>()
            r2.convertFrom(r1)
            r0.add(r2)
            boolean r2 = r1.moveToNext()
            if (r2 != 0) goto L_0x0032
        L_0x0043:
            if (r1 == 0) goto L_0x0048
            r1.close()
        L_0x0048:
            java.lang.String r1 = "MicroMsg.FavCdnStorage"
            java.lang.String r2 = "getUploadedInfos size:%d"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            int r5 = r0.size()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3[r4] = r5
            com.tencent.mm.sdk.platformtools.Log.v(r1, r2, r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.b.f.a.DU(long):java.util.List");
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final void DV(long j2) {
        AppMethodBeat.i(101674);
        this.db.execSQL("FavCdnInfo", String.format("delete from %s where %s = %d and %s = %d", "FavCdnInfo", "favLocalId", Long.valueOf(j2), "type", 0));
        AppMethodBeat.o(101674);
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final int x(long j2, int i2) {
        AppMethodBeat.i(101675);
        Cursor rawQuery = this.db.rawQuery("select status from FavCdnInfo where favLocalId = " + j2 + " and type = " + i2, null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(101675);
            return 3;
        } else if (!rawQuery.moveToFirst()) {
            rawQuery.close();
            AppMethodBeat.o(101675);
            return 3;
        } else {
            boolean z = true;
            boolean z2 = true;
            boolean z3 = true;
            do {
                int i3 = rawQuery.getInt(0);
                if (i3 == 1) {
                    rawQuery.close();
                    AppMethodBeat.o(101675);
                    return 1;
                }
                if (i3 != 4) {
                    z3 = false;
                }
                if (i3 != 2) {
                    z2 = false;
                }
                if (i3 != 3) {
                    z = false;
                }
            } while (rawQuery.moveToNext());
            rawQuery.close();
            if (z2) {
                AppMethodBeat.o(101675);
                return 2;
            } else if (z3) {
                AppMethodBeat.o(101675);
                return 4;
            } else if (z) {
                AppMethodBeat.o(101675);
                return 3;
            } else {
                AppMethodBeat.o(101675);
                return 0;
            }
        }
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final Cursor cUL() {
        AppMethodBeat.i(101676);
        Cursor rawQuery = this.db.rawQuery("select * from FavCdnInfo where type = 0 and status = 1", null);
        AppMethodBeat.o(101676);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final Cursor cUM() {
        AppMethodBeat.i(101677);
        Cursor rawQuery = this.db.rawQuery("select * from FavCdnInfo where type = 1 and status = 1", null);
        AppMethodBeat.o(101677);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.fav.a.q
    public final boolean DW(long j2) {
        AppMethodBeat.i(101678);
        c cVar = new c();
        cVar.field_favLocalId = j2;
        boolean b2 = b(cVar, "favLocalId");
        AppMethodBeat.o(101678);
        return b2;
    }
}
