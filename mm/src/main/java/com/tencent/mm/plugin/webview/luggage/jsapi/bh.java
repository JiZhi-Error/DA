package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.z;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import org.json.JSONObject;

public class bh extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return z.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        boolean z;
        AppMethodBeat.i(78626);
        Log.i("MicroMsg.JsApiSetNavigationBarColor", "invoke");
        boolean z2 = aVar.ctb.csi.optInt("actionCode") == 1;
        float f2 = -1.0f;
        String str = "";
        try {
            JSONObject optJSONObject = aVar.ctb.csi.optJSONObject("wxcolor");
            if (optJSONObject == null) {
                str = aVar.ctb.csi.optString("color");
                z = z2;
            } else if (ao.isDarkMode()) {
                str = optJSONObject.optString("dark");
                z = z2;
            } else {
                str = optJSONObject.optString("light");
                z = z2;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiSetNavigationBarColor", e2.getMessage());
            z = true;
        }
        try {
            f2 = (float) aVar.ctb.csi.optDouble("alpha", -1.0d);
        } catch (Exception e3) {
            Log.e("MicroMsg.JsApiSetNavigationBarColor", e3.getMessage());
        }
        int optInt = aVar.ctb.csi.optInt("iconDark", -1);
        if (z) {
            aVar.cta.bDo();
        } else {
            aVar.cta.c(str, f2, optInt);
        }
        Log.d("MicroMsg.JsApiSetNavigationBarColor", "colorStr:%s, alpha:%f, iconDark:%d", str, Float.valueOf(f2), Integer.valueOf(optInt));
        aVar.c("", null);
        AppMethodBeat.o(78626);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
