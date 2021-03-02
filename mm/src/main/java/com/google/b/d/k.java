package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class k extends r {
    @Override // com.google.b.d.o, com.google.b.g
    public final b a(String str, a aVar, int i2, int i3, Map<c, ?> map) {
        AppMethodBeat.i(12292);
        if (aVar != a.EAN_8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(12292);
            throw illegalArgumentException;
        }
        b a2 = super.a(str, aVar, i2, i3, map);
        AppMethodBeat.o(12292);
        return a2;
    }

    @Override // com.google.b.d.o
    public final boolean[] ct(String str) {
        AppMethodBeat.i(12293);
        if (str.length() != 8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
            AppMethodBeat.o(12293);
            throw illegalArgumentException;
        }
        boolean[] zArr = new boolean[67];
        int a2 = a(zArr, 0, q.cev, true) + 0;
        for (int i2 = 0; i2 <= 3; i2++) {
            a2 += a(zArr, a2, q.cex[Integer.parseInt(str.substring(i2, i2 + 1))], false);
        }
        int a3 = a2 + a(zArr, a2, q.cew, false);
        for (int i3 = 4; i3 <= 7; i3++) {
            a3 += a(zArr, a3, q.cex[Integer.parseInt(str.substring(i3, i3 + 1))], true);
        }
        a(zArr, a3, q.cev, true);
        AppMethodBeat.o(12293);
        return zArr;
    }
}
