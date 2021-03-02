package com.tencent.luggage.bridge;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class g {
    private JSONObject csi;
    private String csu;
    int csv;
    boolean csw;

    g(m mVar) {
        AppMethodBeat.i(140323);
        JSONObject KX = mVar.KX();
        this.csu = KX.getString(FirebaseAnalytics.b.METHOD);
        this.csi = KX.optJSONObject("data");
        if (this.csi == null) {
            this.csi = new JSONObject();
        }
        this.csv = KX.optInt("callbackId", 0);
        this.csw = KX.optBoolean("keepCallback", false);
        AppMethodBeat.o(140323);
    }
}
