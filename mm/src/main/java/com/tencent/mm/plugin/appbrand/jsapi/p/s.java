package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiRewriteRoute;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app_release"})
public final class s extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "rewriteRoute";
    @Deprecated
    public static final a mkE = new a((byte) 0);

    static {
        AppMethodBeat.i(219681);
        AppMethodBeat.o(219681);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiRewriteRoute$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wxa-app_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2) {
        String str;
        boolean z;
        Integer num = null;
        AppMethodBeat.i(219680);
        com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        if (dVar2 == null) {
            AppMethodBeat.o(219680);
            return;
        }
        if (jSONObject != null) {
            str = jSONObject.optString("url");
        } else {
            str = null;
        }
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar2.i(i2, Zf("fail:invalid data"));
            AppMethodBeat.o(219680);
            return;
        }
        if (jSONObject != null) {
            num = Integer.valueOf(jSONObject.optInt("webviewId", 0));
        }
        int intValue = num.intValue();
        Log.i("Luggage.WXA.JsApiRewriteRoute", "invoke rewriteRoute, webviewId:" + intValue + ", url:" + str);
        dVar2.P(new b(this, dVar2, intValue, str, i2));
        AppMethodBeat.o(219680);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lBv;
        final /* synthetic */ int lyo;
        final /* synthetic */ s mkF;
        final /* synthetic */ int mkG;
        final /* synthetic */ String mkH;

        b(s sVar, com.tencent.mm.plugin.appbrand.d dVar, int i2, String str, int i3) {
            this.mkF = sVar;
            this.lBv = dVar;
            this.mkG = i2;
            this.mkH = str;
            this.lyo = i3;
        }

        public final void run() {
            AppMethodBeat.i(219679);
            AppBrandRuntime runtime = this.lBv.getRuntime();
            p.g(runtime, "env.runtime");
            this.lBv.i(this.lyo, this.mkF.Zf(runtime.brh().ar(this.mkG, this.mkH) ? "ok" : "fail"));
            AppMethodBeat.o(219679);
        }
    }
}
