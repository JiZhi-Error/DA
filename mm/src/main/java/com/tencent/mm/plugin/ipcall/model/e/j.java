package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ewm;
import com.tencent.mm.protocal.protobuf.ewn;
import com.tencent.mm.sdk.platformtools.Log;

public final class j extends q implements m {
    private i callback = null;
    private d rr = null;
    public ewm yrG = null;
    public ewn yrH = null;

    public j(String str) {
        AppMethodBeat.i(25478);
        d.a aVar = new d.a();
        aVar.iLN = new ewm();
        aVar.iLO = new ewn();
        aVar.funcId = 277;
        aVar.uri = "/cgi-bin/micromsg-bin/wcopurchasepackage";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.yrG = (ewm) this.rr.iLK.iLR;
        this.yrG.ProductID = str;
        Log.i("MicroMsg.NetSceneIPCallPurchasePackage", "NetSceneIPCallPurchasePackage ProductID:%s", this.yrG.ProductID);
        AppMethodBeat.o(25478);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 277;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(25479);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(25479);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(25480);
        Log.i("MicroMsg.NetSceneIPCallPurchasePackage", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.yrH = (ewn) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(25480);
    }
}
