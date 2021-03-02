package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.k;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;

public final class p extends k {
    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.k
    public final boolean bze() {
        return q.INSTANCE.qtB;
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.k
    public final boolean bzf() {
        AppMethodBeat.i(226946);
        boolean bIi = q.bIi();
        AppMethodBeat.o(226946);
        return bIi;
    }
}
