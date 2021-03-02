package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.annotation.SuppressLint;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.a;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenFaceContourInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "faceModel", "", "getFaceModel", "()I", "setFaceModel", "(I)V", "highLightAlpha", "", "getHighLightAlpha", "()F", "setHighLightAlpha", "(F)V", "highLightContourPath", "", "getHighLightContourPath", "()Ljava/lang/String;", "setHighLightContourPath", "(Ljava/lang/String;)V", "isValid", "", "()Z", "shadowAlpha", "getShadowAlpha", "setShadowAlpha", "shadowContourPath", "getShadowContourPath", "setShadowContourPath", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"})
public final class f extends a {
    int cGc;
    @SuppressLint({"Range"})
    float cGt = -1.0f;
    @SuppressLint({"Range"})
    float cGu = -1.0f;
    String cGv = "";
    String cGx = "";

    @Override // com.tencent.mm.plugin.appbrand.xweb_ext.a.a
    public final boolean isValid() {
        AppMethodBeat.i(229720);
        if (!(-1.0f == this.cGt || -1.0f == this.cGu)) {
            if (this.cGv.length() > 0) {
                if (this.cGx.length() > 0) {
                    AppMethodBeat.o(229720);
                    return true;
                }
            }
        }
        AppMethodBeat.o(229720);
        return false;
    }

    @Override // com.tencent.mm.sticker.a
    public final a au(JSONObject jSONObject) {
        AppMethodBeat.i(229721);
        p.h(jSONObject, "jsonObj");
        JSONObject optJSONObject = jSONObject.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
        if (optJSONObject == null) {
            Log.w("MicroMsg.FlattenFaceContourInfo", "fromJson, paramsJsonObj is null");
            a au = super.au(jSONObject);
            AppMethodBeat.o(229721);
            return au;
        }
        this.cGt = (float) optJSONObject.optDouble("highlight_alpha", -1.0d);
        this.cGu = (float) optJSONObject.optDouble("shadow_alpha", -1.0d);
        String optString = optJSONObject.optString("highlight_path", "");
        p.g(optString, "paramsJsonObj.optString(…H_LIGHT_CONTOUR_PATH, \"\")");
        this.cGv = optString;
        String optString2 = optJSONObject.optString("shadow_path", "");
        p.g(optString2, "paramsJsonObj.optString(…_SHADOW_CONTOUR_PATH, \"\")");
        this.cGx = optString2;
        this.cGc = optJSONObject.optInt("face_model", 0);
        a au2 = super.au(jSONObject);
        AppMethodBeat.o(229721);
        return au2;
    }

    @Override // com.tencent.mm.sticker.a
    public final JSONObject toJson() {
        AppMethodBeat.i(229722);
        JSONObject json = super.toJson();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("highlight_alpha", Float.valueOf(this.cGt));
        jSONObject.put("shadow_alpha", Float.valueOf(this.cGu));
        jSONObject.put("highlight_path", this.cGv);
        jSONObject.put("shadow_path", this.cGx);
        jSONObject.put("face_model", this.cGc);
        json.put(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject);
        AppMethodBeat.o(229722);
        return json;
    }
}
