package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J.\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiUpdateHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseUpdateViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "enableGesture", "", "getViewId", "", "data", "Lorg/json/JSONObject;", "onUpdateView", "component", "viewId", "view", "Landroid/view/View;", "Companion", "plugin-appbrand-integration_release"})
public final class m extends d<ag> {
    public static final int CTRL_INDEX = 595;
    public static final String NAME = "updateWebGLCanvas";
    public static final a lRh = new a((byte) 0);

    static {
        AppMethodBeat.i(50507);
        AppMethodBeat.o(50507);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.h, int, android.view.View, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final /* synthetic */ boolean c(ag agVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(50506);
        Log.i("JsApiUpdateHTMLCanvasElement", "update HTMLCanvasElement for canvasId[" + i2 + ']');
        boolean c2 = super.c(agVar, i2, view, jSONObject);
        AppMethodBeat.o(50506);
        return c2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiUpdateHTMLCanvasElement$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(50505);
        p.h(jSONObject, "data");
        int i2 = jSONObject.getInt("canvasId");
        AppMethodBeat.o(50505);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean bEW() {
        return true;
    }
}
