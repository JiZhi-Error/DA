package com.tencent.mm.plugin.fcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ec;
import com.tencent.mm.protocal.protobuf.ed;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private i callback;
    private final d rr;

    public c(String str) {
        AppMethodBeat.i(127575);
        d.a aVar = new d.a();
        aVar.iLN = new ec();
        aVar.iLO = new ed();
        aVar.uri = "/cgi-bin/micromsg-bin/androidfcmreg";
        aVar.funcId = 216;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ec ecVar = (ec) this.rr.iLK.iLR;
        ecVar.KCv = str;
        ecVar.xIV = 1;
        AppMethodBeat.o(127575);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 216;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(127576);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(127576);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(127577);
        Log.i("MicroMsg.FCM.NetSceneFcmReg", "onGYNetEnd, errType = " + i3 + " errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(127577);
    }
}
