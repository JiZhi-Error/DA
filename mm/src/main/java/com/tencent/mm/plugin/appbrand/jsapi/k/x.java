package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class x extends c {
    public static final int CTRL_INDEX = 3;
    public static final String NAME = "removeMap";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(143687);
        int ab = f.ab(jSONObject);
        AppMethodBeat.o(143687);
        return ab;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.c
    public final boolean b(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(143688);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiRemoveMap", "data is null");
            AppMethodBeat.o(143688);
            return false;
        }
        e.xg(6);
        if (g.dA(hVar.getAppId(), f.i(hVar, jSONObject))) {
            e.xg(7);
        } else {
            e.xg(8);
        }
        AppMethodBeat.o(143688);
        return true;
    }
}
