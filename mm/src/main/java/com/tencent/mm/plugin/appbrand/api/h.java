package com.tencent.mm.plugin.appbrand.api;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class h implements d {
    public float dTj;
    public String kHV;
    public float latitude;

    @Override // com.tencent.mm.plugin.appbrand.api.d
    public final String bua() {
        AppMethodBeat.i(153193);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("latitude", (double) this.latitude);
            jSONObject.put("longitude", (double) this.dTj);
            jSONObject.put("name", this.kHV);
            String jSONObject2 = new JSONObject().put(FirebaseAnalytics.b.LOCATION, jSONObject).toString();
            AppMethodBeat.o(153193);
            return jSONObject2;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.WeAppOpenPoiNativeExtraData", e2, "", new Object[0]);
            AppMethodBeat.o(153193);
            return "{}";
        }
    }
}
