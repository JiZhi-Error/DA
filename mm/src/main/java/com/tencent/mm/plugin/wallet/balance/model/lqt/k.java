package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dds;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends c<ddt> {
    public int scene;

    public k(int i2, int i3) {
        AppMethodBeat.i(68447);
        d.a aVar = new d.a();
        aVar.iLN = new dds();
        aVar.iLO = new ddt();
        aVar.funcId = 1770;
        aVar.uri = "/cgi-bin/mmpay-bin/preaddplan";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        dds dds = (dds) aXF.iLK.iLR;
        dds.scene = i2;
        dds.Htr = i3;
        c(aXF);
        this.scene = i2;
        Log.i("MicroMsg.CgiLqtPreAddPlan", "scene: %s, planId: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(68447);
    }
}
