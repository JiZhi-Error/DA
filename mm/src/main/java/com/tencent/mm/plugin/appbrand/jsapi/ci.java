package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class ci extends d<d> {
    public static final int CTRL_INDEX = 430;
    public static final String NAME = "pageNotFoundCallback";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147143);
        d dVar2 = dVar;
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiPageNotFoundCallback", "data is null, do nothing");
            dVar2.i(i2, h("fail", null));
            AppMethodBeat.o(147143);
            return;
        }
        Log.i("MicroMsg.JsApiPageNotFoundCallback", "pageNotFoundCallback data:%s", jSONObject);
        boolean optBoolean = jSONObject.optBoolean("hasHandler", false);
        int optInt = jSONObject.optInt("webviewId", -1);
        final c Oq = dVar2.Oq();
        if (optBoolean) {
            if (Oq != null) {
                Oq.bU(true);
                if (Oq.getComponentId() != optInt) {
                    Log.e("MicroMsg.JsApiPageNotFoundCallback", "appBrandPageView.getComponentId():%d, webviewId:%d, err", Integer.valueOf(Oq.getComponentId()), Integer.valueOf(optInt));
                }
            } else {
                Log.e("MicroMsg.JsApiPageNotFoundCallback", "appBrandPageView is null");
            }
            Log.i("MicroMsg.JsApiPageNotFoundCallback", "already handler, ignore");
            dVar2.i(i2, h("ok", null));
            AppMethodBeat.o(147143);
            return;
        }
        if (Oq != null && Oq.getComponentId() == optInt) {
            Oq.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ci.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(147142);
                    Oq.bU(true);
                    Oq.NS();
                    AppMethodBeat.o(147142);
                }
            });
        }
        Log.e("MicroMsg.JsApiPageNotFoundCallback", "currentPageView is null, return");
        dVar2.i(i2, h("ok", null));
        AppMethodBeat.o(147143);
    }
}
