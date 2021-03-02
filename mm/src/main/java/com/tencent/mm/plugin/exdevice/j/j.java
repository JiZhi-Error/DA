package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.h;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class j extends ae {
    private a rEK;
    private h rEL;

    public j(int i2, int i3, long j2) {
        AppMethodBeat.i(23809);
        this.rEL = new h(i2, i3, j2);
        AppMethodBeat.o(23809);
    }

    @Override // com.tencent.mm.plugin.exdevice.model.ae
    public final boolean a(m mVar, d dVar) {
        AppMethodBeat.i(23810);
        if (!u.cLx().Dc(this.rEL.pkb)) {
            Log.w("MicroMsg.exdevice.MMSwitchViewPushTaskExcuter", "push switchview event to device before it do auth, device id = %d", Long.valueOf(this.rEL.pkb));
            AppMethodBeat.o(23810);
            return true;
        }
        this.rEK = new b(this.rEL, dVar);
        boolean b2 = this.rEK.b(mVar);
        AppMethodBeat.o(23810);
        return b2;
    }
}
