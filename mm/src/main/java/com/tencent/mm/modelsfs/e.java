package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class e {
    public static boolean Pv(String str) {
        AppMethodBeat.i(155997);
        if (str.lastIndexOf(";?enc=") > 0) {
            AppMethodBeat.o(155997);
            return true;
        }
        AppMethodBeat.o(155997);
        return false;
    }

    public static String I(String str, long j2) {
        AppMethodBeat.i(155998);
        if (j2 == 0) {
            String format = String.format(str + ";?enc=%d", 314159265L);
            AppMethodBeat.o(155998);
            return format;
        }
        String format2 = String.format(str + ";?enc=%d", Long.valueOf(j2));
        AppMethodBeat.o(155998);
        return format2;
    }

    public static String Pw(String str) {
        AppMethodBeat.i(155999);
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            String substring = str.substring(0, lastIndexOf);
            AppMethodBeat.o(155999);
            return substring;
        }
        AppMethodBeat.o(155999);
        return str;
    }

    public static long Px(String str) {
        AppMethodBeat.i(156000);
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            long safeParseLong = Util.safeParseLong(str.substring(lastIndexOf + 6));
            AppMethodBeat.o(156000);
            return safeParseLong;
        }
        AppMethodBeat.o(156000);
        return 0;
    }
}
