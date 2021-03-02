package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a&\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e\u001a.\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010\u001a6\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"TAG", "", "dispatchEvent", "", "event", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "data", "Lorg/json/JSONObject;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "jOnBLEPeripheralConnectionStateChanged", "deviceID", "serverID", "connected", "", "jOnCharacteristicReadRequest", "", "serviceUUID", "characteristicUUID", "callbackId", "jOnCharacteristicWriteRequest", "base64Value", "luggage-commons-jsapi-connectivity-ext_release"})
public final class a {
    public static final void a(f fVar, String str, String str2, boolean z) {
        AppMethodBeat.i(144734);
        p.h(fVar, "component");
        p.h(str, "deviceID");
        p.h(str2, "serverID");
        Log.i("MicroMsg.BLE.BlePeripheralPublishEventFuns", "jOnBLEPeripheralConnectionStateChanged: connected = " + z + ", deviceID = " + str + ", serverID = " + str2);
        try {
            j jVar = new j();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("deviceId", str);
            jSONObject.put("serverId", str2);
            jSONObject.put("connected", z);
            a(jVar, jSONObject, fVar);
            AppMethodBeat.o(144734);
        } catch (JSONException e2) {
            Log.e("MicroMsg.BLE.BlePeripheralPublishEventFuns", "BlePeripheralPublishEventFuns fail", e2);
            AppMethodBeat.o(144734);
        }
    }

    public static final boolean a(f fVar, int i2, String str, String str2, int i3, String str3) {
        boolean z;
        AppMethodBeat.i(144735);
        p.h(fVar, "component");
        p.h(str, "serviceUUID");
        p.h(str2, "characteristicUUID");
        p.h(str3, "base64Value");
        Log.i("MicroMsg.BLE.BlePeripheralPublishEventFuns", "jOnCharacteristicWriteRequest: serverID = " + i2 + ", serviceUUID = " + str + ',' + " characteristicUUID = " + str2 + ", callbackId = " + i3);
        try {
            l lVar = new l();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("serverId", i2);
            jSONObject.put("serviceId", str);
            jSONObject.put("characteristicId", str2);
            jSONObject.put("callbackId", i3);
            jSONObject.put("value", str3);
            a(lVar, jSONObject, fVar);
            z = true;
        } catch (JSONException e2) {
            Log.e("MicroMsg.BLE.BlePeripheralPublishEventFuns", "BlePeripheralPublishEventFuns fail", e2);
            z = false;
        }
        AppMethodBeat.o(144735);
        return z;
    }

    public static final boolean a(f fVar, int i2, String str, String str2, int i3) {
        boolean z;
        AppMethodBeat.i(144736);
        p.h(fVar, "component");
        p.h(str, "serviceUUID");
        p.h(str2, "characteristicUUID");
        Log.i("MicroMsg.BLE.BlePeripheralPublishEventFuns", "jOnCharacteristicReadRequest: serverID = " + i2 + ", serviceUUID = " + str + ",\" +\n        \" characteristicUUID = " + str2 + ", callbackId = " + i3);
        try {
            k kVar = new k();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("serverId", i2);
            jSONObject.put("serviceId", str);
            jSONObject.put("characteristicId", str2);
            jSONObject.put("callbackId", i3);
            a(kVar, jSONObject, fVar);
            z = true;
        } catch (JSONException e2) {
            Log.e("MicroMsg.BLE.BlePeripheralPublishEventFuns", "OnCharacteristicReadRequest: fail", e2);
            z = false;
        }
        AppMethodBeat.o(144736);
        return z;
    }

    private static final void a(bc bcVar, JSONObject jSONObject, f fVar) {
        AppMethodBeat.i(144737);
        bcVar.Zh(jSONObject.toString());
        bcVar.h(fVar);
        bcVar.bEo();
        AppMethodBeat.o(144737);
    }
}
