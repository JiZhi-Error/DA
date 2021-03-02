package com.tencent.liteapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public static int cL(String str) {
        int i2 = 0;
        AppMethodBeat.i(197813);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i2 = Integer.decode(str).intValue();
                    AppMethodBeat.o(197813);
                    return i2;
                }
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(197813);
            }
        }
        AppMethodBeat.o(197813);
        return i2;
    }
}
