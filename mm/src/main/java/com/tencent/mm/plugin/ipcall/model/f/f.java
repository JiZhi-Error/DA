package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class f extends a {
    public int yrZ = 0;
    public int ysa = 0;
    public int ysb = 0;
    public int ysc = 0;
    public int ysd = -9999;
    public String yse = "";
    public int ysf = 0;
    public int ysg = 0;

    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void start() {
        AppMethodBeat.i(25503);
        super.start();
        AppMethodBeat.o(25503);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void reset() {
        this.yrZ = 0;
        this.ysa = 0;
        this.ysb = 0;
        this.ysc = 0;
        this.ysd = -9999;
        this.yse = "";
        this.ysf = 0;
        this.ysg = 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.ipcall.model.f.a
    public final void bUV() {
        AppMethodBeat.i(25504);
        h.INSTANCE.a(14182, Integer.valueOf(this.yrZ), Integer.valueOf(this.ysa), Integer.valueOf(this.ysb), Integer.valueOf(this.ysc), Integer.valueOf(this.ysd), this.yse, Integer.valueOf(this.ysf), Integer.valueOf(this.ysg));
        AppMethodBeat.o(25504);
    }
}
