package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.MD5Util;

public final class b {
    public static String aHT(String str) {
        AppMethodBeat.i(63092);
        f etU = k.euj().AjC.etU();
        if (etU == null || !str.equalsIgnoreCase(etU.jeV)) {
            String str2 = "0_" + MD5Util.getMD5String(str);
            AppMethodBeat.o(63092);
            return str2;
        }
        String S = com.tencent.mm.plugin.music.h.b.S(etU);
        AppMethodBeat.o(63092);
        return S;
    }
}
