package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.bm;
import com.tencent.mm.protocal.l;

final class c extends o {
    bm.a GQK = new bm.a();
    bm.b GQL = new bm.b();

    c() {
        AppMethodBeat.i(29758);
        AppMethodBeat.o(29758);
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        return 617;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        return "/cgi-bin/micromsg-bin/verifyvoiceprintrsa";
    }

    @Override // com.tencent.mm.network.s
    public final l.e getRespObj() {
        return this.GQL;
    }

    @Override // com.tencent.mm.ak.o
    public final l.d getReqObjImp() {
        return this.GQK;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final int getOptions() {
        return 1;
    }
}
