package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.am;
import com.tencent.mm.protocal.protobuf.an;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.sdk.platformtools.Log;

public final class o extends q implements m {
    private i callback;
    public String pTY;
    public int pTZ;
    public String pUa;
    private final d rr;

    public o(String str, int i2, String str2, String str3, String str4, String str5, int i3, int i4, eck eck) {
        AppMethodBeat.i(112799);
        d.a aVar = new d.a();
        aVar.iLN = new am();
        aVar.iLO = new an();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptcarditem";
        aVar.funcId = 1037;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        am amVar = (am) this.rr.iLK.iLR;
        amVar.eaO = str;
        amVar.pPy = str2;
        amVar.eaQ = i2;
        amVar.eaP = str3;
        amVar.KDg = str4;
        amVar.KDf = str5;
        amVar.KDh = i3;
        amVar.KDi = i4;
        amVar.KDj = eck;
        AppMethodBeat.o(112799);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1037;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112800);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112800);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112801);
        Log.i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + i3 + " errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            an anVar = (an) this.rr.iLL.iLR;
            if (anVar != null) {
                this.pTY = anVar.pTY;
                this.pTZ = anVar.pTZ;
                this.pUa = anVar.pUa;
            }
        } else {
            an anVar2 = (an) this.rr.iLL.iLR;
            if (anVar2 != null) {
                this.pTY = anVar2.pTY;
                this.pTZ = anVar2.pTZ;
                this.pUa = anVar2.pUa;
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112801);
    }
}
