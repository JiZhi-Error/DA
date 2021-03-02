package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public final class ca extends d<k> {
    public static final int CTRL_INDEX = 403;
    public static final String NAME = "openOfflinePayView";
    final int lBa = a.aK(this);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45578);
        final k kVar2 = kVar;
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            Log.e("MicroMsg.JsApiOpenOfflinePayView", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(45578);
            return;
        }
        f.aK(castActivityOrNull).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ca.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174757);
                if (i2 != ca.this.lBa) {
                    AppMethodBeat.o(174757);
                    return false;
                }
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("key_callback");
                    Log.i("MicroMsg.JsApiOpenOfflinePayView", "callback: %s", stringExtra);
                    kVar2.i(i2, ca.this.h(stringExtra, null));
                    h.INSTANCE.a(14954, e.gsR(), "openOfflinePayView:ok");
                } else {
                    kVar2.i(i2, ca.this.h("fail", null));
                    if (!e.gsQ()) {
                        h.INSTANCE.a(14954, e.gsR(), "openOfflinePayView:fail");
                    }
                }
                if (!e.gsQ()) {
                    e.gsS();
                }
                AppMethodBeat.o(174757);
                return true;
            }
        });
        Log.d("MicroMsg.JsApiOpenOfflinePayView", "json: %s", jSONObject.toString());
        AppBrandSysConfigWC TR = com.tencent.mm.plugin.appbrand.a.TR(kVar2.getAppId());
        if (TR == null) {
            kVar2.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiOpenOfflinePayView", "sysConfig is null, invoke fail!");
            AppMethodBeat.o(45578);
            return;
        }
        q TQ = com.tencent.mm.plugin.appbrand.a.TQ(kVar2.getAppId());
        if (TQ == null) {
            kVar2.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiOpenOfflinePayView", "runtime is null, invoke fail!");
            AppMethodBeat.o(45578);
            return;
        }
        String currentUrl = TQ.brh().getCurrentUrl();
        Intent intent = new Intent();
        intent.putExtra("appId", kVar2.getAppId());
        intent.putExtra("timeStamp", jSONObject.optString("timeStamp"));
        intent.putExtra("nonceStr", jSONObject.optString("nonceStr"));
        intent.putExtra("packageExt", jSONObject.optString("package"));
        intent.putExtra("signtype", jSONObject.optString("signType"));
        intent.putExtra("paySignature", jSONObject.optString("paySign"));
        intent.putExtra("wxapp_username", TR.brandName);
        intent.putExtra("wxapp_path", currentUrl);
        int i3 = this.lBa;
        intent.putExtra("key_from_scene", 7);
        c.b(castActivityOrNull, "offline", ".ui.WalletOfflineEntranceUI", intent, i3);
        AppMethodBeat.o(45578);
    }

    public ca() {
        AppMethodBeat.i(174758);
        AppMethodBeat.o(174758);
    }
}
