package com.tencent.mm.plugin.wallet.loan;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletLoanCheckPwdUI extends WalletCheckPwdUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69181);
        super.onCreate(bundle);
        if (getProcess() != null) {
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.wallet.loan.WalletLoanCheckPwdUI.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(69180);
                    com.tencent.mm.wallet_core.a.s(WalletLoanCheckPwdUI.this, 0);
                    AppMethodBeat.o(69180);
                    return true;
                }
            });
        }
        AppMethodBeat.o(69181);
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69182);
        if (!(qVar instanceof x) || (i2 == 0 && i3 == 0)) {
            boolean onSceneEnd = super.onSceneEnd(i2, i3, str, qVar);
            AppMethodBeat.o(69182);
            return onSceneEnd;
        }
        AppMethodBeat.o(69182);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI
    public int getForceOrientation() {
        return 1;
    }
}
