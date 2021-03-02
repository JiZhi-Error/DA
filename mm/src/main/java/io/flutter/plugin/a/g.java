package io.flutter.plugin.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g implements l {
    public static final g SSl = new g();

    static {
        AppMethodBeat.i(9879);
        AppMethodBeat.o(9879);
    }

    private g() {
    }

    @Override // io.flutter.plugin.a.l
    public final ByteBuffer b(j jVar) {
        AppMethodBeat.i(9874);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FirebaseAnalytics.b.METHOD, jVar.method);
            jSONObject.put("args", h.wrap(jVar.SxX));
            ByteBuffer eP = f.SSk.eP(jSONObject);
            AppMethodBeat.o(9874);
            return eP;
        } catch (JSONException e2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid JSON", e2);
            AppMethodBeat.o(9874);
            throw illegalArgumentException;
        }
    }

    @Override // io.flutter.plugin.a.l
    public final j K(ByteBuffer byteBuffer) {
        AppMethodBeat.i(9875);
        try {
            Object J = f.SSk.J(byteBuffer);
            if (J instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) J;
                Object obj = jSONObject.get(FirebaseAnalytics.b.METHOD);
                Object aF = aF(jSONObject.opt("args"));
                if (obj instanceof String) {
                    j jVar = new j((String) obj, aF);
                    AppMethodBeat.o(9875);
                    return jVar;
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid method call: ".concat(String.valueOf(J)));
            AppMethodBeat.o(9875);
            throw illegalArgumentException;
        } catch (JSONException e2) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Invalid JSON", e2);
            AppMethodBeat.o(9875);
            throw illegalArgumentException2;
        }
    }

    @Override // io.flutter.plugin.a.l
    public final ByteBuffer eQ(Object obj) {
        AppMethodBeat.i(9876);
        ByteBuffer eP = f.SSk.eP(new JSONArray().put(h.wrap(obj)));
        AppMethodBeat.o(9876);
        return eP;
    }

    @Override // io.flutter.plugin.a.l
    public final ByteBuffer h(String str, String str2, Object obj) {
        AppMethodBeat.i(9877);
        ByteBuffer eP = f.SSk.eP(new JSONArray().put(str).put(h.wrap(str2)).put(h.wrap(obj)));
        AppMethodBeat.o(9877);
        return eP;
    }

    @Override // io.flutter.plugin.a.l
    public final Object L(ByteBuffer byteBuffer) {
        AppMethodBeat.i(9878);
        try {
            Object J = f.SSk.J(byteBuffer);
            if (J instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) J;
                if (jSONArray.length() == 1) {
                    Object aF = aF(jSONArray.opt(0));
                    AppMethodBeat.o(9878);
                    return aF;
                } else if (jSONArray.length() == 3) {
                    Object obj = jSONArray.get(0);
                    Object aF2 = aF(jSONArray.opt(1));
                    Object aF3 = aF(jSONArray.opt(2));
                    if ((obj instanceof String) && (aF2 == null || (aF2 instanceof String))) {
                        e eVar = new e((String) obj, (String) aF2, aF3);
                        AppMethodBeat.o(9878);
                        throw eVar;
                    }
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid envelope: ".concat(String.valueOf(J)));
            AppMethodBeat.o(9878);
            throw illegalArgumentException;
        } catch (JSONException e2) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Invalid JSON", e2);
            AppMethodBeat.o(9878);
            throw illegalArgumentException2;
        }
    }

    private static Object aF(Object obj) {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj;
    }
}
