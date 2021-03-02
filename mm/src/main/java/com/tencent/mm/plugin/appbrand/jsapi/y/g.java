package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.utils.ad;
import java.util.HashMap;

/* access modifiers changed from: package-private */
public final class g extends bc {
    static final int CTRL_INDEX = 473;
    static final String NAME = "onDeviceOrientationChange";

    g() {
    }

    /* access modifiers changed from: package-private */
    public final void b(ad.a aVar) {
        AppMethodBeat.i(137639);
        String replace = aVar.name().replace("_", "");
        HashMap hashMap = new HashMap(2);
        hashMap.put("errMsg", "ok");
        hashMap.put("value", replace);
        L(hashMap).bEo();
        AppMethodBeat.o(137639);
    }
}
