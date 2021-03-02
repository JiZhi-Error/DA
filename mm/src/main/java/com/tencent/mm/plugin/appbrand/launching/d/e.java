package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.appbrand.networking.b;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo;", "Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "Companion", "plugin-appbrand-integration_release"})
public final class e extends b<ddz> {
    public static final a mYF = new a((byte) 0);
    private final ddy mYE;
    private final d rr;

    static {
        AppMethodBeat.i(50809);
        AppMethodBeat.o(50809);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(ddy ddy) {
        super(ddy.dNI, ddy.username);
        p.h(ddy, "req");
        AppMethodBeat.i(50808);
        this.mYE = ddy;
        d.a aVar = new d.a();
        aVar.MB("/cgi-bin/mmbiz-bin/wxaapp/pregetwxadownloadurl");
        aVar.sG(1189);
        aVar.c(this.mYE);
        aVar.d(new ddz());
        d aXF = aVar.aXF();
        p.g(aXF, "rrb.buildInstance()");
        this.rr = aXF;
        c(this.rr);
        AppMethodBeat.o(50808);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo$Companion;", "", "()V", "TAG", "", "createRequest", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo;", "appId", "oldAppVersion", "", "path", "isSupportWithoutLib", "", "userName", "supportedEncryptVersion", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
