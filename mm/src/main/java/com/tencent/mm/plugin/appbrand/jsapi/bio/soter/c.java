package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends d<k> {
    public static final int CTRL_INDEX = 277;
    public static final String NAME = "startSoterAuthentication";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(106590);
        final k kVar2 = kVar;
        Log.i("MicroMsg.JsApiStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            Log.e("MicroMsg.JsApiStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", kVar2.getAppId());
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(106590);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("requestAuthModes");
        String optString = jSONObject.optString("challenge");
        String optString2 = jSONObject.optString("authContent");
        Intent intent = new Intent(castActivityOrNull, SoterAuthenticationUIWC.class);
        intent.putExtra("auth_mode", a.o(optJSONArray));
        intent.putExtra("challenge", optString);
        intent.putExtra("auth_content", optString2);
        intent.putExtra("key_soter_fp_mp_scene", 0);
        f.aK(castActivityOrNull).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bio.soter.c.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                Bundle bundle = null;
                AppMethodBeat.i(175255);
                if (i2 == 1000) {
                    if (i3 == -1) {
                        Log.i("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth ok");
                        c cVar = c.this;
                        k kVar = kVar2;
                        int i4 = i2;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        c.a(cVar, kVar, i4, bundle, "ok");
                    } else if (i3 == 1) {
                        Log.w("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth failed");
                        c cVar2 = c.this;
                        k kVar2 = kVar2;
                        int i5 = i2;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        c.a(cVar2, kVar2, i5, bundle, "fail");
                    } else {
                        Log.e("MicroMsg.JsApiStartSoterAuthentication", "hy: soter user cancelled");
                        c cVar3 = c.this;
                        k kVar3 = kVar2;
                        int i6 = i2;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        c.a(cVar3, kVar3, i6, bundle, "cancel");
                    }
                    AppMethodBeat.o(175255);
                    return true;
                }
                AppMethodBeat.o(175255);
                return false;
            }
        });
        castActivityOrNull.startActivityForResult(intent, 1000);
        AppMethodBeat.o(106590);
    }

    static /* synthetic */ void a(c cVar, com.tencent.mm.plugin.appbrand.jsapi.f fVar, int i2, Bundle bundle, String str) {
        byte b2;
        AppMethodBeat.i(106591);
        int i3 = -1;
        String str2 = "not returned";
        String str3 = "";
        String str4 = "";
        if (bundle != null) {
            i3 = bundle.getInt("err_code");
            str2 = bundle.getString("err_msg");
            str3 = bundle.getString("result_json");
            str4 = bundle.getString("result_json_signature");
            b2 = bundle.getByte("use_mode");
        } else {
            b2 = 0;
        }
        JSONArray wO = a.wO(b2);
        String str5 = "";
        if (wO.length() > 0) {
            try {
                str5 = wO.getString(0);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.JsApiStartSoterAuthentication", e2, "hy: json error in callback", new Object[0]);
            }
        }
        HashMap hashMap = new HashMap(5);
        hashMap.put("authMode", str5);
        hashMap.put("errCode", Integer.valueOf(i3));
        hashMap.put("resultJSON", str3);
        hashMap.put("resultJSONSignature", str4);
        if ("fail".equals(str)) {
            str = str + " " + str2;
        }
        fVar.i(i2, cVar.n(str, hashMap));
        AppMethodBeat.o(106591);
    }
}
