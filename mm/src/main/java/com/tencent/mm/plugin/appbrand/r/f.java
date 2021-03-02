package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.cev;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneOperateWxDataHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class f {
    public static final a nhA = new a((byte) 0);

    static {
        AppMethodBeat.i(229058);
        AppMethodBeat.o(229058);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneOperateWxDataHelper$Companion;", "", "()V", "getReqRespBuilder", "Lcom/tencent/mm/modelbase/CommReqResp$Builder;", "keepAlive", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final d.a id(boolean z) {
        AppMethodBeat.i(229059);
        d.a aVar = new d.a();
        aVar.c(new ceu());
        aVar.d(new cev());
        aVar.setKeepAlive(z);
        aVar.MB(z ? "/cgi-bin/mmbiz-bin/js-operatewxdata-keepalive" : "/cgi-bin/mmbiz-bin/js-operatewxdata");
        aVar.sG(z ? 4602 : 1133);
        aVar.sI(0);
        aVar.sJ(0);
        AppMethodBeat.o(229059);
        return aVar;
    }
}
