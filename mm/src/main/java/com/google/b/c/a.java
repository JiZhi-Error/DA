package com.google.b.c;

import com.google.b.b.b;
import com.google.b.c;
import com.google.b.c.a.e;
import com.google.b.c.a.i;
import com.google.b.c.a.j;
import com.google.b.c.a.k;
import com.google.b.c.a.l;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class a implements g {
    @Override // com.google.b.g
    public final b a(String str, com.google.b.a aVar, int i2, int i3, Map<c, ?> map) {
        com.google.b.b bVar;
        com.google.b.b bVar2;
        AppMethodBeat.i(12339);
        if (str.isEmpty()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Found empty contents");
            AppMethodBeat.o(12339);
            throw illegalArgumentException;
        } else if (aVar != com.google.b.a.DATA_MATRIX) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(12339);
            throw illegalArgumentException2;
        } else if (i2 < 0 || i3 < 0) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
            AppMethodBeat.o(12339);
            throw illegalArgumentException3;
        } else {
            l lVar = l.FORCE_NONE;
            if (map != null) {
                l lVar2 = (l) map.get(c.DATA_MATRIX_SHAPE);
                if (lVar2 != null) {
                    lVar = lVar2;
                }
                com.google.b.b bVar3 = (com.google.b.b) map.get(c.MIN_SIZE);
                if (bVar3 != null) {
                    bVar2 = bVar3;
                } else {
                    bVar2 = null;
                }
                bVar = (com.google.b.b) map.get(c.MAX_SIZE);
                if (bVar == null) {
                    bVar = null;
                }
            } else {
                bVar = null;
                bVar2 = null;
            }
            String a2 = j.a(str, lVar, bVar2, bVar);
            k a3 = k.a(a2.length(), lVar, bVar2, bVar);
            e eVar = new e(i.a(a2, a3), a3.It(), a3.Iu());
            eVar.Il();
            b a4 = a(eVar, a3);
            AppMethodBeat.o(12339);
            return a4;
        }
    }

    private static b a(e eVar, k kVar) {
        int i2;
        int i3;
        AppMethodBeat.i(12340);
        int It = kVar.It();
        int Iu = kVar.Iu();
        com.google.b.f.b.b bVar = new com.google.b.f.b.b(kVar.Iv(), kVar.Iw());
        int i4 = 0;
        int i5 = 0;
        while (i4 < Iu) {
            if (i4 % kVar.cdS == 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < kVar.Iv(); i7++) {
                    bVar.set(i6, i5, i7 % 2 == 0);
                    i6++;
                }
                i2 = i5 + 1;
            } else {
                i2 = i5;
            }
            int i8 = 0;
            for (int i9 = 0; i9 < It; i9++) {
                if (i9 % kVar.cdR == 0) {
                    bVar.set(i8, i2, true);
                    i8++;
                }
                bVar.set(i8, i2, eVar.cdA[(eVar.cdz * i4) + i9] == 1);
                int i10 = i8 + 1;
                if (i9 % kVar.cdR == kVar.cdR - 1) {
                    bVar.set(i10, i2, i4 % 2 == 0);
                    i8 = i10 + 1;
                } else {
                    i8 = i10;
                }
            }
            int i11 = i2 + 1;
            if (i4 % kVar.cdS == kVar.cdS - 1) {
                int i12 = 0;
                for (int i13 = 0; i13 < kVar.Iv(); i13++) {
                    bVar.set(i12, i11, true);
                    i12++;
                }
                i3 = i11 + 1;
            } else {
                i3 = i11;
            }
            i4++;
            i5 = i3;
        }
        int i14 = bVar.width;
        int i15 = bVar.height;
        b bVar2 = new b(i14, i15);
        bVar2.clear();
        for (int i16 = 0; i16 < i14; i16++) {
            for (int i17 = 0; i17 < i15; i17++) {
                if (bVar.bO(i16, i17) == 1) {
                    bVar2.set(i16, i17);
                }
            }
        }
        AppMethodBeat.o(12340);
        return bVar2;
    }
}
