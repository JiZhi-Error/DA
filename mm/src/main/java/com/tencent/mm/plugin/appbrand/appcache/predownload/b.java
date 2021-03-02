package com.tencent.mm.plugin.appbrand.appcache.predownload;

import android.database.sqlite.SQLiteDiskIOException;
import android.util.LongSparseArray;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.protocal.protobuf.efw;
import com.tencent.mm.protocal.protobuf.lh;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vending.g.d;
import java.util.List;

public final class b extends c<li> {
    private static final LongSparseArray<Object> kON = new LongSparseArray<>();
    private static final LongSparseArray<Object> kOO = new LongSparseArray<>();
    private final d rr;

    /* synthetic */ b(List list, byte b2) {
        this(list);
    }

    static /* synthetic */ List bwK() {
        AppMethodBeat.i(226375);
        List<efw> bwI = bwI();
        AppMethodBeat.o(226375);
        return bwI;
    }

    static {
        AppMethodBeat.i(226376);
        AppMethodBeat.o(226376);
    }

    public static void bwH() {
        AppMethodBeat.i(226373);
        final long nanoTime = System.nanoTime();
        synchronized (kON) {
            try {
                kON.put(nanoTime, kON);
            } catch (Throwable th) {
                AppMethodBeat.o(226373);
                throw th;
            }
        }
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.appcache.predownload.b.AnonymousClass1 */

            public final void run() {
                int size;
                boolean z;
                List list;
                int i2 = 0;
                AppMethodBeat.i(44368);
                synchronized (b.kON) {
                    try {
                        b.kON.remove(nanoTime);
                        size = b.kON.size();
                    } finally {
                        AppMethodBeat.o(44368);
                    }
                }
                if (size > 0) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1422, 12);
                }
                if (!g.aAf().hpY || n.buy() == null || n.buL() == null) {
                    AppMethodBeat.o(44368);
                    return;
                }
                long longValue = ((Long) g.aAh().azQ().get(ar.a.APPBRAND_PREDOWNLOAD_CGI_PULL_LAST_TIME_IN_SECOND_LONG, (Object) 0L)).longValue();
                long j2 = AppBrandGlobalSystemConfig.bzP().ldj.ldF;
                long nowSecond = Util.nowSecond();
                if (nowSecond >= longValue + j2) {
                    z = true;
                } else if (longValue > j2 + nowSecond) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    g.aAh().azQ().set(ar.a.APPBRAND_PREDOWNLOAD_CGI_PULL_LAST_TIME_IN_SECOND_LONG, Long.valueOf(nowSecond));
                    try {
                        list = b.bwK();
                    } catch (SQLiteDiskIOException | com.tencent.wcdb.database.SQLiteDiskIOException e2) {
                        Log.e("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit::collectReqInfoList, e=%s", e2);
                        list = null;
                    }
                    if (Util.isNullOrNil(list)) {
                        Log.e("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit, empty list");
                        AppMethodBeat.o(44368);
                        return;
                    }
                    Log.i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit, collectReqInfoList.size=%d", Integer.valueOf(list.size()));
                    int i3 = AppBrandGlobalSystemConfig.bzP().ldj.ldI;
                    for (int i4 = 0; i4 < list.size() / i3; i4++) {
                        int i5 = i4 * i3;
                        i2 = i5 + i3;
                        bf(list.subList(i5, i2));
                    }
                    if (i2 < list.size()) {
                        bf(list.subList(i2, list.size()));
                    }
                    return;
                }
                AppMethodBeat.o(44368);
            }

            private void bf(List<efw> list) {
                AppMethodBeat.i(44369);
                a aVar = a.INSTANCE;
                a.F(0, 0);
                new b(list, (byte) 0).aYI().a(com.tencent.mm.vending.h.d.LOGIC, new d.b<c.a<li>>() {
                    /* class com.tencent.mm.plugin.appbrand.appcache.predownload.b.AnonymousClass1.AnonymousClass2 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.g.d.b
                    public final /* synthetic */ void bz(c.a<li> aVar) {
                        AppMethodBeat.i(226372);
                        c.a<li> aVar2 = aVar;
                        int i2 = aVar2.errType;
                        int i3 = aVar2.errCode;
                        String str = aVar2.errMsg;
                        li liVar = (li) aVar2.iLC;
                        Log.i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "onCgiBack, errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 != 0 || i3 != 0 || liVar == null || liVar.KPd == null) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1422, 2);
                            a aVar3 = a.INSTANCE;
                            a.F(0, 2);
                            AppMethodBeat.o(226372);
                            return;
                        }
                        e.a(liVar.KPd, false, 0);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1422, 1);
                        a aVar4 = a.INSTANCE;
                        a.F(0, 1);
                        AppMethodBeat.o(226372);
                    }
                }).a(com.tencent.mm.vending.h.d.LOGIC, new d.a<Object>() {
                    /* class com.tencent.mm.plugin.appbrand.appcache.predownload.b.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.vending.g.d.a
                    public final void cn(Object obj) {
                        AppMethodBeat.i(226371);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1422, 2);
                        a aVar = a.INSTANCE;
                        a.F(0, 2);
                        AppMethodBeat.o(226371);
                    }
                });
                AppMethodBeat.o(44369);
            }
        }, "MicroMsg.AppBrand.CgiBatchSyncPkgVersion");
        AppMethodBeat.o(226373);
    }

    private b(List<efw> list) {
        AppMethodBeat.i(44371);
        d.a aVar = new d.a();
        lh lhVar = new lh();
        lhVar.KOw.addAll(list);
        aVar.iLN = lhVar;
        aVar.iLO = new li();
        aVar.funcId = 2763;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxasync/wxabatchsyncversion";
        com.tencent.mm.ak.d aXF = aVar.aXF();
        this.rr = aXF;
        c(aXF);
        AppMethodBeat.o(44371);
    }

    @Override // com.tencent.mm.ak.c
    public final synchronized f<c.a<li>> aYI() {
        f<c.a<li>> aYI;
        AppMethodBeat.i(226374);
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1422, 3);
        aYI = super.aYI();
        AppMethodBeat.o(226374);
        return aYI;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.tencent.mm.protocal.protobuf.efw> bwI() {
        /*
        // Method dump skipped, instructions count: 459
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.predownload.b.bwI():java.util.List");
    }
}
