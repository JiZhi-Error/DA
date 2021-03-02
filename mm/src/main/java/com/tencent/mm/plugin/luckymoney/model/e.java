package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.bwd;
import com.tencent.mm.protocal.protobuf.bwe;

public final class e extends c<bwe> {
    public e(String str) {
        AppMethodBeat.i(213302);
        bwd bwd = new bwd();
        d.a aVar = new d.a();
        aVar.iLN = bwd;
        aVar.iLO = new bwe();
        aVar.funcId = 5952;
        aVar.uri = "/cgi-bin/micromsg-bin/gettimelimitpromo";
        bwd.iwu = str;
        c(aVar.aXF());
        AppMethodBeat.o(213302);
    }
}
