package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ar;

public final class ac {
    public static String TAG = "MicroMsg.WalletIndexPayMenu";

    public static void aev(String str) {
        AppMethodBeat.i(70428);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_INDEX_MAIDAN_STRING_SYNC, str);
        AppMethodBeat.o(70428);
    }
}
