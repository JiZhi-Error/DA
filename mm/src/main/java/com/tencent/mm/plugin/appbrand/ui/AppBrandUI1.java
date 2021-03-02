package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandUI1 extends AppBrandUI {
    @Override // com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.ui.AppBrandUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.ui.AppBrandUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48859);
        super.onCreate(bundle);
        AppMethodBeat.o(48859);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.ui.AppBrandUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(48860);
        super.onResume();
        AppMethodBeat.o(48860);
    }
}
