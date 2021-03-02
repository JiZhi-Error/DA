package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class h extends a {
    private long yrS;
    public long yrT;
    private long yso = 0;
    public long ysp = 0;
    public long ysq = 0;
    public long ysr = 0;

    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void start() {
        AppMethodBeat.i(25507);
        super.start();
        this.yrS = Util.nowMilliSecond();
        AppMethodBeat.o(25507);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void reset() {
        this.yrS = 0;
        this.yrT = 0;
        this.yso = 0;
        this.ysp = 0;
        this.ysq = 0;
        this.ysr = 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void bUV() {
        AppMethodBeat.i(25508);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12931, Long.valueOf(this.yrS), Long.valueOf(this.yrT), Long.valueOf(this.yso), Long.valueOf(this.ysp), Long.valueOf(this.ysq), Long.valueOf(this.ysr));
        AppMethodBeat.o(25508);
    }
}
