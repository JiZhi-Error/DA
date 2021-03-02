package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dwi;
import com.tencent.mm.protocal.protobuf.dwj;

public final class l extends c {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void dNu() {
        AppMethodBeat.i(24868);
        d.a aVar = new d.a();
        aVar.iLN = new dwi();
        aVar.iLO = new dwj();
        aVar.uri = "/cgi-bin/mmo2o-bin/setpcloginuserInfo";
        aVar.funcId = 1761;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(24868);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1761;
    }

    public l(String str, int i2, String str2) {
        AppMethodBeat.i(24869);
        dNu();
        dwi dwi = (dwi) this.rr.iLK.iLR;
        dwi.appId = str;
        dwi.wSx = i2;
        dwi.dHx = str2;
        AppMethodBeat.o(24869);
    }
}
