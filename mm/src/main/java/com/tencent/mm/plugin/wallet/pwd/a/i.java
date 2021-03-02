package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends q implements m {
    private dij HIm;
    private com.tencent.mm.ak.i callback;
    private final d rr;

    public i() {
        AppMethodBeat.i(69547);
        d.a aVar = new d.a();
        dii dii = new dii();
        dii.KBz = System.currentTimeMillis();
        aVar.iLN = dii;
        aVar.iLO = new dij();
        aVar.uri = "/cgi-bin/mmpay-bin/querywalletentrancebalanceswitchstate";
        aVar.funcId = 2635;
        this.rr = aVar.aXF();
        AppMethodBeat.o(69547);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2635;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(69548);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69548);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69549);
        Log.w("MicroMsg.NetSceneQueryWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.HIm = (dij) ((d) sVar).iLL.iLR;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(69549);
    }

    public final dij fOO() {
        AppMethodBeat.i(69550);
        if (this.HIm == null) {
            dij dij = new dij();
            AppMethodBeat.o(69550);
            return dij;
        }
        dij dij2 = this.HIm;
        AppMethodBeat.o(69550);
        return dij2;
    }
}
