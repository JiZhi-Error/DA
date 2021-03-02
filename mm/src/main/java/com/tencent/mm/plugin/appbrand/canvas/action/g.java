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

public final class g implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144875);
        PathActionArgWrapper pathActionArgWrapper = new PathActionArgWrapper();
        AppMethodBeat.o(144875);
        return pathActionArgWrapper;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "strokePath";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144876);
        boolean a2 = a(dVar, canvas, e.a.law.g(jSONArray));
        AppMethodBeat.o(144876);
        return a2;
    }

    private static boolean a(d dVar, Canvas canvas, Path path) {
        AppMethodBeat.i(144877);
        canvas.drawPath(path, dVar.kZl);
        AppMethodBeat.o(144877);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144878);
        boolean a2 = a(dVar, canvas, e.a.law.a((PathActionArgWrapper) drawActionArg));
        AppMethodBeat.o(144878);
        return a2;
    }
}
