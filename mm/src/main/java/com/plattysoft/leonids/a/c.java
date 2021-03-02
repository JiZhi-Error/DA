package com.plattysoft.leonids.a;

import com.plattysoft.leonids.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public final class c implements b {
    private float oll = 90.0f;
    private float olm = 180.0f;

    @Override // com.plattysoft.leonids.a.b
    public final void a(a aVar, Random random) {
        AppMethodBeat.i(261926);
        aVar.hHo = (random.nextFloat() * (this.olm - this.oll)) + this.oll;
        AppMethodBeat.o(261926);
    }
}
