package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.xl;
import com.tencent.mm.protocal.protobuf.xm;

public final class a extends c<xm> {
    public a(String str, String str2) {
        AppMethodBeat.i(213301);
        xl xlVar = new xl();
        d.a aVar = new d.a();
        aVar.iLN = xlVar;
        aVar.iLO = new xm();
        aVar.funcId = 4193;
        aVar.uri = "/cgi-bin/micromsg-bin/checkandusetimelimitpromo";
        xlVar.iwu = str;
        xlVar.signature = str2;
        c(aVar.aXF());
        AppMethodBeat.o(213301);
    }
}
