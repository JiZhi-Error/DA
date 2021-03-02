package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.game.page.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiFunctionalPageStartGame;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class bd extends d<c> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "functionalPageStartGame";
    public static final a lzz = new a((byte) 0);

    static {
        AppMethodBeat.i(228283);
        AppMethodBeat.o(228283);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        String str;
        String optString;
        AppMethodBeat.i(228282);
        c cVar2 = cVar;
        p.h(cVar2, "service");
        if (jSONObject == null || (optString = jSONObject.optString("url", "index.html")) == null) {
            str = "index.html";
        } else {
            str = optString;
        }
        Log.i("MicroMsg.AppBrand.JsApiFunctionalPageStartGame", "invoke: ".concat(String.valueOf(str)));
        q runtime = cVar2.getRuntime();
        p.g(runtime, "service.runtime");
        x bsD = runtime.bsD();
        p.g(bsD, "service.runtime.pageContainer");
        t currentPage = bsD.getCurrentPage();
        if (currentPage == null || !(currentPage instanceof e)) {
            cVar2.i(i2, Zf("fail: current page is null or not GamePage"));
            AppMethodBeat.o(228282);
            return;
        }
        ((e) currentPage).setCurrentUrl(str);
        ac currentPageView = ((e) currentPage).getCurrentPageView();
        if (currentPageView == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.page.AppBrandPageViewWC");
            AppMethodBeat.o(228282);
            throw tVar;
        }
        ((ag) currentPageView).bRK().aeG(str);
        cVar2.i(i2, Zf("ok"));
        AppMethodBeat.o(228282);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiFunctionalPageStartGame$Companion;", "", "()V", "CTRL_INDEX", "", "DEFAULT_URL", "", "NAME", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
