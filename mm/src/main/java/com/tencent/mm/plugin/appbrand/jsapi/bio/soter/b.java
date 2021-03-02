package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends d {
    public static final int CTRL_INDEX = 277;
    public static final String NAME = "startSoterAuthentication";
    private Class<?> lKz;
    private int scene;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(159051);
        Log.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
        Activity activity = (Activity) fVar.getContext();
        if (activity == null) {
            Log.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", fVar.getAppId());
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(159051);
        } else if (this.lKz == null) {
            Log.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "JsApiStartSoterAuthentication ui is null!");
            fVar.i(i2, h("fail:JsApiStartSoterAuthentication UI is null!", null));
            AppMethodBeat.o(159051);
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray("requestAuthModes");
            String optString = jSONObject.optString("challenge");
            String optString2 = jSONObject.optString("authContent");
            Intent intent = new Intent(activity, this.lKz);
            intent.putExtra("auth_mode", d.o(optJSONArray));
            intent.putExtra("challenge", optString);
            intent.putExtra("auth_content", optString2);
            intent.putExtra("key_soter_fp_luggage_fromscene", 1);
            try {
                this.scene = jSONObject.getInt("scene");
                intent.putExtra("key_soter_fp_luggage_scene", this.scene);
            } catch (JSONException e2) {
                Log.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter authentication scene null");
            }
            intent.putExtra("Soter_Result_Receiver", new JsApiLuggageStartSoterAuthentication$1(this, new Handler(Looper.getMainLooper()), fVar, i2));
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/bio/soter/JsApiLuggageStartSoterAuthentication", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/appbrand/jsapi/bio/soter/JsApiLuggageStartSoterAuthentication", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(159051);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.bio.soter.b r16, com.tencent.mm.plugin.appbrand.jsapi.f r17, int r18, android.os.Bundle r19, java.lang.String r20) {
        /*
        // Method dump skipped, instructions count: 364
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.b.a(com.tencent.mm.plugin.appbrand.jsapi.bio.soter.b, com.tencent.mm.plugin.appbrand.jsapi.f, int, android.os.Bundle, java.lang.String):void");
    }
}
