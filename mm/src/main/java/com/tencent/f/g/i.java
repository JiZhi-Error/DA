package com.tencent.f.g;

import com.tencent.f.g.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class i extends a {
    private volatile int limit;

    public i(int i2) {
        this.limit = i2;
    }

    @Override // com.tencent.f.g.a.b
    public final boolean c(g gVar) {
        AppMethodBeat.i(183340);
        if (this.limit >= gVar.hmu()) {
            AppMethodBeat.o(183340);
            return true;
        }
        AppMethodBeat.o(183340);
        return false;
    }

    @Override // com.tencent.f.g.a.b
    public final long a(g gVar, TimeUnit timeUnit) {
        return -1;
    }
}
