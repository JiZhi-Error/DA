package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.ClearRectActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;

public final class a implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144855);
        ClearRectActionArg clearRectActionArg = new ClearRectActionArg();
        AppMethodBeat.o(144855);
        return clearRectActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "clearRect";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144856);
        if (jSONArray.length() < 4) {
            AppMethodBeat.o(144856);
            return false;
        }
        boolean a2 = a(dVar, canvas, g.f(jSONArray, 0), g.f(jSONArray, 1), g.f(jSONArray, 2), g.f(jSONArray, 3));
        AppMethodBeat.o(144856);
        return a2;
    }

    private static boolean a(d dVar, Canvas canvas, float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(144857);
        if (canvas.isHardwareAccelerated()) {
            if (canvas instanceof f) {
                ((f) canvas).l(f2, f3, f2 + f4, f3 + f5);
                Log.v("MicroMsg.ClearRectAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5));
                AppMethodBeat.o(144857);
                return true;
            } else if (dVar.kZq != null) {
                canvas.drawRect(f2, f3, f2 + f4, f3 + f5, dVar.kZq);
                Log.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5));
                AppMethodBeat.o(144857);
                return true;
            } else {
                Log.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5));
                AppMethodBeat.o(144857);
                return false;
            }
        } else if (dVar.kZq != null) {
            canvas.drawRect(f2, f3, f2 + f4, f3 + f5, dVar.kZq);
            Log.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5));
            AppMethodBeat.o(144857);
            return true;
        } else {
            canvas.drawRect(f2, f3, f2 + f4, f3 + f5, dVar.kZp);
            Log.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5));
            AppMethodBeat.o(144857);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144858);
        if (drawActionArg == null || !(drawActionArg instanceof ClearRectActionArg)) {
            AppMethodBeat.o(144858);
            return false;
        }
        ClearRectActionArg clearRectActionArg = (ClearRectActionArg) drawActionArg;
        boolean a2 = a(dVar, canvas, clearRectActionArg.x, clearRectActionArg.y, clearRectActionArg.width, clearRectActionArg.height);
        AppMethodBeat.o(144858);
        return a2;
    }
}
