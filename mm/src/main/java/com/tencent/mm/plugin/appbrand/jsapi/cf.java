package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public final class cf extends d<k> {
    public static final int CTRL_INDEX = 619;
    public static final String NAME = "openWCPayLQTDepositPlanAdd";
    final int lBa = a.aK(this);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45584);
        final k kVar2 = kVar;
        final Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            Log.e("MicroMsg.JsApiOpenWCPayLQTDepositPlanAdd", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(45584);
            return;
        }
        f.aK(castActivityOrNull).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.cf.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174762);
                if (i2 != cf.this.lBa) {
                    AppMethodBeat.o(174762);
                    return false;
                }
                if (i3 == -1) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_mode", 1);
                    c.b(castActivityOrNull, "wallet", ".balance.ui.lqt.WalletLqtPlanAddUI", intent2);
                    kVar2.i(i2, cf.this.h("ok", null));
                } else {
                    kVar2.i(i2, cf.this.h("fail", null));
                    if (!e.gsQ()) {
                        h.INSTANCE.a(14954, e.gsR(), "openWCPayLQTDepositPlanAdd:fail");
                    }
                }
                if (!e.gsQ()) {
                    e.gsS();
                }
                AppMethodBeat.o(174762);
                return true;
            }
        });
        AppBrandSysConfigWC TR = com.tencent.mm.plugin.appbrand.a.TR(kVar2.getAppId());
        if (TR == null) {
            kVar2.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiOpenWCPayLQTDepositPlanAdd", "sysConfig is null, invoke fail!");
            AppMethodBeat.o(45584);
            return;
        }
        q TQ = com.tencent.mm.plugin.appbrand.a.TQ(kVar2.getAppId());
        if (TQ == null) {
            kVar2.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiOpenWCPayLQTDepositPlanAdd", "runtime is null, invoke fail!");
            AppMethodBeat.o(45584);
            return;
        }
        Log.d("MicroMsg.JsApiOpenWCPayLQTDepositPlanAdd", "do openWCPayLQTDepositPlan");
        String currentUrl = TQ.brh().getCurrentUrl();
        String optString = jSONObject.optString("routeURL");
        Bundle bundle = new Bundle();
        bundle.putString("appId", kVar2.getAppId());
        bundle.putString("timeStamp", jSONObject.optString("timeStamp"));
        bundle.putString("nonceStr", jSONObject.optString("nonceStr"));
        bundle.putString("packageExt", jSONObject.optString("package"));
        bundle.putString("signtype", jSONObject.optString("signType"));
        bundle.putString("paySignature", jSONObject.optString("paySign"));
        bundle.putString("pay_channel", jSONObject.optString("pay_channel"));
        bundle.putString("routeURL", optString);
        bundle.putString("wxapp_username", TR.brandName);
        bundle.putInt("jsapi_scene", 22);
        bundle.putString("command_word", NAME);
        bundle.putString("wxapp_path", currentUrl);
        bundle.putInt("source_type", 2);
        if (TextUtils.isEmpty(optString)) {
            c.b(castActivityOrNull, "wallet", ".ui.WalletJsApiAdapterUI", new Intent().putExtras(bundle), this.lBa);
            AppMethodBeat.o(45584);
        } else if ("LQTFixedDepositAddPlan".equals(optString)) {
            ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startLqtFixedDepositMakePlanUseCase(castActivityOrNull, bundle);
            kVar2.i(i2, h("ok", null));
            AppMethodBeat.o(45584);
        } else {
            kVar2.i(i2, h("fail:auth denied", null));
            Log.e("MicroMsg.JsApiOpenWCPayLQTDepositPlanAdd", "routURL auth failed!");
            AppMethodBeat.o(45584);
        }
    }

    public cf() {
        AppMethodBeat.i(174763);
        AppMethodBeat.o(174763);
    }
}
