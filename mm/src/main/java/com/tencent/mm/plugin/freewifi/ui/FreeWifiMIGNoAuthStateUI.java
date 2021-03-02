package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class FreeWifiMIGNoAuthStateUI extends FreeWifiNoAuthStateUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI, com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI
    public final String dNQ() {
        AppMethodBeat.i(25066);
        String string = getString(R.string.f0h);
        AppMethodBeat.o(25066);
        return string;
    }
}
