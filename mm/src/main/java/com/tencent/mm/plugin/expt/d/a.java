package com.tencent.mm.plugin.expt.d;

import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.l;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.d.b.c;
import com.tencent.mm.plugin.expt.d.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.commons.b.g;

public class a implements c, b {
    private static volatile a sxr;
    public com.tencent.mm.plugin.expt.d.b.b.a sxA = new com.tencent.mm.plugin.expt.d.b.b.a();
    public MMHandler sxB = new MMHandler("EdgeComputingMgr#mExecuteScriptHandler") {
        /* class com.tencent.mm.plugin.expt.d.a.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(220264);
            switch (message.what) {
                case 1001:
                    a.a(a.this, true);
                    AppMethodBeat.o(220264);
                    return;
                case 1002:
                    a.a(a.this, false);
                    AppMethodBeat.o(220264);
                    return;
                case 1003:
                    a.a(a.this);
                    break;
            }
            AppMethodBeat.o(220264);
        }
    };
    private IListener sxC = new IListener<l>() {
        /* class com.tencent.mm.plugin.expt.d.a.AnonymousClass2 */

        {
            AppMethodBeat.i(220265);
            this.__eventId = l.class.getName().hashCode();
            AppMethodBeat.o(220265);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(l lVar) {
            AppMethodBeat.i(220266);
            l lVar2 = lVar;
            if (b.cML()) {
                if (lVar2 == null || lVar2.dCi == null || lVar2.dCi.isActive) {
                    a.this.sxB.removeMessages(1001);
                } else {
                    a.this.sxB.removeMessages(1001);
                    a.this.sxB.sendEmptyMessageDelayed(1001, 1000);
                }
            }
            AppMethodBeat.o(220266);
            return false;
        }
    };
    public com.tencent.mm.plugin.expt.d.d.a sxs = new com.tencent.mm.plugin.expt.d.d.a(this);
    private com.tencent.mm.plugin.expt.d.a.c sxt = com.tencent.mm.plugin.expt.d.a.b.GM(1);
    private com.tencent.mm.plugin.expt.d.a.c sxu = com.tencent.mm.plugin.expt.d.a.b.GM(2);
    public com.tencent.mm.plugin.expt.d.i.b sxv = new com.tencent.mm.plugin.expt.d.i.b();
    private com.tencent.mm.plugin.expt.d.g.a sxw = new com.tencent.mm.plugin.expt.d.g.a();
    public com.tencent.mm.plugin.expt.d.c.a sxx = new com.tencent.mm.plugin.expt.d.c.a();
    private ThreadPoolExecutor sxy = b.cMK();
    public com.tencent.mm.plugin.expt.d.b.a.a sxz = new com.tencent.mm.plugin.expt.d.b.a.a();

    private a() {
        AppMethodBeat.i(220270);
        com.tencent.mm.plugin.expt.d.b.b.cMS().sxQ = this;
        EventCenter.instance.add(this.sxC);
        AppMethodBeat.o(220270);
    }

    public static a cMI() {
        AppMethodBeat.i(220271);
        if (sxr == null) {
            synchronized (a.class) {
                try {
                    if (sxr == null) {
                        sxr = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(220271);
                    throw th;
                }
            }
        }
        a aVar = sxr;
        AppMethodBeat.o(220271);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.expt.d.d.b
    public final void a(long j2, final com.tencent.mm.plugin.expt.d.e.a.b bVar, String str) {
        AppMethodBeat.i(220272);
        if (bVar == null || g.eP(str)) {
            AppMethodBeat.o(220272);
            return;
        }
        Log.d("EdgeComputingMgr", "[EdgeComputingMgr] onDataReceive configID : " + bVar.syg + ", data : " + str);
        if (this.sxv == null) {
            Log.e("EdgeComputingMgr", "[EdgeComputingMgr] edgeComputing please resetDB!");
            AppMethodBeat.o(220272);
            return;
        }
        com.tencent.mm.plugin.expt.d.f.a.k(bVar.syg, 3, j2);
        final com.tencent.mm.plugin.expt.d.e.a aVar = new com.tencent.mm.plugin.expt.d.e.a();
        aVar.data = str;
        aVar.syg = bVar.syg;
        aVar.syh = j2;
        this.sxB.post(new Runnable() {
            /* class com.tencent.mm.plugin.expt.d.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(220267);
                long uptimeMillis = SystemClock.uptimeMillis();
                if (bVar.syn == 1) {
                    a.this.sxu.a(aVar);
                    a.this.sxB.removeMessages(1003);
                    a.this.sxB.sendEmptyMessageDelayed(1003, 30000);
                } else {
                    a.this.sxt.a(aVar);
                }
                String str = bVar.syg;
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                if (uptimeMillis2 <= 10) {
                    h.INSTANCE.idkeyStat(1409, 4, 1, false);
                } else if (uptimeMillis2 <= 100) {
                    h.INSTANCE.idkeyStat(1409, 5, 1, false);
                } else if (uptimeMillis2 <= 1000) {
                    h.INSTANCE.idkeyStat(1409, 6, 1, false);
                } else {
                    h.INSTANCE.idkeyStat(1409, 7, 1, false);
                    if (com.tencent.mm.plugin.expt.d.f.a.syv == null) {
                        com.tencent.mm.plugin.expt.d.f.a.syv = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_edge_computing_is_monitor_performance, false));
                        Log.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statCacheCostTime sIsMonitorPerformance : " + com.tencent.mm.plugin.expt.d.f.a.syv);
                    }
                    if (com.tencent.mm.plugin.expt.d.f.a.syv.booleanValue()) {
                        h.INSTANCE.a(20176, str, 1, Long.valueOf(uptimeMillis2), 1);
                    }
                }
                Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statCacheCostTime configID : %s, costTime : %d, dataSzie : %d", str, Long.valueOf(uptimeMillis2), 1);
                com.tencent.mm.plugin.expt.d.f.a.k(bVar.syg, 5, aVar.syh);
                AppMethodBeat.o(220267);
            }
        });
        this.sxB.removeMessages(1002);
        this.sxB.sendEmptyMessageDelayed(1002, 3000);
        AppMethodBeat.o(220272);
    }

    private Map<Long, List<List<com.tencent.mm.plugin.expt.d.e.b>>> a(com.tencent.mm.plugin.expt.d.h.a aVar, com.tencent.mm.plugin.expt.d.e.a.b bVar, Map<Long, List<String>> map, long j2, long j3) {
        boolean z;
        AppMethodBeat.i(220273);
        if (!(aVar == null || bVar == null || map.size() <= 0)) {
            com.tencent.mm.plugin.expt.d.b.a.a aVar2 = this.sxz;
            String str = bVar.syg;
            if (g.eP(str)) {
                z = true;
            } else if (b.KB() || !aVar2.sxY.containsKey(str)) {
                z = false;
            } else {
                Log.i("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] isErrorScriptConfig configID : ".concat(String.valueOf(str)));
                z = true;
            }
            if (!z) {
                Log.d("EdgeComputingMgr", "[EdgeComputingMgr] edgeComputing configID : " + bVar.syg);
                long uptimeMillis = SystemClock.uptimeMillis();
                com.tencent.mm.plugin.expt.d.b.a.a aVar3 = this.sxz;
                String str2 = bVar.syg;
                if (!g.eP(str2)) {
                    aVar3.sya.put(str2, Long.valueOf(System.currentTimeMillis()));
                    aVar3.cMX();
                }
                Map<Long, List<List<com.tencent.mm.plugin.expt.d.e.b>>> a2 = aVar.a(bVar, map, j2, j3);
                com.tencent.mm.plugin.expt.d.b.a.a aVar4 = this.sxz;
                String str3 = bVar.syg;
                if (!g.eP(str3)) {
                    aVar4.sya.remove(str3);
                    aVar4.cMX();
                }
                if (a2 == null || a2.size() <= 0) {
                    AppMethodBeat.o(220273);
                    return null;
                }
                int i2 = 0;
                for (List<List<com.tencent.mm.plugin.expt.d.e.b>> list : a2.values()) {
                    i2 = list.size() + i2;
                }
                String str4 = bVar.syg;
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                if (uptimeMillis2 <= 10) {
                    h.INSTANCE.idkeyStat(1409, 0, 1, false);
                } else if (uptimeMillis2 <= 100) {
                    h.INSTANCE.idkeyStat(1409, 1, 1, false);
                } else if (uptimeMillis2 <= 1000) {
                    h.INSTANCE.idkeyStat(1409, 2, 1, false);
                } else {
                    h.INSTANCE.idkeyStat(1409, 3, 1, false);
                    if (com.tencent.mm.plugin.expt.d.f.a.syv == null) {
                        com.tencent.mm.plugin.expt.d.f.a.syv = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_edge_computing_is_monitor_performance, false));
                        Log.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statComputingCostTime sIsMonitorPerformance : " + com.tencent.mm.plugin.expt.d.f.a.syv);
                    }
                    if (com.tencent.mm.plugin.expt.d.f.a.syv.booleanValue()) {
                        h.INSTANCE.a(20176, str4, 0, Long.valueOf(uptimeMillis2), Integer.valueOf(i2));
                    }
                }
                Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statComputingCostTime configID : %s, costTime : %d, dataSzie : %d", str4, Long.valueOf(uptimeMillis2), Integer.valueOf(i2));
                AppMethodBeat.o(220273);
                return a2;
            }
        }
        AppMethodBeat.o(220273);
        return null;
    }

    private void cMJ() {
        AppMethodBeat.i(220274);
        List<com.tencent.mm.plugin.expt.d.e.a.c> cMV = com.tencent.mm.plugin.expt.d.b.b.cMS().cMV();
        if (cMV.size() <= 0) {
            AppMethodBeat.o(220274);
            return;
        }
        Log.i("EdgeComputingMgr", "[EdgeComputingMgr] runSqlOnRegularTime!");
        for (com.tencent.mm.plugin.expt.d.e.a.c cVar : cMV) {
            if (g.equals(MD5Util.getMD5String(cVar.sql), cVar.syt)) {
                com.tencent.mm.plugin.expt.d.b.a.a aVar = this.sxz;
                String str = cVar.syg;
                if (!g.eP(str)) {
                    aVar.syb.put(str, Long.valueOf(System.currentTimeMillis()));
                    aVar.cMX();
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                List<List<String>> aok = aok(cVar.sql);
                String str2 = cVar.syg;
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                int size = aok != null ? aok.size() : 0;
                if (uptimeMillis2 <= 10) {
                    h.INSTANCE.idkeyStat(1409, 12, 1, false);
                } else if (uptimeMillis2 <= 100) {
                    h.INSTANCE.idkeyStat(1409, 13, 1, false);
                } else if (uptimeMillis2 <= 1000) {
                    h.INSTANCE.idkeyStat(1409, 14, 1, false);
                } else {
                    h.INSTANCE.idkeyStat(1409, 15, 1, false);
                    if (com.tencent.mm.plugin.expt.d.f.a.syv == null) {
                        com.tencent.mm.plugin.expt.d.f.a.syv = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_edge_computing_is_monitor_performance, false));
                        Log.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statRegularWorkTime sIsMonitorPerformance : " + com.tencent.mm.plugin.expt.d.f.a.syv);
                    }
                    if (com.tencent.mm.plugin.expt.d.f.a.syv.booleanValue()) {
                        h.INSTANCE.a(20176, str2, 3, Long.valueOf(uptimeMillis2), Integer.valueOf(size));
                    }
                }
                Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statSQLQueryCostTime configID : %s, costTime : %d, dataSzie : %d", str2, Long.valueOf(uptimeMillis2), Integer.valueOf(size));
                com.tencent.mm.plugin.expt.d.b.a.a aVar2 = this.sxz;
                String str3 = cVar.syg;
                if (!g.eP(str3)) {
                    aVar2.syb.remove(str3);
                    aVar2.cMX();
                }
                if (aok != null && aok.size() > 0) {
                    if (cVar.syl > 0) {
                        for (List<String> list : aok) {
                            com.tencent.mm.plugin.expt.d.g.a.q(list, cVar.syl);
                        }
                    }
                    com.tencent.mm.plugin.expt.d.b.b cMS = com.tencent.mm.plugin.expt.d.b.b.cMS();
                    String str4 = cVar.syg;
                    if (!g.eP(str4)) {
                        Log.i("EdgeComputingConfigService", "[EdgeComputingConfigService] removeSqlConfigModel, configID : ".concat(String.valueOf(str4)));
                        synchronized (cMS.sxN) {
                            try {
                                cMS.sxN.remove(str4);
                                cMS.cMW();
                            } catch (Throwable th) {
                                AppMethodBeat.o(220274);
                                throw th;
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(220274);
    }

    public final List<List<String>> aok(String str) {
        AppMethodBeat.i(220275);
        if (g.eP(str)) {
            AppMethodBeat.o(220275);
            return null;
        }
        List<List<String>> gn = this.sxx.gn("Edge.db", str);
        AppMethodBeat.o(220275);
        return gn;
    }

    @Override // com.tencent.mm.plugin.expt.d.b.c
    public final void a(com.tencent.mm.plugin.expt.d.e.a.b bVar) {
        AppMethodBeat.i(220276);
        if (bVar == null) {
            AppMethodBeat.o(220276);
            return;
        }
        Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigUpdate newConfig : " + bVar.syg);
        AppMethodBeat.o(220276);
    }

    @Override // com.tencent.mm.plugin.expt.d.b.c
    public final void b(final com.tencent.mm.plugin.expt.d.e.a.b bVar) {
        AppMethodBeat.i(220277);
        if (bVar == null) {
            AppMethodBeat.o(220277);
            return;
        }
        Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigOffline offlineConfig : " + bVar.syg);
        this.sxB.post(new Runnable() {
            /* class com.tencent.mm.plugin.expt.d.a.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(220268);
                a.this.sxt.clear(bVar.syg);
                a.this.sxu.clear(bVar.syg);
                com.tencent.mm.plugin.expt.d.i.b bVar = a.this.sxv;
                com.tencent.mm.plugin.expt.d.e.a.b bVar2 = bVar;
                if (bVar.syB == null || bVar2 == null) {
                    AppMethodBeat.o(220268);
                    return;
                }
                new com.tencent.mm.plugin.expt.d.i.a(bVar.syB, bVar2.syg, bVar2.sym).cNg();
                Log.i("EdgeComputingDataStorage", "[EdgeComputingDataStorage] clearAllData configID : " + bVar2.syg);
                AppMethodBeat.o(220268);
            }
        });
        AppMethodBeat.o(220277);
    }

    @Override // com.tencent.mm.plugin.expt.d.b.c
    public final void c(final com.tencent.mm.plugin.expt.d.e.a.b bVar) {
        AppMethodBeat.i(220278);
        if (bVar == null) {
            AppMethodBeat.o(220278);
            return;
        }
        if (b.KB()) {
            this.sxB.post(new Runnable() {
                /* class com.tencent.mm.plugin.expt.d.a.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(220269);
                    if (bVar.syo == 0) {
                        com.tencent.mm.plugin.expt.d.b.b.a aVar = a.this.sxA;
                        String str = bVar.syg;
                        if (!g.eP(str)) {
                            synchronized (aVar.syc) {
                                try {
                                    aVar.syc.remove(str);
                                    aVar.cMZ();
                                } finally {
                                    AppMethodBeat.o(220269);
                                }
                            }
                            return;
                        }
                    }
                    AppMethodBeat.o(220269);
                }
            });
        }
        Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigSame sameConfig : " + bVar.syg);
        AppMethodBeat.o(220278);
    }

    @Override // com.tencent.mm.plugin.expt.d.b.c
    public final void a(com.tencent.mm.plugin.expt.d.e.a.c cVar) {
        AppMethodBeat.i(220279);
        if (cVar == null) {
            AppMethodBeat.o(220279);
            return;
        }
        Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigUpdate newConfig : " + cVar.syg);
        AppMethodBeat.o(220279);
    }

    @Override // com.tencent.mm.plugin.expt.d.b.c
    public final void b(com.tencent.mm.plugin.expt.d.e.a.c cVar) {
        AppMethodBeat.i(220280);
        if (cVar == null) {
            AppMethodBeat.o(220280);
            return;
        }
        Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigOffline offlineConfig : " + cVar.syg);
        AppMethodBeat.o(220280);
    }

    @Override // com.tencent.mm.plugin.expt.d.b.c
    public final void c(com.tencent.mm.plugin.expt.d.e.a.c cVar) {
        AppMethodBeat.i(220281);
        if (cVar == null) {
            AppMethodBeat.o(220281);
            return;
        }
        Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigSame sameConfig : " + cVar.syg);
        AppMethodBeat.o(220281);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
        if ((r4 - r6) < 28800000) goto L_0x04c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0031, code lost:
        if ((r4 - r6) < com.tencent.mm.sdk.platformtools.Util.MILLSECONDS_OF_HOUR) goto L_0x04c8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.expt.d.a r24, boolean r25) {
        /*
        // Method dump skipped, instructions count: 1398
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.d.a.a(com.tencent.mm.plugin.expt.d.a, boolean):void");
    }

    static /* synthetic */ void a(a aVar) {
        List<com.tencent.mm.plugin.expt.d.e.a> aol;
        long j2;
        long j3;
        com.tencent.mm.plugin.expt.d.h.a aVar2;
        AppMethodBeat.i(220283);
        List<com.tencent.mm.plugin.expt.d.e.a.b> cMU = com.tencent.mm.plugin.expt.d.b.b.cMS().cMU();
        if (cMU.size() > 0) {
            Log.i("EdgeComputingMgr", "[EdgeComputingMgr] handleInstantReport!");
            com.tencent.mm.plugin.expt.d.h.a aVar3 = null;
            long currentTimeMillis = System.currentTimeMillis();
            for (com.tencent.mm.plugin.expt.d.e.a.b bVar : cMU) {
                if (bVar.syn == 1 && (aol = aVar.sxu.aol(bVar.syg)) != null && aol.size() > 0) {
                    HashMap hashMap = new HashMap();
                    for (com.tencent.mm.plugin.expt.d.e.a aVar4 : aol) {
                        List<String> list = hashMap.get(Long.valueOf(aVar4.syh));
                        if (list == null) {
                            list = new ArrayList<>();
                            hashMap.put(Long.valueOf(aVar4.syh), list);
                        }
                        list.add(aVar4.data);
                    }
                    long j4 = ((long) bVar.syp) * 60 * 60 * 1000;
                    long rawOffset = (long) TimeZone.getDefault().getRawOffset();
                    if (bVar.syp > 0) {
                        long j5 = currentTimeMillis / j4;
                        j3 = ((j5 * j4) - rawOffset) - j4;
                        j2 = ((j4 * j5) - rawOffset) - 1;
                    } else {
                        j2 = currentTimeMillis;
                        j3 = currentTimeMillis;
                    }
                    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] handleInstantReport configID : " + bVar.syg + ", now : " + currentTimeMillis);
                    if (aVar3 == null) {
                        aVar2 = new com.tencent.mm.plugin.expt.d.h.a();
                    } else {
                        aVar2 = aVar3;
                    }
                    Map<Long, List<List<com.tencent.mm.plugin.expt.d.e.b>>> a2 = aVar.a(aVar2, bVar, hashMap, j3, j2);
                    if (a2 == null || a2.size() <= 0) {
                        aVar3 = aVar2;
                    } else {
                        com.tencent.mm.plugin.expt.d.f.a.k(bVar.syg, 4, 0);
                        if (bVar.syq > 0) {
                            long uptimeMillis = SystemClock.uptimeMillis();
                            int i2 = 0;
                            for (Long l : a2.keySet()) {
                                List<List<com.tencent.mm.plugin.expt.d.e.b>> list2 = a2.get(Long.valueOf(l.longValue()));
                                if (list2 != null && list2.size() > 0) {
                                    Log.d("EdgeComputingMgr", "[EdgeComputingMgr] handleInstantReport saveResult ret : ".concat(String.valueOf(aVar.sxv.a(list2, bVar))));
                                    i2 = list2.size() + i2;
                                }
                            }
                            com.tencent.mm.plugin.expt.d.f.a.e(bVar.syg, SystemClock.uptimeMillis() - uptimeMillis, i2);
                            com.tencent.mm.plugin.expt.d.f.a.k(bVar.syg, 6, 0);
                        }
                        if (bVar.syl > 0) {
                            for (Long l2 : a2.keySet()) {
                                List<List<com.tencent.mm.plugin.expt.d.e.b>> list3 = a2.get(Long.valueOf(l2.longValue()));
                                if (list3 != null && list3.size() > 0) {
                                    for (List<com.tencent.mm.plugin.expt.d.e.b> list4 : list3) {
                                        com.tencent.mm.plugin.expt.d.g.a.p(list4, bVar.syl);
                                    }
                                }
                            }
                            com.tencent.mm.plugin.expt.d.f.a.k(bVar.syg, 7, 0);
                        }
                        aVar.sxu.clear(bVar.syg);
                        aVar3 = aVar2;
                    }
                }
            }
            if (aVar3 != null) {
                aVar3.release();
            }
            aVar.sxu.clearAll();
        }
        AppMethodBeat.o(220283);
    }
}
