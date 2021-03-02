package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e<CONTEXT extends f> extends d<CONTEXT> {
    /* access modifiers changed from: protected */
    public int H(JSONObject jSONObject) {
        throw new JSONException("viewId do not exist, override the method getViewId(data).");
    }

    protected static float[] L(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("position"));
            return new float[]{g.a(jSONObject2, "left", 0.0f), g.a(jSONObject2, "top", 0.0f), g.a(jSONObject2, "width", 0.0f), g.a(jSONObject2, "height", 0.0f), (float) jSONObject.optInt("zIndex", 0)};
        } catch (Exception e2) {
            return null;
        }
    }

    protected static int M(JSONObject jSONObject) {
        try {
            return jSONObject.getBoolean(MessengerShareContentUtility.SHARE_BUTTON_HIDE) ? 4 : 0;
        } catch (JSONException e2) {
            return -1;
        }
    }

    protected static Boolean N(JSONObject jSONObject) {
        try {
            return Boolean.valueOf(jSONObject.getBoolean("fixed"));
        } catch (JSONException e2) {
            return null;
        }
    }

    protected static Boolean O(JSONObject jSONObject) {
        try {
            return Boolean.valueOf(jSONObject.getBoolean("fullscreen"));
        } catch (JSONException e2) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Boolean I(JSONObject jSONObject) {
        return null;
    }
}
