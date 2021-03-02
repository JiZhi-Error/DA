package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akr;
import com.tencent.mm.protocal.protobuf.aks;

public final class c extends q implements m {
    private i callback;
    private final d iUB;

    public c(String str) {
        AppMethodBeat.i(30172);
        d.a aVar = new d.a();
        akr akr = new akr();
        aks aks = new aks();
        aVar.iLN = akr;
        aVar.iLO = aks;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
        aVar.funcId = 973;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        akr.LtA = str;
        this.iUB = aVar.aXF();
        AppMethodBeat.o(30172);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 973;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(30173);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(30173);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(30174);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(30174);
    }
}
