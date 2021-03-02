package com.tencent.mm.plugin.wallet_core.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class a extends d {
    @Override // com.tencent.mm.wallet_core.d
    public d a(Activity activity, Bundle bundle) {
        K("start", activity, bundle);
        if (bundle != null) {
            bundle.putBoolean("key_is_bind_reg_process", true);
        }
        b(activity, WalletBankcardIdUI.class, bundle);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public void a(Activity activity, int i2, Bundle bundle) {
        K("forward", activity, Integer.valueOf(i2), bundle);
        if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            b(activity, WalletCardElementUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            b(activity, WalletSetPasswordUI.class, bundle);
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletOrderInfoUI) {
            b(activity, bundle);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public void g(Activity activity, int i2) {
        K("back", activity, Integer.valueOf(i2));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i2);
        } else {
            P(activity);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public boolean c(Activity activity, Bundle bundle) {
        return activity instanceof WalletOrderInfoUI;
    }

    @Override // com.tencent.mm.wallet_core.d
    public boolean a(final WalletBaseUI walletBaseUI, int i2, String str) {
        switch (i2) {
            case 404:
                Log.i("MicroMsg.ProcessManager", "404 bind error, cancel bind!");
                h.a((Context) walletBaseUI, str, (String) null, walletBaseUI.getString(R.string.i8p), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.b.a.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(69864);
                        a.this.b(walletBaseUI, a.this.dQL);
                        if (walletBaseUI.isTransparent()) {
                            walletBaseUI.finish();
                        }
                        walletBaseUI.clearErr();
                        AppMethodBeat.o(69864);
                    }
                });
                return true;
            default:
                return false;
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public int a(MMActivity mMActivity, int i2) {
        return R.string.ied;
    }
}
