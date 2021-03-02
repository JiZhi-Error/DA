package com.tencent.mm.plugin.wallet_payu.balance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;

public class WalletPayUBalanceResultUI extends WalletBalanceResultUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI
    public void initView() {
        AppMethodBeat.i(71969);
        super.initView();
        this.Hwv.setVisibility(8);
        AppMethodBeat.o(71969);
    }
}
