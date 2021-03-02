package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.google.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class j extends r {
    @Override // com.google.b.d.o, com.google.b.g
    public final b a(String str, a aVar, int i2, int i3, Map<c, ?> map) {
        AppMethodBeat.i(12391);
        if (aVar != a.EAN_13) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(12391);
            throw illegalArgumentException;
        }
        b a2 = super.a(str, aVar, i2, i3, map);
        AppMethodBeat.o(12391);
        return a2;
    }

    @Override // com.google.b.d.o
    public final boolean[] ct(String str) {
        AppMethodBeat.i(12392);
        if (str.length() != 13) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
            AppMethodBeat.o(12392);
            throw illegalArgumentException;
        }
        try {
            if (!q.x(str)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Contents do not pass checksum");
                AppMethodBeat.o(12392);
                throw illegalArgumentException2;
            }
            int i2 = i.ceo[Integer.parseInt(str.substring(0, 1))];
            boolean[] zArr = new boolean[95];
            int a2 = a(zArr, 0, q.cev, true) + 0;
            for (int i3 = 1; i3 <= 6; i3++) {
                int parseInt = Integer.parseInt(str.substring(i3, i3 + 1));
                if (((i2 >> (6 - i3)) & 1) == 1) {
                    parseInt += 10;
                }
                a2 += a(zArr, a2, q.cey[parseInt], false);
            }
            int a3 = a2 + a(zArr, a2, q.cew, false);
            for (int i4 = 7; i4 <= 12; i4++) {
                a3 += a(zArr, a3, q.cex[Integer.parseInt(str.substring(i4, i4 + 1))], true);
            }
            a(zArr, a3, q.cev, true);
            AppMethodBeat.o(12392);
            return zArr;
        } catch (d e2) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Illegal contents");
            AppMethodBeat.o(12392);
            throw illegalArgumentException3;
        }
    }
}
