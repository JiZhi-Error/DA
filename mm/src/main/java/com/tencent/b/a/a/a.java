package com.tencent.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class a {
    public static String dfr = "ts";
    public static String dfs = "times";
    public static String dft = "mfreq";
    public static String dfu = "mdays";
    long dfn = 0;
    int dfo = 0;
    int dfp = 100;
    int dfq = 3;

    a() {
    }

    a(String str) {
        AppMethodBeat.i(87622);
        if (!s.eY(str)) {
            AppMethodBeat.o(87622);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(dfr)) {
                this.dfn = jSONObject.getLong(dfr);
            }
            if (!jSONObject.isNull(dft)) {
                this.dfp = jSONObject.getInt(dft);
            }
            if (!jSONObject.isNull(dfs)) {
                this.dfo = jSONObject.getInt(dfs);
            }
            if (!jSONObject.isNull(dfu)) {
                this.dfq = jSONObject.getInt(dfu);
                AppMethodBeat.o(87622);
                return;
            }
        } catch (JSONException e2) {
            s.Ug();
        }
        AppMethodBeat.o(87622);
    }

    public final String toString() {
        AppMethodBeat.i(87623);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(dfr, this.dfn);
            jSONObject.put(dfs, this.dfo);
            jSONObject.put(dft, this.dfp);
            jSONObject.put(dfu, this.dfq);
        } catch (JSONException e2) {
            s.Ug();
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(87623);
        return jSONObject2;
    }
}
