package com.tencent.mm.plugin.voip.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.service.f;
import com.tencent.mm.plugin.voip.c;

public final class b extends f {
    public b(com.tencent.mm.plugin.ball.a.f fVar) {
        super(fVar);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGf() {
        AppMethodBeat.i(235478);
        ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).jS(true);
        super.aGf();
        AppMethodBeat.o(235478);
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
        AppMethodBeat.i(184045);
        super.G(i2, str);
        ciw().hDa = 10;
        if (c.fFg() != null) {
            ciw().dPJ = String.valueOf(c.fFg().GYS.GSZ.GVV.ypH);
        }
        cit();
        AppMethodBeat.o(184045);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final boolean wu(int i2) {
        AppMethodBeat.i(184046);
        boolean wu = super.wu(i2);
        AppMethodBeat.o(184046);
        return wu;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(184047);
        super.aGi();
        this.oXA.hb(false);
        AppMethodBeat.o(184047);
    }

    public final void fFm() {
        AppMethodBeat.i(235479);
        ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).jS(true);
        this.oWE.oWs.opType = 4;
        if (this.oWG != null) {
            this.oWG.q(this.oWE);
        }
        AppMethodBeat.o(235479);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGj() {
        AppMethodBeat.i(184048);
        ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).jS(false);
        this.oWE.oWs.opType = 4;
        if (this.oWG != null) {
            this.oWG.q(this.oWE);
        }
        AppMethodBeat.o(184048);
    }
}
