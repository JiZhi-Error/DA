package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.a.b;
import kotlin.x;
import org.json.JSONObject;

public final class c extends d<com.tencent.mm.plugin.appbrand.service.c> {
    public static final int CTRL_INDEX = 693;
    public static final String NAME = "getWCPayOverseaPrepayRequest";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46714);
        final com.tencent.mm.plugin.appbrand.service.c cVar2 = cVar;
        Log.i("MicroMsg.JsApiGetWCPayOverseaPrepayRequest", "invoke JsApiGetWCPayOverseaPrepayRequest!");
        if (cVar2 == null) {
            Log.e("MicroMsg.JsApiGetWCPayOverseaPrepayRequest", "fail:component is null");
            AppMethodBeat.o(46714);
            return;
        }
        final Activity ay = cVar2.ay(Activity.class);
        if (ay == null) {
            Log.e("MicroMsg.JsApiGetWCPayOverseaPrepayRequest", "fail:context is null");
            cVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(46714);
            return;
        }
        final WalletJsapiData walletJsapiData = new WalletJsapiData(jSONObject);
        walletJsapiData.KxH = 2;
        final AnonymousClass1 r2 = new MMActivity.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.c.AnonymousClass1 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(46713);
                Log.i("MicroMsg.JsApiGetWCPayOverseaPrepayRequest", "mmOnActivityResult, resultCode = ".concat(String.valueOf(i3)));
                if (i3 == -1) {
                    if (intent != null && intent.hasExtra("url")) {
                        Intent intent2 = new Intent();
                        if (intent.hasExtra("view_port_code")) {
                            intent2.putExtra("view_port_code", intent.getStringExtra("view_port_code"));
                        }
                        try {
                            intent2.putExtra("rawUrl", intent.getStringExtra("url"));
                            com.tencent.mm.br.c.b(ay, "webview", ".ui.tools.WebViewUI", intent2);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.JsApiGetWCPayOverseaPrepayRequest", "loadUrl ex: %s", e2.getMessage());
                        }
                    }
                    cVar2.i(i2, c.this.h("ok", null));
                    AppMethodBeat.o(46713);
                    return;
                }
                cVar2.i(i2, c.this.h("cancel", null));
                AppMethodBeat.o(46713);
            }
        };
        if (!AppBrandJsApiPayUtils.a(ay, new b<MMActivity, x>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.c.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(MMActivity mMActivity) {
                AppMethodBeat.i(174865);
                f.a(mMActivity, walletJsapiData, 1, r2);
                x xVar = x.SXb;
                AppMethodBeat.o(174865);
                return xVar;
            }
        })) {
            cVar2.i(i2, h("fail", null));
        }
        AppMethodBeat.o(46714);
    }
}
