package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j {
    public static int cL(String str) {
        int i2 = 0;
        AppMethodBeat.i(945);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i2 = Integer.parseInt(str);
                    AppMethodBeat.o(945);
                    return i2;
                }
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(945);
            }
        }
        AppMethodBeat.o(945);
        return i2;
    }
}
