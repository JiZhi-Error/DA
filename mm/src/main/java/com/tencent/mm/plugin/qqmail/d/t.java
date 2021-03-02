package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;

public final class t extends q implements m {
    private i callback;
    private d hJu;

    public t() {
        AppMethodBeat.i(198609);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.iLN = new af();
        aVar.iLO = new ag();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindxmail";
        this.hJu = aVar.aXF();
        AppMethodBeat.o(198609);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3889;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(198610);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(198610);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(198611);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(198611);
    }
}
