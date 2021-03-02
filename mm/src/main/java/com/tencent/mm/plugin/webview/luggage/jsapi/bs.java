package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.d.b;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.f.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class bs<T extends g> extends br<T> {
    @Override // com.tencent.luggage.d.b, com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(b<T>.a aVar) {
        String str;
        String str2;
        JSONObject jSONObject = aVar.ctb.csi;
        String url = aVar.cta.getUrl();
        c gbF = aVar.cta.gbF();
        if (gbF != null) {
            str = gbF.aZj(url);
        } else {
            str = null;
        }
        if (Util.isNullOrNil(str)) {
            str2 = url;
        } else {
            str2 = str;
        }
        GameWebPerformanceInfo Fd = GameWebPerformanceInfo.Fd(aVar.cta.coX());
        if (Fd != null) {
            Fd.hhB = 1;
        }
        try {
            jSONObject.put("currentUrl", url);
            jSONObject.put("shareUrl", str2);
            if (aVar.cta.ITw != null) {
                jSONObject.put("preVerifyAppId", aVar.cta.ITw.getAppId());
            }
            if (getClass().getName().equals(bb.class.getName())) {
                jSONObject.put("sendAppMessageScene", bb.gcm());
                bb.gcn();
            }
        } catch (JSONException e2) {
        }
        super.a(aVar);
    }
}
