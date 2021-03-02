package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.vendor.MIUI;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends d {
    public static final int CTRL_INDEX = 318;
    public static final String NAME = "getConnectedWifi";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(144687);
        if (!d.mHU) {
            Log.e("MicroMsg.JsApiGetConnectedWifi", "not invoke startWifi");
            Map<String, ? extends Object> hashMap = new HashMap<>();
            hashMap.put("errCode", 12000);
            fVar.i(i2, n("fail:not invoke startWifi", hashMap));
            AppMethodBeat.o(144687);
            return;
        }
        Context context = fVar.getContext();
        if (context == null) {
            Log.e("MicroMsg.JsApiGetConnectedWifi", "mContext is null, invoke fail!");
            Map<String, ? extends Object> hashMap2 = new HashMap<>();
            hashMap2.put("errCode", 12010);
            fVar.i(i2, n("fail:context is null", hashMap2));
            AppMethodBeat.o(144687);
            return;
        }
        e.eb(context);
        if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.isWifiEnabled()) {
            Log.e("MicroMsg.JsApiGetConnectedWifi", "wifi is disable,invoke fail!");
            Map<String, ? extends Object> hashMap3 = new HashMap<>();
            hashMap3.put("errCode", 12005);
            fVar.i(i2, n("fail:wifi is disable", hashMap3));
            AppMethodBeat.o(144687);
            return;
        }
        c bLG = e.bLG();
        if (bLG != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                Log.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null");
                Map<String, ? extends Object> hashMap4 = new HashMap<>();
                hashMap4.put("errCode", 12010);
                fVar.i(i2, n("fail:connectivityManager is null", hashMap4));
                AppMethodBeat.o(144687);
                return;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                Log.e("MicroMsg.JsApiGetConnectedWifi", "netInfo is null");
                Map<String, ? extends Object> hashMap5 = new HashMap<>();
                hashMap5.put("errCode", 12010);
                fVar.i(i2, n("fail:netInfo is null", hashMap5));
                AppMethodBeat.o(144687);
            } else if (activeNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.CONNECTED) {
                Log.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null, detailState:%s", activeNetworkInfo.getDetailedState());
                Map<String, ? extends Object> hashMap6 = new HashMap<>();
                hashMap6.put("errCode", 12010);
                fVar.i(i2, n("fail:detailState is not connected", hashMap6));
                AppMethodBeat.o(144687);
            } else {
                Log.i("MicroMsg.JsApiGetConnectedWifi", "[invoke]currentWifi:%s", bLG);
                try {
                    HashMap hashMap7 = new HashMap();
                    hashMap7.put("wifi", bLG.toJSONObject());
                    hashMap7.put("errCode", 0);
                    fVar.i(i2, n("ok", hashMap7));
                    AppMethodBeat.o(144687);
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.JsApiGetConnectedWifi", e2, "", new Object[0]);
                    Map<String, ? extends Object> hashMap8 = new HashMap<>();
                    hashMap8.put("errCode", 12010);
                    fVar.i(i2, n("fail:parse json err", hashMap8));
                    AppMethodBeat.o(144687);
                }
            }
        } else if (Build.VERSION.SDK_INT < 23 || MIUI.isMIUI() || ((LocationManager) context.getSystemService(FirebaseAnalytics.b.LOCATION)).isProviderEnabled("gps")) {
            boolean a2 = i.a((Activity) context, "android.permission.ACCESS_FINE_LOCATION", 64, null, null);
            Log.i("MicroMsg.JsApiGetConnectedWifi", "checkLocation:%b", Boolean.valueOf(a2));
            if (!a2) {
                Map<String, ? extends Object> hashMap9 = new HashMap<>();
                hashMap9.put("errCode", 12012);
                fVar.i(i2, n("fail:may be not obtain GPS Perrmission", hashMap9));
                Log.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not obtain GPS Perrmission");
                AppMethodBeat.o(144687);
                return;
            }
            Log.e("MicroMsg.JsApiGetConnectedWifi", "currentWifi is null");
            Map<String, ? extends Object> hashMap10 = new HashMap<>();
            hashMap10.put("errCode", 12010);
            fVar.i(i2, n("fail:currentWifi is null", hashMap10));
            AppMethodBeat.o(144687);
        } else {
            Map<String, ? extends Object> hashMap11 = new HashMap<>();
            hashMap11.put("errCode", 12006);
            fVar.i(i2, n("fail:may be not open GPS", hashMap11));
            Log.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not open GPS");
            AppMethodBeat.o(144687);
        }
    }
}
