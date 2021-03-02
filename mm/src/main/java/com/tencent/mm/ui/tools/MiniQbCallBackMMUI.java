package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;

public class MiniQbCallBackMMUI extends MiniQbCallBackBaseUI {
    @Override // com.tencent.mm.ui.tools.MiniQbCallBackBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.tools.MiniQbCallBackBaseUI
    public final String getTag() {
        return "MicroMsg.FilesFloatBall.MiniQbCallBackMMUI";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.tools.MiniQbCallBackBaseUI
    public final void b(String str, String str2, int i2, String str3, int i3) {
        AppMethodBeat.i(234464);
        super.b(str, str2, i2, str3, i3);
        if (Util.isNullOrNil(str2)) {
            mn mnVar = new mn();
            mnVar.dSa.action = i2;
            mnVar.dSa.filePath = str3;
            mnVar.dSa.dSc = i3;
            EventCenter.instance.publish(mnVar);
            AppMethodBeat.o(234464);
            return;
        }
        ((f) g.af(f.class)).a(str2, new MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent(i2, str3));
        AppMethodBeat.o(234464);
    }
}
