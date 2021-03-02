package com.tencent.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class f extends b {
    private final long RUa = 1000;
    private final float dwT = 500.0f;

    public f(int i2, int i3) {
        super(i2, i3);
    }

    @Override // com.tencent.f.g.a.b
    public final long a(g gVar, TimeUnit timeUnit) {
        int intValue;
        AppMethodBeat.i(183327);
        Object obj = gVar.map.get("incrementCount");
        if (obj == null) {
            intValue = 1;
        } else {
            intValue = ((Integer) obj).intValue();
        }
        gVar.map.put("incrementCount", Integer.valueOf(intValue + 1));
        long convert = timeUnit.convert((long) (((float) this.RUa) + (((float) intValue) * this.dwT)), TimeUnit.MILLISECONDS);
        AppMethodBeat.o(183327);
        return convert;
    }
}
