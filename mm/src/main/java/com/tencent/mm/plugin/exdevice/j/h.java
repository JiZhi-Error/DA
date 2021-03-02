package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.f;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class h extends ae {
    private a rEI;
    private f rxK;

    public h(f fVar) {
        this.rxK = fVar;
    }

    @Override // com.tencent.mm.plugin.exdevice.model.ae
    public final boolean a(m mVar, d dVar) {
        AppMethodBeat.i(23806);
        this.rEI = new a(this.rxK, dVar);
        boolean b2 = this.rEI.b(mVar);
        Log.i("MicroMsg.exdevice.MMSendDataToDeviceExcuter", "send data to devide : %b", Boolean.valueOf(b2));
        AppMethodBeat.o(23806);
        return b2;
    }
}
