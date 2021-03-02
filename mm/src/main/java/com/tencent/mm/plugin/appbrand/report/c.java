package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c implements n {
    @Override // com.tencent.mm.plugin.appbrand.service.n
    public final String bUg() {
        AppMethodBeat.i(227364);
        String networkType = i.getNetworkType(MMApplicationContext.getContext());
        AppMethodBeat.o(227364);
        return networkType;
    }
}
