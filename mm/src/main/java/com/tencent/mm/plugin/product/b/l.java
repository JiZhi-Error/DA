package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.eew;
import com.tencent.mm.protocal.protobuf.eex;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class l extends w implements m {
    public String AZw;
    private i callback;
    private d rr;

    public l(dyy dyy, String str) {
        AppMethodBeat.i(66906);
        d.a aVar = new d.a();
        aVar.iLN = new eew();
        aVar.iLO = new eex();
        aVar.uri = "/cgi-bin/micromsg-bin/submitmallorder";
        aVar.funcId = 556;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        eew eew = (eew) this.rr.iLK.iLR;
        eew.NeQ = dyy;
        eew.NeS = str;
        AppMethodBeat.o(66906);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 556;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(66907);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(66907);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(66908);
        eex eex = (eex) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneMallSubmitMallOrder", "resp.ReqKey " + eex.NeR);
            this.AZw = eex.NeR;
        }
        Log.d("MicroMsg.NetSceneMallSubmitMallOrder", "errCode " + i4 + ", errMsg " + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(66908);
    }
}
