package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

public final class d implements m {
    @Override // com.google.android.exoplayer2.c.m
    public final void f(Format format) {
    }

    @Override // com.google.android.exoplayer2.c.m
    public final int a(f fVar, int i2, boolean z) {
        AppMethodBeat.i(91974);
        int dO = fVar.dO(i2);
        if (dO != -1) {
            AppMethodBeat.o(91974);
            return dO;
        } else if (z) {
            AppMethodBeat.o(91974);
            return -1;
        } else {
            EOFException eOFException = new EOFException();
            AppMethodBeat.o(91974);
            throw eOFException;
        }
    }

    @Override // com.google.android.exoplayer2.c.m
    public final void a(m mVar, int i2) {
        AppMethodBeat.i(91975);
        mVar.eZ(i2);
        AppMethodBeat.o(91975);
    }

    @Override // com.google.android.exoplayer2.c.m
    public final void a(long j2, int i2, int i3, int i4, m.a aVar) {
    }
}
