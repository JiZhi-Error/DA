package com.tencent.mm.plugin.webview.luggage;

import android.os.Build;
import android.webkit.WebResourceResponse;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.webview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

public final class e implements c {
    private String ISX = "";

    public e() {
    }

    public e(String str) {
        this.ISX = str;
    }

    @Override // com.tencent.luggage.webview.a.c
    public final String Pl() {
        return "weixin://bridge.js";
    }

    @Override // com.tencent.luggage.webview.a.c
    public final WebResourceResponse cX(String str) {
        AppMethodBeat.i(78212);
        if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(78212);
            return null;
        }
        try {
            WebResourceResponse webResourceResponse = new WebResourceResponse("application/javascript", ProtocolPackage.ServerEncoding, new ByteArrayInputStream((d.afA("LuggageBridge.js") + this.ISX).getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET)));
            HashMap hashMap = new HashMap();
            hashMap.put("Cache-Control", "no-cache, no-store, must-revalidate");
            hashMap.put("Pragma", "no-cache");
            hashMap.put("Expires", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            webResourceResponse.setResponseHeaders(hashMap);
            AppMethodBeat.o(78212);
            return webResourceResponse;
        } catch (Exception e2) {
            Log.printDebugStack("MicroMsg.LuggageMMJsBridgeResourceProvider", "", e2);
            AppMethodBeat.o(78212);
            return null;
        }
    }
}
