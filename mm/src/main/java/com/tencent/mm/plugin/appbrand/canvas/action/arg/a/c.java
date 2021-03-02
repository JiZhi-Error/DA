package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.d;

public final class c extends a<BaseDrawActionArg> {
    private static com.tencent.mm.plugin.appbrand.canvas.c kZY = new com.tencent.mm.plugin.appbrand.canvas.c();
    private static c kZZ = new c();

    static {
        AppMethodBeat.i(145318);
        AppMethodBeat.o(145318);
    }

    public static c bzn() {
        return kZZ;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.a.a
    public final <T> T WE(String str) {
        AppMethodBeat.i(145317);
        d dVar = kZY.kZk.get(str);
        if (dVar == null) {
            AppMethodBeat.o(145317);
            return null;
        }
        T t = (T) dVar.bzj();
        AppMethodBeat.o(145317);
        return t;
    }
}
