package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiRemoveBlePeripheralService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class f extends d<com.tencent.mm.plugin.appbrand.jsapi.f> {
    private static final int CTRL_INDEX = CTRL_INDEX;
    private static final String NAME = NAME;
    public static final a lLr = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiRemoveBlePeripheralService$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(144757);
        AppMethodBeat.o(144757);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(144756);
        p.h(fVar, "env");
        if (!c.bFE()) {
            b.a(this, i2, fVar, 10001, "fail:not available");
            Log.i("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke: Ble is not available");
            AppMethodBeat.o(144756);
        } else if (jSONObject == null || !jSONObject.has("serverId") || !jSONObject.has("serviceId")) {
            Log.e("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke data is invalid");
            b.a(this, i2, fVar, 10013, "fail:invalid data");
            AppMethodBeat.o(144756);
        } else {
            int optInt = jSONObject.optInt("serverId");
            o oVar = o.lLV;
            n wQ = o.wQ(optInt);
            if (wQ == null) {
                Log.i("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke: retrieve a null server");
                b.a(this, i2, fVar, 10020, "fail: no server");
                AppMethodBeat.o(144756);
                return;
            }
            try {
                UUID fromString = UUID.fromString(jSONObject.optString("serviceId"));
                p.g(fromString, "UUID.fromString(data.optString(PARAMS_SERVICE_ID))");
                BluetoothGattService service = wQ.bFi().getService(fromString);
                if (service == null) {
                    b.a(this, i2, fVar, ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL, "fail:no service");
                    AppMethodBeat.o(144756);
                } else if (wQ.bFi().removeService(service)) {
                    b.a(this, i2, fVar);
                    AppMethodBeat.o(144756);
                } else {
                    b.a(this, i2, fVar, 10008, "fail: remove #" + fromString + " service fail");
                    AppMethodBeat.o(144756);
                }
            } catch (Exception e2) {
                b.a(this, i2, fVar, 10013, "fail:invalid data");
                AppMethodBeat.o(144756);
            }
        }
    }
}
