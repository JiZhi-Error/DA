package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.service.l;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p;
import junit.framework.Assert;

public final class m extends p.a {
    private n rET = null;
    l rEU = null;

    public m(c cVar, c cVar2) {
        AppMethodBeat.i(23819);
        Assert.assertNotNull(cVar);
        Assert.assertNotNull(cVar2);
        this.rET = new n(cVar);
        this.rEU = new l(cVar2);
        AppMethodBeat.o(23819);
    }

    @Override // com.tencent.mm.plugin.exdevice.service.p
    public final o cLq() {
        AppMethodBeat.i(23820);
        Assert.assertNotNull(this.rET);
        n nVar = this.rET;
        AppMethodBeat.o(23820);
        return nVar;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.p
    public final l cLr() {
        AppMethodBeat.i(23821);
        Assert.assertNotNull(this.rEU);
        l lVar = this.rEU;
        AppMethodBeat.o(23821);
        return lVar;
    }
}
