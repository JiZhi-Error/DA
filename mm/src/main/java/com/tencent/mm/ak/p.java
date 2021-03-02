package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.t;

public final class p extends o {
    private final t.a iMg = new t.a();
    private final t.b iMh = new t.b();

    public p() {
        AppMethodBeat.i(132307);
        AppMethodBeat.o(132307);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ak.o
    public final l.d getReqObjImp() {
        return this.iMg;
    }

    @Override // com.tencent.mm.network.s
    public final l.e getRespObj() {
        return this.iMh;
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        return 381;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getcert";
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final int getOptions() {
        return 1;
    }
}
