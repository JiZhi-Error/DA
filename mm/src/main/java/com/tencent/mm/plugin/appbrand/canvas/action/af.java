package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetStrokeStyleActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class af implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144970);
        SetStrokeStyleActionArg setStrokeStyleActionArg = new SetStrokeStyleActionArg();
        AppMethodBeat.o(144970);
        return setStrokeStyleActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setStrokeStyle";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144971);
        if (jSONArray.length() < 2) {
            AppMethodBeat.o(144971);
            return false;
        }
        String optString = jSONArray.optString(0);
        if ("linear".equalsIgnoreCase(optString)) {
            if (jSONArray.length() < 3) {
                AppMethodBeat.o(144971);
                return false;
            }
            JSONArray optJSONArray = jSONArray.optJSONArray(1);
            if (optJSONArray == null || optJSONArray.length() < 4) {
                AppMethodBeat.o(144971);
                return false;
            }
            float f2 = g.f(optJSONArray, 0);
            float f3 = g.f(optJSONArray, 1);
            float f4 = g.f(optJSONArray, 2);
            float f5 = g.f(optJSONArray, 3);
            JSONArray optJSONArray2 = jSONArray.optJSONArray(2);
            if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                AppMethodBeat.o(144971);
                return false;
            }
            int[] iArr = new int[optJSONArray2.length()];
            float[] fArr = new float[optJSONArray2.length()];
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i2);
                if (optJSONArray3.length() >= 2) {
                    fArr[i2] = (float) optJSONArray3.optDouble(0);
                    iArr[i2] = g.r(optJSONArray3.optJSONArray(1));
                }
            }
            dVar.kZl.setShader(new LinearGradient(f2, f3, f4, f5, iArr, fArr, Shader.TileMode.CLAMP));
        } else if ("radial".equalsIgnoreCase(optString)) {
            if (jSONArray.length() < 3) {
                AppMethodBeat.o(144971);
                return false;
            }
            JSONArray optJSONArray4 = jSONArray.optJSONArray(1);
            if (optJSONArray4 == null || optJSONArray4.length() < 3) {
                AppMethodBeat.o(144971);
                return false;
            }
            float f6 = g.f(optJSONArray4, 1);
            float f7 = g.f(optJSONArray4, 2);
            float f8 = g.f(optJSONArray4, 3);
            JSONArray optJSONArray5 = jSONArray.optJSONArray(2);
            int[] iArr2 = new int[optJSONArray5.length()];
            float[] fArr2 = new float[optJSONArray5.length()];
            for (int i3 = 0; i3 < optJSONArray5.length(); i3++) {
                JSONArray optJSONArray6 = optJSONArray5.optJSONArray(i3);
                if (optJSONArray6.length() >= 2) {
                    fArr2[i3] = (float) optJSONArray6.optDouble(0);
                    iArr2[i3] = g.r(optJSONArray6.optJSONArray(1));
                }
            }
            dVar.kZl.setShader(new RadialGradient(f6, f7, f8, iArr2, fArr2, Shader.TileMode.CLAMP));
        } else if ("normal".equalsIgnoreCase(optString)) {
            JSONArray optJSONArray7 = jSONArray.optJSONArray(1);
            if (optJSONArray7 == null || optJSONArray7.length() < 4) {
                AppMethodBeat.o(144971);
                return false;
            }
            dVar.kZl.setColor(g.r(optJSONArray7));
        }
        AppMethodBeat.o(144971);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144972);
        SetStrokeStyleActionArg setStrokeStyleActionArg = (SetStrokeStyleActionArg) drawActionArg;
        if (setStrokeStyleActionArg == null) {
            AppMethodBeat.o(144972);
            return false;
        }
        boolean a2 = setStrokeStyleActionArg.a(dVar, canvas);
        AppMethodBeat.o(144972);
        return a2;
    }
}
