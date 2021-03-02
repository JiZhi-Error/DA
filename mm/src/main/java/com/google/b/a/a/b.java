package com.google.b.a.a;

import com.google.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class b extends g {
    private final short cci;
    private final short ccj;

    b(g gVar, int i2, int i3) {
        super(gVar);
        AppMethodBeat.i(12257);
        this.cci = (short) i2;
        this.ccj = (short) i3;
        AppMethodBeat.o(12257);
    }

    @Override // com.google.b.a.a.g
    public final void a(a aVar, byte[] bArr) {
        AppMethodBeat.i(12258);
        for (int i2 = 0; i2 < this.ccj; i2++) {
            if (i2 == 0 || (i2 == 31 && this.ccj <= 62)) {
                aVar.bH(31, 5);
                if (this.ccj > 62) {
                    aVar.bH(this.ccj - 31, 16);
                } else if (i2 == 0) {
                    aVar.bH(Math.min((int) this.ccj, 31), 5);
                } else {
                    aVar.bH(this.ccj - 31, 5);
                }
            }
            aVar.bH(bArr[this.cci + i2], 8);
        }
        AppMethodBeat.o(12258);
    }

    public final String toString() {
        AppMethodBeat.i(12259);
        String str = "<" + ((int) this.cci) + "::" + ((this.cci + this.ccj) - 1) + '>';
        AppMethodBeat.o(12259);
        return str;
    }
}
