package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ao;
import com.tencent.mm.protocal.protobuf.ap;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class p extends q implements m {
    private i callback;
    public String pTY;
    public int pTZ;
    public String pUa;
    private final d rr;

    public p(LinkedList<um> linkedList, int i2, String str, String str2, int i3) {
        AppMethodBeat.i(112802);
        d.a aVar = new d.a();
        aVar.iLN = new ao();
        aVar.iLO = new ap();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
        aVar.funcId = 1049;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ao aoVar = (ao) this.rr.iLK.iLR;
        aoVar.KDk = linkedList;
        aoVar.eaQ = i2;
        aoVar.KDg = str;
        aoVar.KDf = str2;
        aoVar.KDh = i3;
        AppMethodBeat.o(112802);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1049;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112803);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112803);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112804);
        Log.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i3 + " errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            ap apVar = (ap) this.rr.iLL.iLR;
            this.pTY = apVar.pTY;
            this.pTZ = apVar.pTZ;
            this.pUa = apVar.pUa;
            Log.e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.pTZ + " ret_msg = " + this.pUa);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112804);
    }
}
