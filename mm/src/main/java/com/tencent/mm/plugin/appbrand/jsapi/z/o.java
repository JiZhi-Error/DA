package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class o<CONTEXT extends f> extends d<CONTEXT> {
    public static final int CTRL_INDEX = 168;
    public static final String NAME = "setClipboardData";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(CONTEXT context, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137673);
        String optString = jSONObject.optString("data");
        if (Util.isNullOrNil(optString)) {
            context.i(i2, h("fail", null));
            AppMethodBeat.o(137673);
            return;
        }
        Log.d("MicroMsg.JsApiSetClipboardData", "stevyang dataStr %s", optString);
        ClipboardHelper.setText(context.getContext(), "text", optString);
        context.i(i2, h("ok", null));
        c(context, optString);
        AppMethodBeat.o(137673);
    }

    public void c(CONTEXT context, String str) {
    }
}
