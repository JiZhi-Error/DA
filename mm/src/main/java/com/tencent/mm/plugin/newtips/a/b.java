package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dgf;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    boolean ACX = false;
    int ACY = 0;
    private i callback;
    private d rr;

    @Deprecated
    public b(int i2, int i3, String str) {
        AppMethodBeat.i(188557);
        d.a aVar = new d.a();
        aVar.iLN = new dgf();
        aVar.iLO = new dgg();
        aVar.uri = "/cgi-bin/micromsg-bin/pushnewtips";
        aVar.funcId = 597;
        this.rr = aVar.aXF();
        dgf dgf = (dgf) this.rr.iLK.iLR;
        dgf.MKR = i2;
        dgf.MKS = 1;
        dgf.xMX = str;
        this.ACY = i2;
        AppMethodBeat.o(188557);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(127210);
        if (i3 == 0 && i4 == 0) {
            this.ACX = ((dgg) ((d) sVar).iLL.iLR).MKT;
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(127210);
            return;
        }
        Log.e("MicroMsg.NetScenePushCompatNewTips", "errType:" + i3 + " errCode:" + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(127210);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 597;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(127211);
        Log.d("MicroMsg.NetScenePushCompatNewTips", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(127211);
        return dispatch;
    }
}
