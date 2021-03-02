package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.c.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.bhl;
import com.tencent.mm.protocal.protobuf.bhm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.a;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.c;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class b {
    private static boolean gc = false;

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(153118);
        aXo();
        AppMethodBeat.o(153118);
    }

    static /* synthetic */ void access$300() {
        AppMethodBeat.i(153120);
        aXq();
        AppMethodBeat.o(153120);
    }

    static /* synthetic */ void sz(int i2) {
        AppMethodBeat.i(153119);
        sy(i2);
        AppMethodBeat.o(153119);
    }

    static void aXm() {
        long longValue;
        int i2;
        boolean z = true;
        AppMethodBeat.i(153110);
        if (!g.aAc()) {
            Log.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
            AppMethodBeat.o(153110);
            return;
        }
        Long l = (Long) g.aAh().azQ().get(ar.a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, (Object) null);
        if (l == null) {
            longValue = 0;
        } else {
            longValue = l.longValue();
        }
        if (longValue == 0) {
            int nextInt = new Random().nextInt(LocalCache.TIME_DAY);
            sy(nextInt);
            aXo();
            aXq();
            Log.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", Integer.valueOf(nextInt));
        } else {
            Integer num = (Integer) g.aAh().azQ().get(ar.a.USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT, (Object) null);
            if (num == null || num.intValue() == 0) {
                i2 = 86400;
            } else {
                i2 = num.intValue();
            }
            long j2 = (long) i2;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(currentTimeMillis > longValue + j2);
            objArr[1] = Long.valueOf(longValue);
            objArr[2] = Long.valueOf(j2);
            objArr[3] = Long.valueOf(currentTimeMillis);
            Log.i("MicroMsg.ABTestUpdater", "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d", objArr);
            if (currentTimeMillis <= longValue + j2) {
                z = false;
            }
        }
        if (!z) {
            Log.v("MicroMsg.ABTestUpdater", "No need to update");
            AppMethodBeat.o(153110);
        } else if (gc) {
            Log.i("MicroMsg.ABTestUpdater", "Updating");
            AppMethodBeat.o(153110);
        } else {
            update();
            AppMethodBeat.o(153110);
        }
    }

    static void aXn() {
        AppMethodBeat.i(153111);
        if (!g.aAc()) {
            Log.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
            AppMethodBeat.o(153111);
        } else if (gc) {
            Log.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
            AppMethodBeat.o(153111);
        } else {
            Log.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
            update();
            AppMethodBeat.o(153111);
        }
    }

    private static String c(LinkedList<akc> linkedList) {
        AppMethodBeat.i(153112);
        String str = "";
        Iterator<akc> it = linkedList.iterator();
        while (it.hasNext()) {
            akc next = it.next();
            str = str + next.Lqu + ":" + next.priority + "|";
        }
        AppMethodBeat.o(153112);
        return str;
    }

    private static void update() {
        AppMethodBeat.i(153113);
        gc = true;
        d.a aVar = new d.a();
        aVar.iLN = new bhl();
        aVar.iLO = new bhm();
        aVar.uri = "/cgi-bin/mmux-bin/getabtest";
        aVar.funcId = 1801;
        d aXF = aVar.aXF();
        bhl bhl = (bhl) aXF.iLK.iLR;
        bhl.LRW = aXp();
        bhl.LRX = d.aXu().gzx();
        bhl.LRX.addAll(d.aXv().gzx());
        Log.i("MicroMsg.ABTestUpdater", "update abtest: %s", c(bhl.LRX));
        aa.a(aXF, new aa.a() {
            /* class com.tencent.mm.model.c.b.AnonymousClass1 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(153109);
                boolean unused = b.gc = false;
                if (i2 == 0 && i3 == 0) {
                    bhm bhm = (bhm) dVar.iLL.iLR;
                    b.access$100();
                    b.sA(bhm.Timestamp);
                    b.sz(bhm.LSa);
                    b.at(bhm.LSb);
                    b.au(bhm.LRZ);
                    b.access$300();
                    Log.i("MicroMsg.ABTestUpdater", "Update Interval: %d", Integer.valueOf(bhm.LSa));
                    AppMethodBeat.o(153109);
                } else {
                    Log.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) LocalCache.TIME_DAY));
                    b.access$100();
                    b.sz(LocalCache.TIME_DAY);
                    b.access$300();
                    AppMethodBeat.o(153109);
                }
                return 0;
            }
        }, true);
        AppMethodBeat.o(153113);
    }

    private static void aXo() {
        AppMethodBeat.i(153114);
        g.aAh().azQ().set(ar.a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis() / 1000));
        AppMethodBeat.o(153114);
    }

    private static void sy(int i2) {
        AppMethodBeat.i(153115);
        int i3 = 0;
        if (i2 == 0) {
            i3 = LocalCache.TIME_DAY;
        } else if (i2 < 3600 || i2 > 129600) {
            i3 = new Random().nextInt(126000) + LocalCache.TIME_HOUR;
        }
        g.aAh().azQ().set(ar.a.USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT, Integer.valueOf(i3));
        AppMethodBeat.o(153115);
    }

    private static int aXp() {
        AppMethodBeat.i(153116);
        Integer num = (Integer) g.aAh().azQ().get(ar.a.USERINFO_ABTEST_SERVER_TIMESTAMP_INT, (Object) null);
        if (num == null) {
            AppMethodBeat.o(153116);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(153116);
        return intValue;
    }

    private static void aXq() {
        AppMethodBeat.i(153117);
        g.aAh().azQ().gBI();
        AppMethodBeat.o(153117);
    }

    static /* synthetic */ void sA(int i2) {
        AppMethodBeat.i(153121);
        g.aAh().azQ().set(ar.a.USERINFO_ABTEST_SERVER_TIMESTAMP_INT, Integer.valueOf(i2));
        AppMethodBeat.o(153121);
    }

    static /* synthetic */ void at(List list) {
        AppMethodBeat.i(153122);
        if (Util.isNullOrNil(list)) {
            Log.w("MicroMsg.ABTestUpdater", "No expired Exp");
            AppMethodBeat.o(153122);
            return;
        }
        com.tencent.mm.storage.d aXu = d.aXu();
        if (!Util.isNullOrNil(list)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (num != null) {
                    c cVar = new c();
                    cVar.field_expId = String.valueOf(num);
                    aXu.delete(cVar, "expId");
                }
            }
        }
        com.tencent.mm.storage.b aXv = d.aXv();
        if (!Util.isNullOrNil(list)) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Integer num2 = (Integer) it2.next();
                if (num2 != null) {
                    a aVar = new a();
                    aVar.field_expId = String.valueOf(num2);
                    aXv.delete(aVar, "expId");
                }
            }
        }
        AppMethodBeat.o(153122);
    }

    static /* synthetic */ void au(List list) {
        AppMethodBeat.i(153123);
        if (list == null || list.size() == 0) {
            Log.w("MicroMsg.ABTestUpdater", "No Exp");
            AppMethodBeat.o(153123);
            return;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a.C0444a Ld = a.Ld(z.a((com.tencent.mm.bw.b) it.next()));
            linkedList.addAll(Ld.iHf);
            linkedList2.addAll(Ld.iHg);
        }
        d.aXu().H(linkedList, 0);
        d.aXv().H(linkedList2, 1);
        AppMethodBeat.o(153123);
    }
}
