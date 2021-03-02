package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;

public final class i extends AppBrandRuntime.b {
    public boolean chu = false;

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime.b
    public final void prepare() {
        this.chu = false;
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime.b
    public final void KY() {
        AppMethodBeat.i(226278);
        super.KY();
        this.chu = true;
        AppMethodBeat.o(226278);
    }
}
