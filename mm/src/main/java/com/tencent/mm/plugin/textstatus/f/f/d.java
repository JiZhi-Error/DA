package com.tencent.mm.plugin.textstatus.f.f;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.textstatus.f.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;

public final class d extends MAutoStorage<a> {
    private static final String[] FZH = {MAutoStorage.getCreateSQLs(a.FZC, TABLE)};
    public static final b FZK = new b((byte) 0);
    public static final String TABLE = TABLE;
    private final f FZJ = g.ah(new a(this));
    public final ISQLiteDatabase db;

    public final ConcurrentHashMap<String, a> hXr() {
        AppMethodBeat.i(258410);
        ConcurrentHashMap<String, a> concurrentHashMap = (ConcurrentHashMap) this.FZJ.getValue();
        AppMethodBeat.o(258410);
        return concurrentHashMap;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(a aVar, String[] strArr) {
        AppMethodBeat.i(216278);
        a aVar2 = aVar;
        p.h(aVar2, "item");
        p.h(strArr, "keys");
        boolean delete = super.delete(aVar2, (String[]) Arrays.copyOf(strArr, strArr.length));
        if (delete) {
            hXr().remove(aVar2.field_UserName);
            doNotify(aVar2.field_UserName);
        }
        AppMethodBeat.o(216278);
        return delete;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(a aVar) {
        AppMethodBeat.i(216272);
        boolean b2 = b(aVar);
        AppMethodBeat.o(216272);
        return b2;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(a aVar) {
        AppMethodBeat.i(216274);
        boolean c2 = c(aVar);
        AppMethodBeat.o(216274);
        return c2;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(long j2, a aVar) {
        AppMethodBeat.i(216277);
        a aVar2 = aVar;
        p.h(aVar2, "item");
        boolean update = super.update(j2, aVar2);
        if (update) {
            hXr().put(aVar2.field_UserName, aVar2);
            doNotify(aVar2.field_UserName);
        }
        AppMethodBeat.o(216277);
        return update;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(a aVar, String[] strArr) {
        AppMethodBeat.i(216276);
        boolean a2 = a(aVar, strArr);
        AppMethodBeat.o(216276);
        return a2;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.FZC, TABLE, null);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        a.C1821a aVar = a.FZD;
        AppMethodBeat.i(216284);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(216284);
    }

    static {
        AppMethodBeat.i(216285);
        a.C1821a aVar = a.FZD;
        AppMethodBeat.o(216285);
    }

    public final boolean b(a aVar) {
        AppMethodBeat.i(216271);
        p.h(aVar, "item");
        boolean insertNotify = super.insertNotify(aVar, false);
        if (insertNotify) {
            hXr().put(aVar.field_UserName, aVar);
            doNotify(aVar.field_UserName);
        }
        AppMethodBeat.o(216271);
        return insertNotify;
    }

    public final boolean c(a aVar) {
        AppMethodBeat.i(216273);
        p.h(aVar, "item");
        boolean replace = super.replace(aVar, false);
        if (replace) {
            hXr().put(aVar.field_UserName, aVar);
            doNotify(aVar.field_UserName);
        }
        AppMethodBeat.o(216273);
        return replace;
    }

    public final boolean a(a aVar, String... strArr) {
        AppMethodBeat.i(216275);
        p.h(aVar, "item");
        p.h(strArr, "keys");
        boolean updateNotify = super.updateNotify(aVar, false, (String[]) Arrays.copyOf(strArr, strArr.length));
        if (updateNotify) {
            hXr().put(aVar.field_UserName, aVar);
            doNotify(aVar.field_UserName);
        }
        AppMethodBeat.o(216275);
        return updateNotify;
    }

    public final boolean aTk(String str) {
        boolean z = true;
        AppMethodBeat.i(216279);
        p.h(str, "userName");
        Log.i("MicroMsg.TxtStatus.TextStatusStorage", "delete ".concat(String.valueOf(str)));
        if (this.db.delete(TABLE, "UserName = ?", new String[]{str}) <= 0) {
            z = false;
        }
        if (z) {
            hXr().remove(str);
            doNotify(str);
        }
        AppMethodBeat.o(216279);
        return z;
    }

    public final boolean ie(String str, int i2) {
        a aVar;
        boolean z = false;
        AppMethodBeat.i(257985);
        p.h(str, "userName");
        Log.i("MicroMsg.TxtStatus.TextStatusStorage", "deleteByCreateTime " + str + ' ' + i2);
        if (this.db.delete(TABLE, "UserName = ? and CreateTime<?", new String[]{str, String.valueOf(i2)}) > 0) {
            z = true;
        }
        if (z && (aVar = hXr().get(str)) != null && aVar.field_CreateTime < i2) {
            hXr().remove(str);
            doNotify(str);
        }
        AppMethodBeat.o(257985);
        return z;
    }

    public static final class c<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(216269);
            int a2 = kotlin.b.a.a(Integer.valueOf(((a) t2).field_CreateTime), Integer.valueOf(((a) t).field_CreateTime));
            AppMethodBeat.o(216269);
            return a2;
        }
    }

    public final a aTl(String str) {
        AppMethodBeat.i(216280);
        p.h(str, ch.COL_USERNAME);
        a aVar = hXr().get(str);
        if (aVar == null || aVar.field_ExpireTime <= cl.aWB()) {
            hXr().remove(str);
            AppMethodBeat.o(216280);
            return null;
        }
        AppMethodBeat.o(216280);
        return aVar;
    }

    public final List<a> m(String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(216281);
        ArrayList arrayList2 = new ArrayList();
        if (str == null) {
            ArrayList arrayList3 = arrayList2;
            AppMethodBeat.o(216281);
            return arrayList3;
        }
        for (a aVar : hXr().values()) {
            if (p.j(aVar.field_TopicId, str) && aVar.field_ExpireTime > cl.aWB()) {
                if (arrayList == null || !arrayList.contains(aVar.field_UserName)) {
                    arrayList2.add(aVar);
                }
            }
        }
        ArrayList arrayList4 = arrayList2;
        if (arrayList4.size() > 1) {
            j.a((List) arrayList4, (Comparator) new c());
        }
        ArrayList arrayList5 = arrayList2;
        AppMethodBeat.o(216281);
        return arrayList5;
    }

    public final a aTm(String str) {
        AppMethodBeat.i(216282);
        p.h(str, "statusId");
        for (a aVar : hXr().values()) {
            if (p.j(aVar.field_StatusID, str) && aVar.field_ExpireTime > cl.aWB()) {
                AppMethodBeat.o(216282);
                return aVar;
            }
        }
        AppMethodBeat.o(216282);
        return null;
    }

    public final LinkedHashMap<String, ArrayList<a>> w(List<String> list, List<String> list2) {
        AppMethodBeat.i(216283);
        LinkedHashMap<String, ArrayList<a>> linkedHashMap = new LinkedHashMap<>();
        for (a aVar : hXr().values()) {
            if (!list.contains(aVar.field_UserName) && !list2.contains(aVar.field_TopicId) && aVar.field_ExpireTime > cl.aWB()) {
                if (!linkedHashMap.containsKey(aVar.field_TopicId)) {
                    linkedHashMap.put(aVar.field_TopicId, new ArrayList<>());
                }
                ArrayList<a> arrayList = linkedHashMap.get(aVar.field_TopicId);
                if (arrayList != null) {
                    arrayList.add(aVar);
                }
            }
        }
        AppMethodBeat.o(216283);
        return linkedHashMap;
    }

    public final void bys(String str) {
        AppMethodBeat.i(258411);
        p.h(str, "userName");
        if (p.j(str, com.tencent.mm.plugin.auth.a.a.ceA())) {
            AppMethodBeat.o(258411);
            return;
        }
        Log.i("MicroMsg.TxtStatus.TextStatusStorage", "markRead ".concat(String.valueOf(str)));
        a aTl = aTl(str);
        if (aTl != null) {
            int i2 = aTl.field_state;
            a.C1821a aVar = a.FZD;
            if (i2 != a.VdI) {
                a.C1821a aVar2 = a.FZD;
                aTl.field_state = a.VdI;
                a(aTl, new String[0]);
            }
            AppMethodBeat.o(258411);
            return;
        }
        AppMethodBeat.o(258411);
    }

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.a<ConcurrentHashMap<String, a>> {
        final /* synthetic */ d FZL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d dVar) {
            super(0);
            this.FZL = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ConcurrentHashMap<String, a> invoke() {
            AppMethodBeat.i(216268);
            ConcurrentHashMap<String, a> concurrentHashMap = new ConcurrentHashMap<>();
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder("select rowid, * from ");
            b bVar = d.FZK;
            Cursor rawQuery = this.FZL.db.rawQuery(sb.append(d.TABLE).append(" where ExpireTime > ").append(cl.aWB()).append(' ').toString(), null);
            p.g(rawQuery, "db.rawQuery(sql, null)");
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    a aVar = new a();
                    aVar.convertFrom(rawQuery);
                    concurrentHashMap.put(aVar.field_UserName, aVar);
                }
                rawQuery.close();
            }
            Log.i("MicroMsg.TxtStatus.TextStatusStorage", "init time " + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(216268);
            return concurrentHashMap;
        }
    }
}
