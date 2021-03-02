package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WalletForgotPwdBindNewUI extends WalletForgotPwdUI {
    @Override // com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        return false;
    }

    @Override // com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(69643);
        super.initView();
        AppMethodBeat.o(69643);
    }
}
