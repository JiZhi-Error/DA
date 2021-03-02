package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class HoneyPayBaseUI extends WalletBaseUI {
    protected final String TAG = ("MicroMsg." + getClass().getSimpleName());
    protected int wwG = R.color.afz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dYP();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(64660);
                HoneyPayBaseUI.this.hideVKB();
                HoneyPayBaseUI.this.hideTenpayKB();
                HoneyPayBaseUI.this.finish();
                AppMethodBeat.o(64660);
                return false;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void dYP() {
        setActionbarColor(getResources().getColor(this.wwG));
        hideActionbarLine();
    }
}
