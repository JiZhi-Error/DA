package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.i;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends ae {
    private c rEG;
    private a rEH;

    public g(byte[] bArr, int i2, long j2) {
        AppMethodBeat.i(23804);
        this.rEG = new i(bArr, i2, j2);
        AppMethodBeat.o(23804);
    }

    @Override // com.tencent.mm.plugin.exdevice.model.ae
    public final boolean a(m mVar, d dVar) {
        AppMethodBeat.i(23805);
        if (!u.cLx().Dc(this.rEG.pkb)) {
            Log.w("MicroMsg.exdevice.MMPushManufacturerSvrSendDataLogic", "Service push data to device before it do auth, device id = %d", Long.valueOf(this.rEG.pkb));
            AppMethodBeat.o(23805);
            return true;
        }
        this.rEH = new a(this.rEG, dVar);
        boolean b2 = this.rEH.b(mVar);
        AppMethodBeat.o(23805);
        return b2;
    }
}
