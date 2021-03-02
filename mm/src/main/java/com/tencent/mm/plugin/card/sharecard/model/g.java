package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dxe;
import com.tencent.mm.protocal.protobuf.dxf;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.protocal.protobuf.dxy;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class g extends q implements m {
    private i callback;
    public String pTY;
    public int pTZ;
    public String pUa;
    private final d rr;

    public g(int i2, LinkedList<dxg> linkedList, String str, String str2, dxy dxy, int i3, eck eck) {
        AppMethodBeat.i(112972);
        d.a aVar = new d.a();
        aVar.iLN = new dxe();
        aVar.iLO = new dxf();
        aVar.uri = "/cgi-bin/micromsg-bin/sharecarditem";
        aVar.funcId = 902;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dxe dxe = (dxe) this.rr.iLK.iLR;
        dxe.MXj = i2;
        dxe.iAd = linkedList;
        dxe.gTT = str;
        dxe.LTz = str2;
        Log.i("MicroMsg.NetSceneShareCardItem", "list length is " + linkedList.size());
        dxe.MXk = dxy;
        dxe.eaQ = i3;
        dxe.KDj = eck;
        AppMethodBeat.o(112972);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112973);
        Log.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(getType()), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
            dxf dxf = (dxf) this.rr.iLL.iLR;
            if (dxf != null) {
                this.pTY = dxf.pTY;
                this.pTZ = dxf.pTZ;
                this.pUa = dxf.pUa;
            }
        } else {
            dxf dxf2 = (dxf) this.rr.iLL.iLR;
            if (dxf2 != null) {
                this.pTY = dxf2.pTY;
                this.pTZ = dxf2.pTZ;
                this.pUa = dxf2.pUa;
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112973);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 902;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(112974);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112974);
        return dispatch;
    }
}
