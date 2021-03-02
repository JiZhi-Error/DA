package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.protocal.protobuf.pl;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.protocal.protobuf.pn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020!H\u0007J\b\u0010#\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\b\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R!\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLCardUpdateMgr;", "", "()V", "STATE_IDLE", "", "STATE_UPDATING", "TAG", "", "isUpdateCardOpen", "", "()Z", "isUpdateCardOpen$delegate", "Lkotlin/Lazy;", "mgrState", "Ljava/util/concurrent/atomic/AtomicInteger;", "getMgrState", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setMgrState", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "setQueue", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getSetQueue", "()Ljava/util/HashSet;", "updateQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/protocal/protobuf/BizRecArticleCardLite;", "getUpdateQueue", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "addUpdateQueue", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "checkUpdate", "tryUpdate", "plugin-brandservice_release"})
public final class j {
    private static AtomicInteger pul = new AtomicInteger(2);
    private static final ConcurrentLinkedDeque<pl> pum = new ConcurrentLinkedDeque<>();
    private static final HashSet<Long> pun = new HashSet<>();
    private static final f puo = g.ah(a.puq);
    public static final j pup = new j();

    static {
        AppMethodBeat.i(195293);
        AppMethodBeat.o(195293);
    }

    private j() {
    }

    public static final /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(195294);
        jVar.cmK();
        AppMethodBeat.o(195294);
    }

    public static AtomicInteger cmI() {
        return pul;
    }

    public static HashSet<Long> cmJ() {
        return pun;
    }

    public static final boolean k(z zVar) {
        efz efz;
        boolean z = false;
        AppMethodBeat.i(195291);
        p.h(zVar, "info");
        if (zVar.gAD() == null || !zVar.gAu()) {
            AppMethodBeat.o(195291);
            return false;
        }
        switch (zVar.gAD().style) {
            case 101:
            case 102:
            case 103:
                Log.i("MicroMsg.BizTLCardUpdateMgr", "checkUpdate msgId = " + zVar.field_msgId);
                j jVar = pup;
                p.h(zVar, "info");
                if (((Boolean) puo.getValue()).booleanValue() && zVar.gAu() && ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_timeline_reccard_update, 1) != 0) {
                    ege gAD = zVar.gAD();
                    if (gAD != null) {
                        efz = gAD.NfY;
                    } else {
                        efz = null;
                    }
                    if (!(efz == null || gAD.Nga == null || Util.isNullOrNil(gAD.Nga.KUf))) {
                        p.h(gAD, "$this$isExpire");
                        if (Math.abs(System.currentTimeMillis() - gAD.lastUpdateTime) / 1000 > ((long) MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300))) {
                            z = true;
                        }
                        if (z) {
                            synchronized (jVar) {
                                try {
                                    if (!pun.contains(Long.valueOf(zVar.field_msgId))) {
                                        pl l = k.l(zVar);
                                        pun.add(Long.valueOf(l.KWz));
                                        pum.add(l);
                                        Log.i("MicroMsg.BizTLCardUpdateMgr", "addUpdateQueue msgId = " + zVar.field_msgId + ", queue size = " + pum.size());
                                    }
                                    x xVar = x.SXb;
                                } finally {
                                    AppMethodBeat.o(195291);
                                }
                            }
                            jVar.cmK();
                        }
                    }
                }
                return true;
            case 1001:
                AppMethodBeat.o(195291);
                return true;
            default:
                AppMethodBeat.o(195291);
                return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        r1 = new com.tencent.mm.ak.d.a();
        r1.c(new com.tencent.mm.protocal.protobuf.pm());
        r1.d(new com.tencent.mm.protocal.protobuf.pn());
        r1.MB("/cgi-bin/mmbiz-bin/timeline/bizrecommendarticle");
        r1.sG(1084);
        r2 = r1.aXF();
        r0 = r2.aYJ();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005f, code lost:
        if (r0 != null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0061, code lost:
        r0 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizRecommendArticleReq");
        com.tencent.matrix.trace.core.AppMethodBeat.o(195292);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0073, code lost:
        r0 = (com.tencent.mm.protocal.protobuf.pm) r0;
        r0.KWB = com.tencent.mm.plugin.brandservice.ui.timeline.item.j.pum.removeFirst();
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate msgId = " + r0.KWB.KWz);
        com.tencent.mm.ak.aa.a(r2, com.tencent.mm.plugin.brandservice.ui.timeline.item.j.b.pur);
        com.tencent.matrix.trace.core.AppMethodBeat.o(195292);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void cmK() {
        /*
        // Method dump skipped, instructions count: 165
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.item.j.cmK():void");
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    public static final class b implements aa.a {
        public static final b pur = new b();

        static {
            AppMethodBeat.i(195290);
            AppMethodBeat.o(195290);
        }

        b() {
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, d dVar, q qVar) {
            pm pmVar = null;
            AppMethodBeat.i(195289);
            p.h(dVar, "rr");
            p.h(qVar, "scene");
            j jVar = j.pup;
            j.cmI().set(2);
            j.a(j.pup);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.bw.a aYK = dVar.aYK();
                if (!(aYK instanceof pn)) {
                    aYK = null;
                }
                final pn pnVar = (pn) aYK;
                if (pnVar == null) {
                    AppMethodBeat.o(195289);
                } else {
                    com.tencent.mm.bw.a aYJ = dVar.aYJ();
                    if (aYJ instanceof pm) {
                        pmVar = aYJ;
                    }
                    pm pmVar2 = pmVar;
                    if (pmVar2 == null) {
                        AppMethodBeat.o(195289);
                    } else if (pmVar2.KWB.KWz != pnVar.KWC.KWz) {
                        AppMethodBeat.o(195289);
                    } else {
                        final z MM = ag.ban().MM(pmVar2.KWB.KWz);
                        if (MM == null) {
                            AppMethodBeat.o(195289);
                        } else if (pnVar.KWC == null || Util.isNullOrNil(pnVar.KWC.KUf)) {
                            AppMethodBeat.o(195289);
                        } else {
                            j jVar2 = j.pup;
                            j.cmJ().remove(Long.valueOf(MM.field_msgId));
                            MultiProcessMMKV.getSingleMMKV("brandService").encode("BizRecommendCardRefreshIntervalSec", Math.min(300, pnVar.KSO));
                            Log.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate success msgId = " + MM.field_msgId);
                            com.tencent.mm.co.g.hio().h(new com.tencent.mm.vending.c.a<_Ret, _Var>() {
                                /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.j.b.AnonymousClass1 */

                                @Override // com.tencent.mm.vending.c.a
                                public final /* synthetic */ Object call(Object obj) {
                                    AppMethodBeat.i(195287);
                                    switch (MM.gAD().style) {
                                        case 101:
                                        case 102:
                                        case 103:
                                            ege gAD = MM.gAD();
                                            gAD.Nga.KHa = pnVar.KWC.KHa;
                                            LinkedList<pj> linkedList = gAD.Nga.KUf;
                                            p.g(linkedList, "extraInfo.BizInfo");
                                            int i2 = 0;
                                            for (T t : linkedList) {
                                                int i3 = i2 + 1;
                                                if (i2 < 0) {
                                                    kotlin.a.j.hxH();
                                                }
                                                T t2 = t;
                                                if (i2 < pnVar.KWC.KUf.size() && pnVar.KWC.KUf.get(i2) != null) {
                                                    gAD.Nga.KUf.set(i2, pnVar.KWC.KUf.get(i2));
                                                    gAD.Nga.KUf.get(i2).KWr = t2.KWr;
                                                    gAD.Nga.KUf.get(i2).KWs = t2.KWs;
                                                    LinkedList<pi> linkedList2 = gAD.Nga.KUf.get(i2).KWy;
                                                    p.g(linkedList2, "extraInfo.BizInfo[index].AppMsg");
                                                    int i4 = 0;
                                                    for (T t3 : linkedList2) {
                                                        int i5 = i4 + 1;
                                                        if (i4 < 0) {
                                                            kotlin.a.j.hxH();
                                                        }
                                                        T t4 = t3;
                                                        if (!(t2.KWy == null || t2.KWy.get(i4) == null)) {
                                                            pi piVar = t2.KWy.get(i4);
                                                            t4.KWr = piVar.KWr;
                                                            t4.KWs = piVar.KWs;
                                                            if (t4.KHa != 1) {
                                                                t4.KHa = piVar.KHa;
                                                            }
                                                            t4.KWw = piVar.KWw;
                                                            t4.KWv = piVar.KWv;
                                                        }
                                                        i4 = i5;
                                                    }
                                                }
                                                i2 = i3;
                                            }
                                            gAD.lastUpdateTime = System.currentTimeMillis();
                                            break;
                                        default:
                                            ege gAD2 = MM.gAD();
                                            gAD2.Nga.KHa = pnVar.KWC.KHa;
                                            gAD2.Nga.Lug = pnVar.KWC.Title;
                                            gAD2.Nga.KUf = pnVar.KWC.KUf;
                                            gAD2.lastUpdateTime = System.currentTimeMillis();
                                            break;
                                    }
                                    MM.c(MM.gAD());
                                    Boolean valueOf = Boolean.valueOf(ag.ban().updateNotify(MM, false, "msgId"));
                                    AppMethodBeat.o(195287);
                                    return valueOf;
                                }
                            }).b(new com.tencent.mm.vending.c.a<_Ret, _Var>() {
                                /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.j.b.AnonymousClass2 */

                                @Override // com.tencent.mm.vending.c.a
                                public final /* synthetic */ Object call(Object obj) {
                                    AppMethodBeat.i(195288);
                                    aa.a aVar = new aa.a();
                                    aVar.NQE = aa.b.UPDATE;
                                    LinkedList linkedList = new LinkedList();
                                    linkedList.add(MM);
                                    aVar.list = linkedList;
                                    ag.ban().a(aVar);
                                    x xVar = x.SXb;
                                    AppMethodBeat.o(195288);
                                    return xVar;
                                }
                            });
                            AppMethodBeat.o(195289);
                        }
                    }
                }
            } else {
                AppMethodBeat.o(195289);
            }
            return 0;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final a puq = new a();

        static {
            AppMethodBeat.i(195286);
            AppMethodBeat.o(195286);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z = true;
            AppMethodBeat.i(195285);
            y yVar = y.NPP;
            if (y.aTI().decodeInt("BizTimeLineUpdateCard", 1) != 1) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(195285);
            return valueOf;
        }
    }
}
