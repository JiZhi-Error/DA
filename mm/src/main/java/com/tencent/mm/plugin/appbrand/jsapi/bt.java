package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import org.json.JSONObject;

public class bt extends d<k> {
    public static final int CTRL_INDEX = 62;
    public static final String NAME = "openAddress";
    private final int lAS = a.aK(this);

    public bt() {
        AppMethodBeat.i(174754);
        AppMethodBeat.o(174754);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45572);
        final k kVar2 = kVar;
        Intent intent = new Intent();
        a(intent, kVar2, jSONObject);
        intent.putExtra("req_app_id", kVar2.getAppId());
        intent.putExtra("launch_from_appbrand", true);
        AppBrandInitConfig OU = kVar2.getRuntime().OU();
        if ((OU instanceof AppBrandInitConfigWC) && ((AppBrandInitConfigWC) OU).kHL.isEnable()) {
            intent.putExtra("content_view_height", ((AppBrandInitConfigWC) OU).kHL.height);
            intent.putExtra("click_empty_close", ((AppBrandInitConfigWC) OU).kHL.lfo);
        }
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            Log.e("MicroMsg.JsApiOpenAddress", "invoke appId:%s, callbackId:%d, context == null", kVar2.getAppId(), Integer.valueOf(i2));
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(45572);
            return;
        }
        f.aK(castActivityOrNull).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bt.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174753);
                if (i2 != (bt.this.hashCode() & 65535)) {
                    AppMethodBeat.o(174753);
                    return false;
                }
                if (i3 == -1 && intent != null) {
                    String nullAs = Util.nullAs(intent.getStringExtra("nationalCode"), "");
                    String nullAs2 = Util.nullAs(intent.getStringExtra("userName"), "");
                    String nullAs3 = Util.nullAs(intent.getStringExtra("telNumber"), "");
                    String nullAs4 = Util.nullAs(intent.getStringExtra("addressPostalCode"), "");
                    String nullAs5 = Util.nullAs(intent.getStringExtra("proviceFirstStageName"), "");
                    String nullAs6 = Util.nullAs(intent.getStringExtra("addressCitySecondStageName"), "");
                    String nullAs7 = Util.nullAs(intent.getStringExtra("addressCountiesThirdStageName"), "");
                    String nullAs8 = Util.nullAs(intent.getStringExtra("addressDetailInfo"), "");
                    Log.i("MicroMsg.JsApiOpenAddress", "first =  " + nullAs5 + " ; detail =" + nullAs8 + "; second = " + nullAs6 + " ; tel = " + nullAs3 + "; third = " + nullAs7);
                    if (!Util.isNullOrNil(nullAs2)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("nationalCode", nullAs);
                        hashMap.put("userName", nullAs2);
                        hashMap.put("telNumber", nullAs3);
                        hashMap.put("addressPostalCode", nullAs4);
                        hashMap.put("proviceFirstStageName", nullAs5);
                        hashMap.put("addressCitySecondStageName", nullAs6);
                        hashMap.put("addressCountiesThirdStageName", nullAs7);
                        hashMap.put("addressDetailInfo", nullAs8);
                        kVar2.i(i2, bt.this.n("ok", hashMap));
                        AppMethodBeat.o(174753);
                        return true;
                    }
                }
                if (i3 == 0) {
                    kVar2.i(i2, bt.this.h("cancel", null));
                    AppMethodBeat.o(174753);
                    return true;
                }
                kVar2.i(i2, bt.this.h("fail", null));
                AppMethodBeat.o(174753);
                return true;
            }
        });
        c.a((Context) castActivityOrNull, "address", ".ui.WalletSelectAddrUI", intent, this.lAS, false);
        AppMethodBeat.o(45572);
    }

    /* access modifiers changed from: protected */
    public void a(Intent intent, k kVar, JSONObject jSONObject) {
    }
}
