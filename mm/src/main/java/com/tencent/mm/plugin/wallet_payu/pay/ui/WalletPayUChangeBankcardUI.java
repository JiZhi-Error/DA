package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wallet_payu.pay.ui.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletPayUChangeBankcardUI extends WalletChangeBankcardUI {
    private String ItZ = null;
    private IListener Iua = new IListener<pj>() {
        /* class com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI.AnonymousClass4 */

        {
            AppMethodBeat.i(160903);
            this.__eventId = pj.class.getName().hashCode();
            AppMethodBeat.o(160903);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pj pjVar) {
            AppMethodBeat.i(72105);
            Log.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: on request proceed pay");
            WalletJsapiData walletJsapiData = new WalletJsapiData(pjVar);
            WalletPayUChangeBankcardUI.this.getInput().putString("app_id", walletJsapiData.appId);
            WalletPayUChangeBankcardUI.this.getInput().putString("package", walletJsapiData.packageExt);
            WalletPayUChangeBankcardUI.this.getInput().putString(AppMeasurement.Param.TIMESTAMP, walletJsapiData.timeStamp);
            WalletPayUChangeBankcardUI.this.getInput().putString("noncestr", walletJsapiData.nonceStr);
            WalletPayUChangeBankcardUI.this.getInput().putString("pay_sign", walletJsapiData.dVt);
            WalletPayUChangeBankcardUI.this.getInput().putString("sign_type", walletJsapiData.signType);
            WalletPayUChangeBankcardUI.this.getInput().putString("url", walletJsapiData.url);
            WalletPayUChangeBankcardUI.this.getInput().putBoolean("from_jsapi", true);
            WalletPayUChangeBankcardUI.this.getInput().putString("key_trans_id", ((PayInfo) WalletPayUChangeBankcardUI.this.getInput().getParcelable("key_pay_info")).dDL);
            WalletPayUChangeBankcardUI.this.getInput().putBoolean("key_should_redirect", false);
            com.tencent.mm.wallet_core.a.l(WalletPayUChangeBankcardUI.this, WalletPayUChangeBankcardUI.this.getInput());
            AppMethodBeat.o(72105);
            return true;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletPayUChangeBankcardUI() {
        AppMethodBeat.i(72106);
        AppMethodBeat.o(72106);
    }

    static /* synthetic */ void i(WalletPayUChangeBankcardUI walletPayUChangeBankcardUI) {
        AppMethodBeat.i(72114);
        walletPayUChangeBankcardUI.updateView();
        AppMethodBeat.o(72114);
    }

    static /* synthetic */ View k(WalletPayUChangeBankcardUI walletPayUChangeBankcardUI) {
        AppMethodBeat.i(72115);
        View contentView = walletPayUChangeBankcardUI.getContentView();
        AppMethodBeat.o(72115);
        return contentView;
    }

    static /* synthetic */ void l(WalletPayUChangeBankcardUI walletPayUChangeBankcardUI) {
        AppMethodBeat.i(72116);
        walletPayUChangeBankcardUI.dJG();
        AppMethodBeat.o(72116);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72107);
        super.onCreate(bundle);
        EventCenter.instance.addListener(this.Iua);
        AppMethodBeat.o(72107);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
    public void onDestroy() {
        AppMethodBeat.i(72108);
        super.onDestroy();
        EventCenter.instance.removeListener(this.Iua);
        AppMethodBeat.o(72108);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
    public final k fOr() {
        AppMethodBeat.i(72109);
        a aVar = new a(this, this.Hva, this.HGc, this.CwO);
        AppMethodBeat.o(72109);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
    public final void fOs() {
        AppMethodBeat.i(72110);
        Log.d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
        String string = getInput().getString("key_pwd1");
        if (Util.isNullOrNil(string)) {
            setContentViewVisibility(4);
            this.HGb = b.a(this, this.CwO, this.HGf, this.Hvb, new b.AbstractC1927b() {
                /* class com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.wallet_payu.pay.ui.b.AbstractC1927b
                public final void a(String str, String str2, FavorPayInfo favorPayInfo) {
                    AppMethodBeat.i(72102);
                    WalletPayUChangeBankcardUI.this.HGf = favorPayInfo;
                    WalletPayUChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.this.HGf);
                    WalletPayUChangeBankcardUI.this.krw = str;
                    WalletPayUChangeBankcardUI.this.ItZ = str2;
                    WalletPayUChangeBankcardUI.this.hideVKB();
                    WalletPayUChangeBankcardUI.this.aUW(str);
                    AppMethodBeat.o(72102);
                }
            }, new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(72103);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/pay/ui/WalletPayUChangeBankcardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (WalletPayUChangeBankcardUI.this.HGb != null) {
                        WalletPayUChangeBankcardUI.this.HGb.dismiss();
                    }
                    WalletPayUChangeBankcardUI.this.HGd.h(WalletPayUChangeBankcardUI.this.Hva, true);
                    WalletPayUChangeBankcardUI.this.HGf = (FavorPayInfo) view.getTag();
                    if (WalletPayUChangeBankcardUI.this.HGf != null) {
                        WalletPayUChangeBankcardUI.this.HGf.HXM = "";
                    }
                    WalletPayUChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.this.HGf);
                    WalletPayUChangeBankcardUI.i(WalletPayUChangeBankcardUI.this);
                    WalletPayUChangeBankcardUI.this.setContentViewVisibility(0);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/pay/ui/WalletPayUChangeBankcardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(72103);
                }
            }, new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI.AnonymousClass3 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(72104);
                    WalletPayUChangeBankcardUI.this.krw = null;
                    if (WalletPayUChangeBankcardUI.k(WalletPayUChangeBankcardUI.this).getVisibility() != 0) {
                        WalletPayUChangeBankcardUI.l(WalletPayUChangeBankcardUI.this);
                    }
                    AppMethodBeat.o(72104);
                }
            }, "CREDITCARD_PAYU".equals(this.Hvb.field_bankcardType));
            AppMethodBeat.o(72110);
            return;
        }
        aUW(string);
        AppMethodBeat.o(72110);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
    public final void aUW(String str) {
        int i2;
        boolean z;
        AppMethodBeat.i(72111);
        this.HDR.HUO = str;
        if (this.Hvb != null) {
            getInput().putString("key_mobile", this.Hvb.field_mobile);
            getInput().putParcelable("key_bankcard", this.Hvb);
            this.HDR.ANo = this.Hvb.field_bindSerial;
            this.HDR.dDj = this.Hvb.field_bankcardType;
            if (this.HGf != null) {
                this.HDR.HUY = this.HGf.HXI;
            } else {
                this.HDR.HUY = null;
            }
            if (!(this.CwO == null || this.CwO.HZe == null)) {
                this.HDR.HUX = this.CwO.HZe.HEt;
            }
            if (this.CwO != null && this.CwO.HQg == 3) {
                if (this.Hvb.fQe()) {
                    this.HDR.cSx = 3;
                } else {
                    this.HDR.cSx = 6;
                }
                Bundle input = getInput();
                if (!this.Hvb.fQe()) {
                    z = true;
                } else {
                    z = false;
                }
                input.putBoolean("key_is_oversea", z);
            }
        }
        getInput().putParcelable("key_authen", this.HDR);
        if (this.mPayInfo.dVv == 32 || this.mPayInfo.dVv == 31) {
            if (this.mPayInfo.dVv == 32) {
                Log.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
                i2 = 1;
            } else {
                i2 = 0;
            }
            doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.dDL, this.krw, this.mPayInfo.iqp.getDouble("total_fee"), this.mPayInfo.iqp.getString("fee_type"), i2, this.mPayInfo.iqp.getString("extinfo_key_1"), this.Hvb.field_bindSerial, this.mPayInfo.iqp.getString("extinfo_key_4")));
            AppMethodBeat.o(72111);
        } else if (this.mPayInfo.dVv == 11) {
            String str2 = this.krw;
            String str3 = this.ItZ;
            String str4 = this.mPayInfo.dDL;
            double d2 = this.mPayInfo.iqp.getDouble("total_fee");
            String string = this.mPayInfo.iqp.getString("fee_type");
            String str5 = this.Hvb.field_bindSerial;
            String str6 = this.Hvb.field_bankcardType;
            s.fOg();
            doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str2, str3, str4, d2, string, str5, str6, s.fOh().Hwc.field_bindSerial));
            AppMethodBeat.o(72111);
        } else {
            doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.a(this.mPayInfo.dDL, this.mPayInfo.iqp.getDouble("total_fee"), this.mPayInfo.iqp.getString("fee_type"), this.Hvb.field_bankcardType, this.Hvb.field_bindSerial, this.ItZ, str));
            AppMethodBeat.o(72111);
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(72112);
        if (i2 == 0 && i3 == 0 && ((qVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a) || (qVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a) || (qVar instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))) {
            Bundle input = getInput();
            if (!Util.isNullOrNil(this.krw)) {
                input.putString("key_pwd1", this.krw);
            }
            input.putBoolean("key_need_verify_sms", false);
            input.putParcelable("key_pay_info", this.mPayInfo);
            input.putInt("key_pay_flag", 3);
            if (qVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a) {
                com.tencent.mm.plugin.wallet_payu.pay.a.a aVar = (com.tencent.mm.plugin.wallet_payu.pay.a.a) qVar;
                input.putString("transid", aVar.qvD);
                input.putBoolean("key_should_redirect", aVar.ItT);
                input.putString("key_gateway_code", aVar.Isy);
                input.putString("key_gateway_reference", aVar.Isx);
                input.putString("key_force_adjust_code", aVar.IsA);
                input.putBoolean("key_should_force_adjust", aVar.ItU);
                if (aVar.isSuccess()) {
                    input.putParcelable("key_orders", c.a(this.CwO, aVar.ItV, aVar.ItW, aVar.qwL, aVar.dQl));
                }
            }
            if (qVar instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b) {
                com.tencent.mm.plugin.wallet_payu.balance.a.b bVar = (com.tencent.mm.plugin.wallet_payu.balance.a.b) qVar;
                input.putString("transid", bVar.qvD);
                input.putBoolean("key_should_redirect", bVar.Isw);
                input.putString("key_gateway_code", bVar.Isy);
                input.putString("key_gateway_reference", bVar.Isx);
                input.putString("key_force_adjust_code", bVar.IsA);
                input.putBoolean("key_should_force_adjust", bVar.Isz);
            }
            com.tencent.mm.wallet_core.a.l(this, input);
            AppMethodBeat.o(72112);
            return true;
        }
        AppMethodBeat.o(72112);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(72113);
        if (i2 == 23351) {
            Log.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: check otp done. resultcode: %d", Integer.valueOf(i3));
            if (i3 == -1) {
                getInput().putBoolean("key_should_redirect", false);
                com.tencent.mm.wallet_core.a.l(this, getInput());
            }
            if (i3 == 0) {
                com.tencent.mm.wallet_core.a.c(this, getInput(), 0);
            }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(72113);
    }
}
