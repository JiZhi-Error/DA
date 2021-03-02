package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class j {
    private static final HashSet<String> bdl = new HashSet<>();
    private static String bdm = "goog.exo.core";

    static {
        AppMethodBeat.i(91953);
        AppMethodBeat.o(91953);
    }

    public static synchronized String tu() {
        String str;
        synchronized (j.class) {
            str = bdm;
        }
        return str;
    }

    public static synchronized void bb(String str) {
        synchronized (j.class) {
            AppMethodBeat.i(91952);
            if (bdl.add(str)) {
                bdm += ", " + str;
            }
            AppMethodBeat.o(91952);
        }
    }
}
