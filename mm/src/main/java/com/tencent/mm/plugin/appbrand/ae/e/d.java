package com.tencent.mm.plugin.appbrand.ae.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends g implements b {
    private String oiF = "*";

    @Override // com.tencent.mm.plugin.appbrand.ae.e.b
    public final void afO(String str) {
        AppMethodBeat.i(156664);
        if (str == null) {
            Log.i("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
            AppMethodBeat.o(156664);
            return;
        }
        this.oiF = str;
        AppMethodBeat.o(156664);
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.e.a
    public final String bZL() {
        return this.oiF;
    }
}
