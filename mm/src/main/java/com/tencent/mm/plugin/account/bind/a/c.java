package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.contact.f;
import com.tencent.mm.protocal.protobuf.eky;
import com.tencent.mm.protocal.protobuf.ekz;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private i callback;
    private final d rr;

    public c() {
        AppMethodBeat.i(109749);
        d.a aVar = new d.a();
        aVar.iLN = new eky();
        aVar.iLO = new ekz();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindlinkedincontact";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((eky) this.rr.iLK.iLR).KMz = 1;
        AppMethodBeat.o(109749);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(109750);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(109750);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return f.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(109751);
        Log.d("MicroMsg.NetSceneUnBindLinkedinContact", "onGYNetEnd errType:" + i3 + " errCode:" + i4);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.kernel.g.aAh().azQ().set(286722, "");
            com.tencent.mm.kernel.g.aAh().azQ().set(286721, "");
            com.tencent.mm.kernel.g.aAh().azQ().set(286723, "");
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(109751);
    }
}
