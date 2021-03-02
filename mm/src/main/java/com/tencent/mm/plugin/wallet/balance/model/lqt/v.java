package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vending.app.a;

public class v extends a {
    @Override // com.tencent.mm.vending.app.a
    public final void onCreate() {
        AppMethodBeat.i(68481);
        super.onCreate();
        AppMethodBeat.o(68481);
    }

    static /* synthetic */ void fMY() {
        AppMethodBeat.i(68482);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_LQT_OPEN_FLAG_INT_SYNC, (Object) -1);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_LQT_ENTRY_WORDING_STRING_SYNC, (Object) null);
        AppMethodBeat.o(68482);
    }
}
