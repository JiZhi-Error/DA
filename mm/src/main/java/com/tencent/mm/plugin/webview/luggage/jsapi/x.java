package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class x extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "getOpenDeviceId";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        AppMethodBeat.i(78559);
        Log.i("MicroMsg.JsApiGetOpenDeviceId", "invokeInMM");
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            Log.e("MicroMsg.JsApiGetOpenDeviceId", "data is null");
            aVar.i("fail", null);
            AppMethodBeat.o(78559);
            return;
        }
        String optString = Zc.optString("preVerifyAppId");
        String dr = q.dr(true);
        String aoG = q.aoG();
        if (Util.isNullOrNil(dr) || Util.isNullOrNil(aoG) || Util.isNullOrNil(optString)) {
            aVar.i("fail", null);
            AppMethodBeat.o(78559);
            return;
        }
        String mD5String = MD5Util.getMD5String(MD5Util.getMD5String(optString + dr));
        String mD5String2 = MD5Util.getMD5String(MD5Util.getMD5String(optString + aoG));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceid", mD5String);
            jSONObject.put("newDeviceId", mD5String2);
        } catch (JSONException e2) {
        }
        aVar.i(null, jSONObject);
        AppMethodBeat.o(78559);
    }
}
