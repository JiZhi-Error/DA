package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g extends Exception {
    public g(String str) {
        super(str);
    }

    public g(Throwable th) {
        super(th.toString(), th);
        AppMethodBeat.i(234788);
        AppMethodBeat.o(234788);
    }
}
