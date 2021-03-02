package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.djp;
import com.tencent.mm.protocal.protobuf.djq;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends q implements m {
    private i callback;
    private d rr;

    public g(int i2) {
        AppMethodBeat.i(20783);
        d.a aVar = new d.a();
        aVar.iLN = new djp();
        aVar.iLO = new djq();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfotouch";
        aVar.funcId = 419;
        aVar.iLP = 204;
        aVar.respCmdId = 1000000204;
        this.rr = aVar.aXF();
        ((djp) this.rr.iLK.iLR).id = i2;
        AppMethodBeat.o(20783);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20784);
        Log.d("MicroMsg.NetSceneRcptInfoTouch", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        if (i3 == 0 && i4 == 0) {
            djq djq = (djq) ((d) sVar).iLL.iLR;
            if (djq.MNs.MNv != null) {
                Log.d("MicroMsg.NetSceneRcptInfoTouch", "resp.rImpl.rcptinfolist.rcptinfolist " + djq.MNs.MNv.size());
                a.bqb();
                a.bqd().t(djq.MNs.MNv);
                a.bqb();
                a.bqd().bqf();
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20784);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 419;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(20785);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(20785);
        return dispatch;
    }
}
