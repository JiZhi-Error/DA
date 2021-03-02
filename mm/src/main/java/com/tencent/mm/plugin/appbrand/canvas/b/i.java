package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathQuadraticCurveToActionArg;
import org.json.JSONArray;

public final class i implements a {
    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final String getMethod() {
        return "quadraticCurveTo";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final boolean a(Path path, JSONArray jSONArray) {
        AppMethodBeat.i(145375);
        if (jSONArray.length() < 4) {
            AppMethodBeat.o(145375);
            return false;
        }
        boolean a2 = a(path, g.f(jSONArray, 0), g.f(jSONArray, 1), g.f(jSONArray, 2), g.f(jSONArray, 3));
        AppMethodBeat.o(145375);
        return a2;
    }

    private static boolean a(Path path, float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(145376);
        path.quadTo(f2, f3, f4, f5);
        AppMethodBeat.o(145376);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final boolean a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(145377);
        PathQuadraticCurveToActionArg pathQuadraticCurveToActionArg = (PathQuadraticCurveToActionArg) basePathActionArg;
        if (basePathActionArg == null) {
            AppMethodBeat.o(145377);
            return false;
        }
        boolean a2 = a(path, pathQuadraticCurveToActionArg.x1, pathQuadraticCurveToActionArg.y1, pathQuadraticCurveToActionArg.x2, pathQuadraticCurveToActionArg.y2);
        AppMethodBeat.o(145377);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final BasePathActionArg bzv() {
        AppMethodBeat.i(145378);
        PathQuadraticCurveToActionArg pathQuadraticCurveToActionArg = new PathQuadraticCurveToActionArg();
        AppMethodBeat.o(145378);
        return pathQuadraticCurveToActionArg;
    }
}
