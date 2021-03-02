package com.tencent.mm.compatible.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static Object[] gKK = new Object[0];
    private static Object[] gKL = new Object[73];

    public static int idealIntArraySize(int i2) {
        int i3 = i2 * 4;
        int i4 = 4;
        while (true) {
            if (i4 >= 32) {
                break;
            } else if (i3 <= (1 << i4) - 12) {
                i3 = (1 << i4) - 12;
                break;
            } else {
                i4++;
            }
        }
        return i3 / 4;
    }

    public static <T> boolean contains(T[] tArr, T t) {
        AppMethodBeat.i(157476);
        for (T t2 : tArr) {
            if (t2 == null) {
                if (t == null) {
                    AppMethodBeat.o(157476);
                    return true;
                }
            } else if (t != null && t2.equals(t)) {
                AppMethodBeat.o(157476);
                return true;
            }
        }
        AppMethodBeat.o(157476);
        return false;
    }

    public static boolean contains(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }
}
