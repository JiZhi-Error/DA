package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.os.ParcelUuid;
import android.util.Base64;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J#\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\tX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "connectable", "", "deviceName", "", "manufacturerData", "", "Lkotlin/Pair;", "", "powerLevel", "serverId", "getServerId", "()I", "setServerId", "(I)V", "serviceUuids", "Landroid/os/ParcelUuid;", "getAdvertiseReqData", "Landroid/bluetooth/le/AdvertiseData;", "getAdvertiseRespData", "getAdvertiseSettings", "Landroid/bluetooth/le/AdvertiseSettings;", "getPowerInfo", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "parseData", "reset", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class g extends d<f> {
    private static final int CTRL_INDEX = CTRL_INDEX;
    private static final String NAME = NAME;
    public static final a lLw = new a((byte) 0);
    private String deviceName = "";
    private int ktp = -1;
    private boolean lLs = true;
    private final List<ParcelUuid> lLt = new ArrayList();
    private final List<o<Integer, String>> lLu = new ArrayList();
    private String lLv = FirebaseAnalytics.b.MEDIUM;

    public g() {
        AppMethodBeat.i(144763);
        AppMethodBeat.o(144763);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(144764);
        AppMethodBeat.o(144764);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$invoke$1", "Landroid/bluetooth/le/AdvertiseCallback;", "onStartFailure", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "luggage-commons-jsapi-connectivity-ext_release"})
    public static final class b extends AdvertiseCallback {
        final /* synthetic */ g lLx;
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;

        b(g gVar, int i2, f fVar) {
            this.lLx = gVar;
            this.lyo = i2;
            this.lyn = fVar;
        }

        public final void onStartSuccess(AdvertiseSettings advertiseSettings) {
            AppMethodBeat.i(144758);
            super.onStartSuccess(advertiseSettings);
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.lLx, this.lyo, this.lyn);
            AppMethodBeat.o(144758);
        }

        public final void onStartFailure(int i2) {
            String str;
            AppMethodBeat.i(144759);
            super.onStartFailure(i2);
            Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "Not broadcasting: ".concat(String.valueOf(i2)));
            switch (i2) {
                case 1:
                    str = "fail:data too large";
                    break;
                case 2:
                    str = "fail:too many advertisers";
                    break;
                case 3:
                    str = "fail:already started";
                    break;
                case 4:
                    str = "fail:internal error";
                    break;
                case 5:
                    str = "fail:feature unsupported";
                    break;
                default:
                    str = "fail:Unhandled " + i2 + " error";
                    break;
            }
            Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "onStartFailure: error msg = ".concat(String.valueOf(str)));
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.lLx, this.lyo, this.lyn, 10008, str);
            AppMethodBeat.o(144759);
        }
    }

    private final boolean Q(JSONObject jSONObject) {
        boolean z;
        int i2;
        AppMethodBeat.i(144761);
        if (jSONObject == null) {
            AppMethodBeat.o(144761);
            return false;
        }
        try {
            this.ktp = jSONObject.optInt("serverId");
            String optString = jSONObject.optString("powerLevel", FirebaseAnalytics.b.MEDIUM);
            p.g(optString, "data.optString(\"powerLevel\", \"medium\")");
            this.lLv = optString;
            JSONObject optJSONObject = jSONObject.optJSONObject("advertiseRequest");
            this.lLs = optJSONObject.optBoolean("connectable", true);
            String optString2 = optJSONObject.optString("deviceName", "");
            p.g(optString2, "jAdvertiseRequest.optString(\"deviceName\", \"\")");
            this.deviceName = optString2;
            JSONArray optJSONArray = optJSONObject.optJSONArray("serviceUuids");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                String[] strArr = new String[length];
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = optJSONArray.get(i3);
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.String");
                        AppMethodBeat.o(144761);
                        throw tVar;
                    }
                    strArr[i3] = (String) obj;
                }
                ArrayList<ParcelUuid> arrayList = new ArrayList(strArr.length);
                for (String str : strArr) {
                    arrayList.add(new ParcelUuid(UUID.fromString(str)));
                }
                for (ParcelUuid parcelUuid : arrayList) {
                    this.lLt.add(parcelUuid);
                }
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("manufacturerData");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                JSONObject[] jSONObjectArr = new JSONObject[length2];
                for (int i4 = 0; i4 < length2; i4++) {
                    Object obj2 = optJSONArray2.get(i4);
                    if (obj2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type org.json.JSONObject");
                        AppMethodBeat.o(144761);
                        throw tVar2;
                    }
                    jSONObjectArr[i4] = (JSONObject) obj2;
                }
                for (JSONObject jSONObject2 : jSONObjectArr) {
                    String optString3 = jSONObject2.optString("manufacturerId");
                    int i5 = 10;
                    p.g(optString3, "manufacturerIdString");
                    if (n.J(optString3, "0x", false)) {
                        optString3 = n.j(optString3, "0x", "", false);
                        i5 = 16;
                    }
                    try {
                        i2 = Integer.parseInt(optString3, i5);
                    } catch (NumberFormatException e2) {
                        Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "NumberFormatException: input = ".concat(String.valueOf(optString3)));
                        i2 = 0;
                    }
                    this.lLu.add(new o<>(Integer.valueOf(i2), jSONObject2.optString("manufacturerSpecificData", "")));
                }
            }
            z = true;
        } catch (Exception e3) {
            Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "parseData: error ", e3);
            z = false;
        }
        AppMethodBeat.o(144761);
        return z;
    }

    private final AdvertiseData bFh() {
        AppMethodBeat.i(144762);
        AdvertiseData.Builder includeDeviceName = new AdvertiseData.Builder().setIncludeDeviceName(!n.aL(this.deviceName));
        for (T t : this.lLu) {
            includeDeviceName.addManufacturerData(t.first.intValue(), c.aK(Base64.decode(t.second, 2)));
        }
        Iterator<T> it = this.lLt.iterator();
        while (it.hasNext()) {
            includeDeviceName.addServiceUuid(it.next());
        }
        AdvertiseData build = includeDeviceName.build();
        p.g(build, "builder.build()");
        AppMethodBeat.o(144762);
        return build;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(144760);
        p.h(fVar, "env");
        this.lLu.clear();
        this.lLt.clear();
        this.lLv = FirebaseAnalytics.b.MEDIUM;
        this.deviceName = "";
        this.lLs = true;
        this.ktp = -1;
        if (!c.bFE()) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this, i2, fVar, 10001, "fail:not available");
            Log.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: Ble is not available");
            AppMethodBeat.o(144760);
        } else if (!Q(jSONObject)) {
            Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "createBLEPeripheralServer data is invalid");
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this, i2, fVar, 10013, "fail:invalid data");
            AppMethodBeat.o(144760);
        } else {
            o oVar = o.lLV;
            n wQ = o.wQ(this.ktp);
            if (wQ == null || wQ.lLE != p.CREATED) {
                Log.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: retrieve a null server");
                if (wQ == null || wQ.lLE != p.CONNECTED) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this, i2, fVar, 10020, "fail: no server");
                    AppMethodBeat.o(144760);
                    return;
                }
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this, i2, fVar, 10000, "fail:not init:already connected");
                AppMethodBeat.o(144760);
                return;
            }
            BluetoothAdapter bFC = c.bFC();
            if (bFC == null) {
                Log.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: adapter is null");
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this, i2, fVar, 10001, "fail:not available");
                AppMethodBeat.o(144760);
                return;
            }
            p.h(fVar, "<set-?>");
            wQ.lqg = fVar;
            String str = this.lLv;
            switch (str.hashCode()) {
                case -1078030475:
                    if (str.equals(FirebaseAnalytics.b.MEDIUM)) {
                        i3 = 2;
                        i4 = 1;
                        break;
                    }
                    i3 = 3;
                    i4 = 2;
                    break;
                case 107348:
                    if (str.equals("low")) {
                        i3 = 1;
                        i4 = 0;
                        break;
                    }
                    i3 = 3;
                    i4 = 2;
                    break;
                case 3202466:
                    if (str.equals("high")) {
                        i3 = 3;
                        i4 = 2;
                        break;
                    }
                    i3 = 3;
                    i4 = 2;
                    break;
                default:
                    i3 = 3;
                    i4 = 2;
                    break;
            }
            o oVar2 = new o(Integer.valueOf(i4), Integer.valueOf(i3));
            AdvertiseSettings build = new AdvertiseSettings.Builder().setAdvertiseMode(oVar2.first.intValue()).setTxPowerLevel(oVar2.second.intValue()).setTimeout(0).setConnectable(this.lLs).build();
            p.g(build, "AdvertiseSettings.Builde…ble)\n            .build()");
            AdvertiseData bFh = bFh();
            AdvertiseData build2 = new AdvertiseData.Builder().setIncludeDeviceName(false).build();
            p.g(build2, "AdvertiseData.Builder()\n…lse)\n            .build()");
            String str2 = this.deviceName;
            b bVar = new b(this, i2, fVar);
            p.h(build, "settings");
            p.h(bFh, "advertiseData");
            p.h(build2, "scanResponse");
            p.h(str2, "deviceName");
            p.h(bFC, "adapter");
            p.h(bVar, "userCallback");
            if (wQ.bFj()) {
                bVar.onStartFailure(3);
                AppMethodBeat.o(144760);
                return;
            }
            wQ.lLI = bVar;
            wQ.lLJ.set(true);
            h.RTc.aX(new n.d(wQ, bFC, str2, build, bFh, build2));
            AppMethodBeat.o(144760);
        }
    }
}
