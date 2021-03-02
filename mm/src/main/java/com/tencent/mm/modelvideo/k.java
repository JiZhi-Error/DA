package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Util;

public final class k {
    public static final String bhc() {
        AppMethodBeat.i(126889);
        String str = g.aAh().hqG + "draft/";
        AppMethodBeat.o(126889);
        return str;
    }

    public static final String Qh(String str) {
        AppMethodBeat.i(126890);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(126890);
            return null;
        }
        String str2 = bhc() + str;
        AppMethodBeat.o(126890);
        return str2;
    }

    public static final String Qi(String str) {
        AppMethodBeat.i(126891);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(126891);
            return null;
        }
        String str2 = bhc() + str + ".thumb";
        AppMethodBeat.o(126891);
        return str2;
    }
}
