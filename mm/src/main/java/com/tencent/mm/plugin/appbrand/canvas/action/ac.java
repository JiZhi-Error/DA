package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SeMiterLimitActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class ac implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144958);
        SeMiterLimitActionArg seMiterLimitActionArg = new SeMiterLimitActionArg();
        AppMethodBeat.o(144958);
        return seMiterLimitActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setMiterLimit";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144959);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(144959);
            return false;
        }
        boolean a2 = a(dVar, (float) jSONArray.optDouble(0));
        AppMethodBeat.o(144959);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144961);
        SeMiterLimitActionArg seMiterLimitActionArg = (SeMiterLimitActionArg) drawActionArg;
        if (seMiterLimitActionArg == null) {
            AppMethodBeat.o(144961);
            return false;
        }
        boolean a2 = a(dVar, seMiterLimitActionArg.kZI);
        AppMethodBeat.o(144961);
        return a2;
    }

    private static boolean a(d dVar, float f2) {
        AppMethodBeat.i(144960);
        dVar.kZm.setStrokeMiter(f2);
        dVar.kZl.setStrokeMiter(f2);
        AppMethodBeat.o(144960);
        return true;
    }
}
