package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.facedetect.b.k;
import com.tencent.mm.protocal.l;

final class g extends o {
    k.a sPD = new k.a();
    k.b sPE = new k.b();

    g() {
        AppMethodBeat.i(103589);
        AppMethodBeat.o(103589);
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        return 930;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        return "/cgi-bin/micromsg-bin/verifyfacersa";
    }

    @Override // com.tencent.mm.network.s
    public final l.e getRespObj() {
        return this.sPE;
    }

    @Override // com.tencent.mm.ak.o
    public final l.d getReqObjImp() {
        return this.sPD;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final int getOptions() {
        return 1;
    }
}
