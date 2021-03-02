package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.protocal.protobuf.fcn;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public final class u extends MStorage {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(a.iBg, "AppBrandStarApp")};
    private static final b<fcn> kVu = new b<fcn>() {
        /* class com.tencent.mm.plugin.appbrand.appusage.u.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.appbrand.appusage.u.b
        public final /* bridge */ /* synthetic */ long cu(fcn fcn) {
            return (long) fcn.KWR;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.appbrand.appusage.u.b
        public final /* bridge */ /* synthetic */ int cv(fcn fcn) {
            return fcn.KXC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.appbrand.appusage.u.b
        public final /* bridge */ /* synthetic */ String cw(fcn fcn) {
            return fcn.username;
        }
    };
    private static final b<LocalUsageInfo> kVv = new b<LocalUsageInfo>() {
        /* class com.tencent.mm.plugin.appbrand.appusage.u.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.appbrand.appusage.u.b
        public final /* bridge */ /* synthetic */ long cu(LocalUsageInfo localUsageInfo) {
            return 0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.appbrand.appusage.u.b
        public final /* bridge */ /* synthetic */ int cv(LocalUsageInfo localUsageInfo) {
            return localUsageInfo.iOo;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.appbrand.appusage.u.b
        public final /* bridge */ /* synthetic */ String cw(LocalUsageInfo localUsageInfo) {
            return localUsageInfo.username;
        }
    };
    final h kVs;
    private final c kVt;

    /* access modifiers changed from: package-private */
    public interface b<T> {
        long cu(T t);

        int cv(T t);

        String cw(T t);
    }

    static {
        AppMethodBeat.i(44590);
        AppMethodBeat.o(44590);
    }

    public u(h hVar) {
        AppMethodBeat.i(44577);
        this.kVs = hVar;
        this.kVt = new c(hVar);
        AppMethodBeat.o(44577);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public final void add(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(44578);
        add("MicroMsg.AppBrandStarAppStorage.WORKER", iOnStorageChange);
        AppMethodBeat.o(44578);
    }

    /* access modifiers changed from: package-private */
    public static final class c extends MAutoStorage<a> {
        c(h hVar) {
            super(hVar, a.iBg, "AppBrandStarApp", a.INDEX_CREATE);
        }
    }

    public final int byk() {
        int i2 = 0;
        AppMethodBeat.i(44579);
        Cursor rawQuery = this.kVs.rawQuery("select count(*) from AppBrandStarApp", null);
        if (rawQuery == null || rawQuery.isClosed()) {
            AppMethodBeat.o(44579);
        } else {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.o(44579);
        }
        return i2;
    }

    public final ArrayList<AppBrandRecentTaskInfo> a(ag.a aVar) {
        AppMethodBeat.i(44580);
        ArrayList<AppBrandRecentTaskInfo> b2 = b(-1, aVar);
        AppMethodBeat.o(44580);
        return b2;
    }

    public final ArrayList<AppBrandRecentTaskInfo> b(int i2, ag.a aVar) {
        AppMethodBeat.i(44581);
        ArrayList<AppBrandRecentTaskInfo> b2 = b(i2, aVar, Integer.MAX_VALUE);
        AppMethodBeat.o(44581);
        return b2;
    }

    public final ArrayList<AppBrandRecentTaskInfo> b(int i2, ag.a aVar, int i3) {
        int min;
        AppMethodBeat.i(44582);
        if (aVar == null) {
            aVar = ag.a.DESC;
        }
        if (aVar == ag.a.UPATE_TIME_DESC) {
            ArrayList<AppBrandRecentTaskInfo> vX = vX(i2);
            AppMethodBeat.o(44582);
            return vX;
        }
        if (i2 <= 0) {
            min = v.byo();
        } else {
            min = Math.min(v.byo(), i2);
        }
        String str = null;
        String[] strArr = null;
        if (i3 != Integer.MAX_VALUE) {
            str = String.format(Locale.US, "%s=?", "versionType");
            strArr = new String[]{String.valueOf(i3)};
        }
        Cursor query = this.kVs.query("AppBrandStarApp", new String[]{ch.COL_USERNAME, "versionType"}, str, strArr, null, null, String.format(Locale.US, "%s desc limit %d offset 0", "orderSequence", Integer.valueOf(min)));
        if (query == null) {
            AppMethodBeat.o(44582);
            return null;
        }
        ArrayList<AppBrandRecentTaskInfo> arrayList = null;
        if (ag.a.ASC != aVar ? query.moveToFirst() : query.moveToLast()) {
            LinkedList linkedList = new LinkedList();
            a aVar2 = new a();
            while (true) {
                aVar2.convertFrom(query);
                linkedList.add(y.a(String.format(Locale.US, "$%s$%d@starapp", aVar2.field_username, Integer.valueOf(aVar2.field_versionType)), aVar2.field_username, aVar2.field_versionType, -1));
                if (ag.a.ASC == aVar) {
                    if (!query.moveToPrevious()) {
                        break;
                    }
                } else if (!query.moveToNext()) {
                    break;
                }
            }
            arrayList = new ArrayList<>(linkedList.size());
            arrayList.addAll(linkedList);
        }
        query.close();
        AppMethodBeat.o(44582);
        return arrayList;
    }

    private ArrayList<AppBrandRecentTaskInfo> vX(int i2) {
        AppMethodBeat.i(44583);
        Cursor rawQuery = this.kVs.rawQuery("select AppBrandStarApp.username, AppBrandStarApp.versionType, AppBrandLocalUsageRecord.updateTime from AppBrandStarApp left outer join AppBrandLocalUsageRecord on AppBrandStarApp.username = AppBrandLocalUsageRecord.username and AppBrandStarApp.versionType = AppBrandLocalUsageRecord.versionType order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(i2, 1) + " offset 0", null);
        if (rawQuery == null) {
            AppMethodBeat.o(44583);
            return null;
        } else if (!rawQuery.moveToFirst()) {
            rawQuery.close();
            AppMethodBeat.o(44583);
            return null;
        } else {
            LinkedList linkedList = new LinkedList();
            do {
                String string = rawQuery.getString(0);
                if (!Util.isNullOrNil(string)) {
                    int i3 = rawQuery.getInt(1);
                    linkedList.add(y.a(String.format(Locale.US, "$%s$%d@starapp", string, Integer.valueOf(i3)), string, i3, rawQuery.getLong(2)));
                }
            } while (rawQuery.moveToNext());
            rawQuery.close();
            ArrayList<AppBrandRecentTaskInfo> arrayList = new ArrayList<>(linkedList.size());
            arrayList.addAll(linkedList);
            AppMethodBeat.o(44583);
            return arrayList;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.mm.plugin.appbrand.appusage.u$b] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.tencent.mm.plugin.appbrand.appusage.u$b<com.tencent.mm.protocal.protobuf.fcn>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> void a(java.lang.Class<T> r13, java.util.List<T> r14, java.lang.Long r15) {
        /*
        // Method dump skipped, instructions count: 163
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appusage.u.a(java.lang.Class, java.util.List, java.lang.Long):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int bk(java.lang.String r14, int r15) {
        /*
        // Method dump skipped, instructions count: 503
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appusage.u.bk(java.lang.String, int):int");
    }

    public final boolean bl(String str, int i2) {
        AppMethodBeat.i(44588);
        boolean j2 = j(str, i2, true);
        AppMethodBeat.o(44588);
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(java.lang.String r10, int r11, boolean r12) {
        /*
        // Method dump skipped, instructions count: 201
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appusage.u.j(java.lang.String, int, boolean):boolean");
    }

    public static final class a extends com.tencent.mm.g.c.u {
        static final IAutoDBItem.MAutoDBInfo iBg;
        static final String[] kJX = {ch.COL_USERNAME, "versionType"};

        @Override // com.tencent.mm.sdk.storage.IAutoDBItem
        public final IAutoDBItem.MAutoDBInfo getDBInfo() {
            return iBg;
        }

        static {
            AppMethodBeat.i(44576);
            IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
            mAutoDBInfo.fields = new Field[4];
            mAutoDBInfo.columns = new String[5];
            StringBuilder sb = new StringBuilder();
            mAutoDBInfo.columns[0] = ch.COL_USERNAME;
            mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
            sb.append(" username TEXT");
            sb.append(", ");
            mAutoDBInfo.columns[1] = "versionType";
            mAutoDBInfo.colsMap.put("versionType", "INTEGER");
            sb.append(" versionType INTEGER");
            sb.append(", ");
            mAutoDBInfo.columns[2] = ch.COL_UPDATETIME;
            mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
            sb.append(" updateTime LONG");
            sb.append(", ");
            mAutoDBInfo.columns[3] = "orderSequence";
            mAutoDBInfo.colsMap.put("orderSequence", "LONG");
            sb.append(" orderSequence LONG");
            mAutoDBInfo.columns[4] = "rowid";
            mAutoDBInfo.sql = sb.toString();
            iBg = mAutoDBInfo;
            String str = " PRIMARY KEY ( ";
            String[] strArr = kJX;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                str = str + ", " + strArr[i2];
            }
            String str2 = str.replaceFirst(",", "") + " )";
            StringBuilder sb2 = new StringBuilder();
            IAutoDBItem.MAutoDBInfo mAutoDBInfo2 = iBg;
            mAutoDBInfo2.sql = sb2.append(mAutoDBInfo2.sql).append(",").append(str2).toString();
            AppMethodBeat.o(44576);
        }
    }

    public final boolean bj(String str, int i2) {
        Cursor cursor = null;
        AppMethodBeat.i(44584);
        if (!Util.isNullOrNil(str)) {
            cursor = this.kVs.query("AppBrandStarApp", null, String.format(Locale.US, "%s=? and %s=?", ch.COL_USERNAME, "versionType"), new String[]{str, String.valueOf(i2)}, null, null, null);
        }
        if (cursor == null) {
            AppMethodBeat.o(44584);
            return false;
        }
        boolean moveToFirst = cursor.moveToFirst();
        cursor.close();
        AppMethodBeat.o(44584);
        return moveToFirst;
    }
}
