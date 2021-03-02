package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.l;

public final class d extends o {
    private static int jiX = 3941;
    private final l.e iNj = new j.d();
    private final l.d req = new j.c();

    public d() {
        AppMethodBeat.i(134153);
        AppMethodBeat.o(134153);
    }

    @Override // com.tencent.mm.network.s
    public final l.e getRespObj() {
        return this.iNj;
    }

    @Override // com.tencent.mm.ak.o
    public final l.d getReqObjImp() {
        return this.req;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        return "/cgi-bin/micromsg-bin/disasterauth";
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        return jiX;
    }
}
