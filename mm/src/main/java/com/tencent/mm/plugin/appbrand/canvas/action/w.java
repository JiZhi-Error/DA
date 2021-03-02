package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalCompositeOperationActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;
import org.json.JSONException;

public final class w implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144937);
        SetGlobalCompositeOperationActionArg setGlobalCompositeOperationActionArg = new SetGlobalCompositeOperationActionArg();
        AppMethodBeat.o(144937);
        return setGlobalCompositeOperationActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setGlobalCompositeOperation";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144938);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(144938);
            return false;
        }
        try {
            boolean b2 = b(dVar, jSONArray.getString(0));
            AppMethodBeat.o(144938);
            return b2;
        } catch (JSONException e2) {
            AppMethodBeat.o(144938);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144940);
        SetGlobalCompositeOperationActionArg setGlobalCompositeOperationActionArg = (SetGlobalCompositeOperationActionArg) drawActionArg;
        if (setGlobalCompositeOperationActionArg == null) {
            AppMethodBeat.o(144940);
            return false;
        }
        boolean b2 = b(dVar, setGlobalCompositeOperationActionArg.type);
        AppMethodBeat.o(144940);
        return b2;
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(144939);
        a aVar = dVar.kZm;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2120744511:
                if (str.equals("luminosity")) {
                    c2 = 24;
                    break;
                }
                break;
            case -1763725041:
                if (str.equals("destination-out")) {
                    c2 = 6;
                    break;
                }
                break;
            case -1698458601:
                if (str.equals("source-in")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1427739212:
                if (str.equals("hard-light")) {
                    c2 = 17;
                    break;
                }
                break;
            case -1338968417:
                if (str.equals("darken")) {
                    c2 = '\r';
                    break;
                }
                break;
            case -1247677005:
                if (str.equals("soft-light")) {
                    c2 = 18;
                    break;
                }
                break;
            case -1112602980:
                if (str.equals("source-out")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1091287984:
                if (str.equals("overlay")) {
                    c2 = '\f';
                    break;
                }
                break;
            case -230491182:
                if (str.equals("saturation")) {
                    c2 = 22;
                    break;
                }
                break;
            case -131372090:
                if (str.equals("source-atop")) {
                    c2 = 3;
                    break;
                }
                break;
            case -130953402:
                if (str.equals("source-over")) {
                    c2 = 0;
                    break;
                }
                break;
            case -120580883:
                if (str.equals("color-dodge")) {
                    c2 = 15;
                    break;
                }
                break;
            case 103672:
                if (str.equals("hue")) {
                    c2 = 21;
                    break;
                }
                break;
            case 118875:
                if (str.equals("xor")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 3059573:
                if (str.equals("copy")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c2 = 23;
                    break;
                }
                break;
            case 170546239:
                if (str.equals("lighten")) {
                    c2 = 14;
                    break;
                }
                break;
            case 170546243:
                if (str.equals("lighter")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 653829668:
                if (str.equals("multiply")) {
                    c2 = 11;
                    break;
                }
                break;
            case 912936772:
                if (str.equals("destination-in")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1158680499:
                if (str.equals("destination-atop")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1159099187:
                if (str.equals("destination-over")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1242982905:
                if (str.equals("color-burn")) {
                    c2 = 16;
                    break;
                }
                break;
            case 1686617550:
                if (str.equals("exclusion")) {
                    c2 = 20;
                    break;
                }
                break;
            case 1728361789:
                if (str.equals("difference")) {
                    c2 = 19;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                break;
            case 1:
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                break;
            case 2:
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
                break;
            case 3:
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
                break;
            case 4:
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                break;
            case 5:
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                break;
            case 6:
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                break;
            case 7:
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
                break;
            case '\b':
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
                break;
            case '\t':
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
                break;
            case '\n':
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
                break;
            case 11:
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
                break;
            case '\f':
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.OVERLAY));
                break;
            case '\r':
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
                break;
            case 14:
                aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
                break;
        }
        AppMethodBeat.o(144939);
        return true;
    }
}
