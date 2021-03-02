package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.protocal.protobuf.zs;
import com.tencent.mm.protocal.protobuf.zt;
import java.util.LinkedList;

public final class a extends c<zt> {
    public a(LinkedList<zr> linkedList, int i2, String str) {
        AppMethodBeat.i(6200);
        d.a aVar = new d.a();
        aVar.funcId = 2731;
        aVar.uri = "/cgi-bin/mmbiz-bin/checktmplver";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        zs zsVar = new zs();
        zsVar.Scene = i2;
        zsVar.pLm = str;
        zsVar.LkZ = linkedList;
        aVar.iLN = zsVar;
        aVar.iLO = new zt();
        c(aVar.aXF());
        AppMethodBeat.o(6200);
    }
}
