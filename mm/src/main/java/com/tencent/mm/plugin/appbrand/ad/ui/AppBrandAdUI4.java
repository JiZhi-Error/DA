package com.tencent.mm.plugin.appbrand.ad.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandAdUI4 extends AppBrandAdUI {
    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
