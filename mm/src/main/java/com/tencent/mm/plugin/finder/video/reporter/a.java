package com.tencent.mm.plugin.finder.video.reporter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class a {
    private boolean whD = false;

    public final void dFX() {
        AppMethodBeat.i(241820);
        if (!this.whD) {
            h.INSTANCE.n(1505, 249, 1);
            this.whD = true;
        }
        AppMethodBeat.o(241820);
    }
}
