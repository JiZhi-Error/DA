package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.bor;

public final class g extends c {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void dNu() {
        AppMethodBeat.i(24857);
        d.a aVar = new d.a();
        aVar.iLN = new boq();
        aVar.iLO = new bor();
        aVar.uri = "/cgi-bin/mmo2o-bin/getprotocol31schemaurl";
        aVar.funcId = 1746;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(24857);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1746;
    }

    public g(String str, String str2, String str3) {
        AppMethodBeat.i(24858);
        dNu();
        boq boq = (boq) this.rr.iLK.iLR;
        boq.wOK = str;
        boq.wOL = str2;
        boq.wOM = str3;
        boq.KCP = m.dMM();
        AppMethodBeat.o(24858);
    }

    public final String dNC() {
        return ((bor) this.rr.iLL.iLR).LWQ;
    }
}
