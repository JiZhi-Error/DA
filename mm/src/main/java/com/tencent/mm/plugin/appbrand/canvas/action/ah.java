package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextBaseLineActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;

public final class ah implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144977);
        SetTextBaseLineActionArg setTextBaseLineActionArg = new SetTextBaseLineActionArg();
        AppMethodBeat.o(144977);
        return setTextBaseLineActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setTextBaseline";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144978);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(144978);
            return false;
        }
        boolean b2 = b(dVar, jSONArray.optString(0));
        AppMethodBeat.o(144978);
        return b2;
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(144979);
        Log.i("MicroMsg.SetTextBaselineAction", "SetTextBaselineAction, align:%s", str);
        if ("top".equalsIgnoreCase(str)) {
            dVar.kZl.laj = a.EnumC0560a.TOP;
            dVar.kZm.laj = a.EnumC0560a.TOP;
        } else if ("middle".equalsIgnoreCase(str)) {
            dVar.kZl.laj = a.EnumC0560a.MIDDLE;
            dVar.kZm.laj = a.EnumC0560a.MIDDLE;
        } else if ("bottom".equalsIgnoreCase(str)) {
            dVar.kZl.laj = a.EnumC0560a.BOTTOM;
            dVar.kZm.laj = a.EnumC0560a.BOTTOM;
        } else if ("normal".equalsIgnoreCase(str)) {
            dVar.kZl.laj = a.EnumC0560a.NORMAL;
            dVar.kZm.laj = a.EnumC0560a.NORMAL;
        }
        AppMethodBeat.o(144979);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144980);
        SetTextBaseLineActionArg setTextBaseLineActionArg = (SetTextBaseLineActionArg) drawActionArg;
        if (setTextBaseLineActionArg == null) {
            AppMethodBeat.o(144980);
            return false;
        }
        boolean b2 = b(dVar, setTextBaseLineActionArg.kZR);
        AppMethodBeat.o(144980);
        return b2;
    }
}
