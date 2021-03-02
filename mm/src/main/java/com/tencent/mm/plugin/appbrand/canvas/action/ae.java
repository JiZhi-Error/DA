package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetShadowActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class ae implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144966);
        SetShadowActionArg setShadowActionArg = new SetShadowActionArg();
        AppMethodBeat.o(144966);
        return setShadowActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setShadow";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144967);
        if (jSONArray.length() < 4) {
            AppMethodBeat.o(144967);
            return false;
        }
        float f2 = g.f(jSONArray, 0);
        float f3 = g.f(jSONArray, 1);
        float f4 = g.f(jSONArray, 2);
        JSONArray optJSONArray = jSONArray.optJSONArray(3);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.o(144967);
            return false;
        }
        boolean a2 = a(dVar, f2, f3, f4, g.r(optJSONArray));
        AppMethodBeat.o(144967);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144969);
        SetShadowActionArg setShadowActionArg = (SetShadowActionArg) drawActionArg;
        if (setShadowActionArg == null) {
            AppMethodBeat.o(144969);
            return false;
        }
        boolean a2 = a(dVar, setShadowActionArg.x, setShadowActionArg.y, setShadowActionArg.kZP, setShadowActionArg.color);
        AppMethodBeat.o(144969);
        return a2;
    }

    private static boolean a(d dVar, float f2, float f3, float f4, int i2) {
        AppMethodBeat.i(144968);
        dVar.kZm.setShadowLayer(f4, f2, f3, i2);
        dVar.kZl.setShadowLayer(f4, f2, f3, i2);
        AppMethodBeat.o(144968);
        return true;
    }
}
