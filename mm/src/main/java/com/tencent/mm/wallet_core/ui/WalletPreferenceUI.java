package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

@a(3)
public abstract class WalletPreferenceUI extends MMPreference implements f {
    protected g mNetController = null;
    protected i mNetSceneMgr = null;
    protected d mProcess = null;

    public abstract boolean e(int i2, int i3, String str, q qVar);

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        fixStatusbar(true);
        super.onCreate(bundle);
        setStatusColor();
        this.mNetSceneMgr = new i(this, this);
        this.mNetSceneMgr.addSceneEndListener(385);
        this.mNetSceneMgr.addSceneEndListener(1518);
        if (getLayoutId() > 0) {
            f.hhT();
        }
    }

    /* access modifiers changed from: protected */
    public void setStatusColor() {
        setActionbarColor(getActionbarColor());
    }

    public final i hhW() {
        if (this.mNetSceneMgr == null) {
            this.mNetSceneMgr = new i(this, this);
        }
        return this.mNetSceneMgr;
    }

    @Override // com.tencent.mm.wallet_core.d.f
    public void onSceneEnd(int i2, int i3, String str, q qVar, boolean z) {
        if (!e(i2, i3, str, qVar) && i3 != 0) {
            if (Util.isNullOrNil(str)) {
                str = getString(R.string.ibn);
            }
            h.a((Context) this, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.wallet_core.ui.WalletPreferenceUI.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(73060);
                    WalletPreferenceUI.this.finish();
                    AppMethodBeat.o(73060);
                }
            });
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        this.mNetSceneMgr.removeSceneEndListener(385);
        this.mNetSceneMgr.removeSceneEndListener(1518);
        this.mNetSceneMgr = null;
        super.onDestroy();
    }
}
