package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;

final class a extends s {
    private static final int CTRL_INDEX = 246;
    private static final String NAME = "onStartReportPageData";
    private static final a mjH = new a();

    a() {
    }

    static synchronized void m(f fVar) {
        synchronized (a.class) {
            AppMethodBeat.i(147207);
            mjH.g(fVar).bEo();
            AppMethodBeat.o(147207);
        }
    }

    static {
        AppMethodBeat.i(147208);
        AppMethodBeat.o(147208);
    }
}
