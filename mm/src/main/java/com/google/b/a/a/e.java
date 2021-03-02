package com.google.b.a.a;

import com.google.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class e extends g {
    private final short ccr;
    private final short value;

    e(g gVar, int i2, int i3) {
        super(gVar);
        AppMethodBeat.i(12202);
        this.value = (short) i2;
        this.ccr = (short) i3;
        AppMethodBeat.o(12202);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.b.a.a.g
    public final void a(a aVar, byte[] bArr) {
        AppMethodBeat.i(12203);
        aVar.bH(this.value, this.ccr);
        AppMethodBeat.o(12203);
    }

    public final String toString() {
        AppMethodBeat.i(12204);
        String str = "<" + Integer.toBinaryString((this.value & ((1 << this.ccr) - 1)) | (1 << this.ccr) | (1 << this.ccr)).substring(1) + '>';
        AppMethodBeat.o(12204);
        return str;
    }
}
