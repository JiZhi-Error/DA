package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h {
    public static Object wrap(Object obj) {
        AppMethodBeat.i(9836);
        if (obj == null) {
            Object obj2 = JSONObject.NULL;
            AppMethodBeat.o(9836);
            return obj2;
        } else if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
            AppMethodBeat.o(9836);
            return obj;
        } else if (obj.equals(JSONObject.NULL)) {
            AppMethodBeat.o(9836);
            return obj;
        } else {
            try {
                if (obj instanceof Collection) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object obj3 : (Collection) obj) {
                        jSONArray.put(wrap(obj3));
                    }
                    AppMethodBeat.o(9836);
                    return jSONArray;
                } else if (obj.getClass().isArray()) {
                    JSONArray jSONArray2 = new JSONArray();
                    int length = Array.getLength(obj);
                    for (int i2 = 0; i2 < length; i2++) {
                        jSONArray2.put(wrap(Array.get(obj, i2)));
                    }
                    AppMethodBeat.o(9836);
                    return jSONArray2;
                } else if (obj instanceof Map) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        jSONObject.put((String) entry.getKey(), wrap(entry.getValue()));
                    }
                    AppMethodBeat.o(9836);
                    return jSONObject;
                } else if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) {
                    AppMethodBeat.o(9836);
                    return obj;
                } else {
                    if (obj.getClass().getPackage().getName().startsWith("java.")) {
                        String obj4 = obj.toString();
                        AppMethodBeat.o(9836);
                        return obj4;
                    }
                    AppMethodBeat.o(9836);
                    return null;
                }
            } catch (Exception e2) {
            }
        }
    }
}
