package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathBezierCurveToActionArg;
import org.json.JSONArray;

public final class d implements a {
    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final String getMethod() {
        return "bezierCurveTo";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final boolean a(Path path, JSONArray jSONArray) {
        AppMethodBeat.i(145355);
        if (jSONArray.length() < 6) {
            AppMethodBeat.o(145355);
            return false;
        }
        boolean a2 = a(path, g.f(jSONArray, 0), g.f(jSONArray, 1), g.f(jSONArray, 2), g.f(jSONArray, 3), g.f(jSONArray, 4), g.f(jSONArray, 5));
        AppMethodBeat.o(145355);
        return a2;
    }

    private static boolean a(Path path, float f2, float f3, float f4, float f5, float f6, float f7) {
        AppMethodBeat.i(145356);
        path.cubicTo(f2, f3, f4, f5, f6, f7);
        AppMethodBeat.o(145356);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final boolean a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(145357);
        PathBezierCurveToActionArg pathBezierCurveToActionArg = (PathBezierCurveToActionArg) basePathActionArg;
        if (pathBezierCurveToActionArg == null) {
            AppMethodBeat.o(145357);
            return false;
        }
        boolean a2 = a(path, pathBezierCurveToActionArg.x1, pathBezierCurveToActionArg.y1, pathBezierCurveToActionArg.x2, pathBezierCurveToActionArg.y2, pathBezierCurveToActionArg.x3, pathBezierCurveToActionArg.y3);
        AppMethodBeat.o(145357);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final BasePathActionArg bzv() {
        AppMethodBeat.i(145358);
        PathBezierCurveToActionArg pathBezierCurveToActionArg = new PathBezierCurveToActionArg();
        AppMethodBeat.o(145358);
        return pathBezierCurveToActionArg;
    }
}
