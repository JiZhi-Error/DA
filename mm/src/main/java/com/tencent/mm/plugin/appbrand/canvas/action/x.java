package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineCapActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class x implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144941);
        SetLineCapActionArg setLineCapActionArg = new SetLineCapActionArg();
        AppMethodBeat.o(144941);
        return setLineCapActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setLineCap";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144942);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(144942);
            return false;
        }
        boolean b2 = b(dVar, jSONArray.optString(0));
        AppMethodBeat.o(144942);
        return b2;
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(144943);
        if ("butt".equalsIgnoreCase(str)) {
            dVar.kZm.setStrokeCap(Paint.Cap.BUTT);
            dVar.kZl.setStrokeCap(Paint.Cap.BUTT);
        } else if ("round".equalsIgnoreCase(str)) {
            dVar.kZm.setStrokeCap(Paint.Cap.ROUND);
            dVar.kZl.setStrokeCap(Paint.Cap.ROUND);
        } else if (MessengerShareContentUtility.IMAGE_RATIO_SQUARE.equalsIgnoreCase(str)) {
            dVar.kZm.setStrokeCap(Paint.Cap.SQUARE);
            dVar.kZl.setStrokeCap(Paint.Cap.SQUARE);
        }
        AppMethodBeat.o(144943);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144944);
        SetLineCapActionArg setLineCapActionArg = (SetLineCapActionArg) drawActionArg;
        if (setLineCapActionArg == null) {
            AppMethodBeat.o(144944);
            return false;
        }
        boolean b2 = b(dVar, setLineCapActionArg.kZK);
        AppMethodBeat.o(144944);
        return b2;
    }
}
