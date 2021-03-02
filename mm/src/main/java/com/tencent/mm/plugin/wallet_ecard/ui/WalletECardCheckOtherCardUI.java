package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletECardCheckOtherCardUI extends WalletECardBaseUI implements WalletFormView.a {
    private WalletFormView Cjy;
    private WalletFormView HSp;
    private Button krs;
    private String mTrueName;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBaseUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71768);
        super.onCreate(bundle);
        this.mTrueName = getInput().getString(a.IpH, "");
        setMMTitle(getString(R.string.bpm));
        this.mNetSceneMgr.addSceneEndListener(385);
        initView();
        AppMethodBeat.o(71768);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(71769);
        this.Cjy = (WalletFormView) findViewById(R.id.b00);
        this.HSp = (WalletFormView) findViewById(R.id.b01);
        this.krs = (Button) findViewById(R.id.b02);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.Cjy);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.HSp);
        if (!Util.isNullOrNil(this.mTrueName)) {
            this.Cjy.setHint(getString(R.string.bpj, new Object[]{this.mTrueName}));
        } else {
            this.Cjy.setHint(getString(R.string.bpk));
        }
        this.HSp.setHint(getString(R.string.bpl));
        this.Cjy.setOnInputValidChangeListener(this);
        this.HSp.setOnInputValidChangeListener(this);
        setEditFocusListener(this.Cjy, 0, false);
        setEditFocusListener(this.HSp, 0, false);
        this.krs.setEnabled(false);
        this.krs.setClickable(false);
        this.krs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(71767);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardCheckOtherCardUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.WalletECardCheckOtherCardUI", "do check card");
                if (!WalletECardCheckOtherCardUI.this.Cjy.bql() || !WalletECardCheckOtherCardUI.this.HSp.bql()) {
                    Log.w("MicroMsg.WalletECardCheckOtherCardUI", "input invalid");
                } else {
                    String text = WalletECardCheckOtherCardUI.this.Cjy.getText();
                    String text2 = WalletECardCheckOtherCardUI.this.HSp.getText();
                    WalletECardCheckOtherCardUI.this.getNetController().r(text, text2);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardCheckOtherCardUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71767);
            }
        });
        AppMethodBeat.o(71769);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a0d;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(71770);
        super.onDestroy();
        this.mNetSceneMgr.removeSceneEndListener(385);
        AppMethodBeat.o(71770);
    }

    @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
    public final void onInputValidChange(boolean z) {
        AppMethodBeat.i(71771);
        Log.d("MicroMsg.WalletECardCheckOtherCardUI", "is valid: %s", Boolean.valueOf(z));
        if (!this.Cjy.bql() || !this.HSp.bql()) {
            this.krs.setEnabled(false);
            this.krs.setClickable(false);
            AppMethodBeat.o(71771);
            return;
        }
        this.krs.setEnabled(true);
        this.krs.setClickable(true);
        AppMethodBeat.o(71771);
    }
}
