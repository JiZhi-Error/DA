package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    private i callback;
    private String eaO = "";
    public int pTZ;
    private final d rr;

    public a(String str) {
        AppMethodBeat.i(112954);
        d.a aVar = new d.a();
        aVar.iLN = new afz();
        aVar.iLO = new aga();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
        aVar.funcId = 1163;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((afz) this.rr.iLK.iLR).eaO = str;
        this.eaO = str;
        AppMethodBeat.o(112954);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112955);
        Log.i("MicroMsg.NetSceneDelShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(getType()), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            aga aga = (aga) this.rr.iLL.iLR;
            Log.i("MicroMsg.NetSceneDelShareCard", "ret_code:" + aga.pTZ);
            this.pTZ = aga.pTZ;
            if (this.pTZ == 0) {
                am.ctY().ajz(this.eaO);
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112955);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1163;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112956);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112956);
        return dispatch;
    }
}
