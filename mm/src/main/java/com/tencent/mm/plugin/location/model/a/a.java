package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    private i callback;
    private Runnable jkz;
    public final d rr;

    public a(String str) {
        AppMethodBeat.i(55785);
        d.a aVar = new d.a();
        aVar.iLN = new aka();
        aVar.iLO = new akb();
        aVar.uri = "/cgi-bin/micromsg-bin/exittrackroom";
        aVar.funcId = com.tencent.mm.plugin.appbrand.jsapi.y.d.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((aka) this.rr.iLK.iLR).Ltk = str;
        Log.d("MicroMsg.NetSceneExitTrackRoom", "trackRoomId:".concat(String.valueOf(str)));
        AppMethodBeat.o(55785);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.y.d.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(55786);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(55786);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(55787);
        Log.d("MicroMsg.NetSceneExitTrackRoom", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        if (this.jkz != null) {
            this.jkz.run();
        }
        AppMethodBeat.o(55787);
    }
}
