package com.tencent.mm.plugin.newtips.b;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d extends MAutoStorage<c> {
    private static final Long ADQ = 1209600L;
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS uniqueIdIndex ON NewTipsInfo2 ( uniqueId )", "CREATE INDEX IF NOT EXISTS pathQueryIndex ON NewTipsInfo2 ( path,state,beginShowTime,disappearTime )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "NewTipsInfo2")};
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(c cVar) {
        AppMethodBeat.i(127280);
        boolean a2 = a(cVar);
        AppMethodBeat.o(127280);
        return a2;
    }

    static {
        AppMethodBeat.i(127281);
        AppMethodBeat.o(127281);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "NewTipsInfo2", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final List<c> c(e eVar) {
        AppMethodBeat.i(188568);
        if (eVar == null) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(188568);
            return arrayList;
        } else if (eVar.ADS) {
            List<c> aID = aID(eVar.ADR);
            AppMethodBeat.o(188568);
            return aID;
        } else {
            List<c> TG = TG(eVar.path);
            AppMethodBeat.o(188568);
            return TG;
        }
    }

    private List<c> TG(int i2) {
        AppMethodBeat.i(127272);
        ArrayList arrayList = new ArrayList();
        if (i2 == 0) {
            AppMethodBeat.o(127272);
            return arrayList;
        }
        long aWy = cl.aWy() / 1000;
        Cursor query = this.db.query("NewTipsInfo2", c.info.columns, "path=? and state=? and beginShowTime<=? and maxClientVersion>=? and minClientVersion<=?", new String[]{String.valueOf(i2), AppEventsConstants.EVENT_PARAM_VALUE_NO, String.valueOf(aWy), new StringBuilder().append(com.tencent.mm.protocal.d.KyO).toString(), new StringBuilder().append(com.tencent.mm.protocal.d.KyO).toString()}, null, null, null);
        if (query == null) {
            AppMethodBeat.o(127272);
            return arrayList;
        }
        while (query.moveToNext()) {
            c cVar = new c();
            cVar.convertFrom(query);
            if (a(aWy, cVar)) {
                arrayList.add(cVar);
            }
        }
        AppMethodBeat.o(127272);
        return arrayList;
    }

    private List<c> aID(String str) {
        AppMethodBeat.i(188569);
        ArrayList arrayList = new ArrayList();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(188569);
            return arrayList;
        }
        long aWy = cl.aWy() / 1000;
        Cursor query = this.db.query("NewTipsInfo2", c.info.columns, "dynamicPath=? and state=? and beginShowTime<=? and maxClientVersion>=? and minClientVersion<=?", new String[]{str, AppEventsConstants.EVENT_PARAM_VALUE_NO, String.valueOf(aWy), new StringBuilder().append(com.tencent.mm.protocal.d.KyO).toString(), new StringBuilder().append(com.tencent.mm.protocal.d.KyO).toString()}, null, null, null);
        if (query == null) {
            AppMethodBeat.o(188569);
            return arrayList;
        }
        while (query.moveToNext()) {
            c cVar = new c();
            cVar.convertFrom(query);
            if (a(aWy, cVar)) {
                arrayList.add(cVar);
            }
        }
        AppMethodBeat.o(188569);
        return arrayList;
    }

    private static boolean a(long j2, c cVar) {
        long j3;
        AppMethodBeat.i(127273);
        if (cVar.field_exposureTime != 0 && j2 - cVar.field_exposureTime > ADQ.longValue()) {
            AppMethodBeat.o(127273);
            return false;
        } else if (cVar.field_overdueTime != 0) {
            if (cVar.field_exposureTime == 0) {
                j3 = cVar.field_overdueTime + j2;
            } else {
                j3 = cVar.field_exposureDisappearTime;
            }
            if (cVar.field_disappearTime != 0) {
                j3 = Math.min(j3, cVar.field_disappearTime);
            }
            if (j2 < j3) {
                AppMethodBeat.o(127273);
                return true;
            }
            AppMethodBeat.o(127273);
            return false;
        } else if (j2 < cVar.field_disappearTime) {
            AppMethodBeat.o(127273);
            return true;
        } else {
            AppMethodBeat.o(127273);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0036 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean Hw(long r12) {
        /*
            r11 = this;
            r9 = 127274(0x1f12a, float:1.78349E-40)
            r0 = 1
            r1 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r9)
            com.tencent.mm.sdk.storage.ISQLiteDatabase r2 = r11.db     // Catch:{ Exception -> 0x003c }
            java.lang.String r3 = "NewTipsInfo2"
            java.lang.String r4 = "disappearTime!=0 and disappearTime<?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ Exception -> 0x003c }
            r6 = 0
            java.lang.String r7 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x003c }
            r5[r6] = r7     // Catch:{ Exception -> 0x003c }
            int r3 = r2.delete(r3, r4, r5)     // Catch:{ Exception -> 0x003c }
            com.tencent.mm.sdk.storage.ISQLiteDatabase r2 = r11.db     // Catch:{ Exception -> 0x0056 }
            java.lang.String r4 = "NewTipsInfo2"
            java.lang.String r5 = "disappearTime=0 and exposureTime!=0 and exposureDisappearTime<?"
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ Exception -> 0x0056 }
            r7 = 0
            java.lang.String r8 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0056 }
            r6[r7] = r8     // Catch:{ Exception -> 0x0056 }
            int r2 = r2.delete(r4, r5, r6)     // Catch:{ Exception -> 0x0056 }
        L_0x0034:
            if (r3 <= 0) goto L_0x0051
            if (r2 <= 0) goto L_0x0051
            com.tencent.matrix.trace.core.AppMethodBeat.o(r9)
        L_0x003b:
            return r0
        L_0x003c:
            r2 = move-exception
            r3 = r1
        L_0x003e:
            java.lang.String r4 = "MicroMsg.NewTips.NewTipsInfoStorage"
            java.lang.String r5 = "deleteExpireData NewTipsInfo by dissappearTime [%s]"
            java.lang.Object[] r6 = new java.lang.Object[r0]
            java.lang.String r2 = r2.toString()
            r6[r1] = r2
            com.tencent.mm.sdk.platformtools.Log.e(r4, r5, r6)
            r2 = r1
            goto L_0x0034
        L_0x0051:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r9)
            r0 = r1
            goto L_0x003b
        L_0x0056:
            r2 = move-exception
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.newtips.b.d.Hw(long):boolean");
    }

    public final boolean aHo() {
        int i2;
        AppMethodBeat.i(127275);
        try {
            i2 = this.db.delete("NewTipsInfo2", null, null);
        } catch (Exception e2) {
            Log.e("MicroMsg.NewTips.NewTipsInfoStorage", "deleteAllData exception:%s", e2.toString());
            i2 = 0;
        }
        if (i2 > 0) {
            AppMethodBeat.o(127275);
            return true;
        }
        AppMethodBeat.o(127275);
        return false;
    }

    public final List<c> aIE(String str) {
        AppMethodBeat.i(127276);
        ArrayList arrayList = new ArrayList();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(127276);
            return arrayList;
        }
        Cursor query = this.db.query("NewTipsInfo2", c.info.columns, "uniqueId=?", new String[]{String.valueOf(str)}, null, null, null);
        if (query == null) {
            AppMethodBeat.o(127276);
            return arrayList;
        }
        while (query.moveToNext()) {
            c cVar = new c();
            cVar.convertFrom(query);
            arrayList.add(cVar);
        }
        AppMethodBeat.o(127276);
        return arrayList;
    }

    public final int fI(List<c> list) {
        h hVar;
        long j2 = -1;
        AppMethodBeat.i(127277);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(127277);
            return 0;
        }
        if (this.db instanceof h) {
            h hVar2 = (h) this.db;
            j2 = hVar2.beginTransaction(j2);
            hVar = hVar2;
        } else {
            hVar = null;
        }
        try {
            Iterator<c> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                c next = it.next();
                i2 = next == null ? false : update(next.systemRowid, next) ? i2 + 1 : i2;
            }
            return i2;
        } finally {
            if (hVar != null) {
                hVar.endTransaction(j2);
            }
            AppMethodBeat.o(127277);
        }
    }

    public final int bb(List<c> list) {
        h hVar;
        int i2;
        long j2 = -1;
        int i3 = 0;
        AppMethodBeat.i(127278);
        if (list.size() <= 0) {
            AppMethodBeat.o(127278);
        } else {
            if (this.db instanceof h) {
                h hVar2 = (h) this.db;
                j2 = hVar2.beginTransaction(j2);
                hVar = hVar2;
            } else {
                hVar = null;
            }
            try {
                for (c cVar : list) {
                    if (a(cVar)) {
                        i2 = i3 + 1;
                    } else {
                        i2 = i3;
                    }
                    i3 = i2;
                }
            } finally {
                if (hVar != null) {
                    hVar.endTransaction(j2);
                }
                AppMethodBeat.o(127278);
            }
        }
        return i3;
    }

    private boolean a(c cVar) {
        AppMethodBeat.i(127279);
        if (cVar == null) {
            AppMethodBeat.o(127279);
            return false;
        }
        boolean insert = super.insert(cVar);
        AppMethodBeat.o(127279);
        return insert;
    }
}
