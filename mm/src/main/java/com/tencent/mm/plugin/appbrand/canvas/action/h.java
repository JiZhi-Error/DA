package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawRectActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class h implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144879);
        DrawRectActionArg drawRectActionArg = new DrawRectActionArg();
        AppMethodBeat.o(144879);
        return drawRectActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "strokeRect";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144880);
        if (jSONArray.length() < 4) {
            AppMethodBeat.o(144880);
            return false;
        }
        boolean a2 = a(dVar, canvas, g.f(jSONArray, 0), g.f(jSONArray, 1), g.f(jSONArray, 2), g.f(jSONArray, 3));
        AppMethodBeat.o(144880);
        return a2;
    }

    private static boolean a(d dVar, Canvas canvas, float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(144881);
        canvas.drawRect(f2, f3, f2 + f4, f3 + f5, dVar.kZl);
        AppMethodBeat.o(144881);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144882);
        DrawRectActionArg drawRectActionArg = (DrawRectActionArg) drawActionArg;
        if (drawRectActionArg == null) {
            AppMethodBeat.o(144882);
            return false;
        }
        boolean a2 = a(dVar, canvas, drawRectActionArg.x, drawRectActionArg.y, drawRectActionArg.width, drawRectActionArg.height);
        AppMethodBeat.o(144882);
        return a2;
    }
}
