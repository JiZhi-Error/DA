package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

public final class i {
    static e SCD = g.htt().hts();

    static {
        AppMethodBeat.i(183528);
        AppMethodBeat.o(183528);
    }

    public static String bhK(String str) {
        AppMethodBeat.i(183524);
        String bhK = SCD.bhK(str);
        AppMethodBeat.o(183524);
        return bhK;
    }

    public static boolean copyFile(String str, String str2) {
        AppMethodBeat.i(183525);
        boolean copyFile = SCD.copyFile(str, str2);
        AppMethodBeat.o(183525);
        return copyFile;
    }

    public static InputStream openRead(String str) {
        AppMethodBeat.i(183526);
        InputStream openRead = SCD.openRead(str);
        AppMethodBeat.o(183526);
        return openRead;
    }

    public static OutputStream LM(String str) {
        AppMethodBeat.i(183527);
        OutputStream LM = SCD.LM(str);
        AppMethodBeat.o(183527);
        return LM;
    }
}
