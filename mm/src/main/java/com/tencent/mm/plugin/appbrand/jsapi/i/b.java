package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class b extends bc implements a.b {
    private static final int CTRL_INDEX = 341;
    private static final String NAME = "onLocationChange";
    private final f lWU;

    b(f fVar) {
        this.lWU = fVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.b.a.b
    public final void a(int i2, String str, a.C0814a aVar) {
        AppMethodBeat.i(143626);
        if (i2 == -1) {
            Log.e("MicroMsg.AppBrand.EventOnLocationChange", "errCode:%d, errStr:%s", Integer.valueOf(i2), str);
            AppMethodBeat.o(143626);
            return;
        }
        HashMap hashMap = new HashMap(7);
        hashMap.put("longitude", Double.valueOf(aVar.longitude));
        hashMap.put("latitude", Double.valueOf(aVar.latitude));
        hashMap.put("speed", Double.valueOf(aVar.dxQ));
        hashMap.put("accuracy", Double.valueOf(aVar.ohZ));
        hashMap.put("altitude", Double.valueOf(aVar.altitude));
        hashMap.put("verticalAccuracy", Float.valueOf(0.0f));
        hashMap.put("horizontalAccuracy", Double.valueOf(aVar.ohZ));
        if (!Util.isNullOrNil(aVar.buildingId)) {
            hashMap.put("buildingId", aVar.buildingId);
            hashMap.put("floorName", aVar.floorName);
        }
        hashMap.put("provider", aVar.provider);
        hashMap.put("indoorLocationType", Integer.valueOf(aVar.oia));
        hashMap.put(TencentLocation.EXTRA_DIRECTION, Float.valueOf(aVar.oib));
        hashMap.put("steps", Double.valueOf(aVar.oic));
        String jSONObject = new JSONObject(hashMap).toString();
        Log.v("MicroMsg.AppBrand.EventOnLocationChange", "onLocationChanged %s, %s, %s", this.lWU.getAppId(), aVar.provider, jSONObject);
        synchronized (this) {
            try {
                h(this.lWU).Zh(jSONObject).bEo();
            } finally {
                AppMethodBeat.o(143626);
            }
        }
    }
}
