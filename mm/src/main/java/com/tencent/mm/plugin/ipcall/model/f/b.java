package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class b extends a {
    private long yrS;
    public long yrT;
    public long yrU = 0;
    public long yrV = 0;
    public long yrW = 0;

    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void start() {
        AppMethodBeat.i(25498);
        super.start();
        this.yrS = Util.nowMilliSecond();
        AppMethodBeat.o(25498);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void reset() {
        this.yrS = 0;
        this.yrT = 0;
        this.yrU = 0;
        this.yrV = 0;
        this.yrW = 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void bUV() {
        AppMethodBeat.i(25499);
        h.INSTANCE.a(12930, Long.valueOf(this.yrS), Long.valueOf(this.yrT), Long.valueOf(this.yrU), Long.valueOf(this.yrV), Long.valueOf(this.yrW));
        AppMethodBeat.o(25499);
    }
}
