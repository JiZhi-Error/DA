package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dum;
import com.tencent.mm.protocal.protobuf.dun;

public final class am extends q implements m {
    private i callback;
    private final d rr;

    public am(String str) {
        AppMethodBeat.i(131142);
        d.a aVar = new d.a();
        aVar.iLN = new dum();
        aVar.iLO = new dun();
        aVar.uri = "/cgi-bin/micromsg-bin/sendverifyemail";
        aVar.funcId = 108;
        aVar.iLP = 43;
        aVar.respCmdId = 1000000043;
        this.rr = aVar.aXF();
        ((dum) this.rr.iLK.iLR).Lqk = new dqi().bhy(str);
        AppMethodBeat.o(131142);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(131143);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(131143);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 108;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(131144);
        updateDispatchId(i2);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131144);
    }
}
