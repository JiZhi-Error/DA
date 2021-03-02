package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ar;
import com.tencent.mm.protocal.protobuf.as;
import com.tencent.mm.sdk.platformtools.Log;

public final class q extends com.tencent.mm.ak.q implements m {
    private i callback;
    public CardGiftInfo pUb;
    private final d rr;

    public q(int i2, String str, String str2, Boolean bool) {
        AppMethodBeat.i(112805);
        d.a aVar = new d.a();
        aVar.iLN = new ar();
        aVar.iLO = new as();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptgiftcard";
        aVar.funcId = 1136;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ar arVar = (ar) this.rr.iLK.iLR;
        arVar.KDl = i2;
        arVar.KDm = str;
        arVar.KDn = str2;
        arVar.KDo = bool.booleanValue();
        AppMethodBeat.o(112805);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112806);
        Log.i("MicroMsg.NetSceneAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.pUb = CardGiftInfo.a((as) this.rr.iLL.iLR);
            Log.d("MicroMsg.NetSceneAcceptGiftCard", "%s", this.pUb.toString());
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112806);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1136;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112807);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112807);
        return dispatch;
    }
}
