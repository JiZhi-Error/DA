package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletCheckIdentityUI extends WalletBaseUI {
    private WalletFormView HJY;
    private WalletFormView Idq;
    private String JQh;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72326);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(72326);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cai;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(72327);
        setMMTitle(R.string.ias);
        this.Idq = (WalletFormView) findViewById(R.id.fte);
        a.e(this, this.Idq);
        this.HJY = (WalletFormView) findViewById(R.id.duk);
        a.c(this.HJY);
        setEditFocusListener(this.HJY, 1, false);
        String string = getInput().getString("key_pre_name");
        this.JQh = getInput().getString("key_pre_indentity");
        if (!Util.isNullOrNil(string)) {
            this.Idq.getPrefilledTv().setText(string);
            this.Idq.setHint(getString(R.string.iah));
        }
        if (!Util.isNullOrNil(this.JQh)) {
            this.HJY.setMaxInputLength(4);
            this.HJY.getPrefilledTv().setText(this.JQh);
            this.HJY.setHint(getString(R.string.i_9));
        }
        findViewById(R.id.fz0).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(72325);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletCheckIdentityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String text = WalletCheckIdentityUI.this.Idq.getText();
                String text2 = WalletCheckIdentityUI.this.HJY.getText();
                if (WalletCheckIdentityUI.a(WalletCheckIdentityUI.this, text, text2)) {
                    WalletCheckIdentityUI.this.getNetController().r(text, text2);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletCheckIdentityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72325);
            }
        });
        AppMethodBeat.o(72327);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ boolean a(WalletCheckIdentityUI walletCheckIdentityUI, String str, String str2) {
        AppMethodBeat.i(72328);
        if (Util.isNullOrNil(str)) {
            u.makeText(walletCheckIdentityUI, (int) R.string.iaq, 0).show();
            AppMethodBeat.o(72328);
            return false;
        } else if (Util.isNullOrNil(str2) || str2.length() < 4 || (Util.isNullOrNil(walletCheckIdentityUI.JQh) && !walletCheckIdentityUI.HJY.bql())) {
            u.makeText(walletCheckIdentityUI, (int) R.string.i_6, 0).show();
            AppMethodBeat.o(72328);
            return false;
        } else {
            AppMethodBeat.o(72328);
            return true;
        }
    }
}
