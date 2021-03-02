package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.bk;
import com.tencent.mm.protocal.l;

final class a extends o {
    bk.a GQG = new bk.a();
    bk.b GQH = new bk.b();

    a() {
        AppMethodBeat.i(29756);
        AppMethodBeat.o(29756);
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        return 616;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintresourcersa";
    }

    @Override // com.tencent.mm.network.s
    public final l.e getRespObj() {
        return this.GQH;
    }

    @Override // com.tencent.mm.ak.o
    public final l.d getReqObjImp() {
        return this.GQG;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final int getOptions() {
        return 1;
    }
}
