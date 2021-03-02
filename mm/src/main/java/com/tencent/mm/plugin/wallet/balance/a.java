package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;

public class a extends b {
    public static int HsP = 1;
    public static int HsQ = 2;

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(68368);
        z.aqh(14);
        d a2 = super.a(activity, bundle);
        AppMethodBeat.o(68368);
        return a2;
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(68369);
        z.hhs();
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.o(68369);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(68370);
        z.hhs();
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            activity.finish();
            AppMethodBeat.o(68370);
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (bundle.getInt("from_bind_ui", HsQ) == HsP) {
            intent.putExtra("from_bind_ui", HsP);
            a(activity, "wallet", ".balance.ui.WalletBalanceManagerUI", -1, intent, true);
            AppMethodBeat.o(68370);
            return;
        }
        intent.putExtra("from_bind_ui", HsQ);
        a(activity, "wallet", ".balance.ui.WalletBalanceFetchUI", -1, intent, true);
        AppMethodBeat.o(68370);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "BalanceFetchCardProcess";
    }
}
