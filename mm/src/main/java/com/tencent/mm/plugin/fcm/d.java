package com.tencent.mm.plugin.fcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.bx;
import com.tencent.mm.protocal.protobuf.ee;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends q implements m {
    private i callback;
    private final com.tencent.mm.ak.d rr;

    public d(String str) {
        AppMethodBeat.i(127578);
        d.a aVar = new d.a();
        aVar.iLN = new ee();
        aVar.iLO = new ef();
        aVar.uri = "/cgi-bin/micromsg-bin/androidfcmunreg";
        aVar.funcId = 1059;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((ee) this.rr.iLK.iLR).KCv = str;
        AppMethodBeat.o(127578);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return bx.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(127579);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(127579);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(127580);
        Log.i("MicroMsg.FCM.NetSceneFcmUnreg", "onGYNetEnd, errType = " + i3 + " errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(127580);
    }
}
