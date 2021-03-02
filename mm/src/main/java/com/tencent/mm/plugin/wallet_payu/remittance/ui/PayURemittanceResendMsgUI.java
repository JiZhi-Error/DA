package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.f;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class PayURemittanceResendMsgUI extends RemittanceResendMsgUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72203);
        super.onCreate(bundle);
        AppMethodBeat.o(72203);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI
    public final void f(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(72204);
        doSceneProgress(new f(str, getIntent().getIntExtra("total_fee", 0), getIntent().getStringExtra("fee_type"), str3, i2));
        AppMethodBeat.o(72204);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(72205);
        if (!(qVar instanceof f)) {
            AppMethodBeat.o(72205);
            return false;
        } else if (i2 == 0 && i3 == 0) {
            h.cD(this, getString(R.string.g4a));
            finish();
            AppMethodBeat.o(72205);
            return true;
        } else {
            h.cD(this, str);
            finish();
            AppMethodBeat.o(72205);
            return true;
        }
    }
}
