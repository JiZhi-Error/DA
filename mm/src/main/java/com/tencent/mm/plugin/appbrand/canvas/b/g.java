package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathLineToActionArg;
import org.json.JSONArray;

public final class g implements a {
    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final String getMethod() {
        return "lineTo";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final boolean a(Path path, JSONArray jSONArray) {
        AppMethodBeat.i(145369);
        if (jSONArray.length() < 2) {
            AppMethodBeat.o(145369);
            return false;
        }
        path.lineTo(com.tencent.mm.plugin.appbrand.ac.g.f(jSONArray, 0), com.tencent.mm.plugin.appbrand.ac.g.f(jSONArray, 1));
        AppMethodBeat.o(145369);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final boolean a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(145370);
        PathLineToActionArg pathLineToActionArg = (PathLineToActionArg) basePathActionArg;
        if (pathLineToActionArg == null) {
            AppMethodBeat.o(145370);
            return false;
        }
        path.lineTo(pathLineToActionArg.x, pathLineToActionArg.y);
        AppMethodBeat.o(145370);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final BasePathActionArg bzv() {
        AppMethodBeat.i(145371);
        PathLineToActionArg pathLineToActionArg = new PathLineToActionArg();
        AppMethodBeat.o(145371);
        return pathLineToActionArg;
    }
}
