package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.protocal.protobuf.buf;

public final class f extends c<buf> {
    public f(String str) {
        AppMethodBeat.i(163540);
        bue bue = new bue();
        d.a aVar = new d.a();
        aVar.iLN = bue;
        aVar.iLO = new buf();
        aVar.funcId = 3858;
        aVar.uri = "/cgi-bin/micromsg-bin/getredpacketpreview";
        bue.url = str;
        c(aVar.aXF());
        AppMethodBeat.o(163540);
    }
}
