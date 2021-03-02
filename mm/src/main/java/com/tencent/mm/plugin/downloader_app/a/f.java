package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends com.tencent.mm.plugin.ball.service.f {
    public f(com.tencent.mm.plugin.ball.a.f fVar) {
        super(fVar);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGg() {
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGh() {
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void G(int i2, String str) {
        AppMethodBeat.i(175270);
        super.G(i2, str);
        ciw().hDa = 11;
        AppMethodBeat.o(175270);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final boolean wu(int i2) {
        AppMethodBeat.i(175271);
        this.oWE = e.cBX().oWE;
        boolean wu = super.wu(i2);
        AppMethodBeat.o(175271);
        return wu;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCA() {
        AppMethodBeat.i(175272);
        super.bCA();
        e.cBX().qKU = true;
        AppMethodBeat.o(175272);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGj() {
        AppMethodBeat.i(175273);
        super.aGj();
        e.cBX().qKU = false;
        e.cBX().jU(false);
        AppMethodBeat.o(175273);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(175274);
        super.aGi();
        this.oXA.hb(false);
        AppMethodBeat.o(175274);
    }
}
