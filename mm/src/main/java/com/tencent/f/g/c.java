package com.tencent.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class c extends b {
    private long RUa = 1000;

    public c(int i2, int i3) {
        super(i2, i3);
    }

    @Override // com.tencent.f.g.a.b
    public final long a(g gVar, TimeUnit timeUnit) {
        AppMethodBeat.i(183325);
        long convert = timeUnit.convert(this.RUa, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(183325);
        return convert;
    }
}
