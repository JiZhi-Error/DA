package com.tencent.mm.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.dqi;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u0016\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006\u001a0\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004\u001a<\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u000f\u001a\u00020\b2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004\u001a\u001c\u0010\u0012\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u001a\"\u0010\u0016\u001a\u00020\t2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010\u000f\u001a\u00020\u0006\u001a\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u0004\u0018\u00010\u001c¨\u0006\u001d"}, hxF = {"getKey", "", "originKey", "keyMap", "Ljava/util/HashMap;", "pbToJSON", "Lorg/json/JSONObject;", "originObj", "", "", "jsonObj", "pbToList", "Ljava/util/LinkedList;", "list", "pbToMap", "obj", "clazz", "Ljava/lang/Class;", "putListToJSON", "", "array", "Lorg/json/JSONArray;", "putMapToJSON", "map", "", "safePbToJSON", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "", "libktcomm_release"})
public final class g {
    public static final JSONObject bN(Object obj) {
        AppMethodBeat.i(168829);
        p.h(obj, "originObj");
        try {
            JSONObject jSONObject = new JSONObject();
            a(obj, jSONObject);
            AppMethodBeat.o(168829);
            return jSONObject;
        } catch (Exception e2) {
            JSONObject jSONObject2 = new JSONObject();
            AppMethodBeat.o(168829);
            return jSONObject2;
        }
    }

    public static final void a(Object obj, JSONObject jSONObject) {
        AppMethodBeat.i(168830);
        p.h(obj, "originObj");
        p.h(jSONObject, "jsonObj");
        a((Map<String, ? extends Object>) a(obj, obj.getClass(), null), jSONObject);
        AppMethodBeat.o(168830);
    }

    private static void a(Map<String, ? extends Object> map, JSONObject jSONObject) {
        AppMethodBeat.i(168831);
        p.h(map, "map");
        p.h(jSONObject, "obj");
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                JSONObject jSONObject2 = new JSONObject();
                a((Map<String, ? extends Object>) ((Map) value), jSONObject2);
                jSONObject.put(key, jSONObject2);
            } else if (value instanceof LinkedList) {
                JSONArray jSONArray = new JSONArray();
                a((LinkedList) value, jSONArray);
                jSONObject.put(key, jSONArray);
            } else if (value instanceof Long) {
                jSONObject.put(key, value.toString());
            } else {
                jSONObject.put(key, value);
            }
        }
        AppMethodBeat.o(168831);
    }

    private static void a(List<? extends Object> list, JSONArray jSONArray) {
        AppMethodBeat.i(168832);
        p.h(list, "list");
        p.h(jSONArray, "array");
        for (Object obj : list) {
            if (obj instanceof LinkedList) {
                JSONArray jSONArray2 = new JSONArray();
                a((List) obj, jSONArray2);
                jSONArray.put(jSONArray2);
            } else if (obj instanceof Map) {
                JSONObject jSONObject = new JSONObject();
                a((Map<String, ? extends Object>) ((Map) obj), jSONObject);
                jSONArray.put(jSONObject);
            } else {
                jSONArray.put(obj);
            }
        }
        AppMethodBeat.o(168832);
    }

    private static HashMap<String, Object> a(Object obj, Class<?> cls, HashMap<String, String> hashMap) {
        LinkedList<Object> a2;
        AppMethodBeat.i(168833);
        p.h(obj, "obj");
        p.h(cls, "clazz");
        HashMap<String, Object> hashMap2 = new HashMap<>();
        Field[] fields = cls.getFields();
        p.g(fields, "clazz.fields");
        for (Field field : fields) {
            try {
                Object obj2 = field.get(obj);
                if (obj2 != null) {
                    p.g(field, "field");
                    Class<?> type = field.getType();
                    p.g(type, "field.type");
                    if (type.isPrimitive() || (obj2 instanceof String)) {
                        String name = field.getName();
                        p.g(name, "field.name");
                        hashMap2.put(a(name, hashMap), obj2);
                    } else if (obj2 instanceof a) {
                        Class<?> type2 = field.getType();
                        p.g(type2, "field.type");
                        HashMap<String, Object> a3 = a(obj2, type2, hashMap);
                        String name2 = field.getName();
                        p.g(name2, "field.name");
                        hashMap2.put(a(name2, hashMap), a3);
                    } else if ((obj2 instanceof LinkedList) && (a2 = a((LinkedList) obj2, hashMap)) != null) {
                        String name3 = field.getName();
                        p.g(name3, "field.name");
                        hashMap2.put(a(name3, hashMap), a2);
                    }
                }
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(168833);
        return hashMap2;
    }

    private static String a(String str, HashMap<String, String> hashMap) {
        String str2;
        AppMethodBeat.i(168834);
        p.h(str, "originKey");
        if (hashMap == null || !hashMap.containsKey(str)) {
            str2 = str;
        } else {
            str2 = hashMap.get(str);
            if (str2 == null) {
                AppMethodBeat.o(168834);
                return "";
            }
        }
        AppMethodBeat.o(168834);
        return str2;
    }

    private static LinkedList<Object> a(LinkedList<?> linkedList, HashMap<String, String> hashMap) {
        Object obj;
        AppMethodBeat.i(168835);
        p.h(linkedList, "list");
        if (linkedList.size() > 0) {
            obj = linkedList.get(0);
        } else {
            obj = null;
        }
        if (obj == null) {
            p.hyc();
        }
        if (obj.getClass().isPrimitive() || (obj instanceof String)) {
            AppMethodBeat.o(168835);
            return linkedList;
        } else if (obj instanceof dqi) {
            LinkedList<Object> linkedList2 = new LinkedList<>();
            Iterator<?> it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(it.next().toString());
            }
            AppMethodBeat.o(168835);
            return linkedList2;
        } else if (obj instanceof a) {
            LinkedList<Object> linkedList3 = new LinkedList<>();
            Iterator<?> it2 = linkedList.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                p.g(next, "o");
                linkedList3.add(a(next, next.getClass(), hashMap));
            }
            AppMethodBeat.o(168835);
            return linkedList3;
        } else {
            AppMethodBeat.o(168835);
            return null;
        }
    }
}
