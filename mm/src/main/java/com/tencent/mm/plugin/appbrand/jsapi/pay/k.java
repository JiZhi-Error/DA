package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class k extends d<com.tencent.mm.plugin.appbrand.jsapi.k> {
    public static final int CTRL_INDEX = 682;
    public static final String NAME = "requestH5Transaction";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46727);
        final com.tencent.mm.plugin.appbrand.jsapi.k kVar2 = kVar;
        Log.i("MicroMsg.JsApiRequestH5Transaction", "invoke JsApiRequestH5Transaction!");
        if (kVar2 == null) {
            Log.e("MicroMsg.JsApiRequestH5Transaction", "fail:component is null");
            AppMethodBeat.o(46727);
            return;
        }
        Context context = kVar2.getContext();
        if (context == null) {
            Log.e("MicroMsg.JsApiRequestH5Transaction", "fail:context is null");
            kVar2.i(i2, h("fail", null));
            AppMethodBeat.o(46727);
            return;
        }
        String optString = jSONObject.optString("closeWebAfterPayDetailBack");
        Log.i("MicroMsg.JsApiRequestH5Transaction", "close window: %s", optString);
        if (Util.isEqual("1", optString)) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.k.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(46726);
                    kVar2.getRuntime().finish();
                    AppMethodBeat.o(46726);
                }
            }, 1000);
        }
        Intent intent = new Intent();
        intent.putExtra("appId", kVar2.getAppId());
        intent.putExtra("timeStamp", jSONObject.optString("timeStamp"));
        intent.putExtra("nonceStr", jSONObject.optString("nonceStr"));
        intent.putExtra("packageExt", jSONObject.optString("package"));
        intent.putExtra("signtype", jSONObject.optString("signType"));
        intent.putExtra("paySignature", jSONObject.optString("paySign"));
        intent.putExtra("url", jSONObject.optString("url"));
        Log.i("MicroMsg.WalletManager", "startIbgOrder context %s from %s", context, Util.getStack());
        c.c(context, "wallet_core", ".ui.ibg.WalletIbgOrderInfoUI", intent);
        kVar2.i(i2, h("ok", null));
        AppMethodBeat.o(46727);
    }
}
