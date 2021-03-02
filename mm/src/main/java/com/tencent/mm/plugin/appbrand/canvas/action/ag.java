package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextAlignActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class ag implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144973);
        SetTextAlignActionArg setTextAlignActionArg = new SetTextAlignActionArg();
        AppMethodBeat.o(144973);
        return setTextAlignActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setTextAlign";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144974);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(144974);
            return false;
        }
        boolean b2 = b(dVar, jSONArray.optString(0));
        AppMethodBeat.o(144974);
        return b2;
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(144975);
        if ("left".equalsIgnoreCase(str)) {
            dVar.kZl.setTextAlign(Paint.Align.LEFT);
            dVar.kZm.setTextAlign(Paint.Align.LEFT);
        } else if ("right".equalsIgnoreCase(str)) {
            dVar.kZl.setTextAlign(Paint.Align.RIGHT);
            dVar.kZm.setTextAlign(Paint.Align.RIGHT);
        } else if ("center".equalsIgnoreCase(str)) {
            dVar.kZl.setTextAlign(Paint.Align.CENTER);
            dVar.kZm.setTextAlign(Paint.Align.CENTER);
        }
        AppMethodBeat.o(144975);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144976);
        SetTextAlignActionArg setTextAlignActionArg = (SetTextAlignActionArg) drawActionArg;
        if (setTextAlignActionArg == null) {
            AppMethodBeat.o(144976);
            return false;
        }
        boolean b2 = b(dVar, setTextAlignActionArg.kZR);
        AppMethodBeat.o(144976);
        return b2;
    }
}
