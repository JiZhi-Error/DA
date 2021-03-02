package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.sdk.platformtools.Log;
import junit.framework.Assert;

public final class n extends o.a {
    private c rEy = null;

    public n(c cVar) {
        AppMethodBeat.i(23822);
        Assert.assertNotNull(cVar);
        this.rEy = cVar;
        AppMethodBeat.o(23822);
    }

    @Override // com.tencent.mm.plugin.exdevice.service.o
    public final long cLk() {
        AppMethodBeat.i(23823);
        Log.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.rEy.pkb);
        long j2 = this.rEy.pkb;
        AppMethodBeat.o(23823);
        return j2;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.o
    public final byte[] cLl() {
        AppMethodBeat.i(23824);
        byte[] cKi = this.rEy.cKi();
        AppMethodBeat.o(23824);
        return cKi;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.o
    public final int cLm() {
        AppMethodBeat.i(23825);
        short cKg = this.rEy.cKg();
        AppMethodBeat.o(23825);
        return cKg;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.o
    public final int cLn() {
        return this.rEy.rxx;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.o
    public final int cLo() {
        AppMethodBeat.i(23826);
        short cKh = this.rEy.cKh();
        AppMethodBeat.o(23826);
        return cKh;
    }
}
