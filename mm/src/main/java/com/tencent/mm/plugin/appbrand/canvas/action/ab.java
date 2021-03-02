package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineWidthActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class ab implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144954);
        SetLineWidthActionArg setLineWidthActionArg = new SetLineWidthActionArg();
        AppMethodBeat.o(144954);
        return setLineWidthActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setLineWidth";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144955);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(144955);
            return false;
        }
        boolean a2 = a(dVar, g.f(jSONArray, 0));
        AppMethodBeat.o(144955);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144957);
        SetLineWidthActionArg setLineWidthActionArg = (SetLineWidthActionArg) drawActionArg;
        if (setLineWidthActionArg == null) {
            AppMethodBeat.o(144957);
            return false;
        }
        boolean a2 = a(dVar, setLineWidthActionArg.kZO);
        AppMethodBeat.o(144957);
        return a2;
    }

    private static boolean a(d dVar, float f2) {
        AppMethodBeat.i(144956);
        dVar.kZm.setStrokeWidth(f2);
        dVar.kZl.setStrokeWidth(f2);
        AppMethodBeat.o(144956);
        return true;
    }
}
