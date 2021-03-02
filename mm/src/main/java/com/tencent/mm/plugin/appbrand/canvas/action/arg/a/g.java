package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionLinearArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionNormalArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionPatternArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionRadialArg;

public final class g extends a<BaseDrawActionArg> {
    private static g lag = new g();

    static {
        AppMethodBeat.i(145327);
        AppMethodBeat.o(145327);
    }

    public static g bzr() {
        return lag;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.a.a
    public final <T> T WE(String str) {
        AppMethodBeat.i(145326);
        T t = null;
        if ("linear".equalsIgnoreCase(str)) {
            t = (T) new RealSetFillStyleActionLinearArg();
        } else if ("radial".equalsIgnoreCase(str)) {
            t = (T) new RealSetFillStyleActionRadialArg();
        } else if ("normal".equalsIgnoreCase(str)) {
            t = (T) new RealSetFillStyleActionNormalArg();
        } else if ("pattern".equalsIgnoreCase(str)) {
            t = (T) new RealSetFillStyleActionPatternArg();
        }
        t.method = str;
        AppMethodBeat.o(145326);
        return t;
    }
}
