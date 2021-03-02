package com.tencent.mm.plugin.appbrand.task.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.permission.i;

public final class d implements i {
    @Override // com.tencent.mm.plugin.appbrand.permission.i
    public final boolean aeo(String str) {
        AppMethodBeat.i(227540);
        boolean z = p.Un(str).kDe;
        AppMethodBeat.o(227540);
        return z;
    }
}
