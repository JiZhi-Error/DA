package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class g extends d<c> {
    public static final int CTRL_INDEX = 714;
    public static final String NAME = "requestBizSplitBillPayment";
    private final int mml = a.aK(this);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(174868);
        final c cVar2 = cVar;
        Log.i("MicroMsg.Aa.JsApiRequestBizSplitBillPayment", "invoke JsApiRequestBizSplitBillPayment!");
        if (cVar2 == null) {
            Log.e("MicroMsg.Aa.JsApiRequestBizSplitBillPayment", "fail:component is null");
            AppMethodBeat.o(174868);
            return;
        }
        Activity ay = cVar2.ay(Activity.class);
        if (ay == null) {
            Log.e("MicroMsg.Aa.JsApiRequestBizSplitBillPayment", "fail:context is null");
            cVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(174868);
            return;
        }
        String optString = jSONObject.optString("orderNo");
        Log.i("MicroMsg.Aa.JsApiRequestBizSplitBillPayment", "pfOrderNo:%s", Util.nullAs(optString, ""));
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.Aa.JsApiRequestBizSplitBillPayment", "fail:context is null");
            cVar2.i(i2, h("fail", null));
            AppMethodBeat.o(174868);
            return;
        }
        f.aK(ay).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.g.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174866);
                Log.i("MicroMsg.Aa.JsApiRequestBizSplitBillPayment", "mmOnActivityResult, resultCode = ".concat(String.valueOf(i3)));
                if (i3 == -1) {
                    if (intent == null || !intent.getBooleanExtra("cancel", false)) {
                        cVar2.i(i2, g.this.h("ok", null));
                    } else {
                        cVar2.i(i2, g.this.h("cancel", null));
                    }
                    AppMethodBeat.o(174866);
                    return true;
                }
                cVar2.i(i2, g.this.h("fail", null));
                AppMethodBeat.o(174866);
                return false;
            }
        });
        Intent intent = new Intent();
        intent.putExtra("pfOrderNo", optString);
        intent.putExtra("appid", cVar2.getAppId());
        com.tencent.mm.br.c.c(ay, ".plugin.aa.ui.LaunchAABeforeUI", intent, this.mml);
        AppMethodBeat.o(174868);
    }

    public g() {
        AppMethodBeat.i(174867);
        AppMethodBeat.o(174867);
    }
}
