package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.p.y;
import com.tencent.mm.protocal.protobuf.esw;
import com.tencent.mm.protocal.protobuf.esx;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    private i callback;
    public d rr;

    public a(int i2, long j2, long j3, String str, int i3) {
        AppMethodBeat.i(125422);
        d.a aVar = new d.a();
        aVar.iLN = new esw();
        aVar.iLO = new esx();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoiphangup";
        aVar.funcId = y.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        esw esw = (esw) this.rr.iLK.iLR;
        esw.MKg = i2;
        esw.NeG = j2;
        esw.Lta = j3;
        esw.Nqu = str;
        esw.KMd = i3;
        esw.MKf = System.currentTimeMillis();
        AppMethodBeat.o(125422);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return y.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(125423);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(125423);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(125424);
        Log.i("MicroMsg.NetSceneVoipCSHangUp", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(125424);
    }
}
