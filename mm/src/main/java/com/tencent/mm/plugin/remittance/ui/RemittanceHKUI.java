package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.remittance.model.q;
import com.tencent.mm.plugin.remittance.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.ui.f;

public class RemittanceHKUI extends RemittanceBaseUI {
    private int Cwu;
    private String Cwv;
    private String Cww;
    private String Cwx;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68203);
        super.onCreate(bundle);
        addSceneEndListener(1529);
        addSceneEndListener(1257);
        this.Cwu = getIntent().getIntExtra("hk_currency", 0);
        this.Cwv = getIntent().getStringExtra("hk_currencyuint");
        this.Cww = getIntent().getStringExtra("hk_notice");
        this.Cwx = getIntent().getStringExtra("hk_notice_url");
        this.qAh.setTitleText(this.Cwv);
        this.Crb.setText(this.Cwv);
        AppMethodBeat.o(68203);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68204);
        super.onDestroy();
        removeSceneEndListener(1529);
        removeSceneEndListener(1257);
        AppMethodBeat.o(68204);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public final void aMj(String str) {
        AppMethodBeat.i(68205);
        Log.d("MicroMsg.RemittanceHKUI", "do scene gen pay");
        int i2 = 0;
        if (this.mPayScene == 33) {
            i2 = 1;
        }
        doSceneProgress(new r(Math.round(this.jVp * 100.0d), this.goe, this.qnT, this.Crk, this.mDesc, this.CqS, this.Cwu, i2), true);
        AppMethodBeat.o(68205);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public final void eNK() {
        AppMethodBeat.i(68206);
        u.makeText(getContext(), getString(R.string.g3w, new Object[]{this.Cwv}), 0).show();
        AppMethodBeat.o(68206);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public final void eNN() {
        AppMethodBeat.i(68207);
        if (!Util.isNullOrNil(this.Cww)) {
            TextView textView = (TextView) findViewById(R.id.a2b);
            textView.setText(this.Cww);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceHKUI.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(68202);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/remittance/ui/RemittanceHKUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.RemittanceHKUI", "hy: on click banner");
                    if (!Util.isNullOrNil(RemittanceHKUI.this.Cwx)) {
                        f.bn(RemittanceHKUI.this.getContext(), RemittanceHKUI.this.Cwx);
                    }
                    a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceHKUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(68202);
                }
            });
        }
        AppMethodBeat.o(68207);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public final void eNI() {
        int i2;
        AppMethodBeat.i(68208);
        Log.d("MicroMsg.RemittanceHKUI", "do scene cancel");
        if (this.mPayScene == 33) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        doSceneProgress(new q(this.goe, this.CqS, this.Cwu, ((long) this.jVp) * 100, i2), false);
        AppMethodBeat.o(68208);
    }

    @Override // com.tencent.mm.wallet_core.d.f, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar, boolean z) {
        AppMethodBeat.i(68209);
        if (qVar instanceof r) {
            r rVar = (r) qVar;
            if (i2 != 0 || i3 != 0) {
                h.c(getContext(), str, "", false);
                AppMethodBeat.o(68209);
            } else if (!Util.isNullOrNil(rVar.CoO)) {
                f.a((Context) getContext(), rVar.CoO, false, 4);
                AppMethodBeat.o(68209);
            } else {
                Log.e("MicroMsg.RemittanceHKUI", "empty payurl");
                AppMethodBeat.o(68209);
            }
        } else {
            super.onSceneEnd(i2, i3, str, qVar, z);
            AppMethodBeat.o(68209);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(68210);
        if (i2 == 4 && i3 == -1) {
            finish();
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(68210);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public final void eNS() {
    }
}
