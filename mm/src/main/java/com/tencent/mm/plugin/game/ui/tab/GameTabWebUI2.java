package com.tencent.mm.plugin.game.ui.tab;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameTabWebUI2 extends GameTabWebUI {
    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.game.ui.tab.GameTabWebUI, com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
