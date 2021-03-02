package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.lx;
import com.tencent.mm.protocal.protobuf.ly;

public final class e extends q implements m {
    public static int kir = 1;
    public static int kis = 2;
    private i callback;
    private d rr;

    public e(int i2, String str) {
        AppMethodBeat.i(127829);
        d.a aVar = new d.a();
        aVar.iLN = new lx();
        aVar.iLO = new ly();
        aVar.uri = "/cgi-bin/micromsg-bin/bindemail";
        aVar.funcId = 256;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        lx lxVar = (lx) this.rr.iLK.iLR;
        lxVar.OpCode = i2;
        lxVar.KPz = str;
        AppMethodBeat.o(127829);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(127830);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(127830);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 256;
    }

    public final int Vj() {
        return ((lx) this.rr.iLK.iLR).OpCode;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(127831);
        updateDispatchId(i2);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(127831);
    }
}
