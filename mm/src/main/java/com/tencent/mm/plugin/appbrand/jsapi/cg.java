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

public final class cg extends d<k> {
    public static final int CTRL_INDEX = 616;
    public static final String NAME = "openWCPayLQTDetail";
    final int lBa = a.aK(this);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45586);
        final k kVar2 = kVar;
        final Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            Log.e("MicroMsg.JsApiOpenWCPayLQTDetail", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(45586);
            return;
        }
        final int optInt = jSONObject.optInt("auto_jump_charge_setting");
        final int optInt2 = jSONObject.optInt("show_open_toast");
        f.aK(castActivityOrNull).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.cg.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174764);
                if (i2 != cg.this.lBa) {
                    AppMethodBeat.o(174764);
                    return false;
                }
                if (i3 == -1) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_account_type", 1);
                    if (optInt == 1) {
                        intent2.putExtra("show_open_toast", optInt2);
                        c.b(castActivityOrNull, "wallet", ".balance.ui.lqt.WalletLqtBalanceAutoTransferUI", intent2);
                    } else {
                        c.V(castActivityOrNull, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    }
                    kVar2.i(i2, cg.this.h("ok", null));
                } else {
                    kVar2.i(i2, cg.this.h("fail", null));
                    if (!e.gsQ()) {
                        h.INSTANCE.a(14954, e.gsR(), "JsApiOpenWCPayLQTDetail:fail");
                    }
                }
                if (!e.gsQ()) {
                    e.gsS();
                }
                AppMethodBeat.o(174764);
                return true;
            }
        });
        AppBrandSysConfigWC TR = com.tencent.mm.plugin.appbrand.a.TR(kVar2.getAppId());
        if (TR == null) {
            kVar2.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiOpenWCPayLQTDetail", "sysConfig is null, invoke fail!");
            AppMethodBeat.o(45586);
            return;
        }
        q TQ = com.tencent.mm.plugin.appbrand.a.TQ(kVar2.getAppId());
        if (TQ == null) {
            kVar2.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiOpenWCPayLQTDetail", "runtime is null, invoke fail!");
            AppMethodBeat.o(45586);
            return;
        }
        Log.d("MicroMsg.JsApiOpenWCPayLQTDetail", "do openWCPayLQTDepositPlan");
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
        intent.putExtra("jsapi_scene", 19);
        intent.putExtra("command_word", NAME);
        intent.putExtra("wxapp_path", currentUrl);
        intent.putExtra("source_type", 2);
        c.b(castActivityOrNull, "wallet", ".ui.WalletJsApiAdapterUI", intent, this.lBa);
        AppMethodBeat.o(45586);
    }

    public cg() {
        AppMethodBeat.i(174765);
        AppMethodBeat.o(174765);
    }
}
