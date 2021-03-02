package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public final class bp extends d<s> {
    public static final int CTRL_INDEX = 102;
    public static final String NAME = "makePhoneCall";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(139844);
        final s sVar2 = sVar;
        String optString = jSONObject.optString("phoneNumber");
        if (Util.isNullOrNil(optString)) {
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(139844);
            return;
        }
        Activity ay = sVar2.ay(Activity.class);
        if (ay == null) {
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(139844);
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse(WebView.SCHEME_TEL + Uri.encode(optString)));
            f.aK(ay).a(intent, new f.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.bp.AnonymousClass1 */

                @Override // com.tencent.luggage.h.f.b
                public final void a(int i2, Intent intent) {
                    AppMethodBeat.i(139843);
                    sVar2.i(i2, bp.this.h("ok", null));
                    AppMethodBeat.o(139843);
                }
            });
            AppMethodBeat.o(139844);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiMakePhoneCall", "startActivity failed");
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(139844);
        }
    }
}
