package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.agc;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends q implements m {
    private com.tencent.mm.ak.i callback;
    private final d rr;

    public i(String str) {
        AppMethodBeat.i(20609);
        Log.i("MicroMsg.NetSceneDelTempSession", "NetSceneDelTempSession %s", str);
        d.a aVar = new d.a();
        aVar.iLN = new agb();
        aVar.iLO = new agc();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/deltempsession";
        aVar.funcId = 1067;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        agb agb = (agb) this.rr.iLK.iLR;
        agb.KSV = str;
        agb.Lqr = b.cD(new byte[0]);
        AppMethodBeat.o(20609);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1067;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(20610);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(20610);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20611);
        Log.i("MicroMsg.NetSceneDelTempSession", "onGYNetEnd: %d, %d, %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20611);
    }
}
