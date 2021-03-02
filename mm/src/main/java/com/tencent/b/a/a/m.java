package com.tencent.b.a.a;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.b.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class m {
    protected Context context = null;
    private int dfV = 0;
    private JSONObject dfW = null;

    m(Context context2, JSONObject jSONObject) {
        AppMethodBeat.i(87661);
        this.context = context2;
        this.dfV = (int) (System.currentTimeMillis() / 1000);
        this.dfW = jSONObject;
        AppMethodBeat.o(87661);
    }

    /* access modifiers changed from: package-private */
    public final JSONObject toJSONObject() {
        AppMethodBeat.i(87662);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ky", "AVF4T76RVR81");
            jSONObject.put("et", 2);
            jSONObject.put("ts", this.dfV);
            jSONObject.put("si", this.dfV);
            s.a(jSONObject, "ui", s.bu(this.context));
            s.a(jSONObject, "mc", s.bv(this.context));
            String Ua = i.bq(this.context).Ua();
            if (s.eZ(Ua)) {
                jSONObject.put("mid", Ua);
            } else {
                jSONObject.put("mid", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            b bVar = new b(this.context);
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (b.dfv != null) {
                    b.a aVar = b.dfv;
                    jSONObject2.put("sr", String.valueOf(aVar.dfz.widthPixels) + "*" + aVar.dfz.heightPixels);
                    s.a(jSONObject2, "av", aVar.appVersion);
                    s.a(jSONObject2, "ch", aVar.dfC);
                    s.a(jSONObject2, "mf", aVar.dfB);
                    s.a(jSONObject2, "sv", aVar.dfy);
                    s.a(jSONObject2, "ov", Integer.toString(aVar.dfA));
                    jSONObject2.put("os", 1);
                    s.a(jSONObject2, "op", aVar.dfD);
                    s.a(jSONObject2, "lg", aVar.language);
                    s.a(jSONObject2, "md", aVar.model);
                    s.a(jSONObject2, "tz", aVar.timezone);
                    if (aVar.dfF != 0) {
                        jSONObject2.put("jb", aVar.dfF);
                    }
                    s.a(jSONObject2, "sd", aVar.dfE);
                    s.a(jSONObject2, "apn", aVar.packageName);
                    if (s.bt(aVar.ctx)) {
                        JSONObject jSONObject3 = new JSONObject();
                        s.a(jSONObject3, "bs", s.bw(aVar.ctx));
                        s.a(jSONObject3, "ss", s.bx(aVar.ctx));
                        if (jSONObject3.length() > 0) {
                            s.a(jSONObject2, "wf", jSONObject3.toString());
                        }
                    }
                    JSONArray by = s.by(aVar.ctx);
                    if (by != null && by.length() > 0) {
                        s.a(jSONObject2, "wflist", by.toString());
                    }
                    s.a(jSONObject2, "ram", aVar.dfG);
                    s.a(jSONObject2, "rom", aVar.dfH);
                    s.a(jSONObject2, "im", aVar.imsi);
                }
                s.a(jSONObject2, "cn", bVar.dfx);
                if (bVar.dfw != null) {
                    jSONObject2.put("tn", bVar.dfw);
                }
                jSONObject.put("ev", jSONObject2);
            } catch (Throwable th) {
                s.Ug();
            }
            if (this.dfW != null) {
                jSONObject.put("ext", this.dfW);
            }
        } catch (Throwable th2) {
            s.Ug();
        }
        AppMethodBeat.o(87662);
        return jSONObject;
    }
}
