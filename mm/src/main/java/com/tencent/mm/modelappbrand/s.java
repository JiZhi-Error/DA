package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.fex;
import com.tencent.mm.protocal.protobuf.fey;
import com.tencent.mm.sdk.platformtools.Log;

public final class s extends q implements m {
    private i heq;
    private final d iIu;

    public s(String str) {
        AppMethodBeat.i(121059);
        d.a aVar = new d.a();
        aVar.iLN = new fex();
        aVar.iLO = new fey();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iIu = aVar.aXF();
        ((fex) this.iIu.iLK.iLR).NAm = str;
        AppMethodBeat.o(121059);
    }

    public final fey aXR() {
        if (this.iIu != null) {
            return (fey) this.iIu.iLL.iLR;
        }
        return null;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1198;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(121060);
        Log.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.heq != null) {
            this.heq.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(121060);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(121061);
        Log.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.iIu, this);
        AppMethodBeat.o(121061);
        return dispatch;
    }
}
