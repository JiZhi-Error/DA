package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class h extends d {
    private static final int CTRL_INDEX = 178;
    private static final String NAME = "getBluetoothDevices";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> list;
        AppMethodBeat.i(144501);
        c.pl(166);
        String appId = fVar.getAppId();
        Object[] objArr = new Object[2];
        objArr[0] = appId;
        objArr[1] = jSONObject == null ? "" : jSONObject;
        Log.i("MicroMsg.JsApiGetBluetoothDevices", "appId:%s getBluetoothDevices data:%s", objArr);
        b ZC = a.ZC(appId);
        if (ZC == null) {
            Log.e("MicroMsg.JsApiGetBluetoothDevices", "bleWorker is null, may not open ble");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10000);
            fVar.i(i2, n("fail:not init", hashMap));
            c.dY(168, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE);
            AppMethodBeat.o(144501);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE()) {
            Log.e("MicroMsg.JsApiGetBluetoothDevices", "adapter is null or not enabled!");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10001);
            fVar.i(i2, n("fail:not available", hashMap2));
            c.dY(168, 172);
            AppMethodBeat.o(144501);
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bFg = ZC.bFg();
            if (bFg != null) {
                list = bFg.lMs.bFw();
            } else {
                list = null;
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (list != null) {
                boolean optBoolean = jSONObject != null ? jSONObject.optBoolean("useOldImpl", false) : false;
                Log.i("MicroMsg.JsApiGetBluetoothDevices", "useOldImpl: ".concat(String.valueOf(optBoolean)));
                list.addAll(ZC.hn(optBoolean));
                for (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d dVar : list) {
                    try {
                        jSONArray.put(dVar.bEw());
                    } catch (JSONException e2) {
                        Log.printErrStackTrace("MicroMsg.JsApiGetBluetoothDevices", e2, "", new Object[0]);
                    }
                }
            }
            try {
                jSONObject2.put("errMsg", getName() + ":ok");
                jSONObject2.put("devices", jSONArray);
            } catch (JSONException e3) {
                Log.e("MicroMsg.JsApiGetBluetoothDevices", "put json value error : %s", android.util.Log.getStackTraceString(e3));
            }
            Log.i("MicroMsg.JsApiGetBluetoothDevices", "retJson %s", jSONObject2);
            fVar.i(i2, jSONObject2.toString());
            c.pl(TbsListener.ErrorCode.STARTDOWNLOAD_8);
            AppMethodBeat.o(144501);
        }
    }
}
