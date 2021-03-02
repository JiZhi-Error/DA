package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class c extends d {
    private static final int CTRL_INDEX = 221;
    private static final String NAME = "startBeaconDiscovery";
    h.c lLT = null;
    private a.C0666a.AbstractC0667a lWm;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, int i2) {
        com.tencent.mm.vending.j.c Q;
        AppMethodBeat.i(144679);
        Log.i("MicroMsg.JsApiStartBeaconDiscovery", "startBeaconDiscovery data %s", jSONObject);
        UUID[] W = W(jSONObject);
        if (W == null || W.length <= 0) {
            Log.e("MicroMsg.JsApiStartBeaconDiscovery", "serviceUuids is empty");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 11006);
            fVar.i(i2, n("fail:invalid data", hashMap));
            AppMethodBeat.o(144679);
            return;
        }
        String appId = fVar.getAppId();
        a.C0666a ZM = a.ZM(fVar.getAppId());
        if (ZM == null) {
            Log.i("MicroMsg.JsApiStartBeaconDiscovery", "beaconWorker init");
            ZM = new a.C0666a();
            a.a(appId, ZM);
        }
        if (this.lWm == null) {
            Log.i("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconScanCallback init");
            this.lWm = new a.C0666a.AbstractC0667a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.g.c.AnonymousClass1 */
                b lWr = new b((byte) 0);
                a lWs = new a((byte) 0);

                {
                    AppMethodBeat.i(144675);
                    AppMethodBeat.o(144675);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.g.a.C0666a.AbstractC0667a
                public final void O(Map<String, JSONObject> map) {
                    AppMethodBeat.i(144676);
                    Log.d("MicroMsg.JsApiStartBeaconDiscovery", "found device ibeacon %s", map);
                    JSONArray jSONArray = new JSONArray();
                    for (JSONObject jSONObject : map.values()) {
                        if (jSONObject != null) {
                            jSONArray.put(jSONObject);
                        }
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("beacons", jSONArray);
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", e2);
                    }
                    this.lWr.b(fVar, fVar.getComponentId()).Zh(jSONObject2.toString()).bEo();
                    AppMethodBeat.o(144676);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.g.a.C0666a.AbstractC0667a
                public final void ho(boolean z) {
                    AppMethodBeat.i(144677);
                    Log.i("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", Boolean.valueOf(z));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("available", z);
                        jSONObject.put("discovering", false);
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", e2);
                    }
                    Log.d("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", jSONObject.toString());
                    this.lWs.b(fVar, fVar.getComponentId()).Zh(jSONObject.toString()).bEo();
                    AppMethodBeat.o(144677);
                }
            };
        }
        if (this.lLT == null) {
            Log.i("MicroMsg.JsApiStartBeaconDiscovery", "listener init");
            this.lLT = new h.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.g.c.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.h.c
                public final void onDestroy() {
                    AppMethodBeat.i(144678);
                    Log.i("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
                    h.b(fVar.getAppId(), this);
                    a.C0666a ZM = a.ZM(fVar.getAppId());
                    if (ZM != null) {
                        ZM.Qt();
                        a.remove(fVar.getAppId());
                    }
                    c.this.lLT = null;
                    AppMethodBeat.o(144678);
                }
            };
            h.a(fVar.getAppId(), this.lLT);
        }
        ZM.lWl = W;
        ZM.lWm = this.lWm;
        Log.i("MicroMsg.BeaconManager", "BeaconWorker:%d start", Integer.valueOf(ZM.hashCode()));
        if (ZM.isStart()) {
            Log.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already start", Integer.valueOf(ZM.hashCode()));
            Q = com.tencent.mm.vending.j.c.Q(11003, "fail:already start");
        } else if (com.tencent.mm.compatible.util.d.oE(18)) {
            Log.e("MicroMsg.BeaconManager", "API version is below 18!");
            Q = com.tencent.mm.vending.j.c.Q(11000, "fail:not support");
        } else if (ZM.lWj == null) {
            Log.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
            Q = com.tencent.mm.vending.j.c.Q(11001, "fail:bluetooth service is unavailable");
        } else if (!ZM.lWj.isEnabled()) {
            Log.e("MicroMsg.BeaconManager", "bluetoothAdapter is not enabled!");
            Q = com.tencent.mm.vending.j.c.Q(11001, "fail:bluetooth service is unavailable");
        } else if (ZM.lWj.isDiscovering()) {
            Log.e("MicroMsg.BeaconManager", "bluetoothAdapter is Discovering!");
            Q = com.tencent.mm.vending.j.c.Q(11003, "fail:already start");
        } else {
            ZM.lWk.clear();
            Log.i("MicroMsg.BeaconManager", "[BluetoothTrace] start scan");
            Log.printErrStackTrace("MicroMsg.BeaconManager", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
            boolean startLeScan = ZM.lWj.startLeScan(ZM.lWp);
            Log.i("MicroMsg.BeaconManager", "startLeScan:%b", Boolean.valueOf(startLeScan));
            if (!startLeScan) {
                Q = com.tencent.mm.vending.j.c.Q(11005, "fail:system error");
            } else {
                ZM.isStart = true;
                Q = com.tencent.mm.vending.j.c.Q(0, "");
            }
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("errCode", Q.get(0));
        fVar.i(i2, n(((Integer) Q.get(0)).intValue() == 0 ? "ok" : (String) Q.get(1), hashMap2));
        AppMethodBeat.o(144679);
    }

    private static UUID[] W(JSONObject jSONObject) {
        AppMethodBeat.i(144680);
        UUID[] uuidArr = null;
        if (jSONObject.has("uuids")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("uuids"));
                uuidArr = new UUID[jSONArray.length()];
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string = jSONArray.getString(i2);
                    Log.d("MicroMsg.JsApiStartBeaconDiscovery", "uuid %s", string);
                    uuidArr[i2] = UUID.fromString(string);
                }
            } catch (JSONException e2) {
                Log.e("MicroMsg.JsApiStartBeaconDiscovery", "get uuid error!");
            }
        }
        AppMethodBeat.o(144680);
        return uuidArr;
    }

    static class a extends bc {
        private static final int CTRL_INDEX = 225;
        private static final String NAME = "onBeaconServiceChanged";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    static class b extends bc {
        private static final int CTRL_INDEX = 224;
        private static final String NAME = "onBeaconUpdated";

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }
}
