package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ae extends q implements m {
    private i callback;
    private d rr;

    public ae(LinkedList<dna> linkedList) {
        AppMethodBeat.i(124143);
        d.a aVar = new d.a();
        aVar.iLN = new dnb();
        aVar.iLO = new dnc();
        aVar.uri = "/cgi-bin/micromsg-bin/reportcommand";
        aVar.funcId = 2592;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dnb dnb = (dnb) this.rr.iLK.iLR;
        dnb.LlQ = linkedList;
        Log.i("MicroMsg.NetSceneReportBrandSession", "reportcommand MsgReport size %d", Integer.valueOf(dnb.LlQ.size()));
        AppMethodBeat.o(124143);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124144);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(124144);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2592;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124145);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124145);
        return dispatch;
    }
}
