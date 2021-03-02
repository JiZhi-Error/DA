package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class WalletVerifyIdCardUI extends WalletBaseUI {
    private boolean IkD = false;
    private i IkF = new i();
    private p.a IkG = new p.a() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI.AnonymousClass4 */

        @Override // com.tencent.mm.wallet_core.c.p.a
        public final void fTo() {
            AppMethodBeat.i(71292);
            WalletVerifyIdCardUI.b(WalletVerifyIdCardUI.this);
            AppMethodBeat.o(71292);
        }
    };
    private EditHintPasswdView IkM;
    private TextView mPa;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletVerifyIdCardUI() {
        AppMethodBeat.i(71293);
        AppMethodBeat.o(71293);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        View findViewById;
        AppMethodBeat.i(71294);
        super.onCreate(bundle);
        this.IkF = new i(getInput());
        initView();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.afz)));
        View customView = getSupportActionBar().getCustomView();
        if (!(customView == null || (findViewById = customView.findViewById(R.id.brt)) == null)) {
            findViewById.setBackgroundColor(getResources().getColor(R.color.ac_));
        }
        if (d.oD(21)) {
            if (d.oD(23)) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.afz));
            } else {
                getWindow().setStatusBarColor(getResources().getColor(R.color.BW_90));
            }
        }
        setMMTitle("");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(71289);
                WalletVerifyIdCardUI.this.finish();
                AppMethodBeat.o(71289);
                return false;
            }
        }, R.raw.actionbar_icon_dark_back);
        AppMethodBeat.o(71294);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(71295);
        this.mPa = (TextView) findViewById(R.id.jr_);
        this.IkM = (EditHintPasswdView) findViewById(R.id.jr9);
        String string = getInput().getString("key_true_name");
        String string2 = getInput().getString("key_cre_name");
        String string3 = getInput().getString("key_cre_type");
        this.mPa.setText(getString(R.string.idj, new Object[]{string, string2}));
        this.IkM.setEditTextMaxLength(4);
        this.IkM.setEditTextSize(34.0f);
        this.IkM.setOnInputValidListener(new EditHintPasswdView.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI.AnonymousClass2 */

            @Override // com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a
            public final void onInputValidChange(final boolean z) {
                AppMethodBeat.i(71291);
                WalletVerifyIdCardUI.this.IkM.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(71290);
                        if (z) {
                            if (WalletVerifyIdCardUI.a(WalletVerifyIdCardUI.this, WalletVerifyIdCardUI.this.IkG)) {
                                AppMethodBeat.o(71290);
                                return;
                            }
                            WalletVerifyIdCardUI.b(WalletVerifyIdCardUI.this);
                        }
                        AppMethodBeat.o(71290);
                    }
                }, 50);
                AppMethodBeat.o(71291);
            }
        });
        if ("1".equals(string3)) {
            setEditFocusListener(this.IkM, 1, false);
            AppMethodBeat.o(71295);
            return;
        }
        setEditFocusListener(this.IkM, 1, true);
        AppMethodBeat.o(71295);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71296);
        if (qVar instanceof p) {
            if (i3 == 0 || !((p) qVar).isBlock()) {
                this.IkM.eIj();
            } else {
                h.a((Context) getContext(), str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
            AppMethodBeat.o(71296);
            return true;
        }
        AppMethodBeat.o(71296);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.caf;
    }

    private boolean fTp() {
        AppMethodBeat.i(71297);
        boolean z = getInput().getBoolean("key_is_oversea", false);
        AppMethodBeat.o(71297);
        return z;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onPreSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71298);
        Log.i("MicroMsg.WalletVerifyIdCardUI", "onPreSceneEnd %s %s", Integer.valueOf(i3), qVar);
        if ((qVar instanceof p) && i3 == 0) {
            this.IkD = true;
            u.makeText(this, (int) R.string.ils, 0).show();
            Log.i("MicroMsg.WalletVerifyIdCardUI", "tag it isCertInstalled ok");
        }
        AppMethodBeat.o(71298);
        return true;
    }

    static /* synthetic */ boolean a(WalletVerifyIdCardUI walletVerifyIdCardUI, p.a aVar) {
        AppMethodBeat.i(71299);
        if (walletVerifyIdCardUI.IkD) {
            Log.i("MicroMsg.WalletVerifyIdCardUI", "isCertInstalled passed");
            AppMethodBeat.o(71299);
            return false;
        }
        String string = walletVerifyIdCardUI.getInput().getString("key_cre_type");
        String text = walletVerifyIdCardUI.IkM.getText();
        if (walletVerifyIdCardUI.IkF.fQo()) {
            Log.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isBlockInstall %s", aVar);
            if (!Util.isNullOrNil(text)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13731, 6);
                walletVerifyIdCardUI.doSceneProgress(new p(string, text, walletVerifyIdCardUI.getPayReqKey(), aVar, true));
                AppMethodBeat.o(71299);
                return true;
            }
            Log.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isBlockInstall sms error %s", aVar);
            AppMethodBeat.o(71299);
            return false;
        } else if (walletVerifyIdCardUI.IkF.fQn()) {
            Log.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isNeedInstall %s", aVar);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13731, 6);
            walletVerifyIdCardUI.doSceneProgress(new p(string, text, walletVerifyIdCardUI.getPayReqKey(), aVar, false));
            AppMethodBeat.o(71299);
            return true;
        } else {
            Log.i("MicroMsg.WalletVerifyIdCardUI", "no need installcert");
            AppMethodBeat.o(71299);
            return false;
        }
    }

    static /* synthetic */ void b(WalletVerifyIdCardUI walletVerifyIdCardUI) {
        AppMethodBeat.i(71300);
        if (walletVerifyIdCardUI.getNetController() != null) {
            Log.d("MicroMsg.WalletVerifyIdCardUI", "3des text: %s", walletVerifyIdCardUI.IkM.getText());
            v vVar = new v();
            vVar.kdF = walletVerifyIdCardUI.getInput().getString("key_pwd1");
            vVar.BDB = (PayInfo) walletVerifyIdCardUI.getInput().getParcelable("key_pay_info");
            vVar.dUT = 1;
            vVar.IaZ = walletVerifyIdCardUI.getInput().getString("key_cre_type");
            vVar.IaY = walletVerifyIdCardUI.IkM.getText();
            vVar.token = Util.nullAs(walletVerifyIdCardUI.getInput().getString("kreq_token"), "");
            switch (walletVerifyIdCardUI.getInput().getInt("key_pay_flag", 0)) {
                case 1:
                    vVar.flag = "1";
                    break;
                case 2:
                    if (walletVerifyIdCardUI.fTp()) {
                        vVar.flag = "5";
                        break;
                    } else {
                        vVar.flag = "2";
                        break;
                    }
                case 3:
                    if (walletVerifyIdCardUI.fTp()) {
                        vVar.flag = "6";
                        break;
                    } else {
                        vVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                        break;
                    }
            }
            Bankcard bankcard = (Bankcard) walletVerifyIdCardUI.getInput().getParcelable("key_bankcard");
            if (bankcard != null) {
                vVar.dDj = bankcard.field_bankcardType;
                vVar.ANo = bankcard.field_bindSerial;
                vVar.HUU = Util.nullAs(bankcard.field_arrive_type, "");
            } else {
                vVar.dDj = walletVerifyIdCardUI.getInput().getString("key_bank_type");
                if (Util.isNullOrNil(vVar.dDj)) {
                    vVar.dDj = walletVerifyIdCardUI.getInput().getString("key_bind_card_type", "");
                }
            }
            walletVerifyIdCardUI.getNetController().r(vVar);
        }
        AppMethodBeat.o(71300);
    }
}
