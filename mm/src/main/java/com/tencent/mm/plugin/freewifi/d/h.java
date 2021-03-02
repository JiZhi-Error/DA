package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.protocal.protobuf.bsm;
import com.tencent.mm.protocal.protobuf.bsn;

public final class h extends c {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void dNu() {
        AppMethodBeat.i(24859);
        d.a aVar = new d.a();
        aVar.iLN = new bsm();
        aVar.iLO = new bsn();
        aVar.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
        aVar.funcId = 1760;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(24859);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1760;
    }

    public h(String str, int i2, String str2) {
        AppMethodBeat.i(24860);
        dNu();
        bsm bsm = (bsm) this.rr.iLK.iLR;
        bsm.appId = str;
        bsm.wSx = i2;
        bsm.dHx = str2;
        AppMethodBeat.o(24860);
    }

    public final bfr dNy() {
        bsn bsn = (bsn) this.rr.iLL.iLR;
        if (bsn != null) {
            return bsn.KCJ;
        }
        return null;
    }
}
