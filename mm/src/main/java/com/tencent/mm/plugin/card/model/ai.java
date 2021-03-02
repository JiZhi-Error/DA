package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.protocal.protobuf.dnr;
import com.tencent.mm.sdk.platformtools.Log;

public final class ai extends q implements m {
    private i callback;
    private final d rr;

    public ai(String str, byte[] bArr, float f2, float f3, float f4, boolean z, boolean z2) {
        AppMethodBeat.i(112861);
        d.a aVar = new d.a();
        aVar.iLN = new dnq();
        aVar.iLO = new dnr();
        aVar.uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
        aVar.funcId = 2574;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dnq dnq = (dnq) this.rr.iLK.iLR;
        dnq.eaO = str;
        dnq.MQK = b.cD(bArr);
        dnq.dTj = f2;
        dnq.latitude = f3;
        dnq.MQJ = f4;
        dnq.MQL = z;
        dnq.MQM = z2;
        AppMethodBeat.o(112861);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2574;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112862);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112862);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112863);
        Log.i("MicroMsg.NetSceneReportLotionOrBluetoothInfo", "onGYNetEnd, errType = " + i3 + " errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112863);
    }
}
