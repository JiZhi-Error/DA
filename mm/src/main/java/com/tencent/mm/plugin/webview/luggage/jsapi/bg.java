package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class bg extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "setNavigationBarButtons";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78625);
        Log.i("MicroMsg.JsApiSetNavigationBarButtons", "invokeInOwn");
        String optString = aVar.ctb.csi.optString("left");
        String optString2 = aVar.ctb.csi.optString("right");
        if (!Util.isNullOrNil(optString) || !Util.isNullOrNil(optString2)) {
            Bundle bundle = new Bundle();
            try {
                JSONObject jSONObject = new JSONObject(optString);
                String bfL = z.bfL(jSONObject.optString("wxcolor", ""));
                if (Util.isNullOrNil(bfL)) {
                    bfL = jSONObject.optString("color", "");
                }
                if (!Util.isNullOrNil(bfL)) {
                    bundle.putString("set_navigation_bar_buttons_left_text_color", bfL);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.JsApiSetNavigationBarButtons", e2, "setNavigationBarButtons opt left ", new Object[0]);
            }
            try {
                JSONObject jSONObject2 = new JSONObject(optString2);
                boolean optBoolean = jSONObject2.optBoolean("hidden", false);
                String optString3 = jSONObject2.optString("text", "");
                String nullAsNil = Util.nullAsNil(z.bfI(jSONObject2.optString("iconData", "")));
                String bfL2 = z.bfL(jSONObject2.optString("wxcolor", ""));
                if (Util.isNullOrNil(bfL2)) {
                    bfL2 = jSONObject2.optString("color", "");
                }
                boolean optBoolean2 = jSONObject2.optBoolean("needClickEvent", false);
                if (!optBoolean) {
                    bundle.putString("set_navigation_bar_buttons_text", optString3);
                    bundle.putString("set_navigation_bar_buttons_icon_data", nullAsNil);
                    bundle.putString("set_navigation_bar_buttons_text_color", bfL2);
                    bundle.putBoolean("set_navigation_bar_buttons_need_click_event", optBoolean2);
                } else {
                    bundle.putBoolean("set_navigation_bar_buttons_hide_right_button", true);
                }
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.JsApiSetNavigationBarButtons", e3, "setNavigationBarButtons opt right ", new Object[0]);
            }
            if (bundle.size() < 0) {
                aVar.c("fail", null);
                AppMethodBeat.o(78625);
                return;
            }
            m gbC = aVar.cta.gbC();
            if (gbC == null) {
                aVar.c("fail", null);
                AppMethodBeat.o(78625);
                return;
            }
            gbC.setNavigationBarButtons(bundle);
            aVar.c("", null);
            AppMethodBeat.o(78625);
            return;
        }
        aVar.c("fail", null);
        AppMethodBeat.o(78625);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
