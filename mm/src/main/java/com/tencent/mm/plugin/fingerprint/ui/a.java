package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a extends d {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(64477);
        Log.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess start,forward to WalletCheckPwdUI");
        b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.o(64477);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(64478);
        if (activity instanceof WalletCheckPwdUI) {
            Log.i("MicroMsg.FingerPrintAuthProcess", "forward to FingerPrintAuthUI");
            if (this.dQL.getInt("key_open_biometric_type") == 1) {
                b(activity, FingerPrintAuthUI.class, bundle);
                AppMethodBeat.o(64478);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("key_scene", 0);
            a(activity, WalletFaceIdAuthUI.class, bundle, bundle2);
            AppMethodBeat.o(64478);
        } else if (activity instanceof FingerPrintAuthUI) {
            b(activity, bundle);
            AppMethodBeat.o(64478);
        } else {
            if (activity instanceof WalletFaceIdAuthUI) {
                b(activity, bundle);
            }
            AppMethodBeat.o(64478);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(64479);
        b(activity, new Bundle());
        AppMethodBeat.o(64479);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(64480);
        Intent intent = new Intent();
        Log.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess end");
        a(activity, "wallet", ".pwd.ui.WalletBiometricPaySettingsUI", 0, intent, true);
        AppMethodBeat.o(64480);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "FingerprintAuth";
    }

    @Override // com.tencent.mm.wallet_core.d
    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(64481);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 r0 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.fingerprint.ui.a.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(64476);
                    a.this.dQL.putString("pwd", (String) objArr[0]);
                    Log.i("MicroMsg.FingerPrintAuthProcess", "this is onNext");
                    AppMethodBeat.o(64476);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    return false;
                }
            };
            AppMethodBeat.o(64481);
            return r0;
        }
        g a2 = super.a(mMActivity, iVar);
        AppMethodBeat.o(64481);
        return a2;
    }
}
