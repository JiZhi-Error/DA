package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.FillRectActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class k implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144891);
        FillRectActionArg fillRectActionArg = new FillRectActionArg();
        AppMethodBeat.o(144891);
        return fillRectActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "fillRect";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144892);
        if (jSONArray.length() < 4) {
            AppMethodBeat.o(144892);
            return false;
        }
        boolean a2 = a(dVar, canvas, g.f(jSONArray, 0), g.f(jSONArray, 1), g.f(jSONArray, 2), g.f(jSONArray, 3));
        AppMethodBeat.o(144892);
        return a2;
    }

    private static boolean a(d dVar, Canvas canvas, float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(144893);
        canvas.drawRect(f2, f3, f2 + f4, f3 + f5, dVar.kZm);
        AppMethodBeat.o(144893);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144894);
        FillRectActionArg fillRectActionArg = (FillRectActionArg) drawActionArg;
        if (fillRectActionArg == null) {
            AppMethodBeat.o(144894);
            return false;
        }
        boolean a2 = a(dVar, canvas, fillRectActionArg.x, fillRectActionArg.y, fillRectActionArg.width, fillRectActionArg.height);
        AppMethodBeat.o(144894);
        return a2;
    }
}
