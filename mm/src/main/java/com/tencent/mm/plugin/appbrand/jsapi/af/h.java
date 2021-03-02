package com.tencent.mm.plugin.appbrand.jsapi.af;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.av;
import org.json.JSONObject;

public final class h extends c {
    public static final int CTRL_INDEX = 299;
    public static final String NAME = "removeHTMLWebView";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(47018);
        int i2 = jSONObject.getInt("htmlId");
        AppMethodBeat.o(47018);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.c
    public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(47019);
        if (view instanceof a) {
            ((a) view).destroy();
            if (hVar instanceof ag) {
                av.a((ag) hVar, null);
            }
        }
        boolean b2 = super.b(hVar, i2, view, jSONObject);
        AppMethodBeat.o(47019);
        return b2;
    }
}
