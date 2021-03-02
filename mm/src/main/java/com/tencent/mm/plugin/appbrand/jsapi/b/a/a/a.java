package com.tencent.mm.plugin.appbrand.jsapi.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/jsapi/AppBrandWebGLPluginJsApi;", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandPluginAsyncJsApi;", "()V", "getPluginType", "", "getViewId", "", "data", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
public class a extends c {
    @Override // com.tencent.mm.plugin.appbrand.h.c
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(228367);
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("canvasId", -1);
            AppMethodBeat.o(228367);
            return optInt;
        }
        AppMethodBeat.o(228367);
        return -1;
    }

    @Override // com.tencent.mm.plugin.appbrand.h.c
    public final String bCy() {
        return "webgl";
    }
}
