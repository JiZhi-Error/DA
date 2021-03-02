package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.vq;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.sdk.platformtools.Log;

public final class m extends q implements com.tencent.mm.network.m {
    public vr CoI;
    private vq CoJ = ((vq) this.rr.iLK.iLR);
    private i callback;
    private final d rr;

    public m(String str, String str2) {
        AppMethodBeat.i(213730);
        d.a aVar = new d.a();
        aVar.iLN = new vq();
        aVar.iLO = new vr();
        aVar.funcId = 2850;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fminiprogramconfirmrcvr";
        this.rr = aVar.aXF();
        this.CoJ.Cqr = str;
        this.CoJ.dNI = str2;
        AppMethodBeat.o(213730);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2850;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(213731);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(213731);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(213732);
        Log.i("MicroMsg.NetSceneF2FMinniProgramConfirm", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.CoI = (vr) ((d) sVar).iLL.iLR;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(213732);
    }
}
