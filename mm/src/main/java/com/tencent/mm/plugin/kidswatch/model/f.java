package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cgp;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends q implements m {
    private i callback;
    private final d iUB;

    public f(String str, String str2) {
        AppMethodBeat.i(256401);
        d.a aVar = new d.a();
        cgp cgp = new cgp();
        cgq cgq = new cgq();
        aVar.iLN = cgp;
        aVar.iLO = cgq;
        aVar.uri = "/cgi-bin/micromsg-bin/kidswatchloginconfirmget";
        aVar.funcId = 5218;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iUB = aVar.aXF();
        cgp.LtA = str;
        cgp.oTI = str2;
        Log.d("MicroMsg.NetSceneKidsWatchLoginConfirmGet", "[NetSceneKidsWatchLoginConfirmGet]loginUrl:%s, deviceName:%s", str, str2);
        AppMethodBeat.o(256401);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5218;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(256402);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(256402);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(256403);
        Log.d("MicroMsg.NetSceneKidsWatchLoginConfirmGet", "onGYNetEnd  errType:" + i3 + " errCode:" + i4 + " errMsg:" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(256403);
    }

    public final cgq ebU() {
        return (cgq) this.iUB.iLL.iLR;
    }
}
