package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.at;
import com.tencent.mm.plugin.qqmail.d.au;

public final class c extends q implements m {
    public String BqZ;
    private i callback;
    public d iUB;

    public c(String str) {
        AppMethodBeat.i(198656);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/xmmailbroker/mb_readmail";
        at atVar = new at();
        atVar.BsL = str;
        g.aAf();
        atVar.uin = (long) a.getUin();
        aVar.iLN = atVar;
        aVar.iLO = new au();
        this.iUB = aVar.aXF();
        this.BqZ = str;
        AppMethodBeat.o(198656);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 11312;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(198657);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(198657);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(198658);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(198658);
    }
}
