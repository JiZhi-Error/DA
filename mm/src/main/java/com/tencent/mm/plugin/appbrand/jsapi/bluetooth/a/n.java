package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiSetBLEMtu;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class n extends d<f> {
    private static final int CTRL_INDEX = 738;
    private static final String NAME = "setBLEMTU";
    public static final a lLd = new a((byte) 0);

    static {
        AppMethodBeat.i(144733);
        AppMethodBeat.o(144733);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiSetBLEMtu$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(144732);
        p.h(fVar, "service");
        if (jSONObject == null || !jSONObject.has("deviceId") || !jSONObject.has("mtu")) {
            Log.e("MicroMsg.JsApiSetBLEMtu", "createBLEConnection data is null, err");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10013);
            fVar.i(i2, n("fail:invalid data", hashMap));
            AppMethodBeat.o(144732);
            return;
        }
        String appId = fVar.getAppId();
        p.g(appId, "service.appId");
        Log.i("MicroMsg.JsApiSetBLEMtu", "appId:%s createBLEConnection data %s", appId, jSONObject.toString());
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b ZC = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ZC(fVar.getAppId());
        if (ZC == null) {
            Log.e("MicroMsg.JsApiSetBLEMtu", "bleWorker is null, may not open ble");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10000);
            fVar.i(i2, n("fail:not init", hashMap2));
            c.dY(27, 30);
            AppMethodBeat.o(144732);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.bFf()) {
            Log.e("MicroMsg.JsApiSetBLEMtu", "bleWorker is disable, may not open ble");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", 10001);
            fVar.i(i2, n("fail:not available", hashMap3));
            c.dY(27, 32);
            AppMethodBeat.o(144732);
        } else {
            String optString = jSONObject.optString("deviceId");
            ZC.a(optString, new h(Integer.valueOf(jSONObject.optInt("mtu")), optString), new b(this, appId, i2, fVar));
            AppMethodBeat.o(144732);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "kotlin.jvm.PlatformType", "onResult"})
    static final class b implements com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b {
        final /* synthetic */ String kPQ;
        final /* synthetic */ n lLe;
        final /* synthetic */ f lLf;
        final /* synthetic */ int lyo;

        b(n nVar, String str, int i2, f fVar) {
            this.lLe = nVar;
            this.kPQ = str;
            this.lyo = i2;
            this.lLf = fVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
        public final void a(j jVar) {
            AppMethodBeat.i(144731);
            Log.d("MicroMsg.JsApiSetBLEMtu", "invoke: appid %s setMtuSize result = %s", this.kPQ, jVar);
            switch (jVar.errCode) {
                case 0:
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.lLe, this.lyo, this.lLf);
                    AppMethodBeat.o(144731);
                    return;
                default:
                    n nVar = this.lLe;
                    int i2 = this.lyo;
                    f fVar = this.lLf;
                    int i3 = jVar.errCode;
                    String str = jVar.errMsg;
                    p.g(str, "result.errMsg");
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(nVar, i2, fVar, i3, str);
                    AppMethodBeat.o(144731);
                    return;
            }
        }
    }
}
