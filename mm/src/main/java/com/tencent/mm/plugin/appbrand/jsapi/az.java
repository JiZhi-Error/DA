package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class az extends d<s> {
    public static final int CTRL_INDEX = 286;
    public static final String NAME = "chooseInvoiceTitle";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45470);
        final s sVar2 = sVar;
        Intent intent = new Intent();
        intent.putExtra("req_scene", 0);
        intent.putExtra("launch_from_appbrand", true);
        Activity ay = sVar2.ay(Activity.class);
        if (ay == null) {
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(45470);
            return;
        }
        f.aK(ay).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.az.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174752);
                if (i2 != (az.this.hashCode() & 65535)) {
                    AppMethodBeat.o(174752);
                    return false;
                } else if (i3 == -1 && intent != null) {
                    HashMap hashMap = new HashMap();
                    String nullAs = Util.nullAs(intent.getStringExtra("choose_invoice_title_info"), "");
                    Log.i("MicroMsg.JsApiChooseInvoiceTitle", "choose_invoice_title_info is : ".concat(String.valueOf(nullAs)));
                    hashMap.put("invoiceTitleInfo", nullAs);
                    sVar2.i(i2, az.this.n("ok", hashMap));
                    AppMethodBeat.o(174752);
                    return true;
                } else if (i3 == 0) {
                    sVar2.i(i2, az.this.h("cancel", null));
                    AppMethodBeat.o(174752);
                    return true;
                } else {
                    sVar2.i(i2, az.this.h("fail", null));
                    AppMethodBeat.o(174752);
                    return true;
                }
            }
        });
        c.a((Context) ay, "address", ".ui.InvoiceListUI", intent, hashCode() & 65535, false);
        AppMethodBeat.o(45470);
    }
}
