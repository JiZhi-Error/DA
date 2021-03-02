package com.tencent.mm.plugin.appbrand.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;

public final class n {
    public static String cO(Object obj) {
        AppMethodBeat.i(121092);
        String str = "Token@" + (obj != null ? Integer.valueOf(obj.hashCode()) : BuildConfig.COMMAND);
        AppMethodBeat.o(121092);
        return str;
    }

    public static String Bs(long j2) {
        AppMethodBeat.i(121093);
        String concat = "Token@".concat(String.valueOf(j2));
        AppMethodBeat.o(121093);
        return concat;
    }
}
