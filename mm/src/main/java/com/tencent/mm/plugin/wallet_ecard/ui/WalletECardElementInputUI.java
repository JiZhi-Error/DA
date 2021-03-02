package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletECardElementInputUI extends WalletECardBaseUI {
    private ElementQuery HRy;
    private WalletFormView IeY;
    private Button gxv;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBaseUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71774);
        super.onCreate(bundle);
        setMMTitle(R.string.bpn);
        initView();
        updateView();
        AppMethodBeat.o(71774);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(71775);
        this.IeY = (WalletFormView) findViewById(R.id.jf2);
        this.IeY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(71772);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardElementInputUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", WalletECardElementInputUI.this.getInput().getInt("key_support_bankcard", 3));
                bundle.putInt("key_bind_scene", WalletECardElementInputUI.this.getInput().getInt("key_bind_scene", -1));
                if (!Util.isNullOrNil(WalletECardElementInputUI.this.IeY.getText())) {
                    bundle.putString("key_bank_type", WalletECardElementInputUI.this.HRy.dDj);
                    bundle.putInt("key_bankcard_type", WalletECardElementInputUI.this.HRy.HXl);
                }
                d by = com.tencent.mm.wallet_core.a.by(WalletECardElementInputUI.this);
                if (by != null) {
                    by.a(WalletECardElementInputUI.this, WalletCardSelectUI.class, bundle, 1);
                }
                a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardElementInputUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71772);
            }
        });
        this.gxv = (Button) findViewById(R.id.fz0);
        this.gxv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(71773);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardElementInputUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.WalletECardElementInputUI", "goto next: %s", WalletECardElementInputUI.this.HRy.dDj);
                WalletECardElementInputUI.this.getNetController().r(WalletECardElementInputUI.this.HRy);
                a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardElementInputUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71773);
            }
        });
        AppMethodBeat.o(71775);
    }

    private void updateView() {
        AppMethodBeat.i(71776);
        if (this.HRy == null) {
            this.HRy = new ElementQuery();
        }
        if (Util.isNullOrNil(this.HRy.ynT)) {
            this.IeY.setText("");
            AppMethodBeat.o(71776);
        } else if (!Util.isNullOrNil(this.HRy.HXm)) {
            this.IeY.setText(this.HRy.ynT + " " + this.HRy.HXm);
            AppMethodBeat.o(71776);
        } else if (2 == this.HRy.HXl) {
            this.IeY.setText(this.HRy.ynT + " " + getString(R.string.ibk));
            AppMethodBeat.o(71776);
        } else {
            this.IeY.setText(this.HRy.ynT + " " + getString(R.string.ic4));
            AppMethodBeat.o(71776);
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a0e;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(71777);
        Log.i("MicroMsg.WalletECardElementInputUI", "onAcvityResult requestCode:".concat(String.valueOf(i2)));
        if (i3 != -1) {
            AppMethodBeat.o(71777);
            return;
        }
        switch (i2) {
            case 1:
                this.HRy = (ElementQuery) intent.getParcelableExtra("elemt_query");
                updateView();
                AppMethodBeat.o(71777);
                return;
            default:
                super.onActivityResult(i2, i3, intent);
                AppMethodBeat.o(71777);
                return;
        }
    }
}
