package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.etd;
import com.tencent.mm.protocal.protobuf.ete;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends q implements m {
    private i callback;
    public com.tencent.mm.ak.d rr;

    public d(long j2, long j3) {
        AppMethodBeat.i(125431);
        d.a aVar = new d.a();
        aVar.iLN = new etd();
        aVar.iLO = new ete();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipredirect";
        aVar.funcId = com.tencent.mm.plugin.appbrand.jsapi.pay.q.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        etd etd = (etd) this.rr.iLK.iLR;
        etd.NeG = j2;
        etd.Lta = j3;
        etd.MKf = System.currentTimeMillis();
        AppMethodBeat.o(125431);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(125432);
        Log.i("MicroMsg.NetSceneVoipCSRedirect", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(125432);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.pay.q.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(125433);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(125433);
        return dispatch;
    }
}
