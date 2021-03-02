package com.tencent.mm.plugin.wear.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WearYoNoLockUI extends WearYoUI {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.wear.ui.WearYoUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
