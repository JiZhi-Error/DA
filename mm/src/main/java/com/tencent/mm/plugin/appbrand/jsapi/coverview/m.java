package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import org.json.JSONObject;

public final class m extends c {
    private static final int CTRL_INDEX = 448;
    public static final String NAME = "removeScrollView";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(137538);
        int i2 = jSONObject.getInt("viewId");
        AppMethodBeat.o(137538);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.c
    public final boolean b(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(137539);
        hVar.gA(jSONObject.optBoolean("independent", false)).wC(i2);
        boolean b2 = super.b(hVar, i2, view, jSONObject);
        AppMethodBeat.o(137539);
        return b2;
    }
}
