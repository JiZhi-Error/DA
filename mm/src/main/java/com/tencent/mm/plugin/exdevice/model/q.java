package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.bvo;
import com.tencent.mm.sdk.platformtools.Log;

public final class q extends com.tencent.mm.ak.q implements m {
    private i callback = null;
    public d rr = null;

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23396);
        Log.i("MicroMsg.exdevice.NetSceneGetSportDeviceList", "onGYNetEnd netId = " + i2 + " errType = " + i3 + " errCode = " + i4 + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23396);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1267;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23397);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new bvn();
        aVar.iLO = new bvo();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/getsportdevicelist";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23397);
        return dispatch;
    }
}
