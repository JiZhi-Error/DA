package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.luggage.sdk.b.a.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0014R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/debugger/RemoteDebugServiceLogicWC;", "Lcom/tencent/luggage/sdk/jsapi/component/service/MPRemoteDebugServiceLogic;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "service", "(Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;)V", "getService", "()Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "onCreateJsApiPool", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "plugin-appbrand-integration_release"})
public final class t extends j<c> {
    private final c liR;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(c cVar) {
        super(cVar);
        p.h(cVar, "service");
        AppMethodBeat.i(50353);
        this.liR = cVar;
        AppMethodBeat.o(50353);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> Nf() {
        AppMethodBeat.i(50352);
        Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> bEk = com.tencent.mm.plugin.appbrand.jsapi.t.bEk();
        p.g(bEk, "AppBrandJsApiPool.getServiceApiPool()");
        AppMethodBeat.o(50352);
        return bEk;
    }
}
