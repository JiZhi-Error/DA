package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class s extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "getBrandWCPayRequest";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<g>.a aVar) {
        AppMethodBeat.i(78553);
        Log.i("MicroMsg.JsApiGetBrandWCPayRequest", "invokeInOwn");
        MMActivity mMActivity = (MMActivity) aVar.cta.mContext;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", aVar.cta.getUrl());
            jSONObject.put("pay_scene", 3);
        } catch (JSONException e2) {
        }
        WalletJsapiData walletJsapiData = new WalletJsapiData(aVar.ctb.csi);
        walletJsapiData.KxH = 1;
        walletJsapiData.KxO = aVar.cta.mParams.getString(e.p.OzI);
        Log.i("MicroMsg.JsApiGetBrandWCPayRequest", "pay channel: %s, scene: %s, adUxInfo: %s", Integer.valueOf(walletJsapiData.payChannel), Integer.valueOf(walletJsapiData.dVv), walletJsapiData.KxO);
        if (!f.a(mMActivity, walletJsapiData, hashCode() & 65535, new MMActivity.a() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.s.AnonymousClass1 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(78552);
                if (i2 != (s.this.hashCode() & 65535)) {
                    AppMethodBeat.o(78552);
                } else if (i3 == -1) {
                    aVar.c("", null);
                    AppMethodBeat.o(78552);
                } else if (i3 == 5) {
                    HashMap hashMap = new HashMap();
                    int intExtra = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                    String nullAsNil = Util.nullAsNil(intent.getStringExtra("key_jsapi_pay_err_msg"));
                    hashMap.put("err_code", Integer.valueOf(intExtra));
                    hashMap.put("err_desc", nullAsNil);
                    Log.e("MicroMsg.JsApiGetBrandWCPayRequest", "errCode: %d, errMsg: %s", Integer.valueOf(intExtra), nullAsNil);
                    aVar.e("fail", hashMap);
                    AppMethodBeat.o(78552);
                } else {
                    aVar.c("cancel", null);
                    AppMethodBeat.o(78552);
                }
            }
        })) {
            aVar.c("fail", null);
        }
        AppMethodBeat.o(78553);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
