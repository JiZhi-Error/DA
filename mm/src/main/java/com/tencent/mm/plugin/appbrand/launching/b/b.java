package com.tencent.mm.plugin.appbrand.launching.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.co.f;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.launching.ao;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.fcc;
import com.tencent.mm.protocal.protobuf.fdb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.c;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J6\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00120\u0011H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/CgiPrefetchLaunchWxaApp;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", ch.COL_USERNAME, "", "enterPath", "(Ljava/lang/String;Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"})
public final class b extends c<che> {
    private final String kHw;
    private final String username;

    public b(String str, String str2) {
        this.username = str;
        this.kHw = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, che che, q qVar) {
        AppMethodBeat.i(50784);
        che che2 = che;
        Log.i("MicroMsg.AppBrand.CgiPrefetchLaunchWxaApp", "onCgiBack, instance[" + hashCode() + "] errType[" + i2 + "] errCode[" + i3 + "] errMsg[" + str + "], accHasReady[" + g.aAc() + ']');
        if (g.aAc()) {
            String str2 = che2 != null ? che2.dNI : null;
            if (!(str2 == null || str2.length() == 0)) {
                if (com.tencent.mm.plugin.appbrand.r.a.a(i2, i3, che2)) {
                    ao buD = n.buD();
                    if (che2 == null) {
                        p.hyc();
                    }
                    String str3 = che2.dNI;
                    if (str3 == null) {
                        p.hyc();
                    }
                    buD.a(str3, che2);
                }
                AppMethodBeat.o(50784);
                return;
            }
        }
        AppMethodBeat.o(50784);
    }

    @Override // com.tencent.mm.ak.c
    public final f<c.a<che>> aYI() {
        AppMethodBeat.i(50783);
        String str = this.username;
        if (str == null || str.length() == 0) {
            f<c.a<che>> c2 = com.tencent.mm.co.g.c(new a(this));
            p.g(c2, "pipelineExt {\n          …          )\n            }");
            AppMethodBeat.o(50783);
            return c2;
        }
        Log.i("MicroMsg.AppBrand.CgiPrefetchLaunchWxaApp", "run() with username[" + this.username + "] enterPath[" + this.kHw + "] instance[" + hashCode() + ']');
        d.a aVar = new d.a();
        chd chd = new chd();
        chd.Mmv = this.username;
        fcc fcc = new fcc();
        fcc.MqE = this.kHw;
        chd.Mmn = fcc;
        chd.Mem = true;
        chd.Men = true;
        fdb fdb = new fdb();
        ICommLibReader bvT = at.bvT();
        fdb.MqF = bvT != null ? bvT.bvd() : -1;
        chd.Mmp = fdb;
        aVar.c(chd);
        aVar.sG(1122);
        aVar.MB("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp");
        aVar.d(new che());
        d aXF = aVar.aXF();
        p.g(aXF, "rr");
        com.tencent.mm.bw.a aYJ = aXF.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
            AppMethodBeat.o(50783);
            throw tVar;
        }
        com.tencent.mm.plugin.appbrand.launching.a.b.a((chd) aYJ);
        com.tencent.mm.bw.a aYJ2 = aXF.aYJ();
        if (aYJ2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
            AppMethodBeat.o(50783);
            throw tVar2;
        }
        com.tencent.mm.plugin.appbrand.launching.a.b.b((chd) aYJ2);
        c(aXF);
        f<c.a<che>> aYI = super.aYI();
        p.g(aYI, "super.run()");
        AppMethodBeat.o(50783);
        return aYI;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class a<_Ret> implements c.a<_Var> {
        final /* synthetic */ b mYb;

        a(b bVar) {
            this.mYb = bVar;
        }

        @Override // com.tencent.mm.vending.g.c.a
        public final /* synthetic */ Object call() {
            AppMethodBeat.i(50782);
            c.a a2 = c.a.a(3, -2, "EMPTY USERNAME", new che(), null, this.mYb);
            AppMethodBeat.o(50782);
            return a2;
        }
    }
}
