package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class h extends ab<ac> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "initReady";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public /* bridge */ /* synthetic */ String a(ac acVar, JSONObject jSONObject) {
        AppMethodBeat.i(134880);
        String a2 = a(acVar, jSONObject);
        AppMethodBeat.o(134880);
        return a2;
    }

    public String a(ac acVar, JSONObject jSONObject) {
        AppMethodBeat.i(134879);
        boolean optBoolean = jSONObject.optBoolean("ignoreWebviewPreload", false);
        Log.i("MicroMsg.JsApiInitReady", "invoke, appId:%s, webviewId:%s, ignoreWebviewPreload:%b, url:%s", acVar.getAppId(), Integer.valueOf(acVar.getComponentId()), Boolean.valueOf(optBoolean), acVar.lBI);
        if (!optBoolean) {
            acVar.getRuntime().brh().i(acVar);
        }
        acVar.adM(NAME);
        String h2 = h("ok", null);
        AppMethodBeat.o(134879);
        return h2;
    }
}
