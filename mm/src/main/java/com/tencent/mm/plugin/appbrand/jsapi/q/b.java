package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kn;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.o;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/perf/JsApiNoticePerformanceMetrics;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class b extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "noticePerformanceMetrics";
    @Deprecated
    public static final a mmC = new a((byte) 0);

    static {
        AppMethodBeat.i(228447);
        AppMethodBeat.o(228447);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/perf/JsApiNoticePerformanceMetrics$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2) {
        JSONArray optJSONArray;
        AppMethodBeat.i(228446);
        com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        if (dVar2 == null) {
            AppMethodBeat.o(228446);
        } else if (!o.bVk()) {
            dVar2.i(i2, Zf("ok"));
            AppMethodBeat.o(228446);
        } else if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("events")) == null) {
            dVar2.i(i2, Zf("fail:invalid data"));
            AppMethodBeat.o(228446);
        } else {
            try {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    kn knVar = new kn();
                    String appId = dVar2.getAppId();
                    if (appId == null) {
                        p.hyc();
                    }
                    QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(appId);
                    if (aeU == null) {
                        p.hyc();
                    }
                    knVar.xS(aeU.kEY);
                    String appId2 = dVar2.getAppId();
                    if (appId2 == null) {
                        p.hyc();
                    }
                    knVar.xT(appId2);
                    knVar.tK(optJSONObject.optLong("timeStamp"));
                    knVar.xU(optJSONObject.optString("eventName"));
                    knVar.tL(optJSONObject.optLong("eventType"));
                    knVar.xV(optJSONObject.optString("parent"));
                    knVar.tM(optJSONObject.optLong("category"));
                    knVar.tN(optJSONObject.optLong("option"));
                    o.a(knVar);
                }
                dVar2.i(i2, Zf("ok"));
                AppMethodBeat.o(228446);
            } catch (Exception e2) {
                dVar2.i(i2, Zf("fail ".concat(String.valueOf(e2))));
                AppMethodBeat.o(228446);
            }
        }
    }
}
