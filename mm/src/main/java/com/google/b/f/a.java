package com.google.b.f;

import com.google.b.b.b;
import com.google.b.c;
import com.google.b.f.b.f;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class a implements g {
    @Override // com.google.b.g
    public final b a(String str, com.google.b.a aVar, int i2, int i3, Map<c, ?> map) {
        AppMethodBeat.i(12323);
        if (str.isEmpty()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Found empty contents");
            AppMethodBeat.o(12323);
            throw illegalArgumentException;
        } else if (aVar != com.google.b.a.QR_CODE) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(12323);
            throw illegalArgumentException2;
        } else if (i2 < 0 || i3 < 0) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
            AppMethodBeat.o(12323);
            throw illegalArgumentException3;
        } else {
            com.google.b.f.a.a aVar2 = com.google.b.f.a.a.L;
            int i4 = 4;
            if (map != null) {
                if (map.containsKey(c.ERROR_CORRECTION)) {
                    aVar2 = com.google.b.f.a.a.valueOf(map.get(c.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(c.MARGIN)) {
                    i4 = Integer.parseInt(map.get(c.MARGIN).toString());
                }
            }
            b a2 = a(com.google.b.f.b.c.a(str, aVar2, map), i2, i3, i4);
            AppMethodBeat.o(12323);
            return a2;
        }
    }

    private static b a(f fVar, int i2, int i3, int i4) {
        AppMethodBeat.i(12324);
        com.google.b.f.b.b bVar = fVar.cfO;
        if (bVar == null) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(12324);
            throw illegalStateException;
        }
        int i5 = bVar.width;
        int i6 = bVar.height;
        int i7 = (i4 << 1) + i5;
        int i8 = (i4 << 1) + i6;
        int max = Math.max(i2, i7);
        int max2 = Math.max(i3, i8);
        int min = Math.min(max / i7, max2 / i8);
        int i9 = (max - (i5 * min)) / 2;
        b bVar2 = new b(max, max2);
        int i10 = (max2 - (i6 * min)) / 2;
        for (int i11 = 0; i11 < i6; i11++) {
            int i12 = 0;
            int i13 = i9;
            while (i12 < i5) {
                if (bVar.bO(i12, i11) == 1) {
                    bVar2.p(i13, i10, min, min);
                }
                i12++;
                i13 += min;
            }
            i10 += min;
        }
        AppMethodBeat.o(12324);
        return bVar2;
    }
}
