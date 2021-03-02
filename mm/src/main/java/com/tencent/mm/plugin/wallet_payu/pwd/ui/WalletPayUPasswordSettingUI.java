package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.plugin.wallet_payu.pwd.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.a;

public class WalletPayUPasswordSettingUI extends WalletPasswordSettingUI {
    @Override // com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI
    public final void fPm() {
        AppMethodBeat.i(72161);
        Log.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu do forgot pwd");
        a.a(this, f.class, null);
        AppMethodBeat.o(72161);
    }

    @Override // com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI
    public final void fPl() {
        AppMethodBeat.i(72162);
        Log.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu reset pwd");
        a.a(this, g.class, null);
        AppMethodBeat.o(72162);
    }

    @Override // com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI
    public final void fPn() {
        AppMethodBeat.i(72163);
        getPreferenceScreen().m38do("wallet_modify_gesture_password", true);
        getPreferenceScreen().m38do("wallet_open_gesture_password", true);
        AppMethodBeat.o(72163);
    }

    @Override // com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI
    public final int fPk() {
        return R.xml.dh;
    }
}
