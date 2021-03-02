package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper;
import com.tencent.mm.plugin.appbrand.canvas.b.e;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class j implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144887);
        PathActionArgWrapper pathActionArgWrapper = new PathActionArgWrapper();
        AppMethodBeat.o(144887);
        return pathActionArgWrapper;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "fillPath";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144888);
        boolean a2 = a(dVar, canvas, e.a.law.g(jSONArray));
        AppMethodBeat.o(144888);
        return a2;
    }

    private static boolean a(d dVar, Canvas canvas, Path path) {
        AppMethodBeat.i(144889);
        canvas.drawPath(path, dVar.kZm);
        AppMethodBeat.o(144889);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144890);
        boolean a2 = a(dVar, canvas, e.a.law.a((PathActionArgWrapper) drawActionArg));
        AppMethodBeat.o(144890);
        return a2;
    }
}
