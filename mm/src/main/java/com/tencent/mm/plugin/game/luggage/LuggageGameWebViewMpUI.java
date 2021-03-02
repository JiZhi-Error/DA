package com.tencent.mm.plugin.game.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LuggageGameWebViewMpUI extends LuggageGameWebViewUI {
    @Override // com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
