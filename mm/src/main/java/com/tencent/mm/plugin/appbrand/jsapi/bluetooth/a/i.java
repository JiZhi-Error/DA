package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p.z;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class i extends d {
    private static final int CTRL_INDEX = 179;
    private static final String NAME = "getConnectedBluetoothDevices";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        ArrayList arrayList;
        AppMethodBeat.i(144502);
        c.pl(191);
        Log.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "getConnectedBluetoothDevices!");
        Log.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "appId:%s getConnectedBluetoothDevices data %s", fVar.getAppId(), jSONObject.toString());
        b ZC = a.ZC(fVar.getAppId());
        if (ZC == null) {
            Log.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bleWorker is null, may not open ble");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10000);
            fVar.i(i2, n("fail:not init", hashMap));
            c.dY(193, 195);
            AppMethodBeat.o(144502);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE()) {
            Log.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "adapter is null or not enabled!");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10001);
            fVar.i(i2, n("fail:not available", hashMap2));
            c.dY(193, 197);
            AppMethodBeat.o(144502);
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray("services");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                arrayList = new ArrayList(length);
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = optJSONArray.optString(i3);
                    if (optString != null) {
                        arrayList.add(optString);
                    }
                }
            } else {
                arrayList = null;
            }
            boolean optBoolean = jSONObject.optBoolean("useOldImpl", false);
            Log.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "useOldImpl: ".concat(String.valueOf(optBoolean)));
            List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> b2 = ZC.b(arrayList, optBoolean);
            if (b2 == null) {
                Log.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetoothDevices is empty!");
                fVar.i(i2, h("fail:internal error", null));
                c.dY(193, z.CTRL_INDEX);
                AppMethodBeat.o(144502);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d dVar : b2) {
                String str = dVar.dGL;
                String str2 = dVar.name;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("deviceId", str);
                    jSONObject2.put("name", str2);
                    jSONArray.put(jSONObject2);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "put JSON data error : %s", e2);
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("errMsg", getName() + ":ok");
                jSONObject3.put("devices", jSONArray);
            } catch (JSONException e3) {
                Log.printErrStackTrace("MicroMsg.JsApiGetConnectedBluetoothDevices", e3, "", new Object[0]);
            }
            Log.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "retJson %s", jSONObject3.toString());
            fVar.i(i2, jSONObject3.toString());
            c.pl(192);
            AppMethodBeat.o(144502);
        }
    }
}
