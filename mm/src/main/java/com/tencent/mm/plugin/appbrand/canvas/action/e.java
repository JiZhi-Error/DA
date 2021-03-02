package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawArcActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class e implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144865);
        DrawArcActionArg drawArcActionArg = new DrawArcActionArg();
        AppMethodBeat.o(144865);
        return drawArcActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "arc";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144866);
        if (jSONArray.length() < 5) {
            AppMethodBeat.o(144866);
            return false;
        }
        boolean a2 = a(dVar, canvas, g.f(jSONArray, 0), g.f(jSONArray, 1), g.f(jSONArray, 2), (float) jSONArray.optDouble(3), (float) jSONArray.optDouble(4));
        AppMethodBeat.o(144866);
        return a2;
    }

    private static boolean a(d dVar, Canvas canvas, float f2, float f3, float f4, float f5, float f6) {
        AppMethodBeat.i(144867);
        canvas.drawArc(new RectF(f2 - f4, f3 - f4, f2 + f4, f3 + f4), (float) ((((double) f5) / 3.141592653589793d) * 180.0d), (float) ((((double) f6) / 3.141592653589793d) * 180.0d), true, dVar.kZl);
        AppMethodBeat.o(144867);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144868);
        DrawArcActionArg drawArcActionArg = (DrawArcActionArg) drawActionArg;
        if (drawArcActionArg == null) {
            AppMethodBeat.o(144868);
            return false;
        }
        boolean a2 = a(dVar, canvas, drawArcActionArg.x, drawArcActionArg.y, drawArcActionArg.radius, drawArcActionArg.mj, drawArcActionArg.mk);
        AppMethodBeat.o(144868);
        return a2;
    }
}
