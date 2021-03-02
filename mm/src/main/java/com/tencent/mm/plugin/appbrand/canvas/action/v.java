package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalAlphaActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;

public final class v implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144933);
        SetGlobalAlphaActionArg setGlobalAlphaActionArg = new SetGlobalAlphaActionArg();
        AppMethodBeat.o(144933);
        return setGlobalAlphaActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setGlobalAlpha";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144934);
        try {
            boolean a2 = a(dVar, jSONArray.getInt(0));
            AppMethodBeat.o(144934);
            return a2;
        } catch (JSONException e2) {
            Log.e("MicroMsg.SetGlobalAlphaAction", "getGlobalAlpha value error. exception : %s", e2);
            AppMethodBeat.o(144934);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144936);
        SetGlobalAlphaActionArg setGlobalAlphaActionArg = (SetGlobalAlphaActionArg) drawActionArg;
        if (setGlobalAlphaActionArg == null) {
            AppMethodBeat.o(144936);
            return false;
        }
        boolean a2 = a(dVar, setGlobalAlphaActionArg.alpha);
        AppMethodBeat.o(144936);
        return a2;
    }

    private static boolean a(d dVar, int i2) {
        AppMethodBeat.i(144935);
        dVar.kZl.aG(((float) i2) / 255.0f);
        dVar.kZm.aG(((float) i2) / 255.0f);
        AppMethodBeat.o(144935);
        return true;
    }
}
