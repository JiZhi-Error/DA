package com.tencent.mm.plugin.lite.ui;

import com.tencent.liteapp.ui.WxaLiteAppUI;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;

public class WxaLiteAppLiteUI extends WxaLiteAppUI {
    @Override // com.tencent.mm.ext.ui.SwipeBackActivity, com.tencent.liteapp.ui.WxaLiteAppUI, com.tencent.liteapp.ui.WxaLiteAppBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.liteapp.ui.WxaLiteAppUI
    public final boolean isDarkMode() {
        AppMethodBeat.i(198949);
        boolean isDarkMode = ao.isDarkMode();
        AppMethodBeat.o(198949);
        return isDarkMode;
    }
}
