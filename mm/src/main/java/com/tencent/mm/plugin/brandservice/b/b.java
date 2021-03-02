package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.pluginsdk.c;
import com.tencent.mm.protocal.protobuf.dkw;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.protocal.protobuf.eqs;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.protocal.protobuf.qd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.r;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0013H\u0007J\b\u0010\u0015\u001a\u00020\u0013H\u0007J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0007J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/model/BizStrategyManager;", "", "()V", "KEY_BIZ_STRATEGY_FETCH_INTERVAL", "", "KEY_BIZ_STRATEGY_FETCH_LAST_TIME", "TAG", "lastTriggerPreDownloadTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "requestType", "", "fetchBizStrategy", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onEnterBizTimeLineUI", "onUpdateBizStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "preloadForPluginApp", "release", "updateBizStrategyControlInfo", "RequestType", "plugin-brandservice_release"})
public final class b {
    private static final f iBW = g.ah(C0863b.pmX);
    private static long pmU;
    public static final b pmV = new b();
    private static int requestType = ((r.gzN() ? 16 : 0) | 42);

    private static MultiProcessMMKV aTI() {
        AppMethodBeat.i(175459);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) iBW.getValue();
        AppMethodBeat.o(175459);
        return multiProcessMMKV;
    }

    static {
        AppMethodBeat.i(175458);
        r rVar = r.NPl;
        AppMethodBeat.o(175458);
    }

    private b() {
    }

    public static final /* synthetic */ MultiProcessMMKV cls() {
        AppMethodBeat.i(195124);
        MultiProcessMMKV aTI = aTI();
        AppMethodBeat.o(195124);
        return aTI;
    }

    public static final void init() {
        AppMethodBeat.i(175460);
        Log.i("MicroMsg.BizStrategyManager", "alvinluo BizStrategyManager init requestType: %d", Integer.valueOf(requestType));
        c.init();
        AppMethodBeat.o(175460);
    }

    public static final void release() {
        AppMethodBeat.i(175461);
        c.release();
        AppMethodBeat.o(175461);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class a implements aa.a {
        public static final a pmW = new a();

        static {
            AppMethodBeat.i(175455);
            AppMethodBeat.o(175455);
        }

        a() {
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, d dVar, q qVar) {
            AppMethodBeat.i(175454);
            Log.i("MicroMsg.BizStrategyManager", "doBizStrategy callback %d/%d %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            b bVar = b.pmV;
            b.cls().putLong("biz_time_line_strategy_last_time", System.currentTimeMillis());
            if (i2 == 0 && i3 == 0) {
                b bVar2 = b.pmV;
                int i4 = b.requestType;
                p.g(dVar, "comReqResp");
                com.tencent.mm.bw.a aYK = dVar.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyResp");
                    AppMethodBeat.o(175454);
                    throw tVar;
                }
                b.a(i4, (qd) aYK);
                AppMethodBeat.o(175454);
            } else {
                AppMethodBeat.o(175454);
            }
            return 0;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.b.b$b  reason: collision with other inner class name */
    static final class C0863b extends kotlin.g.b.q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final C0863b pmX = new C0863b();

        static {
            AppMethodBeat.i(175457);
            AppMethodBeat.o(175457);
        }

        C0863b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(175456);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            AppMethodBeat.o(175456);
            return singleMMKV;
        }
    }

    public static final void clr() {
        String str;
        AppMethodBeat.i(175462);
        long abs = Math.abs(System.currentTimeMillis() - aTI().getLong("biz_time_line_strategy_last_time", 0));
        if (abs < aTI().getLong("biz_time_line_fetch_interval", 1800000)) {
            Log.i("MicroMsg.BizStrategyManager", "fetchBizStrategy delta < interval, return");
        } else {
            Log.i("MicroMsg.BizStrategyManager", "alvinluo fetchBizStrategy %d, requestType: %d", Long.valueOf(abs), Integer.valueOf(requestType));
            d.a aVar = new d.a();
            aVar.c(new qc());
            aVar.d(new qd());
            aVar.MB("/cgi-bin/mmbiz-bin/timeline/bizstrategy");
            aVar.sG(1806);
            d aXF = aVar.aXF();
            p.g(aXF, "rr");
            com.tencent.mm.bw.a aYJ = aXF.aYJ();
            if (aYJ == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyReq");
                AppMethodBeat.o(175462);
                throw tVar;
            }
            ((qc) aYJ).ReqType = requestType;
            aa.a(aXF, a.pmW);
        }
        if (c.clu()) {
            c cVar = c.pne;
            c.cly();
            ((com.tencent.mm.plugin.appbrand.service.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.f.class)).a(z.BIZ_TIME_LINE);
            eqs clw = c.clw();
            if (!(clw == null || (str = clw.MVS) == null)) {
                if (System.currentTimeMillis() - pmU < Util.MILLSECONDS_OF_HOUR) {
                    AppMethodBeat.o(175462);
                    return;
                }
                pmU = System.currentTimeMillis();
                ((w) com.tencent.mm.kernel.g.af(w.class)).bb(str, 0);
                AppMethodBeat.o(175462);
                return;
            }
        }
        AppMethodBeat.o(175462);
    }

    public static final /* synthetic */ void a(int i2, qd qdVar) {
        AppMethodBeat.i(175463);
        if (qdVar == null) {
            AppMethodBeat.o(175463);
            return;
        }
        qb qbVar = qdVar.KWY;
        if (qbVar != null) {
            Log.i("MicroMsg.BizStrategyManager", "alvinluo updateBizStrategyControlInfo RefreshInterval = %d", Integer.valueOf(qbVar.KWU));
            if (qbVar.KWU > 0) {
                aTI().putLong("biz_time_line_fetch_interval", (long) qbVar.KWU);
            }
        }
        if ((i2 & 2) != 0) {
            c cVar = c.JSr;
            c.c(qdVar);
        }
        if ((i2 & 8) != 0) {
            c.a(qdVar);
        }
        if ((i2 & 16) != 0) {
            r rVar = r.NPl;
            dt dtVar = qdVar.KXb;
            if (dtVar != null) {
                r.NOT = dtVar.KHK;
                r.Kmn = dtVar.KHL;
                r.gzR();
                Log.i("MicroMsg.BizCardLogic", "handleExtInfo extInfo " + r.NOT + ' ' + r.Kmn);
            }
        }
        if ((i2 & 32) != 0) {
            p.a aVar = com.tencent.mm.model.p.iCa;
            dkw dkw = qdVar.KXc;
            if (dkw == null) {
                AppMethodBeat.o(175463);
                return;
            }
            Log.i("Micromsg.BizTLRecFeedsDataUtil", "updateSvrSwitch = " + dkw.MOQ);
            if (dkw.MOQ == p.c.RECOMMEND_FEEDS_CLOSE.value) {
                p.a.aTI().encode("BizTLRecommendFeedsSvrOpen", false);
                AppMethodBeat.o(175463);
                return;
            } else if (dkw.MOQ == p.c.RECOMMEND_FEEDS_OPEN.value) {
                p.a.aTI().encode("BizTLRecommendFeedsSvrOpen", true);
            }
        }
        AppMethodBeat.o(175463);
    }
}
