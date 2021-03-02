package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¨\u0006\u0003"}, hxF = {"makeReturnJson", "", "apiName", "plugin-appbrand-integration_release"})
public final class d {
    static final String en(String str, String str2) {
        boolean z = false;
        AppMethodBeat.i(228833);
        try {
            String string = new JSONObject(str).getString("errMsg");
            p.g(string, "this.getString(\"errMsg\")");
            if (!n.J(string, str2 + ':', false)) {
                z = true;
            }
        } catch (JSONException e2) {
            z = true;
        }
        if (z) {
            String jSONObject = new JSONObject().put("errMsg", str2 + ':' + str).toString();
            p.g(jSONObject, "JSONObject().put(\"errMsg…ame}:${this}\").toString()");
            AppMethodBeat.o(228833);
            return jSONObject;
        }
        AppMethodBeat.o(228833);
        return str;
    }
}
