package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

@TargetApi(18)
public final class b extends d {
    private static final int CTRL_INDEX = 174;
    private static final String NAME = "closeBluetoothAdapter";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(144495);
        c.pl(116);
        String appId = fVar.getAppId();
        Log.i("MicroMsg.JsApiCloseBluetoothAdapter", "appId:%s closeBluetoothAdapter!", appId);
        j ZD = a.ZD(appId);
        Log.i("MicroMsg.JsApiCloseBluetoothAdapter", "result:%s", ZD);
        switch (ZD.errCode) {
            case 0:
                fVar.i(i2, h("ok", null));
                c.pl(117);
                AppMethodBeat.o(144495);
                return;
            default:
                fVar.i(i2, h(ZD.errMsg, null));
                c.pl(118);
                AppMethodBeat.o(144495);
                return;
        }
    }
}
