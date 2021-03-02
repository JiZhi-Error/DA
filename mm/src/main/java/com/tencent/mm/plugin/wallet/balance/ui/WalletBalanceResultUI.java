package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.c;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

@a(19)
public class WalletBalanceResultUI extends WalletBaseUI {
    protected Orders CwO;
    protected TextView Hwu;
    protected CheckBox Hwv;
    protected Bankcard Hww;
    protected Button krs;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(WalletBalanceResultUI walletBalanceResultUI) {
        AppMethodBeat.i(68692);
        walletBalanceResultUI.fNr();
        AppMethodBeat.o(68692);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c7r;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68687);
        super.onCreate(bundle);
        this.CwO = (Orders) getInput().getParcelable("key_orders");
        initView();
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        showHomeBtn(false);
        AppMethodBeat.o(68687);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(68688);
        this.Hwu = (TextView) findViewById(R.id.jjg);
        this.krs = (Button) findViewById(R.id.jjf);
        if (this.CwO == null) {
            finish();
            AppMethodBeat.o(68688);
            return;
        }
        this.Hwu.setText(f.d(this.CwO.dDO, this.CwO.AOl));
        this.krs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(68683);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.WalletBalanceResultUI", "click finish btn");
                WalletBalanceResultUI.a(WalletBalanceResultUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68683);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68684);
                WalletBalanceResultUI.a(WalletBalanceResultUI.this);
                AppMethodBeat.o(68684);
                return false;
            }
        });
        this.Hww = (Bankcard) getInput().getParcelable("key_bankcard");
        AppMethodBeat.o(68688);
    }

    private void fNr() {
        AppMethodBeat.i(213910);
        int i2 = getInput().getInt("key_pay_flag", 0);
        String string = getInput().getString("key_pwd1");
        String string2 = getInput().getString("key_verify_code");
        PayInfo payInfo = (PayInfo) getInput().getParcelable("key_pay_info");
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_bindcard_after_save_balance, 1);
        if (payInfo != null && a2 == 1) {
            if (this.Hww == null) {
                Log.d("MicroMsg.WalletBalanceResultUI", "flag: %s, verifycode: %s, reqkey: %s, payScene: %s, ignoreBind: %s", Integer.valueOf(i2), string2, payInfo.dDL, Integer.valueOf(payInfo.dVv), AppEventsConstants.EVENT_PARAM_VALUE_NO);
                doSceneProgress(new c(i2, string, string2, payInfo.dDL, payInfo.dVv, AppEventsConstants.EVENT_PARAM_VALUE_NO));
                AppMethodBeat.o(213910);
                return;
            }
            Log.d("MicroMsg.WalletBalanceResultUI", "flag: %s, verifycode: %s, reqkey: %s, payScene: %s, ignoreBind: %s", Integer.valueOf(i2), string2, payInfo.dDL, Integer.valueOf(payInfo.dVv), "1");
            doSceneProgress(new c(i2, string, string2, payInfo.dDL, payInfo.dVv, "1"), false);
        }
        next();
        AppMethodBeat.o(213910);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void next() {
        AppMethodBeat.i(68689);
        if (!getNetController().r(this.CwO)) {
            super.next();
        }
        AppMethodBeat.o(68689);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(68690);
        if (qVar instanceof c) {
            if (((c) qVar).HsS) {
                if (i2 == 0 && i3 == 0) {
                    s.fOg();
                    s.fOh().IbS = Util.nowSecond();
                    zv zvVar = new zv();
                    zvVar.efR.scene = 15;
                    zvVar.callback = new Runnable() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(68686);
                            Log.i("MicroMsg.WalletBalanceResultUI", "update user info succ, end process");
                            AppMethodBeat.o(68686);
                        }
                    };
                    EventCenter.instance.publish(zvVar);
                }
                next();
            }
            AppMethodBeat.o(68690);
            return true;
        }
        AppMethodBeat.o(68690);
        return false;
    }

    static /* synthetic */ void a(WalletBalanceResultUI walletBalanceResultUI) {
        AppMethodBeat.i(68691);
        if (walletBalanceResultUI.getInput().containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) walletBalanceResultUI.getInput().getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                realnameGuideHelper.b(walletBalanceResultUI, bundle, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(68685);
                        WalletBalanceResultUI.b(WalletBalanceResultUI.this);
                        AppMethodBeat.o(68685);
                    }
                });
                walletBalanceResultUI.getInput().remove("key_realname_guide_helper");
            }
            AppMethodBeat.o(68691);
            return;
        }
        walletBalanceResultUI.fNr();
        AppMethodBeat.o(68691);
    }
}
