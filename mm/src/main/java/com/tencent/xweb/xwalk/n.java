package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import com.tencent.xweb.internal.f;
import com.tencent.xweb.m;
import com.tencent.xweb.xwalk.s;
import org.xwalk.core.Log;

public final class n implements f {
    private boolean SHG;

    @Override // com.tencent.xweb.internal.f
    public final void htE() {
        AppMethodBeat.i(183743);
        if (!this.SHG) {
            String brI = a.brI(WebView.getCurStrModule());
            int brH = a.brH(WebView.getCurStrModule());
            int i2 = 0;
            try {
                i2 = Integer.parseInt(a.nS("enableWindowPerformanceSampleRatio", WebView.getCurStrModule()));
            } catch (NumberFormatException e2) {
            }
            s.a.hvb();
            Log.d("XWalkExtensionInternal", "setProfileConfig with enabledTraceCategory: " + brI + " traceSampleRatio: " + brH + " enableWindowPerformanceSampleRatio: " + i2);
            s.bb(brI, brH, i2);
            this.SHG = true;
        }
        AppMethodBeat.o(183743);
    }

    @Override // com.tencent.xweb.internal.f
    public final m htD() {
        AppMethodBeat.i(183742);
        s hvb = s.a.hvb();
        AppMethodBeat.o(183742);
        return hvb;
    }
}
