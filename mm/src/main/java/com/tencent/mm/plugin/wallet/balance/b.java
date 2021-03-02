package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet.pay.a.e.j;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.text.SimpleDateFormat;
import java.util.Date;

public class b extends d {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(68385);
        z.aqh(14);
        if (activity instanceof WalletBalanceFetchUI) {
            s.fOg();
            if (!s.fOh().fRk()) {
                this.dQL.putInt("key_pay_flag", 1);
                b(activity, WalletBankcardIdUI.class, bundle);
            } else if (((Bankcard) this.dQL.getParcelable("key_bankcard")) != null) {
                this.dQL.putInt("key_pay_flag", 3);
                this.dQL.putString("key_pwd_cash_title", activity.getString(R.string.i6f));
                Orders orders = (Orders) this.dQL.getParcelable("key_orders");
                if (orders != null) {
                    this.dQL.putString("key_pwd_cash_money", f.D(orders.dDO));
                }
                b(activity, WalletBalanceFetchPwdInputUI.class, bundle);
            } else {
                this.dQL.putInt("key_pay_flag", 2);
                b(activity, WalletCheckPwdUI.class, bundle);
            }
        } else {
            b(activity, WalletBalanceFetchUI.class, bundle);
        }
        AppMethodBeat.o(68385);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(68386);
        if (activity instanceof WalletBalanceFetchUI) {
            s.fOg();
            if (!s.fOh().fRk()) {
                this.dQL.putInt("key_pay_flag", 1);
                b(activity, WalletBankcardIdUI.class, bundle);
                AppMethodBeat.o(68386);
            } else if (((Bankcard) this.dQL.getParcelable("key_bankcard")) != null) {
                this.dQL.putInt("key_pay_flag", 3);
                this.dQL.putString("key_pwd_cash_title", activity.getString(R.string.i6f));
                Orders orders = (Orders) this.dQL.getParcelable("key_orders");
                if (orders != null) {
                    this.dQL.putString("key_pwd_cash_money", f.D(orders.dDO));
                }
                b(activity, WalletBalanceFetchPwdInputUI.class, bundle);
                AppMethodBeat.o(68386);
            } else {
                this.dQL.putInt("key_pay_flag", 2);
                b(activity, WalletCheckPwdUI.class, bundle);
                AppMethodBeat.o(68386);
            }
        } else if (activity instanceof WalletBalanceFetchPwdInputUI) {
            if (bundle.getBoolean("key_need_verify_sms", false)) {
                b(activity, WalletVerifyCodeUI.class, bundle);
                AppMethodBeat.o(68386);
                return;
            }
            b(activity, WalletBalanceFetchResultUI.class, bundle);
            AppMethodBeat.o(68386);
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, WalletBankcardIdUI.class, bundle);
            AppMethodBeat.o(68386);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            b(activity, WalletCardElementUI.class, bundle);
            AppMethodBeat.o(68386);
        } else if (activity instanceof WalletCardElementUI) {
            b(activity, WalletVerifyCodeUI.class, bundle);
            AppMethodBeat.o(68386);
        } else if (activity instanceof WalletVerifyCodeUI) {
            s.fOg();
            if (s.fOh().fRk()) {
                b(activity, WalletBalanceFetchResultUI.class, bundle);
                AppMethodBeat.o(68386);
                return;
            }
            b(activity, WalletSetPasswordUI.class, bundle);
            AppMethodBeat.o(68386);
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.o(68386);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, WalletBalanceFetchResultUI.class, bundle);
            AppMethodBeat.o(68386);
        } else {
            if (activity instanceof WalletBalanceFetchResultUI) {
                b(activity, bundle);
            }
            AppMethodBeat.o(68386);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(68387);
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i2);
            AppMethodBeat.o(68387);
        } else if (activity instanceof WalletBalanceResultUI) {
            z.hhs();
            b(activity, this.dQL);
            AppMethodBeat.o(68387);
        } else {
            z.hhs();
            P(activity);
            AppMethodBeat.o(68387);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(68388);
        if (this.dQL.getInt("key_balance_fetch_scene", 0) == 0) {
            a(activity, WalletBalanceManagerUI.class, -1, true);
            AppMethodBeat.o(68388);
            return;
        }
        a(activity, WalletBalanceFetchUI.class, -1, false);
        AppMethodBeat.o(68388);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(68389);
        if (mMActivity instanceof WalletBalanceFetchUI) {
            AnonymousClass1 r0 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.balance.b.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean A(Object... objArr) {
                    String str;
                    AppMethodBeat.i(68371);
                    Bundle bundle = b.this.dQL;
                    s.fOg();
                    bundle.putParcelable("key_history_bankcard", s.fOh().IbL);
                    PayInfo payInfo = (PayInfo) b.this.dQL.get("key_pay_info");
                    i iVar = this.Ruz;
                    if (payInfo == null) {
                        str = null;
                    } else {
                        str = payInfo.dDL;
                    }
                    iVar.b(new aa(str), true);
                    AppMethodBeat.o(68371);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(68372);
                    b.this.a(this.activity, 0, b.this.dQL);
                    AppMethodBeat.o(68372);
                    return true;
                }
            };
            AppMethodBeat.o(68389);
            return r0;
        } else if (mMActivity instanceof WalletBalanceFetchPwdInputUI) {
            AnonymousClass2 r02 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.balance.b.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    boolean z = false;
                    AppMethodBeat.i(68373);
                    if (i2 == 0 && i3 == 0 && (qVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
                        com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) qVar;
                        b.this.dQL.putString("kreq_token", bVar.getToken());
                        b.this.dQL.putParcelable("key_authen", bVar.HFI);
                        Bundle bundle = b.this.dQL;
                        if (!bVar.HFG) {
                            z = true;
                        }
                        bundle.putBoolean("key_need_verify_sms", z);
                        RealnameGuideHelper realnameGuideHelper = bVar.AJr;
                        if (realnameGuideHelper != null) {
                            b.this.dQL.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                        }
                        if (bVar.HFP != null) {
                            b.this.dQL.putString("key_fetch_result_show_info", bVar.HFP.toString());
                        }
                        a.l(this.activity, b.this.dQL);
                        this.activity.finish();
                        AppMethodBeat.o(68373);
                        return true;
                    }
                    AppMethodBeat.o(68373);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(68374);
                    Bankcard bankcard = (Bankcard) b.this.dQL.getParcelable("key_bankcard");
                    b.this.dQL.putString("key_pwd1", (String) objArr[0]);
                    b.this.dQL.putString("key_mobile", bankcard.field_mobile);
                    Authen authen = new Authen();
                    authen.cSx = 3;
                    authen.HUO = (String) objArr[0];
                    authen.ANo = bankcard.field_bindSerial;
                    authen.dDj = bankcard.field_bankcardType;
                    authen.BDB = (PayInfo) b.this.dQL.getParcelable("key_pay_info");
                    authen.HUU = bankcard.field_arrive_type;
                    this.Ruz.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, (Orders) b.this.dQL.getParcelable("key_orders")), true, 1);
                    AppMethodBeat.o(68374);
                    return true;
                }
            };
            AppMethodBeat.o(68389);
            return r02;
        } else if (mMActivity instanceof WalletCardElementUI) {
            AnonymousClass3 r03 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.balance.b.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(68375);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                            com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) qVar;
                            b.this.dQL.putString("kreq_token", bVar.getToken());
                            if (bVar.isPaySuccess) {
                                b.this.dQL.putParcelable("key_orders", bVar.HFH);
                            }
                        }
                        if (b.this.c(this.activity, (Bundle) null)) {
                            this.Ruz.a(new ad(b.o(b.this), 13), true, 1);
                            AppMethodBeat.o(68375);
                            return true;
                        }
                        b.this.a(this.activity, 0, b.this.dQL);
                        AppMethodBeat.o(68375);
                        return true;
                    }
                    AppMethodBeat.o(68375);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(68376);
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    switch (b.this.dQL.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (b.this.fTp()) {
                                authen.cSx = 4;
                                break;
                            } else {
                                authen.cSx = 1;
                                break;
                            }
                        case 2:
                            if (b.this.fTp()) {
                                authen.cSx = 5;
                                break;
                            } else {
                                authen.cSx = 2;
                                break;
                            }
                        case 3:
                            if (b.this.fTp()) {
                                authen.cSx = 6;
                                break;
                            } else {
                                authen.cSx = 3;
                                break;
                            }
                        default:
                            AppMethodBeat.o(68376);
                            return false;
                    }
                    b.this.dQL.putParcelable("key_authen", authen);
                    this.Ruz.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                    AppMethodBeat.o(68376);
                    return true;
                }
            };
            AppMethodBeat.o(68389);
            return r03;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            AnonymousClass4 r04 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.balance.b.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(68377);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.g) {
                            com.tencent.mm.plugin.wallet.pay.a.d.g gVar = (com.tencent.mm.plugin.wallet.pay.a.d.g) qVar;
                            if (gVar.isPaySuccess) {
                                b.this.dQL.putParcelable("key_orders", gVar.HFH);
                            }
                            a.l(this.activity, b.this.dQL);
                            AppMethodBeat.o(68377);
                            return true;
                        } else if (qVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                            com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) qVar;
                            RealnameGuideHelper realnameGuideHelper = bVar.AJr;
                            if (realnameGuideHelper != null) {
                                b.this.dQL.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                            }
                            b.this.dQL.putString("kreq_token", bVar.getToken());
                            AppMethodBeat.o(68377);
                            return true;
                        }
                    }
                    AppMethodBeat.o(68377);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(68378);
                    v vVar = (v) objArr[1];
                    if (!(vVar == null || vVar.BDB == null)) {
                        vVar.BDB.dVv = 21;
                    }
                    Orders orders = (Orders) b.this.dQL.getParcelable("key_orders");
                    switch (b.this.dQL.getInt("key_pay_flag", 0)) {
                        case 1:
                            vVar.flag = "1";
                            break;
                        case 2:
                            if (b.this.fTp()) {
                                vVar.flag = "5";
                                break;
                            } else {
                                vVar.flag = "2";
                                break;
                            }
                        case 3:
                            if (b.this.fTp()) {
                                vVar.flag = "6";
                                break;
                            } else {
                                vVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                                break;
                            }
                        default:
                            AppMethodBeat.o(68378);
                            return false;
                    }
                    this.Ruz.a(new com.tencent.mm.plugin.wallet.pay.a.d.g(vVar, orders), true, 1);
                    AppMethodBeat.o(68378);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean B(Object... objArr) {
                    AppMethodBeat.i(68379);
                    this.Ruz.a(new com.tencent.mm.plugin.wallet.pay.a.a.b((Authen) b.this.dQL.getParcelable("key_authen"), (Orders) b.this.dQL.getParcelable("key_orders")), true, 1);
                    AppMethodBeat.o(68379);
                    return true;
                }
            };
            AppMethodBeat.o(68389);
            return r04;
        } else if (mMActivity instanceof WalletBalanceFetchResultUI) {
            AnonymousClass5 r05 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.balance.b.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean A(Object... objArr) {
                    AppMethodBeat.i(68380);
                    t.fQI().Hwc.HVC -= ((Orders) b.this.dQL.getParcelable("key_orders")).dDO;
                    b.this.dQL.putInt("key_balance_result_logo", R.raw.remittance_wait);
                    boolean A = super.A(objArr);
                    AppMethodBeat.o(68380);
                    return A;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    return false;
                }

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(68381);
                    switch (i2) {
                        case 0:
                            String string = this.activity.getString(R.string.i72);
                            AppMethodBeat.o(68381);
                            return string;
                        case 1:
                            Orders orders = (Orders) b.this.dQL.getParcelable("key_orders");
                            if (orders == null || Util.isNullOrNil(orders.HYX)) {
                                String string2 = this.activity.getString(R.string.i6z);
                                AppMethodBeat.o(68381);
                                return string2;
                            }
                            String str = orders.HYX;
                            AppMethodBeat.o(68381);
                            return str;
                        case 2:
                            Orders orders2 = (Orders) b.this.dQL.getParcelable("key_orders");
                            if (orders2 != null && orders2.HYW > 0) {
                                String format = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS).format(new Date(orders2.HYW));
                                AppMethodBeat.o(68381);
                                return format;
                            }
                    }
                    CharSequence tips = super.getTips(i2);
                    AppMethodBeat.o(68381);
                    return tips;
                }
            };
            AppMethodBeat.o(68389);
            return r05;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            AnonymousClass6 r06 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.balance.b.AnonymousClass6 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(68382);
                    if (i2 == 0 && i3 == 0 && (qVar instanceof j)) {
                        j jVar = (j) qVar;
                        if (jVar.isPaySuccess) {
                            b.this.dQL.putParcelable("key_orders", jVar.HFH);
                        }
                        b.this.a(this.activity, 0, b.this.dQL);
                        AppMethodBeat.o(68382);
                        return true;
                    }
                    AppMethodBeat.o(68382);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(68383);
                    this.Ruz.a(new j((v) objArr[0], (Orders) b.this.dQL.getParcelable("key_orders")), true, 1);
                    AppMethodBeat.o(68383);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final /* synthetic */ CharSequence getTips(int i2) {
                    AppMethodBeat.i(68384);
                    String string = this.activity.getString(R.string.isr);
                    AppMethodBeat.o(68384);
                    return string;
                }
            };
            AppMethodBeat.o(68389);
            return r06;
        } else {
            g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(68389);
            return a2;
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final int a(MMActivity mMActivity, int i2) {
        return R.string.i6a;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "BalanceFetchProcess";
    }

    static /* synthetic */ String o(b bVar) {
        PayInfo payInfo;
        AppMethodBeat.i(68390);
        if (bVar.dQL == null || (payInfo = (PayInfo) bVar.dQL.getParcelable("key_pay_info")) == null) {
            AppMethodBeat.o(68390);
            return "";
        }
        String str = payInfo.dDL;
        AppMethodBeat.o(68390);
        return str;
    }
}
