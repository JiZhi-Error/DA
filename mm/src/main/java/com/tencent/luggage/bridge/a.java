package com.tencent.luggage.bridge;

import java.util.HashMap;
import org.json.JSONObject;

abstract class a {
    protected b csh;
    protected JSONObject csi;

    a() {
    }

    /* access modifiers changed from: package-private */
    public final b KW() {
        return this.csh;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject KX() {
        return this.csi;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", this.csh.name());
        hashMap.put("data", this.csi);
        return new JSONObject(hashMap).toString();
    }
}
