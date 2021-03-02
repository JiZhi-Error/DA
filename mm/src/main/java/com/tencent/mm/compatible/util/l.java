package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;

public final class l {
    public static boolean apy() {
        AppMethodBeat.i(155909);
        String str = af.get("ro.mediatek.platform");
        if (str == null || (!str.startsWith("MT") && !str.startsWith("mt"))) {
            AppMethodBeat.o(155909);
            return false;
        }
        AppMethodBeat.o(155909);
        return true;
    }
}
