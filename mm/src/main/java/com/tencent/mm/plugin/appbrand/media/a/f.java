package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;

public final class f {
    public static e c(WxaPkg.Info info) {
        AppMethodBeat.i(182599);
        if (info == null) {
            AppMethodBeat.o(182599);
            return null;
        } else if (g.bOQ()) {
            e eVar = new e(info.fileName, info.kMK);
            AppMethodBeat.o(182599);
            return eVar;
        } else {
            d dVar = new d(info.fileName, info.kMK);
            AppMethodBeat.o(182599);
            return dVar;
        }
    }
}
