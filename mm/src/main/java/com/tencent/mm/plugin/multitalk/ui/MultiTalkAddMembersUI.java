package com.tencent.mm.plugin.multitalk.ui;

import android.app.KeyguardManager;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MultiTalkAddMembersUI extends MultiTalkSelectContactUI {
    private boolean zPH = false;

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI
    public void initView() {
        AppMethodBeat.i(114651);
        super.initView();
        this.zoy.setBackgroundResource(R.color.l0);
        MultiSelectContactView multiSelectContactView = this.zoy;
        int i2 = f.zSe;
        multiSelectContactView.setPadding(i2, i2, f.zSe, 0);
        AppMethodBeat.o(114651);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI
    public final void egJ() {
        AppMethodBeat.i(178894);
        this.zQc = false;
        super.egJ();
        AppMethodBeat.o(178894);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(178895);
        super.onPause();
        this.zPH = (hasWindowFocus() || !((KeyguardManager) MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) && ((PowerManager) MMApplicationContext.getContext().getSystemService("power")).isScreenOn();
        AppMethodBeat.o(178895);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(178896);
        super.onStop();
        if (this.zQc) {
            this.zQc = false;
            egJ();
            ac.eom().rI(false);
        }
        AppMethodBeat.o(178896);
    }
}
