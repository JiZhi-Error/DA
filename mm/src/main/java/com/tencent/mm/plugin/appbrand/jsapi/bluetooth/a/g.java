package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.util.HashMap;
import org.json.JSONObject;

public final class g extends d {
    private static final int CTRL_INDEX = 175;
    private static final String NAME = "getBluetoothAdapterState";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        boolean z = false;
        AppMethodBeat.i(144500);
        c.pl(126);
        Log.i("MicroMsg.JsApiGetBluetoothAdapterState", "appId:%s getBluetoothAdapterState", fVar.getAppId());
        b ZC = a.ZC(fVar.getAppId());
        if (ZC == null) {
            Log.e("MicroMsg.JsApiGetBluetoothAdapterState", "bleWorker is null, may not open ble");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10000);
            fVar.i(i2, n("fail:not init", hashMap));
            c.dY(128, 130);
            AppMethodBeat.o(144500);
            return;
        }
        boolean bFE = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE();
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bFg = ZC.bFg();
        if (bFg != null) {
            z = bFg.lMs.lNQ.get();
        }
        Log.i("MicroMsg.JsApiGetBluetoothAdapterState", "availableState : " + bFE + ",discoveringState : " + z);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("available", Boolean.valueOf(bFE));
        hashMap2.put("discovering", Boolean.valueOf(z));
        fVar.i(i2, n("ok", hashMap2));
        c.pl(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
        AppMethodBeat.o(144500);
    }
}
