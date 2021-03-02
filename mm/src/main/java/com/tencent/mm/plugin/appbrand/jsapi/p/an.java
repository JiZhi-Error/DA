package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0014¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/PrivateJsApiSetDisplayOrientation;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiPageExtensionBasedSync;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewOrientationExtension;", "()V", "invokeByExt", "", "env", "data", "Lorg/json/JSONObject;", "ext", "Companion", "luggage-wechat-full-sdk_release"})
public final class an extends l<d, com.tencent.mm.plugin.appbrand.page.a.d> {
    public static final int CTRL_INDEX = 533;
    public static final String NAME = "setDisplayOrientation";
    @Deprecated
    public static final a mlz = new a((byte) 0);

    static {
        AppMethodBeat.i(147949);
        AppMethodBeat.o(147949);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.p.l
    public final /* synthetic */ String a(d dVar, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.page.a.d dVar2) {
        String str;
        AppMethodBeat.i(147948);
        com.tencent.mm.plugin.appbrand.page.a.d dVar3 = dVar2;
        p.h(dVar, "env");
        p.h(jSONObject, "data");
        p.h(dVar3, "ext");
        switch (jSONObject.optInt("orientation", 0)) {
            case -90:
                str = "landscapeLeft";
                break;
            case 90:
                str = "landscape";
                break;
            default:
                str = "portrait";
                break;
        }
        Log.i("MicroMsg.AppBrand.PrivateJsApiSetDisplayOrientation", "set display orientation:%s", str);
        dVar3.dx(str);
        String Zf = Zf("ok");
        p.g(Zf, "makeReturnJson(\"ok\")");
        AppMethodBeat.o(147948);
        return Zf;
    }

    public an() {
        super(com.tencent.mm.plugin.appbrand.page.a.d.class);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/PrivateJsApiSetDisplayOrientation$Companion;", "", "()V", "CTRL_INDEX", "", "LANDSCAPE", "LANDSCAPE_REVERSE", "NAME", "", "PORTRAIT", "TAG", "luggage-wechat-full-sdk_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
