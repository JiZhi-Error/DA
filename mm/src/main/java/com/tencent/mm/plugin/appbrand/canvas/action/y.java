package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineDashActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;
import org.json.JSONException;

public final class y implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144945);
        SetLineDashActionArg setLineDashActionArg = new SetLineDashActionArg();
        AppMethodBeat.o(144945);
        return setLineDashActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setLineDash";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144946);
        if (jSONArray.length() < 2) {
            AppMethodBeat.o(144946);
            return false;
        }
        try {
            JSONArray jSONArray2 = jSONArray.getJSONArray(0);
            if (jSONArray2 == null) {
                AppMethodBeat.o(144946);
                return false;
            }
            float[] fArr = new float[jSONArray2.length()];
            for (int i2 = 0; i2 < fArr.length; i2++) {
                fArr[i2] = g.f(jSONArray2, i2);
            }
            boolean a2 = a(dVar, fArr, g.f(jSONArray, 1));
            AppMethodBeat.o(144946);
            return a2;
        } catch (JSONException e2) {
            AppMethodBeat.o(144946);
            return false;
        }
    }

    private static boolean a(d dVar, float[] fArr, float f2) {
        AppMethodBeat.i(144947);
        if (!(fArr == null || f2 == Float.MIN_VALUE)) {
            dVar.kZl.setPathEffect(new DashPathEffect(fArr, f2));
        }
        AppMethodBeat.o(144947);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144948);
        SetLineDashActionArg setLineDashActionArg = (SetLineDashActionArg) drawActionArg;
        if (setLineDashActionArg == null) {
            AppMethodBeat.o(144948);
            return false;
        }
        boolean a2 = a(dVar, setLineDashActionArg.kZL, setLineDashActionArg.kZM);
        AppMethodBeat.o(144948);
        return a2;
    }
}
