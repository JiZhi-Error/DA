package com.tencent.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public class e extends b {
    public e(int i2, int i3) {
        super(i2, i3);
    }

    @Override // com.tencent.f.g.a.b
    public final long a(g gVar, TimeUnit timeUnit) {
        AppMethodBeat.i(183326);
        long j2 = gVar.getLong("INCREMENT", 1);
        long j3 = gVar.getLong("LAST_INCREMENT", 0) + j2;
        gVar.put("LAST_INCREMENT", j2);
        gVar.put("INCREMENT", j3);
        long convert = timeUnit.convert(j3, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(183326);
        return convert;
    }
}
