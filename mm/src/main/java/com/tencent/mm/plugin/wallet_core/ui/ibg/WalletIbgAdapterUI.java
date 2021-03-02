package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.b;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

@a(7)
public class WalletIbgAdapterUI extends WalletBaseUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71438);
        super.onCreate(bundle);
        setContentViewVisibility(4);
        this.mNetSceneMgr.addSceneEndListener(1564);
        doSceneForceProgress(new b());
        AppMethodBeat.o(71438);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(71439);
        super.onResume();
        AppMethodBeat.o(71439);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(71440);
        if (i2 == 0 && i3 == 0 && (qVar instanceof b)) {
            int i4 = ((b) qVar).HQH;
            String str2 = ((b) qVar).jumpUrl;
            Log.i("MicroMsg.WalletH5AdapterUI", "hy: get success! url is: %s, download x5 = %b", str2, Integer.valueOf(i4));
            if (i4 == 1) {
                int gmJ = x.a.gmJ();
                Log.i("MicroMsg.WalletH5AdapterUI", "now status = %d", Integer.valueOf(gmJ));
                switch (gmJ) {
                    case 1:
                    case 4:
                        z = true;
                        break;
                    case 2:
                    case 3:
                        g.aAi();
                        if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                            Toast.makeText(this, getString(R.string.j0e), 1).show();
                            x.a.gmK();
                            finish();
                        } else {
                            fTO();
                        }
                        z = false;
                        break;
                    default:
                        fTO();
                        z = false;
                        break;
                }
                if (z) {
                    aVV(str2);
                    finish();
                    AppMethodBeat.o(71440);
                }
                AppMethodBeat.o(71440);
            } else {
                aVV(str2);
                finish();
                AppMethodBeat.o(71440);
            }
        } else {
            com.tencent.mm.wallet_core.a.c(this, null, 0);
            AppMethodBeat.o(71440);
        }
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(71441);
        this.mNetSceneMgr.removeSceneEndListener(1564);
        super.onDestroy();
        AppMethodBeat.o(71441);
    }

    private void aVV(String str) {
        AppMethodBeat.i(71442);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        f.aA(this, intent);
        AppMethodBeat.o(71442);
    }

    private void fTO() {
        AppMethodBeat.i(71443);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.TRUE);
        h.a((Context) this, false, getString(R.string.j0h), "", getString(R.string.j0c), getString(R.string.j0b), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgAdapterUI.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(71436);
                x.a.gmK();
                Toast.makeText(WalletIbgAdapterUI.this, WalletIbgAdapterUI.this.getString(R.string.j0d), 1).show();
                WalletIbgAdapterUI.this.finish();
                AppMethodBeat.o(71436);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgAdapterUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(71437);
                WalletIbgAdapterUI.this.finish();
                AppMethodBeat.o(71437);
            }
        });
        AppMethodBeat.o(71443);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
