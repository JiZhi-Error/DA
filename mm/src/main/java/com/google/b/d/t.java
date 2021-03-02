package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class t extends r {
    @Override // com.google.b.d.o, com.google.b.g
    public final b a(String str, a aVar, int i2, int i3, Map<c, ?> map) {
        AppMethodBeat.i(12220);
        if (aVar != a.UPC_E) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(12220);
            throw illegalArgumentException;
        }
        b a2 = super.a(str, aVar, i2, i3, map);
        AppMethodBeat.o(12220);
        return a2;
    }

    @Override // com.google.b.d.o
    public final boolean[] ct(String str) {
        AppMethodBeat.i(12221);
        if (str.length() != 8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
            AppMethodBeat.o(12221);
            throw illegalArgumentException;
        }
        int i2 = s.cez[Integer.parseInt(str.substring(7, 8))];
        boolean[] zArr = new boolean[51];
        int a2 = a(zArr, 0, q.cev, true) + 0;
        for (int i3 = 1; i3 <= 6; i3++) {
            int parseInt = Integer.parseInt(str.substring(i3, i3 + 1));
            if (((i2 >> (6 - i3)) & 1) == 1) {
                parseInt += 10;
            }
            a2 += a(zArr, a2, q.cey[parseInt], false);
        }
        a(zArr, a2, q.cet, false);
        AppMethodBeat.o(12221);
        return zArr;
    }
}
