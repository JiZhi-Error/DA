package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.luggage.game.b.d;
import com.tencent.magicbrush.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends d {
    @Override // com.tencent.luggage.game.b.d
    public final void LX() {
        AppMethodBeat.i(45113);
        super.LX();
        long currentTicks = Util.currentTicks();
        b.loadLibrary("gamelog_delegate");
        Log.i("MicroMsg.MBLogDelegateRegistryWC", "dl: load gamelog_delegate [%d]ms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(45113);
    }
}
