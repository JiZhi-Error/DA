package com.tencent.mm.plugin.wallet_core.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.m;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class b extends a {
    public a HPw;

    public interface a {
        void run(int i2);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69875);
        K("start", activity, bundle);
        Log.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
        if (bundle != null) {
            ab.mg(6, bundle.getInt("key_bind_scene"));
            z.aqh(bundle.getInt("key_bind_scene"));
        } else {
            ab.mg(6, 0);
            z.aqh(0);
        }
        if (t.fQI().fRk()) {
            boolean z = bundle.getBoolean("key_bind_card_can_pass_pwd", false);
            String string = bundle.getString("key_bind_card_user_token", null);
            if (!z || Util.isNullOrNil(string)) {
                b(activity, WalletCheckPwdUI.class, bundle);
            } else {
                b(activity, WalletBankcardIdUI.class, bundle);
            }
            AppMethodBeat.o(69875);
            return this;
        }
        if (bundle != null) {
            f.jV(bundle.getInt("key_bind_scene", 0), 1);
        }
        if (bundle == null || !bundle.getBoolean("key_is_import_bind", false)) {
            d a2 = super.a(activity, bundle);
            AppMethodBeat.o(69875);
            return a2;
        }
        b(activity, WalletCardImportUI.class, bundle);
        AppMethodBeat.o(69875);
        return this;
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(69876);
        K("forward", activity, Integer.valueOf(i2), bundle);
        Log.i("MicroMsg.BindCardProcess", "forward Process : BindCardProcess");
        if (activity instanceof WalletCheckPwdUI) {
            if (bundle.getBoolean("key_is_import_bind", false)) {
                b(activity, WalletCardImportUI.class, bundle);
                AppMethodBeat.o(69876);
                return;
            }
            b(activity, WalletBankcardIdUI.class, bundle);
            AppMethodBeat.o(69876);
        } else if ((activity instanceof WalletCardElementUI) || (activity instanceof WalletCardImportUI)) {
            if (!fTp()) {
                Log.i("MicroMsg.BindCardProcess", "is domestic bankcard! need verify code!");
                b(activity, WalletVerifyCodeUI.class, bundle);
                AppMethodBeat.o(69876);
            } else if (!t.fQI().fRk()) {
                Log.i("MicroMsg.BindCardProcess", "wallet is not register, start WalletSetPasswordUI!");
                b(activity, WalletSetPasswordUI.class, bundle);
                AppMethodBeat.o(69876);
            } else {
                Log.i("MicroMsg.BindCardProcess", "bind bank card success!!");
                bundle.putBoolean("intent_bind_end", true);
                h.cD(activity, activity.getString(R.string.i7l));
                b(activity, bundle);
                AppMethodBeat.o(69876);
            }
        } else if ((activity instanceof WalletVerifyCodeUI) && t.fQI().fRk()) {
            Log.i("MicroMsg.BindCardProcess", "end process after verify!");
            int i3 = this.dQL.getInt("key_bind_scene", -1);
            BindCardOrder bindCardOrder = (BindCardOrder) this.dQL.getParcelable("key_bindcard_value_result");
            if (bindCardOrder == null || i3 != 15) {
                bundle.putBoolean("intent_bind_end", true);
                h.cD(activity, activity.getString(R.string.i7l));
                b(activity, bundle);
                AppMethodBeat.o(69876);
                return;
            }
            String string = this.dQL.getString("key_bind_card_type");
            String string2 = this.dQL.getString("key_bind_card_show1");
            String string3 = this.dQL.getString("key_bind_card_show2");
            int i4 = this.dQL.getInt("key_bind_scene");
            int i5 = this.dQL.getInt("realname_scene");
            Log.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", string, string2, Integer.valueOf(i4), Integer.valueOf(i5));
            bindCardOrder.dDj = string;
            bindCardOrder.HWv = string2;
            bindCardOrder.HWw = string3;
            bindCardOrder.HWy = i4;
            bindCardOrder.HWz = i5;
            b(activity, WalletBindCardResultUI.class, bundle);
            AppMethodBeat.o(69876);
        } else if (activity instanceof WalletPwdConfirmUI) {
            Log.i("MicroMsg.BindCardProcess", "end process after confirm pwd!");
            f.jV(this.dQL.getInt("key_bind_scene", 0), 7);
            bundle.putBoolean("intent_bind_end", true);
            h.cD(activity, activity.getString(R.string.i7l));
            BindCardOrder bindCardOrder2 = (BindCardOrder) this.dQL.getParcelable("key_bindcard_value_result");
            int i6 = this.dQL.getInt("key_bind_scene", -1);
            if (bindCardOrder2 == null || i6 != 15) {
                b(activity, bundle);
                AppMethodBeat.o(69876);
                return;
            }
            String string4 = this.dQL.getString("key_bind_card_type");
            String string5 = this.dQL.getString("key_bind_card_show1");
            String string6 = this.dQL.getString("key_bind_card_show2");
            int i7 = this.dQL.getInt("key_bind_scene");
            int i8 = this.dQL.getInt("realname_scene");
            Log.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", string4, string5, Integer.valueOf(i7), Integer.valueOf(i8));
            bindCardOrder2.dDj = string4;
            bindCardOrder2.HWv = string5;
            bindCardOrder2.HWw = string6;
            bindCardOrder2.HWy = i7;
            bindCardOrder2.HWz = i8;
            b(activity, WalletBindCardResultUI.class, bundle);
            AppMethodBeat.o(69876);
        } else if (activity instanceof WalletBindCardResultUI) {
            b(activity, bundle);
            AppMethodBeat.o(69876);
        } else {
            Log.i("MicroMsg.BindCardProcess", "super forward!");
            super.a(activity, 0, bundle);
            AppMethodBeat.o(69876);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(69877);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 r0 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_core.b.b.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(69865);
                    switch (i2) {
                        case 0:
                            String string = this.activity.getString(R.string.ib3);
                            AppMethodBeat.o(69865);
                            return string;
                        case 1:
                            String string2 = this.activity.getString(R.string.idq);
                            AppMethodBeat.o(69865);
                            return string2;
                        default:
                            CharSequence tips = super.getTips(i2);
                            AppMethodBeat.o(69865);
                            return tips;
                    }
                }
            };
            AppMethodBeat.o(69877);
            return r0;
        } else if ((mMActivity instanceof WalletCardElementUI) || (mMActivity instanceof WalletCardImportUI)) {
            AnonymousClass2 r02 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_core.b.b.AnonymousClass2 */
                Authen HFI;

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69868);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof com.tencent.mm.plugin.wallet_core.b.a.a) {
                            com.tencent.mm.plugin.wallet_core.b.a.a aVar = (com.tencent.mm.plugin.wallet_core.b.a.a) qVar;
                            if (aVar.HPz == null) {
                                b.this.dQL.putString("kreq_token", aVar.getToken());
                                if (b.this.c(this.activity, b.this.dQL)) {
                                    Log.i("MicroMsg.BindCardProcess", "need update bankcardlist");
                                    this.Ruz.b(new ad(null, 12), false);
                                } else {
                                    Log.i("MicroMsg.BindCardProcess", "not need update bankcardlist");
                                    b.this.a(this.activity, 0, b.this.dQL);
                                }
                            } else {
                                Log.i("MicroMsg.BindCardProcess", "NetSceneTenpayBindBankcard show juveniles dialog");
                                h.c(this.activity, aVar.HPz.dQx, "", aVar.HPz.IaV, aVar.HPz.IaU, new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.wallet_core.b.b.AnonymousClass2.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(69866);
                                        Log.i("MicroMsg.BindCardProcess", "NetSceneTenpayBindBankcard dialog lOk");
                                        AnonymousClass2.this.Ruz.a(new com.tencent.mm.plugin.wallet_core.b.a.a(AnonymousClass2.this.HFI, "1", ""), true, 1);
                                        u.xV(1);
                                        AppMethodBeat.o(69866);
                                    }
                                }, new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.wallet_core.b.b.AnonymousClass2.AnonymousClass2 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(69867);
                                        Log.i("MicroMsg.BindCardProcess", "NetSceneTenpayBindBankcard dialog lCancel");
                                        u.xV(0);
                                        AppMethodBeat.o(69867);
                                    }
                                });
                            }
                            AppMethodBeat.o(69868);
                            return true;
                        } else if (qVar instanceof ad) {
                            Log.i("MicroMsg.BindCardProcess", "update bankcardlist success!");
                            b.this.a(this.activity, 0, b.this.dQL);
                            AppMethodBeat.o(69868);
                            return true;
                        }
                    }
                    AppMethodBeat.o(69868);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69869);
                    b.this.K("onNext", objArr);
                    Log.i("MicroMsg.BindCardProcess", "onNext, do bind bank card!");
                    this.HFI = (Authen) objArr[0];
                    this.HFI.cSx = b.this.fPO();
                    this.Ruz.a(new com.tencent.mm.plugin.wallet_core.b.a.a(this.HFI, "", ""), true, 1);
                    AppMethodBeat.o(69869);
                    return true;
                }
            };
            AppMethodBeat.o(69877);
            return r02;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            AnonymousClass3 r03 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_core.b.b.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69870);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof com.tencent.mm.plugin.wallet_core.b.a.a) {
                            Log.i("MicroMsg.BindCardProcess", "verify code success!");
                            b.this.dQL.putString("kreq_token", ((com.tencent.mm.plugin.wallet_core.b.a.a) qVar).getToken());
                            AppMethodBeat.o(69870);
                            return true;
                        } else if (qVar instanceof v) {
                            b.this.a(this.Ruz);
                            if (((v) qVar).HPA != null) {
                                b.this.dQL.putParcelable("key_bindcard_value_result", ((v) qVar).HPA);
                            }
                        } else if (qVar instanceof m) {
                            AppMethodBeat.o(69870);
                            return true;
                        }
                    }
                    AppMethodBeat.o(69870);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69871);
                    b.this.K("WalletVerifyCodeUI onNext", objArr);
                    Log.i("MicroMsg.BindCardProcess", "onNext, do bind verify!");
                    com.tencent.mm.plugin.wallet_core.model.v vVar = (com.tencent.mm.plugin.wallet_core.model.v) objArr[1];
                    if (t.fQI().fRk()) {
                        vVar.flag = "2";
                    } else {
                        vVar.flag = "1";
                    }
                    if ("realname_verify_process".equals(b.this.dKC())) {
                        this.Ruz.a(new v(vVar, b.this.dQL.getInt("entry_scene", -1), b.this.dQL.getString("key_realname_sessionid")), true, 1);
                    } else {
                        this.Ruz.a(new v(vVar), true, 1);
                    }
                    AppMethodBeat.o(69871);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(69872);
                    String string = this.activity.getString(R.string.ith);
                    AppMethodBeat.o(69872);
                    return string;
                }
            };
            AppMethodBeat.o(69877);
            return r03;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            AnonymousClass4 r04 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_core.b.b.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69873);
                    if (qVar instanceof com.tencent.mm.plugin.wallet_core.b.a.b) {
                        b.this.a(this.Ruz);
                        if (((com.tencent.mm.plugin.wallet_core.b.a.b) qVar).HPA != null) {
                            b.this.dQL.putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.b.a.b) qVar).HPA);
                        }
                    } else if (qVar instanceof m) {
                        AppMethodBeat.o(69873);
                        return true;
                    }
                    AppMethodBeat.o(69873);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69874);
                    com.tencent.mm.plugin.wallet_core.model.v vVar = (com.tencent.mm.plugin.wallet_core.model.v) objArr[0];
                    b.this.dQL.getString("verify_card_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    if ("realname_verify_process".equals(b.this.dKC())) {
                        this.Ruz.b(new com.tencent.mm.plugin.wallet_core.b.a.b(vVar, b.this.dQL.getInt("entry_scene", -1), b.this.dQL.getString("key_realname_sessionid"), (RealNameBundle) b.this.dQL.getParcelable("realname_verify_process_bundle")), true);
                    } else {
                        this.Ruz.b(new com.tencent.mm.plugin.wallet_core.b.a.b(vVar), true);
                    }
                    AppMethodBeat.o(69874);
                    return false;
                }
            };
            AppMethodBeat.o(69877);
            return r04;
        } else {
            g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(69877);
            return a2;
        }
    }

    public final void a(i iVar) {
        AppMethodBeat.i(69878);
        Log.d("MicroMsg.BindCardProcess", "do set user exinfo");
        iVar.a(new m(this.dQL.getString("key_country_code", ""), this.dQL.getString("key_province_code", ""), this.dQL.getString("key_city_code", ""), (Profession) this.dQL.getParcelable("key_profession"), this.dQL.getString("key_country_iso")), false, 1);
        AppMethodBeat.o(69878);
    }

    @Override // com.tencent.mm.wallet_core.d
    public void b(Activity activity, Bundle bundle) {
        Class<?> cls;
        int i2 = -1;
        AppMethodBeat.i(69879);
        K("end", activity, bundle);
        Log.i("MicroMsg.BindCardProcess", "end Process : BindCardProcess");
        z.hhs();
        hgM();
        boolean z = bundle.getBoolean("intent_bind_end", false);
        Bundle bundle2 = this.dQL;
        if (bundle2 != null && bundle2.getBoolean("is_from_new_cashier", false)) {
            try {
                cls = Class.forName(bundle2.getString("start_activity_class", ""));
            } catch (Exception e2) {
                cls = null;
            }
            if (cls != null) {
                c(activity, cls);
                if (this.HPw != null) {
                    a aVar = this.HPw;
                    if (!z) {
                        i2 = 0;
                    }
                    aVar.run(i2);
                }
                AppMethodBeat.o(69879);
                return;
            }
        }
        if (bundle == null || !bundle.getBoolean("key_need_bind_response", false)) {
            e(activity, "wallet", ".bind.ui.WalletBankcardManageUI");
            AppMethodBeat.o(69879);
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        a(activity, "wallet", ".bind.ui.WalletBindUI", -1, intent, false);
        AppMethodBeat.o(69879);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public boolean c(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69880);
        if (!t.fQI().fRk()) {
            boolean z = activity instanceof WalletPwdConfirmUI;
            AppMethodBeat.o(69880);
            return z;
        } else if ((activity instanceof WalletCardElementUI) && fTp()) {
            AppMethodBeat.o(69880);
            return true;
        } else if (activity instanceof WalletVerifyCodeUI) {
            AppMethodBeat.o(69880);
            return true;
        } else {
            AppMethodBeat.o(69880);
            return false;
        }
    }

    public final int fPO() {
        AppMethodBeat.i(69881);
        if (!fTp()) {
            if (t.fQI().fRk()) {
                AppMethodBeat.o(69881);
                return 2;
            }
            AppMethodBeat.o(69881);
            return 1;
        } else if (t.fQI().fRk()) {
            AppMethodBeat.o(69881);
            return 5;
        } else {
            AppMethodBeat.o(69881);
            return 4;
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public String dKC() {
        return "BindCardProcess";
    }
}
