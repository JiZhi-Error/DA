package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class j extends a {
    private long yrS;
    public long yrT;
    public long yss = 0;
    public long yst = 0;
    public long ysu = 0;

    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void start() {
        AppMethodBeat.i(25510);
        super.start();
        this.yrS = Util.nowMilliSecond();
        AppMethodBeat.o(25510);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void reset() {
        this.yrS = 0;
        this.yrT = 0;
        this.yss = 0;
        this.yst = 0;
        this.ysu = 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void bUV() {
        AppMethodBeat.i(25511);
        h.INSTANCE.a(12934, Long.valueOf(this.yrS), Long.valueOf(this.yrT), Long.valueOf(this.yss), Long.valueOf(this.yst), Long.valueOf(this.ysu));
        AppMethodBeat.o(25511);
    }
}
