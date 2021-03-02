package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cu extends d<d> {
    public static final int CTRL_INDEX = 215;
    public static final String NAME = "updatePerfData";
    private static final SparseArray<Integer> lCm;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147146);
        d dVar2 = dVar;
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (!AppBrandPerformanceManager.e((com.tencent.luggage.sdk.d.d) dVar2.getRuntime()) || optJSONArray == null) {
            dVar2.i(i2, h("fail", null));
            AppMethodBeat.o(147146);
            return;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("key");
                String optString2 = optJSONObject.optString("value");
                if (!Util.isNullOrNil(optString)) {
                    Integer num = lCm.get(optString.hashCode());
                    if (num != null) {
                        AppBrandPerformanceManager.a((com.tencent.luggage.sdk.d.d) dVar2.getRuntime(), num.intValue(), optString2);
                    } else {
                        AppBrandPerformanceManager.a((com.tencent.luggage.sdk.d.d) dVar2.getRuntime(), optString, optString2);
                    }
                }
            }
        }
        dVar2.i(i2, h("ok", null));
        AppMethodBeat.o(147146);
    }

    static {
        AppMethodBeat.i(147147);
        SparseArray<Integer> sparseArray = new SparseArray<>();
        lCm = sparseArray;
        sparseArray.put("firstRenderTime".hashCode(), 301);
        lCm.put("reRenderTime".hashCode(), 302);
        lCm.put("webview2AppServiceTotalTime".hashCode(), 402);
        lCm.put("webview2AppServiceDataSize".hashCode(), 403);
        lCm.put("webview2AppServiceNativeTime".hashCode(), 404);
        lCm.put("appService2WebviewTotalTime".hashCode(), 405);
        lCm.put("appService2WebviewDataSize".hashCode(), 406);
        lCm.put("appService2WebviewNativeTime".hashCode(), 407);
        AppMethodBeat.o(147147);
    }
}
