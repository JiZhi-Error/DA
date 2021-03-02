package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.annotation.SuppressLint;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.a;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenEyeBrowInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "faceModel", "", "getFaceModel", "()I", "setFaceModel", "(I)V", "isValid", "", "()Z", "leftEyeBrowPath", "", "getLeftEyeBrowPath", "()Ljava/lang/String;", "setLeftEyeBrowPath", "(Ljava/lang/String;)V", "rightEyeBrowPath", "getRightEyeBrowPath", "setRightEyeBrowPath", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"})
public final class d extends a {
    @SuppressLint({"Range"})
    float alpha = -1.0f;
    int cGc;
    String cGf = "";
    String cGh = "";

    @Override // com.tencent.mm.plugin.appbrand.xweb_ext.a.a
    public final boolean isValid() {
        AppMethodBeat.i(229714);
        if (-1.0f != this.alpha) {
            if (this.cGf.length() > 0) {
                if (this.cGh.length() > 0) {
                    AppMethodBeat.o(229714);
                    return true;
                }
            }
        }
        AppMethodBeat.o(229714);
        return false;
    }

    @Override // com.tencent.mm.sticker.a
    public final a au(JSONObject jSONObject) {
        AppMethodBeat.i(229715);
        p.h(jSONObject, "jsonObj");
        JSONObject optJSONObject = jSONObject.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
        if (optJSONObject == null) {
            Log.w("MicroMsg.FlattenEyeBrowInfo", "fromJson, paramsJsonObj is null");
            a au = super.au(jSONObject);
            AppMethodBeat.o(229715);
            return au;
        }
        this.alpha = (float) optJSONObject.optDouble("alpha", -1.0d);
        String optString = optJSONObject.optString("left_path", "");
        p.g(optString, "paramsJsonObj.optString(…Y_LEFT_EYE_BROW_PATH, \"\")");
        this.cGf = optString;
        String optString2 = optJSONObject.optString("right_path", "");
        p.g(optString2, "paramsJsonObj.optString(…_RIGHT_EYE_BROW_PATH, \"\")");
        this.cGh = optString2;
        this.cGc = optJSONObject.optInt("face_model", 0);
        a au2 = super.au(jSONObject);
        AppMethodBeat.o(229715);
        return au2;
    }

    @Override // com.tencent.mm.sticker.a
    public final JSONObject toJson() {
        AppMethodBeat.i(229716);
        JSONObject json = super.toJson();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("alpha", Float.valueOf(this.alpha));
        jSONObject.put("left_path", this.cGf);
        jSONObject.put("right_path", this.cGh);
        jSONObject.put("face_model", this.cGc);
        json.put(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject);
        AppMethodBeat.o(229716);
        return json;
    }
}
