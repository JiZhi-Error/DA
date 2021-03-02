package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.share.c;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.protocal.protobuf.esz;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    private i callback;
    private d rr;

    public b(long j2, long j3) {
        AppMethodBeat.i(125425);
        d.a aVar = new d.a();
        aVar.iLN = new esy();
        aVar.iLO = new esz();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipheartbeat";
        aVar.funcId = c.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        esy esy = (esy) this.rr.iLK.iLR;
        esy.NeG = j2;
        esy.Lta = j3;
        esy.MKf = System.currentTimeMillis();
        AppMethodBeat.o(125425);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(125426);
        Log.i("MicroMsg.NetSceneVoipCSHeartBeat", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(125426);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return c.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(125427);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(125427);
        return dispatch;
    }
}
