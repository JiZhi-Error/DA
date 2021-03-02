package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.d;

public class b extends com.tencent.mm.plugin.wallet_core.b.b {
    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(68737);
        d a2 = super.a(activity, bundle);
        AppMethodBeat.o(68737);
        return a2;
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(68738);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.o(68738);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(68739);
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            activity.finish();
            AppMethodBeat.o(68739);
            return;
        }
        a(activity, "wallet", ".balance.ui.lqt.WalletLqtSaveFetchUI", -1, new Intent(), true);
        AppMethodBeat.o(68739);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "BalanceFetchCardProcess";
    }
}
