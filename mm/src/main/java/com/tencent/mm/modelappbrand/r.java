package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.sdk.platformtools.Log;

public final class r extends q implements m {
    private i heq;
    public final d iIu;

    public r(int i2) {
        AppMethodBeat.i(121056);
        d.a aVar = new d.a();
        aVar.iLN = new bux();
        aVar.iLO = new buy();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iIu = aVar.aXF();
        ((bux) this.iIu.iLK.iLR).Mbn = i2;
        AppMethodBeat.o(121056);
    }

    public final buy aXQ() {
        return (buy) this.iIu.iLL.iLR;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(121057);
        Log.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.heq != null) {
            this.heq.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(121057);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1145;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(121058);
        Log.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.iIu, this);
        AppMethodBeat.o(121058);
        return dispatch;
    }
}
