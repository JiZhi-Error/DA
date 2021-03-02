package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.ScaleActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class p implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144911);
        ScaleActionArg scaleActionArg = new ScaleActionArg();
        AppMethodBeat.o(144911);
        return scaleActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "scale";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144912);
        if (jSONArray.length() < 2) {
            AppMethodBeat.o(144912);
            return false;
        }
        canvas.scale((float) jSONArray.optDouble(0), (float) jSONArray.optDouble(1));
        AppMethodBeat.o(144912);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144913);
        ScaleActionArg scaleActionArg = (ScaleActionArg) drawActionArg;
        if (scaleActionArg == null) {
            AppMethodBeat.o(144913);
            return false;
        }
        canvas.scale(scaleActionArg.kZA, scaleActionArg.kZB);
        AppMethodBeat.o(144913);
        return true;
    }
}
