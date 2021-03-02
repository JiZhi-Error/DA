package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.bind.model.c;
import com.tencent.mm.plugin.wallet_payu.bind.model.d;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletPayUBankcardManageUI extends WalletBankcardManageUI {
    @Override // com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71994);
        super.onCreate(bundle);
        AppMethodBeat.o(71994);
    }

    @Override // com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI
    public final void xT(boolean z) {
        AppMethodBeat.i(71995);
        if (z) {
            doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.b.a(), false);
            AppMethodBeat.o(71995);
            return;
        }
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.b.a());
        AppMethodBeat.o(71995);
    }

    @Override // com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI
    public final void fOa() {
        AppMethodBeat.i(71996);
        com.tencent.mm.wallet_core.a.a(this, c.class, null);
        AppMethodBeat.o(71996);
    }

    @Override // com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71997);
        if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.b.a) {
            fOb();
            AppMethodBeat.o(71997);
            return true;
        }
        AppMethodBeat.o(71997);
        return false;
    }

    @Override // com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI
    public final com.tencent.mm.plugin.wallet.bind.ui.a fNZ() {
        AppMethodBeat.i(71998);
        a aVar = new a(this, this.HDi);
        AppMethodBeat.o(71998);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI
    public final void e(Bankcard bankcard) {
        AppMethodBeat.i(71999);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard", bankcard);
        com.tencent.mm.wallet_core.a.a(this, d.class, bundle);
        AppMethodBeat.o(71999);
    }
}
