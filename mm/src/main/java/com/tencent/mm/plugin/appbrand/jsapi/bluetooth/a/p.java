package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.l;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

@TargetApi(18)
public final class p extends d {
    private static final int CTRL_INDEX = 177;
    private static final String NAME = "stopBluetoothDevicesDiscovery";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        j jVar;
        AppMethodBeat.i(144525);
        c.pl(101);
        String appId = fVar.getAppId();
        Object[] objArr = new Object[2];
        objArr[0] = appId;
        Object obj = jSONObject;
        if (jSONObject == null) {
            obj = "";
        }
        objArr[1] = obj;
        Log.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "appId:%s stopBluetoothDevicesDiscovery data:%s", objArr);
        b ZC = a.ZC(appId);
        if (ZC == null) {
            Log.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10000);
            fVar.i(i2, n("fail:not init", hashMap));
            c.dY(103, 106);
            AppMethodBeat.o(144525);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE()) {
            Log.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "adapter is null or not enabled!");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10001);
            fVar.i(i2, n("fail:not available", hashMap2));
            c.dY(103, 108);
            AppMethodBeat.o(144525);
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bFg = ZC.bFg();
            if (bFg != null) {
                jVar = bFg.lMs.bFv();
            } else {
                jVar = j.lNv;
            }
            Log.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "stopBleScan result:%s", jVar);
            HashMap hashMap3 = new HashMap();
            switch (jVar.errCode) {
                case 0:
                    hashMap3.put("isDiscovering", Boolean.FALSE);
                    fVar.i(i2, n("ok", hashMap3));
                    c.pl(102);
                    l.c.a(fVar, true, false);
                    AppMethodBeat.o(144525);
                    return;
                default:
                    hashMap3.put("isDiscovering", Boolean.FALSE);
                    fVar.i(i2, n("fail", hashMap3));
                    c.pl(103);
                    AppMethodBeat.o(144525);
                    return;
            }
        }
    }
}
