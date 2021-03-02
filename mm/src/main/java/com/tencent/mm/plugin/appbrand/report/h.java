package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.b;
import com.tencent.mm.sdk.platformtools.Util;

public final class h extends b {
    private volatile long nHa = 0;
    private volatile boolean nHb = false;
    public volatile String nHc;

    public h(int i2) {
        super(i2);
    }

    public final long bUs() {
        if (this.nHb) {
            return this.nIq.nHT - this.nHa;
        }
        return 0;
    }

    public final void aeF(String str) {
        AppMethodBeat.i(227370);
        super.onForeground();
        this.nHa = 0;
        if (str.startsWith("__wx__")) {
            this.nHb = false;
            this.nHc = null;
        }
        AppMethodBeat.o(227370);
    }

    public final void aeG(String str) {
        AppMethodBeat.i(227371);
        this.nHa = Util.nowMilliSecond() - this.nIq.nHP.getStartTime();
        this.nHc = str;
        this.nHb = true;
        AppMethodBeat.o(227371);
    }
}
