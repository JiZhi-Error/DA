package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class g extends a {
    private long yrS;
    public long yrT;
    public long ysh = 0;
    public String ysi = "";
    public String ysj = "";
    public long ysk = 0;
    public long ysl = 0;
    public long ysm = 0;
    public String ysn = "";

    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void start() {
        AppMethodBeat.i(25505);
        super.start();
        this.yrS = Util.nowMilliSecond();
        AppMethodBeat.o(25505);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void reset() {
        this.yrS = 0;
        this.yrT = 0;
        this.ysh = 0;
        this.ysi = "";
        this.ysj = "";
        this.ysk = 0;
        this.ysl = 0;
        this.ysm = 0;
        this.ysn = "";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void bUV() {
        AppMethodBeat.i(25506);
        h.INSTANCE.a(12933, Long.valueOf(this.yrS), Long.valueOf(this.yrT), Long.valueOf(this.ysh), this.ysi, this.ysj, Long.valueOf(this.ysk), Long.valueOf(this.ysl), Long.valueOf(this.ysm), this.ysn);
        AppMethodBeat.o(25506);
    }
}
