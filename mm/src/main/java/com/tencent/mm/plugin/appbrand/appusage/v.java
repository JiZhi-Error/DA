package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.protocal.protobuf.bzl;
import com.tencent.mm.protocal.protobuf.fcn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public enum v {
    ;
    
    private static Integer kVw = null;
    private static final long kVx = TimeUnit.DAYS.toSeconds(1);

    static {
        AppMethodBeat.i(44596);
        AppMethodBeat.o(44596);
    }

    public static v valueOf(String str) {
        AppMethodBeat.i(44592);
        v vVar = (v) Enum.valueOf(v.class, str);
        AppMethodBeat.o(44592);
        return vVar;
    }

    public static boolean bym() {
        return true;
    }

    public static boolean byn() {
        return true;
    }

    public static void vY(int i2) {
        LinkedList linkedList;
        AppMethodBeat.i(44593);
        kVw = Integer.valueOf(i2);
        u uVar = (u) n.W(u.class);
        Cursor query = uVar.kVs.query("AppBrandStarApp", new String[]{"rowid"}, null, null, null, null, String.format(Locale.US, "%s desc limit %d offset %d", "orderSequence", Long.valueOf((long) MAlarmHandler.NEXT_FIRE_INTERVAL), Integer.valueOf(byo())));
        if (query == null) {
            AppMethodBeat.o(44593);
            return;
        }
        if (query.moveToFirst()) {
            linkedList = new LinkedList();
            do {
                linkedList.add(String.valueOf(query.getLong(0)));
            } while (query.moveToNext());
        } else {
            linkedList = null;
        }
        query.close();
        if (!Util.isNullOrNil(linkedList)) {
            String[] strArr = new String[1];
            long beginTransaction = uVar.kVs.beginTransaction(Thread.currentThread().getId());
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                strArr[0] = (String) it.next();
                uVar.kVs.delete("AppBrandStarApp", "rowid=?", strArr);
            }
            uVar.kVs.endTransaction(beginTransaction);
            uVar.doNotify(MStorageEventData.EventType.BATCH, 5, null);
        }
        AppMethodBeat.o(44593);
    }

    public static int byo() {
        AppMethodBeat.i(44594);
        if (kVw != null) {
            int intValue = kVw.intValue();
            AppMethodBeat.o(44594);
            return intValue;
        }
        int i2 = AppBrandGlobalSystemConfig.bzP().lcU;
        AppMethodBeat.o(44594);
        return i2;
    }

    static void a(int i2, int i3, int i4, String str, d dVar, Long l) {
        AppMethodBeat.i(44595);
        if (dVar == null) {
            Log.e("MicroMsg.AppBrandStarListLogic[collection]", "onResp, NULL CommReqResp");
            AppMethodBeat.o(44595);
        } else if ((((bzk) dVar.iLK.iLR).condition & 2) == 0) {
            AppMethodBeat.o(44595);
        } else {
            bzl bzl = (bzl) dVar.iLL.iLR;
            Log.i("MicroMsg.AppBrandStarListLogic[collection]", "onResp, errType %d, errCode %d, errMsg %s, ticket %s", Integer.valueOf(i3), Integer.valueOf(i4), str, l);
            if (i3 == 0 && i4 == 0 && bzl != null) {
                if (n.W(u.class) != null) {
                    ((u) n.W(u.class)).a(fcn.class, bzl.Mfe, l);
                    w.a(i2, bzl.Mfe);
                }
                g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_FAVORITE_BOOLEAN, Boolean.valueOf((bzl.status & 1) > 0));
            }
            AppMethodBeat.o(44595);
        }
    }
}
