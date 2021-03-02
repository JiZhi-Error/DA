package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;

public class g extends e {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72157);
        b(activity, WalletPayUCheckPwdUI.class, bundle);
        AppMethodBeat.o(72157);
        return this;
    }

    @Override // com.tencent.mm.plugin.wallet_payu.pwd.a.e, com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(72158);
        if (activity instanceof WalletPayUCheckPwdUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
            AppMethodBeat.o(72158);
            return;
        }
        super.a(activity, i2, bundle);
        AppMethodBeat.o(72158);
    }

    @Override // com.tencent.mm.plugin.wallet_payu.pwd.a.e, com.tencent.mm.wallet_core.d
    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(72159);
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            AnonymousClass1 r0 = new a(mMActivity, iVar, this.dQL) {
                /* class com.tencent.mm.plugin.wallet_payu.pwd.a.g.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(72154);
                    if (i2 == 0) {
                        String string = this.activity.getString(R.string.ib1);
                        AppMethodBeat.o(72154);
                        return string;
                    }
                    CharSequence tips = super.getTips(i2);
                    AppMethodBeat.o(72154);
                    return tips;
                }
            };
            AppMethodBeat.o(72159);
            return r0;
        } else if (mMActivity instanceof WalletPayUPwdConfirmUI) {
            AnonymousClass2 r02 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_payu.pwd.a.g.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72155);
                    if (qVar instanceof b) {
                        Log.d("MicroMsg.PayUModifyPasswordProcess", "hy: change pwd user success");
                        if (i2 == 0 && i3 == 0) {
                            g.this.dQL.putInt("key_errcode_payu", 0);
                            a.c(this.activity, g.this.dQL, 0);
                            AppMethodBeat.o(72155);
                            return true;
                        }
                    }
                    AppMethodBeat.o(72155);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72156);
                    this.Ruz.b(new b(g.this.dQL.getString("key_pwd1"), ((v) objArr[0]).kdF), true);
                    AppMethodBeat.o(72156);
                    return true;
                }
            };
            AppMethodBeat.o(72159);
            return r02;
        } else {
            com.tencent.mm.wallet_core.d.g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(72159);
            return a2;
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "PayUModifyPasswordProcess";
    }
}
