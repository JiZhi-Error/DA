package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public final class ch extends d<k> {
    public static final int CTRL_INDEX = 617;
    public static final String NAME = "openWCPayLQTSave";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45588);
        final k kVar2 = kVar;
        final Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            Log.e("MicroMsg.JsApiOpenWCPayLQTSave", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(45588);
            return;
        }
        f.aK(castActivityOrNull).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ch.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174766);
                Log.d("MicroMsg.JsApiOpenWCPayLQTSave", "activity result: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
                if (i2 == (ch.this.hashCode() & 65535)) {
                    if (i3 == -1) {
                        c.b(castActivityOrNull, "wallet", ".balance.ui.lqt.WalletLqtBeforeSaveUI", new Intent(), ch.this.hashCode() & 65534);
                        kVar2.i(i2, ch.this.h("ok", null));
                    } else {
                        kVar2.i(i2, ch.this.h("fail", null));
                        if (!e.gsQ()) {
                            h.INSTANCE.a(14954, e.gsR(), "JsApiOpenWCPayLQTSave:fail");
                        }
                    }
                    if (!e.gsQ()) {
                        e.gsS();
                    }
                    AppMethodBeat.o(174766);
                    return true;
                } else if (i2 != (ch.this.hashCode() & 65534)) {
                    Log.d("MicroMsg.JsApiOpenWCPayLQTSave", "beforeSave callback");
                    if (i3 == -1) {
                        kVar2.i(i2, ch.this.h("ok", null));
                    } else {
                        kVar2.i(i2, ch.this.h("fail", null));
                    }
                    AppMethodBeat.o(174766);
                    return true;
                } else {
                    AppMethodBeat.o(174766);
                    return false;
                }
            }
        });
        AppBrandSysConfigWC TR = a.TR(kVar2.getAppId());
        if (TR == null) {
            kVar2.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiOpenWCPayLQTSave", "sysConfig is null, invoke fail!");
            AppMethodBeat.o(45588);
            return;
        }
        q TQ = a.TQ(kVar2.getAppId());
        if (TQ == null) {
            kVar2.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiOpenWCPayLQTSave", "runtime is null, invoke fail!");
            AppMethodBeat.o(45588);
            return;
        }
        Log.d("MicroMsg.JsApiOpenWCPayLQTSave", "do openWCPayLQTDepositPlan");
        String currentUrl = TQ.brh().getCurrentUrl();
        Intent intent = new Intent();
        intent.putExtra("appId", kVar2.getAppId());
        intent.putExtra("timeStamp", jSONObject.optString("timeStamp"));
        intent.putExtra("nonceStr", jSONObject.optString("nonceStr"));
        intent.putExtra("packageExt", jSONObject.optString("package"));
        intent.putExtra("signtype", jSONObject.optString("signType"));
        intent.putExtra("paySignature", jSONObject.optString("paySign"));
        intent.putExtra("pay_channel", jSONObject.optString("pay_channel"));
        intent.putExtra("wxapp_username", TR.brandName);
        intent.putExtra("jsapi_scene", 20);
        intent.putExtra("command_word", NAME);
        intent.putExtra("wxapp_path", currentUrl);
        intent.putExtra("source_type", 2);
        c.b(castActivityOrNull, "wallet", ".ui.WalletJsApiAdapterUI", intent, hashCode() & 65535);
        AppMethodBeat.o(45588);
    }
}
