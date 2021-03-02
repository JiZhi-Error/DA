package com.tencent.mm.plugin.box.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.byc;
import com.tencent.mm.protocal.protobuf.byd;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    private i callback;
    public String dPI;
    private d iUB;
    private long plM;
    public byd plN;

    public a(String str, String str2) {
        AppMethodBeat.i(76328);
        this.dPI = str;
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getweappbox";
        aVar.iLN = new byc();
        aVar.iLO = new byd();
        this.iUB = aVar.aXF();
        ((byc) this.iUB.iLK.iLR).MdD = str2;
        Log.i("MicroMsg.Box.NetSceneBox", "Create NetSceneBox %s %s", str, str2);
        AppMethodBeat.o(76328);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1869;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(76329);
        this.plM = System.currentTimeMillis();
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(76329);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(76330);
        Log.i("MicroMsg.Box.NetSceneBox", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(System.currentTimeMillis() - this.plM));
        this.plN = (byd) this.iUB.iLL.iLR;
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(76330);
    }
}
