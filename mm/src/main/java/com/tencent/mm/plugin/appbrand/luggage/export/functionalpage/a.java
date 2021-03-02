package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.fej;
import com.tencent.mm.protocal.protobuf.fek;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00130\u0012H\u0016J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u0004\u0018\u00010\u0004H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/WxaRuntimeUpdateDeeplinkInfoResp;", "ticket", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "Companion", "plugin-appbrand-integration_release"})
public final class a extends c<fek> {
    public static final C0746a nap = new C0746a((byte) 0);
    private final String dHx;
    private final String nao;
    private final int status;

    static {
        AppMethodBeat.i(228831);
        AppMethodBeat.o(228831);
    }

    private a(String str, String str2) {
        b bfZ;
        AppMethodBeat.i(228830);
        this.dHx = str;
        this.status = 3;
        this.nao = str2;
        d.a aVar = new d.a();
        fej fej = new fej();
        fej.status = this.status;
        String str3 = this.nao;
        if (str3 == null) {
            bfZ = null;
        } else {
            bfZ = b.bfZ(str3);
        }
        fej.NzD = bfZ;
        fej.NzE = this.dHx;
        aVar.c(fej);
        aVar.d(new fek());
        aVar.sG(2889);
        aVar.MB("/cgi-bin/mmbiz-bin/wxaruntime/updatedeeplinkinfo");
        c(aVar.aXF());
        AppMethodBeat.o(228830);
    }

    public /* synthetic */ a(String str, String str2, byte b2) {
        this(str, str2);
    }

    @Override // com.tencent.mm.ak.c
    public final f<c.a<fek>> aYI() {
        AppMethodBeat.i(228828);
        Log.i("MicroMsg.CgiRuntimeUpdateDeepLinkInfo", "run() ticket:" + this.dHx + " status:" + this.status + ", cgiHash[" + hashCode() + ']');
        f<c.a<fek>> aYI = super.aYI();
        p.g(aYI, "super.run()");
        AppMethodBeat.o(228828);
        return aYI;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo$Companion;", "", "()V", "STATUS_CONSUMED", "", "STATUS_EXPIRED", "STATUS_FINISHED", "STATUS_INITIAL", "TAG", "", "confirm", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo;", "ticket", "respData", "consume", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a$a  reason: collision with other inner class name */
    public static final class C0746a {
        private C0746a() {
        }

        public /* synthetic */ C0746a(byte b2) {
            this();
        }

        public static a el(String str, String str2) {
            AppMethodBeat.i(228827);
            p.h(str, "ticket");
            a aVar = new a(str, str2, (byte) 0);
            AppMethodBeat.o(228827);
            return aVar;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, fek fek, q qVar) {
        AppMethodBeat.i(228829);
        Log.i("MicroMsg.CgiRuntimeUpdateDeepLinkInfo", "onCgiBack errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + ", cgiHash[" + hashCode() + ']');
        AppMethodBeat.o(228829);
    }
}
