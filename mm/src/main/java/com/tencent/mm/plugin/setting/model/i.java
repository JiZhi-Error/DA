package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bwt;
import com.tencent.mm.protocal.protobuf.bwu;

public final class i extends q implements m {
    public bwu CXM;
    public byte[] CXN;
    private com.tencent.mm.ak.i callback;

    public i(byte[] bArr) {
        this.CXN = bArr;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1146;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(73771);
        this.callback = iVar;
        d.a aVar = new d.a();
        bwt bwt = new bwt();
        if (this.CXN != null) {
            bwt.Mcz = z.aC(this.CXN).getBuffer();
        }
        aVar.iLN = bwt;
        this.CXM = new bwu();
        aVar.iLO = this.CXM;
        aVar.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        int dispatch = dispatch(gVar, aVar.aXF(), this);
        AppMethodBeat.o(73771);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(73772);
        this.CXM = (bwu) ((d) sVar).iLL.iLR;
        if (this.CXM.Lqs != null) {
            i4 = this.CXM.Lqs.dIZ;
            str = this.CXM.Lqs.dJa;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(73772);
    }
}
