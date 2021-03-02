package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.protocal.protobuf.dst;

public final class l extends q implements m {
    public byte[] CXN;
    public dst CXQ;
    private i callback;
    private String dDv;

    public l(String str) {
        this.dDv = str;
    }

    public l(byte[] bArr) {
        this.CXN = bArr;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1169;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(73778);
        this.callback = iVar;
        d.a aVar = new d.a();
        dss dss = new dss();
        dss.dDv = this.dDv;
        if (this.CXN != null) {
            dss.Mcz = z.aC(this.CXN).getBuffer();
        }
        aVar.iLN = dss;
        aVar.iLO = new dst();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        int dispatch = dispatch(gVar, aVar.aXF(), this);
        AppMethodBeat.o(73778);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(73779);
        this.CXQ = (dst) ((d) sVar).iLL.iLR;
        if (this.CXQ.Lqs != null) {
            i4 = this.CXQ.Lqs.dIZ;
            str = this.CXQ.Lqs.dJa;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(73779);
    }
}
