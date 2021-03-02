package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.appbrand.jsapi.ce;
import com.tencent.mm.protocal.l;

final class b extends o {
    bl.a GQI = new bl.a();
    bl.b GQJ = new bl.b();

    b() {
        AppMethodBeat.i(29757);
        AppMethodBeat.o(29757);
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        return ce.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintticketrsa";
    }

    @Override // com.tencent.mm.network.s
    public final l.e getRespObj() {
        return this.GQJ;
    }

    @Override // com.tencent.mm.ak.o
    public final l.d getReqObjImp() {
        return this.GQI;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final int getOptions() {
        return 1;
    }
}
