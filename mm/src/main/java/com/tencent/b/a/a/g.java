package com.tencent.b.a.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class g {
    String ckt = null;
    String dfJ = null;
    String dfK = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    long dfL = 0;

    g() {
    }

    static g eX(String str) {
        AppMethodBeat.i(87657);
        g gVar = new g();
        if (s.eY(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    gVar.ckt = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    gVar.dfJ = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    gVar.dfK = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    gVar.dfL = jSONObject.getLong("ts");
                }
            } catch (JSONException e2) {
                s.Ug();
            }
        }
        AppMethodBeat.o(87657);
        return gVar;
    }

    /* access modifiers changed from: package-private */
    public final int a(g gVar) {
        AppMethodBeat.i(87658);
        if (gVar == null) {
            AppMethodBeat.o(87658);
            return 1;
        } else if (!s.eZ(this.dfK) || !s.eZ(gVar.dfK)) {
            if (s.eZ(this.dfK)) {
                AppMethodBeat.o(87658);
                return 1;
            }
            AppMethodBeat.o(87658);
            return -1;
        } else if (this.dfK.equals(gVar.dfK)) {
            AppMethodBeat.o(87658);
            return 0;
        } else if (this.dfL >= gVar.dfL) {
            AppMethodBeat.o(87658);
            return 1;
        } else {
            AppMethodBeat.o(87658);
            return -1;
        }
    }

    public final String toString() {
        AppMethodBeat.i(87659);
        String jSONObject = TY().toString();
        AppMethodBeat.o(87659);
        return jSONObject;
    }

    private JSONObject TY() {
        AppMethodBeat.i(87660);
        JSONObject jSONObject = new JSONObject();
        try {
            s.a(jSONObject, "ui", this.ckt);
            s.a(jSONObject, "mc", this.dfJ);
            s.a(jSONObject, "mid", this.dfK);
            jSONObject.put("ts", this.dfL);
        } catch (JSONException e2) {
            s.Ug();
        }
        AppMethodBeat.o(87660);
        return jSONObject;
    }
}
