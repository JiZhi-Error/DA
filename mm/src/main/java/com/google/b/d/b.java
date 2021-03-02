package com.google.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.r.f;

public final class b extends o {
    private static final char[] ced = {'A', 'B', 'C', 'D'};
    private static final char[] cee = {'T', 'N', '*', 'E'};
    private static final char[] cef = {'/', ':', '+', '.'};
    private static final char ceg = ced[0];

    @Override // com.google.b.d.o
    public final boolean[] ct(String str) {
        int i2;
        AppMethodBeat.i(12237);
        if (str.length() < 2) {
            str = ceg + str + ceg;
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean a2 = a.a(ced, upperCase);
            boolean a3 = a.a(ced, upperCase2);
            boolean a4 = a.a(cee, upperCase);
            boolean a5 = a.a(cee, upperCase2);
            if (a2) {
                if (!a3) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                    AppMethodBeat.o(12237);
                    throw illegalArgumentException;
                }
            } else if (a4) {
                if (!a5) {
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                    AppMethodBeat.o(12237);
                    throw illegalArgumentException2;
                }
            } else if (a3 || a5) {
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                AppMethodBeat.o(12237);
                throw illegalArgumentException3;
            } else {
                str = ceg + str + ceg;
            }
        }
        int i3 = 20;
        for (int i4 = 1; i4 < str.length() - 1; i4++) {
            if (Character.isDigit(str.charAt(i4)) || str.charAt(i4) == '-' || str.charAt(i4) == '$') {
                i3 += 9;
            } else if (a.a(cef, str.charAt(i4))) {
                i3 += 10;
            } else {
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Cannot encode : '" + str.charAt(i4) + '\'');
                AppMethodBeat.o(12237);
                throw illegalArgumentException4;
            }
        }
        boolean[] zArr = new boolean[((str.length() - 1) + i3)];
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i6));
            if (i6 == 0 || i6 == str.length() - 1) {
                switch (upperCase3) {
                    case '*':
                        upperCase3 = 'C';
                        break;
                    case 'E':
                        upperCase3 = 'D';
                        break;
                    case h.a.CTRL_INDEX /*{ENCODED_INT: 78}*/:
                        upperCase3 = 'B';
                        break;
                    case f.CTRL_INDEX /*{ENCODED_INT: 84}*/:
                        upperCase3 = 'A';
                        break;
                }
            }
            int i7 = 0;
            while (true) {
                if (i7 >= a.cea.length) {
                    i2 = 0;
                } else if (upperCase3 == a.cea[i7]) {
                    i2 = a.ceb[i7];
                } else {
                    i7++;
                }
            }
            int i8 = 0;
            boolean z = true;
            int i9 = i5;
            int i10 = 0;
            while (i8 < 7) {
                zArr[i9] = z;
                i9++;
                if (((i2 >> (6 - i8)) & 1) == 0 || i10 == 1) {
                    i8++;
                    z = !z;
                    i10 = 0;
                } else {
                    i10++;
                }
            }
            if (i6 < str.length() - 1) {
                zArr[i9] = false;
                i5 = i9 + 1;
            } else {
                i5 = i9;
            }
        }
        AppMethodBeat.o(12237);
        return zArr;
    }
}
