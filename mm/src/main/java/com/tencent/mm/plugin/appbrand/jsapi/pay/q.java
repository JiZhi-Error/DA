package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public final class q extends d<s> {
    public static final int CTRL_INDEX = 285;
    public static final String NAME = "requestVirtualPayment";
    boolean mmw = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46741);
        final s sVar2 = sVar;
        if (jSONObject == null) {
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(46741);
            return;
        }
        Activity ay = sVar2.ay(Activity.class);
        if (ay == null) {
            sVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(46741);
        } else if (this.mmw) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 2);
            Log.e("MicroMsg.JsApiRequestVirtualPayment", "errCode: %d, errMsg: an order is being paid", 2);
            sVar2.i(i2, n("fail an order is being paid", hashMap));
            AppMethodBeat.o(46741);
        } else {
            this.mmw = true;
            final AnonymousClass1 r2 = new MMActivity.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.q.AnonymousClass1 */

                @Override // com.tencent.mm.ui.MMActivity.a
                public final void d(int i2, int i3, Intent intent) {
                    int i4;
                    AppMethodBeat.i(46740);
                    if (i2 != (q.this.hashCode() & 65535)) {
                        AppMethodBeat.o(46740);
                        return;
                    }
                    q.this.mmw = false;
                    if (intent != null) {
                        i4 = intent.getIntExtra("key_err_code", 1);
                    } else {
                        i4 = 1;
                    }
                    Log.i("MicroMsg.JsApiRequestVirtualPayment", "resultCode:%d,result:%d", Integer.valueOf(i3), Integer.valueOf(i4));
                    if (i3 != -1) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(i4));
                        sVar2.i(i2, q.this.n("cancel", hashMap));
                        AppMethodBeat.o(46740);
                    } else if (i4 == 0) {
                        Log.i("MicroMsg.JsApiRequestVirtualPayment", "requestIAP ok");
                        sVar2.i(i2, q.this.h("ok", null));
                        AppMethodBeat.o(46740);
                    } else {
                        HashMap hashMap2 = new HashMap();
                        String nullAsNil = Util.nullAsNil(intent.getStringExtra("key_err_msg"));
                        hashMap2.put("errCode", Integer.valueOf(i4));
                        Log.i("MicroMsg.JsApiRequestVirtualPayment", "requestVirtualPayment errCode: %d, errMsg: %s", Integer.valueOf(i4), nullAsNil);
                        sVar2.i(i2, q.this.n("fail ".concat(String.valueOf(nullAsNil)), hashMap2));
                        AppMethodBeat.o(46740);
                    }
                }
            };
            new Bundle().putInt("scene", 0);
            ac currentPageView = sVar2.getCurrentPageView();
            if (currentPageView != null) {
                com.tencent.luggage.game.page.d dVar = (com.tencent.luggage.game.page.d) currentPageView.S(com.tencent.luggage.game.page.d.class);
                if (dVar != null) {
                    dVar.MP();
                }
            } else {
                Log.e("MicroMsg.JsApiRequestVirtualPayment", "hy: associated page view is null!!");
            }
            Intent intent = new Intent();
            Log.i("MicroMsg.JsApiRequestVirtualPayment", "iap payment start ... data : ".concat(String.valueOf(jSONObject)));
            intent.putExtra("key_appid", sVar2.getAppId());
            intent.putExtra("key_product_id", jSONObject.optString("priceLevel"));
            intent.putExtra("key_price", jSONObject.optString("priceLevel"));
            intent.putExtra("key_currency_type", jSONObject.optString("currencyType", "CNY"));
            intent.putExtra("key_desc", jSONObject.optString("desc"));
            intent.putExtra("key_count", jSONObject.optInt("count", 1));
            intent.putExtra("key_is_mini_program", true);
            intent.putExtra("key_busiid", jSONObject.optString("outTradeNo"));
            intent.putExtra("key_virtual_pay_sign", jSONObject.optString("virtualPaySign"));
            intent.putExtra("key_attach", jSONObject.optString("attach"));
            if (currentPageView != null && currentPageView.isFullScreen()) {
                intent.putExtra("key_request_fullscreen", true);
            }
            f.aK(ay).b(new f.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.q.AnonymousClass2 */

                @Override // com.tencent.luggage.h.f.c
                public final boolean c(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(174869);
                    r2.d(i2, i3, intent);
                    AppMethodBeat.o(174869);
                    return true;
                }
            });
            c.b(ay, "wallet_index", ".ui.WalletIapUI", intent, hashCode() & 65535);
            AppMethodBeat.o(46741);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }
}
