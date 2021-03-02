package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class ay extends d<s> {
    public static final int CTRL_INDEX = 501;
    public static final String NAME = "chooseInvoice";
    final int lzi = a.aK(this);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45468);
        final s sVar2 = sVar;
        if (jSONObject == null) {
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(45468);
            return;
        }
        Activity ay = sVar2.ay(Activity.class);
        if (ay == null) {
            sVar2.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiChooseInvoice", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(45468);
            return;
        }
        int optInt = jSONObject.optInt("timeStamp");
        String optString = jSONObject.optString("nonceStr");
        String optString2 = jSONObject.optString("signType");
        String optString3 = jSONObject.optString("cardSign");
        Intent intent = new Intent();
        intent.putExtra("app_id", sVar2.getAppId());
        intent.putExtra("sign_type", optString2);
        intent.putExtra("card_sign", optString3);
        intent.putExtra("time_stamp", optInt);
        intent.putExtra("nonce_str", optString);
        intent.putExtra("can_multi_select", 1);
        intent.putExtra("card_type", "INVOICE");
        intent.putExtra("key_from_scene", 7);
        f.aK(ay).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ay.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174750);
                if (ay.this.lzi != i2) {
                    Log.e("MicroMsg.JsApiChooseInvoice", "onActivityResult mismatch requestCode, with appId:%s, callbackId:%d", sVar2.getAppId(), Integer.valueOf(i2));
                    sVar2.i(i2, ay.this.h("fail:internal error", null));
                    AppMethodBeat.o(174750);
                    return false;
                }
                Log.d("MicroMsg.JsApiChooseInvoice", "request choose invoice, resultCode = ".concat(String.valueOf(i3)));
                HashMap hashMap = new HashMap();
                if (i3 == -1) {
                    if (intent != null) {
                        hashMap.put("invoiceInfo", Util.nullAs(intent.getStringExtra("choose_invoice_info"), ""));
                    }
                    sVar2.i(i2, ay.this.n("ok", hashMap));
                    Log.i("MicroMsg.JsApiChooseInvoice", "callback ok values = ".concat(String.valueOf(hashMap)));
                } else if (i3 == 0) {
                    sVar2.i(i2, ay.this.h("cancel", null));
                    Log.i("MicroMsg.JsApiChooseInvoice", "callback cancel");
                } else {
                    sVar2.i(i2, ay.this.h("fail", null));
                    Log.i("MicroMsg.JsApiChooseInvoice", "callback fail");
                }
                AppMethodBeat.o(174750);
                return true;
            }
        });
        c.a((Context) ay, "card", ".ui.CardListSelectedUI", intent, this.lzi, false);
        AppMethodBeat.o(45468);
    }

    public ay() {
        AppMethodBeat.i(174751);
        AppMethodBeat.o(174751);
    }
}
