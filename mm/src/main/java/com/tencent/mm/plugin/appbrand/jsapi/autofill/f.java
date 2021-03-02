package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends d<ac> {
    public static final int CTRL_INDEX = 402;
    public static final String NAME = "openRealnameAuth";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(ac acVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46111);
        final ac acVar2 = acVar;
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiOpenRealnameAuth", "getIDCardInfo data is null");
            acVar2.i(i2, h("fail:data is null", null));
            AppMethodBeat.o(46111);
            return;
        }
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(acVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            acVar2.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiOpenRealnameAuth", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(46111);
            return;
        }
        String optString = jSONObject.optString("categoryId", "");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiOpenRealnameAuth", "category_id is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 40003);
            acVar2.i(i2, n("fail:category_id is empty", hashMap));
            AppMethodBeat.o(46111);
            return;
        }
        String appId = acVar2.getAppId();
        int optInt = jSONObject.optInt("authType", 1);
        Log.i("MicroMsg.JsApiOpenRealnameAuth", "getIDCardInfo category_id:%s, appId:%s, authType:%d", optString, appId, Integer.valueOf(optInt));
        Intent intent = new Intent(castActivityOrNull, AppBrandIDCardUI.class);
        intent.putExtra("intent_appid", appId);
        intent.putExtra("intent_category_id", optString);
        intent.putExtra("intent_auth_type", optInt);
        intent.putExtra("id_ui_theme", 1);
        com.tencent.luggage.h.f.aK(castActivityOrNull).a(intent, new f.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.f.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.b
            public final void a(int i2, Intent intent) {
                AppMethodBeat.i(174778);
                Log.i("MicroMsg.JsApiOpenRealnameAuth", "mmOnActivityResult resultCode:%d", Integer.valueOf(i2));
                HashMap hashMap = new HashMap();
                if (i2 == -1) {
                    Log.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth ok");
                    String stringExtra = intent.getStringExtra("intent_auth_token");
                    if (!Util.isNullOrNil(stringExtra)) {
                        hashMap.put("errCode", 0);
                        hashMap.put("auth_token", stringExtra);
                        acVar2.i(i2, f.this.n("ok", hashMap));
                        Log.d("MicroMsg.JsApiOpenRealnameAuth", "authToken:%s", stringExtra);
                        AppMethodBeat.o(174778);
                        return;
                    }
                    acVar2.i(i2, f.this.n("fail", hashMap));
                    AppMethodBeat.o(174778);
                } else if (i2 == 0) {
                    Log.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth cancel");
                    acVar2.i(i2, f.this.h("cancel", null));
                    AppMethodBeat.o(174778);
                } else {
                    if (i2 == 1) {
                        Log.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth fail");
                        if (intent != null) {
                            int intExtra = intent.getIntExtra("intent_err_code", -1);
                            String stringExtra2 = intent.getStringExtra("intent_err_msg");
                            hashMap.put("errCode", Integer.valueOf(intExtra));
                            acVar2.i(i2, f.this.n("fail:" + Util.nullAsNil(stringExtra2), hashMap));
                            Log.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth errCode:%d, errMsg:%s", Integer.valueOf(intExtra), stringExtra2);
                            AppMethodBeat.o(174778);
                            return;
                        }
                        acVar2.i(i2, f.this.n("fail", hashMap));
                    }
                    AppMethodBeat.o(174778);
                }
            }
        });
        h.INSTANCE.a(14943, appId, 1, "");
        AppMethodBeat.o(46111);
    }
}
