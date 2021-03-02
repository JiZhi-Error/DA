package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends q implements m {
    public btx HPJ;
    private i callback;
    private final d rr;

    public k() {
        AppMethodBeat.i(214160);
        d.a aVar = new d.a();
        btw btw = new btw();
        btw.timestamp = cl.aWz();
        aVar.iLN = btw;
        aVar.iLO = new btx();
        aVar.funcId = 2860;
        aVar.uri = "/cgi-bin/mmpay-bin/getreceiptassisplugin";
        this.rr = aVar.aXF();
        AppMethodBeat.o(214160);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2860;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(214161);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(214161);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(214162);
        Log.w("MicroMsg.NetSceneGetReceipAssistPlugin", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.HPJ = (btx) ((d) sVar).iLL.iLR;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(214162);
    }
}
