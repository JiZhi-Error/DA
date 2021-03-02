package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletResetPwdAdapterUI;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class c extends d {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69516);
        Log.d("MicroMsg.ResetPwdProcessByToken", "start Process : ResetPwdProcessByToken");
        b(activity, WalletSetPasswordUI.class, bundle);
        AppMethodBeat.o(69516);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(69517);
        if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.o(69517);
            return;
        }
        if (activity instanceof WalletPwdConfirmUI) {
            b(activity, bundle);
        }
        AppMethodBeat.o(69517);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(69518);
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i2);
        }
        AppMethodBeat.o(69518);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69519);
        Intent intent = new Intent(activity, WalletResetPwdAdapterUI.class);
        intent.putExtra("RESET_PWD_USER_ACTION", bundle.getInt("RESET_PWD_USER_ACTION", 0));
        a(activity, WalletResetPwdAdapterUI.class, -1, intent, false);
        AppMethodBeat.o(69519);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(69520);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 r0 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pwd.c.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69510);
                    this.Ruz.a(new w((String) objArr[0], 3, (String) objArr[1]), true, 1);
                    AppMethodBeat.o(69510);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(69511);
                    switch (i2) {
                        case 0:
                            String string = this.activity.getString(R.string.ib0);
                            AppMethodBeat.o(69511);
                            return string;
                        case 1:
                            String string2 = this.activity.getString(R.string.imh);
                            AppMethodBeat.o(69511);
                            return string2;
                        default:
                            CharSequence tips = super.getTips(i2);
                            AppMethodBeat.o(69511);
                            return tips;
                    }
                }
            };
            AppMethodBeat.o(69520);
            return r0;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            AnonymousClass2 r02 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pwd.c.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69513);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof com.tencent.mm.plugin.wallet.pwd.a.q) {
                            c.this.dQL.putInt("RESET_PWD_USER_ACTION", 1);
                            c.this.a(this.activity, 0, c.this.dQL);
                            h.cD(this.activity, this.activity.getString(R.string.im0));
                        }
                        AppMethodBeat.o(69513);
                        return true;
                    } else if (qVar instanceof com.tencent.mm.plugin.wallet.pwd.a.q) {
                        h.a((Context) this.activity, str, "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet.pwd.c.AnonymousClass2.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(69512);
                                c.this.dQL.putInt("RESET_PWD_USER_ACTION", 2);
                                c.this.a(AnonymousClass2.this.activity, 0, c.this.dQL);
                                AppMethodBeat.o(69512);
                            }
                        });
                        AppMethodBeat.o(69513);
                        return true;
                    } else {
                        AppMethodBeat.o(69513);
                        return false;
                    }
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69514);
                    v vVar = (v) objArr[0];
                    c.this.dQL.getString("key_pwd1");
                    this.Ruz.a(new com.tencent.mm.plugin.wallet.pwd.a.q(vVar.kdF, vVar.token), true, 1);
                    AppMethodBeat.o(69514);
                    return true;
                }
            };
            AppMethodBeat.o(69520);
            return r02;
        } else {
            g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(69520);
            return a2;
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean a(final WalletBaseUI walletBaseUI, int i2, String str) {
        AppMethodBeat.i(69521);
        switch (i2) {
            case 404:
                h.a((Context) walletBaseUI, str, (String) null, walletBaseUI.getString(R.string.isj), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.pwd.c.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(69515);
                        c.this.b(walletBaseUI, c.this.dQL);
                        if (walletBaseUI.isTransparent()) {
                            walletBaseUI.finish();
                        }
                        walletBaseUI.clearErr();
                        AppMethodBeat.o(69515);
                    }
                });
                AppMethodBeat.o(69521);
                return true;
            default:
                AppMethodBeat.o(69521);
                return false;
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final int a(MMActivity mMActivity, int i2) {
        return R.string.isj;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "ResetPwdProcessByToken";
    }
}
