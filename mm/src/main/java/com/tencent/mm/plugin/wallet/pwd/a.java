package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pwd.a.j;
import com.tencent.mm.plugin.wallet.pwd.a.o;
import com.tencent.mm.plugin.wallet.pwd.a.p;
import com.tencent.mm.plugin.wallet.pwd.a.r;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdBindNewUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class a extends com.tencent.mm.plugin.wallet_core.b.a {
    public AbstractC1905a HHO;
    private p HHP;

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.a$a  reason: collision with other inner class name */
    public interface AbstractC1905a {
        void run(int i2);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69493);
        Log.d("MicroMsg.ProcessManager", "start Process : ForgotPwdProcess");
        Bundle bundle2 = this.dQL;
        s.fOg();
        bundle2.putBoolean("key_is_oversea", !s.fOh().fRt());
        Bundle bundle3 = this.dQL;
        s.fOg();
        bundle3.putInt("key_support_bankcard", s.fOh().fRt() ? 1 : 2);
        this.dQL.putBoolean("key_is_forgot_process", true);
        boolean z = bundle.getBoolean("isFromKinda");
        boolean z2 = bundle.getBoolean("isDomesticUser");
        s.fOg();
        if (s.fOh().fRt() || (z && z2)) {
            b(activity, WalletForgotPwdVerifyIdUI.class, bundle);
        } else {
            b(activity, WalletForgotPwdUI.class, bundle);
        }
        AppMethodBeat.o(69493);
        return this;
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(69494);
        if (activity instanceof WalletForgotPwdUI) {
            if (!bundle.containsKey("key_is_force_bind") || !bundle.getBoolean("key_is_force_bind")) {
                b(activity, WalletCardElementUI.class, bundle);
                AppMethodBeat.o(69494);
                return;
            }
            b(activity, WalletForgotPwdBindNewUI.class, bundle);
            AppMethodBeat.o(69494);
        } else if (activity instanceof WalletCardElementUI) {
            if (!fTp()) {
                b(activity, WalletVerifyCodeUI.class, bundle);
                AppMethodBeat.o(69494);
                return;
            }
            b(activity, WalletSetPasswordUI.class, bundle);
            AppMethodBeat.o(69494);
        } else if (activity instanceof WalletVerifyCodeUI) {
            b(activity, WalletSetPasswordUI.class, bundle);
            AppMethodBeat.o(69494);
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.o(69494);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, bundle);
            AppMethodBeat.o(69494);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            K("startActivity2", activity, WalletCardElementUI.class, bundle, "flag: 67108864");
            Intent intent = new Intent(activity, WalletCardElementUI.class);
            intent.putExtra("process_id", getClass().hashCode());
            intent.addFlags(67108864);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (bundle != null) {
                this.dQL.putAll(bundle);
            }
            Log.d("MicroMsg.ProcessManager", "bankcard tag :" + hgI());
            AppMethodBeat.o(69494);
        } else if (!(activity instanceof WalletForgotPwdVerifyIdUI)) {
            if (activity instanceof WalletForgotPwdSelectUI) {
                if (!bundle.containsKey("key_select_bank_card") || !bundle.getBoolean("key_select_bank_card")) {
                    Log.i("MicroMsg.ProcessManager", "forward after face check");
                    b(activity, WalletSetPasswordUI.class, bundle);
                } else {
                    Log.i("MicroMsg.ProcessManager", "forward select bankcard");
                    b(activity, WalletForgotPwdUI.class, bundle);
                    AppMethodBeat.o(69494);
                    return;
                }
            }
            AppMethodBeat.o(69494);
        } else if (!bundle.containsKey("key_is_support_face") || bundle.getInt("key_is_support_face") != 1) {
            Log.i("MicroMsg.ProcessManager", "forward not support face");
            b(activity, WalletForgotPwdUI.class, bundle);
            AppMethodBeat.o(69494);
        } else {
            Log.i("MicroMsg.ProcessManager", "forward support face");
            h.INSTANCE.a(15774, Integer.valueOf(this.dQL.getInt("key_forgot_scene", 1)), 1);
            b(activity, WalletForgotPwdSelectUI.class, bundle);
            AppMethodBeat.o(69494);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69495);
        s.fOg();
        if (s.fOh().fRt()) {
            a(activity, WalletForgotPwdVerifyIdUI.class, -1, false);
            if (this.HHO != null) {
                this.HHO.run(0);
                AppMethodBeat.o(69495);
                return;
            }
        } else {
            a(activity, WalletForgotPwdUI.class, -1, false);
            if (this.HHO != null) {
                this.HHO.run(-1);
            }
        }
        AppMethodBeat.o(69495);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(69496);
        if (mMActivity instanceof WalletForgotPwdUI) {
            AnonymousClass1 r0 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pwd.a.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69483);
                    if (i2 == 0 && i3 == 0 && (qVar instanceof ad)) {
                        am fRN = t.fQD().fRN();
                        Log.i("MicroMsg.ProcessManager", "hy: reset_pwd_flag: %s, find_pwd_url: %s", fRN.field_reset_passwd_flag, fRN.field_find_passwd_url);
                        String fRx = t.fQI().fRx();
                        if (!Util.isNullOrNil(fRx)) {
                            Log.i("MicroMsg.ProcessManager", "jump to forget url: %s", fRx);
                            f.p(this.activity, fRx, false);
                            AppMethodBeat.o(69483);
                            return true;
                        }
                    }
                    AppMethodBeat.o(69483);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.o(69496);
            return r0;
        } else if (mMActivity instanceof WalletForgotPwdVerifyIdUI) {
            AnonymousClass2 r02 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pwd.a.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69484);
                    if (objArr.length == 3) {
                        this.Ruz.b(new com.tencent.mm.plugin.wallet.pwd.a.t(objArr[0].toString(), ((Integer) objArr[1]).intValue(), (String) objArr[2]), true);
                    }
                    AppMethodBeat.o(69484);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    return false;
                }
            };
            AppMethodBeat.o(69496);
            return r02;
        } else if (mMActivity instanceof WalletCardElementUI) {
            AnonymousClass3 r03 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pwd.a.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69485);
                    if (i2 == 0 && i3 == 0 && (qVar instanceof p)) {
                        p pVar = (p) qVar;
                        a.this.dQL.putString("kreq_token", pVar.getToken());
                        a.this.HHP = pVar;
                        if (!pVar.HFE) {
                            a.this.a(this.activity, 0, a.this.dQL);
                        }
                        AppMethodBeat.o(69485);
                        return true;
                    }
                    AppMethodBeat.o(69485);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    int i2;
                    AppMethodBeat.i(69486);
                    Authen authen = (Authen) objArr[0];
                    if (!a.this.fTp()) {
                        authen.cSx = 1;
                    } else {
                        authen.cSx = 4;
                    }
                    if (a.this.dQL.getBoolean("key_is_paymanager")) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    this.Ruz.a(new p(authen, a.this.dQL.getBoolean("key_is_reset_with_new_card", false), i2), true, 1);
                    AppMethodBeat.o(69486);
                    return true;
                }
            };
            AppMethodBeat.o(69496);
            return r03;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            AnonymousClass4 r04 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pwd.a.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69487);
                    if (i2 == 0 && i3 == 0 && (qVar instanceof p)) {
                        a.this.dQL.putString("kreq_token", ((p) qVar).getToken());
                        AppMethodBeat.o(69487);
                        return true;
                    }
                    AppMethodBeat.o(69487);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean B(Object... objArr) {
                    AppMethodBeat.i(214058);
                    if (a.this.HHP != null) {
                        a.this.HHP.resend();
                        this.Ruz.b(a.this.HHP, false);
                    }
                    AppMethodBeat.o(214058);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69488);
                    v vVar = (v) objArr[1];
                    vVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                    this.Ruz.a(new r(vVar), true, 1);
                    AppMethodBeat.o(69488);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(69489);
                    String string = this.activity.getString(R.string.itp);
                    AppMethodBeat.o(69489);
                    return string;
                }
            };
            AppMethodBeat.o(69496);
            return r04;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            AnonymousClass5 r05 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pwd.a.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69490);
                    if (i2 == 0 && i3 == 0 && ((qVar instanceof o) || (qVar instanceof j))) {
                        a.this.a(this.activity, 0, a.this.dQL);
                        AppMethodBeat.o(69490);
                        return true;
                    }
                    AppMethodBeat.o(69490);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69491);
                    v vVar = (v) objArr[0];
                    if (a.this.dQL.getBoolean("key_is_set_pwd_after_face_action")) {
                        Log.i("MicroMsg.ProcessManager", "WalletPwdConfirmUI controller onNext, after face verify, reset pwd by face");
                        this.Ruz.a(new j(a.this.dQL.getString("key_face_action_result_token"), vVar.kdF), true, 1);
                    } else {
                        Log.i("MicroMsg.ProcessManager", "WalletPwdConfirmUI controller onNext, not after face verify, reset pwd normal");
                        this.Ruz.a(new o(vVar), true, 1);
                    }
                    AppMethodBeat.o(69491);
                    return true;
                }
            };
            AppMethodBeat.o(69496);
            return r05;
        } else {
            g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(69496);
            return a2;
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return activity instanceof WalletPwdConfirmUI;
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final boolean a(final WalletBaseUI walletBaseUI, int i2, String str) {
        AppMethodBeat.i(69497);
        switch (i2) {
            case 404:
                com.tencent.mm.ui.base.h.a((Context) walletBaseUI, str, (String) null, walletBaseUI.getString(R.string.id1), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.pwd.a.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(69492);
                        a.this.b(walletBaseUI, a.this.dQL);
                        if (walletBaseUI.isTransparent()) {
                            walletBaseUI.finish();
                        }
                        walletBaseUI.clearErr();
                        AppMethodBeat.o(69492);
                    }
                });
                AppMethodBeat.o(69497);
                return true;
            default:
                AppMethodBeat.o(69497);
                return false;
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final int a(MMActivity mMActivity, int i2) {
        return R.string.id1;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "ForgotPwdProcess";
    }
}
