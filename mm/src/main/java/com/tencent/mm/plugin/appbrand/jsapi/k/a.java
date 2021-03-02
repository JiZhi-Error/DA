package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static void a(b bVar, JSONObject jSONObject) {
        AppMethodBeat.i(234539);
        b.ad adVar = bVar.bGU().mbe;
        if (adVar == null) {
            Log.e("MicroMsg.AppBrandMapUtils", "visibleRegion is  null");
        }
        b.j jVar = adVar.mbf;
        if (jVar == null) {
            Log.e("MicroMsg.AppBrandMapUtils", "latLngBounds is  null");
        }
        b.i iVar = jVar.maE;
        b.i iVar2 = jVar.maF;
        JSONObject jSONObject2 = new JSONObject();
        if (iVar != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("latitude", iVar.latitude);
                jSONObject3.put("longitude", iVar.longitude);
                jSONObject2.put("southwest", jSONObject3);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandMapUtils", e2, "", new Object[0]);
                AppMethodBeat.o(234539);
                return;
            }
        }
        if (iVar2 != null) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("latitude", iVar2.latitude);
            jSONObject4.put("longitude", iVar2.longitude);
            jSONObject2.put("northeast", jSONObject4);
        }
        jSONObject.remove("region");
        jSONObject.put("region", jSONObject2);
        AppMethodBeat.o(234539);
    }

    public static void b(b bVar, JSONObject jSONObject) {
        AppMethodBeat.i(234540);
        b.i bGY = bVar.bGY();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("latitude", bGY.latitude);
            jSONObject2.put("longitude", bGY.longitude);
            jSONObject.remove("centerLocation");
            jSONObject.put("centerLocation", jSONObject2);
            AppMethodBeat.o(234540);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandMapUtils", e2, "", new Object[0]);
            AppMethodBeat.o(234540);
        }
    }
}
