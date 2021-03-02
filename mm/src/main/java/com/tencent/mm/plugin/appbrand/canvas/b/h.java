package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathMoveToActionArg;
import org.json.JSONArray;

public final class h implements a {
    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final String getMethod() {
        return "moveTo";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final boolean a(Path path, JSONArray jSONArray) {
        AppMethodBeat.i(145372);
        if (jSONArray.length() < 2) {
            AppMethodBeat.o(145372);
            return false;
        }
        path.moveTo(g.f(jSONArray, 0), g.f(jSONArray, 1));
        AppMethodBeat.o(145372);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final boolean a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(145373);
        PathMoveToActionArg pathMoveToActionArg = (PathMoveToActionArg) basePathActionArg;
        if (pathMoveToActionArg == null) {
            AppMethodBeat.o(145373);
            return false;
        }
        path.moveTo(pathMoveToActionArg.x, pathMoveToActionArg.y);
        AppMethodBeat.o(145373);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final BasePathActionArg bzv() {
        AppMethodBeat.i(145374);
        PathMoveToActionArg pathMoveToActionArg = new PathMoveToActionArg();
        AppMethodBeat.o(145374);
        return pathMoveToActionArg;
    }
}
