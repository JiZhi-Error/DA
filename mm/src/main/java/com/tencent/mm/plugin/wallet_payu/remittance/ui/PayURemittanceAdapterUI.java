package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.f;

@a(7)
public class PayURemittanceAdapterUI extends RemittanceAdapterUI {
    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI
    public final void eNH() {
        AppMethodBeat.i(72180);
        doSceneProgress(new d(this.goe), false);
        AppMethodBeat.o(72180);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(72181);
        super.onSceneEnd(i2, i3, str, qVar);
        if (qVar instanceof d) {
            this.CqH = false;
        }
        if (i2 == 0 && i3 == 0 && (qVar instanceof d)) {
            final d dVar = (d) qVar;
            this.goe = dVar.username;
            if (Util.isNullOrNil(this.goe)) {
                Log.d("MicroMsg.PayURemittanceAdapterUI", "Username empty & fishsh. scene=" + this.mScene);
                finish();
                AppMethodBeat.o(72181);
                return true;
            }
            final Intent intent = new Intent();
            intent.putExtra("fee", dVar.qwJ);
            intent.putExtra("desc", dVar.desc);
            intent.putExtra("scan_remittance_id", dVar.CpA);
            intent.putExtra("receiver_true_name", f.bps(dVar.Cpz));
            g.aAi();
            if (((l) g.af(l.class)).aSN().bjK(this.goe) != null) {
                c(this.goe, dVar.scene, intent);
            } else {
                Log.d("MicroMsg.PayURemittanceAdapterUI", "Receiver in contactStg and try to get contact");
                final long nowMilliSecond = Util.nowMilliSecond();
                ay.a.iDq.a(this.goe, "", new ay.b.a() {
                    /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceAdapterUI.AnonymousClass1 */

                    @Override // com.tencent.mm.model.ay.b.a
                    public final void p(String str, boolean z) {
                        AppMethodBeat.i(72179);
                        if (z) {
                            Log.v("MicroMsg.PayURemittanceAdapterUI", "getContact suc; cost=" + (Util.nowMilliSecond() - nowMilliSecond) + " ms");
                            c.ap(str, 3);
                            p.aYD().Mg(str);
                        } else {
                            Log.w("MicroMsg.PayURemittanceAdapterUI", "getContact failed");
                        }
                        PayURemittanceAdapterUI.this.c(PayURemittanceAdapterUI.this.goe, dVar.scene, intent);
                        AppMethodBeat.o(72179);
                    }
                });
            }
            AppMethodBeat.o(72181);
            return true;
        }
        AppMethodBeat.o(72181);
        return false;
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI
    public final void c(String str, int i2, Intent intent) {
        Intent intent2;
        AppMethodBeat.i(72182);
        Log.i("MicroMsg.PayURemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + str);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        intent2.putExtra("receiver_name", str);
        intent2.putExtra("scene", this.mScene);
        intent2.putExtra("pay_scene", i2);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        setResult(-1);
        finish();
        AppMethodBeat.o(72182);
    }
}
