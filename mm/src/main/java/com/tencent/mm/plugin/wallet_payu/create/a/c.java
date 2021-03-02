package com.tencent.mm.plugin.wallet_payu.create.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUVerifyCodeUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.f;

public class c extends d {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72022);
        Log.d("MicroMsg.PayUOpenProcess", "hy: start process PayUOpenProcess");
        s.fOg();
        String bbI = s.bbI();
        s.fOg();
        String fOi = s.fOi();
        if (bundle != null) {
            bundle.putString("key_mobile", bbI);
            bundle.putString("dial_code", fOi);
        }
        b(activity, WalletPayUStartOpenUI.class, bundle);
        AppMethodBeat.o(72022);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(72023);
        if (activity instanceof WalletPayUStartOpenUI) {
            b(activity, WalletPayUVerifyCodeUI.class, bundle);
        }
        if (activity instanceof WalletPayUVerifyCodeUI) {
            if (!bundle.getBoolean("key_is_has_mobile")) {
                b(activity, WalletPayUSecurityQuestionSettingUI.class, bundle);
            } else {
                b(activity, WalletPayUSecurityQuestionAnswerUI.class, bundle);
            }
        }
        if (activity instanceof WalletPayUSecurityQuestionSettingUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
        }
        if (activity instanceof WalletPayUSetPasswordUI) {
            b(activity, WalletPayUPwdConfirmUI.class, bundle);
        }
        if (activity instanceof WalletPayUSecurityQuestionAnswerUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
        }
        AppMethodBeat.o(72023);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(72024);
        if (activity instanceof WalletPayUPwdConfirmUI) {
            a(activity, WalletPayUSetPasswordUI.class, i2);
            AppMethodBeat.o(72024);
            return;
        }
        b(activity, this.dQL);
        AppMethodBeat.o(72024);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean j(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72025);
        bundle.putInt("key_open_error_code", 1);
        u.makeText(activity, activity.getString(R.string.ioo), 0).show();
        b(activity, bundle);
        AppMethodBeat.o(72025);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72026);
        if (bundle.getInt("key_open_error_code", -1) == 0) {
            Log.i("MicroMsg.PayUOpenProcess", "hy: user open success");
            boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_walletv2_open_config, true);
            Log.i("MicroMsg.PayUOpenProcess", " walletMallV2 switch is ：%s", Boolean.valueOf(a2));
            if (a2) {
                e(activity, "mall", ".ui.MallIndexUIv2");
                AppMethodBeat.o(72026);
                return;
            }
            e(activity, "mall", ".ui.MallIndexUI");
            AppMethodBeat.o(72026);
            return;
        }
        Log.i("MicroMsg.PayUOpenProcess", "hy: user interrupted the process. go to preference");
        super.bA(activity);
        f.kR(activity);
        AppMethodBeat.o(72026);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final int a(MMActivity mMActivity, int i2) {
        AppMethodBeat.i(72027);
        if (i2 == 1) {
            AppMethodBeat.o(72027);
            return R.string.iod;
        }
        int a2 = super.a(mMActivity, i2);
        AppMethodBeat.o(72027);
        return a2;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(72028);
        if (mMActivity instanceof WalletPayUStartOpenUI) {
            AnonymousClass1 r0 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_payu.create.a.c.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72012);
                    if (qVar instanceof com.tencent.mm.plugin.wallet_payu.a.b) {
                        Log.d("MicroMsg.PayUOpenProcess", "hy: scene gen otp, errCode %d, errType %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 == 0 && i3 == 0) {
                            com.tencent.mm.plugin.wallet_payu.a.b bVar = (com.tencent.mm.plugin.wallet_payu.a.b) qVar;
                            c.this.dQL.putString("payu_reference", bVar.dRM);
                            Log.d("MicroMsg.PayUOpenProcess", "hy: session: %s", bVar.dRM);
                            c.this.dQL.putBoolean("key_is_has_mobile", bVar.Ity);
                            a.l(this.activity, c.this.dQL);
                            AppMethodBeat.o(72012);
                            return true;
                        }
                    }
                    AppMethodBeat.o(72012);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72013);
                    this.Ruz.b(new com.tencent.mm.plugin.wallet_payu.a.b(c.this.dQL.getString("dial_code"), c.this.dQL.getString("key_mobile")), true);
                    AppMethodBeat.o(72013);
                    return false;
                }
            };
            AppMethodBeat.o(72028);
            return r0;
        } else if (mMActivity instanceof WalletPayUVerifyCodeUI) {
            AnonymousClass2 r02 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_payu.create.a.c.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean B(Object... objArr) {
                    AppMethodBeat.i(72014);
                    this.Ruz.a(new com.tencent.mm.plugin.wallet_payu.a.b(c.this.dQL.getString("dial_code"), c.this.dQL.getString("key_mobile")), true, 1);
                    AppMethodBeat.o(72014);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72015);
                    if (qVar instanceof com.tencent.mm.plugin.wallet_payu.a.a) {
                        com.tencent.mm.plugin.wallet_payu.a.a aVar = (com.tencent.mm.plugin.wallet_payu.a.a) qVar;
                        if (i2 == 0 && i3 == 0 && aVar.DcO) {
                            c.this.dQL.putString("payu_reference", aVar.Itx);
                            a.l(this.activity, c.this.dQL);
                            AppMethodBeat.o(72015);
                            return true;
                        }
                    } else if ((qVar instanceof com.tencent.mm.plugin.wallet_payu.a.b) && i2 == 0 && i3 == 0) {
                        c.this.dQL.putString("payu_reference", ((com.tencent.mm.plugin.wallet_payu.a.b) qVar).dRM);
                        AppMethodBeat.o(72015);
                        return true;
                    }
                    AppMethodBeat.o(72015);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72016);
                    this.Ruz.b(new com.tencent.mm.plugin.wallet_payu.a.a((String) objArr[0], c.this.dQL.getString("payu_reference")), true);
                    AppMethodBeat.o(72016);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(72017);
                    if (i2 == 0) {
                        String string = this.activity.getString(R.string.itj, new Object[]{f.bpt("+" + c.this.dQL.getString("dial_code") + c.this.dQL.getString("key_mobile"))});
                        AppMethodBeat.o(72017);
                        return string;
                    }
                    CharSequence tips = super.getTips(i2);
                    AppMethodBeat.o(72017);
                    return tips;
                }
            };
            AppMethodBeat.o(72028);
            return r02;
        } else if (mMActivity instanceof WalletPayUSecurityQuestionSettingUI) {
            AnonymousClass3 r03 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_payu.create.a.c.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean A(Object... objArr) {
                    AppMethodBeat.i(72018);
                    this.Ruz.b(new com.tencent.mm.plugin.wallet_payu.security_question.model.d(), true);
                    AppMethodBeat.o(72018);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72019);
                    if ((qVar instanceof com.tencent.mm.plugin.wallet_payu.security_question.model.d) && i2 == 0 && i3 == 0) {
                        c.this.dQL.putParcelableArrayList("key_security_question_list", ((com.tencent.mm.plugin.wallet_payu.security_question.model.d) qVar).IuJ);
                        AppMethodBeat.o(72019);
                        return true;
                    }
                    AppMethodBeat.o(72019);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.o(72028);
            return r03;
        } else if (mMActivity instanceof WalletPayUPwdConfirmUI) {
            AnonymousClass4 r04 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_payu.create.a.c.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72020);
                    if ((qVar instanceof a) && i2 == 0 && i3 == 0) {
                        Log.d("MicroMsg.PayUOpenProcess", "hy: create user success");
                        a.c(this.activity, c.this.dQL, 0);
                        c.this.dQL.putInt("key_open_error_code", 0);
                        u.makeText(this.activity, this.activity.getString(R.string.iou), 0).show();
                        AppMethodBeat.o(72020);
                        return true;
                    } else if ((qVar instanceof b) && i2 == 0 && i3 == 0) {
                        Log.d("MicroMsg.PayUOpenProcess", "hy: link user success");
                        a.c(this.activity, c.this.dQL, 0);
                        c.this.dQL.putInt("key_open_error_code", 0);
                        u.makeText(this.activity, this.activity.getString(R.string.iou), 0).show();
                        AppMethodBeat.o(72020);
                        return true;
                    } else {
                        AppMethodBeat.o(72020);
                        return false;
                    }
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72021);
                    String string = c.this.dQL.getString("dial_code");
                    String string2 = c.this.dQL.getString("key_mobile");
                    String str = ((v) objArr[0]).kdF;
                    String string3 = c.this.dQL.getString("key_question_id");
                    String string4 = c.this.dQL.getString("key_question_answer");
                    String string5 = c.this.dQL.getString("payu_reference");
                    if (!c.this.dQL.getBoolean("key_is_has_mobile")) {
                        this.Ruz.b(new a(string, string2, str, string3, string4, string5), true);
                    } else {
                        this.Ruz.b(new b(string, string2, str, string5), true);
                    }
                    AppMethodBeat.o(72021);
                    return true;
                }
            };
            AppMethodBeat.o(72028);
            return r04;
        } else if (mMActivity instanceof WalletPayUSecurityQuestionAnswerUI) {
            com.tencent.mm.plugin.wallet_payu.security_question.model.a aVar = new com.tencent.mm.plugin.wallet_payu.security_question.model.a(mMActivity, iVar, this.dQL);
            AppMethodBeat.o(72028);
            return aVar;
        } else {
            com.tencent.mm.wallet_core.d.g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(72028);
            return a2;
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "PayUOpenProcess";
    }
}
