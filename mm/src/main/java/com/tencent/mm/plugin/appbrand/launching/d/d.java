package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.vending.g.c;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e\u0018\u00010\rH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "isSync", "", "(Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;Z)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "onBeforeRunCgi", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "run", "Companion", "plugin-appbrand-integration_release"})
public final class d extends com.tencent.mm.plugin.appbrand.networking.b<che> {
    public static final a mYC = new a((byte) 0);
    private final boolean kqC;
    private final chd mYB;
    private final com.tencent.mm.ak.d rr;

    static {
        AppMethodBeat.i(50807);
        AppMethodBeat.o(50807);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(chd chd, boolean z) {
        super(chd.jfi, chd.Mmv);
        p.h(chd, "req");
        AppMethodBeat.i(50806);
        this.mYB = chd;
        this.kqC = z;
        d.a aVar = new d.a();
        aVar.sG(1122);
        aVar.MB("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp");
        aVar.c(this.mYB);
        aVar.d(new che());
        com.tencent.mm.ak.d aXF = aVar.aXF();
        p.g(aXF, "rrb.buildInstance()");
        this.rr = aXF;
        c(this.rr);
        AppMethodBeat.o(50806);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J^\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u001c\u0010\u0017\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch$Companion;", "", "()V", "TAG", "", "createRequest", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "userName", "appId", "wxaAppBaseInfo", "Lcom/tencent/mm/protocal/protobuf/WxaAppBaseInfo;", "webLaunch", "Lcom/tencent/mm/protocal/protobuf/WxaWebLaunchInfo;", "appJump", "Lcom/tencent/mm/protocal/protobuf/WxaJumpInfo;", "libVersion", "", "wxaPushMsgInfo", "Lcom/tencent/mm/protocal/protobuf/WxaPushMsgInfo;", "wxaMaterialInfo", "Lcom/tencent/mm/protocal/protobuf/WxaMaterialInfo;", "isSync", "", "createRequestForCmdPreLaunch", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.networking.b, com.tencent.mm.ak.c
    public final f<c.a<che>> aYI() {
        AppMethodBeat.i(50805);
        com.tencent.mm.plugin.appbrand.launching.a.a aVar = new com.tencent.mm.plugin.appbrand.launching.a.a();
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
            AppMethodBeat.o(50805);
            throw tVar;
        }
        f<c.a<che>> a2 = aVar.a((chd) aYJ, this.kqC, this);
        com.tencent.mm.bw.a aYJ2 = this.rr.aYJ();
        if (aYJ2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
            AppMethodBeat.o(50805);
            throw tVar2;
        }
        com.tencent.mm.plugin.appbrand.launching.a.b.a((chd) aYJ2);
        com.tencent.mm.bw.a aYJ3 = this.rr.aYJ();
        if (aYJ3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
            AppMethodBeat.o(50805);
            throw tVar3;
        }
        com.tencent.mm.plugin.appbrand.launching.a.b.b((chd) aYJ3);
        f<c.a<che>> aYI = a2 == null ? super.aYI() : a2;
        AppMethodBeat.o(50805);
        return aYI;
    }

    @Override // com.tencent.mm.plugin.appbrand.networking.b
    public final f<c.a<che>> bAe() {
        AppMethodBeat.i(228752);
        if (!com.tencent.mm.plugin.appbrand.networking.a.eA(this.mYB.jfi, this.mYB.Mmv)) {
            f<c.a<che>> c2 = g.c(new b(this));
            AppMethodBeat.o(228752);
            return c2;
        }
        AppMethodBeat.o(228752);
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class b<_Ret> implements c.a<_Var> {
        final /* synthetic */ d mYD;

        b(d dVar) {
            this.mYD = dVar;
        }

        @Override // com.tencent.mm.vending.g.c.a
        public final /* synthetic */ Object call() {
            AppMethodBeat.i(228751);
            c.a a2 = c.a.a(4, -2, "", null, null, this.mYD);
            AppMethodBeat.o(228751);
            return a2;
        }
    }
}
