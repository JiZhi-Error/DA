package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjx;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.sdk.platformtools.Log;

public final class o extends q implements m {
    private i callback = null;
    d rr = null;

    public o() {
        AppMethodBeat.i(23391);
        d.a aVar = new d.a();
        aVar.iLN = new bjx();
        aVar.iLO = new bjy();
        aVar.uri = "/cgi-bin/micromsg-bin/getboundharddevices";
        aVar.funcId = 539;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((bjx) this.rr.iLK.iLR).Version = 1;
        AppMethodBeat.o(23391);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23392);
        Log.i("MicroMsg.exdevice.NetSceneGetBoundHardDevices", "onGYNetEnd netId = " + i2 + " errType = " + i3 + " errCode = " + i4 + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23392);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 539;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23393);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23393);
        return dispatch;
    }
}
