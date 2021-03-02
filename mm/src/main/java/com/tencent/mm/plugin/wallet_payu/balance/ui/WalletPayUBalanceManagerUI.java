package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet_core.c.b.a;

public class WalletPayUBalanceManagerUI extends WalletBalanceManagerUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71965);
        super.onCreate(bundle);
        AppMethodBeat.o(71965);
    }

    @Override // com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI
    public final void fNn() {
        AppMethodBeat.i(71966);
        s.fOg();
        doSceneProgress(new a(), s.fOh().Hwc == null);
        AppMethodBeat.o(71966);
    }

    @Override // com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71967);
        if (i2 == 0 && i3 == 0 && (qVar instanceof a)) {
            is(false);
        }
        AppMethodBeat.o(71967);
        return false;
    }

    @Override // com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI
    public final void fNo() {
        AppMethodBeat.i(71968);
        startActivity(WalletPayUBalanceSaveUI.class);
        AppMethodBeat.o(71968);
    }
}
