package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.b.a;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.h;

public class WalletOpenFingerprintPayRedirectUI extends AutoLoginActivity implements i {
    private boolean ZB = false;
    private Dialog tipDialog = null;

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletOpenFingerprintPayRedirectUI walletOpenFingerprintPayRedirectUI, String str) {
        AppMethodBeat.i(71940);
        walletOpenFingerprintPayRedirectUI.c(4, false, str);
        AppMethodBeat.o(71940);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71934);
        super.onCreate(bundle);
        g.aAi();
        g.aAg().hqi.a(385, this);
        AppMethodBeat.o(71934);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final boolean ab(Intent intent) {
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(71935);
        super.onDestroy();
        g.aAi();
        g.aAg().hqi.b(385, this);
        AppMethodBeat.o(71935);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final void a(AutoLoginActivity.a aVar, Intent intent) {
        AppMethodBeat.i(71936);
        Log.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, loginResult = ".concat(String.valueOf(aVar)));
        switch (aVar) {
            case LOGIN_OK:
                Log.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: login ok.");
                g.aAi();
                g.aAg().hqi.a(new ad(null, 19), 0);
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                this.tipDialog = h.b(this, true, new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.wallet_index.ui.WalletOpenFingerprintPayRedirectUI.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(71931);
                        WalletOpenFingerprintPayRedirectUI.this.ZB = true;
                        WalletOpenFingerprintPayRedirectUI.a(WalletOpenFingerprintPayRedirectUI.this, "");
                        AppMethodBeat.o(71931);
                    }
                });
                AppMethodBeat.o(71936);
                return;
            case LOGIN_CANCEL:
            case LOGIN_FAIL:
                Log.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin fail, loginResult = ".concat(String.valueOf(aVar)));
                c(1, false, "");
                break;
            default:
                Log.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, unknown login result = ".concat(String.valueOf(aVar)));
                break;
        }
        c(2, true, getString(R.string.i5r));
        AppMethodBeat.o(71936);
    }

    private void c(int i2, boolean z, String str) {
        AppMethodBeat.i(71937);
        Log.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: redirect to open fingerprint failed. errCode: %d", Integer.valueOf(i2));
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (z) {
            com.tencent.mm.ui.base.h.a((Context) this, str, "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_index.ui.WalletOpenFingerprintPayRedirectUI.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(71932);
                    WalletOpenFingerprintPayRedirectUI.this.finish();
                    AppMethodBeat.o(71932);
                }
            });
            AppMethodBeat.o(71937);
            return;
        }
        finish();
        AppMethodBeat.o(71937);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(71938);
        super.onStop();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        AppMethodBeat.o(71938);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71939);
        if (qVar instanceof ad) {
            if (!this.ZB) {
                this.ZB = true;
                if (i2 == 0 && i3 == 0) {
                    Log.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query ok. start judge.");
                    s.fOg();
                    an fOh = s.fOh();
                    if (fOh == null || !fOh.fRk()) {
                        Log.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not open wechat payment. hint bind bankcard");
                        c(5, true, getString(R.string.icv));
                        AppMethodBeat.o(71939);
                        return;
                    } else if (!a.fPB() || ae.gKx.gIF != 1) {
                        Log.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not support wechat fp pay or not allow");
                        c(6, true, getString(R.string.icx));
                        AppMethodBeat.o(71939);
                        return;
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("key_is_from_system", true);
                        c.b(this, "wallet", ".pwd.ui.WalletPasswordSettingUI", intent);
                        finish();
                        AppMethodBeat.o(71939);
                        return;
                    }
                } else {
                    Log.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query failed. inform fail.");
                    c(3, true, getString(R.string.i5r));
                    AppMethodBeat.o(71939);
                    return;
                }
            } else {
                Log.w("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: is already handled");
            }
        }
        AppMethodBeat.o(71939);
    }
}
