package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    public Map<String, a> lav = new HashMap();

    public static class a {
        public static e law = new e();

        static {
            AppMethodBeat.i(145359);
            AppMethodBeat.o(145359);
        }
    }

    public e() {
        AppMethodBeat.i(145360);
        a(new h());
        a(new f());
        a(new g());
        a(new i());
        a(new d());
        a(new b());
        a(new c());
        a(new j());
        AppMethodBeat.o(145360);
    }

    public final Path a(PathActionArgWrapper pathActionArgWrapper) {
        AppMethodBeat.i(145361);
        Path path = new Path();
        List<BasePathActionArg> list = pathActionArgWrapper.kZW;
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(145361);
            return path;
        }
        for (BasePathActionArg basePathActionArg : list) {
            if (basePathActionArg != null) {
                b(path, basePathActionArg);
            }
        }
        AppMethodBeat.o(145361);
        return path;
    }

    private boolean b(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(145362);
        a aVar = this.lav.get(basePathActionArg.method);
        if (aVar == null) {
            AppMethodBeat.o(145362);
            return false;
        }
        boolean a2 = aVar.a(path, basePathActionArg);
        AppMethodBeat.o(145362);
        return a2;
    }

    public final Path g(JSONArray jSONArray) {
        AppMethodBeat.i(145363);
        Path path = new Path();
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(145363);
            return path;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                a(path, optJSONObject);
            }
        }
        AppMethodBeat.o(145363);
        return path;
    }

    private boolean a(Path path, JSONObject jSONObject) {
        AppMethodBeat.i(145364);
        String optString = jSONObject.optString(FirebaseAnalytics.b.METHOD);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        a aVar = this.lav.get(optString);
        if (aVar == null) {
            AppMethodBeat.o(145364);
            return false;
        }
        boolean a2 = aVar.a(path, optJSONArray);
        AppMethodBeat.o(145364);
        return a2;
    }

    private void a(a aVar) {
        AppMethodBeat.i(145365);
        this.lav.put(aVar.getMethod(), aVar);
        AppMethodBeat.o(145365);
    }
}
