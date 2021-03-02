package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@a(19)
public class WalletResetInfoUI extends WalletBaseUI implements WalletFormView.a {
    private Orders CwO;
    private WalletFormView HDM;
    private WalletFormView HDN;
    private WalletFormView HDO;
    private WalletFormView HDP;
    private WalletPhoneInputView HDQ;
    private Authen HDR;
    private ElementQuery HDS;
    private Bankcard Hww;
    private Button gxv;
    private TextView nnM;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ boolean a(WalletResetInfoUI walletResetInfoUI) {
        AppMethodBeat.i(69173);
        boolean bqg = walletResetInfoUI.bqg();
        AppMethodBeat.o(69173);
        return bqg;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c_w;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69164);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(69164);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(69165);
        super.onDestroy();
        AppMethodBeat.o(69165);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(69166);
        this.nnM = (TextView) findViewById(R.id.ji4);
        Bankcard bankcard = (Bankcard) getInput().getParcelable("key_switch_phone_reset_bank_card");
        if (bankcard == null) {
            bankcard = (Bankcard) getInput().getParcelable("key_bankcard");
        }
        this.Hww = bankcard;
        this.CwO = (Orders) getInput().getParcelable("key_orders");
        this.HDR = (Authen) getInput().getParcelable("key_authen");
        if (this.HDR == null) {
            Log.w("Micromsg.WalletResetInfoUI", "authen is null!");
            AppMethodBeat.o(69166);
            return;
        }
        if (TextUtils.isEmpty(getInput().getString("key_pwd1", ""))) {
            getInput().putString("key_pwd1", this.HDR.HUO);
            Log.e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
        }
        this.HDS = (ElementQuery) getInput().getParcelable("elemt_query");
        this.HDQ = (WalletPhoneInputView) findViewById(R.id.fh1);
        this.HDP = this.HDQ.getPhoneNumberEt();
        if (this.Hww.HVV == 1) {
            this.HDQ.fTV();
        } else {
            this.HDQ.fTU();
        }
        setEditFocusListener(this.HDQ.getPhoneNumberEt(), 0, false);
        setEditFocusListener(this.HDQ.getPhoneNumberEt(), (EditText) this.HDQ.findViewById(R.id.gg7), 0, false, false, true);
        this.HDM = (WalletFormView) findViewById(R.id.a1j);
        this.HDN = (WalletFormView) findViewById(R.id.bkj);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.HDN);
        this.HDO = (WalletFormView) findViewById(R.id.bk5);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.HDO);
        this.HDN.setOnInputValidChangeListener(this);
        this.HDO.setOnInputValidChangeListener(this);
        this.HDP.setOnInputValidChangeListener(this);
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.id.ji9);
        mMScrollView.a(mMScrollView, mMScrollView);
        if (this.Hww != null) {
            this.HDM.setText(this.Hww.field_desc);
        } else {
            this.HDM.setVisibility(8);
        }
        fOf();
        if (fOe()) {
            doSceneProgress(new y("", "", null), true);
        }
        AppMethodBeat.o(69166);
    }

    private boolean fOe() {
        AppMethodBeat.i(69167);
        if (getInput().getInt("key_err_code", 408) == 408 && this.HDS == null) {
            AppMethodBeat.o(69167);
            return true;
        }
        AppMethodBeat.o(69167);
        return false;
    }

    private void fOf() {
        AppMethodBeat.i(69168);
        switch (getInput().getInt("key_err_code", 408)) {
            case 402:
                setMMTitle(R.string.iqu);
                this.HDO.setVisibility(0);
                this.nnM.setText(R.string.iqt);
                break;
            case 403:
                setMMTitle(R.string.ir1);
                this.HDN.setVisibility(0);
                this.nnM.setText(R.string.ir0);
                break;
            default:
                if (getInput().getBoolean("key_balance_change_phone_need_confirm_phone", true)) {
                    setMMTitle(R.string.iqy);
                    this.HDQ.setVisibility(0);
                } else {
                    setMMTitle(R.string.iqw);
                }
                if (this.Hww != null) {
                    Log.d("Micromsg.WalletResetInfoUI", "bankPhone: %s", this.Hww.field_bankPhone);
                    this.nnM.setText(String.format(getString(R.string.iqx), this.Hww.field_bankPhone));
                }
                if (this.HDS == null && this.Hww != null) {
                    this.HDS = t.fQQ().aVi(this.Hww.field_bankcardType);
                }
                if (this.HDS != null && this.HDS.HXf) {
                    this.HDO.setVisibility(0);
                }
                if (this.HDS != null && this.HDS.HXg) {
                    this.HDN.setVisibility(0);
                    break;
                }
        }
        this.gxv = (Button) findViewById(R.id.fz0);
        this.gxv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(69163);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletResetInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!WalletResetInfoUI.a(WalletResetInfoUI.this)) {
                    Log.w("Micromsg.WalletResetInfoUI", "input format illegal!");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletResetInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(69163);
                    return;
                }
                if (WalletResetInfoUI.this.HDO.getVisibility() == 0) {
                    WalletResetInfoUI.this.HDR.HUS = WalletResetInfoUI.this.HDO.getText();
                }
                if (WalletResetInfoUI.this.HDN.getVisibility() == 0) {
                    WalletResetInfoUI.this.HDR.HUT = Util.nullAs(WalletResetInfoUI.this.HDN.getText(), "");
                }
                if (WalletResetInfoUI.this.HDQ.getVisibility() == 0) {
                    WalletResetInfoUI.this.HDR.HQc = Util.nullAs(WalletResetInfoUI.this.HDP.getText(), "");
                    WalletResetInfoUI.this.getInput().putString("key_mobile", f.bpt(WalletResetInfoUI.this.HDR.HQc));
                }
                Log.d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", WalletResetInfoUI.this.HDR.dDj, WalletResetInfoUI.this.HDR.ANo);
                WalletResetInfoUI.this.HDR.HUN = 1;
                WalletResetInfoUI.this.HDR.HVd = "+" + WalletResetInfoUI.this.HDQ.getCountryCode();
                if (WalletResetInfoUI.this.getInput().getBoolean("key_is_changing_balance_phone_num", false)) {
                    WalletResetInfoUI.this.doSceneProgress(com.tencent.mm.plugin.wallet.pay.a.a.b(WalletResetInfoUI.this.HDR, WalletResetInfoUI.this.CwO, WalletResetInfoUI.this.getInput().getBoolean("key_isbalance", false)));
                } else {
                    com.tencent.mm.plugin.wallet.pay.a.a.b a2 = com.tencent.mm.plugin.wallet.pay.a.a.a(WalletResetInfoUI.this.HDR, WalletResetInfoUI.this.CwO, false);
                    if (a2 != null) {
                        WalletResetInfoUI.this.doSceneProgress(a2);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletResetInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69163);
            }
        });
        bqg();
        if (fOe()) {
            setContentViewVisibility(4);
            AppMethodBeat.o(69168);
            return;
        }
        setContentViewVisibility(0);
        AppMethodBeat.o(69168);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69169);
        Log.d("Micromsg.WalletResetInfoUI", " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            Bundle input = getInput();
            if ((qVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) || (qVar instanceof c)) {
                com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) qVar;
                input.putBoolean("key_need_verify_sms", !bVar.HFG);
                input.putString("kreq_token", bVar.getToken());
                if (bVar.isPaySuccess) {
                    input.putParcelable("key_orders", bVar.HFH);
                }
                RealnameGuideHelper realnameGuideHelper = bVar.AJr;
                if (realnameGuideHelper != null) {
                    input.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
                input.putInt("key_err_code", 0);
                com.tencent.mm.wallet_core.a.l(this, input);
                AppMethodBeat.o(69169);
                return true;
            } else if ((qVar instanceof y) && this.Hww != null) {
                this.HDS = t.fQQ().aVj(this.Hww.field_bindSerial);
                fOf();
            }
        }
        AppMethodBeat.o(69169);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(69170);
        if (this.HDQ.g(i2, i3, intent)) {
            AppMethodBeat.o(69170);
            return;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(69170);
    }

    private boolean bqg() {
        boolean z;
        AppMethodBeat.i(69171);
        if (!this.HDN.hK(null)) {
            z = false;
        } else {
            z = true;
        }
        if (this.HDQ.getVisibility() == 0 && this.HDQ.fTT() && !this.HDP.hK(null)) {
            z = false;
        }
        if (!this.HDO.hK(null)) {
            z = false;
        }
        if (this.CwO == null || this.HDR == null) {
            z = false;
        }
        if (z) {
            this.gxv.setEnabled(true);
            this.gxv.setClickable(true);
        } else {
            this.gxv.setEnabled(false);
            this.gxv.setClickable(false);
        }
        AppMethodBeat.o(69171);
        return z;
    }

    @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
    public final void onInputValidChange(boolean z) {
        AppMethodBeat.i(69172);
        bqg();
        AppMethodBeat.o(69172);
    }
}
