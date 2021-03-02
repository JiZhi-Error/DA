package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.os.Bundle;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public class m<CONTEXT extends f> extends a<CONTEXT> {
    public static final int CTRL_INDEX = 37;
    public static final String NAME = "getLocation";

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.appbrand.jsapi.f */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.i.a
    public final /* bridge */ /* synthetic */ void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143634);
        super.a(fVar, jSONObject, i2);
        AppMethodBeat.o(143634);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.a
    public final void d(final CONTEXT context, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(143632);
        final String trim = Util.nullAsNil(jSONObject.optString("type", "wgs84")).trim();
        if (Util.isNullOrNil(trim)) {
            trim = "wgs84";
        }
        final boolean optBoolean = jSONObject.optBoolean("altitude", false);
        Log.i("MicroMsg.JsApiGetLocation", "getLocation data:%s", jSONObject);
        if (!"wgs84".equals(trim) && !"gcj02".equals(trim)) {
            Log.e("MicroMsg.JsApiGetLocation", "doGeoLocation fail, unsupported type = %s", trim);
            HashMap hashMap = new HashMap(1);
            hashMap.put("errCode", -1);
            context.i(i2, n("fail:invalid data", hashMap));
            AppMethodBeat.o(143632);
        } else if (!q(context)) {
            HashMap hashMap2 = new HashMap(1);
            hashMap2.put("errCode", -2);
            context.i(i2, n("fail:system permission denied", hashMap2));
            AppMethodBeat.o(143632);
        } else {
            s(context);
            Bundle g2 = g(context, jSONObject);
            a aVar = (a) context.M(a.class);
            if (aVar != null) {
                aVar.a(trim, new a.b() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.i.m.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.utils.b.a.b
                    public final void a(int i2, String str, a.C0814a aVar) {
                        AppMethodBeat.i(143631);
                        Log.i("MicroMsg.JsApiGetLocation", "errCode:%d, errStr:%s, location:%s", Integer.valueOf(i2), str, aVar);
                        m.this.bGF();
                        if (i2 == 0) {
                            HashMap hashMap = new HashMap(4);
                            hashMap.put("type", trim);
                            hashMap.put("latitude", Double.valueOf(aVar.latitude));
                            hashMap.put("longitude", Double.valueOf(aVar.longitude));
                            hashMap.put("speed", Double.valueOf(aVar.dxQ));
                            hashMap.put("accuracy", Double.valueOf(aVar.ohZ));
                            if (optBoolean) {
                                hashMap.put("altitude", Double.valueOf(aVar.altitude));
                            }
                            hashMap.put("provider", aVar.provider);
                            hashMap.put("verticalAccuracy", 0);
                            hashMap.put("horizontalAccuracy", Double.valueOf(aVar.ohZ));
                            if (!Util.isNullOrNil(aVar.buildingId)) {
                                hashMap.put("buildingId", aVar.buildingId);
                                hashMap.put("floorName", aVar.floorName);
                            }
                            hashMap.put("indoorLocationType", Integer.valueOf(aVar.oia));
                            hashMap.put(TencentLocation.EXTRA_DIRECTION, Float.valueOf(aVar.oib));
                            hashMap.put("steps", Double.valueOf(aVar.oic));
                            context.i(i2, m.this.n("ok", hashMap));
                            AppMethodBeat.o(143631);
                            return;
                        }
                        HashMap hashMap2 = new HashMap(1);
                        hashMap2.put("errCode", Integer.valueOf(i2));
                        context.i(i2, m.this.n("fail:".concat(String.valueOf(str)), hashMap2));
                        AppMethodBeat.o(143631);
                    }
                }, g2);
            }
            AppMethodBeat.o(143632);
        }
    }

    /* access modifiers changed from: protected */
    public Bundle g(CONTEXT context, JSONObject jSONObject) {
        AppMethodBeat.i(143633);
        Bundle bundle = new Bundle();
        boolean optBoolean = jSONObject.optBoolean("isHighAccuracy", false);
        int optInt = jSONObject.optInt("highAccuracyExpireTime", 3000);
        bundle.putBoolean("isHighAccuracy", optBoolean);
        bundle.putInt("highAccuracyExpireTime", optInt);
        AppMethodBeat.o(143633);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void s(CONTEXT context) {
    }

    /* access modifiers changed from: protected */
    public void bGF() {
    }
}
