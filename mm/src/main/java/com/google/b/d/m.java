package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class m extends o {
    private static final int[] ceq = {1, 1, 1, 1};
    private static final int[] cet = {3, 1, 1};

    @Override // com.google.b.d.o, com.google.b.g
    public final b a(String str, a aVar, int i2, int i3, Map<c, ?> map) {
        AppMethodBeat.i(12382);
        if (aVar != a.ITF) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(12382);
            throw illegalArgumentException;
        }
        b a2 = super.a(str, aVar, i2, i3, map);
        AppMethodBeat.o(12382);
        return a2;
    }

    @Override // com.google.b.d.o
    public final boolean[] ct(String str) {
        AppMethodBeat.i(12383);
        int length = str.length();
        if (length % 2 != 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The length of the input should be even");
            AppMethodBeat.o(12383);
            throw illegalArgumentException;
        } else if (length > 80) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
            AppMethodBeat.o(12383);
            throw illegalArgumentException2;
        } else {
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int a2 = a(zArr, 0, ceq, true);
            for (int i2 = 0; i2 < length; i2 += 2) {
                int digit = Character.digit(str.charAt(i2), 10);
                int digit2 = Character.digit(str.charAt(i2 + 1), 10);
                int[] iArr = new int[18];
                for (int i3 = 0; i3 < 5; i3++) {
                    iArr[i3 * 2] = l.ces[digit][i3];
                    iArr[(i3 * 2) + 1] = l.ces[digit2][i3];
                }
                a2 += a(zArr, a2, iArr, true);
            }
            a(zArr, a2, cet, true);
            AppMethodBeat.o(12383);
            return zArr;
        }
    }
}
