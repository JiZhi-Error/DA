package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.annotation.SuppressLint;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.a;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u0014\u0010\u0018\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001e\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000e¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenLipStickInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "colorB", "", "getColorB", "()I", "setColorB", "(I)V", "colorG", "getColorG", "setColorG", "colorR", "getColorR", "setColorR", "faceModel", "getFaceModel", "setFaceModel", "isValid", "", "()Z", "mouthShape", "getMouthShape", "setMouthShape", "type", "getType", "setType", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"})
public final class g extends a {
    @SuppressLint({"Range"})
    float alpha = -1.0f;
    @SuppressLint({"Range"})
    int cGX = -1;
    @SuppressLint({"Range"})
    int cGY = -1;
    @SuppressLint({"Range"})
    int cGZ = -1;
    int cGc;
    int oGM;
    int type;

    @Override // com.tencent.mm.plugin.appbrand.xweb_ext.a.a
    public final boolean isValid() {
        return (-1.0f == this.alpha || -1 == this.cGX || -1 == this.cGY || -1 == this.cGZ) ? false : true;
    }

    @Override // com.tencent.mm.sticker.a
    public final a au(JSONObject jSONObject) {
        AppMethodBeat.i(229723);
        p.h(jSONObject, "jsonObj");
        JSONObject optJSONObject = jSONObject.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
        if (optJSONObject == null) {
            Log.w("MicroMsg.FlattenLipStickInfo", "fromJson, paramsJsonObj is null");
            a au = super.au(jSONObject);
            AppMethodBeat.o(229723);
            return au;
        }
        this.alpha = (float) optJSONObject.optDouble("alpha", -1.0d);
        JSONArray optJSONArray = optJSONObject.optJSONArray("color");
        if (optJSONArray == null || 1 > optJSONArray.length()) {
            Log.w("MicroMsg.FlattenLipStickInfo", "fromJson, colorJsonArr2d is illegal");
        } else {
            JSONArray jSONArray = optJSONArray.getJSONArray(0);
            if (jSONArray == null || 3 != optJSONArray.length()) {
                Log.w("MicroMsg.FlattenLipStickInfo", "fromJson, colorJsonArr is illegal");
            } else {
                this.cGX = jSONArray.optInt(0, -1);
                this.cGY = jSONArray.optInt(1, -1);
                this.cGZ = jSONArray.optInt(2, -1);
            }
        }
        this.type = optJSONObject.optInt("lipstick_type", 0);
        this.cGc = optJSONObject.optInt("face_model", 0);
        this.oGM = optJSONObject.optInt("mouth_shape", 0);
        a au2 = super.au(jSONObject);
        AppMethodBeat.o(229723);
        return au2;
    }

    @Override // com.tencent.mm.sticker.a
    public final JSONObject toJson() {
        AppMethodBeat.i(229724);
        JSONObject json = super.toJson();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("alpha", Float.valueOf(this.alpha));
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(this.cGX);
        jSONArray2.put(this.cGY);
        jSONArray2.put(this.cGZ);
        jSONArray.put(jSONArray2);
        jSONObject.put("color", jSONArray);
        jSONObject.put("lipstick_type", this.type);
        jSONObject.put("face_model", this.cGc);
        jSONObject.put("mouth_shape", this.oGM);
        json.put(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject);
        AppMethodBeat.o(229724);
        return json;
    }
}
