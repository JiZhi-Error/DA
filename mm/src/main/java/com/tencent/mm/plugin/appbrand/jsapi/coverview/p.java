package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c;
import com.tencent.mm.plugin.appbrand.jsapi.ac.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.widget.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class p extends d {
    private static final int CTRL_INDEX = 254;
    public static final String NAME = "updateImageView";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(137542);
        int i2 = jSONObject.getInt("viewId");
        AppMethodBeat.o(137542);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean c(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(137543);
        Log.d("MicroMsg.JsApiUpdateImageView", "onUpdateView(viewId : %s, %s)", Integer.valueOf(i2), jSONObject);
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiUpdateImageView", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(137543);
            return false;
        }
        a aVar = (a) ((CoverViewContainer) view).aB(a.class);
        if (aVar == null) {
            Log.w("MicroMsg.JsApiUpdateImageView", "the target view(%s) is null", Integer.valueOf(i2));
            AppMethodBeat.o(137543);
            return false;
        }
        f.b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
        c.a(hVar, i2, aVar, jSONObject, new b(i2, aVar.getKeyValueSet(), hVar));
        boolean c2 = super.c(hVar, i2, view, jSONObject);
        AppMethodBeat.o(137543);
        return c2;
    }
}
