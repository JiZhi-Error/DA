package com.tencent.mm.i;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends e {
    public int cBY = 0;
    public String dRS;
    public CdnLogic.BatchSnsReqImageData[] gqo;
    public int gqv;
    public int gqw;
    public volatile boolean gqx = false;

    public final boolean alN() {
        if (this.gqw == this.cBY) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.i.e
    public final String toString() {
        AppMethodBeat.i(120677);
        String format = String.format("feedId: %s, count:%d", this.dRS, Integer.valueOf(this.gqw));
        AppMethodBeat.o(120677);
        return format;
    }
}
