package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class f extends d {
    public static final int CTRL_INDEX = 680;
    public static final String NAME = "openWCPayOverseaPaymentReceive";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46721);
        Log.i("MicroMsg.JsApiOpenWCPayOverseaPaymentReceive", "invoke JsApiOpenWCPayOverseaPaymentReceive!");
        if (fVar == null) {
            Log.e("MicroMsg.JsApiOpenWCPayOverseaPaymentReceive", "fail:component is null");
            AppMethodBeat.o(46721);
            return;
        }
        Context context = fVar.getContext();
        if (context == null) {
            Log.e("MicroMsg.JsApiOpenWCPayOverseaPaymentReceive", "fail:context is null");
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(46721);
            return;
        }
        com.tencent.mm.pluginsdk.wallet.f.aD(context, 7);
        fVar.i(i2, h("ok", null));
        AppMethodBeat.o(46721);
    }
}
