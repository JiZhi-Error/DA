package com.plattysoft.leonids.a;

import com.plattysoft.leonids.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public final class d implements b {
    private float Rkj;
    private float RnB;

    public d(float f2, float f3) {
        this.RnB = f2;
        this.Rkj = f3;
    }

    @Override // com.plattysoft.leonids.a.b
    public final void a(a aVar, Random random) {
        AppMethodBeat.i(261927);
        aVar.dhh = (random.nextFloat() * (this.Rkj - this.RnB)) + this.RnB;
        AppMethodBeat.o(261927);
    }
}
