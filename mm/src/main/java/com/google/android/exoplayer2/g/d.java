package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends b {
    private final int bDZ;
    private final Object data;

    public d(q qVar, int i2) {
        this(qVar, i2, (byte) 0);
    }

    private d(q qVar, int i2, byte b2) {
        super(qVar, i2);
        AppMethodBeat.i(92947);
        this.bDZ = 0;
        this.data = null;
        AppMethodBeat.o(92947);
    }

    @Override // com.google.android.exoplayer2.g.f
    public final void af(long j2) {
    }

    @Override // com.google.android.exoplayer2.g.f
    public final int getSelectedIndex() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.g.f
    public final int vP() {
        return this.bDZ;
    }

    @Override // com.google.android.exoplayer2.g.f
    public final Object vQ() {
        return this.data;
    }
}
