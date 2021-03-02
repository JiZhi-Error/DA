package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class h extends o {
    @Override // com.google.b.d.o, com.google.b.g
    public final b a(String str, a aVar, int i2, int i3, Map<c, ?> map) {
        AppMethodBeat.i(12238);
        if (aVar != a.CODE_93) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(12238);
            throw illegalArgumentException;
        }
        b a2 = super.a(str, aVar, i2, i3, map);
        AppMethodBeat.o(12238);
        return a2;
    }

    @Override // com.google.b.d.o
    public final boolean[] ct(String str) {
        AppMethodBeat.i(12239);
        int length = str.length();
        if (length > 80) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
            AppMethodBeat.o(12239);
            throw illegalArgumentException;
        }
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[(((str.length() + 2 + 2) * 9) + 1)];
        a(g.ceb[47], iArr);
        int a2 = a(zArr, 0, iArr);
        for (int i2 = 0; i2 < length; i2++) {
            a(g.ceb["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i2))], iArr);
            a2 += a(zArr, a2, iArr);
        }
        int l = l(str, 20);
        a(g.ceb[l], iArr);
        int a3 = a2 + a(zArr, a2, iArr);
        a(g.ceb[l(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(l), 15)], iArr);
        int a4 = a(zArr, a3, iArr) + a3;
        a(g.ceb[47], iArr);
        zArr[a4 + a(zArr, a4, iArr)] = true;
        AppMethodBeat.o(12239);
        return zArr;
    }

    private static void a(int i2, int[] iArr) {
        for (int i3 = 0; i3 < 9; i3++) {
            iArr[i3] = ((1 << (8 - i3)) & i2) == 0 ? 0 : 1;
        }
    }

    private static int a(boolean[] zArr, int i2, int[] iArr) {
        boolean z;
        int i3 = 0;
        while (i3 < 9) {
            int i4 = i2 + 1;
            if (iArr[i3] != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i2] = z;
            i3++;
            i2 = i4;
        }
        return 9;
    }

    private static int l(String str, int i2) {
        AppMethodBeat.i(12240);
        int i3 = 0;
        int length = str.length() - 1;
        int i4 = 1;
        while (length >= 0) {
            i3 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i4;
            int i5 = i4 + 1;
            if (i5 > i2) {
                i5 = 1;
            }
            length--;
            i4 = i5;
        }
        int i6 = i3 % 47;
        AppMethodBeat.o(12240);
        return i6;
    }
}
