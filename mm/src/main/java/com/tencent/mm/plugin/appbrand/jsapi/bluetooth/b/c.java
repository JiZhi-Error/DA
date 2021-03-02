package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiAddBlePeripheralService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "parseData", "Landroid/bluetooth/BluetoothGattService;", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class c extends d<f> {
    private static final int CTRL_INDEX = CTRL_INDEX;
    private static final String NAME = NAME;
    public static final a lLn = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "success", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ c lLo;
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar, int i2, f fVar) {
            super(1);
            this.lLo = cVar;
            this.lyo = i2;
            this.lyn = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(144748);
            if (bool.booleanValue()) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.lLo, this.lyo, this.lyn);
            } else {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.lLo, this.lyo, this.lyn, 10008, "fail:system error, add service fail");
            }
            x xVar = x.SXb;
            AppMethodBeat.o(144748);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiAddBlePeripheralService$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(144751);
        AppMethodBeat.o(144751);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(144749);
        p.h(fVar, "env");
        if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE()) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this, i2, fVar, 10001, "fail:not available");
            Log.i("MicroMsg.BLE.JsApiAddBlePeripheralService", "invoke: Ble is not open");
            AppMethodBeat.o(144749);
            return;
        }
        BluetoothGattService P = P(jSONObject);
        if (P == null) {
            Log.e("MicroMsg.BLE.JsApiAddBlePeripheralService", "createBLEPeripheralService data is invalid");
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this, i2, fVar, 10013, "fail:invalid data");
            AppMethodBeat.o(144749);
            return;
        }
        if (jSONObject == null) {
            p.hyc();
        }
        int optInt = jSONObject.optInt("serverId");
        o oVar = o.lLV;
        n wQ = o.wQ(optInt);
        if (wQ == null) {
            Log.i("MicroMsg.BLE.JsApiAddBlePeripheralService", "invoke: retrieve a null server by #".concat(String.valueOf(optInt)));
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this, i2, fVar, 10020, "fail: no server");
            AppMethodBeat.o(144749);
            return;
        }
        b bVar = new b(this, i2, fVar);
        p.h(P, "service");
        p.h(bVar, "callback");
        BluetoothGattServer bluetoothGattServer = wQ.lLF;
        if (bluetoothGattServer == null) {
            p.btv("gattServer");
        }
        if (!bluetoothGattServer.addService(P)) {
            bVar.invoke(Boolean.FALSE);
        }
        Map<UUID, o<kotlin.g.a.b<Boolean, x>, Timer>> map = wQ.lLG;
        UUID uuid = P.getUuid();
        p.g(uuid, "service.uuid");
        Timer btu = kotlin.c.b.btu(null);
        btu.schedule(new n.b(bVar), 3000, MAlarmHandler.NEXT_FIRE_INTERVAL);
        map.put(uuid, new o<>(bVar, btu));
        AppMethodBeat.o(144749);
    }

    private static BluetoothGattService P(JSONObject jSONObject) {
        int i2;
        AppMethodBeat.i(144750);
        z.f fVar = new z.f();
        if (jSONObject == null) {
            AppMethodBeat.o(144750);
            return null;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("service");
            fVar.SYG = (T) new BluetoothGattService(UUID.fromString(optJSONObject.optString("uuid")), 0);
            JSONArray optJSONArray = optJSONObject.optJSONArray("characteristics");
            if (optJSONArray == null) {
                T t = fVar.SYG;
                AppMethodBeat.o(144750);
                return t;
            }
            int length = optJSONArray.length();
            JSONObject[] jSONObjectArr = new JSONObject[length];
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = optJSONArray.get(i3);
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type org.json.JSONObject");
                    AppMethodBeat.o(144750);
                    throw tVar;
                }
                jSONObjectArr[i3] = (JSONObject) obj;
            }
            ArrayList<BluetoothGattCharacteristic> arrayList = new ArrayList(jSONObjectArr.length);
            for (JSONObject jSONObject2 : jSONObjectArr) {
                String optString = jSONObject2.optString("uuid");
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("properties");
                boolean optBoolean = optJSONObject2.optBoolean("write", false);
                boolean optBoolean2 = optJSONObject2.optBoolean("read", false);
                boolean optBoolean3 = optJSONObject2.optBoolean("notify", false);
                boolean optBoolean4 = optJSONObject2.optBoolean("indicate", false);
                boolean optBoolean5 = optJSONObject2.optBoolean("writeNoResponse", false);
                int i4 = 0;
                if (optBoolean) {
                    i4 = 8;
                }
                if (optBoolean2) {
                    i4 |= 2;
                }
                if (optBoolean3) {
                    i4 |= 16;
                }
                if (optBoolean4) {
                    i4 |= 32;
                }
                if (optBoolean5) {
                    i2 = i4 | 4;
                } else {
                    i2 = i4;
                }
                JSONObject optJSONObject3 = jSONObject2.optJSONObject("permission");
                boolean optBoolean6 = optJSONObject3.optBoolean("readable", false);
                boolean optBoolean7 = optJSONObject3.optBoolean("writeable", false);
                boolean optBoolean8 = optJSONObject3.optBoolean("readEncryptionRequired", false);
                boolean optBoolean9 = optJSONObject3.optBoolean("writeEncryptionRequired", false);
                int i5 = 0;
                if (optBoolean6) {
                    i5 = 1;
                }
                if (optBoolean7) {
                    i5 |= 16;
                }
                if (optBoolean9) {
                    i5 = i5 | 32 | 64;
                }
                if (optBoolean8) {
                    i5 = i5 | 2 | 4;
                }
                BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UUID.fromString(optString), i2, i5);
                String optString2 = jSONObject2.optString("value");
                byte[] aK = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aK(Base64.decode(optString2, 2));
                Log.i("MicroMsg.BLE.JsApiAddBlePeripheralService", "parseData characteristic : base64 = " + optString2 + ", hex = " + aK);
                bluetoothGattCharacteristic.setValue(aK);
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("descriptors");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    JSONObject[] jSONObjectArr2 = new JSONObject[length2];
                    for (int i6 = 0; i6 < length2; i6++) {
                        Object obj2 = optJSONArray2.get(i6);
                        if (obj2 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type org.json.JSONObject");
                            AppMethodBeat.o(144750);
                            throw tVar2;
                        }
                        jSONObjectArr2[i6] = (JSONObject) obj2;
                    }
                    for (JSONObject jSONObject3 : jSONObjectArr2) {
                        String optString3 = jSONObject3.optString("uuid");
                        JSONObject optJSONObject4 = jSONObject3.optJSONObject("permission");
                        String optString4 = jSONObject3.optString("value");
                        boolean optBoolean10 = optJSONObject4.optBoolean("write");
                        int i7 = 0;
                        if (optJSONObject4.optBoolean("read")) {
                            i7 = 1;
                        }
                        if (optBoolean10) {
                            i7 |= 16;
                        }
                        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(UUID.fromString(optString3), i7);
                        byte[] aK2 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aK(Base64.decode(optString4, 2));
                        Log.i("MicroMsg.BLE.JsApiAddBlePeripheralService", "parseData descriptor: base64 = " + optString4 + ", hex = " + aK2);
                        bluetoothGattDescriptor.setValue(aK2);
                        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
                    }
                }
                arrayList.add(bluetoothGattCharacteristic);
            }
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : arrayList) {
                T t2 = fVar.SYG;
                if (t2 == null) {
                    p.hyc();
                }
                t2.addCharacteristic(bluetoothGattCharacteristic2);
            }
            T t3 = fVar.SYG;
            AppMethodBeat.o(144750);
            return t3;
        } catch (Exception e2) {
            Log.e("MicroMsg.BLE.JsApiAddBlePeripheralService", "parseData: fail", e2);
            fVar.SYG = null;
        }
    }
}
