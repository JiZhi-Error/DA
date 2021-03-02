package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.SystemClock;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ap;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.x;

public final class l extends MAutoStorage<ch> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(FinderItem.info, ch.TABLE_NAME)};
    public static final a vDM = new a((byte) 0);
    public final String TABLE = ch.TABLE_NAME;
    public final ISQLiteDatabase db;
    public String vDJ;
    private String vDK;
    private final ArrayList<Integer> vDL;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, FinderItem.info, ch.TABLE_NAME, ch.INDEX_CREATE);
        p.h(iSQLiteDatabase, "_db");
        FinderItem.a aVar = FinderItem.Companion;
        AppMethodBeat.i(166975);
        this.db = iSQLiteDatabase;
        ap.a aVar2 = ap.vFv;
        this.vDL = ap.a.eu(j.listOf((Object[]) new Integer[]{1, 2}));
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.vDL.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if ((next.intValue() & 1) != 0 && (next.intValue() & 2) == 0) {
                arrayList.add(next);
            }
        }
        ap.a aVar3 = ap.vFv;
        this.vDJ = ap.a.k(arrayList, "localFlag");
        Log.i("Finder.FinderFeedStorage", "CONDITION_POST " + this.vDJ);
        arrayList.clear();
        Iterator<Integer> it2 = this.vDL.iterator();
        while (it2.hasNext()) {
            Integer next2 = it2.next();
            if ((next2.intValue() & 1) != 0 || (next2.intValue() & 2) != 0) {
                arrayList.add(next2);
            }
        }
        ap.a aVar4 = ap.vFv;
        this.vDK = ap.a.k(arrayList, "localFlag");
        Log.i("Finder.FinderFeedStorage", "FAIL_OR_WAITING " + this.vDK);
        AppMethodBeat.o(166975);
    }

    public final boolean a(long j2, FinderItem finderItem) {
        AppMethodBeat.i(251727);
        p.h(finderItem, "finder");
        if (j2 == 0) {
            Log.printInfoStack("Finder.FinderFeedStorage", "update svrId " + j2 + ' ' + finderItem.info() + ' ' + Util.getStack(), new Object[0]);
        }
        ContentValues convertTo = finderItem.convertTo();
        convertTo.remove("rowid");
        if (this.db.update(ch.TABLE_NAME, convertTo, "id=?", new String[]{String.valueOf(j2)}) > 0) {
            AppMethodBeat.o(251727);
            return true;
        }
        AppMethodBeat.o(251727);
        return false;
    }

    public final FinderItem Fy(long j2) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(251728);
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM FinderFeedItem  WHERE id = ".concat(String.valueOf(j2)), null, 2);
        FinderItem finderItem = new FinderItem();
        if (rawQuery != null) {
            Cursor cursor = rawQuery;
            try {
                if (rawQuery.moveToFirst()) {
                    finderItem.convertFrom(rawQuery);
                }
                x xVar = x.SXb;
                b.a(cursor, null);
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                b.a(cursor, th2);
                AppMethodBeat.o(251728);
                throw th;
            }
        }
        AppMethodBeat.o(251728);
        return finderItem;
    }

    public final FinderItem Fz(long j2) {
        FinderItem finderItem = null;
        AppMethodBeat.i(166966);
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM FinderFeedItem  WHERE FinderFeedItem.localId=".concat(String.valueOf(j2)), null, 2);
        if (rawQuery.moveToFirst()) {
            finderItem = new FinderItem();
            p.g(rawQuery, "cu");
            finderItem.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(166966);
        return finderItem;
    }

    public final LinkedList<FinderItem> af(String str, int i2, int i3) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(251729);
        p.h(str, ch.COL_USERNAME);
        c cVar = new c("getLocalSenderFeedBeforeTime");
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM FinderFeedItem   WHERE createTime >= " + i2 + " AND createTime < " + i3 + "  ORDER BY createTime DESC", null, 2);
        Log.i("Finder.FinderFeedStorage", "getLocalSenderFeedBeforeTime1 ".concat(String.valueOf(cVar)));
        LinkedList<FinderItem> linkedList = new LinkedList<>();
        Cursor cursor = rawQuery;
        try {
            if (rawQuery.moveToFirst()) {
                do {
                    FinderItem finderItem = new FinderItem();
                    p.g(rawQuery, "cu");
                    finderItem.convertFrom(rawQuery);
                    finderItem.getFeedObject();
                    linkedList.add(finderItem);
                } while (rawQuery.moveToNext());
            }
            x xVar = x.SXb;
            b.a(cursor, null);
            Log.i("Finder.FinderFeedStorage", "getLocalSenderFeedBeforeTime2 ".concat(String.valueOf(cVar)));
            AppMethodBeat.o(251729);
            return linkedList;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(cursor, th2);
            AppMethodBeat.o(251729);
            throw th;
        }
    }

    public final boolean b(long j2, FinderItem finderItem) {
        AppMethodBeat.i(166968);
        p.h(finderItem, "finderObj");
        ContentValues convertTo = finderItem.convertTo();
        convertTo.remove("rowid");
        if (this.db.update(ch.TABLE_NAME, convertTo, "localId=?", new String[]{String.valueOf(j2)}) > 0) {
            AppMethodBeat.o(166968);
            return true;
        }
        AppMethodBeat.o(166968);
        return false;
    }

    public final long k(FinderItem finderItem) {
        AppMethodBeat.i(166969);
        p.h(finderItem, "finderObj");
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        long a2 = aAh.azQ().a(ar.a.USERINFO_FINDER_FINDERITEM_MAXID_LONG_SYNC, 1);
        e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_FINDER_FINDERITEM_MAXID_LONG_SYNC, Long.valueOf(1 + a2));
        finderItem.setLocalId(a2);
        Log.i("Finder.FinderFeedStorage", "new feed rowId " + this.db.insert(ch.TABLE_NAME, ch.COL_LOCALID, finderItem.convertTo()) + ' ' + com.tencent.mm.ac.g.bN(finderItem.getFeedObject()) + " localID: " + a2);
        AppMethodBeat.o(166969);
        return a2;
    }

    public final boolean FA(long j2) {
        AppMethodBeat.i(166970);
        e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        boolean BX = e.a.BX(j2);
        l.a aVar2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
        for (Integer num : com.tencent.mm.plugin.finder.storage.data.l.vGs) {
            int intValue = num.intValue();
            l.a aVar3 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            l.a.L(j2, intValue);
        }
        boolean z = this.db.delete(ch.TABLE_NAME, "id=?", new String[]{String.valueOf(j2)}) > 0;
        if (BX || z) {
            AppMethodBeat.o(166970);
            return true;
        }
        AppMethodBeat.o(166970);
        return false;
    }

    public final void et(List<Long> list) {
        Throwable th;
        Throwable th2;
        arl arl;
        LinkedList<aqq> linkedList;
        arl arl2;
        AppMethodBeat.i(251730);
        p.h(list, "objectIds");
        long uptimeMillis = SystemClock.uptimeMillis();
        l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
        p.h(list, "svrIds");
        j.o(list);
        for (Integer num : com.tencent.mm.plugin.finder.storage.data.l.vGs) {
            int intValue = num.intValue();
            l.a aVar2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            l.a.Lf(intValue);
            LinkedList<arl> linkedList2 = com.tencent.mm.plugin.finder.storage.data.l.vGv.Lg(intValue).vFP.zns;
            if (!(linkedList2 == null || (arl = (arl) j.L(linkedList2, 0)) == null || (linkedList = arl.gCs) == null)) {
                i iVar = i.vGl;
                if (i.a(list, linkedList)) {
                    if (BuildInfo.DEBUG) {
                        StringBuilder sb = new StringBuilder("[deletePageData] ");
                        LinkedList<arl> linkedList3 = com.tencent.mm.plugin.finder.storage.data.l.vGv.Lg(intValue).vFP.zns;
                        Log.i("Finder.FinderPage", sb.append((linkedList3 == null || (arl2 = (arl) j.L(linkedList3, 0)) == null) ? null : arl2.gCs).toString());
                    }
                    l.a aVar3 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                    l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGv.Lg(intValue));
                }
            }
        }
        LongSparseArray longSparseArray = new LongSparseArray();
        Cursor rawQuery = this.db.rawQuery("SELECT id from BaseFinderFeedItem.TABLE_NAME", null, 2);
        try {
            Cursor cursor = rawQuery;
            if (cursor.moveToFirst()) {
                while (true) {
                    p.g(cursor, "cr");
                    if (cursor.isAfterLast()) {
                        break;
                    }
                    long j2 = cursor.getLong(0);
                    longSparseArray.put(j2, Long.valueOf(j2));
                }
            }
            x xVar = x.SXb;
            b.a(rawQuery, null);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                e.a aVar4 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                e.a.BX(longValue);
                if (longSparseArray.indexOfKey(longValue) >= 0) {
                    this.db.delete(ch.TABLE_NAME, "id=?", new String[]{String.valueOf(longValue)});
                }
            }
            if (BuildInfo.DEBUG) {
                Log.d("Finder.FinderFeedStorage", "[deleteByGroupId] objectIds=".concat(String.valueOf(list)));
            }
            Log.i("Finder.FinderFeedStorage", "[deleteByGroupId] size=" + list.size() + " COST=" + (SystemClock.uptimeMillis() - uptimeMillis) + LocaleUtil.MALAY);
            AppMethodBeat.o(251730);
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(rawQuery, th2);
            AppMethodBeat.o(251730);
            throw th;
        }
    }

    public static /* synthetic */ boolean a(l lVar, long j2) {
        AppMethodBeat.i(166972);
        boolean A = lVar.A(j2, true);
        AppMethodBeat.o(166972);
        return A;
    }

    public final boolean A(long j2, boolean z) {
        AppMethodBeat.i(166971);
        if (z) {
            l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            l.a.FQ(j2);
        }
        if (this.db.delete(ch.TABLE_NAME, "localId=?", new String[]{String.valueOf(j2)}) > 0) {
            AppMethodBeat.o(166971);
            return true;
        }
        AppMethodBeat.o(166971);
        return false;
    }

    public final FinderItem dxC() {
        AppMethodBeat.i(166973);
        FinderItem finderItem = new FinderItem();
        String str = "SELECT * FROM FinderFeedItem  WHERE " + this.vDJ + " ORDER BY " + this.TABLE + ".localId ASC LIMIT 1";
        Cursor rawQuery = this.db.rawQuery(str, null, 2);
        Log.d("Finder.FinderFeedStorage", "getWaitingPost ".concat(String.valueOf(str)));
        if (!rawQuery.moveToFirst()) {
            rawQuery.close();
            AppMethodBeat.o(166973);
            return null;
        }
        p.g(rawQuery, "cr");
        finderItem.convertFrom(rawQuery);
        rawQuery.close();
        AppMethodBeat.o(166973);
        return finderItem;
    }

    public final List<FinderItem> dxD() {
        AppMethodBeat.i(166974);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM FinderFeedItem  WHERE localFlag IN (1, 2);", null, 2);
        while (rawQuery.moveToNext()) {
            FinderItem finderItem = new FinderItem();
            p.g(rawQuery, "cr");
            finderItem.convertFrom(rawQuery);
            arrayList.add(finderItem);
        }
        rawQuery.close();
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(166974);
        return arrayList2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(166976);
        FinderItem.a aVar = FinderItem.Companion;
        AppMethodBeat.o(166976);
    }
}
