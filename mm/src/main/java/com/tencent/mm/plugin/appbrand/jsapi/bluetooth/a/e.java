package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiGetBLEDeviceRSSI;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class e extends d<f> {
    public static final int CTRL_INDEX = 777;
    public static final String NAME = "getBLEDeviceRSSI";
    public static final a lKQ = new a((byte) 0);

    static {
        AppMethodBeat.i(175635);
        AppMethodBeat.o(175635);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiGetBLEDeviceRSSI$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_DEVICE_ID", "RESULT_ERROR_CODE", "RESULT_RSSI", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(175634);
        if (fVar == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "env is null", new Object[0]);
            AppMethodBeat.o(175634);
        } else if (jSONObject == null || !jSONObject.has("deviceId")) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "data is null or do not have key: deviceId", new Object[0]);
            fVar.i(i2, n("fail:invalid data", ae.f(s.U("errCode", 10013))));
            AppMethodBeat.o(175634);
        } else {
            String appId = fVar.getAppId();
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "appId: " + appId + ", data: " + jSONObject, new Object[0]);
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b ZC = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ZC(appId);
            if (ZC == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "bleWorker is null", new Object[0]);
                fVar.i(i2, n("fail:not init", ae.f(s.U("errCode", 10000))));
                AppMethodBeat.o(175634);
                return;
            }
            String optString = jSONObject.optString("deviceId");
            if (optString == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "deviceId is null", new Object[0]);
                fVar.i(i2, n("fail:invalid data", ae.f(s.U("errCode", 10013))));
                AppMethodBeat.o(175634);
                return;
            }
            ZC.a(optString, new c(), new b(this, appId, i2, fVar));
            AppMethodBeat.o(175634);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "kotlin.jvm.PlatformType", "onResult"})
    static final class b implements com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b {
        final /* synthetic */ String kPQ;
        final /* synthetic */ e lKR;
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;

        b(e eVar, String str, int i2, f fVar) {
            this.lKR = eVar;
            this.kPQ = str;
            this.lyo = i2;
            this.lyn = fVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
        public final void a(j jVar) {
            AppMethodBeat.i(175633);
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "appId: " + this.kPQ + ", result: " + jVar, new Object[0]);
            switch (jVar.errCode) {
                case 0:
                    Object obj = jVar.lNO;
                    if (!(obj instanceof Integer)) {
                        obj = null;
                    }
                    Integer num = (Integer) obj;
                    if (num == null) {
                        e eVar = this.lKR;
                        int i2 = this.lyo;
                        f fVar = this.lyn;
                        int i3 = j.lNv.errCode;
                        String str = j.lNv.errMsg;
                        p.g(str, "Result.FAIL.errMsg");
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(eVar, i2, fVar, i3, str);
                        AppMethodBeat.o(175633);
                        return;
                    }
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.lKR, this.lyo, this.lyn, ae.g(s.U("RSSI", num)));
                    AppMethodBeat.o(175633);
                    return;
                default:
                    e eVar2 = this.lKR;
                    int i4 = this.lyo;
                    f fVar2 = this.lyn;
                    int i5 = jVar.errCode;
                    String str2 = jVar.errMsg;
                    p.g(str2, "result.errMsg");
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(eVar2, i4, fVar2, i5, str2);
                    AppMethodBeat.o(175633);
                    return;
            }
        }
    }
}
