package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletOpenLqbProxyUI extends WalletBaseUI {
    public com.tencent.mm.plugin.wallet.balance.ui.lqt.a Iqy;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71795);
        super.onCreate(bundle);
        setContentViewVisibility(4);
        this.Iqy = new com.tencent.mm.plugin.wallet.balance.ui.lqt.a(this);
        d process = getProcess();
        if (process != null) {
            int i2 = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipq, 0);
            String string = getInput().getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipw);
            Log.i("MicroMsg.WalletOpenLqbProxyUI", "WalletOpenLqbProxyUI onCreate, openScene: %s, extraData: %s", Integer.valueOf(i2), string);
            if (i2 == 3) {
                getNetController().r(Integer.valueOf(i2), string);
                AppMethodBeat.o(71795);
                return;
            }
            process.b(this, getInput());
            finish();
        }
        AppMethodBeat.o(71795);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
