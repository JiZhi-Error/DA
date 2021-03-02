package com.google.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends n {
    static final char[] cea = "0123456789-$:/.+ABCD".toCharArray();
    static final int[] ceb = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] cec = {'A', 'B', 'C', 'D'};

    static {
        AppMethodBeat.i(12390);
        AppMethodBeat.o(12390);
    }

    static boolean a(char[] cArr, char c2) {
        if (cArr == null) {
            return false;
        }
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }
}
