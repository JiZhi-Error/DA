package com.tencent.mm.plugin.fingerprint.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class FingerPrintEntranceUI extends WalletBaseUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(64554);
        super.onCreate(bundle);
        Log.i("MicroMsg.FingerPrintEntranceUI", "onCreate");
        if (d.dKk()) {
            Log.i("MicroMsg.FingerPrintEntranceUI", "will call showSetFingerPrintGuide()");
            Log.i("MicroMsg.FingerPrintEntranceUI", "hy: has standard action starting to fingerprint setting");
            h.a((Context) this, getResources().getString(R.string.hjf), "", getResources().getString(((a) g.af(a.class)).dJW() ? R.string.am7 : R.string.x_), getString(R.string.sz), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(64550);
                    Log.i("MicroMsg.FingerPrintEntranceUI", "user click the button to set system fingerprint");
                    FingerPrintEntranceUI.a(FingerPrintEntranceUI.this);
                    FingerPrintEntranceUI.this.finish();
                    AppMethodBeat.o(64550);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(64551);
                    FingerPrintEntranceUI.this.finish();
                    AppMethodBeat.o(64551);
                }
            });
            d.dKg();
        } else if (!d.dKf()) {
            Log.i("MicroMsg.FingerPrintEntranceUI", "will showOpenFingerPrintPayGuide()");
            h.a((Context) this, getResources().getString(R.string.hje), "", getResources().getString(R.string.am5), getString(R.string.sz), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(64552);
                    Log.i("MicroMsg.FingerPrintEntranceUI", "user click the button to open fingerprint pay");
                    c.V(FingerPrintEntranceUI.this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                    FingerPrintEntranceUI.this.finish();
                    AppMethodBeat.o(64552);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(64553);
                    FingerPrintEntranceUI.this.finish();
                    AppMethodBeat.o(64553);
                }
            });
            d.dKe();
        } else {
            z = false;
        }
        if (!z) {
            Log.e("MicroMsg.FingerPrintEntranceUI", "finish FingerPrintEntranceUI");
            finish();
        }
        AppMethodBeat.o(64554);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(64555);
        super.onResume();
        AppMethodBeat.o(64555);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    static /* synthetic */ void a(FingerPrintEntranceUI fingerPrintEntranceUI) {
        AppMethodBeat.i(64556);
        ((a) g.af(a.class)).fK(fingerPrintEntranceUI);
        AppMethodBeat.o(64556);
    }
}
