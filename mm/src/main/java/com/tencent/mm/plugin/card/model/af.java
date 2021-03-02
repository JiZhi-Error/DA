package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.bzn;
import com.tencent.mm.sdk.platformtools.Log;

public final class af extends q implements m {
    private i callback;
    public String eaP;
    public int pTZ;
    public String pUa;
    private final d rr;

    public af(String str, String str2, int i2) {
        AppMethodBeat.i(112852);
        d.a aVar = new d.a();
        aVar.iLN = new bzm();
        aVar.iLO = new bzn();
        aVar.uri = "/cgi-bin/micromsg-bin/giftcarditem";
        aVar.funcId = 1045;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bzm bzm = (bzm) this.rr.iLK.iLR;
        bzm.eaO = str;
        bzm.pPz = str2;
        bzm.Mfg = i2;
        AppMethodBeat.o(112852);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1045;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112853);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112853);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112854);
        Log.i("MicroMsg.NetSceneGiftCardItem", "onGYNetEnd, errType = " + i3 + " errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            bzn bzn = (bzn) this.rr.iLL.iLR;
            if (bzn != null) {
                this.eaP = bzn.eaP;
                this.pUa = bzn.pUa;
                this.pTZ = bzn.pTZ;
            }
        } else {
            bzn bzn2 = (bzn) this.rr.iLL.iLR;
            if (bzn2 != null) {
                this.eaP = bzn2.eaP;
                this.pUa = bzn2.pUa;
                this.pTZ = bzn2.pTZ;
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112854);
    }
}
