package com.google.android.exoplayer2.h.a;

import com.google.android.exoplayer2.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c implements f.a {
    private final a bFT;
    private final long bFU;
    private final int bufferSize;

    public c(a aVar, long j2) {
        this(aVar, j2, (byte) 0);
    }

    private c(a aVar, long j2, byte b2) {
        this.bFT = aVar;
        this.bFU = j2;
        this.bufferSize = 20480;
    }

    @Override // com.google.android.exoplayer2.h.f.a
    public final f wF() {
        AppMethodBeat.i(92965);
        b bVar = new b(this.bFT, this.bFU, this.bufferSize);
        AppMethodBeat.o(92965);
        return bVar;
    }
}
