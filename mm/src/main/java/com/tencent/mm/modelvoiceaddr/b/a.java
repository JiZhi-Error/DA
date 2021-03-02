package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.doj;
import com.tencent.mm.protocal.protobuf.dok;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class a extends q implements m {
    private i callback;
    doj jxM = ((doj) this.rr.iLK.iLR);
    private d rr;

    a(int i2, LinkedList<dqi> linkedList, dqi dqi, dqi dqi2) {
        AppMethodBeat.i(148644);
        d.a aVar = new d.a();
        aVar.iLN = new doj();
        aVar.iLO = new dok();
        aVar.uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
        aVar.funcId = 228;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.jxM.MRJ = i2;
        this.jxM.MRK = linkedList;
        this.jxM.MRL = dqi;
        this.jxM.MRM = dqi2;
        AppMethodBeat.o(148644);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 228;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(148645);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(148645);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(148646);
        Log.d("MicroMsg.NetSceneNewVoiceInputReport", "onGYNetEnd errtype:" + i3 + " errcode:" + i4 + " errMsg:" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(148646);
    }
}
