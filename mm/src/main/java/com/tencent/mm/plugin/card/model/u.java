package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.sdk.platformtools.Log;

public final class u extends q implements m {
    private i callback;
    private final d rr;

    public u(float f2, float f3, String str, String str2, int i2) {
        AppMethodBeat.i(112818);
        d.a aVar = new d.a();
        aVar.iLN = new dno();
        aVar.iLO = new dnp();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
        aVar.funcId = 1253;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dno dno = (dno) this.rr.iLK.iLR;
        dno.latitude = (double) f2;
        dno.longitude = (double) f3;
        dno.eaO = str;
        dno.pRX = str2;
        dno.MQI = i2;
        AppMethodBeat.o(112818);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1253;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112819);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112819);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112820);
        Log.i("MicroMsg.NetSceneCardReportLocation", "onGYNetEnd, errType = " + i3 + " errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112820);
    }
}
