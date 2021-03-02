package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.bur;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    private i callback;
    public bur kiN;
    private d rr;

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(125514);
        if (!(i3 == 0 && i4 == 0)) {
            Log.e("MicroMsg.NetSceneGetSafetyInfo", "errType:%d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        }
        this.kiN = (bur) ((d) sVar).iLL.iLR;
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(125514);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 850;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(125515);
        d.a aVar = new d.a();
        aVar.iLN = new buq();
        aVar.iLO = new bur();
        aVar.uri = "/cgi-bin/micromsg-bin/getsafetyinfo";
        aVar.funcId = 850;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(125515);
        return dispatch;
    }
}
