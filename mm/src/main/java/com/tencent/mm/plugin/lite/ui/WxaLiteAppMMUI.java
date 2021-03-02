package com.tencent.mm.plugin.lite.ui;

import com.tencent.liteapp.ui.WxaLiteAppUI;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaLiteAppMMUI extends WxaLiteAppUI {
    @Override // com.tencent.mm.ext.ui.SwipeBackActivity, com.tencent.liteapp.ui.WxaLiteAppUI, com.tencent.liteapp.ui.WxaLiteAppBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
