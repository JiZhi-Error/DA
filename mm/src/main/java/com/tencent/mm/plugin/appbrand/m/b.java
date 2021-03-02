package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.f;
import com.tencent.mm.appbrand.v8.y;

public final class b extends c {
    public b(IJSRuntime.Config config) {
        super(config);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.m.a, com.tencent.mm.plugin.appbrand.m.c
    public final IJSRuntime g(IJSRuntime.Config config) {
        AppMethodBeat.i(144157);
        y d2 = f.d(config);
        AppMethodBeat.o(144157);
        return d2;
    }
}
