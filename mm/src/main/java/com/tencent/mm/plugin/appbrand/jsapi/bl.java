package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;

public final class bl extends bk {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.bk
    public final Map<String, Object> d(d dVar) {
        AppMethodBeat.i(45493);
        Map<String, Object> d2 = super.d(dVar);
        d2.put("clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.KyO));
        d2.put("x5Version", Integer.valueOf(com.tencent.xweb.x5.sdk.d.getTbsVersion(MMApplicationContext.getContext())));
        AppMethodBeat.o(45493);
        return d2;
    }
}
