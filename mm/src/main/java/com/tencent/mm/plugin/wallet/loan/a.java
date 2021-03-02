package com.tencent.mm.plugin.wallet.loan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.wallet_core.d;

public class a extends b {
    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69177);
        if (t.fQI().fRk()) {
            b(activity, WalletLoanCheckPwdUI.class, bundle);
        } else {
            super.a(activity, bundle);
        }
        AppMethodBeat.o(69177);
        return this;
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        int i2 = 0;
        AppMethodBeat.i(69179);
        if (bundle.getBoolean("intent_bind_end", false)) {
            i2 = -1;
        }
        a(activity, WalletLoanRepaymentUI.class, i2, (Intent) null, true);
        AppMethodBeat.o(69179);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(69178);
        b(activity, this.dQL);
        AppMethodBeat.o(69178);
    }
}
