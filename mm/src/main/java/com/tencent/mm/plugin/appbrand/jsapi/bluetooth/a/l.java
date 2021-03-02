package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class l extends d {
    private static final int CTRL_INDEX = 173;
    private static final String NAME = "openBluetoothAdapter";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(144515);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(0);
        String appId = fVar.getAppId();
        Log.i("MicroMsg.JsApiOpenBluetoothAdapter", "appid:%s openBluetoothAdapter!", appId);
        j a2 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.a(appId, new b.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.l.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.a
            public final void ho(boolean z) {
                AppMethodBeat.i(144506);
                c.a(fVar, z, false);
                AppMethodBeat.o(144506);
            }
        }, new h() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.l.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h
            public final void ap(String str, boolean z) {
                AppMethodBeat.i(144507);
                b.a(fVar, str, z);
                AppMethodBeat.o(144507);
            }
        }, new g() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.l.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g
            public final void g(String str, String str2, String str3, String str4) {
                AppMethodBeat.i(144508);
                a.a(fVar, str, str2, str3, str4);
                AppMethodBeat.o(144508);
            }
        });
        HashMap hashMap = new HashMap();
        switch (a2.errCode) {
            case 0:
                fVar.i(i2, n("ok", hashMap));
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(1);
                AppMethodBeat.o(144515);
                return;
            case 10001:
                hashMap.put("errCode", 10001);
                fVar.i(i2, n("fail:not available", hashMap));
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(2, 7);
                AppMethodBeat.o(144515);
                return;
            case 10009:
                hashMap.put("errCode", 10009);
                fVar.i(i2, n("fail:system not support", hashMap));
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(2, 8);
                AppMethodBeat.o(144515);
                return;
            default:
                hashMap.put("errCode", Integer.valueOf(a2.errCode));
                fVar.i(i2, n(a2.errMsg, hashMap));
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(2);
                AppMethodBeat.o(144515);
                return;
        }
    }

    public static class c extends bc {
        private static final int CTRL_INDEX = 189;
        private static final String NAME = "onBluetoothAdapterStateChange";
        private static JSONObject lKZ = new JSONObject();
        private static c lLb = new c();

        static {
            AppMethodBeat.i(144514);
            AppMethodBeat.o(144514);
        }

        public static synchronized void a(f fVar, boolean z, boolean z2) {
            synchronized (c.class) {
                AppMethodBeat.i(144513);
                if (fVar == null) {
                    Log.e("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
                    AppMethodBeat.o(144513);
                } else {
                    try {
                        lKZ.remove("available");
                        lKZ.put("available", z);
                        lKZ.remove("discovering");
                        lKZ.put("discovering", z2);
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", e2);
                    }
                    if (fVar == null) {
                        Log.w("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
                        AppMethodBeat.o(144513);
                    } else {
                        lLb.b(fVar, fVar.getComponentId()).Zh(lKZ.toString()).bEo();
                        Log.i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChange %s", lKZ.toString());
                        AppMethodBeat.o(144513);
                    }
                }
            }
        }
    }

    static class b extends bc {
        private static final int CTRL_INDEX = 188;
        private static final String NAME = "onBLEConnectionStateChanged";
        private static JSONObject lKZ = new JSONObject();
        private static b lLa = new b();

        private b() {
        }

        static {
            AppMethodBeat.i(144512);
            AppMethodBeat.o(144512);
        }

        public static synchronized void a(f fVar, String str, boolean z) {
            synchronized (b.class) {
                AppMethodBeat.i(144511);
                if (fVar == null) {
                    Log.e("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLEConnectionStateChangedEvent dispatch fail, service is null");
                    AppMethodBeat.o(144511);
                } else {
                    try {
                        lKZ.remove("deviceId");
                        lKZ.put("deviceId", str);
                        lKZ.remove("connected");
                        lKZ.put("connected", z);
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", e2);
                    }
                    if (fVar == null) {
                        Log.w("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
                        AppMethodBeat.o(144511);
                    } else {
                        lLa.b(fVar, fVar.getComponentId()).Zh(lKZ.toString()).bEo();
                        Log.i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLEConnectionStateChangedEvent %s", lKZ.toString());
                        AppMethodBeat.o(144511);
                    }
                }
            }
        }
    }

    static class a extends bc {
        private static final int CTRL_INDEX = 187;
        private static final String NAME = "onBLECharacteristicValueChange";
        private static a lKY = new a();
        private static JSONObject lKZ = new JSONObject();

        private a() {
        }

        static {
            AppMethodBeat.i(144510);
            AppMethodBeat.o(144510);
        }

        public static synchronized void a(f fVar, String str, String str2, String str3, String str4) {
            synchronized (a.class) {
                AppMethodBeat.i(144509);
                if (fVar == null) {
                    Log.e("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLECharacteristicValueChangeEvent dispatch fail, service is null");
                    AppMethodBeat.o(144509);
                } else {
                    try {
                        lKZ.remove("value");
                        lKZ.put("value", str4);
                        lKZ.remove("deviceId");
                        lKZ.put("deviceId", str);
                        lKZ.remove("serviceId");
                        lKZ.put("serviceId", str2);
                        lKZ.remove("characteristicId");
                        lKZ.put("characteristicId", str3);
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", e2);
                    }
                    if (fVar == null) {
                        Log.w("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
                        AppMethodBeat.o(144509);
                    } else {
                        lKY.b(fVar, fVar.getComponentId()).Zh(lKZ.toString()).bEo();
                        Log.i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLECharacteristicValueChangeEvent %s", lKZ.toString());
                        AppMethodBeat.o(144509);
                    }
                }
            }
        }
    }
}
