package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDiskIOException;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.p;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appusage.n;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.protocal.protobuf.fcn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storagebase.h;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class x extends MStorage {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(a.iBg, "AppBrandLauncherLayoutItem")};
    private final b kVA;
    public final c kVB = new c(this, (byte) 0);
    public final h kVs;

    static /* synthetic */ int L(String str, int i2, int i3) {
        AppMethodBeat.i(44626);
        int K = K(str, i2, i3);
        AppMethodBeat.o(44626);
        return K;
    }

    static {
        AppMethodBeat.i(44627);
        AppMethodBeat.o(44627);
    }

    public x(h hVar) {
        AppMethodBeat.i(44609);
        this.kVs = hVar;
        this.kVA = new b(hVar);
        AppMethodBeat.o(44609);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public final void add(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(44610);
        add("MicroMsg.AppBrandUsageStorage.WORKER", iOnStorageChange);
        AppMethodBeat.o(44610);
    }

    /* access modifiers changed from: package-private */
    public final Cursor a(String[] strArr, int i2, int i3) {
        AppMethodBeat.i(44612);
        Cursor a2 = a(strArr, i2, i3, Integer.MAX_VALUE);
        AppMethodBeat.o(44612);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final Cursor a(String[] strArr, int i2, int i3, int i4) {
        String format;
        String[] strArr2;
        AppMethodBeat.i(44613);
        if (i4 == Integer.MAX_VALUE) {
            format = String.format(Locale.US, "%s=? order by %s desc limit %d offset %d", "scene", ch.COL_UPDATETIME, Integer.valueOf(i2), Integer.valueOf(i3));
            strArr2 = new String[]{"2"};
        } else {
            format = String.format(Locale.US, "%s=? and %s=? order by %s desc limit %d offset %d", "scene", "versionType", ch.COL_UPDATETIME, Integer.valueOf(i2), Integer.valueOf(i3));
            strArr2 = new String[]{"2", String.valueOf(i4)};
        }
        Cursor query = this.kVs.query("AppBrandLauncherLayoutItem", strArr, format, strArr2, null, null, null);
        AppMethodBeat.o(44613);
        return query;
    }

    public static ArrayList<AppBrandRecentTaskInfo> d(Cursor cursor) {
        ArrayList<AppBrandRecentTaskInfo> arrayList;
        AppMethodBeat.i(44614);
        if (cursor == null) {
            ArrayList<AppBrandRecentTaskInfo> arrayList2 = new ArrayList<>();
            AppMethodBeat.o(44614);
            return arrayList2;
        }
        try {
            if (cursor.moveToFirst()) {
                LinkedList linkedList = new LinkedList();
                a aVar = new a();
                do {
                    aVar.convertFrom(cursor);
                    if (!Util.isNullOrNil(aVar.field_brandId)) {
                        linkedList.add(y.a(String.valueOf(aVar.field_recordId), aVar.field_brandId, aVar.field_versionType, aVar.field_updateTime, aVar.field_usedInThirdPartyAppRecently, aVar.field_thirdPartyAppUsingDesc));
                    }
                } while (cursor.moveToNext());
                arrayList = new ArrayList<>(linkedList.size());
                arrayList.addAll(linkedList);
            } else {
                arrayList = new ArrayList<>();
            }
            return arrayList;
        } catch (SQLiteDiskIOException | com.tencent.wcdb.database.SQLiteDiskIOException e2) {
            Log.e("MicroMsg.AppBrandUsageStorage", "obtainHistoryList e=%s", e2);
            return new ArrayList<>(0);
        } finally {
            cursor.close();
            AppMethodBeat.o(44614);
        }
    }

    public final class c {
        /* synthetic */ c(x xVar, byte b2) {
            this();
        }

        private c() {
        }

        public final ArrayList<AppBrandRecentTaskInfo> byr() {
            AppMethodBeat.i(226394);
            ArrayList<AppBrandRecentTaskInfo> g2 = g(MAlarmHandler.NEXT_FIRE_INTERVAL, 30);
            AppMethodBeat.o(226394);
            return g2;
        }

        public final ArrayList<AppBrandRecentTaskInfo> g(long j2, int i2) {
            AppMethodBeat.i(226395);
            ArrayList<AppBrandRecentTaskInfo> d2 = x.d(x.this.kVs.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s<? ", "scene", ch.COL_UPDATETIME), new String[]{"2", String.valueOf(j2)}, null, null, String.format(Locale.US, "%s desc limit %d offset 0 ", ch.COL_UPDATETIME, Integer.valueOf(i2)), 2));
            AppMethodBeat.o(226395);
            return d2;
        }
    }

    public final c byp() {
        return this.kVB;
    }

    public final List<String> Ww(String str) {
        AppMethodBeat.i(44616);
        LinkedList linkedList = new LinkedList();
        if (!Util.isNullOrNil(str)) {
            Cursor query = this.kVs.query("AppBrandLauncherLayoutItem", new String[]{"recordId"}, String.format(Locale.US, "%s=? and %s=?", "scene", "brandId"), new String[]{"2", str}, null, null, null);
            if (query == null) {
                AppMethodBeat.o(44616);
                return null;
            }
            if (query.moveToFirst()) {
                do {
                    linkedList.add(String.valueOf(query.getInt(query.getColumnIndex("recordId"))));
                } while (query.moveToNext());
            }
            query.close();
        }
        AppMethodBeat.o(44616);
        return linkedList;
    }

    private boolean a(String str, int i2, boolean z, boolean z2, int i3, int i4, String str2) {
        long j2;
        boolean z3;
        boolean z4;
        AppMethodBeat.i(44617);
        if (Util.isNullOrNil(str) || 999 == i2) {
            AppMethodBeat.o(44617);
            return false;
        }
        Cursor rawQuery = this.kVs.rawQuery(String.format(Locale.US, "select max(%s) from %s where %s=?", ch.COL_UPDATETIME, "AppBrandLauncherLayoutItem", "scene"), new String[]{"2"});
        if (rawQuery == null) {
            j2 = 0;
        } else {
            j2 = 0;
            if (rawQuery.moveToFirst()) {
                j2 = rawQuery.getLong(0);
            }
            rawQuery.close();
        }
        long max = Math.max(j2 + 1, Util.nowSecond());
        int K = K(str, i2, 2);
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(ch.COL_UPDATETIME, Long.valueOf(max));
        contentValues.put("usedInThirdPartyAppRecently", Boolean.FALSE);
        contentValues.put("thirdPartyAppUsingDesc", "");
        boolean z5 = this.kVs.update("AppBrandLauncherLayoutItem", contentValues, String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{String.valueOf(K)}) > 0;
        if (z5) {
            doNotify(MStorageEventData.EventType.SINGLE, 3, String.valueOf(K));
        }
        if (!z5) {
            a aVar = new a();
            aVar.field_updateTime = max;
            aVar.field_scene = 2;
            aVar.field_brandId = str;
            aVar.field_versionType = i2;
            boolean a2 = a(aVar);
            if (a2) {
                doNotify(MStorageEventData.EventType.SINGLE, 2, String.valueOf(K));
            }
            z4 = a2;
            z3 = a2;
        } else {
            z3 = true;
            z4 = false;
        }
        if (z3 && z) {
            Pair<Boolean, Integer> I = ((com.tencent.mm.plugin.appbrand.appcache.predownload.e.b) n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.e.b.class)).I(str, 3, i3);
            if (((Boolean) I.first).booleanValue()) {
                Log.i("MicroMsg.AppBrandUsageStorage", "addRecord, addOk TRUE, cgi blocked by username(%s), scene(%d)", str, Integer.valueOf(i3));
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar2 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) ((Integer) I.second).intValue(), 165);
            } else {
                new ab(i3, z2, i2, 1, str, i4, str2).aYI();
            }
        }
        if (z3) {
            ac.aR(str, i2);
        }
        if (z4) {
            byq();
        }
        if (z3) {
            ((n) n.W(n.class)).a(str, i2, n.a.USAGE_LIST);
        }
        AppMethodBeat.o(44617);
        return z3;
    }

    private boolean bn(String str, int i2) {
        boolean z = true;
        AppMethodBeat.i(44619);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44619);
            return false;
        }
        if (this.kVs.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", "recordId"), new String[]{String.valueOf(K(str, i2, 2))}) <= 0) {
            z = false;
        }
        if (z) {
            ((n) com.tencent.mm.plugin.appbrand.app.n.W(n.class)).b(str, i2, n.a.USAGE_LIST);
        }
        AppMethodBeat.o(44619);
        return z;
    }

    public final boolean a(String str, int i2, boolean z, int i3, int i4, String str2, boolean z2) {
        AppMethodBeat.i(226396);
        boolean a2 = a(str, i2, true, z, i3, i4, str2);
        if (a2) {
            i.b(true, !z2, str2);
        }
        AppMethodBeat.o(226396);
        return a2;
    }

    public final void bo(String str, int i2) {
        AppMethodBeat.i(44621);
        a(str, i2, false, false, 0, 0, (String) null);
        AppMethodBeat.o(44621);
    }

    public final boolean bp(String str, int i2) {
        AppMethodBeat.i(44622);
        boolean bn = bn(str, i2);
        if (bn) {
            ab.br(str, i2).aYI();
            doNotify(MStorageEventData.EventType.SINGLE, 5, String.valueOf(K(str, i2, 2)));
        }
        AppMethodBeat.o(44622);
        return bn;
    }

    public final boolean bq(String str, int i2) {
        boolean z = true;
        AppMethodBeat.i(44623);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(44623);
            return false;
        }
        Cursor rawQuery = this.kVs.rawQuery(String.format("select count(*) from %s where %s=?", "AppBrandLauncherLayoutItem", "recordId"), new String[]{String.valueOf(K(str, i2, 2))}, 2);
        if (rawQuery == null || rawQuery.isClosed()) {
            AppMethodBeat.o(44623);
            return false;
        }
        try {
            if (rawQuery.moveToFirst()) {
                if (rawQuery.getInt(0) <= 0) {
                    z = false;
                }
                return z;
            }
            rawQuery.close();
            AppMethodBeat.o(44623);
            return false;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(44623);
        }
    }

    /* access modifiers changed from: package-private */
    public final void bk(List<fcn> list) {
        AppMethodBeat.i(226397);
        a aVar = new a();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        long beginTransaction = this.kVs.beginTransaction(Thread.currentThread().getId());
        for (fcn fcn : list) {
            if (!Util.isNullOrNil(fcn.username)) {
                aVar.field_brandId = fcn.username;
                aVar.field_versionType = fcn.KXC;
                aVar.field_scene = 2;
                if (!this.kVA.get(aVar, new String[0])) {
                    aVar.field_updateTime = (long) fcn.KWR;
                    aVar.field_usedInThirdPartyAppRecently = fcn.Nyt;
                    aVar.field_thirdPartyAppUsingDesc = fcn.Nyu;
                    if (a(aVar)) {
                        linkedList.add(String.valueOf(aVar.field_recordId));
                    }
                } else {
                    aVar.field_updateTime = Math.max((long) fcn.KWR, aVar.field_updateTime);
                    aVar.field_usedInThirdPartyAppRecently = fcn.Nyt;
                    aVar.field_thirdPartyAppUsingDesc = fcn.Nyu;
                    if (this.kVA.update(aVar, new String[0])) {
                        linkedList2.add(String.valueOf(aVar.field_recordId));
                    }
                }
            }
        }
        this.kVs.endTransaction(beginTransaction);
        if (!Util.isNullOrNil(linkedList)) {
            doNotify(MStorageEventData.EventType.BATCH, 2, linkedList);
        }
        if (!Util.isNullOrNil(linkedList2)) {
            doNotify(MStorageEventData.EventType.BATCH, 3, linkedList2);
        }
        AppMethodBeat.o(226397);
    }

    private boolean a(a aVar) {
        AppMethodBeat.i(44624);
        if (Util.isNullOrNil(aVar.field_brandId)) {
            AppMethodBeat.o(44624);
            return false;
        }
        long insert = this.kVs.insert("AppBrandLauncherLayoutItem", "", aVar.convertTo());
        if (insert > 0 || insert == ((long) aVar.field_recordId)) {
            AppMethodBeat.o(44624);
            return true;
        }
        AppMethodBeat.o(44624);
        return false;
    }

    public static final class a extends p {
        static final IAutoDBItem.MAutoDBInfo iBg;
        static final String[] kJX = {"brandId", "versionType", "scene"};

        @Override // com.tencent.mm.sdk.storage.IAutoDBItem
        public final IAutoDBItem.MAutoDBInfo getDBInfo() {
            return iBg;
        }

        @Override // com.tencent.mm.g.c.p, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
        public final ContentValues convertTo() {
            AppMethodBeat.i(44606);
            this.systemRowid = 0;
            ContentValues convertTo = super.convertTo();
            int L = x.L(this.field_brandId, this.field_versionType, this.field_scene);
            this.field_recordId = L;
            convertTo.put("recordId", Integer.valueOf(L));
            AppMethodBeat.o(44606);
            return convertTo;
        }

        static {
            AppMethodBeat.i(44607);
            IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
            mAutoDBInfo.fields = new Field[7];
            mAutoDBInfo.columns = new String[8];
            StringBuilder sb = new StringBuilder();
            mAutoDBInfo.columns[0] = "recordId";
            mAutoDBInfo.colsMap.put("recordId", "INTEGER PRIMARY KEY ");
            sb.append(" recordId INTEGER PRIMARY KEY ");
            sb.append(", ");
            mAutoDBInfo.primaryKey = "recordId";
            mAutoDBInfo.columns[1] = "brandId";
            mAutoDBInfo.colsMap.put("brandId", "TEXT");
            sb.append(" brandId TEXT");
            sb.append(", ");
            mAutoDBInfo.columns[2] = "versionType";
            mAutoDBInfo.colsMap.put("versionType", "INTEGER");
            sb.append(" versionType INTEGER");
            sb.append(", ");
            mAutoDBInfo.columns[3] = ch.COL_UPDATETIME;
            mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
            sb.append(" updateTime LONG");
            sb.append(", ");
            mAutoDBInfo.columns[4] = "scene";
            mAutoDBInfo.colsMap.put("scene", "INTEGER");
            sb.append(" scene INTEGER");
            sb.append(", ");
            mAutoDBInfo.columns[5] = "usedInThirdPartyAppRecently";
            mAutoDBInfo.colsMap.put("usedInThirdPartyAppRecently", "INTEGER default 'false' ");
            sb.append(" usedInThirdPartyAppRecently INTEGER default 'false' ");
            sb.append(", ");
            mAutoDBInfo.columns[6] = "thirdPartyAppUsingDesc";
            mAutoDBInfo.colsMap.put("thirdPartyAppUsingDesc", "TEXT");
            sb.append(" thirdPartyAppUsingDesc TEXT");
            mAutoDBInfo.columns[7] = "rowid";
            mAutoDBInfo.sql = sb.toString();
            iBg = mAutoDBInfo;
            AppMethodBeat.o(44607);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b extends MAutoStorage<a> {
        b(ISQLiteDatabase iSQLiteDatabase) {
            super(iSQLiteDatabase, a.iBg, "AppBrandLauncherLayoutItem", a.INDEX_CREATE);
        }
    }

    private static int K(String str, int i2, int i3) {
        AppMethodBeat.i(44625);
        int hashCode = String.format(Locale.US, "%s|%d|%d", str, Integer.valueOf(i2), Integer.valueOf(i3)).hashCode();
        AppMethodBeat.o(44625);
        return hashCode;
    }

    public final boolean bm(String str, int i2) {
        boolean z = true;
        AppMethodBeat.i(44611);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44611);
            return false;
        }
        Cursor rawQuery = this.kVs.rawQuery(String.format(Locale.US, "select count(*) from %s where %s=? and %s=? and %s=?", "AppBrandLauncherLayoutItem", "brandId", "versionType", "scene"), new String[]{str, String.valueOf(i2), "2"});
        if (rawQuery == null) {
            AppMethodBeat.o(44611);
            return false;
        }
        if (!rawQuery.moveToFirst()) {
            z = false;
        } else if (rawQuery.getInt(0) <= 0) {
            z = false;
        }
        rawQuery.close();
        AppMethodBeat.o(44611);
        return z;
    }

    public final ArrayList<AppBrandRecentTaskInfo> vZ(int i2) {
        AppMethodBeat.i(44615);
        ArrayList<AppBrandRecentTaskInfo> d2 = d(a(null, i2, 0));
        AppMethodBeat.o(44615);
        return d2;
    }

    private void byq() {
        int i2;
        AppMethodBeat.i(44618);
        Cursor rawQuery = this.kVs.rawQuery(String.format(Locale.US, "select count(*) from %s where %s=?", "AppBrandLauncherLayoutItem", "scene"), new String[]{"2"});
        if (rawQuery == null) {
            i2 = 0;
        } else {
            i2 = 0;
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        if (i2 > 10000) {
            Cursor a2 = a(new String[]{"recordId", "brandId", "versionType"}, Integer.MAX_VALUE, 10000);
            if (a2 == null) {
                AppMethodBeat.o(44618);
                return;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList(i2 - 10000);
            ArrayList arrayList2 = new ArrayList(i2 - 10000);
            if (a2.moveToFirst()) {
                do {
                    linkedList.add(String.valueOf(a2.getInt(0)));
                    arrayList.add(a2.getString(1));
                    arrayList2.add(Integer.valueOf(a2.getInt(2)));
                } while (a2.moveToNext());
            }
            a2.close();
            if (Util.isNullOrNil(linkedList)) {
                AppMethodBeat.o(44618);
                return;
            }
            long beginTransaction = this.kVs.beginTransaction(Thread.currentThread().getId());
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                this.kVs.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", "recordId"), new String[]{(String) it.next()});
            }
            this.kVs.endTransaction(beginTransaction);
            ArrayList arrayList3 = new ArrayList(arrayList.size());
            ArrayList arrayList4 = new ArrayList(arrayList.size());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String Xw = y.Xw((String) arrayList.get(i3));
                if (!Util.isNullOrNil(Xw)) {
                    arrayList3.add(Xw);
                    arrayList4.add(arrayList2.get(i3));
                }
            }
            if (com.tencent.mm.plugin.appbrand.app.n.buL() != null) {
                com.tencent.mm.plugin.appbrand.app.n.buL().f(arrayList3, arrayList4);
            }
            doNotify(MStorageEventData.EventType.BATCH, 5, linkedList);
        }
        AppMethodBeat.o(44618);
    }
}
