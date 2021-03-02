package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TmplWebViewTooLMpUI extends TmplWebViewToolUI {
    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
