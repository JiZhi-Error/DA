package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ar;

public final class ao {
    public static boolean bJw() {
        AppMethodBeat.i(70534);
        g.aAi();
        if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            AppMethodBeat.o(70534);
            return false;
        }
        AppMethodBeat.o(70534);
        return true;
    }
}
