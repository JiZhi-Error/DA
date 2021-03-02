package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends d {
    private static final int CTRL_INDEX = 223;
    private static final String NAME = "getBeacons";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(144674);
        Log.d("MicroMsg.JsApiGetBeacons", "getBeacons!");
        JSONArray jSONArray = new JSONArray();
        a.C0666a ZM = a.ZM(fVar.getAppId());
        if (ZM != null) {
            Map<String, JSONObject> map = ZM.lWk;
            Log.d("MicroMsg.JsApiGetBeacons", "getBeaconInfo, beaconInfos: ".concat(String.valueOf(map)));
            if (map != null && map.size() > 0) {
                for (JSONObject jSONObject2 : map.values()) {
                    jSONArray.put(jSONObject2);
                }
            }
        } else {
            Log.e("MicroMsg.JsApiGetBeacons", "not found device");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("beacons", jSONArray);
        fVar.i(i2, n("ok", hashMap));
        AppMethodBeat.o(144674);
    }
}
