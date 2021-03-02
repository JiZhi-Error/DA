package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public class f extends d<h> {
    public static final int CTRL_INDEX = 69;
    public static final String NAME = "drawCanvas";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(145537);
        int i2 = jSONObject.getInt("canvasId");
        AppMethodBeat.o(145537);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean b(h hVar, int i2, View view, JSONObject jSONObject, final i iVar) {
        AppMethodBeat.i(145538);
        if (!(view instanceof CoverViewContainer)) {
            Log.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of CoverViewContainer.(%s)", Integer.valueOf(i2));
            AppMethodBeat.o(145538);
            return false;
        }
        View view2 = (View) ((CoverViewContainer) view).aB(View.class);
        Log.d("MicroMsg.JsApiDrawCanvas", "drawCanvas(id : %s)", Integer.valueOf(i2));
        if (!(view2 instanceof a)) {
            Log.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of AppBrandDrawableView.(%s)", Integer.valueOf(i2));
            AppMethodBeat.o(145538);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONArray optJSONArray = jSONObject.optJSONArray("actions");
        a aVar = (a) view2;
        if (jSONObject.optBoolean("reserve")) {
            aVar.b(optJSONArray, new a.AbstractC0561a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.b.f.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a.AbstractC0561a
                public final void a(DrawCanvasArg drawCanvasArg) {
                    AppMethodBeat.i(145535);
                    iVar.ZA(f.this.h("ok", null));
                    AppMethodBeat.o(145535);
                }
            });
        } else {
            aVar.a(optJSONArray, new a.AbstractC0561a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.b.f.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a.AbstractC0561a
                public final void a(DrawCanvasArg drawCanvasArg) {
                    AppMethodBeat.i(145536);
                    iVar.ZA(f.this.h("ok", null));
                    AppMethodBeat.o(145536);
                }
            });
        }
        aVar.bzg();
        Log.v("MicroMsg.JsApiDrawCanvas", "post drawCanvas cost : %sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        boolean b2 = super.b(hVar, i2, view, jSONObject, iVar);
        AppMethodBeat.o(145538);
        return b2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean bEV() {
        return true;
    }
}
