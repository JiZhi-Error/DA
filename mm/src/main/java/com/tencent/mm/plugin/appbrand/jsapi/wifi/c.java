package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.os.Looper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends d {
    public static final int CTRL_INDEX = 317;
    public static final String NAME = "getWifiList";

    public static class a extends bc {
        private static final int CTRL_INDEX = 321;
        private static final String NAME = "onGetWifiList";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(144688);
        if (!d.mHU) {
            Log.e("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 12000);
            fVar.i(i2, n("fail:not invoke startWifi", hashMap));
            AppMethodBeat.o(144688);
            return;
        }
        final Context context = fVar.getContext();
        if (context == null) {
            Log.e("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 12010);
            fVar.i(i2, n("fail:context is null", hashMap2));
            AppMethodBeat.o(144688);
            return;
        }
        e.eb(context);
        if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.isWifiEnabled()) {
            Log.e("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", 12005);
            fVar.i(i2, n("fail:wifi is disable", hashMap3));
            AppMethodBeat.o(144688);
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final MTimerHandler mTimerHandler = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.wifi.c.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(215164);
                Log.i("MicroMsg.JsApiGetWifiList", "onTimerExpired");
                e.bLI();
                if (!atomicBoolean.get()) {
                    c.a(c.this, fVar, i2, context, e.bLH());
                    atomicBoolean.set(true);
                } else {
                    Log.i("MicroMsg.JsApiGetWifiList", "onTimerExpired, hasCallback");
                }
                AppMethodBeat.o(215164);
                return false;
            }
        }, false);
        e.a(new b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.wifi.c.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b
            public final void a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d dVar) {
                AppMethodBeat.i(215165);
                Log.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList");
                mTimerHandler.stopTimer();
                e.bLI();
                if (!atomicBoolean.get()) {
                    c.a(c.this, fVar, i2, context, dVar);
                    atomicBoolean.set(true);
                    AppMethodBeat.o(215165);
                    return;
                }
                Log.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList, hasCallback");
                AppMethodBeat.o(215165);
            }
        });
        long optLong = jSONObject != null ? jSONObject.optLong("timeout", 10000) : 10000;
        Log.i("MicroMsg.JsApiGetWifiList", "invoke, getWifiListAsyncTimeoutMills: ".concat(String.valueOf(optLong)));
        mTimerHandler.startTimer(optLong);
        AppMethodBeat.o(144688);
    }

    static /* synthetic */ void a(c cVar, f fVar, int i2, Context context, com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d dVar) {
        AppMethodBeat.i(215166);
        if (dVar == null && dVar.mIe == null) {
            Log.e("MicroMsg.JsApiGetWifiList", "WiFiListResult is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 12010);
            fVar.i(i2, cVar.n("fail:can't gain wifi list", hashMap));
            AppMethodBeat.o(215166);
        } else if (dVar.jFn.equals("ok")) {
            try {
                Log.i("MicroMsg.JsApiGetWifiList", "onGetWifiList size:%d", Integer.valueOf(dVar.mIe.size()));
                if (dVar.mIe.size() == 0) {
                    if (Build.VERSION.SDK_INT < 23 || ((LocationManager) context.getSystemService(FirebaseAnalytics.b.LOCATION)).isProviderEnabled("gps")) {
                        boolean a2 = i.a((Activity) context, "android.permission.ACCESS_FINE_LOCATION", 64, null, null);
                        Log.i("MicroMsg.JsApiGetWifiList", "checkLocation:%b", Boolean.valueOf(a2));
                        if (!a2) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("errCode", 12012);
                            fVar.i(i2, cVar.n("fail:may be not obtain GPS Perrmission", hashMap2));
                            Log.e("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not obtain GPS Perrmission");
                            AppMethodBeat.o(215166);
                            return;
                        }
                    } else {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("errCode", 12006);
                        fVar.i(i2, cVar.n("fail:may be not open GPS", hashMap3));
                        Log.e("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not open GPS");
                        AppMethodBeat.o(215166);
                        return;
                    }
                }
                HashMap hashMap4 = new HashMap();
                hashMap4.put("errCode", 0);
                fVar.i(i2, cVar.n("ok", hashMap4));
                Log.d("MicroMsg.JsApiGetWifiList", "onGetWifiList %s", dVar);
                a aVar = new a();
                HashMap hashMap5 = new HashMap();
                hashMap5.put("wifiList", dVar.bLF());
                aVar.b(fVar, 0).L(hashMap5).bEo();
                AppMethodBeat.o(215166);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.JsApiGetWifiList", e2, "", new Object[0]);
                HashMap hashMap6 = new HashMap();
                hashMap6.put("errCode", 12010);
                fVar.i(i2, cVar.n("fail:parse json err", hashMap6));
                AppMethodBeat.o(215166);
            }
        } else {
            Log.e("MicroMsg.JsApiGetWifiList", "error, mErrorMsg:%s", dVar.jFn);
            HashMap hashMap7 = new HashMap();
            hashMap7.put("errCode", 12010);
            fVar.i(i2, cVar.n("fail:" + dVar.jFn, hashMap7));
            AppMethodBeat.o(215166);
        }
    }
}
