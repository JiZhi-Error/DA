package com.tencent.mm.plugin.appbrand.jsapi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.k;
import com.tencent.mm.plugin.appbrand.page.a.h;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0014¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiShowStatusBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiPageExtensionBased;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewStatusBarExtension;", "()V", "invokeByExt", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "ext", "Companion", "luggage-wxa-app-jsapi_release"})
public final class d extends k<com.tencent.mm.plugin.appbrand.d, h> {
    private static final int CTRL_INDEX = CTRL_INDEX;
    private static final String NAME = NAME;
    @Deprecated
    public static final a muZ = new a((byte) 0);

    public d() {
        super(h.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.d, org.json.JSONObject, int, java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.p.k
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2, h hVar) {
        AppMethodBeat.i(138293);
        h hVar2 = hVar;
        p.h(dVar, "env");
        p.h(jSONObject, "data");
        p.h(hVar2, "ext");
        hVar2.Nj();
        dVar.i(i2, Zf("ok"));
        AppMethodBeat.o(138293);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiShowStatusBar$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wxa-app-jsapi_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(138294);
        AppMethodBeat.o(138294);
    }
}
