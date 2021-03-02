package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoSync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "Companion", "luggage-wechat-full-sdk_release"})
public final class l extends ab<d> {
    private static final int CTRL_INDEX = 918;
    private static final String NAME = "getSystemInfoSync";
    @Deprecated
    public static final a mtZ = new a((byte) 0);

    static {
        AppMethodBeat.i(230108);
        AppMethodBeat.o(230108);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoSync$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wechat-full-sdk_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(d dVar, JSONObject jSONObject) {
        AppMethodBeat.i(230107);
        d dVar2 = dVar;
        p Ze = dVar2.Ze("getSystemInfo");
        if (!(Ze instanceof i)) {
            Ze = null;
        }
        i iVar = (i) Ze;
        if (iVar == null) {
            String Zf = Zf("fail:not supported");
            kotlin.g.b.p.g(Zf, "makeReturnJson(Constants…ApiMsg.API_NOT_SUPPORTED)");
            AppMethodBeat.o(230107);
            return Zf;
        }
        String n = n("ok", iVar.a(dVar2));
        kotlin.g.b.p.g(n, "makeReturnJson(\"ok\", legacyImpl.getInfo(env))");
        AppMethodBeat.o(230107);
        return n;
    }
}
