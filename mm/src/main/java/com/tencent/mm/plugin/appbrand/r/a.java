package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.protocal.protobuf.dpc;
import java.util.Locale;

public final class a {
    public static boolean a(int i2, int i3, dpc dpc) {
        return i2 == 0 && i3 == 0 && dpc != null;
    }

    public static boolean d(c.a<?> aVar) {
        AppMethodBeat.i(180325);
        if (aVar == null || !a(aVar.errType, aVar.errCode, aVar.iLC)) {
            AppMethodBeat.o(180325);
            return false;
        }
        AppMethodBeat.o(180325);
        return true;
    }

    public static String e(c.a aVar) {
        AppMethodBeat.i(180326);
        if (aVar == null) {
            AppMethodBeat.o(180326);
            return BuildConfig.COMMAND;
        }
        String format = String.format(Locale.US, "%d %d %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.errMsg);
        AppMethodBeat.o(180326);
        return format;
    }
}
