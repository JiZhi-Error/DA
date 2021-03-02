package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI;
import com.tencent.mm.plugin.wallet_payu.balance.a.a;
import com.tencent.mm.pluginsdk.wallet.f;

public class WalletPayUBalanceSaveUI extends WalletBalanceSaveUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71970);
        super.onCreate(bundle);
        this.Hve.setVisibility(8);
        AppMethodBeat.o(71970);
    }

    @Override // com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI
    public final void fNt() {
        AppMethodBeat.i(71971);
        doSceneProgress(new a(this.jVp, "ZAR"));
        AppMethodBeat.o(71971);
    }

    @Override // com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71972);
        if (i2 == 0 && i3 == 0 && (qVar instanceof a)) {
            f.a(this, ((a) qVar).dDL, "", 11, 1);
        }
        AppMethodBeat.o(71972);
        return false;
    }
}
