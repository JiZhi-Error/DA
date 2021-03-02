package com.tencent.map.tools.json;

import android.text.TextUtils;
import com.tencent.map.tools.Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {
    public static <T> List<T> parseToList(JSONArray jSONArray, Class<T> cls, Object... objArr) {
        AppMethodBeat.i(180912);
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(parseToModel(jSONArray.optJSONObject(i2), cls, objArr));
            }
        }
        AppMethodBeat.o(180912);
        return arrayList;
    }

    public static <C extends Collection> C parseTo(Class<C> cls, JSONArray jSONArray, Class cls2, Object... objArr) {
        AppMethodBeat.i(180913);
        C c2 = (C) ((Collection) Util.newInstance(cls, new Object[0]));
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                Object opt = jSONArray.opt(i2);
                if (opt instanceof JSONArray) {
                    c2.add(parseTo(cls, (JSONArray) opt, cls2, objArr));
                } else if (opt instanceof JSONObject) {
                    c2.add(parseToModel((JSONObject) opt, cls2, objArr));
                } else if (opt.getClass() == cls2) {
                    c2.add(opt);
                }
            }
        }
        AppMethodBeat.o(180913);
        return c2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        if (r2 != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T parseToModel(org.json.JSONObject r5, java.lang.Class<T> r6, java.lang.Object... r7) {
        /*
            r1 = 0
            r4 = 180914(0x2c2b2, float:2.53515E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.lang.Class<com.tencent.map.tools.json.annotation.JsonType> r0 = com.tencent.map.tools.json.annotation.JsonType.class
            java.lang.annotation.Annotation r0 = r6.getAnnotation(r0)
            com.tencent.map.tools.json.annotation.JsonType r0 = (com.tencent.map.tools.json.annotation.JsonType) r0
            if (r0 == 0) goto L_0x0037
            java.lang.Class r0 = r0.deserializer()
            java.lang.Class<com.tencent.map.tools.json.JsonParser$Deserializer> r2 = com.tencent.map.tools.json.JsonParser.Deserializer.class
            if (r0 == r2) goto L_0x0037
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Object r0 = com.tencent.map.tools.Util.newInstance(r0, r2)
            com.tencent.map.tools.json.JsonParser$Deserializer r0 = (com.tencent.map.tools.json.JsonParser.Deserializer) r0
            r2 = 0
            java.lang.String r3 = ""
            java.lang.Object r0 = r0.deserialize(r2, r3, r5)     // Catch:{ JSONException -> 0x004b }
            if (r0 == 0) goto L_0x004d
            java.lang.Class r2 = r0.getClass()     // Catch:{ JSONException -> 0x004b }
            boolean r2 = r6.isAssignableFrom(r2)     // Catch:{ JSONException -> 0x004b }
            if (r2 == 0) goto L_0x004d
        L_0x0036:
            r1 = r0
        L_0x0037:
            if (r1 != 0) goto L_0x003d
            java.lang.Object r1 = com.tencent.map.tools.Util.newInstance(r6, r7)
        L_0x003d:
            boolean r0 = r1 instanceof com.tencent.map.tools.json.JsonParser
            if (r0 == 0) goto L_0x0047
            r0 = r1
            com.tencent.map.tools.json.JsonParser r0 = (com.tencent.map.tools.json.JsonParser) r0
            r0.parse(r5)
        L_0x0047:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r1
        L_0x004b:
            r0 = move-exception
            goto L_0x0037
        L_0x004d:
            r0 = r1
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.tools.json.JsonUtils.parseToModel(org.json.JSONObject, java.lang.Class, java.lang.Object[]):java.lang.Object");
    }

    public static <T> T parseToModel(String str, Class<T> cls, Object... objArr) {
        T t = null;
        AppMethodBeat.i(180915);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(180915);
        } else {
            try {
                t = (T) parseToModel(new JSONObject(str), cls, objArr);
                AppMethodBeat.o(180915);
            } catch (JSONException e2) {
                AppMethodBeat.o(180915);
            }
        }
        return t;
    }

    public static <T> String modelToJsonString(T t) {
        AppMethodBeat.i(180916);
        JSONObject modelToJson = modelToJson(t);
        if (modelToJson != null) {
            String jSONObject = modelToJson.toString();
            AppMethodBeat.o(180916);
            return jSONObject;
        }
        AppMethodBeat.o(180916);
        return null;
    }

    public static <T> JSONObject modelToJson(T t) {
        AppMethodBeat.i(180917);
        if (t instanceof JsonEncoder) {
            JSONObject json = t.toJson();
            AppMethodBeat.o(180917);
            return json;
        }
        AppMethodBeat.o(180917);
        return null;
    }

    public static <T> String collectionToJson(Collection<T> collection) {
        AppMethodBeat.i(180918);
        if (collection == null || collection.isEmpty()) {
            AppMethodBeat.o(180918);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (T t : collection) {
            if (t instanceof JsonEncoder) {
                jSONArray.put(t.toJson());
            } else {
                jSONArray.put((Object) null);
            }
        }
        String jSONArray2 = jSONArray.toString();
        AppMethodBeat.o(180918);
        return jSONArray2;
    }

    public static Object parseToArray(JSONArray jSONArray, Class cls) {
        AppMethodBeat.i(180919);
        if (jSONArray == null) {
            AppMethodBeat.o(180919);
            return null;
        }
        int length = jSONArray.length();
        Object newInstance = Array.newInstance(cls, length);
        for (int i2 = 0; i2 < length; i2++) {
            try {
                Array.set(newInstance, i2, jSONArray.get(i2));
            } catch (JSONException e2) {
            }
        }
        AppMethodBeat.o(180919);
        return newInstance;
    }
}
