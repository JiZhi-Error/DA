package com.tencent.map.tools.json;

import org.json.JSONObject;

public interface JsonParser {

    public interface Deserializer<T> {
        T deserialize(Object obj, String str, Object obj2);
    }

    void parse(JSONObject jSONObject);
}
