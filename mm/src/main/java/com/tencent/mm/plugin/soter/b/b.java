package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.appbrand.jsapi.ba;
import com.tencent.mm.plugin.soter.b.c;
import com.tencent.mm.protocal.l;

final class b extends o {
    c.a Fho = new c.a();
    c.b Fhp = new c.b();

    b() {
        AppMethodBeat.i(130804);
        AppMethodBeat.o(130804);
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        return ba.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        return "/cgi-bin/micromsg-bin/updatesoteraskrsa";
    }

    @Override // com.tencent.mm.network.s
    public final l.e getRespObj() {
        return this.Fhp;
    }

    @Override // com.tencent.mm.ak.o
    public final l.d getReqObjImp() {
        return this.Fho;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final int getOptions() {
        return 1;
    }
}
