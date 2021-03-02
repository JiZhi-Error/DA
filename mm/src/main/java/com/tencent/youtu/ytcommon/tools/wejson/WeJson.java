package com.tencent.youtu.ytcommon.tools.wejson;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeJson {
    private static final String EMPTY_ARR = "[]";
    private static final String EMPTY_MAP = "{}";

    public <T> String toJson(T t) {
        AppMethodBeat.i(73409);
        String json = toJson(t, 0);
        AppMethodBeat.o(73409);
        return json;
    }

    public <T> String toJson(T t, int i2) {
        AppMethodBeat.i(73410);
        if (t == null) {
            AppMethodBeat.o(73410);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        process(sb, t);
        String sb2 = sb.toString();
        AppMethodBeat.o(73410);
        return sb2;
    }

    private <T> void process(StringBuilder sb, T t) {
        AppMethodBeat.i(73411);
        if (t.getClass().isPrimitive()) {
            sb.append((Object) t);
            AppMethodBeat.o(73411);
        } else if (t instanceof String) {
            sb.append('\"').append(getValidStr(t)).append('\"');
            AppMethodBeat.o(73411);
        } else if (isPrimitivePackageType(t)) {
            sb.append((Object) t);
            AppMethodBeat.o(73411);
        } else if (t.getClass().isArray()) {
            processArr(sb, (Object[]) t);
            AppMethodBeat.o(73411);
        } else if (t instanceof Iterable) {
            processIterable(sb, t);
            AppMethodBeat.o(73411);
        } else if (t instanceof Map) {
            processMap(sb, t);
            AppMethodBeat.o(73411);
        } else {
            processObj(sb, t);
            AppMethodBeat.o(73411);
        }
    }

    private String getValidStr(String str) {
        AppMethodBeat.i(73412);
        String replace = str.replace("\"", "\\\"").replace("\\", "\\\\").replace("\b", "\\b").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f").replace("\t", "\\t");
        AppMethodBeat.o(73412);
        return replace;
    }

    private <T> boolean isPrimitivePackageType(T t) {
        return (t instanceof Integer) || (t instanceof Short) || (t instanceof Long) || (t instanceof Byte) || (t instanceof Boolean) || (t instanceof Float) || (t instanceof Double) || (t instanceof Character);
    }

    private void processMap(StringBuilder sb, Map<String, Object> map) {
        AppMethodBeat.i(73413);
        if (map.size() == 0) {
            sb.append(EMPTY_MAP);
            AppMethodBeat.o(73413);
            return;
        }
        sb.append('{');
        int size = map.size();
        int i2 = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (!(key == null || key.equals("") || value == null)) {
                if (!(value instanceof String) || !entry.equals("")) {
                    sb.append('\"').append(key).append('\"');
                    sb.append(':');
                    process(sb, value);
                    if (i2 < size - 1) {
                        sb.append(',');
                    }
                    i2++;
                }
            }
        }
        sb.append('}');
        AppMethodBeat.o(73413);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.tencent.youtu.ytcommon.tools.wejson.WeJson */
    /* JADX WARN: Multi-variable type inference failed */
    private <T> void processObj(StringBuilder sb, T t) {
        String substring;
        Object invoke;
        int i2 = 0;
        AppMethodBeat.i(73414);
        Field[] declaredFields = t.getClass().getDeclaredFields();
        Field[] declaredFields2 = t.getClass().getSuperclass().getDeclaredFields();
        Field[] fieldArr = new Field[(declaredFields.length + declaredFields2.length)];
        for (int i3 = 0; i3 < declaredFields.length; i3++) {
            fieldArr[i3] = declaredFields[i3];
        }
        for (int length = declaredFields.length; length < fieldArr.length; length++) {
            fieldArr[length] = declaredFields2[length - declaredFields.length];
        }
        if (fieldArr.length == 0) {
            sb.append(EMPTY_MAP);
            AppMethodBeat.o(73414);
            return;
        }
        HashMap hashMap = new HashMap();
        for (Field field : fieldArr) {
            try {
                int modifiers = field.getModifiers();
                if ((modifiers & 8) == 0) {
                    String name = field.getName();
                    if (!name.contains("$")) {
                        if ((modifiers & 1) != 0) {
                            Object obj = field.get(t);
                            if (obj != null) {
                                hashMap.put(name, obj);
                            }
                        } else {
                            Class<?> cls = t.getClass();
                            StringBuilder append = new StringBuilder("get").append(name.substring(0, 1).toUpperCase());
                            if (name.length() == 1) {
                                substring = "";
                            } else {
                                substring = name.substring(1);
                            }
                            Method method = cls.getMethod(append.append(substring).toString(), new Class[0]);
                            if (!(method == null || (invoke = method.invoke(t, new Object[0])) == null)) {
                                hashMap.put(name, invoke);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
            }
        }
        sb.append('{');
        int size = hashMap.size();
        for (Map.Entry entry : hashMap.entrySet()) {
            int i4 = i2 + 1;
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (!(value instanceof String) || !value.equals("")) {
                sb.append('\"').append(str).append('\"').append(':');
                process(sb, value);
                if (i4 < size) {
                    sb.append(',');
                }
                i2 = i4;
            } else {
                i2 = i4;
            }
        }
        sb.append('}');
        AppMethodBeat.o(73414);
    }

    private void processIterable(StringBuilder sb, Iterable iterable) {
        AppMethodBeat.i(73415);
        sb.append('[');
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            process(sb, obj);
            sb.append(',');
        }
        if (i2 > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(']');
        AppMethodBeat.o(73415);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.tencent.youtu.ytcommon.tools.wejson.WeJson */
    /* JADX WARN: Multi-variable type inference failed */
    private <T> void processArr(StringBuilder sb, Object[] objArr) {
        AppMethodBeat.i(73416);
        if (objArr.length == 0) {
            sb.append(EMPTY_ARR);
            AppMethodBeat.o(73416);
            return;
        }
        sb.append('[');
        for (int i2 = 0; i2 < objArr.length; i2++) {
            process(sb, objArr[i2]);
            if (i2 < objArr.length - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        AppMethodBeat.o(73416);
    }

    public <T> T fromJson(String str, Class<T> cls) {
        T t = null;
        AppMethodBeat.i(73417);
        if (str == null) {
            AppMethodBeat.o(73417);
        } else if (cls == null) {
            WeJsonException weJsonException = new WeJsonException("必须指定classOfT");
            AppMethodBeat.o(73417);
            throw weJsonException;
        } else {
            String trim = str.trim();
            if (trim.startsWith("[")) {
                try {
                    t = (T) fromJsonArr(new JSONArray(trim), cls, null);
                    if (t != null) {
                        AppMethodBeat.o(73417);
                    }
                } catch (Exception e2) {
                    WeJsonException weJsonException2 = new WeJsonException("json 解析错误" + e2.getMessage(), e2);
                    AppMethodBeat.o(73417);
                    throw weJsonException2;
                }
            } else if (trim.startsWith("{")) {
                try {
                    t = (T) fromJsonObj(new JSONObject(trim), cls, null);
                    AppMethodBeat.o(73417);
                } catch (Exception e3) {
                    WeJsonException weJsonException3 = new WeJsonException("json 解析错误:" + e3.getMessage(), e3);
                    AppMethodBeat.o(73417);
                    throw weJsonException3;
                }
            }
            WeJsonException weJsonException4 = new WeJsonException("classOfT 指定错误");
            AppMethodBeat.o(73417);
            throw weJsonException4;
        }
        return t;
    }

    private <T> T fromJsonArr(JSONArray jSONArray, Class<T> cls, Class<?> cls2) {
        AppMethodBeat.i(73418);
        if (cls.equals(List.class)) {
            T t = (T) fromList(jSONArray, cls, cls2);
            AppMethodBeat.o(73418);
            return t;
        } else if (cls.isArray()) {
            T t2 = (T) fromArr(jSONArray, cls);
            AppMethodBeat.o(73418);
            return t2;
        } else {
            WeJsonException weJsonException = new WeJsonException("json 解析错误:不支持的类型:" + cls.getName());
            AppMethodBeat.o(73418);
            throw weJsonException;
        }
    }

    private <T> T fromJsonObj(JSONObject jSONObject, Class<T> cls, Class<?> cls2) {
        AppMethodBeat.i(73419);
        if (cls.equals(Map.class)) {
            T t = (T) fromMap(jSONObject, cls, cls2);
            AppMethodBeat.o(73419);
            return t;
        }
        T t2 = (T) fromPojo(jSONObject, cls);
        AppMethodBeat.o(73419);
        return t2;
    }

    private List fromList(JSONArray jSONArray, Class<List> cls, Class<?> cls2) {
        ArrayList newInstance;
        AppMethodBeat.i(73420);
        if (cls2 == null) {
            WeJsonException weJsonException = new WeJsonException("无法确定列表项的类型");
            AppMethodBeat.o(73420);
            throw weJsonException;
        }
        if (cls.getName().equals("java.util.List")) {
            newInstance = new ArrayList();
        } else {
            try {
                newInstance = cls.newInstance();
            } catch (Exception e2) {
                WeJsonException weJsonException2 = new WeJsonException("创建List类型失败,该列表不支持无参实例化", e2);
                AppMethodBeat.o(73420);
                throw weJsonException2;
            }
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            Object object = getObject(jSONArray, i2);
            if (object instanceof JSONArray) {
                newInstance.add(fromJsonArr((JSONArray) object, cls, cls2));
            } else if (object instanceof JSONObject) {
                newInstance.add(fromJsonObj((JSONObject) object, cls, cls2));
            } else {
                newInstance.add(object);
            }
        }
        AppMethodBeat.o(73420);
        return newInstance;
    }

    private Map fromMap(JSONObject jSONObject, Class<Map> cls, Class<?> cls2) {
        HashMap newInstance;
        AppMethodBeat.i(73421);
        if (cls2 == null) {
            WeJsonException weJsonException = new WeJsonException("无法确定列表项的类型");
            AppMethodBeat.o(73421);
            throw weJsonException;
        }
        if (cls.getName().equals("java.util.Map")) {
            newInstance = new HashMap();
        } else {
            try {
                newInstance = cls.newInstance();
            } catch (Exception e2) {
                WeJsonException weJsonException2 = new WeJsonException("创建Map类型失败,该Map不支持无参实例化", e2);
                AppMethodBeat.o(73421);
                throw weJsonException2;
            }
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object object = getObject(jSONObject, next);
            if (object != null) {
                newInstance.put(next, fromJsonData(object, cls, cls2));
            } else {
                newInstance.put(next, null);
            }
        }
        AppMethodBeat.o(73421);
        return newInstance;
    }

    private Object getObject(JSONArray jSONArray, int i2) {
        AppMethodBeat.i(73422);
        try {
            Object obj = jSONArray.get(i2);
            AppMethodBeat.o(73422);
            return obj;
        } catch (JSONException e2) {
            WeJsonException weJsonException = new WeJsonException("JSONArray.get() cause JSONException", e2);
            AppMethodBeat.o(73422);
            throw weJsonException;
        }
    }

    private Object getObject(JSONObject jSONObject, String str) {
        AppMethodBeat.i(73423);
        try {
            Object obj = jSONObject.get(str);
            AppMethodBeat.o(73423);
            return obj;
        } catch (JSONException e2) {
            WeJsonException weJsonException = new WeJsonException("JSONObject.get() cause JSONException", e2);
            AppMethodBeat.o(73423);
            throw weJsonException;
        }
    }

    private Object fromJsonData(Object obj, Class<?> cls, Class<?> cls2) {
        AppMethodBeat.i(73424);
        if (obj instanceof JSONArray) {
            Object fromJsonArr = fromJsonArr((JSONArray) obj, cls, cls2);
            AppMethodBeat.o(73424);
            return fromJsonArr;
        } else if (obj instanceof JSONObject) {
            Object fromJsonObj = fromJsonObj((JSONObject) obj, cls, cls2);
            AppMethodBeat.o(73424);
            return fromJsonObj;
        } else {
            AppMethodBeat.o(73424);
            return obj;
        }
    }

    private <T> T fromArr(JSONArray jSONArray, Class<T> cls) {
        AppMethodBeat.i(73425);
        Class<?> componentType = cls.getComponentType();
        T t = (T) Array.newInstance(componentType, jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            Array.set(t, i2, fromJsonData(getObject(jSONArray, i2), componentType, componentType));
        }
        AppMethodBeat.o(73425);
        return t;
    }

    private <T> T fromPojo(JSONObject jSONObject, Class<T> cls) {
        AppMethodBeat.i(73426);
        Field[] declaredFields = cls.getDeclaredFields();
        Class<? super T> superclass = cls.getSuperclass();
        Field[] fieldArr = new Field[0];
        if (superclass != null) {
            fieldArr = superclass.getDeclaredFields();
        }
        Field[] fieldArr2 = new Field[(declaredFields.length + fieldArr.length)];
        for (int i2 = 0; i2 < declaredFields.length; i2++) {
            fieldArr2[i2] = declaredFields[i2];
        }
        for (int length = declaredFields.length; length < fieldArr2.length; length++) {
            fieldArr2[length] = fieldArr[length - declaredFields.length];
        }
        if (fieldArr2.length == 0) {
            AppMethodBeat.o(73426);
            return null;
        }
        try {
            T newInstance = cls.newInstance();
            for (Field field : fieldArr2) {
                String name = field.getName();
                if (!name.contains("$")) {
                    int modifiers = field.getModifiers();
                    Object opt = jSONObject.opt(name);
                    if (opt != null) {
                        Object fromJsonData = fromJsonData(opt, getMemberType(cls, field), getSubType(cls, field, opt));
                        Object obj = JSONObject.NULL.equals(fromJsonData) ? null : fromJsonData;
                        if ((modifiers & 1) != 0) {
                            try {
                                field.set(newInstance, obj);
                            } catch (IllegalAccessException e2) {
                                WeJsonException weJsonException = new WeJsonException("设置成员变量值失败.", e2);
                                AppMethodBeat.o(73426);
                                throw weJsonException;
                            }
                        } else {
                            try {
                                try {
                                    cls.getMethod("set" + name.substring(0, 1).toUpperCase() + (name.length() == 1 ? "" : name.substring(1)), field.getType()).invoke(newInstance, obj);
                                } catch (Exception e3) {
                                    WeJsonException weJsonException2 = new WeJsonException("调用set方法失败.", e3);
                                    AppMethodBeat.o(73426);
                                    throw weJsonException2;
                                }
                            } catch (NoSuchMethodException e4) {
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(73426);
            return newInstance;
        } catch (Exception e5) {
            WeJsonException weJsonException3 = new WeJsonException("必须为该类型提供一个无参构造方法:" + cls.getName(), e5);
            AppMethodBeat.o(73426);
            throw weJsonException3;
        }
    }

    private <T> Class<?> getMemberType(Class<T> cls, Field field) {
        AppMethodBeat.i(73427);
        if (field.getGenericType() instanceof TypeVariable) {
            cls.getTypeParameters();
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                if (type instanceof Class) {
                    Class<?> cls2 = (Class) type;
                    AppMethodBeat.o(73427);
                    return cls2;
                }
                WeJsonException weJsonException = new WeJsonException("不支持嵌套泛型");
                AppMethodBeat.o(73427);
                throw weJsonException;
            }
            WeJsonException weJsonException2 = new WeJsonException("缺少泛型信息:".concat(String.valueOf(cls)));
            AppMethodBeat.o(73427);
            throw weJsonException2;
        }
        Class<?> type2 = field.getType();
        AppMethodBeat.o(73427);
        return type2;
    }

    private <T> Class<?> getSubType(Class<T> cls, Field field, Object obj) {
        AppMethodBeat.i(73428);
        if (field.getGenericType() instanceof TypeVariable) {
            cls.getTypeParameters();
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                if (type instanceof Class) {
                    Class<?> cls2 = (Class) type;
                    AppMethodBeat.o(73428);
                    return cls2;
                }
                WeJsonException weJsonException = new WeJsonException("不支持嵌套泛型");
                AppMethodBeat.o(73428);
                throw weJsonException;
            }
            WeJsonException weJsonException2 = new WeJsonException("缺少泛型信息:".concat(String.valueOf(cls)));
            AppMethodBeat.o(73428);
            throw weJsonException2;
        } else if (field.getType().equals(List.class)) {
            Type genericType = field.getGenericType();
            if (genericType instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) genericType).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    Class<?> cls3 = (Class) type2;
                    AppMethodBeat.o(73428);
                    return cls3;
                }
                WeJsonException weJsonException3 = new WeJsonException("不支持嵌套泛型:" + field.getName());
                AppMethodBeat.o(73428);
                throw weJsonException3;
            }
            WeJsonException weJsonException4 = new WeJsonException("缺少泛型类型声明:" + field.getName());
            AppMethodBeat.o(73428);
            throw weJsonException4;
        } else if (field.getType().equals(Map.class)) {
            Type genericType2 = field.getGenericType();
            if (genericType2 instanceof ParameterizedType) {
                Type type3 = ((ParameterizedType) genericType2).getActualTypeArguments()[1];
                if (type3 instanceof Class) {
                    Class<?> cls4 = (Class) type3;
                    AppMethodBeat.o(73428);
                    return cls4;
                }
                WeJsonException weJsonException5 = new WeJsonException("不支持嵌套泛型:" + field.getName());
                AppMethodBeat.o(73428);
                throw weJsonException5;
            }
            WeJsonException weJsonException6 = new WeJsonException("缺少泛型类型声明:" + field.getName());
            AppMethodBeat.o(73428);
            throw weJsonException6;
        } else {
            Class<?> type4 = field.getType();
            AppMethodBeat.o(73428);
            return type4;
        }
    }
}
