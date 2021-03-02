package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d {
    public static final int CTRL_INDEX = 314;
    public static final String NAME = "startWifi";
    public static boolean mHU = false;
    public static BroadcastReceiver mHV = null;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(144691);
        Log.i("MicroMsg.JsApiStartWifi", "invoke startWifi");
        final Context context = fVar.getContext();
        if (context == null) {
            Log.e("MicroMsg.JsApiStartWifi", "mContext is null, invoke fail!");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 12010);
            fVar.i(i2, n("fail:context is null", hashMap));
            AppMethodBeat.o(144691);
            return;
        }
        e.eb(context);
        if (!mHU) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.setPriority(Integer.MAX_VALUE);
            mHV = new BroadcastReceiver() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.wifi.d.AnonymousClass1 */

                public final void onReceive(Context context, Intent intent) {
                    Parcelable parcelableExtra;
                    boolean z;
                    AppMethodBeat.i(144689);
                    if (intent == null) {
                        AppMethodBeat.o(144689);
                        return;
                    }
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(action)) {
                        AppMethodBeat.o(144689);
                        return;
                    }
                    Log.i("MicroMsg.JsApiStartWifi", "actiong:%s", action);
                    if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                        int intExtra = intent.getIntExtra("wifi_state", 0);
                        Log.i("MicroMsg.JsApiStartWifi", "wifiState".concat(String.valueOf(intExtra)));
                        switch (intExtra) {
                            case 1:
                                d.F(fVar);
                                break;
                        }
                    }
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && (parcelableExtra = intent.getParcelableExtra("networkInfo")) != null) {
                        NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                        boolean z2 = networkInfo.getState() == NetworkInfo.State.CONNECTED;
                        if (networkInfo.getType() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z2 || !z) {
                            d.F(fVar);
                        } else {
                            c bLG = e.bLG();
                            Log.i("MicroMsg.JsApiStartWifi", "[mWiFiEventReceiver]currentWifi:%s", bLG);
                            if (bLG == null) {
                                Log.e("MicroMsg.JsApiStartWifi", "[CONNECTIVITY_ACTION]currentWIfi is null");
                                AppMethodBeat.o(144689);
                                return;
                            }
                            try {
                                a.C0723a aVar = new a.C0723a();
                                HashMap hashMap = new HashMap();
                                hashMap.put("wifi", bLG.toJSONObject());
                                aVar.b(fVar, 0).L(hashMap).bEo();
                                AppMethodBeat.o(144689);
                                return;
                            } catch (JSONException e2) {
                                Log.e("MicroMsg.JsApiStartWifi", "IConnectWiFiCallback is error");
                                Log.printErrStackTrace("MicroMsg.JsApiStartWifi", e2, "", new Object[0]);
                                AppMethodBeat.o(144689);
                                return;
                            }
                        }
                    }
                    AppMethodBeat.o(144689);
                }
            };
            context.registerReceiver(mHV, intentFilter);
            mHU = true;
        }
        h.a(fVar.getAppId(), new h.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.wifi.d.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(144690);
                if (d.mHV != null) {
                    Log.i("MicroMsg.JsApiStartWifi", "unregisterReceiver");
                    try {
                        context.unregisterReceiver(d.mHV);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.JsApiStartWifi", e2, "", new Object[0]);
                    }
                    d.mHU = false;
                    d.mHV = null;
                }
                h.b(fVar.getAppId(), this);
                AppMethodBeat.o(144690);
            }
        });
        HashMap hashMap2 = new HashMap();
        hashMap2.put("errCode", 0);
        fVar.i(i2, n("ok", hashMap2));
        AppMethodBeat.o(144691);
    }

    static /* synthetic */ void F(f fVar) {
        AppMethodBeat.i(144692);
        try {
            a.C0723a aVar = new a.C0723a();
            HashMap hashMap = new HashMap();
            hashMap.put("wifi", new c().toJSONObject());
            aVar.b(fVar, 0).L(hashMap).bEo();
            AppMethodBeat.o(144692);
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiStartWifi", "mWiFiEventReceiver is error");
            Log.printErrStackTrace("MicroMsg.JsApiStartWifi", e2, "", new Object[0]);
            AppMethodBeat.o(144692);
        }
    }
}
