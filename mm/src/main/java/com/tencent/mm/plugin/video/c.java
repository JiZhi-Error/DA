package com.tencent.mm.plugin.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigInteger;

public final class c {
    public static String aTR(String str) {
        AppMethodBeat.i(127140);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(127140);
            return "";
        }
        String bigInteger = new BigInteger(Long.toBinaryString(Util.getLong(str, 0)), 2).toString();
        AppMethodBeat.o(127140);
        return bigInteger;
    }
}
