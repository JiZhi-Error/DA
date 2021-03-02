package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawTextActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class l implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144895);
        DrawTextActionArg drawTextActionArg = new DrawTextActionArg();
        AppMethodBeat.o(144895);
        return drawTextActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "fillText";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144896);
        if (jSONArray.length() < 3) {
            AppMethodBeat.o(144896);
            return false;
        }
        boolean a2 = a(dVar, canvas, jSONArray.optString(0), g.f(jSONArray, 1), g.f(jSONArray, 2), g.f(jSONArray, 3));
        AppMethodBeat.o(144896);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144898);
        DrawTextActionArg drawTextActionArg = (DrawTextActionArg) drawActionArg;
        if (drawTextActionArg == null) {
            AppMethodBeat.o(144898);
            return false;
        }
        boolean a2 = a(dVar, canvas, drawTextActionArg.text, drawTextActionArg.x, drawTextActionArg.y, drawTextActionArg.maxWidth);
        AppMethodBeat.o(144898);
        return a2;
    }

    private static boolean a(d dVar, Canvas canvas, String str, float f2, float f3, float f4) {
        AppMethodBeat.i(144897);
        Paint.FontMetrics fontMetrics = dVar.kZl.getFontMetrics();
        if (dVar.kZl.laj == a.EnumC0560a.TOP) {
            f3 += Math.abs(fontMetrics.ascent);
        } else if (dVar.kZl.laj == a.EnumC0560a.MIDDLE) {
            f3 += Math.abs((((-fontMetrics.ascent) + fontMetrics.descent) / 2.0f) - fontMetrics.descent);
        } else if (dVar.kZl.laj == a.EnumC0560a.BOTTOM) {
            f3 -= Math.abs(fontMetrics.descent);
        }
        a aVar = dVar.kZm;
        float measureText = aVar.measureText(str);
        if (f4 <= 0.0f || f4 >= measureText) {
            canvas.drawText(str, f2, f3, aVar);
        } else {
            canvas.save();
            canvas.translate(f2, f3);
            canvas.scale(f4 / measureText, 1.0f);
            canvas.drawText(str, 0.0f, 0.0f, aVar);
            canvas.restore();
        }
        AppMethodBeat.o(144897);
        return true;
    }
}
