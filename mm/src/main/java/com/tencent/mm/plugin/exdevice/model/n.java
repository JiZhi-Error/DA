package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.protocal.protobuf.ejp;
import com.tencent.mm.protocal.protobuf.ejq;
import com.tencent.mm.sdk.platformtools.Log;

public final class n extends q implements m {
    private i callback = null;
    public String dGL = null;
    public int rAw = 0;
    d rr = null;

    public n(cce cce, String str, String str2, int i2) {
        AppMethodBeat.i(23388);
        d.a aVar = new d.a();
        aVar.iLN = new ejp();
        aVar.iLO = new ejq();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
        aVar.funcId = 1717;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ejp ejp = (ejp) this.rr.iLK.iLR;
        ejp.KLO = str;
        ejp.Lox = str2;
        ejp.NiV = cce;
        ejp.NiW = i2;
        this.dGL = str2;
        this.rAw = i2;
        AppMethodBeat.o(23388);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23389);
        Log.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + i2 + " errType = " + i3 + " errCode = " + i4 + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23389);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1717;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23390);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23390);
        return dispatch;
    }
}
