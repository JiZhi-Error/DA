package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zz;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.plugin.wallet_payu.pay.a.b;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.plugin.wallet_payu.pay.ui.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import java.util.LinkedList;

@a(3)
public class WalletPayUPayUI extends WalletPayUI {
    private String ItZ = null;

    @Override // com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(WalletPayUPayUI walletPayUPayUI, String str) {
        AppMethodBeat.i(72136);
        walletPayUPayUI.d(false, 0, str);
        AppMethodBeat.o(72136);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72129);
        super.onCreate(bundle);
        AppMethodBeat.o(72129);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(72130);
        Log.i("MicroMsg.WalletPayUPayUI", "hy: onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.o(72130);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI
    public final void fOy() {
        AppMethodBeat.i(72131);
        doSceneProgress(new b(getPayInfo().dDL), getPayInfo().Kxs);
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.b.a(getPayInfo().dDL), getPayInfo().Kxs);
        AppMethodBeat.o(72131);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI
    public final void fOs() {
        AppMethodBeat.i(72132);
        if (!bqg()) {
            AppMethodBeat.o(72132);
            return;
        }
        Log.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
        this.HHm = b.a(this, this.CwO, this.HGf, this.Hvb, new b.AbstractC1927b() {
            /* class com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet_payu.pay.ui.b.AbstractC1927b
            public final void a(String str, String str2, FavorPayInfo favorPayInfo) {
                AppMethodBeat.i(72124);
                WalletPayUPayUI.this.hideVKB();
                WalletPayUPayUI.this.krw = str;
                WalletPayUPayUI.this.ItZ = str2;
                WalletPayUPayUI.this.xY(false);
                f.fUi();
                AppMethodBeat.o(72124);
            }
        }, new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(72125);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/pay/ui/WalletPayUPayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletPayUPayUI.this.HGf = (FavorPayInfo) view.getTag();
                if (WalletPayUPayUI.this.HGf != null) {
                    WalletPayUPayUI.this.HGf.HXM = "";
                }
                WalletPayUPayUI.c(WalletPayUPayUI.this, "");
                WalletPayUPayUI.this.HHm.dismiss();
                WalletPayUPayUI.this.krw = null;
                WalletPayUPayUI.this.HHm = null;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/pay/ui/WalletPayUPayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72125);
            }
        }, new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(72126);
                WalletPayUPayUI.this.krw = null;
                WalletPayUPayUI.this.HHm = null;
                if (WalletPayUPayUI.this.isTransparent()) {
                    WalletPayUPayUI.this.finish();
                }
                AppMethodBeat.o(72126);
            }
        }, "CREDITCARD_PAYU".equals(this.Hvb.field_bankcardType));
        AppMethodBeat.o(72132);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI
    public final void aI(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(72133);
        this.HGU = true;
        if (this.CwO != null) {
            bundle.putInt("key_support_bankcard", this.CwO.HQg);
        }
        if (fOD()) {
            z = false;
        }
        bundle.putBoolean("key_is_oversea", z);
        com.tencent.mm.wallet_core.a.a(this, d.class, bundle);
        AppMethodBeat.o(72133);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI
    public final void xY(boolean z) {
        int i2;
        AppMethodBeat.i(72134);
        if (this.mPayInfo.dVv == 32 || this.mPayInfo.dVv == 31) {
            if (this.mPayInfo.dVv == 32) {
                Log.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
                i2 = 1;
            } else {
                i2 = 0;
            }
            doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.dDL, this.krw, this.mPayInfo.iqp.getDouble("total_fee"), this.mPayInfo.iqp.getString("fee_type"), i2, this.mPayInfo.iqp.getString("extinfo_key_1"), this.Hvb.field_bindSerial, this.mPayInfo.iqp.getString("extinfo_key_4")));
            AppMethodBeat.o(72134);
        } else if (this.mPayInfo.dVv == 11) {
            String str = this.krw;
            String str2 = this.ItZ;
            String str3 = this.mPayInfo.dDL;
            double d2 = this.mPayInfo.iqp.getDouble("total_fee");
            String string = this.mPayInfo.iqp.getString("fee_type");
            String str4 = this.Hvb.field_bindSerial;
            String str5 = this.Hvb.field_bankcardType;
            s.fOg();
            doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str, str2, str3, d2, string, str4, str5, s.fOh().Hwc.field_bindSerial));
            AppMethodBeat.o(72134);
        } else {
            doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.a(this.mPayInfo.dDL, this.mPayInfo.iqp.getDouble("total_fee"), this.mPayInfo.iqp.getString("fee_type"), this.Hvb.field_bankcardType, this.Hvb.field_bindSerial, this.ItZ, this.krw));
            AppMethodBeat.o(72134);
        }
    }

    @Override // com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        AppMethodBeat.i(72135);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
                this.CwO = ((com.tencent.mm.plugin.wallet_payu.pay.a.b) qVar).CwO;
                this.mCount = this.CwO != null ? this.CwO.HZd.size() : 0;
                Log.d("MicroMsg.WalletPayUPayUI", "get mOrders! bankcardTag : " + (this.CwO != null ? Integer.valueOf(this.CwO.HQg) : ""));
                bqg();
                if (!(this.CwO == null || this.CwO.HZd == null)) {
                    LinkedList<String> linkedList = new LinkedList<>();
                    for (Orders.Commodity commodity : this.CwO.HZd) {
                        if (Util.isNullOrNil(commodity.dDM)) {
                            commodity.dDM = this.mPayInfo.dDL;
                        }
                        linkedList.add(commodity.dDM);
                    }
                    if (linkedList.size() > 0) {
                        zz zzVar = new zz();
                        zzVar.egG.egI = linkedList;
                        EventCenter.instance.publish(zzVar);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putDouble("total_fee", this.CwO.dDO);
                    bundle.putString("fee_type", "ZAR");
                    if (this.mPayInfo.iqp == null) {
                        this.mPayInfo.iqp = bundle;
                    } else {
                        this.mPayInfo.iqp.putAll(bundle);
                    }
                }
            } else if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.b.a) {
                s.fOg();
                this.Hva = s.fOh().yk(fOL());
                s.fOg();
                this.Hvb = s.fOh().a(null, null, fOL(), false);
                this.Cwg.setClickable(true);
                if (!(this.CwO == null || this.Hva == null || this.mPayInfo == null)) {
                    f.a(this.mPayInfo, this.CwO);
                    h hVar = h.INSTANCE;
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.mPayInfo.dVv);
                    objArr[1] = 0;
                    s.fOg();
                    objArr[2] = Integer.valueOf(s.fOh().fRk() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.CwO.dDO * 100.0d));
                    objArr[4] = this.CwO.AOl;
                    hVar.a(10690, objArr);
                }
            } else if (qVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a) {
                com.tencent.mm.plugin.wallet_payu.pay.a.a aVar = (com.tencent.mm.plugin.wallet_payu.pay.a.a) qVar;
                Bundle input = getInput();
                input.putParcelable("key_pay_info", this.mPayInfo);
                input.putParcelable("key_bankcard", this.Hvb);
                input.putString("key_bank_type", this.Hvb.field_bankcardType);
                if (!Util.isNullOrNil(this.krw)) {
                    input.putString("key_pwd1", this.krw);
                }
                input.putString("kreq_token", aVar.getToken());
                input.putParcelable("key_authen", fOC());
                input.putBoolean("key_need_verify_sms", false);
                input.putString("key_mobile", this.Hvb.field_mobile);
                if (aVar.isSuccess()) {
                    input.putParcelable("key_orders", c.a(this.CwO, aVar.ItV, aVar.ItW, aVar.qwL, aVar.dQl));
                }
                getInput().putBoolean("key_should_redirect", aVar.ItT);
                getInput().putString("key_gateway_code", aVar.Isy);
                getInput().putString("key_gateway_reference", aVar.Isx);
                getInput().putBoolean("key_should_force_adjust", aVar.ItU);
                getInput().putString("key_force_adjust_code", aVar.IsA);
                input.putInt("key_pay_flag", 3);
                aI(input);
                AppMethodBeat.o(72135);
                return true;
            } else if (qVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a) {
                com.tencent.mm.plugin.wallet_payu.remittance.a.a aVar2 = (com.tencent.mm.plugin.wallet_payu.remittance.a.a) qVar;
                Bundle input2 = getInput();
                input2.putParcelable("key_pay_info", this.mPayInfo);
                input2.putParcelable("key_bankcard", this.Hvb);
                input2.putString("key_bank_type", this.Hvb.field_bankcardType);
                if (!Util.isNullOrNil(this.krw)) {
                    input2.putString("key_pwd1", this.krw);
                }
                input2.putString("kreq_token", aVar2.getToken());
                input2.putParcelable("key_authen", fOC());
                input2.putBoolean("key_need_verify_sms", false);
                input2.putString("key_mobile", this.Hvb.field_mobile);
                input2.putParcelable("key_orders", this.CwO);
                input2.putInt("key_pay_flag", 3);
                aI(input2);
                AppMethodBeat.o(72135);
                return true;
            }
            updateView();
            AppMethodBeat.o(72135);
            return true;
        }
        if (qVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a) {
            switch (i3) {
                case 402:
                case 403:
                case 408:
                    com.tencent.mm.plugin.wallet_payu.pay.a.a aVar3 = (com.tencent.mm.plugin.wallet_payu.pay.a.a) qVar;
                    this.HGZ = getInput();
                    this.HGZ.putParcelable("key_pay_info", this.mPayInfo);
                    this.HGZ.putParcelable("key_bankcard", this.Hvb);
                    if (!Util.isNullOrNil(this.krw)) {
                        this.HGZ.putString("key_pwd1", this.krw);
                    }
                    this.HGZ.putString("kreq_token", aVar3.getToken());
                    this.HGZ.putString("key_mobile", this.Hvb.field_mobile);
                    this.HGZ.putInt("key_err_code", i3);
                    this.HGZ.putParcelable("key_orders", this.CwO);
                    if (Util.isNullOrNil(str)) {
                        str2 = getString(R.string.io6);
                    } else {
                        str2 = str;
                    }
                    com.tencent.mm.ui.base.h.c(this, str2, "", getString(R.string.io5), getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(72127);
                            WalletPayUPayUI.this.HGZ.putInt("key_pay_flag", 3);
                            WalletPayUPayUI.this.aI(WalletPayUPayUI.this.HGZ);
                            AppMethodBeat.o(72127);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(72128);
                            if (WalletPayUPayUI.this.isTransparent()) {
                                WalletPayUPayUI.this.finish();
                            }
                            AppMethodBeat.o(72128);
                        }
                    });
                    AppMethodBeat.o(72135);
                    return true;
                case 404:
                    if (!(this.Hvb == null || this.CwO == null)) {
                        this.Hvb.HVB = this.CwO.dDL;
                        if (this.Hva == null || this.Hva.size() <= 1) {
                            c(true, 4, str);
                        } else {
                            d(true, 4, str);
                        }
                        AppMethodBeat.o(72135);
                        return true;
                    }
                    break;
            }
        }
        AppMethodBeat.o(72135);
        return false;
    }
}
