package com.tencent.mm.plugin.wallet.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;

public class a extends b {
    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(69201);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.o(69201);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69202);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        a(activity, "wallet", ".pay.ui.WalletPayUI", -1, intent, false);
        AppMethodBeat.o(69202);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "BindCardForPayProcess";
    }
}
