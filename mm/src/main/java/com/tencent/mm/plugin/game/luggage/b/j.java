package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.api.DownloadWidgetTaskInfo;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j extends br {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        AppMethodBeat.i(83064);
        LinkedList<DownloadWidgetTaskInfo> cBR = ((c) g.af(c.class)).cBR();
        if (Util.isNullOrNil(cBR)) {
            aVar.i(null, null);
            AppMethodBeat.o(83064);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<DownloadWidgetTaskInfo> it = cBR.iterator();
        while (it.hasNext()) {
            DownloadWidgetTaskInfo next = it.next();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("appid", next.appId);
                jSONObject2.put("status", next.pJC);
                jSONObject2.put("download_id", next.dCa);
                jSONObject2.put("progress", next.progress);
                jSONObject2.put("progress_float", (double) next.lCT);
                if (next.qJh) {
                    jSONObject2.put("reserve_for_wifi", 1);
                }
            } catch (JSONException e2) {
            }
            jSONArray.put(jSONObject2);
        }
        try {
            jSONObject.put("result", jSONArray.toString());
        } catch (JSONException e3) {
        }
        aVar.i(null, jSONObject);
        AppMethodBeat.o(83064);
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "getDownloadWidgetTaskInfos";
    }
}
