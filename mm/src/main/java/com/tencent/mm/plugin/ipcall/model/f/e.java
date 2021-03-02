package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class e extends a {
    public long yrX = 0;
    public long yrY = 0;

    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void bUV() {
        AppMethodBeat.i(25502);
        h.INSTANCE.a(12935, Long.valueOf(this.yrX), Long.valueOf(this.yrY));
        AppMethodBeat.o(25502);
    }
}
