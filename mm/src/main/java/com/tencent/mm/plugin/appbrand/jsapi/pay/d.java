package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zo;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d {
    public static final int CTRL_INDEX = 681;
    public static final String NAME = "handleWCPayOverseaWalletBuffer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46716);
        Log.i("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "invoke JsApiHandleWCPayOverseaWalletBuffer!");
        if (fVar == null) {
            Log.e("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "fail:component is null");
            AppMethodBeat.o(46716);
        } else if (fVar.getContext() == null) {
            Log.e("MicroMsg.JsApiHandleWCPayOverseaWalletBuffer", "fail:context is null");
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(46716);
        } else {
            final zo zoVar = new zo();
            zoVar.efF.action = jSONObject.optString(NativeProtocol.WEB_DIALOG_ACTION);
            zoVar.efF.buffer = jSONObject.optString("buffer");
            zoVar.efF.appId = jSONObject.optString("appId");
            zoVar.efF.efI = Util.getInt(jSONObject.optString("walletRegion"), 0);
            zoVar.efF.dmc = jSONObject.optString("timeStamp");
            zoVar.efF.nonceStr = jSONObject.optString("nonceStr");
            zoVar.efF.dQk = jSONObject.optString("paySign");
            zoVar.efF.signType = jSONObject.optString("signType");
            zoVar.efF.efH = jSONObject.optString("package");
            zoVar.efF.url = jSONObject.optString("url");
            zoVar.efG.efJ = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(46715);
                    if (zoVar.efG.retCode == 0) {
                        new HashMap().put("buffer", zoVar.efG.buffer);
                        fVar.i(i2, d.this.h("ok", null));
                        AppMethodBeat.o(46715);
                    } else if (zoVar.efG.retCode == -2) {
                        fVar.i(i2, d.this.h(BuildConfig.COMMAND, null));
                        AppMethodBeat.o(46715);
                    } else {
                        fVar.i(i2, d.this.h("fail", null));
                        AppMethodBeat.o(46715);
                    }
                }
            };
            EventCenter.instance.publish(zoVar);
            AppMethodBeat.o(46716);
        }
    }
}
