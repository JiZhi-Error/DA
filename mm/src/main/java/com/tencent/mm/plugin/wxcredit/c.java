package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.f;

public class c extends d {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72253);
        Log.d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditCheckPwdProcess");
        b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.o(72253);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(72254);
        if (activity instanceof WalletCheckPwdUI) {
            f.p(activity, bundle.getString("key_url"), false);
            AppMethodBeat.o(72254);
            return;
        }
        b(activity, bundle);
        AppMethodBeat.o(72254);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(72255);
        P(activity);
        AppMethodBeat.o(72255);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72256);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_walletv2_open_config, true);
        Log.i("MicroMsg.WXCreditChangeAmountProcess", " walletMallV2 switch is ：%s", Boolean.valueOf(a2));
        if (a2) {
            e(activity, "mall", ".ui.MallIndexUIv2");
            AppMethodBeat.o(72256);
            return;
        }
        e(activity, "mall", ".ui.MallIndexUI");
        AppMethodBeat.o(72256);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(72257);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 r0 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wxcredit.c.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72251);
                    if (i2 == 0 && i3 == 0) {
                        c.this.a(this.activity, 0, c.this.dQL);
                        this.activity.finish();
                        AppMethodBeat.o(72251);
                        return true;
                    }
                    AppMethodBeat.o(72251);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72252);
                    c.this.dQL.putString("key_pwd1", (String) objArr[0]);
                    this.Ruz.a(new w((String) objArr[0], 5, ""), true, 1);
                    AppMethodBeat.o(72252);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean A(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.o(72257);
            return r0;
        }
        com.tencent.mm.wallet_core.d.g a2 = super.a(mMActivity, iVar);
        AppMethodBeat.o(72257);
        return a2;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "WXCreditCheckPwdProcess";
    }
}
