package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d {
    private static final int CTRL_INDEX = 222;
    private static final String NAME = "stopBeaconDiscovery";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(144681);
        Log.i("MicroMsg.JsApiStopBeaconDiscovery", "stopBeaconDiscovery!");
        a.C0666a ZM = a.ZM(fVar.getAppId());
        if (ZM == null) {
            Log.e("MicroMsg.JsApiStopBeaconDiscovery", "beaconWorker is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 11004);
            fVar.i(i2, n("fail:not start", hashMap));
            AppMethodBeat.o(144681);
            return;
        }
        if (ZM.Qt()) {
            a.remove(fVar.getAppId());
            new HashMap().put("errCode", 0);
            fVar.i(i2, h("ok", null));
        } else {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 11004);
            fVar.i(i2, n("fail:not start", hashMap2));
        }
        a aVar = new a((byte) 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("available", a.lKK);
            jSONObject2.put("discovering", false);
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiStopBeaconDiscovery", "put JSON data error : %s", e2);
        }
        Log.i("MicroMsg.JsApiStopBeaconDiscovery", "OnBeaconServiceChangedEvent %s", jSONObject2.toString());
        aVar.b(fVar, fVar.getComponentId()).Zh(jSONObject2.toString()).bEo();
        AppMethodBeat.o(144681);
    }

    static class a extends bc {
        private static final int CTRL_INDEX = 225;
        private static final String NAME = "onBeaconServiceChanged";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
