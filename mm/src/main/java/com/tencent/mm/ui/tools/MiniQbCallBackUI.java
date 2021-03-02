package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.sdk.event.EventCenter;

public class MiniQbCallBackUI extends MiniQbCallBackBaseUI {
    @Override // com.tencent.mm.ui.tools.MiniQbCallBackBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.tools.MiniQbCallBackBaseUI
    public final String getTag() {
        return "MicroMsg.FilesFloatBall.MiniQbCallBackUI";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.tools.MiniQbCallBackBaseUI
    public final void b(String str, String str2, int i2, String str3, int i3) {
        AppMethodBeat.i(234465);
        super.b(str, str2, i2, str3, i3);
        mn mnVar = new mn();
        mnVar.dSa.action = i2;
        mnVar.dSa.filePath = str3;
        mnVar.dSa.dSc = i3;
        EventCenter.instance.publish(mnVar);
        AppMethodBeat.o(234465);
    }
}
