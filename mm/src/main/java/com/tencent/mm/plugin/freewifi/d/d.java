package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.yq;
import com.tencent.mm.protocal.protobuf.yr;

public final class d extends c {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void dNu() {
        AppMethodBeat.i(24848);
        d.a aVar = new d.a();
        aVar.iLN = new yq();
        aVar.iLO = new yr();
        aVar.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(24848);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1155;
    }

    public d(String str, String str2, String str3, String str4, String str5, long j2, String str6, String str7) {
        AppMethodBeat.i(24849);
        dNu();
        yq yqVar = (yq) this.rr.iLK.iLR;
        yqVar.LjI = str;
        yqVar.LjJ = str2;
        yqVar.LjK = str3;
        yqVar.LjL = str4;
        yqVar.LjM = str5;
        yqVar.LjN = j2;
        yqVar.LjO = str6;
        yqVar.LjP = str7;
        AppMethodBeat.o(24849);
    }

    public final yr dNA() {
        return (yr) this.rr.iLL.iLR;
    }
}
