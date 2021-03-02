package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static long aqI(String str) {
        AppMethodBeat.i(122150);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(122150);
            return 0;
        } else if ("-1".equals(str)) {
            AppMethodBeat.o(122150);
            return -1;
        } else {
            long longValue = Long.valueOf(str.split("@")[0]).longValue();
            AppMethodBeat.o(122150);
            return longValue;
        }
    }

    public static String aqJ(String str) {
        AppMethodBeat.i(122151);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(122151);
            return null;
        } else if ("-1".equals(str)) {
            AppMethodBeat.o(122151);
            return "-1";
        } else {
            String[] split = str.split("@");
            if (split.length <= 1) {
                AppMethodBeat.o(122151);
                return null;
            }
            String str2 = split[1];
            AppMethodBeat.o(122151);
            return str2;
        }
    }
}
