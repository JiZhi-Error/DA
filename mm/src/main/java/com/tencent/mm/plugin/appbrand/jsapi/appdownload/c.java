package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;

public final class c extends b {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onDownloadAppStateChange";

    private c(s sVar) {
        super(sVar);
    }

    public static void n(s sVar) {
        AppMethodBeat.i(45741);
        if (lCV.containsKey(sVar.getAppId())) {
            AppMethodBeat.o(45741);
            return;
        }
        a(sVar, new c(sVar));
        AppMethodBeat.o(45741);
    }
}
