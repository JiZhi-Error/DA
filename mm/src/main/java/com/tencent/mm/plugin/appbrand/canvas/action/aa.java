package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineJoinActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class aa implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144950);
        SetLineJoinActionArg setLineJoinActionArg = new SetLineJoinActionArg();
        AppMethodBeat.o(144950);
        return setLineJoinActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setLineJoin";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144951);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(144951);
            return false;
        }
        boolean b2 = b(dVar, jSONArray.optString(0));
        AppMethodBeat.o(144951);
        return b2;
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(144952);
        if ("miter".equalsIgnoreCase(str)) {
            dVar.kZm.setStrokeJoin(Paint.Join.MITER);
            dVar.kZl.setStrokeJoin(Paint.Join.MITER);
        } else if ("round".equalsIgnoreCase(str)) {
            dVar.kZm.setStrokeJoin(Paint.Join.ROUND);
            dVar.kZl.setStrokeJoin(Paint.Join.ROUND);
        } else if ("bevel".equalsIgnoreCase(str)) {
            dVar.kZm.setStrokeJoin(Paint.Join.BEVEL);
            dVar.kZl.setStrokeJoin(Paint.Join.BEVEL);
        }
        AppMethodBeat.o(144952);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144953);
        SetLineJoinActionArg setLineJoinActionArg = (SetLineJoinActionArg) drawActionArg;
        if (setLineJoinActionArg == null) {
            AppMethodBeat.o(144953);
            return false;
        }
        boolean b2 = b(dVar, setLineJoinActionArg.kZN);
        AppMethodBeat.o(144953);
        return b2;
    }
}
