package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTransformActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;
import org.json.JSONException;

public final class ai implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144981);
        SetTransformActionArg setTransformActionArg = new SetTransformActionArg();
        AppMethodBeat.o(144981);
        return setTransformActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setTransform";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144982);
        if (jSONArray.length() < 6) {
            AppMethodBeat.o(144982);
            return false;
        }
        try {
            boolean a2 = a(canvas, (float) jSONArray.getDouble(0), (float) jSONArray.getDouble(1), (float) jSONArray.getDouble(2), (float) jSONArray.getDouble(3), g.e(jSONArray, 4), g.e(jSONArray, 5));
            AppMethodBeat.o(144982);
            return a2;
        } catch (JSONException e2) {
            AppMethodBeat.o(144982);
            return false;
        }
    }

    private static boolean a(Canvas canvas, float f2, float f3, float f4, float f5, float f6, float f7) {
        AppMethodBeat.i(144983);
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setValues(new float[]{f2, f4, f6, f3, f5, f7, 0.0f, 0.0f, 1.0f});
        canvas.setMatrix(matrix);
        AppMethodBeat.o(144983);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144984);
        SetTransformActionArg setTransformActionArg = (SetTransformActionArg) drawActionArg;
        if (setTransformActionArg == null) {
            AppMethodBeat.o(144984);
            return false;
        }
        boolean a2 = a(canvas, setTransformActionArg.scaleX, setTransformActionArg.kZS, setTransformActionArg.kZT, setTransformActionArg.scaleY, setTransformActionArg.translateX, setTransformActionArg.translateY);
        AppMethodBeat.o(144984);
        return a2;
    }
}
