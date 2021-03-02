package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

public class WalletWXCreditErrDetailUI extends WalletBaseUI {
    private Bankcard Hww;
    private String JQL;
    private TextView JQM;
    private TextView JQN;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cal;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72381);
        super.onCreate(bundle);
        setMMTitle(R.string.i82);
        initView();
        AppMethodBeat.o(72381);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(72382);
        this.Hww = (Bankcard) getInput().getParcelable("key_bankcard");
        this.JQL = getInput().getString("key_repayment_url");
        if (this.Hww == null) {
            AppMethodBeat.o(72382);
            return;
        }
        this.JQM = (TextView) findViewById(R.id.je4);
        this.JQM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(72379);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditErrDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f.p(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.this.JQL, false);
                a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditErrDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72379);
            }
        });
        this.JQN = (TextView) findViewById(R.id.je5);
        this.JQN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(72380);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditErrDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.wallet_core.a.l(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.this.getInput());
                a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditErrDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72380);
            }
        });
        this.JQN.setVisibility(getInput().getBoolean("key_can_unbind", true) ? 0 : 8);
        AppMethodBeat.o(72382);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }
}
