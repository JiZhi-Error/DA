package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DefaultDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class o implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144907);
        DefaultDrawActionArg defaultDrawActionArg = new DefaultDrawActionArg();
        AppMethodBeat.o(144907);
        return defaultDrawActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "save";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144908);
        boolean a2 = a(dVar, canvas);
        AppMethodBeat.o(144908);
        return a2;
    }

    private static boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(144909);
        canvas.save();
        dVar.save();
        AppMethodBeat.o(144909);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144910);
        boolean a2 = a(dVar, canvas);
        AppMethodBeat.o(144910);
        return a2;
    }
}
