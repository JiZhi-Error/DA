package com.tencent.mm.plugin.wallet.pay;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet.pay.a.e.e;
import com.tencent.mm.plugin.wallet.pay.a.e.j;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class b extends com.tencent.mm.plugin.wallet_core.b.a {
    private List<WeakReference<WalletBaseUI>> HFu = new ArrayList();
    private com.tencent.mm.plugin.wallet.pay.a.a.b HFv;

    public b() {
        AppMethodBeat.i(69233);
        AppMethodBeat.o(69233);
    }

    static /* synthetic */ String i(b bVar) {
        AppMethodBeat.i(214052);
        String payReqKey = bVar.getPayReqKey();
        AppMethodBeat.o(214052);
        return payReqKey;
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69234);
        PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
        bundle.putInt("key_pay_scene", payInfo.dVv);
        bundle.putInt("key_pay_channel", payInfo.channel);
        if (f(activity, bundle)) {
            Log.w("MicroMsg.PayProcess", "hy: has err. return");
            AppMethodBeat.o(69234);
        } else {
            int i2 = bundle.getInt("key_pay_flag", 0);
            if ((i2 == 2 || i2 == 1) && payInfo.dVv == 11) {
                z.aqh(13);
            }
            Log.i("MicroMsg.PayProcess", "start pay_flag : " + bundle.getInt("key_pay_flag", 0));
            switch (bundle.getInt("key_pay_flag", 0)) {
                case 1:
                    Log.i("MicroMsg.PayProcess", "start Process : PayRegBindProcess");
                    b(activity, WalletBankcardIdUI.class, bundle);
                    break;
                case 2:
                    Log.i("MicroMsg.PayProcess", "start Process : PayBindProcess");
                    b(activity, WalletCheckPwdUI.class, bundle);
                    break;
                case 3:
                    if (bundle.getBoolean("key_need_verify_sms", false) && !fTp()) {
                        Log.i("MicroMsg.PayProcess", "domestic and verify sms!");
                        b(activity, WalletVerifyCodeUI.class, bundle);
                        break;
                    } else {
                        Log.i("MicroMsg.PayProcess", "jump to result ui!");
                        g(activity, bundle);
                        break;
                    }
            }
            AppMethodBeat.o(69234);
        }
        return this;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        int i3;
        AppMethodBeat.i(69235);
        if (f(activity, bundle)) {
            Log.i("MicroMsg.PayProcess", "deal with the err!");
            AppMethodBeat.o(69235);
            return;
        }
        if (activity instanceof WalletSwitchVerifyPhoneUI) {
            if (this.dQL.getBoolean("key_forward_to_id_verify", false)) {
                Log.i("MicroMsg.PayProcess", "go to verify id tail");
                b(activity, WalletVerifyIdCardUI.class, this.dQL);
                AppMethodBeat.o(69235);
                return;
            }
        } else if (activity instanceof WalletVerifyIdCardUI) {
            g(activity, bundle);
        }
        if (bundle.containsKey("key_pay_flag")) {
            i3 = bundle.getInt("key_pay_flag", 0);
        } else {
            i3 = this.dQL.getInt("key_pay_flag", 0);
        }
        Log.i("MicroMsg.PayProcess", "forward pay_flag : ".concat(String.valueOf(i3)));
        switch (i3) {
            case 1:
                Log.i("MicroMsg.PayProcess", "forwardUnreg()");
                if (activity instanceof WalletSetPasswordUI) {
                    b(activity, WalletPwdConfirmUI.class, bundle);
                    AppMethodBeat.o(69235);
                    return;
                } else if (activity instanceof WalletPwdConfirmUI) {
                    g(activity, bundle);
                    AppMethodBeat.o(69235);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (!fTp()) {
                        Log.i("MicroMsg.PayProcess", "domestic, verify code");
                        b(activity, WalletVerifyCodeUI.class, bundle);
                        AppMethodBeat.o(69235);
                        return;
                    }
                    Log.i("MicroMsg.PayProcess", "oversea, set pwd");
                    b(activity, WalletSetPasswordUI.class, bundle);
                    AppMethodBeat.o(69235);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, (Intent) null, true);
                    AppMethodBeat.o(69235);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    AppMethodBeat.o(69235);
                    return;
                }
            case 2:
                Log.i("MicroMsg.PayProcess", "forwardBind()");
                if ((activity instanceof WalletCheckPwdUI) || (activity instanceof WalletSelectBankcardUI) || (activity instanceof WalletSwitchVerifyPhoneUI)) {
                    b(activity, WalletBankcardIdUI.class, bundle);
                    AppMethodBeat.o(69235);
                    return;
                } else if (activity instanceof WalletVerifyCodeUI) {
                    g(activity, bundle);
                    AppMethodBeat.o(69235);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (!fTp()) {
                        Log.i("MicroMsg.PayProcess", "domestic, verify code!");
                        b(activity, WalletVerifyCodeUI.class, bundle);
                        AppMethodBeat.o(69235);
                        return;
                    }
                    Log.i("MicroMsg.PayProcess", "oversea, jump to result ui!");
                    g(activity, bundle);
                    AppMethodBeat.o(69235);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, (Intent) null, true);
                    AppMethodBeat.o(69235);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    AppMethodBeat.o(69235);
                    return;
                }
            case 3:
                Log.i("MicroMsg.PayProcess", "forwardBound()");
                if (!(activity instanceof WalletVerifyCodeUI)) {
                    if (!(activity instanceof WalletResetInfoUI) && !(activity instanceof WalletChangeBankcardUI)) {
                        if (!(activity instanceof WalletBalanceResultUI)) {
                            if (!(activity instanceof WalletSelectBankcardUI) && !(activity instanceof WalletSwitchVerifyPhoneUI)) {
                                super.a(activity, 0, bundle);
                                break;
                            } else {
                                Log.i("MicroMsg.PayProcess", "need verify code after select bank card!");
                                b(activity, WalletVerifyCodeUI.class, bundle);
                                AppMethodBeat.o(69235);
                                return;
                            }
                        } else {
                            a(activity, WalletBalanceManagerUI.class, -1, (Intent) null, true);
                            AppMethodBeat.o(69235);
                            return;
                        }
                    } else if ((!bundle.getBoolean("key_need_verify_sms", false) || fTp()) && !bundle.getBoolean("key_is_changing_balance_phone_num")) {
                        Log.i("MicroMsg.PayProcess", "jump to result ui!");
                        g(activity, bundle);
                        AppMethodBeat.o(69235);
                        return;
                    } else {
                        Log.i("MicroMsg.PayProcess", "need verify code after reset info or change bank card info!");
                        b(activity, WalletVerifyCodeUI.class, bundle);
                        AppMethodBeat.o(69235);
                        return;
                    }
                } else {
                    g(activity, bundle);
                    AppMethodBeat.o(69235);
                    return;
                }
        }
        AppMethodBeat.o(69235);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(69236);
        Log.i("MicroMsg.PayProcess", "back pay_flag : " + this.dQL.getInt("key_pay_flag", 0));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i2);
            AppMethodBeat.o(69236);
            return;
        }
        z.hhs();
        P(activity);
        AppMethodBeat.o(69236);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        PayInfo payInfo;
        int i2 = -1;
        AppMethodBeat.i(69237);
        Log.i("MicroMsg.PayProcess", "end pay_flag : " + this.dQL.getInt("key_pay_flag", 0));
        z.hhs();
        int i3 = this.dQL.getBoolean("intent_pay_end", false) ? -1 : 0;
        Intent intent = new Intent();
        if (bundle != null) {
            PayInfo payInfo2 = (PayInfo) this.dQL.getParcelable("key_pay_info");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("intent_pay_end_errcode", this.dQL.getInt("intent_pay_end_errcode"));
            bundle2.putString("intent_pay_app_url", this.dQL.getString("intent_pay_app_url"));
            bundle2.putBoolean("intent_pay_end", this.dQL.getBoolean("intent_pay_end"));
            bundle2.putString("intent_wap_pay_jump_url", this.dQL.getString("intent_wap_pay_jump_url"));
            bundle2.putParcelable("key_realname_guide_helper", this.dQL.getParcelable("key_realname_guide_helper"));
            if (payInfo2 != null) {
                bundle2.putInt("pay_channel", payInfo2.channel);
            }
            intent.putExtras(bundle2);
        }
        intent.putExtra("key_orders", this.dQL.getParcelable("key_orders"));
        intent.putExtra("key_is_clear_failure", this.dQL.getInt("key_is_clear_failure", -1));
        aaa aaa = new aaa();
        aaa.egJ.intent = intent;
        aaa.egJ.dDL = getPayReqKey();
        aaa.a aVar = aaa.egJ;
        if (!this.dQL.getBoolean("intent_pay_end", false)) {
            i2 = 0;
        }
        aVar.result = i2;
        if (!(aaa.egJ.result != 0 || bundle == null || (payInfo = (PayInfo) bundle.getParcelable("key_pay_info")) == null)) {
            com.tencent.mm.plugin.wallet.pay.a.b.b.aD(payInfo.dDL, payInfo.dVv, payInfo.channel);
        }
        EventCenter.instance.publish(aaa);
        a(activity, "wallet", ".pay.ui.WalletPayUI", i3, intent, false);
        AppMethodBeat.o(69237);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(WalletBaseUI walletBaseUI) {
        AppMethodBeat.i(69238);
        this.HFu.add(new WeakReference<>(walletBaseUI));
        AppMethodBeat.o(69238);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(WalletBaseUI walletBaseUI) {
        AppMethodBeat.i(69239);
        for (WeakReference<WalletBaseUI> weakReference : this.HFu) {
            if (weakReference.get() == walletBaseUI) {
                this.HFu.remove(weakReference);
                AppMethodBeat.o(69239);
                return;
            }
        }
        AppMethodBeat.o(69239);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void fOj() {
        AppMethodBeat.i(69240);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(69203);
                for (WeakReference weakReference : b.this.HFu) {
                    WalletBaseUI walletBaseUI = (WalletBaseUI) weakReference.get();
                    if (walletBaseUI != null && !walletBaseUI.hasFinish()) {
                        Log.i("MicroMsg.PayProcess", "do finish activity: %s", walletBaseUI);
                        walletBaseUI.finish();
                    }
                }
                b.this.HFu.clear();
                AppMethodBeat.o(69203);
            }
        }, 200);
        AppMethodBeat.o(69240);
    }

    private boolean fOk() {
        int i2;
        AppMethodBeat.i(69241);
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_FORCE_USE_NEW_CASHIER_INT_SYNC, (Object) 0)).intValue();
        if (CrashReportFactory.hasDebuger() || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            i2 = 1;
        } else {
            i2 = intValue;
        }
        Orders orders = (Orders) this.dQL.getParcelable("key_orders");
        if (i2 == 1 || (orders != null && orders.HZA == 1)) {
            AppMethodBeat.o(69241);
            return true;
        }
        AppMethodBeat.o(69241);
        return false;
    }

    private boolean f(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69242);
        int i2 = bundle.getInt("key_err_code", 0);
        Log.i("MicroMsg.PayProcess", "dealwithErr(), errCode %d", Integer.valueOf(i2));
        switch (i2) {
            case -1004:
                this.dQL.putInt("key_pay_flag", 3);
                this.dQL.putInt("key_err_code", 0);
                if (fOk()) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("direc_change_bankcard", true);
                    bundle2.putBoolean("send_cancel_event", false);
                    b(activity, WalletPayUI.class, bundle2, 0);
                } else {
                    b(activity, WalletChangeBankcardUI.class, bundle);
                }
                AppMethodBeat.o(69242);
                return true;
            case -1003:
                s.fOg();
                if (s.fOh().fRk()) {
                    bundle.putInt("key_pay_flag", 2);
                    bundle.putInt("key_err_code", 0);
                    b(activity, WalletCheckPwdUI.class, bundle);
                } else {
                    bundle.putInt("key_pay_flag", 1);
                    bundle.putInt("key_err_code", 0);
                    b(activity, WalletBankcardIdUI.class, bundle);
                }
                AppMethodBeat.o(69242);
                return true;
            case 402:
            case 403:
            case 408:
                Bankcard bankcard = (Bankcard) this.dQL.get("key_bankcard");
                if (bankcard == null || !bankcard.fQb()) {
                    b(activity, WalletResetInfoUI.class, bundle);
                } else if (t.fQI().fRE() == null || t.fQI().fRE().size() <= 0) {
                    b(activity, WalletBankcardIdUI.class, bundle);
                } else {
                    Log.i("MicroMsg.PayProcess", "hy: go to select bankcard ui");
                    Bundle bundle3 = new Bundle();
                    bundle3.putBoolean("key_is_show_new_bankcard", true);
                    bundle3.putInt("key_scene", 0);
                    bundle3.putParcelableArrayList("key_showing_bankcards", t.fQI().fRE());
                    bundle3.putString("key_top_tips", activity.getString(R.string.is1));
                    b(activity, WalletSelectBankcardUI.class, bundle3);
                }
                AppMethodBeat.o(69242);
                return true;
            case 417:
                bundle.putInt("key_err_code", 0);
                b(activity, WalletSwitchVerifyPhoneUI.class, bundle);
                AppMethodBeat.o(69242);
                return true;
            case 418:
                bundle.putInt("key_err_code", 0);
                b(activity, WalletResetInfoUI.class, bundle);
                AppMethodBeat.o(69242);
                return true;
            default:
                AppMethodBeat.o(69242);
                return false;
        }
    }

    private void g(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69243);
        if (this.dQL != null && this.dQL.containsKey("key_realname_guide_helper")) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putParcelable("key_realname_guide_helper", this.dQL.getParcelable("key_realname_guide_helper"));
        }
        int i2 = bundle.getInt("key_pay_scene", 6);
        Log.i("MicroMsg.PayProcess", "jumpToResultUI() payScene:%d", Integer.valueOf(i2));
        if (i2 == 11 || i2 == 21) {
            b(activity, WalletBalanceResultUI.class, bundle);
            AppMethodBeat.o(69243);
        } else if (i2 == 5 || i2 == 31 || i2 == 32 || i2 == 33 || i2 == 48) {
            PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
            if (payInfo == null || payInfo.CpF != 1) {
                a(activity, "remittance", ".ui.RemittanceResultUI", bundle);
                AppMethodBeat.o(69243);
                return;
            }
            Log.i("MicroMsg.PayProcess", "is busi f2f");
            b(activity, bundle);
            AppMethodBeat.o(69243);
        } else if (i2 == 37 || i2 == 39 || i2 == 42 || i2 == 45 || i2 == 52 || i2 == 49) {
            b(activity, bundle);
            AppMethodBeat.o(69243);
        } else if (i2 == 56) {
            a(activity, "remittance", ".mobile.ui.MobileRemitResultUI", bundle);
            AppMethodBeat.o(69243);
        } else {
            b(activity, WalletOrderInfoUI.class, bundle);
            AppMethodBeat.o(69243);
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69244);
        Log.d("MicroMsg.PayProcess", "pay_flag : " + this.dQL.getInt("key_pay_flag", 0));
        switch (this.dQL.getInt("key_pay_flag", 0)) {
            case 1:
                boolean z = activity instanceof WalletOrderInfoUI;
                AppMethodBeat.o(69244);
                return z;
            case 2:
                boolean z2 = activity instanceof WalletOrderInfoUI;
                AppMethodBeat.o(69244);
                return z2;
            case 3:
                AppMethodBeat.o(69244);
                return false;
            default:
                AppMethodBeat.o(69244);
                return false;
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(69245);
        if (mMActivity instanceof WalletPayUI) {
            AnonymousClass11 r0 = new a((WalletBaseUI) mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass11 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean A(Object... objArr) {
                    return false;
                }

                @Override // com.tencent.mm.plugin.wallet.pay.c, com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69217);
                    if (!super.onSceneEnd(i2, i3, str, qVar)) {
                        AppMethodBeat.o(69217);
                        return false;
                    }
                    AppMethodBeat.o(69217);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.o(69245);
            return r0;
        } else if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass12 r02 = new a((WalletBaseUI) mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass12 */

                @Override // com.tencent.mm.plugin.wallet.pay.c, com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69218);
                    if (!super.onSceneEnd(i2, i3, str, qVar)) {
                        AppMethodBeat.o(69218);
                        return false;
                    }
                    AppMethodBeat.o(69218);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69219);
                    this.Ruz.a(new w((String) objArr[0], 4, (String) objArr[1]), true, 1);
                    AppMethodBeat.o(69219);
                    return true;
                }
            };
            AppMethodBeat.o(69245);
            return r02;
        } else if (mMActivity instanceof WalletBankcardIdUI) {
            AnonymousClass13 r03 = new a((WalletBaseUI) mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass13 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean A(Object... objArr) {
                    AppMethodBeat.i(69220);
                    if (b.this.dQL.getInt("key_pay_scene", 0) == 11) {
                        Bundle bundle = b.this.dQL;
                        s.fOg();
                        bundle.putParcelable("key_history_bankcard", s.fOh().IbL);
                    }
                    boolean A = super.A(objArr);
                    AppMethodBeat.o(69220);
                    return A;
                }

                @Override // com.tencent.mm.plugin.wallet.pay.c, com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69221);
                    if (!super.onSceneEnd(i2, i3, str, qVar)) {
                        AppMethodBeat.o(69221);
                        return false;
                    }
                    AppMethodBeat.o(69221);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.o(69245);
            return r03;
        } else if (mMActivity instanceof WalletCardElementUI) {
            AnonymousClass14 r04 = new a((WalletBaseUI) mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass14 */

                @Override // com.tencent.mm.plugin.wallet.pay.c, com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69222);
                    if (super.onSceneEnd(i2, i3, str, qVar)) {
                        AppMethodBeat.o(69222);
                        return true;
                    } else if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                            com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) qVar;
                            b.this.HFv = bVar;
                            b.this.dQL.putString("kreq_token", bVar.getToken());
                            if (bVar.isPaySuccess) {
                                b.this.dQL.putParcelable("key_orders", bVar.HFH);
                            }
                            RealnameGuideHelper realnameGuideHelper = bVar.AJr;
                            if (realnameGuideHelper != null) {
                                b.this.dQL.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                            }
                        } else if (qVar instanceof c) {
                            c cVar = (c) qVar;
                            b.this.HFv = cVar;
                            b.this.dQL.putString("kreq_token", cVar.getToken());
                            if (cVar.isPaySuccess) {
                                b.this.dQL.putParcelable("key_orders", cVar.HFH);
                            }
                        }
                        if (b.this.c(this.activity, (Bundle) null)) {
                            this.Ruz.a(new ad(b.i(b.this), 13), true, 1);
                            AppMethodBeat.o(69222);
                            return true;
                        }
                        if (!(qVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) || !((com.tencent.mm.plugin.wallet.pay.a.a.b) qVar).HFE) {
                            b.this.a(this.activity, 0, b.this.dQL);
                        }
                        AppMethodBeat.o(69222);
                        return true;
                    } else {
                        AppMethodBeat.o(69222);
                        return false;
                    }
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69223);
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    Log.i("MicroMsg.PayProcess", "WalletCardElementUI onNext pay_flag : " + b.this.dQL.getInt("key_pay_flag", 0));
                    switch (b.this.dQL.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (!b.this.fTp()) {
                                authen.cSx = 1;
                            } else {
                                authen.cSx = 4;
                            }
                            this.Ruz.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                            AppMethodBeat.o(69223);
                            return true;
                        case 2:
                            if (!b.this.fTp()) {
                                authen.cSx = 2;
                            } else {
                                authen.cSx = 5;
                            }
                            if (b.this.dQL.getBoolean("key_is_changing_balance_phone_num", false)) {
                                this.Ruz.a(com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders, b.this.dQL.getBoolean("key_isbalance", false)), true, 1);
                            } else {
                                this.Ruz.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                            }
                            AppMethodBeat.o(69223);
                            return true;
                        case 3:
                            if (!b.this.fTp()) {
                                authen.cSx = 3;
                            } else {
                                authen.cSx = 6;
                            }
                            this.Ruz.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                            AppMethodBeat.o(69223);
                            return true;
                        default:
                            AppMethodBeat.o(69223);
                            return false;
                    }
                }
            };
            AppMethodBeat.o(69245);
            return r04;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            AnonymousClass15 r05 = new a((WalletBaseUI) mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass15 */

                @Override // com.tencent.mm.plugin.wallet.pay.c, com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69224);
                    if (!super.onSceneEnd(i2, i3, str, qVar)) {
                        if (i2 == 0 && i3 == 0) {
                            if ((qVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.g) || (qVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.b)) {
                                com.tencent.mm.plugin.wallet.pay.a.d.g gVar = (com.tencent.mm.plugin.wallet.pay.a.d.g) qVar;
                                if (gVar.isPaySuccess) {
                                    b.this.dQL.putParcelable("key_orders", gVar.HFH);
                                }
                                RealnameGuideHelper realnameGuideHelper = gVar.AJr;
                                if (realnameGuideHelper != null) {
                                    b.this.dQL.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                                }
                                h.INSTANCE.a(10707, 1, Integer.valueOf(f.fUj()));
                                AppMethodBeat.o(69224);
                                return false;
                            } else if (qVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                                AppMethodBeat.o(69224);
                                return true;
                            }
                        }
                        AppMethodBeat.o(69224);
                        return false;
                    }
                    AppMethodBeat.o(69224);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean B(Object... objArr) {
                    AppMethodBeat.i(214051);
                    if (b.this.HFv != null) {
                        b.this.HFv.resend();
                        this.Ruz.b(b.this.HFv, false);
                        AppMethodBeat.o(214051);
                        return true;
                    }
                    boolean B = super.B(objArr);
                    AppMethodBeat.o(214051);
                    return B;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69225);
                    v vVar = (v) objArr[1];
                    Orders orders = (Orders) b.this.dQL.getParcelable("key_orders");
                    Log.i("MicroMsg.PayProcess", "WalletVerifyCodeUI onNext pay_flag : " + b.this.dQL.getInt("key_pay_flag", 0));
                    boolean z = b.this.dQL.getBoolean("key_is_changing_balance_phone_num");
                    switch (b.this.dQL.getInt("key_pay_flag", 0)) {
                        case 1:
                            vVar.flag = "1";
                            if (z) {
                                this.Ruz.a(com.tencent.mm.plugin.wallet.pay.a.a.b(vVar, orders), true, 1);
                            } else {
                                com.tencent.mm.plugin.wallet.pay.a.d.g a2 = com.tencent.mm.plugin.wallet.pay.a.a.a(vVar, orders);
                                if (a2 != null) {
                                    this.Ruz.a(a2, true, 1);
                                }
                            }
                            AppMethodBeat.o(69225);
                            return true;
                        case 2:
                            if (!b.this.fTp()) {
                                vVar.flag = "2";
                            } else {
                                vVar.flag = "5";
                            }
                            if (z) {
                                this.Ruz.a(com.tencent.mm.plugin.wallet.pay.a.a.b(vVar, orders), true, 1);
                            } else {
                                com.tencent.mm.plugin.wallet.pay.a.d.g a3 = com.tencent.mm.plugin.wallet.pay.a.a.a(vVar, orders);
                                if (a3 != null) {
                                    this.Ruz.a(a3, true, 1);
                                }
                            }
                            AppMethodBeat.o(69225);
                            return true;
                        case 3:
                            if (!b.this.fTp()) {
                                vVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                            } else {
                                vVar.flag = "6";
                            }
                            if (z) {
                                this.Ruz.a(com.tencent.mm.plugin.wallet.pay.a.a.b(vVar, orders), true, 1);
                            } else {
                                com.tencent.mm.plugin.wallet.pay.a.d.g a4 = com.tencent.mm.plugin.wallet.pay.a.a.a(vVar, orders);
                                if (a4 != null) {
                                    this.Ruz.a(a4, true, 1);
                                }
                            }
                            AppMethodBeat.o(69225);
                            return true;
                        default:
                            AppMethodBeat.o(69225);
                            return false;
                    }
                }
            };
            AppMethodBeat.o(69245);
            return r05;
        } else if (mMActivity instanceof WalletBalanceResultUI) {
            AnonymousClass16 r06 = new a((WalletBaseUI) mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass16 */

                @Override // com.tencent.mm.plugin.wallet.pay.c, com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69226);
                    if (!super.onSceneEnd(i2, i3, str, qVar)) {
                        AppMethodBeat.o(69226);
                        return false;
                    }
                    AppMethodBeat.o(69226);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69227);
                    Orders orders = (Orders) objArr[0];
                    s.fOg();
                    Bankcard bankcard = s.fOh().Hwc;
                    if (bankcard == null) {
                        Log.i("MicroMsg.PayProcess", "balance == null");
                        AppMethodBeat.o(69227);
                    } else {
                        bankcard.HVC += orders.dDO;
                        AppMethodBeat.o(69227);
                    }
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(69228);
                    switch (i2) {
                        case 0:
                            String string = this.activity.getString(R.string.i75);
                            AppMethodBeat.o(69228);
                            return string;
                        case 1:
                            String string2 = this.activity.getString(R.string.i74);
                            AppMethodBeat.o(69228);
                            return string2;
                        default:
                            CharSequence tips = super.getTips(i2);
                            AppMethodBeat.o(69228);
                            return tips;
                    }
                }
            };
            AppMethodBeat.o(69245);
            return r06;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            AnonymousClass17 r07 = new a((WalletBaseUI) mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass17 */

                @Override // com.tencent.mm.plugin.wallet.pay.c, com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69229);
                    if (super.onSceneEnd(i2, i3, str, qVar)) {
                        AppMethodBeat.o(69229);
                        return true;
                    } else if ((qVar instanceof j) && i2 == 0 && i3 == 0) {
                        j jVar = (j) qVar;
                        if (jVar.isPaySuccess) {
                            b.this.dQL.putParcelable("key_orders", jVar.HFH);
                        }
                        RealnameGuideHelper realnameGuideHelper = jVar.AJr;
                        if (realnameGuideHelper != null) {
                            b.this.dQL.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                        }
                        b.this.a(this.activity, 0, b.this.dQL);
                        AppMethodBeat.o(69229);
                        return true;
                    } else {
                        AppMethodBeat.o(69229);
                        return false;
                    }
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    com.tencent.mm.plugin.wallet.pay.a.e.a aVar;
                    AppMethodBeat.i(69230);
                    v vVar = (v) objArr[0];
                    Orders orders = (Orders) b.this.dQL.getParcelable("key_orders");
                    if (vVar == null || orders == null) {
                        Log.e("MicroMsg.CgiManager", "empty verify or orders");
                        aVar = null;
                    } else {
                        PayInfo payInfo = vVar.BDB;
                        String str = "";
                        if (payInfo != null) {
                            Log.i("MicroMsg.CgiManager", "get reqKey from payInfo");
                            str = payInfo.dDL;
                        }
                        if (Util.isNullOrNil(str)) {
                            Log.i("MicroMsg.CgiManager", "get reqKey from orders");
                            str = orders.dDL;
                        }
                        if (Util.isNullOrNil(str)) {
                            Log.i("MicroMsg.CgiManager", "empty reqKey!");
                            aVar = new j(vVar, orders);
                        } else {
                            if (payInfo != null) {
                                Log.d("MicroMsg.CgiManager", "reqKey: %s, %s", payInfo.dDL, orders.dDL);
                            }
                            Log.i("MicroMsg.CgiManager", "verifyreg reqKey: %s", str);
                            Log.i("MicroMsg.CgiManager", "verifyreg go new split cgi");
                            if (str.startsWith("sns_aa_")) {
                                aVar = new com.tencent.mm.plugin.wallet.pay.a.e.a(vVar, orders);
                            } else if (str.startsWith("sns_tf_")) {
                                aVar = new com.tencent.mm.plugin.wallet.pay.a.e.h(vVar, orders);
                            } else if (str.startsWith("sns_ff_")) {
                                aVar = new com.tencent.mm.plugin.wallet.pay.a.e.c(vVar, orders);
                            } else if (str.startsWith("ts_")) {
                                aVar = new com.tencent.mm.plugin.wallet.pay.a.e.d(vVar, orders);
                            } else if (str.startsWith("sns_")) {
                                aVar = new com.tencent.mm.plugin.wallet.pay.a.e.f(vVar, orders);
                            } else if (str.startsWith("up_")) {
                                aVar = new com.tencent.mm.plugin.wallet.pay.a.e.i(vVar, orders);
                            } else if (str.startsWith("seb_ff_")) {
                                aVar = new e(vVar, orders);
                            } else if (str.startsWith("tax_")) {
                                aVar = new com.tencent.mm.plugin.wallet.pay.a.e.g(vVar, orders);
                            } else if (str.startsWith("dc_")) {
                                aVar = new com.tencent.mm.plugin.wallet.pay.a.e.b(vVar, orders);
                            } else {
                                aVar = new j(vVar, orders);
                            }
                        }
                    }
                    if (aVar != null) {
                        this.Ruz.a(aVar, true, 1);
                    }
                    AppMethodBeat.o(69230);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final /* synthetic */ CharSequence getTips(int i2) {
                    AppMethodBeat.i(69231);
                    String string = this.activity.getString(R.string.isr);
                    AppMethodBeat.o(69231);
                    return string;
                }
            };
            AppMethodBeat.o(69245);
            return r07;
        } else if (mMActivity instanceof WalletChangeBankcardUI) {
            AnonymousClass18 r08 = new c((WalletBaseUI) mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass18 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    return false;
                }

                @Override // com.tencent.mm.plugin.wallet.pay.c, com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69232);
                    if (!super.onSceneEnd(i2, i3, str, qVar)) {
                        AppMethodBeat.o(69232);
                        return false;
                    }
                    AppMethodBeat.o(69232);
                    return true;
                }
            };
            AppMethodBeat.o(69245);
            return r08;
        } else if (mMActivity instanceof WalletSelectBankcardUI) {
            AnonymousClass2 r09 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69204);
                    if (i2 == 0 && i3 == 0 && (qVar instanceof c)) {
                        Log.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, forward");
                        b.this.a(this.activity, 0, b.this.dQL);
                        AppMethodBeat.o(69204);
                        return true;
                    }
                    if (i2 == 0 && i3 == 0 && (qVar instanceof y)) {
                        Log.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, directToNext");
                        fOl();
                    }
                    AppMethodBeat.o(69204);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69205);
                    Log.i("MicroMsg.PayProcess", "onNext for select bank card");
                    b.this.dQL.putInt("key_err_code", 0);
                    Bankcard bankcard = (Bankcard) b.this.dQL.getParcelable("key_bankcard");
                    if (bankcard == null) {
                        Log.i("MicroMsg.PayProcess", "directToBindNew()");
                        b.this.dQL.putInt("key_pay_flag", 2);
                        b.this.a(this.activity, 0, b.this.dQL);
                    } else if (t.fQQ().aVi(bankcard.field_bankcardType) != null) {
                        fOl();
                    } else {
                        this.Ruz.a(new y("", "", null), true, 1);
                    }
                    AppMethodBeat.o(69205);
                    return false;
                }

                private void fOl() {
                    AppMethodBeat.i(69206);
                    Log.i("MicroMsg.PayProcess", "directToNext()");
                    boolean z = b.this.dQL.getBoolean("key_balance_change_phone_need_confirm_phone", false);
                    Authen authen = (Authen) b.this.dQL.getParcelable("key_authen");
                    Orders orders = (Orders) b.this.dQL.getParcelable("key_orders");
                    Bankcard bankcard = (Bankcard) b.this.dQL.getParcelable("key_bankcard");
                    ElementQuery aVi = t.fQQ().aVi(bankcard.field_bankcardType);
                    b.this.dQL.putParcelable("elemt_query", aVi);
                    if (!z) {
                        authen.HQc = "";
                        authen.dDj = bankcard.field_bankcardType;
                        authen.ANo = bankcard.field_bindSerial;
                        b.this.dQL.putString("key_mobile", bankcard.field_mobile);
                        if (aVi == null || aVi.HXf || aVi.HXg) {
                            Log.i("MicroMsg.PayProcess", "hy: need rewrite cvv or validThru");
                            b.this.a(this.activity, 0, b.this.dQL);
                            AppMethodBeat.o(69206);
                            return;
                        }
                        this.Ruz.b(com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders, b.this.dQL.getBoolean("key_isbalance", false)), true);
                        AppMethodBeat.o(69206);
                        return;
                    }
                    authen.dDj = bankcard.field_bankcardType;
                    authen.ANo = bankcard.field_bindSerial;
                    b.this.a(this.activity, 0, b.this.dQL);
                    AppMethodBeat.o(69206);
                }
            };
            AppMethodBeat.o(69245);
            return r09;
        } else if (mMActivity instanceof WalletResetInfoUI) {
            AnonymousClass3 r010 = new a((WalletBaseUI) mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean A(Object... objArr) {
                    return false;
                }

                @Override // com.tencent.mm.plugin.wallet.pay.c, com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69207);
                    if (!super.onSceneEnd(i2, i3, str, qVar)) {
                        AppMethodBeat.o(69207);
                        return false;
                    }
                    AppMethodBeat.o(69207);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.o(69245);
            return r010;
        } else if (mMActivity instanceof WalletSwitchVerifyPhoneUI) {
            AnonymousClass4 r011 = new a((WalletBaseUI) mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69208);
                    Log.i("MicroMsg.PayProcess", "start do authen");
                    ix ixVar = (ix) objArr[0];
                    Authen authen = (Authen) b.this.dQL.getParcelable("key_authen");
                    Bankcard bankcard = new Bankcard();
                    bankcard.field_bindSerial = ixVar.ANo;
                    bankcard.field_mobile = ixVar.HQc;
                    bankcard.field_desc = ixVar.ynT;
                    bankcard.field_bankcardType = authen.dDj;
                    Log.d("MicroMsg.PayProcess", "tft: bank_type: %s, bank_serial: %s, authen.serial: %s", authen.dDj, ixVar.ANo, authen.ANo);
                    b.this.dQL.putString("key_mobile", bankcard.field_mobile);
                    b.this.dQL.putParcelable("key_bankcard", bankcard);
                    authen.HUZ = ixVar.KNr;
                    authen.HVa = ixVar.ANo;
                    authen.HVb = ixVar.dDj;
                    authen.HVc = "1";
                    com.tencent.mm.plugin.wallet.pay.a.a.b a2 = com.tencent.mm.plugin.wallet.pay.a.a.a(authen, (Orders) b.this.dQL.getParcelable("key_orders"), false);
                    if (a2 != null) {
                        this.Ruz.a(a2, true, 1);
                    }
                    AppMethodBeat.o(69208);
                    return false;
                }

                @Override // com.tencent.mm.plugin.wallet.pay.c, com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69209);
                    if (qVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                        Log.i("MicroMsg.PayProcess", "finish auth");
                        Authen authen = ((com.tencent.mm.plugin.wallet.pay.a.a.b) qVar).HFI;
                        Orders orders = ((com.tencent.mm.plugin.wallet.pay.a.a.b) qVar).HFH;
                        b.this.dQL.putParcelable("key_authen", authen);
                        b.this.dQL.putParcelable("key_orders", orders);
                        b.this.dQL.putString("kreq_token", ((com.tencent.mm.plugin.wallet.pay.a.a.b) qVar).getToken());
                        b.this.dQL.putBoolean("key_is_return_from_switch_phone", true);
                        b.this.dQL.putInt("key_err_code", 0);
                        Bankcard bankcard = (Bankcard) b.this.dQL.getParcelable("key_bankcard");
                        bankcard.field_bankcardType = authen.dDj;
                        bankcard.field_bindSerial = authen.ANo;
                        b.this.P(this.activity);
                        AppMethodBeat.o(69209);
                        return true;
                    }
                    AppMethodBeat.o(69209);
                    return false;
                }
            };
            AppMethodBeat.o(69245);
            return r011;
        } else if (mMActivity instanceof WalletVerifyIdCardUI) {
            AnonymousClass5 r012 = new a((WalletBaseUI) mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69210);
                    if (objArr.length > 0) {
                        this.Ruz.a(com.tencent.mm.plugin.wallet.pay.a.a.a((v) objArr[0], (Orders) b.this.dQL.getParcelable("key_orders")), true, 1);
                    }
                    AppMethodBeat.o(69210);
                    return false;
                }

                @Override // com.tencent.mm.plugin.wallet.pay.c, com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69211);
                    if (!super.onSceneEnd(i2, i3, str, qVar) && (qVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.g)) {
                        com.tencent.mm.plugin.wallet.pay.a.d.g gVar = (com.tencent.mm.plugin.wallet.pay.a.d.g) qVar;
                        if (i2 == 0 && i3 == 0) {
                            if (gVar.isPaySuccess) {
                                b.this.dQL.putParcelable("key_orders", gVar.HFH);
                            }
                            RealnameGuideHelper realnameGuideHelper = gVar.AJr;
                            if (realnameGuideHelper != null) {
                                b.this.dQL.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                            }
                            b.this.a(this.activity, 0, b.this.dQL);
                            this.activity.finish();
                            AppMethodBeat.o(69211);
                            return true;
                        }
                    }
                    AppMethodBeat.o(69211);
                    return false;
                }
            };
            AppMethodBeat.o(69245);
            return r012;
        } else {
            com.tencent.mm.wallet_core.d.g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(69245);
            return a2;
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final boolean a(final WalletBaseUI walletBaseUI, final int i2, String str) {
        String str2;
        AppMethodBeat.i(69246);
        Log.i("MicroMsg.PayProcess", "onReceiveErr(), errCode %d", Integer.valueOf(i2));
        switch (i2) {
            case 404:
                Log.i("MicroMsg.PayProcess", "404 pay error, cancel pay or change!");
                s.fOg();
                ArrayList<Bankcard> fRE = s.fOh().fRE();
                if (fRE == null || fRE.isEmpty()) {
                    com.tencent.mm.ui.base.h.c(walletBaseUI, str, "", walletBaseUI.getString(R.string.imy), walletBaseUI.getString(R.string.i8q), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(69213);
                            b.this.dQL.putInt("key_err_code", -1003);
                            b.this.a(walletBaseUI, 0, b.this.dQL);
                            if (walletBaseUI.isTransparent()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.o(69213);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass8 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(69214);
                            b.this.b(walletBaseUI, b.this.dQL);
                            if (walletBaseUI.isTransparent()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.o(69214);
                        }
                    });
                } else {
                    com.tencent.mm.ui.base.h.c(walletBaseUI, str, "", walletBaseUI.getString(R.string.ing), walletBaseUI.getString(R.string.i8q), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass9 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(69215);
                            Bankcard bankcard = (Bankcard) b.this.dQL.getParcelable("key_bankcard");
                            PayInfo payInfo = (PayInfo) b.this.dQL.getParcelable("key_pay_info");
                            if (!(bankcard == null || payInfo == null)) {
                                bankcard.HVB = payInfo.dDL;
                            }
                            b.this.dQL.putInt("key_err_code", -1004);
                            b.this.a(walletBaseUI, 0, b.this.dQL);
                            if (walletBaseUI.isTransparent()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.o(69215);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass10 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(69216);
                            b.this.b(walletBaseUI, b.this.dQL);
                            if (walletBaseUI.isTransparent()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.o(69216);
                        }
                    });
                }
                AppMethodBeat.o(69246);
                return true;
            case 402:
            case 403:
            case 408:
                if (hgL() && this.dQL.getParcelable("key_bankcard") != null) {
                    Bankcard bankcard = (Bankcard) this.dQL.getParcelable("key_bankcard");
                    if (Util.isNullOrNil(str)) {
                        str2 = walletBaseUI.getString(R.string.io6, new Object[]{bankcard.field_desc, bankcard.field_mobile});
                    } else {
                        str2 = str;
                    }
                    com.tencent.mm.ui.base.h.c(walletBaseUI, str2, "", walletBaseUI.getString(R.string.io5), walletBaseUI.getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.pay.b.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(69212);
                            b.this.dQL.putInt("key_pay_flag", 3);
                            b.this.dQL.putInt("key_err_code", i2);
                            b.this.a(walletBaseUI, 0, b.this.dQL);
                            if (walletBaseUI.isTransparent()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.o(69212);
                        }
                    }, null);
                    AppMethodBeat.o(69246);
                    return true;
                }
        }
        AppMethodBeat.o(69246);
        return false;
    }

    private String getPayReqKey() {
        AppMethodBeat.i(69247);
        if (this.dQL == null) {
            AppMethodBeat.o(69247);
            return "";
        }
        PayInfo payInfo = (PayInfo) this.dQL.getParcelable("key_pay_info");
        if (payInfo != null) {
            String str = payInfo.dDL;
            AppMethodBeat.o(69247);
            return str;
        }
        AppMethodBeat.o(69247);
        return "";
    }

    abstract class a extends c {
        public a(WalletBaseUI walletBaseUI, i iVar) {
            super(walletBaseUI, iVar);
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final int a(MMActivity mMActivity, int i2) {
        return R.string.inr;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "PayProcess";
    }
}
