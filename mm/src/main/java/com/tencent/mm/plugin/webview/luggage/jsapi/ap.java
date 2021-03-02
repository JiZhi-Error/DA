package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.net.Uri;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class ap extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "openWeAppPage";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78592);
        Log.i("MicroMsg.JsApiOpenWeAppPage", "invokeInOwn %s", aVar.ctb.csi);
        String optString = aVar.ctb.csi.optString("userName");
        String optString2 = aVar.ctb.csi.optString("relativeURL");
        if (optString2.contains("render_data")) {
            try {
                new StringBuilder();
                JSONObject jSONObject = new JSONObject(Uri.parse(optString2).getQueryParameter("widgetData"));
                jSONObject.remove("render_data");
                optString2 = optString2.replaceAll("(widgetData=.*&)|(widgetData=.*$)", "&") + "&widgetData=" + jSONObject.toString();
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.JsApiOpenWeAppPage", e2, "", new Object[0]);
            }
        }
        int optInt = aVar.ctb.csi.optInt("appVersion", 0);
        String optString3 = aVar.ctb.csi.optString("searchId");
        String optString4 = aVar.ctb.csi.optString("docId");
        int optInt2 = aVar.ctb.csi.optInt("position", 1);
        int optInt3 = aVar.ctb.csi.optInt("scene", 1000);
        String optString5 = aVar.ctb.csi.optString("privateExtraData");
        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
        if (optInt3 == 201 || optInt3 == 14 || optInt3 == 22) {
            gVar.scene = 1006;
        } else if (optInt3 == 3) {
            gVar.scene = 1005;
        } else if (optInt3 == 16) {
            gVar.scene = 1042;
        } else if (optInt3 == 20) {
            gVar.scene = 1053;
        } else {
            gVar.scene = 1000;
        }
        gVar.dCw = aVar.ctb.csi.optString("statSessionId") + ":" + aVar.ctb.csi.optString("statKeywordId") + ":" + optString3 + ":" + optString4 + ":" + optInt2 + ":" + aVar.ctb.csi.optString("subScene");
        gVar.kHF = new AppBrandLaunchReferrer();
        gVar.kHF.lep = optString5;
        gVar.username = optString;
        gVar.version = optInt;
        gVar.kHw = optString2;
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(aVar.cta.mContext, gVar);
        aVar.c("", null);
        AppMethodBeat.o(78592);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
