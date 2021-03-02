package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.annotation.SuppressLint;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.a;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenEyeShadowInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "isValid", "", "()Z", "leftMaskPath", "", "getLeftMaskPath", "()Ljava/lang/String;", "setLeftMaskPath", "(Ljava/lang/String;)V", "rightMaskPath", "getRightMaskPath", "setRightMaskPath", "shimmerPosPath", "getShimmerPosPath", "setShimmerPosPath", "type", "", "getType", "()I", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"})
public final class e extends a {
    @SuppressLint({"Range"})
    float alpha = -1.0f;
    String cGk = "";
    String cGm = "";
    String cGo;

    @Override // com.tencent.mm.plugin.appbrand.xweb_ext.a.a
    public final boolean isValid() {
        AppMethodBeat.i(229717);
        if (-1.0f != this.alpha) {
            if (this.cGk.length() > 0) {
                if (this.cGm.length() > 0) {
                    AppMethodBeat.o(229717);
                    return true;
                }
            }
        }
        AppMethodBeat.o(229717);
        return false;
    }

    @Override // com.tencent.mm.sticker.a
    public final a au(JSONObject jSONObject) {
        AppMethodBeat.i(229718);
        p.h(jSONObject, "jsonObj");
        JSONObject optJSONObject = jSONObject.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
        if (optJSONObject == null) {
            Log.w("MicroMsg.FlattenEyeShadowInfo", "fromJson, paramsJsonObj is null");
            a au = super.au(jSONObject);
            AppMethodBeat.o(229718);
            return au;
        }
        this.alpha = (float) optJSONObject.optDouble("alpha", -1.0d);
        String optString = optJSONObject.optString("left_mask", "");
        p.g(optString, "paramsJsonObj.optString(…N_KEY_LEFT_MASK_PATH, \"\")");
        this.cGk = optString;
        String optString2 = optJSONObject.optString("right_mask", "");
        p.g(optString2, "paramsJsonObj.optString(…_KEY_RIGHT_MASK_PATH, \"\")");
        this.cGm = optString2;
        this.cGo = optJSONObject.optString("shimmer_position", null);
        a au2 = super.au(jSONObject);
        AppMethodBeat.o(229718);
        return au2;
    }

    @Override // com.tencent.mm.sticker.a
    public final JSONObject toJson() {
        int i2;
        AppMethodBeat.i(229719);
        JSONObject json = super.toJson();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("alpha", Float.valueOf(this.alpha));
        jSONObject.put("left_mask", this.cGk);
        jSONObject.put("right_mask", this.cGm);
        if (this.cGo != null) {
            jSONObject.put("shimmer_position", this.cGo);
        }
        if (this.cGo != null) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        jSONObject.put("eyeshadow_type", i2);
        json.put(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject);
        AppMethodBeat.o(229719);
        return json;
    }
}
