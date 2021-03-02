package com.tencent.mm.plugin.profile.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.statusbar.DrawStatusBarPreference;

public class ContactProfileUI extends DrawStatusBarPreference {
    @Override // com.tencent.mm.ui.statusbar.DrawStatusBarPreference, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(27042);
        super.onCreate(bundle);
        AppMethodBeat.o(27042);
    }

    @Override // com.tencent.mm.ui.statusbar.DrawStatusBarPreference, com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        AppMethodBeat.i(27043);
        int resourceId = super.getResourceId();
        AppMethodBeat.o(27043);
        return resourceId;
    }
}
