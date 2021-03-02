package com.tencent.mm.plugin.festival.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.service.f;
import kotlin.g.b.p;

public final class u extends f {
    public static final a UyT = new a((byte) 0);
    private static String uzR;

    static {
        AppMethodBeat.i(263058);
        AppMethodBeat.o(263058);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(com.tencent.mm.plugin.ball.a.f fVar) {
        super(fVar);
        p.h(fVar, "pageAdapter");
        AppMethodBeat.i(263057);
        AppMethodBeat.o(263057);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGf() {
        AppMethodBeat.i(263052);
        ((b) g.af(b.class)).jS(true);
        super.aGf();
        AppMethodBeat.o(263052);
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
        AppMethodBeat.i(263053);
        super.G(i2, str);
        ciw().hDa = 15;
        civ();
        AppMethodBeat.o(263053);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(263054);
        super.aGi();
        this.oXA.hb(false);
        AppMethodBeat.o(263054);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGj() {
        AppMethodBeat.i(263055);
        ((b) g.af(b.class)).jS(false);
        this.oWE.oWs.opType = 4;
        super.aGj();
        AppMethodBeat.o(263055);
    }

    public final void nA(boolean z) {
        AppMethodBeat.i(263056);
        ((b) g.af(b.class)).jS(z);
        this.oWE.oWs.opType = 4;
        super.aGj();
        AppMethodBeat.o(263056);
    }
}
