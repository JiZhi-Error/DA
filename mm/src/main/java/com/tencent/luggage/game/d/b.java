package com.tencent.luggage.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class b extends d<s> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "logInJava";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(177431);
        try {
            int i3 = jSONObject.getInt("level");
            String string = jSONObject.getString("logs");
            switch (i3) {
                case 0:
                    Log.d("MicroMsg.JsApiLogInJava", string);
                    AppMethodBeat.o(177431);
                    return;
                case 1:
                    Log.i("MicroMsg.JsApiLogInJava", string);
                    AppMethodBeat.o(177431);
                    return;
                case 2:
                    Log.w("MicroMsg.JsApiLogInJava", string);
                    AppMethodBeat.o(177431);
                    return;
                case 3:
                    Log.e("MicroMsg.JsApiLogInJava", string);
                    AppMethodBeat.o(177431);
                    return;
                default:
                    Log.d("MicroMsg.JsApiLogInJava", string);
                    AppMethodBeat.o(177431);
                    return;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiLogInJava", e2.toString());
            AppMethodBeat.o(177431);
        }
    }
}
