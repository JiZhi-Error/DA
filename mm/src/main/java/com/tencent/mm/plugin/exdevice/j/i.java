package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.g;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends ae {
    private a rEH;
    private g rEJ;

    public i(int i2) {
        AppMethodBeat.i(23807);
        this.rEJ = new g(i2);
        AppMethodBeat.o(23807);
    }

    @Override // com.tencent.mm.plugin.exdevice.model.ae
    public final boolean a(m mVar, d dVar) {
        AppMethodBeat.i(23808);
        if (!u.cLx().Dc(this.rEJ.pkb)) {
            Log.w("MicroMsg.exdevice.MMSwitchBackGroudTaskExcuter", "push switch backgroud event to device before it do auth, device id = %d", Long.valueOf(this.rEJ.pkb));
            AppMethodBeat.o(23808);
            return true;
        }
        this.rEH = new a(this.rEJ, dVar);
        boolean b2 = this.rEH.b(mVar);
        AppMethodBeat.o(23808);
        return b2;
    }
}
