package com.tencent.mm.plugin.game.luggage.i;

import android.webkit.JavascriptInterface;
import com.facebook.internal.NativeProtocol;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.j;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    @JavascriptInterface
    public final void postMessage(String str) {
        AppMethodBeat.i(187009);
        if (str == null) {
            AppMethodBeat.o(187009);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("pageId");
            JSONObject optJSONObject = jSONObject.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
            s aYs = j.aYs(optString);
            if (aYs == null) {
                Log.e("MicroMsg.GameV8JsInterface", "page is null, pageId : %s", optString);
                AppMethodBeat.o(187009);
                return;
            }
            String format = String.format("javascript:WxGameJsCoreBridge.invokeEvent(%s)", optJSONObject.toString());
            Log.i("MicroMsg.GameV8JsInterface", "postMessage, js = %s", format);
            aYs.ctS.cT(format);
            AppMethodBeat.o(187009);
        } catch (JSONException e2) {
            AppMethodBeat.o(187009);
        }
    }

    @JavascriptInterface
    public final void log(String str) {
        AppMethodBeat.i(187010);
        if (str == null) {
            AppMethodBeat.o(187010);
            return;
        }
        Log.i("MicroMsg.GameV8JsInterface", "js console log : %s", str);
        AppMethodBeat.o(187010);
    }

    @JavascriptInterface
    public final void error(String str) {
        AppMethodBeat.i(187011);
        if (str == null) {
            AppMethodBeat.o(187011);
            return;
        }
        Log.e("MicroMsg.GameV8JsInterface", "js console error : %s", str);
        AppMethodBeat.o(187011);
    }
}
