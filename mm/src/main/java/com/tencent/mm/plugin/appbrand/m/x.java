package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.f;
import com.tencent.mm.appbrand.v8.h;
import com.tencent.mm.appbrand.v8.m;

public class x extends a {
    public x() {
        super((byte) 0);
    }

    public x(IJSRuntime.Config config) {
        super(config);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.m.a
    public IJSRuntime g(IJSRuntime.Config config) {
        AppMethodBeat.i(144175);
        h b2 = f.b(config);
        AppMethodBeat.o(144175);
        return b2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.m.a
    public final m a(IJSRuntime iJSRuntime, int i2) {
        AppMethodBeat.i(144176);
        m XA = ((h) iJSRuntime).XA();
        AppMethodBeat.o(144176);
        return XA;
    }
}
