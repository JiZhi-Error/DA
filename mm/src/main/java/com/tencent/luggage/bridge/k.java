package com.tencent.luggage.bridge;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class k {
    boolean csA;
    public String csB;
    public JSONObject csC;
    public JSONObject csi;
    String csu;
    public int csv;
    private boolean csw;
    private f csz;

    k(f fVar, m mVar, boolean z) {
        AppMethodBeat.i(140325);
        this.csz = fVar;
        JSONObject KX = mVar.KX();
        this.csu = KX.getString(FirebaseAnalytics.b.METHOD);
        this.csi = KX.optJSONObject("data");
        if (this.csi == null) {
            this.csi = new JSONObject("{}");
        }
        this.csA = z;
        this.csv = KX.optInt("callbackId", 0);
        this.csw = false;
        this.csC = new JSONObject();
        AppMethodBeat.o(140325);
    }

    public final void c(String str, JSONObject jSONObject) {
        AppMethodBeat.i(140326);
        if (str == null) {
            str = "";
        }
        this.csB = str;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.csC = jSONObject;
        if (this.csv != 0) {
            callback();
        }
        AppMethodBeat.o(140326);
    }

    public final void callback() {
        AppMethodBeat.i(140327);
        this.csz.a(KZ());
        AppMethodBeat.o(140327);
    }

    /* access modifiers changed from: package-private */
    public final e KZ() {
        AppMethodBeat.i(140328);
        c cVar = new c(this.csv, this.csB, this.csC, this.csw);
        AppMethodBeat.o(140328);
        return cVar;
    }
}
