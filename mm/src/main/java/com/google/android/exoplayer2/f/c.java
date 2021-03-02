package com.google.android.exoplayer2.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c extends i {
    private final b bAi;

    public c(b bVar) {
        this.bAi = bVar;
    }

    @Override // com.google.android.exoplayer2.f.i
    public final void release() {
        AppMethodBeat.i(92803);
        this.bAi.a((i) this);
        AppMethodBeat.o(92803);
    }
}
