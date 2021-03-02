package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.api.DownloadWidgetTaskInfo;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        AppMethodBeat.i(186904);
        LinkedList<DownloadWidgetTaskInfo> cBR = ((c) g.af(c.class)).cBR();
        if (Util.isNullOrNil(cBR)) {
            this.yEn.ecz();
            AppMethodBeat.o(186904);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<DownloadWidgetTaskInfo> it = cBR.iterator();
        while (it.hasNext()) {
            DownloadWidgetTaskInfo next = it.next();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("appid", next.appId);
                jSONObject3.put("status", next.pJC);
                jSONObject3.put("download_id", next.dCa);
                jSONObject3.put("progress", next.progress);
                jSONObject3.put("progress_float", (double) next.lCT);
                if (next.qJh) {
                    jSONObject3.put("reserve_for_wifi", 1);
                }
            } catch (JSONException e2) {
            }
            jSONArray.put(jSONObject3);
        }
        try {
            jSONObject2.put("result", jSONArray.toString());
        } catch (JSONException e3) {
        }
        this.yEn.aW(jSONObject2);
        AppMethodBeat.o(186904);
    }
}
