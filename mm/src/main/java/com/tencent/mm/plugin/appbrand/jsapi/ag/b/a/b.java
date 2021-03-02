package com.tencent.mm.plugin.appbrand.jsapi.ag.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class b extends c {
    private static final int CTRL_INDEX = 673;
    public static final String NAME = "removeXWebCanvas";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(139454);
        int optInt = jSONObject.optInt("viewId");
        AppMethodBeat.o(139454);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.c
    public final boolean b(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(215833);
        View view2 = (View) ((CoverViewContainer) view).aB(View.class);
        if (view2 == null || !(view2 instanceof d)) {
            Log.w("Luggage.JsApiRemoveXWebCanvasTextureView", "the skia canvas view(%s) is null", Integer.valueOf(i2));
            AppMethodBeat.o(215833);
            return false;
        }
        ((d) view2).release();
        AppMethodBeat.o(215833);
        return true;
    }
}
