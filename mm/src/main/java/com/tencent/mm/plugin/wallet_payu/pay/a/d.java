package com.tencent.mm.plugin.wallet_payu.pay.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.b.a;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceManagerUI;
import com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceResultUI;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUVerifyCodeUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUOrderInfoUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class d extends a {
    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final com.tencent.mm.wallet_core.d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72090);
        bundle.putInt("key_pay_scene", ((PayInfo) bundle.getParcelable("key_pay_info")).dVv);
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
            case -1003:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                b(activity, WalletPayUChangeBankcardUI.class, bundle);
                AppMethodBeat.o(72090);
                break;
            default:
                Log.d("MicroMsg.PayUPayProcess", "start pay_flag : " + bundle.getInt("key_pay_flag", 0));
                switch (bundle.getInt("key_pay_flag", 0)) {
                    case 3:
                        k(activity, bundle);
                        break;
                }
                AppMethodBeat.o(72090);
                break;
        }
        return this;
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(72092);
        Log.d("MicroMsg.PayUPayProcess", "bakck pay_flag : " + this.dQL.getInt("key_pay_flag", 0));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i2);
            AppMethodBeat.o(72092);
            return;
        }
        P(activity);
        AppMethodBeat.o(72092);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        int i2 = -1;
        AppMethodBeat.i(72093);
        Log.d("MicroMsg.PayUPayProcess", "end pay_flag : " + this.dQL.getInt("key_pay_flag", 0));
        int i3 = this.dQL.getBoolean("intent_pay_end", false) ? -1 : 0;
        Intent intent = new Intent();
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("intent_pay_end_errcode", this.dQL.getInt("intent_pay_end_errcode"));
            bundle2.putString("intent_pay_app_url", this.dQL.getString("intent_pay_app_url"));
            bundle2.putBoolean("intent_pay_end", this.dQL.getBoolean("intent_pay_end"));
            bundle2.putString("intent_wap_pay_jump_url", this.dQL.getString("intent_wap_pay_jump_url"));
            intent.putExtras(bundle2);
        }
        aaa aaa = new aaa();
        aaa.egJ.intent = intent;
        aaa.a aVar = aaa.egJ;
        if (!this.dQL.getBoolean("intent_pay_end", false)) {
            i2 = 0;
        }
        aVar.result = i2;
        EventCenter.instance.publish(aaa);
        a(activity, "wallet_payu", ".pay.ui.WalletPayUPayUI", i3, intent, false);
        AppMethodBeat.o(72093);
    }

    private void k(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72094);
        if (bundle.getBoolean("key_should_redirect", false)) {
            bundle.getString("key_gateway_code");
            b(activity, bundle.getString("key_gateway_reference"), bundle.getBoolean("key_should_force_adjust"), bundle.getString("key_force_adjust_code"));
            AppMethodBeat.o(72094);
            return;
        }
        g(activity, bundle);
        AppMethodBeat.o(72094);
    }

    private static void b(Context context, String str, boolean z, String str2) {
        AppMethodBeat.i(72095);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("shouldForceViewPort", z);
        intent.putExtra("pay_channel", 2);
        intent.putExtra("view_port_code", str2);
        c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 23351);
        AppMethodBeat.o(72095);
    }

    private void g(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72096);
        int i2 = bundle.getInt("key_pay_scene", 6);
        if (i2 == 11 || i2 == 21) {
            b(activity, WalletPayUBalanceResultUI.class, bundle);
            AppMethodBeat.o(72096);
        } else if (i2 == 31 || i2 == 32 || i2 == 33) {
            a(activity, "remittance", ".ui.RemittanceResultUI", bundle);
            AppMethodBeat.o(72096);
        } else {
            b(activity, WalletPayUOrderInfoUI.class, bundle);
            AppMethodBeat.o(72096);
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72097);
        Log.d("MicroMsg.PayUPayProcess", "needupdatebankcardlist pay_flag : " + this.dQL.getInt("key_pay_flag", 0));
        switch (this.dQL.getInt("key_pay_flag", 0)) {
            case 3:
                AppMethodBeat.o(72097);
                break;
            default:
                AppMethodBeat.o(72097);
                break;
        }
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(72098);
        if (mMActivity instanceof WalletPayUPayUI) {
            AnonymousClass1 r0 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_payu.pay.a.d.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean A(Object... objArr) {
                    AppMethodBeat.i(72087);
                    PayInfo payInfo = (PayInfo) this.activity.getIntent().getParcelableExtra("key_pay_info");
                    if (payInfo == null || Util.isNullOrNil(payInfo.dDL)) {
                        AppMethodBeat.o(72087);
                        return false;
                    }
                    this.Ruz.a(new b(payInfo.dDL), payInfo.Kxs, 1);
                    this.Ruz.a(new com.tencent.mm.plugin.wallet_core.c.b.a(), payInfo.Kxs, 1);
                    AppMethodBeat.o(72087);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.o(72098);
            return r0;
        } else if (mMActivity instanceof WalletPayUBalanceResultUI) {
            AnonymousClass2 r02 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_payu.pay.a.d.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72088);
                    s.fOg();
                    s.fOh().Hwc.HVC += ((Orders) objArr[0]).dDO;
                    AppMethodBeat.o(72088);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(72089);
                    switch (i2) {
                        case 0:
                            String string = this.activity.getString(R.string.i75);
                            AppMethodBeat.o(72089);
                            return string;
                        case 1:
                            String string2 = this.activity.getString(R.string.i74);
                            AppMethodBeat.o(72089);
                            return string2;
                        default:
                            CharSequence tips = super.getTips(i2);
                            AppMethodBeat.o(72089);
                            return tips;
                    }
                }
            };
            AppMethodBeat.o(72098);
            return r02;
        } else {
            g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(72098);
            return a2;
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final boolean a(WalletBaseUI walletBaseUI, int i2, String str) {
        return false;
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final int a(MMActivity mMActivity, int i2) {
        return R.string.ins;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "PayUPayProcess";
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        int i3;
        boolean z = true;
        AppMethodBeat.i(72091);
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                b(activity, WalletPayUChangeBankcardUI.class, bundle);
                break;
            case -1003:
                com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.wallet_payu.bind.model.c.class, bundle);
                break;
            case 402:
            case 403:
            case 408:
                b(activity, bundle);
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            Log.i("MicroMsg.PayUPayProcess", "deal with the err!");
            AppMethodBeat.o(72091);
            return;
        }
        if (bundle.containsKey("key_pay_flag")) {
            i3 = bundle.getInt("key_pay_flag", 0);
        } else {
            i3 = this.dQL.getInt("key_pay_flag", 0);
        }
        Log.d("MicroMsg.PayUPayProcess", "forward pay_flag : ".concat(String.valueOf(i3)));
        switch (i3) {
            case 3:
                if (!(activity instanceof WalletPayUVerifyCodeUI)) {
                    if (!(activity instanceof WalletPayUChangeBankcardUI)) {
                        if (!(activity instanceof WalletPayUBalanceResultUI)) {
                            super.a(activity, 0, bundle);
                            break;
                        } else {
                            Intent intent = new Intent(activity, WalletPayUBalanceManagerUI.class);
                            intent.putExtras(new Bundle());
                            intent.getExtras().putAll(bundle);
                            a(activity, WalletPayUBalanceManagerUI.class, intent);
                            AppMethodBeat.o(72091);
                            return;
                        }
                    } else {
                        k(activity, bundle);
                        AppMethodBeat.o(72091);
                        return;
                    }
                } else {
                    g(activity, bundle);
                    AppMethodBeat.o(72091);
                    return;
                }
        }
        AppMethodBeat.o(72091);
    }
}
