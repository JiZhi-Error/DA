package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.x;

public final class bj extends o {
    private final x.a iDQ = new x.a();
    private final x.b iDR = new x.b();

    public bj() {
        AppMethodBeat.i(132250);
        AppMethodBeat.o(132250);
    }

    @Override // com.tencent.mm.ak.o
    public final l.d getReqObjImp() {
        return this.iDQ;
    }

    @Override // com.tencent.mm.network.s
    public final l.e getRespObj() {
        return this.iDR;
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        return 126;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        return "/cgi-bin/micromsg-bin/newreg";
    }
}
