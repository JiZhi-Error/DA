package com.tencent.liteapp.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private long cqW;
    private long cqX;
    private long cqY;
    private String mAppId;

    public b(String str, long j2, long j3, long j4) {
        this.mAppId = str;
        this.cqW = j2;
        this.cqX = j3;
        this.cqY = j4;
    }

    public final void a(JSONObject jSONObject, boolean z) {
        AppMethodBeat.i(197701);
        if (this.cqY < 0) {
            AppMethodBeat.o(197701);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("result", true);
            jSONObject2.put("errMsg", "");
            if (jSONObject != null) {
                jSONObject2.put("data", jSONObject);
            } else {
                jSONObject2.put("data", new JSONObject());
            }
        } catch (JSONException e2) {
            com.tencent.liteapp.b.b.e("WxaLiteApp.LiteAppJsApiCallback", e2.toString(), new Object[0]);
        }
        LiteAppCenter.jsApiCallback(this.mAppId, this.cqW, this.cqX, this.cqY, jSONObject2.toString(), z);
        AppMethodBeat.o(197701);
    }

    public final void h(String str, boolean z) {
        AppMethodBeat.i(197702);
        if (this.cqY >= 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", false);
                jSONObject.put("data", new JSONObject());
                if (str != null) {
                    jSONObject.put("errMsg", str);
                } else {
                    jSONObject.put("errMsg", "");
                }
            } catch (JSONException e2) {
                com.tencent.liteapp.b.b.e("WxaLiteApp.LiteAppJsApiCallback", e2.toString(), new Object[0]);
            }
            LiteAppCenter.jsApiCallback(this.mAppId, this.cqW, this.cqX, this.cqY, jSONObject.toString(), z);
        }
        AppMethodBeat.o(197702);
    }
}
