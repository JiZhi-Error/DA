package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.bb;
import com.tencent.mm.plugin.qqmail.d.bc;

public final class f extends q implements m {
    public String BqZ;
    private i callback;
    private d iUB;

    public f(String str, int i2) {
        AppMethodBeat.i(198665);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/xmmailbroker/mb_updatemailstatus";
        bb bbVar = new bb();
        bbVar.Btu.add(str);
        g.aAf();
        bbVar.uin = (long) a.getUin();
        bbVar.Btv = (long) i2;
        aVar.iLN = bbVar;
        aVar.iLO = new bc();
        this.iUB = aVar.aXF();
        this.BqZ = str;
        AppMethodBeat.o(198665);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 11480;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(198666);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(198666);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(198667);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(198667);
    }
}
