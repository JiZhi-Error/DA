package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cb extends d<c> {
    public static final int CTRL_INDEX = 192;
    public static final String NAME = "openSetting";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45580);
        final c cVar2 = cVar;
        if (cVar2.getRuntime().bsB() == null) {
            Log.e("MicroMsg.JsApiOpenSetting", "config is null!");
            cVar2.i(i2, h("fail:internal error", null));
            AppMethodBeat.o(45580);
            return;
        }
        Activity ay = cVar2.ay(Activity.class);
        if (ay == null) {
            cVar2.i(i2, h("fail:internal error invalid android context", null));
            Log.e("MicroMsg.JsApiOpenSetting", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(45580);
            return;
        }
        final boolean optBoolean = jSONObject.optBoolean("withSubscriptions", false);
        Intent putExtra = new Intent(cVar2.getContext(), AppBrandAuthorizeUI.class).putExtra("key_username", cVar2.getRuntime().bsC().username);
        putExtra.putExtra("key_app_authorize_jsapi", true);
        putExtra.setClass(ay, AppBrandAuthorizeUI.class);
        f.aK(ay).a(putExtra, new f.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.cb.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.b
            public final void a(int i2, Intent intent) {
                String str;
                JSONArray jSONArray;
                AppMethodBeat.i(174759);
                String str2 = "";
                if (intent != null) {
                    str2 = intent.getStringExtra("key_app_authorize_state");
                    str = intent.getStringExtra("key_app_subscriptions_setting");
                } else {
                    str = "";
                }
                try {
                    jSONArray = new JSONArray(str2);
                } catch (JSONException e2) {
                    jSONArray = new JSONArray();
                }
                JSONObject jSONObject = null;
                if (optBoolean) {
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (JSONException e3) {
                        jSONObject = new JSONObject();
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("errMsg", cb.this.getName() + ":ok");
                    jSONObject2.put("authSetting", jSONArray);
                    if (optBoolean) {
                        jSONObject2.put("subscriptionsSetting", jSONObject);
                    }
                } catch (JSONException e4) {
                    Log.e("MicroMsg.JsApiOpenSetting", "set json error!");
                    Log.printErrStackTrace("MicroMsg.JsApiOpenSetting", e4, "", new Object[0]);
                }
                cVar2.i(i2, jSONObject2.toString());
                AppMethodBeat.o(174759);
            }
        });
        AppMethodBeat.o(45580);
    }
}
