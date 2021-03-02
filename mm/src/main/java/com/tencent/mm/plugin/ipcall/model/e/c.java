package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private i callback = null;
    private d rr = null;
    private bxs yrr = null;
    public bxt yrs = null;

    public c() {
        AppMethodBeat.i(25457);
        d.a aVar = new d.a();
        aVar.iLN = new bxs();
        aVar.iLO = new bxt();
        aVar.funcId = 746;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcocallinfo";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.yrr = (bxs) this.rr.iLK.iLR;
        Log.i("MicroMsg.NetSceneIPCallGetCallInfo", "NetSceneIPCallGetCallInfo");
        AppMethodBeat.o(25457);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 746;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(25458);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(25458);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(25459);
        Log.i("MicroMsg.NetSceneIPCallGetCallInfo", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.yrs = (bxt) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(25459);
    }
}
