package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.TranslateActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class ak implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144989);
        TranslateActionArg translateActionArg = new TranslateActionArg();
        AppMethodBeat.o(144989);
        return translateActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "translate";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144990);
        if (jSONArray.length() < 2) {
            AppMethodBeat.o(144990);
            return false;
        }
        canvas.translate(g.f(jSONArray, 0), g.f(jSONArray, 1));
        AppMethodBeat.o(144990);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144991);
        TranslateActionArg translateActionArg = (TranslateActionArg) drawActionArg;
        if (translateActionArg == null) {
            AppMethodBeat.o(144991);
            return false;
        }
        canvas.translate(translateActionArg.x, translateActionArg.y);
        AppMethodBeat.o(144991);
        return true;
    }
}
