package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends q implements m {
    public dap HPG;
    private com.tencent.mm.ak.i callback;
    private final d rr;

    public i() {
        AppMethodBeat.i(69905);
        d.a aVar = new d.a();
        dao dao = new dao();
        dao.timestamp = cl.aWz();
        aVar.iLN = dao;
        aVar.iLO = new dap();
        aVar.funcId = 1820;
        aVar.uri = "/cgi-bin/mmpay-bin/getpayplugin";
        this.rr = aVar.aXF();
        AppMethodBeat.o(69905);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1820;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(69906);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69906);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69907);
        Log.w("MicroMsg.NetSceneGetPayPlugin", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.HPG = (dap) ((d) sVar).iLL.iLR;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(69907);
    }
}
