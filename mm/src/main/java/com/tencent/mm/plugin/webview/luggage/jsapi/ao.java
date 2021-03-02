package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class ao extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "openWeApp";
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
        AppMethodBeat.i(78591);
        Log.i("MicroMsg.JsApiOpenWeApp", "invokeInMM");
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            aVar.i("fail_invalid_data", null);
            AppMethodBeat.o(78591);
            return;
        }
        String optString = Zc.optString("currentUrl");
        String optString2 = Zc.optString("preVerifyAppId");
        wq wqVar = new wq();
        wqVar.ecI.context = context;
        wqVar.ecI.userName = Zc.optString("userName");
        wqVar.ecI.appId = Zc.optString("appId");
        wqVar.ecI.ecK = Zc.optString("relativeURL");
        wqVar.ecI.appVersion = Zc.optInt("appVersion", 0);
        wqVar.ecI.scene = Zc.optInt("scene", 1018);
        wqVar.ecI.dCw = Zc.optString("sceneNote");
        if (Util.isNullOrNil(wqVar.ecI.dCw)) {
            wqVar.ecI.dCw = q.encode(Util.nullAsNil(optString));
        }
        wqVar.ecI.ecN = Zc.optString("downloadURL");
        wqVar.ecI.ecL = Zc.optInt("openType", 0);
        wqVar.ecI.ecO = Zc.optString("checkSumMd5");
        wqVar.ecI.ecQ = false;
        wqVar.ecI.ecR.iIt = Zc.optString("extJsonInfo");
        wqVar.ecI.ecW = optString2;
        if (Util.isNullOrNil(wqVar.ecI.ecW)) {
            wqVar.ecI.ecW = Zc.optString("sourceAppId");
        }
        wqVar.ecI.ecX = optString;
        wqVar.ecI.ecY = Zc.optString("privateExtraData");
        EventCenter.instance.publish(wqVar);
        if (wqVar.ecJ.edc) {
            aVar.i(null, null);
            AppMethodBeat.o(78591);
            return;
        }
        aVar.i(Util.nullAsNil(wqVar.ecJ.edd), null);
        AppMethodBeat.o(78591);
    }
}
