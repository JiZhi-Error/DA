package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.plugin.webview.ui.tools.game.d;
import com.tencent.mm.plugin.webview.ui.tools.game.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class ae extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "reportGameWeb";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<i>.a aVar) {
        AppMethodBeat.i(83089);
        TreeMap treeMap = new TreeMap(new Comparator<Integer>() {
            /* class com.tencent.mm.plugin.game.luggage.b.ae.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Integer num, Integer num2) {
                AppMethodBeat.i(83088);
                int compareTo = num.compareTo(num2);
                AppMethodBeat.o(83088);
                return compareTo;
            }
        });
        JSONObject jSONObject = aVar.ctb.csi;
        String optString = jSONObject.optString("type");
        boolean equals = "1".equals(jSONObject.optString("isReportNow"));
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            Log.i("MicroMsg.JsApiReportGameWeb", "data is null or not json");
            aVar.c("data_is_null", null);
            AppMethodBeat.o(83089);
        } else if ("1".equals(optString)) {
            Log.i("MicroMsg.JsApiReportGameWeb", "report web performance, url:%s", aVar.cta.coX());
            treeMap.put(Integer.valueOf(d.b.Jqx), Boolean.valueOf(equals));
            Map<Integer, Object> cc = f.cc(optJSONObject);
            for (Integer num : cc.keySet()) {
                if (!treeMap.containsKey(num)) {
                    treeMap.put(num, cc.get(num));
                }
            }
            f.P(aVar.cta.dTQ(), treeMap);
            aVar.c("", null);
            AppMethodBeat.o(83089);
        } else if ("2".equals(optString)) {
            treeMap.putAll(aVar.cta.dTR());
            Map<Integer, Object> cc2 = f.cc(optJSONObject);
            for (Integer num2 : cc2.keySet()) {
                if (!treeMap.containsKey(num2)) {
                    treeMap.put(num2, cc2.get(num2));
                }
            }
            String bP = d.bP(treeMap);
            Log.i("MicroMsg.JsApiReportGameWeb", "report web runtime. isReportNow:%b, reportData: [%s]", Boolean.valueOf(equals), bP);
            h.INSTANCE.a(16145, bP, equals, false);
            aVar.c("", null);
            AppMethodBeat.o(83089);
        } else {
            Log.i("MicroMsg.JsApiReportGameWeb", "type is error. type:%s", optString);
            aVar.c("type_not_right", null);
            AppMethodBeat.o(83089);
        }
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
