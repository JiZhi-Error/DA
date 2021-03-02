package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

public class WalletWXCreditOpenUI extends WalletBaseUI {
    private Bankcard HDV;
    private Button krs;

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
        return R.layout.cao;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72396);
        super.onCreate(bundle);
        this.HDV = (Bankcard) getInput().getParcelable("key_bankcard");
        initView();
        AppMethodBeat.o(72396);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(72397);
        setMMTitle(R.string.iwo);
        ((CheckBox) findViewById(R.id.id)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI.AnonymousClass1 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(72393);
                WalletWXCreditOpenUI.this.krs.setEnabled(z);
                AppMethodBeat.o(72393);
            }
        });
        findViewById(R.id.i9).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(72394);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f.b(WalletWXCreditOpenUI.this, WalletWXCreditOpenUI.this.HDV.field_bankcardType, WalletWXCreditOpenUI.this.HDV.field_bankName, true, false);
                a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72394);
            }
        });
        this.krs = (Button) findViewById(R.id.fz0);
        this.krs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(72395);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletWXCreditOpenUI.this.next();
                a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72395);
            }
        });
        AppMethodBeat.o(72397);
    }
}
