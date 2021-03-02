package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.a.b;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "TAG", "", "errorReturn", "", "reason", "handleRequest", "_req", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class m extends AppBrandProxyUIProcessTask {
    private final String TAG = "MicroMsg.AppBrand.FunctionalDirectApi.ProxyTask";

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
        AppBrandProxyUIProcessTask.ProcessRequest processRequest2;
        AppMethodBeat.i(228929);
        if (!(processRequest instanceof ProxyRequest)) {
            processRequest2 = null;
        } else {
            processRequest2 = processRequest;
        }
        ProxyRequest proxyRequest = (ProxyRequest) processRequest2;
        if (proxyRequest == null) {
            acy("Invalid ProxyRequest");
            AppMethodBeat.o(228929);
            return;
        }
        a aVar = a.nbk;
        a aVar2 = a.nbk;
        Object obj = (b) a.c(a.bOJ(), proxyRequest.nbK);
        if (obj == null) {
            acy("Invalid functionHash");
            obj = x.SXb;
        }
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.ProxyFunction /* = (com.tencent.mm.ui.MMActivity) -> kotlin.Unit */");
            AppMethodBeat.o(228929);
            throw tVar;
        }
        MMActivity bDF = bDF();
        p.g(bDF, "activityContext");
        ((b) af.r(obj, 1)).invoke(bDF);
        AppMethodBeat.o(228929);
    }

    private final void acy(String str) {
        AppMethodBeat.i(228930);
        Log.e(this.TAG, "errorReturn reason:".concat(String.valueOf(str)));
        b(null);
        AppMethodBeat.o(228930);
    }
}
