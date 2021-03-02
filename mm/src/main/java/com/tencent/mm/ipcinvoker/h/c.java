package com.tencent.mm.ipcinvoker.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public static final String ar(String str, String str2) {
        AppMethodBeat.i(158840);
        if (str.contains(":") || str.length() <= 0) {
            String[] split = str.split(":");
            if (split[0] == null || split[0].length() <= 0) {
                AppMethodBeat.o(158840);
                return str2;
            }
            String str3 = split[0];
            AppMethodBeat.o(158840);
            return str3;
        }
        AppMethodBeat.o(158840);
        return str;
    }
}
