package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.wifi.WifiConfiguration;
import android.os.Build;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends d {
    public static final int CTRL_INDEX = 316;
    public static final String NAME = "connectWifi";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.a$a  reason: collision with other inner class name */
    public static class C0723a extends bc {
        private static final int CTRL_INDEX = 322;
        private static final String NAME = "onWifiConnected";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(144686);
        if (!d.mHU) {
            Log.e("MicroMsg.JsApiConnectWifi", "not invoke startWifi");
            Map<String, ? extends Object> hashMap = new HashMap<>();
            hashMap.put("errCode", 12000);
            fVar.i(i2, n("fail:not invoke startWifi", hashMap));
            AppMethodBeat.o(144686);
        } else if (jSONObject == null || !jSONObject.has("SSID")) {
            Log.e("MicroMsg.JsApiConnectWifi", "params is invalid");
            Map<String, ? extends Object> hashMap2 = new HashMap<>();
            hashMap2.put("errCode", 12010);
            fVar.i(i2, n("fail:invalid data", hashMap2));
            AppMethodBeat.o(144686);
        } else {
            final Context context = fVar.getContext();
            if (context == null) {
                Log.e("MicroMsg.JsApiConnectWifi", "mContext is null, invoke fail!");
                Map<String, ? extends Object> hashMap3 = new HashMap<>();
                hashMap3.put("errCode", 12010);
                fVar.i(i2, n("fail:context is null", hashMap3));
                AppMethodBeat.o(144686);
                return;
            }
            e.eb(context);
            if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.isWifiEnabled()) {
                Log.e("MicroMsg.JsApiConnectWifi", "wifi is disable");
                Map<String, ? extends Object> hashMap4 = new HashMap<>();
                hashMap4.put("errCode", 12005);
                fVar.i(i2, n("fail:wifi is disable", hashMap4));
                AppMethodBeat.o(144686);
            } else if (fVar.getAppState() != b.kQH) {
                Log.e("MicroMsg.JsApiConnectWifi", "current state :%s isn't foreground", fVar.getAppState());
                Map<String, ? extends Object> hashMap5 = new HashMap<>();
                hashMap5.put("errCode", 12011);
                fVar.i(i2, n("fail:weapp in background", hashMap5));
                AppMethodBeat.o(144686);
            } else {
                if (jSONObject.optBoolean("maunal", false)) {
                    Intent intent = new Intent("android.settings.WIFI_SETTINGS");
                    if (Util.isIntentAvailable(context, intent)) {
                        Log.i("MicroMsg.JsApiConnectWifi", "use manual");
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/wifi/JsApiConnectWifi", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/jsapi/wifi/JsApiConnectWifi", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        HashMap hashMap6 = new HashMap();
                        hashMap6.put("errCode", 0);
                        fVar.i(i2, n("ok", hashMap6));
                        AppMethodBeat.o(144686);
                        return;
                    }
                    Log.w("MicroMsg.JsApiConnectWifi", "jump2SysWifiSettingsIntent is unavailable");
                }
                final com.tencent.luggage.c.a.a aVar = (com.tencent.luggage.c.a.a) com.tencent.luggage.a.e.M(com.tencent.luggage.c.a.a.class);
                final k aE = aVar.aE(context);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.wifi.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(144682);
                        fVar.getDialogContainer().b(aE);
                        AppMethodBeat.o(144682);
                    }
                });
                e.a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.wifi.a.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a
                    public final void H(String str, String str2, String str3) {
                        WifiConfiguration wifiConfiguration;
                        boolean z;
                        AppMethodBeat.i(215162);
                        e.a((com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a) null);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.wifi.a.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(144683);
                                if (aE != null) {
                                    aVar.a(aE);
                                }
                                AppMethodBeat.o(144683);
                            }
                        });
                        if (str3.equals("ok")) {
                            c bLG = e.bLG();
                            if (bLG == null) {
                                Log.i("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback] currentWiFi is null, use WifiConfiguration");
                                List<WifiConfiguration> configuredNetworks = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.getConfiguredNetworks();
                                if (configuredNetworks != null) {
                                    Iterator<WifiConfiguration> it = configuredNetworks.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            wifiConfiguration = null;
                                            break;
                                        }
                                        wifiConfiguration = it.next();
                                        if (Objects.equals(wifiConfiguration.BSSID, str2)) {
                                            break;
                                        }
                                    }
                                } else {
                                    wifiConfiguration = null;
                                }
                                if (wifiConfiguration == null) {
                                    Log.w("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback] curWifiConfig is null");
                                }
                                if (wifiConfiguration == null) {
                                    bLG = null;
                                } else {
                                    c cVar = new c();
                                    cVar.mHX = Util.nullAs(str, "");
                                    cVar.mHY = Util.nullAs(str2, "");
                                    if (2 == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.d(wifiConfiguration)) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    cVar.mIa = z;
                                    cVar.mHZ = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.abK(str2);
                                    bLG = cVar;
                                }
                            }
                            Log.i("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback]currentWifi:%s", bLG);
                            if (bLG == null) {
                                Log.e("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback]currentWIfi is null");
                                HashMap hashMap = new HashMap();
                                fVar.i(i2, a.this.n(a.a(context, hashMap, "fail:can't gain current wifi"), hashMap));
                                AppMethodBeat.o(215162);
                                return;
                            }
                            try {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("wifi", bLG.toJSONObject());
                                hashMap2.put("errCode", 0);
                                fVar.i(i2, a.this.n("ok", hashMap2));
                                AppMethodBeat.o(215162);
                            } catch (JSONException e2) {
                                Log.e("MicroMsg.JsApiConnectWifi", "IConnectWiFiCallback is error");
                                Log.printErrStackTrace("MicroMsg.JsApiConnectWifi", e2, "", new Object[0]);
                                HashMap hashMap3 = new HashMap();
                                hashMap3.put("errCode", 12010);
                                fVar.i(i2, a.this.n("fail:parse json err", hashMap3));
                                AppMethodBeat.o(215162);
                            }
                        } else {
                            HashMap hashMap4 = new HashMap();
                            if (str3.equals("duplicated request")) {
                                hashMap4.put("errCode", 12004);
                            } else if (str3.equals("password error")) {
                                hashMap4.put("errCode", 12002);
                            } else if (str3.equals("wifi config may be expired")) {
                                hashMap4.put("errCode", 12013);
                            } else if (str3.equals("fail to connect wifi:time out")) {
                                hashMap4.put("errCode", 12003);
                            } else {
                                str3 = a.a(context, hashMap4, str3);
                            }
                            Log.e("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback]errCode:%d, errMsg:%s", hashMap4.get("errCode"), str3);
                            fVar.i(i2, a.this.n("fail:".concat(String.valueOf(str3)), hashMap4));
                            AppMethodBeat.o(215162);
                        }
                    }
                });
                h.a(fVar.getAppId(), new h.c() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.wifi.a.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.appbrand.h.c
                    public final void onDestroy() {
                        AppMethodBeat.i(144685);
                        Log.d("MicroMsg.JsApiConnectWifi", "remove listener");
                        e.a((com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a) null);
                        h.b(fVar.getAppId(), this);
                        AppMethodBeat.o(144685);
                    }
                });
                String optString = jSONObject.optString("SSID");
                String optString2 = jSONObject.optString("BSSID");
                String optString3 = jSONObject.optString("password");
                if (optString.equals("")) {
                    Log.e("MicroMsg.JsApiConnectWifi", "params is invalid");
                    Map<String, ? extends Object> hashMap7 = new HashMap<>();
                    hashMap7.put("errCode", 12008);
                    fVar.i(i2, n("fail:invalid data", hashMap7));
                    AppMethodBeat.o(144686);
                    return;
                }
                Log.i("MicroMsg.JsApiConnectWifi", "ssid:%s, bSsid:%s is connecting", optString, optString2);
                e.I(optString, optString2, optString3);
                AppMethodBeat.o(144686);
            }
        }
    }

    static /* synthetic */ String a(Context context, Map map, String str) {
        AppMethodBeat.i(215163);
        if (Build.VERSION.SDK_INT < 23 || ((LocationManager) context.getSystemService(FirebaseAnalytics.b.LOCATION)).isProviderEnabled("gps")) {
            boolean a2 = i.a((Activity) context, "android.permission.ACCESS_FINE_LOCATION", 64, null, null);
            Log.i("MicroMsg.JsApiConnectWifi", "fixErrInfo, checkLocation:%b", Boolean.valueOf(a2));
            if (!a2) {
                map.put("errCode", 12012);
                Log.e("MicroMsg.JsApiConnectWifi", "fixErrInfo, may be not obtain GPS Perrmission");
                AppMethodBeat.o(215163);
                return "fail:may be not obtain GPS Perrmission";
            }
            map.put("errCode", 12010);
            AppMethodBeat.o(215163);
            return str;
        }
        map.put("errCode", 12006);
        Log.e("MicroMsg.JsApiConnectWifi", "fixErrInfo, may be not open GPS");
        AppMethodBeat.o(215163);
        return "fail:may be not open GPS";
    }
}
