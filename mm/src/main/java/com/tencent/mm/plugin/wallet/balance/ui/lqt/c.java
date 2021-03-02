package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;

public class c extends b {
    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(68740);
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            activity.finish();
            AppMethodBeat.o(68740);
            return;
        }
        a(activity, "wallet", ".balance.ui.lqt.WalletLqtPlanAddUI", -1, new Intent(), true);
        AppMethodBeat.o(68740);
    }
}
