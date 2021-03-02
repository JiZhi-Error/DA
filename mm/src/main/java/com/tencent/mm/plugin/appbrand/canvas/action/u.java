package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontWeightArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;

public final class u implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144929);
        SetFontWeightArg setFontWeightArg = new SetFontWeightArg();
        AppMethodBeat.o(144929);
        return setFontWeightArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setFontWeight";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144930);
        if (jSONArray.length() == 0) {
            AppMethodBeat.o(144930);
            return false;
        }
        try {
            boolean b2 = b(dVar, jSONArray.getString(0));
            AppMethodBeat.o(144930);
            return b2;
        } catch (JSONException e2) {
            Log.i("MicroMsg.SetFontWeight", "get 'fontWeight' error.");
            AppMethodBeat.o(144930);
            return false;
        }
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(144931);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1039745817:
                if (str.equals("normal")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3029637:
                if (str.equals("bold")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                dVar.kZl.setFakeBoldText(true);
                dVar.kZm.setFakeBoldText(true);
                break;
            case 1:
                dVar.kZl.setFakeBoldText(false);
                dVar.kZm.setFakeBoldText(false);
                break;
        }
        AppMethodBeat.o(144931);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144932);
        SetFontWeightArg setFontWeightArg = (SetFontWeightArg) drawActionArg;
        if (setFontWeightArg == null) {
            AppMethodBeat.o(144932);
            return false;
        }
        boolean b2 = b(dVar, setFontWeightArg.cNw);
        AppMethodBeat.o(144932);
        return b2;
    }
}
