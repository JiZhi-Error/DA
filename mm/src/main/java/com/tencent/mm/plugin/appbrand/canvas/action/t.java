package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontStyleActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;

public final class t implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144925);
        SetFontStyleActionArg setFontStyleActionArg = new SetFontStyleActionArg();
        AppMethodBeat.o(144925);
        return setFontStyleActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setFontStyle";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144926);
        if (jSONArray.length() == 0) {
            AppMethodBeat.o(144926);
            return false;
        }
        try {
            boolean b2 = b(dVar, jSONArray.getString(0));
            AppMethodBeat.o(144926);
            return b2;
        } catch (JSONException e2) {
            Log.i("MicroMsg.SetFontStyle", "get 'fontStyle' error.");
            AppMethodBeat.o(144926);
            return false;
        }
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(144927);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1657669071:
                if (str.equals("oblique")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1178781136:
                if (str.equals("italic")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                dVar.kZl.we(2);
                dVar.kZm.we(2);
                break;
            case 1:
                dVar.kZl.we(2);
                dVar.kZm.we(2);
                break;
            case 2:
                dVar.kZl.we(0);
                dVar.kZm.we(0);
                break;
        }
        AppMethodBeat.o(144927);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144928);
        SetFontStyleActionArg setFontStyleActionArg = (SetFontStyleActionArg) drawActionArg;
        if (setFontStyleActionArg == null) {
            AppMethodBeat.o(144928);
            return false;
        }
        boolean b2 = b(dVar, setFontStyleActionArg.fontStyle);
        AppMethodBeat.o(144928);
        return b2;
    }
}
