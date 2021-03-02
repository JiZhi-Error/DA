package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r implements g.a {
    private final w<? super q> bEI;

    public r() {
        this((byte) 0);
    }

    private r(byte b2) {
        this.bEI = null;
    }

    @Override // com.google.android.exoplayer2.h.g.a
    public final g wG() {
        AppMethodBeat.i(93082);
        q qVar = new q(this.bEI);
        AppMethodBeat.o(93082);
        return qVar;
    }
}
