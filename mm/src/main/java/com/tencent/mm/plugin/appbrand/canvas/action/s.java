package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontSizeActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class s implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144921);
        SetFontSizeActionArg setFontSizeActionArg = new SetFontSizeActionArg();
        AppMethodBeat.o(144921);
        return setFontSizeActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setFontSize";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144922);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(144922);
            return false;
        }
        boolean a2 = a(dVar, g.c(jSONArray, 0));
        AppMethodBeat.o(144922);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144924);
        SetFontSizeActionArg setFontSizeActionArg = (SetFontSizeActionArg) drawActionArg;
        if (setFontSizeActionArg == null) {
            AppMethodBeat.o(144924);
            return false;
        }
        boolean a2 = a(dVar, setFontSizeActionArg.size);
        AppMethodBeat.o(144924);
        return a2;
    }

    private static boolean a(d dVar, int i2) {
        AppMethodBeat.i(144923);
        dVar.kZm.setTextSize((float) i2);
        dVar.kZl.setTextSize((float) i2);
        AppMethodBeat.o(144923);
        return true;
    }
}
