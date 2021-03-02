package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.protocal.protobuf.dav;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class a extends w {
    private i callback;
    public d rr;

    public a(int i2) {
        AppMethodBeat.i(72056);
        d.a aVar = new d.a();
        aVar.iLN = new dau();
        aVar.iLO = new dav();
        aVar.uri = "/cgi-bin/mmpay-bin/payubatchuserroll";
        aVar.funcId = 1519;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dau dau = (dau) this.rr.iLK.iLR;
        dau.xLW = 10;
        dau.KZk = i2;
        Log.d("MicroMsg.NetScenePayUPayQueryUserRoll", "limit:10,offset:" + i2);
        AppMethodBeat.o(72056);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(72057);
        Log.w("MicroMsg.NetScenePayUPayQueryUserRoll", "errType = " + i3 + " errCode " + i4 + " errMsg " + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetScenePayUPayQueryUserRoll", "rr" + ((dav) ((d) sVar).iLL.iLR).MFY);
        }
        AppMethodBeat.o(72057);
    }

    public final int fUC() {
        return ((dav) this.rr.iLL.iLR).MFY;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1519;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(72058);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(72058);
        return dispatch;
    }
}
