package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cvk;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.protocal.protobuf.esj;
import com.tencent.smtt.sdk.TbsListener;
import java.util.LinkedList;

public final class a extends q implements m {
    private i callback;
    private d rr;

    public a(LinkedList<esj> linkedList, int i2) {
        AppMethodBeat.i(28926);
        d.a aVar = new d.a();
        aVar.iLN = new cvk();
        aVar.iLO = new cvl();
        aVar.uri = "/cgi-bin/micromsg-bin/opvoicereminder";
        aVar.funcId = TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE;
        aVar.iLP = 150;
        aVar.respCmdId = 1000000150;
        this.rr = aVar.aXF();
        cvk cvk = (cvk) this.rr.iLK.iLR;
        cvk.OpCode = 1;
        cvk.MAM = linkedList;
        cvk.MAL = i2;
        AppMethodBeat.o(28926);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(28927);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(28927);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(28928);
        updateDispatchId(i2);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(28928);
    }
}
