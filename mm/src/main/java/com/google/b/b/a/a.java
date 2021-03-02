package com.google.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.pay.q;

public final class a {
    public static final a cdg = new a(4201, 4096, 1);
    public static final a cdh = new a(1033, 1024, 1);
    public static final a cdi = new a(67, 64, 1);
    public static final a cdj = new a(19, 16, 1);
    public static final a cdk = new a(q.CTRL_INDEX, 256, 0);
    public static final a cdl;
    public static final a cdm;
    public static final a cdn = cdi;
    final int[] cdo;
    final int[] cdp;
    final b cdq;
    private final b cdr;
    private final int cds;
    final int cdt;
    final int size;

    static {
        AppMethodBeat.i(12338);
        a aVar = new a(301, 256, 1);
        cdl = aVar;
        cdm = aVar;
        AppMethodBeat.o(12338);
    }

    private a(int i2, int i3, int i4) {
        AppMethodBeat.i(12336);
        this.cds = i2;
        this.size = i3;
        this.cdt = i4;
        this.cdo = new int[i3];
        this.cdp = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.cdo[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.cdp[this.cdo[i7]] = i7;
        }
        this.cdq = new b(this, new int[]{0});
        this.cdr = new b(this, new int[]{1});
        AppMethodBeat.o(12336);
    }

    static int bJ(int i2, int i3) {
        return i2 ^ i3;
    }

    /* access modifiers changed from: package-private */
    public final int bK(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        return this.cdo[(this.cdp[i2] + this.cdp[i3]) % (this.size - 1)];
    }

    public final String toString() {
        AppMethodBeat.i(12337);
        String str = "GF(0x" + Integer.toHexString(this.cds) + ',' + this.size + ')';
        AppMethodBeat.o(12337);
        return str;
    }
}
