package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.model.x;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

@a(7)
public class RemittanceAdapterUI extends WalletBaseUI {
    protected boolean CqH = false;
    protected com.tencent.mm.plugin.wallet.a CqI = null;
    public String goe = null;
    protected String mAppID = null;
    protected int mChannel;
    protected int mScene;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        d process;
        AppMethodBeat.i(67944);
        super.onCreate(bundle);
        setContentViewVisibility(8);
        this.mScene = getIntent().getIntExtra("scene", 0);
        this.goe = getIntent().getStringExtra("receiver_name");
        this.mChannel = getIntent().getIntExtra("pay_channel", -1);
        this.CqI = com.tencent.mm.plugin.wallet.a.be(getIntent());
        if (this.mChannel == 56) {
            this.mAppID = this.CqI.HsN;
        }
        if (this.mChannel == -1 && (process = getProcess()) != null) {
            this.mChannel = process.dQL.getInt("pay_channel", -1);
        }
        if (this.mScene == 1) {
            this.CqH = true;
            eNH();
            AppMethodBeat.o(67944);
        } else if (this.mScene == 3) {
            addSceneEndListener(580);
            if (getIntent() == null) {
                Log.d("MicroMsg.RemittanceAdapterUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                finish();
                AppMethodBeat.o(67944);
                return;
            }
            com.tencent.mm.plugin.wallet_core.c.d dVar = new com.tencent.mm.plugin.wallet_core.c.d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 3, "getTransferMoneyRequest", getIntent().getIntExtra("pay_channel", 0));
            dVar.setProcessName("RemittanceProcess");
            doSceneForceProgress(dVar);
            AppMethodBeat.o(67944);
        } else if (this.mScene == 2) {
            if (Util.isNullOrNil(this.goe)) {
                Log.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
                finish();
                AppMethodBeat.o(67944);
                return;
            }
            c(this.goe, 31, null);
            AppMethodBeat.o(67944);
        } else if (this.mScene != 5 && this.mScene != 6) {
            c(null, 31, null);
            AppMethodBeat.o(67944);
        } else if (Util.isNullOrNil(this.goe)) {
            Log.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
            finish();
            AppMethodBeat.o(67944);
        } else {
            String str = this.goe;
            Log.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + str);
            Intent intent = new Intent();
            com.tencent.mm.plugin.wallet.a.a(this.CqI, intent);
            intent.setClass(this, RemittanceOSRedirect.class);
            intent.putExtra("receiver_name", str);
            intent.putExtra("scene", this.mScene);
            intent.putExtra("pay_scene", 31);
            intent.putExtra("pay_channel", this.mChannel);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceOSUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceOSUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            setResult(-1);
            finish();
            AppMethodBeat.o(67944);
        }
    }

    /* access modifiers changed from: protected */
    public void eNH() {
        AppMethodBeat.i(67945);
        x xVar = new x(this.goe, this.mChannel);
        xVar.setProcessName("RemittanceProcess");
        doSceneProgress(xVar, true);
        AppMethodBeat.o(67945);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(67946);
        if (this.mScene == 3) {
            removeSceneEndListener(580);
        }
        super.onDestroy();
        AppMethodBeat.o(67946);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(67947);
        if (!this.CqH) {
            Log.d("MicroMsg.RemittanceAdapterUI", "back press not lock");
            finish();
            AppMethodBeat.o(67947);
            return;
        }
        Log.d("MicroMsg.RemittanceAdapterUI", "back press but lock");
        AppMethodBeat.o(67947);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(67948);
        if (qVar instanceof x) {
            this.CqH = false;
        }
        if (i2 != 0 || i3 != 0) {
            setResult(0);
            h.cD(this, str);
            finish();
            AppMethodBeat.o(67948);
            return true;
        } else if (qVar instanceof x) {
            final x xVar = (x) qVar;
            if (this.mScene == 1 && xVar.dDN == 0 && xVar.pTI == 1) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", xVar.pTL);
                f.aA(this, intent);
                finish();
                AppMethodBeat.o(67948);
                return true;
            }
            String str2 = xVar.CpJ;
            this.goe = xVar.username;
            if (!Util.isNullOrNil(this.goe) || !Util.isNullOrNil(str2)) {
                if (this.mScene == 1) {
                    if (xVar.scene == 33) {
                        this.CqI = com.tencent.mm.plugin.wallet.a.fV(this.goe, 2);
                        this.CqI.cG(20, getIntent().getStringExtra("receiver_name"));
                    } else {
                        this.CqI = com.tencent.mm.plugin.wallet.a.fV(this.goe, 3);
                        this.CqI.cG(10, getIntent().getStringExtra("receiver_name"));
                    }
                }
                final Intent intent2 = new Intent();
                intent2.putExtra("fee", xVar.qwJ);
                intent2.putExtra("desc", xVar.desc);
                intent2.putExtra("scan_remittance_id", xVar.CpA);
                intent2.putExtra("receiver_true_name", f.bps(xVar.Cpz));
                intent2.putExtra("receiver_true_name_busi", xVar.Cpg);
                intent2.putExtra("receiver_tips", xVar.CpB);
                intent2.putExtra("rcvr_new_desc", xVar.CpC);
                intent2.putExtra("payer_desc", xVar.CpD);
                intent2.putExtra("rcvr_open_id", xVar.CpJ);
                intent2.putExtra("mch_name", xVar.CpG);
                intent2.putExtra("mch_info", xVar.CpM);
                intent2.putExtra("mch_photo", xVar.CpH);
                intent2.putExtra("mch_type", xVar.CpK);
                intent2.putExtra("mch_time", xVar.CpI);
                intent2.putExtra("amount_remind_bit", xVar.CpN);
                if (xVar.CpF == 1) {
                    intent2.putExtra("busi_type", xVar.CpF);
                    intent2.putExtra("rcvr_ticket", xVar.CpE);
                    intent2.putExtra("rcvr_open_id", xVar.CpJ);
                    intent2.putExtra("get_pay_wifi", xVar.CpL);
                    if (xVar.CpO != null) {
                        intent2.putExtra("BusiRemittanceResp", xVar.CpO);
                    }
                }
                if (this.mChannel == 56) {
                    intent2.putExtra("app_id", this.mAppID);
                }
                g.aAi();
                as bjK = ((l) g.af(l.class)).aSN().bjK(this.goe);
                c.ap(this.goe, 3);
                if (bjK != null || this.goe.equals("")) {
                    c(this.goe, xVar.scene, intent2);
                } else {
                    Log.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
                    final long nowMilliSecond = Util.nowMilliSecond();
                    ay.a.iDq.a(this.goe, "", new ay.b.a() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI.AnonymousClass1 */

                        @Override // com.tencent.mm.model.ay.b.a
                        public final void p(String str, boolean z) {
                            AppMethodBeat.i(67943);
                            if (z) {
                                Log.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (Util.nowMilliSecond() - nowMilliSecond) + " ms");
                                c.ap(str, 3);
                                p.aYD().Mg(str);
                            } else {
                                Log.w("MicroMsg.RemittanceAdapterUI", "getContact failed");
                            }
                            RemittanceAdapterUI.this.c(RemittanceAdapterUI.this.goe, xVar.scene, intent2);
                            AppMethodBeat.o(67943);
                        }
                    });
                }
                AppMethodBeat.o(67948);
                return true;
            }
            Log.d("MicroMsg.RemittanceAdapterUI", "Username empty & fishsh. scene=" + this.mScene);
            finish();
            AppMethodBeat.o(67948);
            return true;
        } else if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.d) {
            e.bfP(((com.tencent.mm.plugin.wallet_core.c.d) qVar).fPP());
            c(null, 31, null);
            AppMethodBeat.o(67948);
            return true;
        } else {
            AppMethodBeat.o(67948);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    /* access modifiers changed from: protected */
    public void c(String str, int i2, Intent intent) {
        Intent intent2;
        AppMethodBeat.i(67949);
        Log.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + str + " payScene: " + i2);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        com.tencent.mm.plugin.wallet.a.a(this.CqI, intent2);
        if (intent2.getIntExtra("busi_type", 0) == 1) {
            intent2.setClass(this, RemittanceBusiUI.class);
        } else {
            intent2.setClass(this, RemittanceUI.class);
        }
        intent2.putExtra("receiver_name", str);
        intent2.putExtra("scene", this.mScene);
        intent2.putExtra("pay_scene", i2);
        intent2.putExtra("pay_channel", this.mChannel);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        setResult(-1);
        finish();
        AppMethodBeat.o(67949);
    }
}
