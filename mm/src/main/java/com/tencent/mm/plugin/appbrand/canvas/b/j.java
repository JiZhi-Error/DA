package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathRectActionArg;
import org.json.JSONArray;

public final class j implements a {
    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final String getMethod() {
        return "rect";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final boolean a(Path path, JSONArray jSONArray) {
        AppMethodBeat.i(145379);
        if (jSONArray.length() < 4) {
            AppMethodBeat.o(145379);
            return false;
        }
        boolean a2 = a(path, g.f(jSONArray, 0), g.f(jSONArray, 1), g.f(jSONArray, 2), g.f(jSONArray, 3));
        AppMethodBeat.o(145379);
        return a2;
    }

    private static boolean a(Path path, float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(145380);
        path.addRect(f2, f3, f2 + f4, f3 + f5, Path.Direction.CW);
        AppMethodBeat.o(145380);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final boolean a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(145381);
        PathRectActionArg pathRectActionArg = (PathRectActionArg) basePathActionArg;
        if (pathRectActionArg == null) {
            AppMethodBeat.o(145381);
            return false;
        }
        boolean a2 = a(path, pathRectActionArg.x, pathRectActionArg.y, pathRectActionArg.width, pathRectActionArg.height);
        AppMethodBeat.o(145381);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final BasePathActionArg bzv() {
        AppMethodBeat.i(145382);
        PathRectActionArg pathRectActionArg = new PathRectActionArg();
        AppMethodBeat.o(145382);
        return pathRectActionArg;
    }
}
