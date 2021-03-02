package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class h {
    public static final o.a[] kPj = {o.a.WALLET_MALL_INDEX, o.a.CHATTING, o.a.QRCODE, o.a.QRCODE_PRE};
    private static final kotlin.g.a.a<x> kPk = a.kPp;
    private static final com.tencent.mm.plugin.appbrand.ac.h<String, kotlin.g.a.a<x>> kPl = new com.tencent.mm.plugin.appbrand.ac.h<>();
    private static final ConcurrentHashMap<String, Long> kPm = new ConcurrentHashMap<>();
    private static final long kPn = TimeUnit.MINUTES.toMillis(5);
    public static final h kPo = new h();

    static final class a extends q implements kotlin.g.a.a<x> {
        public static final a kPp = new a();

        static {
            AppMethodBeat.i(228019);
            AppMethodBeat.o(228019);
        }

        a() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public static final class b extends q implements kotlin.g.a.a<x> {
        public static final b kPq = new b();

        static {
            AppMethodBeat.i(228020);
            AppMethodBeat.o(228020);
        }

        b() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public static final class d<T> implements d.b<List<String>> {
        public static final d kPt = new d();

        static {
            AppMethodBeat.i(228025);
            AppMethodBeat.o(228025);
        }

        d() {
        }

        @Override // com.tencent.mm.vending.g.d.b
        public final /* synthetic */ void bz(List<String> list) {
            AppMethodBeat.i(228024);
            final List<String> list2 = list;
            List<String> list3 = list2;
            if (!(list3 == null || list3.isEmpty())) {
                com.tencent.mm.ac.d.i(new kotlin.g.a.a<x>() {
                    /* class com.tencent.mm.plugin.appbrand.appcache.predownload.h.d.AnonymousClass1 */

                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(228023);
                        com.tencent.mm.plugin.appbrand.config.a.b bVar = (com.tencent.mm.plugin.appbrand.config.a.b) n.W(com.tencent.mm.plugin.appbrand.config.a.b.class);
                        if (bVar != null) {
                            bVar.br(list2);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(228023);
                        return xVar;
                    }
                });
            }
            AppMethodBeat.o(228024);
        }
    }

    static {
        AppMethodBeat.i(228030);
        AppMethodBeat.o(228030);
    }

    private h() {
    }

    public static void VE(String str) {
        AppMethodBeat.i(228027);
        p.h(str, "qbarString");
        Long l = kPm.get(str);
        if (l == null) {
            l = 0L;
        }
        p.g(l, "QBAR_STRING_PRELOADED_TIMESTAMP[qbarString] ?: 0L");
        long longValue = l.longValue();
        if (Util.milliSecondsToNow(longValue) < kPn) {
            Log.i("MicroMsg.WxaAttributesBatchPreLoader", "preloadByQBarRawString with qbarString:" + str + ", hit interval control, lastPreloadTimestamp:" + longValue);
            AppMethodBeat.o(228027);
            return;
        }
        kPm.put(str, Long.valueOf(Util.nowMilliSecond()));
        new e(Util.currentTicks(), str, str).aYI();
        AppMethodBeat.o(228027);
    }

    public static final class e extends o {
        final /* synthetic */ long iiX;
        final /* synthetic */ String kPv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(long j2, String str, String str2) {
            super(str2);
            this.iiX = j2;
            this.kPv = str;
        }

        @Override // com.tencent.mm.plugin.appbrand.networking.b, com.tencent.mm.ak.c
        public final /* synthetic */ void a(int i2, int i3, String str, lm lmVar, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(228026);
            lm lmVar2 = lmVar;
            super.a(i2, i3, str, lmVar2, qVar);
            long ticksToNow = Util.ticksToNow(this.iiX);
            try {
                StringBuilder append = new StringBuilder("preloadByQBarRawString::onCgiBack, qbarString:").append(this.kPv).append(", errType:").append(i2).append(", errCode:").append(i3).append(", errMsg:");
                if (str == null) {
                    str = "";
                }
                Log.i("MicroMsg.WxaAttributesBatchPreLoader", append.append(str).append(" cost:").append(ticksToNow).toString());
                LinkedList linkedList = new LinkedList();
                com.tencent.mm.plugin.appbrand.config.x xVar = (com.tencent.mm.plugin.appbrand.config.x) n.W(com.tencent.mm.plugin.appbrand.config.x.class);
                if (lmVar2 == null) {
                    p.hyc();
                }
                xVar.a(lmVar2, linkedList);
                AppMethodBeat.o(228026);
            } catch (Exception e2) {
                Log.e("MicroMsg.WxaAttributesBatchPreLoader", "preloadByQBarRawString::batchUpdateWithProto with qbarString:" + this.kPv + ", failed exception=" + e2);
                AppMethodBeat.o(228026);
            }
        }
    }

    public static final class c implements aa.e {
        private List<String> gMT;
        final /* synthetic */ List kPr;
        final /* synthetic */ kotlin.g.a.a kPs;

        c(List list, kotlin.g.a.a aVar) {
            this.kPr = list;
            this.kPs = aVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.config.aa.e
        public final void bj(List<String> list) {
            v vVar;
            AppMethodBeat.i(228021);
            if (list == null) {
                vVar = v.SXr;
            } else {
                vVar = list;
            }
            this.gMT = new LinkedList(vVar);
            for (String str : this.kPr) {
                h hVar = h.kPo;
                com.tencent.mm.plugin.appbrand.ac.h hVar2 = h.kPl;
                h hVar3 = h.kPo;
                hVar2.r(str, h.kPk);
            }
            AppMethodBeat.o(228021);
        }

        @Override // com.tencent.mm.plugin.appbrand.config.aa.d
        public final void done() {
            AppMethodBeat.i(228022);
            h hVar = h.kPo;
            h.bi(this.kPr);
            this.kPs.invoke();
            AppMethodBeat.o(228022);
        }
    }

    public static /* synthetic */ void a(List list, o.a aVar) {
        AppMethodBeat.i(228029);
        a(list, aVar, b.kPq);
        AppMethodBeat.o(228029);
    }

    public static void a(List<String> list, o.a aVar, kotlin.g.a.a<x> aVar2) {
        AppMethodBeat.i(228028);
        p.h(list, "usernameList");
        p.h(aVar, "scene");
        p.h(aVar2, "onSuccess");
        aa.a(list, aVar, new c(list, aVar2)).a(d.kPt);
        AppMethodBeat.o(228028);
    }

    public static final /* synthetic */ void bi(List list) {
        AppMethodBeat.i(228031);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kotlin.a.x cN = kPl.cN((String) it.next());
            if (cN == null) {
                cN = kotlin.a.x.SXt;
            }
            Iterator<T> it2 = cN.iterator();
            while (it2.hasNext()) {
                it2.next().invoke();
            }
        }
        AppMethodBeat.o(228031);
    }
}
