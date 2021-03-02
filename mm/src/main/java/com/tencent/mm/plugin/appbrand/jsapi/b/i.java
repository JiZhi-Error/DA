package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends ab {
    public static final int CTRL_INDEX = 436;
    public static final String NAME = "measureText";

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final String a(f fVar, JSONObject jSONObject) {
        boolean z;
        char c2 = 65535;
        AppMethodBeat.i(145541);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiMeasureText", "measureText, data is null");
            String h2 = h("fail:data is null", null);
            AppMethodBeat.o(145541);
            return h2;
        }
        String optString = jSONObject.optString("text");
        float optDouble = (float) jSONObject.optDouble("fontSize", 16.0d);
        Log.i("MicroMsg.JsApiMeasureText", "measureText data:%s", jSONObject.toString());
        if (TextUtils.isEmpty(optString) || optDouble <= 0.0f) {
            Log.e("MicroMsg.JsApiMeasureText", "measureText, param is illegal");
            String h3 = h("fail:param is illegal", null);
            AppMethodBeat.o(145541);
            return h3;
        }
        a aVar = new a();
        aVar.setTextSize(g.aT(optDouble));
        try {
            aVar.WF(jSONObject.getString("fontFamily"));
        } catch (JSONException e2) {
            Log.i("MicroMsg.JsApiMeasureText", "get 'fontFamily' error");
        }
        try {
            String string = jSONObject.getString("fontStyle");
            switch (string.hashCode()) {
                case -1657669071:
                    if (string.equals("oblique")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case -1178781136:
                    if (string.equals("italic")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1039745817:
                    if (string.equals("normal")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    aVar.we(2);
                    break;
                case true:
                    aVar.we(2);
                    break;
                case true:
                    aVar.we(0);
                    break;
            }
        } catch (JSONException e3) {
            Log.i("MicroMsg.JsApiMeasureText", "get 'fontStyle' error.");
        }
        try {
            String string2 = jSONObject.getString("fontWeight");
            switch (string2.hashCode()) {
                case -1039745817:
                    if (string2.equals("normal")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3029637:
                    if (string2.equals("bold")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    aVar.setFakeBoldText(true);
                    break;
                case 1:
                    aVar.setFakeBoldText(false);
                    break;
            }
        } catch (JSONException e4) {
            Log.i("MicroMsg.JsApiMeasureText", "get 'fontWeight' error.");
        }
        float measureText = aVar.measureText(optString);
        Paint.FontMetrics fontMetrics = aVar.getFontMetrics();
        float abs = Math.abs(fontMetrics.bottom - fontMetrics.top);
        Log.i("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", Float.valueOf(fontMetrics.bottom), Float.valueOf(fontMetrics.top), Float.valueOf(measureText), Float.valueOf(abs));
        float aS = g.aS(measureText);
        float aS2 = g.aS(abs);
        HashMap hashMap = new HashMap();
        hashMap.put("width", Float.valueOf(aS));
        hashMap.put("height", Float.valueOf(aS2));
        Log.i("MicroMsg.JsApiMeasureText", "map:%s", hashMap.toString());
        String n = n("ok", hashMap);
        AppMethodBeat.o(145541);
        return n;
    }
}
