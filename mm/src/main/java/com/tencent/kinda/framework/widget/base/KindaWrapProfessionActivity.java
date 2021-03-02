package com.tencent.kinda.framework.widget.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.py;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class KindaWrapProfessionActivity extends WalletSelectProfessionUI {
    public static final String ACTIVITY_CLOSE_FLAG = "flag_activity_close_WalletSelectProfessionUI";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(18987);
        super.onPause();
        if (isFinishing()) {
            py pyVar = new py();
            pyVar.dWd.dWe = ACTIVITY_CLOSE_FLAG;
            EventCenter.instance.publish(pyVar);
        }
        AppMethodBeat.o(18987);
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI, com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(18988);
        if (preference.mKey.startsWith("index_")) {
            String[] split = preference.mKey.split("_");
            if (split.length == 2) {
                Profession profession = this.mProfessions[Util.getInt(split[1], 0)];
                py pyVar = new py();
                pyVar.dWd.dWe = profession.HTX;
                pyVar.dWd.dWf = profession.HTY;
                EventCenter.instance.publish(pyVar);
                Log.i("", "KindaWrapProfessionActivity.onPreferenceTreeClick，发送事件，当前线程：" + Thread.currentThread().getId());
            } else {
                Log.w("", "KindaWrapProfessionActivity error key: %s, %s", preference.mKey, preference.getTitle());
            }
            finish();
        }
        AppMethodBeat.o(18988);
        return true;
    }
}
