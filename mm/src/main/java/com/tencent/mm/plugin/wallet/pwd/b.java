package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet.pwd.a.l;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI;
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

public class b extends d {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69504);
        Log.d("MicroMsg.ProcessManager", "start Process : ModifyPwdProcess");
        b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.o(69504);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(69505);
        if (activity instanceof WalletCheckPwdUI) {
            b(activity, WalletSetPasswordUI.class, bundle);
            AppMethodBeat.o(69505);
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.o(69505);
        } else {
            if (activity instanceof WalletPwdConfirmUI) {
                b(activity, bundle);
            }
            AppMethodBeat.o(69505);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(69506);
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i2);
        }
        AppMethodBeat.o(69506);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69507);
        a(activity, WalletPasswordSettingUI.class, -1, false);
        AppMethodBeat.o(69507);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(69508);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 r0 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pwd.b.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69498);
                    this.Ruz.a(new w((String) objArr[0], 3, (String) objArr[1]), true, 1);
                    AppMethodBeat.o(69498);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(69499);
                    switch (i2) {
                        case 0:
                            String string = this.activity.getString(R.string.ib0);
                            AppMethodBeat.o(69499);
                            return string;
                        case 1:
                            String string2 = this.activity.getString(R.string.imh);
                            AppMethodBeat.o(69499);
                            return string2;
                        default:
                            CharSequence tips = super.getTips(i2);
                            AppMethodBeat.o(69499);
                            return tips;
                    }
                }
            };
            AppMethodBeat.o(69508);
            return r0;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            AnonymousClass2 r02 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.pwd.b.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69501);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof l) {
                            b.this.a(this.activity, 0, b.this.dQL);
                            h.cD(this.activity, this.activity.getString(R.string.im0));
                        }
                        AppMethodBeat.o(69501);
                        return true;
                    } else if (qVar instanceof l) {
                        h.a((Context) this.activity, str, "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet.pwd.b.AnonymousClass2.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(69500);
                                b.this.g(AnonymousClass2.this.activity, 0);
                                AppMethodBeat.o(69500);
                            }
                        });
                        AppMethodBeat.o(69501);
                        return true;
                    } else {
                        AppMethodBeat.o(69501);
                        return false;
                    }
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(69502);
                    this.Ruz.a(new l(b.this.dQL.getString("key_pwd1"), ((v) objArr[0]).kdF), true, 1);
                    AppMethodBeat.o(69502);
                    return true;
                }
            };
            AppMethodBeat.o(69508);
            return r02;
        } else {
            g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(69508);
            return a2;
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean a(final WalletBaseUI walletBaseUI, int i2, String str) {
        AppMethodBeat.i(69509);
        switch (i2) {
            case 404:
                h.a((Context) walletBaseUI, str, (String) null, walletBaseUI.getString(R.string.isj), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.pwd.b.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(69503);
                        b.this.b(walletBaseUI, b.this.dQL);
                        if (walletBaseUI.isTransparent()) {
                            walletBaseUI.finish();
                        }
                        walletBaseUI.clearErr();
                        AppMethodBeat.o(69503);
                    }
                });
                AppMethodBeat.o(69509);
                return true;
            default:
                AppMethodBeat.o(69509);
                return false;
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final int a(MMActivity mMActivity, int i2) {
        return R.string.isj;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "ModifyPwdProcess";
    }
}
