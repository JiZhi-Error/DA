package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.game.preload.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends com.tencent.luggage.game.d.a {
    @Override // com.tencent.luggage.game.d.a
    public final boolean Me() {
        AppMethodBeat.i(45133);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_appbrand_game_splashscreen, false);
        AppMethodBeat.o(45133);
        return a2;
    }

    @Override // com.tencent.luggage.game.d.a
    public final void Mf() {
        AppMethodBeat.i(45134);
        d bDu = d.bDu();
        e.bDw().dX(2002, (int) (Util.nowMilliSecond() - bDu.kGW.bsC().startTime));
        e.bDw().dX(3002, bDu.ltZ.intValue());
        e.bDw().dX(3004, bDu.ltY.intValue());
        e.bDw().dX(4002, bDu.lua.intValue());
        e.bDw().dX(3005, bDu.lub.intValue());
        AppMethodBeat.o(45134);
    }
}
