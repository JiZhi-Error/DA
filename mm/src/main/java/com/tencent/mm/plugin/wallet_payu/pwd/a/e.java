package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;

public abstract class e extends d {
    @Override // com.tencent.mm.wallet_core.d
    public void a(Activity activity, int i2, Bundle bundle) {
        if (activity instanceof WalletPayUSetPasswordUI) {
            b(activity, WalletPayUPwdConfirmUI.class, bundle);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        if (activity instanceof WalletPayUPwdConfirmUI) {
            a(activity, WalletPayUSetPasswordUI.class, i2);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        if (this.dQL.getInt("key_errcode_payu", -1) == 0) {
            u.makeText(activity, (int) R.string.ikd, 0).show();
        } else {
            u.makeText(activity, (int) R.string.ice, 0).show();
        }
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_walletv2_open_config, true);
        Log.i("MicroMsg.PayUBaseChangePwdProcess", " walletMallV2 switch is ：%s", Boolean.valueOf(a2));
        if (a2) {
            e(activity, "mall", ".ui.MallIndexUIv2");
        } else {
            e(activity, "mall", ".ui.MallIndexUI");
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        return mMActivity instanceof WalletPayUPwdConfirmUI ? new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
            /* class com.tencent.mm.plugin.wallet_payu.pwd.a.e.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.d.g
            public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(72149);
                if (qVar instanceof d) {
                    Log.d("MicroMsg.PayUBaseChangePwdProcess", "hy: forget pwd user success");
                    if (i2 == 0 && i3 == 0) {
                        e.this.dQL.putInt("key_errcode_payu", 0);
                        a.c(this.activity, e.this.dQL, 0);
                        AppMethodBeat.o(72149);
                        return true;
                    }
                }
                AppMethodBeat.o(72149);
                return false;
            }

            @Override // com.tencent.mm.wallet_core.d.g
            public final boolean r(Object... objArr) {
                AppMethodBeat.i(72150);
                this.Ruz.b(new d(e.this.dQL.getString("payu_reference"), ((v) objArr[0]).kdF), true);
                AppMethodBeat.o(72150);
                return true;
            }
        } : super.a(mMActivity, iVar);
    }
}
