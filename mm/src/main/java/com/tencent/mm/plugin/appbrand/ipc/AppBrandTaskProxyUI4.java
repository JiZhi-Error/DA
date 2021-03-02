package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandTaskProxyUI4 extends AppBrandTaskProxyUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
