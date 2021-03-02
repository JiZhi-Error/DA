package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class k extends c {
    private static final int CTRL_INDEX = 811;
    public static final String NAME = "removeImagePreviewer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.c
    public final boolean b(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(226740);
        Log.d("MicroMsg.JsApiRemoveImagePreviewer", "insertImagePreviewer(viewId : %s, %s)", Integer.valueOf(i2), jSONObject);
        hVar.getCustomViewContainer().wC(i2);
        boolean b2 = super.b(hVar, i2, view, jSONObject);
        AppMethodBeat.o(226740);
        return b2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(226741);
        int i2 = jSONObject.getInt("viewId");
        AppMethodBeat.o(226741);
        return i2;
    }
}
