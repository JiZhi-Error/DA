package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.an;
import com.tencent.mm.plugin.qqmail.d.aw;
import com.tencent.mm.plugin.qqmail.d.ax;

public final class d extends q implements m {
    private i callback;
    public String dPI;
    private com.tencent.mm.ak.d iUB;

    public d(String str, an anVar) {
        AppMethodBeat.i(198659);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/xmmailbroker/mb_sendmail";
        aw awVar = new aw();
        g.aAf();
        awVar.uin = (long) a.getUin();
        awVar.Btj = anVar;
        aVar.iLN = awVar;
        aVar.iLO = new ax();
        this.iUB = aVar.aXF();
        this.dPI = str;
        AppMethodBeat.o(198659);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 11166;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(198660);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(198660);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(198661);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(198661);
    }
}
