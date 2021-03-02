package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.sdk.platformtools.Log;

public final class aa extends q implements m {
    private i callback;
    public String pTY;
    private final d rr;

    public aa(String str, int i2, String str2, String str3, String str4, String str5, int i3, String str6, eck eck) {
        AppMethodBeat.i(112837);
        d.a aVar = new d.a();
        aVar.iLN = new bkj();
        aVar.iLO = new bkk();
        aVar.uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
        aVar.funcId = 1057;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bkj bkj = (bkj) this.rr.iLK.iLR;
        bkj.eaO = str;
        bkj.eaQ = i2;
        bkj.pPy = str2;
        bkj.eaP = str3;
        bkj.KDg = str4;
        bkj.KDf = str5;
        bkj.KDh = i3;
        bkj.LTz = str6;
        bkj.KDj = eck;
        AppMethodBeat.o(112837);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1057;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112838);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112838);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112839);
        Log.i("MicroMsg.NetSceneGetCardItemInfo", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            this.pTY = ((bkk) this.rr.iLL.iLR).pTY;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112839);
    }
}
