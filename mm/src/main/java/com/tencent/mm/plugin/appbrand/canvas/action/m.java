package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DefaultDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class m implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144899);
        DefaultDrawActionArg defaultDrawActionArg = new DefaultDrawActionArg();
        AppMethodBeat.o(144899);
        return defaultDrawActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "restore";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144900);
        boolean a2 = a(dVar, canvas);
        AppMethodBeat.o(144900);
        return a2;
    }

    private static boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(144901);
        canvas.restore();
        dVar.restore();
        AppMethodBeat.o(144901);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144902);
        boolean a2 = a(dVar, canvas);
        AppMethodBeat.o(144902);
        return a2;
    }
}
