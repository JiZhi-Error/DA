package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.elv;
import com.tencent.mm.protocal.protobuf.elw;

public final class y extends q implements m {
    private i callback;
    private String dGL;
    private String dGP;
    public String fMb;
    private int rAB = 0;
    private d rr;

    public y(String str, String str2, String str3) {
        this.fMb = str3;
        this.dGL = str;
        this.dGP = str2;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1263;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23422);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new elv();
        aVar.iLO = new elw();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        elv elv = (elv) this.rr.iLK.iLR;
        elv.fMb = this.fMb;
        elv.AJE = this.dGL;
        elv.devicetype = this.dGP;
        elv.NkG = this.rAB;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23422);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23423);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23423);
    }
}
