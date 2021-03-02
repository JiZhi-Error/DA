package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {
    public long valLayout = 0;
    public long valMeasure = 0;

    public final String result() {
        AppMethodBeat.i(68353);
        String format = String.format("result valMeasure:%s valLayout:%s total:%s", Long.valueOf(this.valMeasure), Long.valueOf(this.valLayout), Long.valueOf(this.valLayout + this.valMeasure));
        AppMethodBeat.o(68353);
        return format;
    }
}
