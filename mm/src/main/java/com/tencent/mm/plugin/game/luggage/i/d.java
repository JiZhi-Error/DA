package com.tencent.mm.plugin.game.luggage.i;

import android.webkit.JavascriptInterface;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    private String xzD;

    public d(String str) {
        this.xzD = str;
    }

    @JavascriptInterface
    public final void postMessage(String str) {
        AppMethodBeat.i(187012);
        if (str == null) {
            AppMethodBeat.o(187012);
            return;
        }
        try {
            g gVar = new g(this.xzD, new JSONObject(str).optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS));
            if (a.dTW() != null) {
                f fVar = a.dTW().xzn;
                Log.i("MicroMsg.Page2JsCoreMsgDispatch", "evaluateMessage, hasDestroyed = %b, hasReady = %b", Boolean.valueOf(fVar.xzH), Boolean.valueOf(fVar.xzG));
                if (!fVar.xzH) {
                    if (!fVar.xzG) {
                        fVar.xzJ.add(gVar);
                        AppMethodBeat.o(187012);
                        return;
                    }
                    fVar.xzo.evaluateJavascript(String.format("WxGameJsCoreBridge.invokeEvent(%s,\"%s\")", gVar.lnV.toString(), gVar.pageId), null);
                }
            }
            AppMethodBeat.o(187012);
        } catch (JSONException e2) {
            AppMethodBeat.o(187012);
        }
    }
}
