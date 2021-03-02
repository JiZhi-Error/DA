package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.sdk.platformtools.Log;

public final class z extends q implements m {
    private i callback;
    public CardGiftInfo pUb;
    private final d rr;

    public z(int i2, String str) {
        AppMethodBeat.i(112834);
        d.a aVar = new d.a();
        aVar.iLN = new bkh();
        aVar.iLO = new bki();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardgiftinfo";
        aVar.funcId = 1165;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bkh bkh = (bkh) this.rr.iLK.iLR;
        bkh.KDl = i2;
        bkh.KDm = str;
        AppMethodBeat.o(112834);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112835);
        Log.i("MicroMsg.NetSceneGetCardGiftInfo", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.pUb = CardGiftInfo.a((bki) this.rr.iLL.iLR);
            Log.d("MicroMsg.NetSceneGetCardGiftInfo", "%s", this.pUb.toString());
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112835);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1165;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112836);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112836);
        return dispatch;
    }
}
