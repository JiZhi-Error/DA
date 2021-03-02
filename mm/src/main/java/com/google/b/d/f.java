package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class f extends o {
    @Override // com.google.b.d.o, com.google.b.g
    public final b a(String str, a aVar, int i2, int i3, Map<c, ?> map) {
        AppMethodBeat.i(12290);
        if (aVar != a.CODE_39) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(12290);
            throw illegalArgumentException;
        }
        b a2 = super.a(str, aVar, i2, i3, map);
        AppMethodBeat.o(12290);
        return a2;
    }

    @Override // com.google.b.d.o
    public final boolean[] ct(String str) {
        AppMethodBeat.i(12291);
        int length = str.length();
        if (length > 80) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
            AppMethodBeat.o(12291);
            throw illegalArgumentException;
        }
        int[] iArr = new int[9];
        int i2 = length + 25;
        for (int i3 = 0; i3 < length; i3++) {
            int indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i3));
            if (indexOf < 0) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Bad contents: ".concat(String.valueOf(str)));
                AppMethodBeat.o(12291);
                throw illegalArgumentException2;
            }
            a(e.ceb[indexOf], iArr);
            for (int i4 = 0; i4 < 9; i4++) {
                i2 += iArr[i4];
            }
        }
        boolean[] zArr = new boolean[i2];
        a(e.cen, iArr);
        int a2 = a(zArr, 0, iArr, true);
        int[] iArr2 = {1};
        int a3 = a2 + a(zArr, a2, iArr2, false);
        for (int i5 = 0; i5 < length; i5++) {
            a(e.ceb["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i5))], iArr);
            int a4 = a3 + a(zArr, a3, iArr, true);
            a3 = a4 + a(zArr, a4, iArr2, false);
        }
        a(e.cen, iArr);
        a(zArr, a3, iArr, true);
        AppMethodBeat.o(12291);
        return zArr;
    }

    private static void a(int i2, int[] iArr) {
        for (int i3 = 0; i3 < 9; i3++) {
            iArr[i3] = ((1 << (8 - i3)) & i2) == 0 ? 1 : 2;
        }
    }
}
