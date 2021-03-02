package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class bj extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "setScreenOrientation";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        int i2 = 1;
        AppMethodBeat.i(78628);
        Log.i("MicroMsg.JsApiSetScreenOrientation", "invoke");
        String optString = aVar.ctb.csi.optString("orientation");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiSetScreenOrientation", "data is null");
            aVar.c("invalid_data", null);
            AppMethodBeat.o(78628);
            return;
        }
        if (optString.equals(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL)) {
            i2 = 0;
        } else if (!optString.equals("vertical")) {
            if (optString.equals("sensor")) {
                i2 = 4;
            } else if (optString.equals("horizontal_unforced")) {
                i2 = 0;
            } else if (!optString.equals("vertical_unforced")) {
                i2 = -1;
            }
        }
        CONTEXT context = aVar.cta;
        context.mParams.putInt("screen_orientation", i2);
        context.gbz();
        aVar.c("", null);
        AppMethodBeat.o(78628);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
