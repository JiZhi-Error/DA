package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agi;
import com.tencent.mm.protocal.protobuf.agj;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    private i callback;
    private final d rr;

    public a(String str) {
        AppMethodBeat.i(90685);
        d.a aVar = new d.a();
        aVar.iLN = new agi();
        aVar.iLO = new agj();
        aVar.uri = "/cgi-bin/micromsg-bin/deletecardimg";
        aVar.funcId = 576;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((agi) this.rr.iLK.iLR).Lqx = str;
        AppMethodBeat.o(90685);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 576;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(90686);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(90686);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(90687);
        Log.d("MicroMsg.NetSceneDeleteCardImg", "onGYNetEnd:%s, %s", Integer.valueOf(i3), Integer.valueOf(i4));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(90687);
    }
}
