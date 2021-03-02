package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.efp;
import com.tencent.mm.protocal.protobuf.efq;
import com.tencent.mm.sdk.platformtools.Log;

public final class q extends com.tencent.mm.ak.q implements m {
    private i callback;
    private d rr;
    public boolean sQf = false;
    public boolean sQg = false;

    public q(int i2) {
        AppMethodBeat.i(103620);
        d.a aVar = new d.a();
        aVar.iLN = new efp();
        aVar.iLO = new efq();
        aVar.uri = "/cgi-bin/micromsg-bin/switchopface";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((efp) this.rr.iLK.iLR).OpCode = i2;
        AppMethodBeat.o(103620);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.i.d.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(103621);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103621);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(103622);
        efq efq = (efq) ((d) sVar).iLL.iLR;
        this.sQf = efq.NfI;
        this.sQg = efq.NfJ;
        Log.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", Integer.valueOf(i3), Integer.valueOf(i4), str, Boolean.valueOf(this.sQf), Boolean.valueOf(this.sQg));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(103622);
    }
}
