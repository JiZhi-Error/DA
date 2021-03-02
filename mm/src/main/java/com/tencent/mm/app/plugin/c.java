package com.tencent.mm.app.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class c {
    public static boolean Xn() {
        AppMethodBeat.i(19663);
        if (!com.tencent.mm.br.c.aZU("translate")) {
            AppMethodBeat.o(19663);
            return false;
        }
        String value = h.aqJ().getValue("TranslateMsgOff");
        if (Util.isNullOrNil(value)) {
            AppMethodBeat.o(19663);
            return true;
        } else if (Util.safeParseInt(value) != 0) {
            AppMethodBeat.o(19663);
            return false;
        } else {
            AppMethodBeat.o(19663);
            return true;
        }
    }
}
