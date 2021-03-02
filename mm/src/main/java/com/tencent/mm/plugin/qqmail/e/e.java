package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.az;
import com.tencent.mm.plugin.qqmail.d.ba;

public final class e extends q implements m {
    public long Btx;
    private i callback;
    public d iUB;

    public e(long j2) {
        AppMethodBeat.i(198662);
        this.Btx = j2;
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/xmmailbroker/mb_syncconact";
        az azVar = new az();
        azVar.Bto = j2;
        g.aAf();
        azVar.uin = (long) a.getUin();
        aVar.iLN = azVar;
        aVar.iLO = new ba();
        this.iUB = aVar.aXF();
        AppMethodBeat.o(198662);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 14418;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(198663);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(198663);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(198664);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(198664);
    }
}
