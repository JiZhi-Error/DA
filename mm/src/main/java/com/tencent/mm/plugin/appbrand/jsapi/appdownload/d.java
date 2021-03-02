package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;

public final class d extends b {
    public static final int CTRL_INDEX = 662;
    public static final String NAME = "onDownloadAppStateChangeForNative";

    private d(s sVar) {
        super(sVar);
    }

    public static void n(s sVar) {
        AppMethodBeat.i(45742);
        if (lCV.containsKey(sVar.getAppId())) {
            AppMethodBeat.o(45742);
            return;
        }
        a(sVar, new d(sVar));
        AppMethodBeat.o(45742);
    }
}
