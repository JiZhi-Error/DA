package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

public class WalletWXCreditOpenNotifyUI extends WalletBaseUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cam;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72385);
        super.onCreate(bundle);
        g.aAi();
        g.aAh().azQ().set(196658, Boolean.FALSE);
        initView();
        AppMethodBeat.o(72385);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        int i2 = 0;
        AppMethodBeat.i(72386);
        setMMTitle(R.string.iwf);
        showHomeBtn(false);
        enableBackMenu(false);
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenNotifyUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(72383);
                WalletWXCreditOpenNotifyUI.this.setResult(-1);
                WalletWXCreditOpenNotifyUI.this.finish();
                AppMethodBeat.o(72383);
                return true;
            }
        });
        ((TextView) findViewById(R.id.jij)).setText(f.D(getInput().getDouble("key_total_amount")));
        Button button = (Button) findViewById(R.id.fz0);
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenNotifyUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(72384);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenNotifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Bundle bundle = new Bundle();
                bundle.putParcelable("key_bankcard", WalletWXCreditOpenNotifyUI.this.getInput().getParcelable("key_bankcard"));
                com.tencent.mm.wallet_core.a.a(WalletWXCreditOpenNotifyUI.this, com.tencent.mm.plugin.wxcredit.b.class, bundle);
                a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenNotifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72384);
            }
        });
        if (!getInput().getBoolean("key_can_upgrade_amount", true)) {
            i2 = 8;
        }
        button.setVisibility(i2);
        AppMethodBeat.o(72386);
    }
}
