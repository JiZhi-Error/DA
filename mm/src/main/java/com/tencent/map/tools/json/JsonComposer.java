package com.tencent.map.tools.json;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.json.annotation.JsonType;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JsonComposer implements JsonEncoder, JsonParser {
    private static Map<Class, Map<Field, String>> sClassJsonMap = new HashMap();
    private boolean mAllowEmpty = true;
    private Map<Class, JsonParser.Deserializer> mClassDeserializer = new HashMap();
    private Map<Field, JsonParser.Deserializer> mFieldDeserializer = new HashMap();
    private String mFieldNamePrefix;
    private FieldNameStyle mFieldNameStyle = FieldNameStyle.HUMP;
    private Map<Field, String> mJsonFields;

    @Override // com.tencent.map.tools.json.JsonEncoder
    public JSONObject toJson() {
        Object obj;
        checkJsonComposerElements();
        Set<Map.Entry<Field, String>> entrySet = this.mJsonFields.entrySet();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<Field, String> entry : entrySet) {
            Field key = entry.getKey();
            key.setAccessible(true);
            Class<?> type = key.getType();
            try {
                obj = key.get(this);
            } catch (IllegalAccessException e2) {
                obj = null;
            }
            if (!onEachItemToJson(jSONObject, entry.getValue(), obj)) {
                if (Collection.class.isAssignableFrom(type)) {
                    try {
                        Collection collection = (Collection) key.get(this);
                        JSONArray jSONArray = new JSONArray();
                        if (collection != null && !collection.isEmpty()) {
                            for (Object obj2 : collection) {
                                if (obj2 instanceof JsonEncoder) {
                                    jSONArray.put(JsonUtils.modelToJson(obj2));
                                }
                            }
                        }
                        jSONObject.put(entry.getValue(), (this.mAllowEmpty || (collection != null && !collection.isEmpty())) ? jSONArray : null);
                    } catch (IllegalAccessException e3) {
                    } catch (JSONException e4) {
                    }
                } else {
                    try {
                        Object obj3 = key.get(this);
                        if (obj3 instanceof Double) {
                            jSONObject.put(entry.getValue(), ((Double) obj3).doubleValue());
                        } else if (obj3 instanceof Long) {
                            jSONObject.put(entry.getValue(), ((Long) obj3).longValue());
                        } else if (obj3 instanceof Integer) {
                            jSONObject.put(entry.getValue(), ((Integer) obj3).intValue());
                        } else if (obj3 instanceof Boolean) {
                            jSONObject.put(entry.getValue(), ((Boolean) obj3).booleanValue());
                        } else if (obj3 instanceof JsonEncoder) {
                            jSONObject.put(entry.getValue(), JsonUtils.modelToJson(obj3));
                        } else if (obj3 == null || !obj3.getClass().isArray()) {
                            String value = entry.getValue();
                            if (obj3 == null && this.mAllowEmpty) {
                                obj3 = "";
                            }
                            jSONObject.put(value, obj3);
                        } else if (Build.VERSION.SDK_INT >= 19) {
                            jSONObject.put(entry.getValue(), new JSONArray(obj3));
                        } else {
                            int length = Array.getLength(obj3);
                            JSONArray jSONArray2 = new JSONArray();
                            for (int i2 = 0; i2 < length; i2++) {
                                jSONArray2.put(i2, Array.get(obj3, i2));
                            }
                            jSONObject.put(entry.getValue(), jSONArray2);
                        }
                    } catch (IllegalAccessException e5) {
                    } catch (JSONException e6) {
                    }
                }
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public boolean onEachItemToJson(JSONObject jSONObject, String str, Object obj) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onEachItemParse(String str, Object obj) {
        return false;
    }

    @Override // com.tencent.map.tools.json.JsonParser
    public void parse(JSONObject jSONObject) {
        Class findClass;
        checkJsonComposerElements();
        JsonParser.Deserializer deserializer = this.mClassDeserializer.get(getClass());
        if (deserializer != null) {
            try {
                deserializer.deserialize(this, getClass().getName(), jSONObject);
                return;
            } catch (JSONException e2) {
            }
        }
        for (Map.Entry<Field, String> entry : this.mJsonFields.entrySet()) {
            Field key = entry.getKey();
            key.setAccessible(true);
            Class<?> type = key.getType();
            Object opt = jSONObject.opt(entry.getValue());
            JsonParser.Deserializer deserializer2 = this.mFieldDeserializer.get(key);
            if (deserializer2 != null) {
                try {
                    key.set(this, deserializer2.deserialize(this, entry.getValue(), opt));
                } catch (Exception e3) {
                }
            }
            if (!onEachItemParse(entry.getValue(), opt)) {
                if (opt instanceof JSONArray) {
                    Type genericType = key.getGenericType();
                    if (genericType instanceof ParameterizedType) {
                        String pickString = pickString(genericType.toString());
                        try {
                            if (!TextUtils.isEmpty(pickString) && (findClass = Util.findClass(pickString, getClass().getClassLoader())) != null) {
                                Collection collection = null;
                                if (Set.class.isAssignableFrom(key.getType())) {
                                    collection = JsonUtils.parseTo(HashSet.class, (JSONArray) opt, findClass, new Object[0]);
                                } else if (List.class.isAssignableFrom(key.getType())) {
                                    collection = JsonUtils.parseTo(ArrayList.class, (JSONArray) opt, findClass, new Object[0]);
                                }
                                key.set(this, collection);
                            }
                        } catch (IllegalAccessException e4) {
                        }
                    } else if (((Class) genericType).isArray()) {
                        try {
                            key.set(this, JsonUtils.parseToArray((JSONArray) opt, ((Class) genericType).getComponentType()));
                        } catch (IllegalAccessException e5) {
                        }
                    }
                } else if (opt instanceof JSONObject) {
                    try {
                        key.set(this, JsonUtils.parseToModel((JSONObject) opt, key.getType(), new Object[0]));
                    } catch (IllegalAccessException e6) {
                    }
                } else if (type == String.class) {
                    try {
                        key.set(this, String.valueOf(opt));
                    } catch (IllegalAccessException e7) {
                    }
                } else {
                    try {
                        if (type == Boolean.TYPE && (opt instanceof Boolean)) {
                            key.setBoolean(this, ((Boolean) opt).booleanValue());
                        } else if (type == Byte.TYPE && (opt instanceof Byte)) {
                            key.setByte(this, ((Byte) opt).byteValue());
                        } else if (type == Character.TYPE && (opt instanceof Character)) {
                            key.setChar(this, ((Character) opt).charValue());
                        } else if (type == Double.TYPE) {
                            if (opt instanceof Number) {
                                key.setDouble(this, ((Number) opt).doubleValue());
                            } else if (opt instanceof String) {
                                key.setDouble(this, Double.parseDouble((String) opt));
                            }
                        } else if (type == Float.TYPE) {
                            if (opt instanceof Number) {
                                key.setFloat(this, ((Number) opt).floatValue());
                            } else if (opt instanceof String) {
                                key.setFloat(this, Float.parseFloat((String) opt));
                            }
                        } else if (type == Integer.TYPE) {
                            if (opt instanceof Number) {
                                key.setInt(this, ((Number) opt).intValue());
                            } else if (opt instanceof String) {
                                key.setInt(this, Integer.parseInt((String) opt));
                            }
                        } else if (type == Long.TYPE) {
                            if (opt instanceof Number) {
                                key.setLong(this, ((Number) opt).longValue());
                            } else if (opt instanceof String) {
                                key.setLong(this, Long.parseLong((String) opt));
                            }
                        } else if (type == Short.TYPE) {
                            if (opt instanceof Number) {
                                key.setShort(this, ((Number) opt).shortValue());
                            } else if (opt instanceof String) {
                                key.setShort(this, Short.parseShort((String) opt));
                            }
                        } else if (opt != null) {
                            key.set(this, opt);
                        }
                    } catch (NumberFormatException e8) {
                    } catch (IllegalAccessException e9) {
                    }
                }
            }
        }
    }

    private String pickString(String str) {
        while (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("<");
            int lastIndexOf = str.lastIndexOf(">");
            if (indexOf < 0) {
                indexOf = 0;
            }
            if (lastIndexOf < 0) {
                lastIndexOf = str.length();
            }
            if (lastIndexOf <= indexOf) {
                break;
            }
            str = str.substring(indexOf + 1, lastIndexOf);
            if (str.contains("<")) {
                if (!str.contains(">")) {
                    break;
                }
            } else {
                break;
            }
        }
        return str;
    }

    private synchronized void checkJsonComposerElements() {
        Class<? extends JsonParser.Deserializer> deserializer;
        JsonType jsonType = (JsonType) getClass().getAnnotation(JsonType.class);
        if (jsonType != null) {
            this.mAllowEmpty = jsonType.allowEmpty();
            this.mFieldNameStyle = jsonType.fieldNameStyle();
            this.mFieldNamePrefix = jsonType.fieldNamePrefix();
            Class<? extends JsonParser.Deserializer> deserializer2 = jsonType.deserializer();
            if (deserializer2 != JsonParser.Deserializer.class) {
                this.mClassDeserializer.put(getClass(), (JsonParser.Deserializer) Util.newInstance(deserializer2, new Object[0]));
            }
        }
        this.mJsonFields = sClassJsonMap.get(getClass());
        Collection<Field> arrayList = new ArrayList();
        if (this.mJsonFields == null) {
            this.mJsonFields = new Hashtable();
            for (Class<?> cls = getClass(); cls != JsonComposer.class; cls = cls.getSuperclass()) {
                arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
            }
            sClassJsonMap.put(getClass(), this.mJsonFields);
        } else {
            arrayList = this.mJsonFields.keySet();
        }
        for (Field field : arrayList) {
            if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isTransient(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
                JsonType jsonType2 = (JsonType) field.getType().getAnnotation(JsonType.class);
                if (!(jsonType2 == null || (deserializer = jsonType2.deserializer()) == JsonParser.Deserializer.class)) {
                    this.mFieldDeserializer.put(field, (JsonParser.Deserializer) Util.newInstance(deserializer, new Object[0]));
                }
                Json json = (Json) field.getAnnotation(Json.class);
                if (json != null) {
                    if (!json.ignore()) {
                        if (TextUtils.isEmpty(json.name())) {
                            this.mJsonFields.put(field, translateFieldName(field.getName()));
                        } else {
                            this.mJsonFields.put(field, json.name());
                        }
                    }
                    Class<? extends JsonParser.Deserializer> deserializer3 = json.deserializer();
                    if (deserializer3 != JsonParser.Deserializer.class) {
                        this.mFieldDeserializer.put(field, (JsonParser.Deserializer) Util.newInstance(deserializer3, new Object[0]));
                    }
                } else if (!field.getName().contains("this")) {
                    this.mJsonFields.put(field, translateFieldName(field.getName()));
                }
            }
        }
    }

    private String translateFieldName(String str) {
        if (this.mFieldNamePrefix != null && str.startsWith(this.mFieldNamePrefix)) {
            String substring = str.substring(this.mFieldNamePrefix.length(), this.mFieldNamePrefix.length() + 1);
            str = substring.toLowerCase() + str.substring(this.mFieldNamePrefix.length() + 1);
        }
        if (this.mFieldNameStyle != FieldNameStyle.UNDERLINE) {
            return str;
        }
        Matcher matcher = Pattern.compile("[A-Z]").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
