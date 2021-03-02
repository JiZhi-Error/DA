package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import android.os.ParcelUuid;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.l;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class o extends d {
    private static final int CTRL_INDEX = 176;
    private static final String NAME = "startBluetoothDevicesDiscovery";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(144524);
        c.pl(11);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startBluetoothDevicesDiscovery data is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10013);
            fVar.i(i2, n("fail:invalid data", hashMap));
            c.dY(13, 14);
            AppMethodBeat.o(144524);
            return;
        }
        Log.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "appId:%s startBluetoothDevicesDiscovery data:%s", fVar.getAppId(), jSONObject);
        b ZC = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ZC(fVar.getAppId());
        if (ZC == null) {
            Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10000);
            fVar.i(i2, n("fail:not init", hashMap2));
            c.dY(13, 16);
            AppMethodBeat.o(144524);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE()) {
            Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", 10001);
            fVar.i(i2, n("fail:not available", hashMap3));
            c.dY(13, 18);
            AppMethodBeat.o(144524);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE()) {
            Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
            HashMap hashMap4 = new HashMap();
            hashMap4.put("errCode", 10001);
            fVar.i(i2, n("fail:not available", hashMap4));
            c.dY(13, 18);
            AppMethodBeat.o(144524);
        } else {
            boolean optBoolean = jSONObject.optBoolean("allowDuplicatesKey");
            int optInt = jSONObject.optInt("interval");
            String optString = jSONObject.optString("powerLevel", FirebaseAnalytics.b.MEDIUM);
            boolean optBoolean2 = jSONObject.optBoolean("customParsePacket", true);
            boolean optBoolean3 = jSONObject.optBoolean("refreshCache", true);
            ArrayList arrayList = null;
            if (jSONObject.has("services")) {
                arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("services"));
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        arrayList.add(new ScanFilterCompat.a().a(ParcelUuid.fromString(jSONArray.getString(i3).toUpperCase())).bFx());
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "get uuid error!");
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put("isDiscovering", Boolean.FALSE);
                    hashMap5.put("errCode", Integer.valueOf((int) ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL));
                    fVar.i(i2, n("fail:no service", hashMap5));
                    c.pl(13);
                    AppMethodBeat.o(144524);
                    return;
                }
            }
            a.C0651a aVar = new a.C0651a();
            aVar.gTn = optInt;
            aVar.lMd = optBoolean;
            aVar.lMm = optString;
            aVar.lMq = optBoolean2;
            aVar.lMo = optBoolean3;
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a bFn = aVar.bFn();
            if (ZC.bFg() != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleManager", "initBleConfig:%s", bFn);
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(bFn);
            }
            AnonymousClass1 r1 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.o.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
                public final void a(j jVar) {
                    AppMethodBeat.i(144518);
                    Log.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "[onScanResult]result:%s", jVar);
                    switch (jVar.errCode) {
                        case 0:
                            HashMap hashMap = new HashMap();
                            hashMap.put("errCode", 0);
                            hashMap.put("isDiscovering", Boolean.TRUE);
                            fVar.i(i2, o.this.n("ok", hashMap));
                            c.pl(12);
                            AppMethodBeat.o(144518);
                            return;
                        default:
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("errCode", Integer.valueOf(jVar.errCode));
                            hashMap2.put("isDiscovering", Boolean.FALSE);
                            fVar.i(i2, o.this.n(jVar.errMsg, hashMap2));
                            c.pl(13);
                            AppMethodBeat.o(144518);
                            return;
                    }
                }
            };
            AnonymousClass2 r3 = new i() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.o.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i
                public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d dVar) {
                    AppMethodBeat.i(144519);
                    a.a(fVar, dVar);
                    AppMethodBeat.o(144519);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i
                public final void bA(List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> list) {
                    AppMethodBeat.i(144520);
                    a.a(fVar, list);
                    AppMethodBeat.o(144520);
                }
            };
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bFg = ZC.bFg();
            if (bFg != null) {
                bFg.lMs.a(r1, arrayList, r3);
            }
            l.c.a(fVar, true, true);
            AppMethodBeat.o(144524);
        }
    }

    static class a extends bc {
        private static final int CTRL_INDEX = 190;
        private static final String NAME = "onBluetoothDeviceFound";
        private static JSONObject lKZ = new JSONObject();
        private static a lLh = new a();

        private a() {
        }

        static {
            AppMethodBeat.i(144523);
            AppMethodBeat.o(144523);
        }

        public static synchronized void a(f fVar, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d dVar) {
            synchronized (a.class) {
                AppMethodBeat.i(144521);
                if (fVar == null) {
                    Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
                    AppMethodBeat.o(144521);
                } else {
                    JSONArray jSONArray = new JSONArray();
                    try {
                        jSONArray.put(dVar.bEw());
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e2);
                    }
                    try {
                        lKZ.remove("devices");
                        lKZ.put("devices", jSONArray);
                    } catch (JSONException e3) {
                        Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e3);
                    }
                    if (fVar == null) {
                        Log.w("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "service is null, fail");
                        AppMethodBeat.o(144521);
                    } else {
                        lLh.b(fVar, fVar.getComponentId()).Zh(lKZ.toString()).bEo();
                        Log.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", lKZ.toString());
                        AppMethodBeat.o(144521);
                    }
                }
            }
        }

        public static synchronized void a(f fVar, List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> list) {
            synchronized (a.class) {
                AppMethodBeat.i(144522);
                if (fVar == null) {
                    Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
                    AppMethodBeat.o(144522);
                } else {
                    JSONArray jSONArray = new JSONArray();
                    for (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d dVar : list) {
                        try {
                            jSONArray.put(dVar.bEw());
                        } catch (JSONException e2) {
                            Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e2);
                        }
                    }
                    try {
                        lKZ.remove("devices");
                        lKZ.put("devices", jSONArray);
                    } catch (JSONException e3) {
                        Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e3);
                    }
                    if (fVar == null) {
                        Log.w("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "service is null, fail");
                        AppMethodBeat.o(144522);
                    } else {
                        lLh.b(fVar, fVar.getComponentId()).Zh(lKZ.toString()).bEo();
                        Log.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", lKZ.toString());
                        AppMethodBeat.o(144522);
                    }
                }
            }
        }
    }
}
