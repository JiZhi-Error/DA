package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.ber;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private i callback;
    public String dSf;
    public String rjt;
    public d rr;

    public c(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(67101);
        this.dSf = str2;
        this.rjt = str3;
        d.a aVar = new d.a();
        aVar.iLN = new beq();
        aVar.iLO = new ber();
        aVar.uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
        aVar.funcId = 1555;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        beq beq = (beq) this.rr.iLK.iLR;
        beq.LOs = str;
        beq.KPP = str2;
        beq.APy = str3;
        beq.LOt = str4;
        beq.LOu = str5;
        beq.Bri = com.tencent.mm.plugin.wallet_core.model.mall.c.fSg().aVu(str);
        AppMethodBeat.o(67101);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(67102);
        Log.d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + i4 + ", errMsg " + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(67102);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1555;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67103);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67103);
        return dispatch;
    }
}
