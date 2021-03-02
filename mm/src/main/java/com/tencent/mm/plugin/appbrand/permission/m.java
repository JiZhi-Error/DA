package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;

public final class m extends l {
    public m(AppBrandRuntime appBrandRuntime) {
        super(appBrandRuntime);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.l, com.tencent.mm.plugin.appbrand.permission.j
    public final void aep(String str) {
        AppMethodBeat.i(47995);
        b.n(this.kEc, str);
        AppMethodBeat.o(47995);
    }
}
