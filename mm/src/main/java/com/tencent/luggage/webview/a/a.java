package com.tencent.luggage.webview.a;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;

public final class a implements c {
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.tencent.luggage.webview.a.c
    public final String Pl() {
        return "^luggage://bridge$";
    }

    @Override // com.tencent.luggage.webview.a.c
    public final WebResourceResponse cX(String str) {
        AppMethodBeat.i(140556);
        try {
            WebResourceResponse webResourceResponse = new WebResourceResponse("application/javascript", MimeTypeUtil.ContentType.DEFAULT_CHARSET, this.mContext.getAssets().open("LuggageBridge.js"));
            AppMethodBeat.o(140556);
            return webResourceResponse;
        } catch (Exception e2) {
            AppMethodBeat.o(140556);
            return null;
        }
    }
}
