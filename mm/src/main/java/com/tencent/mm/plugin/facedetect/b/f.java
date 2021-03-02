package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.facedetect.b.j;
import com.tencent.mm.protocal.l;

final class f extends o {
    j.a sPB = new j.a();
    j.b sPC = new j.b();

    f() {
        AppMethodBeat.i(103588);
        AppMethodBeat.o(103588);
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        return 931;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        return "/cgi-bin/micromsg-bin/registerfacersa";
    }

    @Override // com.tencent.mm.network.s
    public final l.e getRespObj() {
        return this.sPC;
    }

    @Override // com.tencent.mm.ak.o
    public final l.d getReqObjImp() {
        return this.sPB;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final int getOptions() {
        return 1;
    }
}
