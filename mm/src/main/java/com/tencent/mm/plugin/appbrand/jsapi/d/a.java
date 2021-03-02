package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.sns.waid.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/device/JsApiGetDeviceInfo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a extends d<f> {
    public static final int CTRL_INDEX = 867;
    public static final String NAME = "getDeviceInfo";
    public static final C0658a lTK = new C0658a((byte) 0);

    static {
        AppMethodBeat.i(228394);
        AppMethodBeat.o(228394);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/device/JsApiGetDeviceInfo$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d.a$a  reason: collision with other inner class name */
    public static final class C0658a {
        private C0658a() {
        }

        public /* synthetic */ C0658a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        com.tencent.mm.plugin.appbrand.s.a aVar;
        AppMethodBeat.i(228393);
        String aoK = com.tencent.mm.plugin.sns.ad.b.a.aoK();
        String eWE = com.tencent.mm.plugin.sns.ad.b.a.eWE();
        String str = "";
        if (jSONObject != null) {
            String optString = jSONObject.optString("waidPkg");
            str = b.aRy(optString);
            p.g(str, "WaidHelper.getAppWaid(waidPkg)");
            Log.i("MicroMsg.AppBrand.JsApiGetDeviceInfo", "waidPkg=".concat(String.valueOf(optString)));
        }
        String eWC = com.tencent.mm.plugin.sns.ad.b.a.eWC();
        String str2 = (fVar == null || (aVar = (com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class)) == null) ? null : aVar.nhM;
        Log.i("MicroMsg.AppBrand.JsApiGetDeviceInfo", "getDeviceInfo, oaid:" + aoK + ", imei:" + eWE + ", waid:" + str, "ua:".concat(String.valueOf(str2)));
        if (aoK != null || eWE != null || str != null || eWC != null || str2 != null) {
            Map<String, ? extends Object> e2 = ae.e(s.U("oaid", aoK), s.U("imei", eWE), s.U("waid", str), s.U("devIdInfo", eWC), s.U("ua", str2));
            if (fVar != null) {
                fVar.i(i2, n("ok", e2));
                AppMethodBeat.o(228393);
                return;
            }
            AppMethodBeat.o(228393);
        } else if (fVar != null) {
            fVar.i(i2, Zf("fail"));
            AppMethodBeat.o(228393);
        } else {
            AppMethodBeat.o(228393);
        }
    }
}
