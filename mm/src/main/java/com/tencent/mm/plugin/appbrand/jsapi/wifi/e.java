package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends d {
    public static final int CTRL_INDEX = 315;
    public static final String NAME = "stopWifi";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(144693);
        Log.i("MicroMsg.JsApiStopWifi", "invoke registerHotspotHelper");
        Context context = fVar.getContext();
        if (context == null) {
            Log.e("MicroMsg.JsApiStopWifi", "mContext is null, invoke fail!");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 12010);
            fVar.i(i2, n("fail:context is null", hashMap));
            AppMethodBeat.o(144693);
        } else if (!d.mHU) {
            Log.e("MicroMsg.JsApiStopWifi", "not invoke startWifi");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 12000);
            fVar.i(i2, n("fail:not invoke startWifi", hashMap2));
            AppMethodBeat.o(144693);
        } else {
            if (d.mHV != null) {
                Log.i("MicroMsg.JsApiStopWifi", "unregisterReceiver");
                try {
                    context.unregisterReceiver(d.mHV);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiStopWifi", "unregisterReceiver:%s fail", e2);
                }
                d.mHU = false;
                d.mHV = null;
            }
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", 0);
            fVar.i(i2, n("ok", hashMap3));
            AppMethodBeat.o(144693);
        }
    }
}
