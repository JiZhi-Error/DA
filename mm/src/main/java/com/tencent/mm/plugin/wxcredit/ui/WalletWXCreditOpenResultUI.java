package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(19)
public class WalletWXCreditOpenResultUI extends WalletBaseUI {
    private CheckBox JQQ;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletWXCreditOpenResultUI walletWXCreditOpenResultUI) {
        AppMethodBeat.i(72392);
        walletWXCreditOpenResultUI.bpv();
        AppMethodBeat.o(72392);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.can;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72388);
        super.onCreate(bundle);
        g.aAi();
        g.aAh().azQ().set(196658, Boolean.TRUE);
        t.fQI().IbS = Util.nowSecond();
        initView();
        AppMethodBeat.o(72388);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(72389);
        setMMTitle(R.string.iwi);
        TextView textView = (TextView) findViewById(R.id.jit);
        this.JQQ = (CheckBox) findViewById(R.id.vk);
        Bankcard bankcard = (Bankcard) getInput().getParcelable("key_bankcard");
        if (bankcard != null) {
            this.JQQ.setText(getString(R.string.iwk, new Object[]{bankcard.field_bankName}));
            textView.setText(R.string.iwl);
        }
        ((Button) findViewById(R.id.fz0)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(72387);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletWXCreditOpenResultUI.a(WalletWXCreditOpenResultUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72387);
            }
        });
        AppMethodBeat.o(72389);
    }

    private void bpv() {
        AppMethodBeat.i(72390);
        getNetController().r(Boolean.valueOf(this.JQQ.isChecked()));
        AppMethodBeat.o(72390);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(72391);
        if (i2 == 4) {
            bpv();
            AppMethodBeat.o(72391);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(72391);
        return onKeyUp;
    }
}
