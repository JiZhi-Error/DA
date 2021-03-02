package com.tencent.mm.plugin.appbrand.jsapi.af;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONObject;

public final class i extends d {
    public static final int CTRL_INDEX = 300;
    public static final String NAME = "updateHTMLWebView";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean c(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(47020);
        if (!(view instanceof a)) {
            AppMethodBeat.o(47020);
            return false;
        }
        if (jSONObject.has("backgroundColor")) {
            try {
                view.setBackgroundColor(g.afE(jSONObject.getString("backgroundColor")));
            } catch (Exception e2) {
            }
        }
        String optString = jSONObject.optString("src", "");
        Log.i("MicroMsg.AppBrand.JsApiUpdateHTMLWebView", "onUpdateView appId[%s] viewId[%d] viewHash[%d] src[%s]", hVar.getAppId(), Integer.valueOf(i2), Integer.valueOf(view.hashCode()), optString);
        if (TextUtils.isEmpty(optString)) {
            AppMethodBeat.o(47020);
            return true;
        }
        MMWebView webView = ((a) view).getWebView();
        if (optString.indexOf("#") < 0 || TextUtils.isEmpty(webView.getUrl())) {
            webView.loadUrl(optString);
        } else {
            webView.evaluateJavascript(String.format("window.location=\"%s\"", r.afJ(optString)), null);
        }
        AppMethodBeat.o(47020);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(47021);
        int i2 = jSONObject.getInt("htmlId");
        AppMethodBeat.o(47021);
        return i2;
    }
}
