package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.Arrays;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiMakeBluetoothPair;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class j extends d<f> {
    public static final int CTRL_INDEX = 815;
    public static final String NAME = "makeBluetoothPair";
    public static final a lKS = new a((byte) 0);

    static {
        AppMethodBeat.i(215123);
        AppMethodBeat.o(215123);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiMakeBluetoothPair$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_DEVICE_ID", "PARAM_FORCE_PAIR", "PARAM_PIN", "PARAM_TIMEOUT", "PARAM_USE_OLD_IMPL", "RESULT_ERROR_CODE", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        byte[] decode;
        String str;
        AppMethodBeat.i(215122);
        if (fVar == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "env is null", new Object[0]);
            AppMethodBeat.o(215122);
        } else if (jSONObject == null || !jSONObject.has("deviceId")) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "data is null or do not have key: deviceId", new Object[0]);
            fVar.i(i2, n("fail:invalid data", ae.f(s.U("errCode", 10013))));
            AppMethodBeat.o(215122);
        } else {
            String appId = fVar.getAppId();
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "appId: " + appId + ", data: " + jSONObject, new Object[0]);
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b ZC = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ZC(appId);
            if (ZC == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "bleWorker is null", new Object[0]);
                fVar.i(i2, n("fail:not init", ae.f(s.U("errCode", 10000))));
                AppMethodBeat.o(215122);
                return;
            }
            String optString = jSONObject.optString("deviceId", null);
            if (optString == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "deviceId is null", new Object[0]);
                fVar.i(i2, n("fail:invalid data", ae.f(s.U("errCode", 10013))));
                AppMethodBeat.o(215122);
                return;
            }
            String optString2 = jSONObject.optString("pin", null);
            if (optString2 == null) {
                decode = null;
            } else {
                try {
                    decode = Base64.decode(optString2, 2);
                } catch (Exception e2) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "decode pin fail since " + e2.toString(), new Object[0]);
                    fVar.i(i2, n("fail:invalid data", ae.f(s.U("errCode", 10013))));
                    AppMethodBeat.o(215122);
                    return;
                }
            }
            long optLong = jSONObject.optLong("timeout", 20000);
            boolean optBoolean = jSONObject.optBoolean("forcePair", false);
            boolean optBoolean2 = jSONObject.optBoolean("useOldImpl", false);
            StringBuilder append = new StringBuilder("deviceId: ").append(optString).append(", pin: ");
            if (decode != null) {
                str = Arrays.toString(decode);
                p.g(str, "java.util.Arrays.toString(this)");
            } else {
                str = null;
            }
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", append.append(str).append(", timeoutMs: ").append(optLong).append(", forcePair: ").append(optBoolean).append(", useOldImpl: ").append(optBoolean2).toString(), new Object[0]);
            ZC.a(optString, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f(optString, decode, optLong, optBoolean, optBoolean2), new b(this, appId, i2, fVar));
            AppMethodBeat.o(215122);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "kotlin.jvm.PlatformType", "onResult"})
    static final class b implements com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b {
        final /* synthetic */ String kPQ;
        final /* synthetic */ j lKT;
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;

        b(j jVar, String str, int i2, f fVar) {
            this.lKT = jVar;
            this.kPQ = str;
            this.lyo = i2;
            this.lyn = fVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
        public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j jVar) {
            AppMethodBeat.i(215121);
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "appId: " + this.kPQ + ", result: " + jVar, new Object[0]);
            switch (jVar.errCode) {
                case 0:
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.lKT, this.lyo, this.lyn);
                    AppMethodBeat.o(215121);
                    return;
                default:
                    j jVar2 = this.lKT;
                    int i2 = this.lyo;
                    f fVar = this.lyn;
                    int i3 = jVar.errCode;
                    String str = jVar.errMsg;
                    p.g(str, "result.errMsg");
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(jVar2, i2, fVar, i3, str);
                    AppMethodBeat.o(215121);
                    return;
            }
        }
    }
}
