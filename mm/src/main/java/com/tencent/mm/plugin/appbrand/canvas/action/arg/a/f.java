package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.b.e;

public final class f extends a<BasePathActionArg> {
    private static f laf = new f();

    static {
        AppMethodBeat.i(145325);
        AppMethodBeat.o(145325);
    }

    public static f bzq() {
        return laf;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.a.a
    public final <T> T WE(String str) {
        AppMethodBeat.i(145324);
        T t = (T) e.a.law.lav.get(str).bzv();
        AppMethodBeat.o(145324);
        return t;
    }
}
