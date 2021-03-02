package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqn;
import com.tencent.mm.protocal.protobuf.cqo;
import com.tencent.mm.protocal.protobuf.eov;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d extends q implements m {
    private i callback;
    private final com.tencent.mm.ak.d rr;
    private LinkedList<eov> yBV = new LinkedList<>();

    public d(LinkedList<eov> linkedList) {
        AppMethodBeat.i(26152);
        d.a aVar = new d.a();
        aVar.iLN = new cqn();
        aVar.iLO = new cqo();
        aVar.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
        aVar.funcId = 638;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.yBV = linkedList;
        AppMethodBeat.o(26152);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(26153);
        Log.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(26153);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 638;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(26154);
        Log.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
        this.callback = iVar;
        cqn cqn = (cqn) this.rr.iLK.iLR;
        cqn.Mwq = this.yBV;
        cqn.LUu = this.yBV.size();
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(26154);
        return dispatch;
    }
}
