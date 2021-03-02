package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.bsu;
import com.tencent.mm.protocal.protobuf.bsv;

public final class i extends c {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void dNu() {
        AppMethodBeat.i(24861);
        d.a aVar = new d.a();
        aVar.iLN = new bsu();
        aVar.iLO = new bsv();
        aVar.uri = "/cgi-bin/mmo2o-bin/getportalapinfo";
        aVar.funcId = 1709;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(24861);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1709;
    }

    public i(String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(24862);
        dNu();
        bsu bsu = (bsu) this.rr.iLK.iLR;
        bsu.dFd = str;
        bsu.wOK = str2;
        bsu.wOL = str3;
        bsu.wOM = str4;
        bsu.dHx = str5;
        bsu.KCy = str6;
        AppMethodBeat.o(24862);
    }

    public final String dND() {
        return ((bsv) this.rr.iLL.iLR).wPO;
    }

    public final String dNE() {
        return ((bsv) this.rr.iLL.iLR).extend;
    }
}
