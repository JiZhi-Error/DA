package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.aq;
import com.tencent.mm.plugin.qqmail.d.ar;

public final class b extends q implements m {
    private i callback;
    public d iUB;

    public b() {
        AppMethodBeat.i(198653);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/xmmailbroker/mb_getunreadcount";
        aq aqVar = new aq();
        g.aAf();
        aqVar.uin = (long) a.getUin();
        aVar.iLN = aqVar;
        aVar.iLO = new ar();
        this.iUB = aVar.aXF();
        AppMethodBeat.o(198653);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 12213;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(198654);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(198654);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(198655);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(198655);
    }
}
