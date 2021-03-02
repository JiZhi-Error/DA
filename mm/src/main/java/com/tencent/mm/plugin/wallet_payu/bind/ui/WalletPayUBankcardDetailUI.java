package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;

public class WalletPayUBankcardDetailUI extends WalletBankcardDetailUI {
    @Override // com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71993);
        super.onCreate(bundle);
        if (1 == this.Hww.field_bankcardState) {
            fNX();
            findViewById(R.id.jdt).setVisibility(8);
            findViewById(R.id.jds).setVisibility(8);
        } else {
            xR(false);
        }
        findViewById(R.id.jdv).setVisibility(8);
        ((TextView) findViewById(R.id.jdx)).setText(R.string.i7w);
        AppMethodBeat.o(71993);
    }
}
