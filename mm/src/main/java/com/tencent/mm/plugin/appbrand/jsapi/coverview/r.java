package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c;
import com.tencent.mm.plugin.appbrand.jsapi.ac.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class r extends d {
    private static final int CTRL_INDEX = 254;
    public static final String NAME = "updateTextView";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(137547);
        int i2 = jSONObject.getInt("viewId");
        AppMethodBeat.o(137547);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean c(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(137548);
        Log.d("MicroMsg.JsApiUpdateTextView", "onUpdateView(viewId : %s, %s)", Integer.valueOf(i2), jSONObject);
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiUpdateTextView", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(137548);
            return false;
        }
        com.tencent.mm.plugin.appbrand.widget.d dVar = (com.tencent.mm.plugin.appbrand.widget.d) ((CoverViewContainer) view).aB(com.tencent.mm.plugin.appbrand.widget.d.class);
        if (dVar == null) {
            Log.w("MicroMsg.JsApiUpdateTextView", "the target view(%s) is null", Integer.valueOf(i2));
        }
        c.a(dVar, jSONObject.optJSONObject("label"));
        f.b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
        boolean c2 = super.c(hVar, i2, view, jSONObject);
        AppMethodBeat.o(137548);
        return c2;
    }
}
