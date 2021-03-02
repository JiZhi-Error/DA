package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionLinearArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionNormalArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionRadialArg;

public final class h extends a<BaseDrawActionArg> {
    private static h lah = new h();

    static {
        AppMethodBeat.i(145329);
        AppMethodBeat.o(145329);
    }

    public static h bzs() {
        return lah;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.a.a
    public final <T> T WE(String str) {
        AppMethodBeat.i(145328);
        T t = null;
        if ("linear".equalsIgnoreCase(str)) {
            t = (T) new RealSetStrokeStyleActionLinearArg();
        } else if ("radial".equalsIgnoreCase(str)) {
            t = (T) new RealSetStrokeStyleActionRadialArg();
        } else if ("normal".equalsIgnoreCase(str)) {
            t = (T) new RealSetStrokeStyleActionNormalArg();
        }
        t.method = str;
        AppMethodBeat.o(145328);
        return t;
    }
}
