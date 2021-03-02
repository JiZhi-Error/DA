package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontFamilyActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;

public final class r implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144917);
        SetFontFamilyActionArg setFontFamilyActionArg = new SetFontFamilyActionArg();
        AppMethodBeat.o(144917);
        return setFontFamilyActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setFontFamily";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144918);
        if (jSONArray.length() == 0) {
            AppMethodBeat.o(144918);
            return false;
        }
        try {
            boolean b2 = b(dVar, jSONArray.getString(0));
            AppMethodBeat.o(144918);
            return b2;
        } catch (JSONException e2) {
            Log.i("MicroMsg.SetFontFamily", "get 'fontFamily' error.");
            AppMethodBeat.o(144918);
            return false;
        }
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(144919);
        if (!TextUtils.isEmpty(str)) {
            dVar.kZl.WF(str);
            dVar.kZm.WF(str);
            AppMethodBeat.o(144919);
            return true;
        }
        AppMethodBeat.o(144919);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144920);
        SetFontFamilyActionArg setFontFamilyActionArg = (SetFontFamilyActionArg) drawActionArg;
        if (setFontFamilyActionArg == null) {
            AppMethodBeat.o(144920);
            return false;
        }
        boolean b2 = b(dVar, setFontFamilyActionArg.fontFamily);
        AppMethodBeat.o(144920);
        return b2;
    }
}
