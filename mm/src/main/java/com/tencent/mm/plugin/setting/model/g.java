package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends q implements m {
    public btz CXL;
    private i callback;
    private final d rr;

    public g() {
        AppMethodBeat.i(256459);
        d.a aVar = new d.a();
        aVar.iLN = new bty();
        aVar.iLO = new btz();
        aVar.funcId = 2745;
        aVar.uri = "/cgi-bin/mmpay-bin/getreceiptassisstatus";
        this.rr = aVar.aXF();
        AppMethodBeat.o(256459);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2745;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(256460);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(256460);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(256461);
        Log.w("MicroMsg.NetSceneGetReceipAssistStatus", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.CXL = (btz) ((d) sVar).iLL.iLR;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(256461);
    }
}
