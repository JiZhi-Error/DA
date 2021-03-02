package com.tencent.mm.plugin.appbrand.jsapi.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public static final String a(String str, int i2, JSONObject jSONObject) {
        AppMethodBeat.i(163912);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("errMsg", str);
            jSONObject2.put("errCode", i2);
            jSONObject2.put("data", jSONObject);
        } catch (Exception e2) {
        }
        String jSONObject3 = jSONObject2.toString();
        AppMethodBeat.o(163912);
        return jSONObject3;
    }

    public static final String a(String str, int i2, JSONArray jSONArray) {
        AppMethodBeat.i(163913);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errMsg", str);
            jSONObject.put("errCode", i2);
            jSONObject.put("data", jSONArray);
        } catch (Exception e2) {
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(163913);
        return jSONObject2;
    }

    public static final void a(Object obj, JSONObject jSONObject) {
        AppMethodBeat.i(163914);
        g.a(obj, jSONObject);
        AppMethodBeat.o(163914);
    }

    private static void b(Object obj, JSONObject jSONObject) {
        AppMethodBeat.i(163915);
        Field[] fields = obj.getClass().getFields();
        for (Field field : fields) {
            try {
                Object obj2 = field.get(obj);
                if (obj2 != null) {
                    if (field.getType().isPrimitive() || (obj2 instanceof String)) {
                        jSONObject.put(field.getName(), obj2);
                    } else if (obj2 instanceof List) {
                        JSONArray jSONArray = new JSONArray();
                        b((List) obj2, jSONArray);
                        jSONObject.put(field.getName(), jSONArray);
                    } else {
                        JSONObject jSONObject2 = new JSONObject();
                        b(obj2, jSONObject2);
                        jSONObject.put(field.getName(), jSONObject2);
                    }
                }
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(163915);
    }

    public static final void b(List<? extends Object> list, JSONArray jSONArray) {
        AppMethodBeat.i(163916);
        for (Object obj : list) {
            if (obj.getClass().isPrimitive() || (obj instanceof String)) {
                jSONArray.put(obj);
            } else if (obj instanceof List) {
                JSONArray jSONArray2 = new JSONArray();
                b((List) obj, jSONArray2);
                jSONArray.put(jSONArray2);
            } else {
                JSONObject jSONObject = new JSONObject();
                b(obj, jSONObject);
                jSONArray.put(jSONObject);
            }
        }
        AppMethodBeat.o(163916);
    }

    public static final <T> T a(JSONObject jSONObject, Class<T> cls) {
        AppMethodBeat.i(163917);
        try {
            T newInstance = cls.newInstance();
            Iterator<String> keys = jSONObject.keys();
            while (keys != null && keys.hasNext()) {
                try {
                    String next = keys.next();
                    Field field = cls.getField(next);
                    if (field != null) {
                        Object obj = jSONObject.get(next);
                        if (obj instanceof JSONObject) {
                            field.set(newInstance, a((JSONObject) obj, field.getType()));
                        } else if (obj instanceof JSONArray) {
                            JSONArray jSONArray = (JSONArray) obj;
                            LinkedList linkedList = new LinkedList();
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                Object obj2 = jSONArray.get(i2);
                                if (obj2 instanceof JSONObject) {
                                    linkedList.add(a((JSONObject) obj2, obj2.getClass()));
                                } else {
                                    linkedList.add(obj2);
                                }
                            }
                            field.set(newInstance, linkedList);
                        } else {
                            field.set(newInstance, obj);
                        }
                    }
                } catch (Exception e2) {
                }
            }
            AppMethodBeat.o(163917);
            return newInstance;
        } catch (Exception e3) {
            AppMethodBeat.o(163917);
            return null;
        }
    }
}
