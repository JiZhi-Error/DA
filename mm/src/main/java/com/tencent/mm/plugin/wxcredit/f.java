package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;

public class f extends d {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72291);
        Log.d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
        if (bundle.getBoolean("key_is_show_detail", true)) {
            a(activity, "wallet", ".bind.ui.WalletBankcardDetailUI", bundle);
        } else {
            b(activity, WalletCheckPwdUI.class, bundle);
        }
        AppMethodBeat.o(72291);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(72292);
        if (activity.getClass().getSimpleName().equalsIgnoreCase("WalletBankcardDetailUI")) {
            b(activity, WalletCheckPwdUI.class, bundle);
            AppMethodBeat.o(72292);
            return;
        }
        if (activity instanceof WalletCheckPwdUI) {
            b(activity, bundle);
        }
        AppMethodBeat.o(72292);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(72293);
        P(activity);
        AppMethodBeat.o(72293);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72294);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_walletv2_open_config, true);
        Log.i("MicroMsg.ProcessManager", " walletMallV2 switch is ：%s", Boolean.valueOf(a2));
        if (a2) {
            e(activity, "mall", ".ui.MallIndexUIv2");
            AppMethodBeat.o(72294);
            return;
        }
        e(activity, "mall", ".ui.MallIndexUI");
        AppMethodBeat.o(72294);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(72295);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 r0 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wxcredit.f.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72289);
                    if (i2 == 0 && i3 == 0 && (qVar instanceof com.tencent.mm.plugin.wxcredit.a.f)) {
                        f.this.a(this.activity, 0, f.this.dQL);
                        AppMethodBeat.o(72289);
                        return true;
                    }
                    AppMethodBeat.o(72289);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72290);
                    if (!f.this.dQL.getBoolean("key_is_show_detail", true)) {
                        Bankcard bankcard = (Bankcard) f.this.dQL.getParcelable("key_bankcard");
                        this.Ruz.a(new com.tencent.mm.plugin.wxcredit.a.f(bankcard.field_bankcardType, bankcard.field_bindSerial, f.this.dQL.getString("key_pwd1")), true, 1);
                        AppMethodBeat.o(72290);
                        return true;
                    }
                    AppMethodBeat.o(72290);
                    return false;
                }
            };
            AppMethodBeat.o(72295);
            return r0;
        }
        com.tencent.mm.wallet_core.d.g a2 = super.a(mMActivity, iVar);
        AppMethodBeat.o(72295);
        return a2;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "WXCreditUnbindProcess";
    }
}
