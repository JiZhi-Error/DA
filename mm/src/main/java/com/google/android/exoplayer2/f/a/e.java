package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends i {
    private final d bBE;

    public e(d dVar) {
        this.bBE = dVar;
    }

    @Override // com.google.android.exoplayer2.f.i
    public final void release() {
        AppMethodBeat.i(92784);
        d dVar = this.bBE;
        clear();
        dVar.bBB.add(this);
        AppMethodBeat.o(92784);
    }
}
