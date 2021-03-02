package com.tencent.mm.plugin.forcenotify.d;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0005J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u0005J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019J\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001cJ\u0006\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0002J\u0016\u0010 \u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0015J\u0016\u0010#\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/storage/ForceNotifyStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "()V", "TABLE_NAME", "", "TAG", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/storagebase/SqliteDB;", "mCache", "Ljava/util/concurrent/ConcurrentHashMap;", "delete", "", "forcePushId", "deleteExpireInfo", "", "deleteGameLife", "get", "userName", "getById", "getErrorCount", "", "getExpireTime", "", "getList", "Ljava/util/ArrayList;", "getListExcept", "pushIdList", "", "getUnExpireCount", "isHasSetForceNotify", "isNeedNotify", "set", "info", "transformOldData", "updateStatus", "status", "plugin-force-notify_release"})
public final class a extends MAutoStorage<d> {
    public static final h iFy;
    public static final ConcurrentHashMap<String, d> wLT = new ConcurrentHashMap<>();
    public static final a wLU = new a();

    static {
        AppMethodBeat.i(149193);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        h dataDB = aAh.getDataDB();
        if (dataDB == null) {
            p.hyc();
        }
        iFy = dataDB;
        AppMethodBeat.o(149193);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private a() {
        /*
            r7 = this;
            r6 = 149192(0x246c8, float:2.09063E-40)
            com.tencent.mm.kernel.e r0 = com.tencent.mm.kernel.g.aAh()
            java.lang.String r1 = "MMKernel.storage()"
            kotlin.g.b.p.g(r0, r1)
            com.tencent.mm.storagebase.h r0 = r0.getDataDB()
            com.tencent.mm.sdk.storage.ISQLiteDatabase r0 = (com.tencent.mm.sdk.storage.ISQLiteDatabase) r0
            com.tencent.mm.sdk.storage.IAutoDBItem$MAutoDBInfo r1 = com.tencent.mm.plugin.forcenotify.c.d.info
            java.lang.String r2 = "ForceNotifyData"
            r3 = 5
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            java.lang.String r5 = "DROP INDEX IF EXISTS statusIndex"
            r3[r4] = r5
            r4 = 1
            java.lang.String r5 = "CREATE INDEX IF NOT EXISTS userNameIndex ON ForceNotifyData(UserName)"
            r3[r4] = r5
            r4 = 2
            java.lang.String r5 = "CREATE INDEX IF NOT EXISTS forcePushIdIndex ON ForceNotifyData(ForcePushId)"
            r3[r4] = r5
            r4 = 3
            java.lang.String r5 = "CREATE INDEX IF NOT EXISTS ForceNotifyData_statusIndex ON ForceNotifyData(Status)"
            r3[r4] = r5
            r4 = 4
            java.lang.String r5 = "CREATE INDEX IF NOT EXISTS expireTimeIndex ON ForceNotifyData(ExpiredTime)"
            r3[r4] = r5
            r7.<init>(r0, r1, r2, r3)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.forcenotify.d.a.<init>():void");
    }

    public static boolean axC(String str) {
        Throwable th;
        d dVar;
        Throwable th2 = null;
        AppMethodBeat.i(149182);
        p.h(str, "forcePushId");
        Log.i("MicroMsg.ForceNotifyStorage", "isNeedNotify(" + str + ')');
        if (wLT.isEmpty() || (dVar = wLT.get(str)) == null) {
            Cursor query = iFy.query("ForceNotifyData", new String[]{"*"}, "ForcePushId=?", new String[]{str}, null, null, null, 2);
            Cursor cursor = query;
            try {
                if (query.moveToFirst()) {
                    d dVar2 = new d();
                    dVar2.convertFrom(query);
                    wLT.put(str, dVar2);
                    Log.i("MicroMsg.ForceNotifyStorage", "[isNeedNotify] forcePushId:%s %s", str, dVar2);
                    boolean z = !dVar2.dMp() && dVar2.isEnable();
                    b.a(cursor, null);
                    AppMethodBeat.o(149182);
                    return z;
                }
                x xVar = x.SXb;
                b.a(cursor, null);
                AppMethodBeat.o(149182);
                return false;
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                b.a(cursor, th2);
                AppMethodBeat.o(149182);
                throw th;
            }
        } else if (dVar.dMp() || !dVar.isEnable()) {
            AppMethodBeat.o(149182);
            return false;
        } else {
            AppMethodBeat.o(149182);
            return true;
        }
    }

    public static boolean axF(String str) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(149183);
        p.h(str, "forcePushId");
        Log.i("MicroMsg.ForceNotifyStorage", "isHasSetForceNotify(" + str + ')');
        if (wLT.isEmpty()) {
            Cursor query = iFy.query("ForceNotifyData", new String[]{"*"}, "ForcePushId=?", new String[]{str}, null, null, null, 2);
            Cursor cursor = query;
            if (query == null) {
                try {
                    p.hyc();
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    b.a(cursor, th2);
                    AppMethodBeat.o(149183);
                    throw th;
                }
            }
            if (query.moveToFirst()) {
                d dVar = new d();
                dVar.convertFrom(query);
                Log.i("MicroMsg.ForceNotifyStorage", "[isHasSetForceNotify] id:%s %s", str, dVar);
                b.a(cursor, null);
                AppMethodBeat.o(149183);
                return true;
            }
            x xVar = x.SXb;
            b.a(cursor, null);
            AppMethodBeat.o(149183);
            return false;
        } else if (wLT.get(str) == null) {
            AppMethodBeat.o(149183);
            return false;
        } else {
            AppMethodBeat.o(149183);
            return true;
        }
    }

    public final void dc(String str, int i2) {
        AppMethodBeat.i(149184);
        p.h(str, "forcePushId");
        Log.i("MicroMsg.ForceNotifyStorage", "updateStatus(" + str + ", " + i2 + ')');
        d dVar = new d();
        dVar.field_ForcePushId = str;
        if (get(dVar, new String[0])) {
            dVar.field_Status = i2;
            Log.i("MicroMsg.ForceNotifyStorage", "[updateStatus] ret:%s %s", Long.valueOf(iFy.replace("ForceNotifyData", "ForcePushId", dVar.convertTo())), dVar);
            wLT.put(str, dVar);
            doNotify();
        }
        AppMethodBeat.o(149184);
    }

    public final boolean gC(String str) {
        AppMethodBeat.i(149185);
        p.h(str, "forcePushId");
        Log.i("MicroMsg.ForceNotifyStorage", "delete(" + str + ')');
        if (iFy.delete("ForceNotifyData", "ForcePushId=?", new String[]{str}) >= 0) {
            wLT.remove(str);
            doNotify();
            AppMethodBeat.o(149185);
            return true;
        }
        AppMethodBeat.o(149185);
        return false;
    }

    public static d byi(String str) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(261763);
        p.h(str, "forcePushId");
        Log.i("MicroMsg.ForceNotifyStorage", "getById(" + str + ')');
        Cursor query = iFy.query("ForceNotifyData", new String[]{"*"}, "ForcePushId=?", new String[]{str}, null, null, "ExpiredTime Desc", 2);
        d dVar = new d();
        Cursor cursor = query;
        try {
            query.moveToFirst();
            if (query == null) {
                p.hyc();
            }
            if (!query.isAfterLast()) {
                dVar.convertFrom(query);
                b.a(cursor, null);
                AppMethodBeat.o(261763);
                return dVar;
            }
            b.a(cursor, null);
            AppMethodBeat.o(261763);
            return null;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(cursor, th2);
            AppMethodBeat.o(261763);
            throw th;
        }
    }

    public static ArrayList<d> dMq() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(149187);
        Log.i("MicroMsg.ForceNotifyStorage", "getList()");
        ArrayList<d> arrayList = new ArrayList<>();
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        bv aSN = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN();
        Cursor query = iFy.query("ForceNotifyData", new String[]{"*"}, "ExpiredTime>?", new String[]{String.valueOf(cl.aWz())}, null, null, "ExpiredTime Desc", 2);
        Cursor cursor = query;
        try {
            query.moveToFirst();
            while (true) {
                if (query == null) {
                    p.hyc();
                }
                if (!query.isAfterLast()) {
                    d dVar = new d();
                    dVar.convertFrom(query);
                    if (dVar.field_ForcePushId != null) {
                        dVar.contact = aSN.Kn(dVar.field_UserName);
                        arrayList.add(dVar);
                        Log.i("MicroMsg.ForceNotifyStorage", "add List:%s", dVar);
                        String str = dVar.field_ForcePushId;
                        p.g(str, "result.field_ForcePushId");
                        wLT.put(str, dVar);
                    }
                    query.moveToNext();
                } else {
                    x xVar = x.SXb;
                    b.a(cursor, null);
                    AppMethodBeat.o(149187);
                    return arrayList;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(cursor, th2);
            AppMethodBeat.o(149187);
            throw th;
        }
    }

    public final int dMr() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(149188);
        Log.i("MicroMsg.ForceNotifyStorage", "transformOldData()");
        LinkedList linkedList = new LinkedList();
        Cursor query = iFy.query("ForceNotifyInfo", new String[]{"*"}, "ExpiredTime>=?", new String[]{String.valueOf(cl.aWz())}, null, null, "ExpiredTime Desc", 2);
        Cursor cursor = query;
        try {
            query.moveToFirst();
            while (true) {
                if (query == null) {
                    p.hyc();
                }
                if (query.isAfterLast()) {
                    break;
                }
                d dVar = new d();
                dVar.convertFrom(query);
                linkedList.add(dVar);
                query.moveToNext();
            }
            x xVar = x.SXb;
            b.a(cursor, null);
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                d dVar2 = (d) it.next();
                int i3 = i2 + 1;
                if (!insertNotify(dVar2, false)) {
                    Log.i("MicroMsg.ForceNotifyStorage", "[transformOldData] insert error! %s", dVar2);
                }
                i2 = i3;
            }
            iFy.blB("ForceNotifyInfo");
            AppMethodBeat.o(149188);
            return i2;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(cursor, th2);
            AppMethodBeat.o(149188);
            throw th;
        }
    }

    public static void dMt() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(149190);
        Log.i("MicroMsg.ForceNotifyStorage", "deleteExpireInfo()");
        if (!g.aAc() || g.af(com.tencent.mm.plugin.forcenotify.a.a.class) == null) {
            AppMethodBeat.o(149190);
            return;
        }
        Cursor query = iFy.query("ForceNotifyData", new String[]{"*"}, "ExpiredTime<=?", new String[]{String.valueOf(cl.aWz())}, null, null, null, 2);
        Cursor cursor = query;
        try {
            query.moveToFirst();
            while (true) {
                if (query == null) {
                    p.hyc();
                }
                if (!query.isAfterLast()) {
                    d dVar = new d();
                    dVar.convertFrom(query);
                    ((com.tencent.mm.plugin.forcenotify.a.a) g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).C(dVar.field_ForcePushId, 5, cl.aWz() / 1000);
                    query.moveToNext();
                } else {
                    x xVar = x.SXb;
                    b.a(cursor, null);
                    Log.i("MicroMsg.ForceNotifyStorage", "[deleteExpireInfo] ret:%s", Integer.valueOf(iFy.delete("ForceNotifyData", "ExpiredTime<=?", new String[]{String.valueOf(cl.aWz())})));
                    AppMethodBeat.o(149190);
                    return;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(cursor, th2);
            AppMethodBeat.o(149190);
            throw th;
        }
    }
}
