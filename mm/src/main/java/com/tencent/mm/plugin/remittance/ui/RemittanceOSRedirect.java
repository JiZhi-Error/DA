package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.remittance.model.aa;
import com.tencent.mm.plugin.remittance.model.s;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceOSRedirect extends WalletBaseUI {
    public String goe = "";
    private int mScene;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68254);
        super.onCreate(bundle);
        setTitleVisibility(8);
        this.mScene = getIntent().getIntExtra("scene", 0);
        this.goe = getIntent().getStringExtra("receiver_name");
        if (this.mScene == 0) {
            Log.e("MicroMsg.RemittanceOSRedirect", "error scene: %s", Integer.valueOf(this.mScene));
            finish();
            AppMethodBeat.o(68254);
        } else if (this.mScene == 5) {
            this.mNetSceneMgr.addSceneEndListener(1574);
            doSceneProgress(new aa(z.aUf()));
            AppMethodBeat.o(68254);
        } else {
            if (this.mScene == 6) {
                this.mNetSceneMgr.addSceneEndListener(1301);
                doSceneProgress(new s(this.goe), true);
            }
            AppMethodBeat.o(68254);
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return true;
    }

    @Override // com.tencent.mm.wallet_core.d.f, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onSceneEnd(int i2, int i3, String str, q qVar, boolean z) {
        AppMethodBeat.i(68255);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof aa) {
                aa aaVar = (aa) qVar;
                Log.i("MicroMsg.RemittanceOSRedirect", "indexScene  %s", aaVar.Cql);
                Intent intent = getIntent();
                if (aaVar.qww == 1) {
                    f.a(this, 2, this.goe, 11, (com.tencent.mm.plugin.wallet.a) null);
                } else {
                    intent.setClass(this, RemittanceOSUI.class);
                    intent.putExtra("os_currency", aaVar.qww);
                    intent.putExtra("os_currencyuint", aaVar.Cql);
                    intent.putExtra("os_currencywording", aaVar.Cqm);
                    intent.putExtra("os_notice", aaVar.jTx);
                    intent.putExtra("os_notice_url", aaVar.jTy);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                finish();
                AppMethodBeat.o(68255);
                return;
            } else if (qVar instanceof s) {
                s sVar = (s) qVar;
                Intent intent2 = new Intent();
                intent2.setClass(this, RemittanceHKUI.class);
                this.goe = sVar.CoP;
                intent2.putExtra("scene", this.mScene);
                intent2.putExtra("fee", ((double) sVar.eht) / 100.0d);
                intent2.putExtra("desc", sVar.desc);
                intent2.putExtra("scan_remittance_id", sVar.CoR);
                intent2.putExtra("receiver_name", sVar.CoP);
                intent2.putExtra("receiver_true_name", sVar.qwy);
                intent2.putExtra("receiver_nick_name", sVar.CoQ);
                intent2.putExtra("hk_currency", sVar.qww);
                intent2.putExtra("hk_currencyuint", sVar.qwx);
                intent2.putExtra("hk_notice", sVar.jTx);
                intent2.putExtra("hk_notice_url", sVar.jTy);
                intent2.putExtra("recv_headimgurl", sVar.CoS);
                int i4 = sVar.qwz;
                int i5 = 32;
                Log.i("MicroMsg.RemittanceOSRedirect", "setAmount: %d", Integer.valueOf(i4));
                if (i4 == 1) {
                    i5 = 33;
                }
                intent2.putExtra("pay_scene", i5);
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                finish();
                AppMethodBeat.o(68255);
                return;
            }
        } else if (qVar instanceof aa) {
            Log.i("MicroMsg.RemittanceOSRedirect", "indexScene  errMsg %s", str);
            h.d(this, str, "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceOSRedirect.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(68252);
                    RemittanceOSRedirect.this.finish();
                    AppMethodBeat.o(68252);
                }
            });
            AppMethodBeat.o(68255);
            return;
        } else if (qVar instanceof s) {
            h.d(this, str, "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceOSRedirect.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(68253);
                    RemittanceOSRedirect.this.finish();
                    AppMethodBeat.o(68253);
                }
            });
        }
        AppMethodBeat.o(68255);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68256);
        super.onDestroy();
        if (this.mScene == 5) {
            removeSceneEndListener(1574);
            AppMethodBeat.o(68256);
            return;
        }
        if (this.mScene == 6) {
            removeSceneEndListener(1301);
        }
        AppMethodBeat.o(68256);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
