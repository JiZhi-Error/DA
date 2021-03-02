package com.google.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class b {
    final byte[] ceE;
    private int ceF = 0;

    b(int i2) {
        AppMethodBeat.i(12222);
        this.ceE = new byte[i2];
        AppMethodBeat.o(12222);
    }

    /* access modifiers changed from: package-private */
    public final void d(boolean z, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.ceF;
            this.ceF = i4 + 1;
            this.ceE[i4] = (byte) (z ? 1 : 0);
        }
    }
}
