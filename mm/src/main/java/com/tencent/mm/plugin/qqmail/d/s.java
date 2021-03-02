package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.sdk.platformtools.Util;

public final class s extends q implements m {
    private String BrR = "";
    private i callback;
    private final boolean eeO;
    private d rr;

    public s(boolean z, String str) {
        AppMethodBeat.i(122719);
        this.eeO = z;
        this.BrR = Util.nullAsNil(str);
        AppMethodBeat.o(122719);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(122720);
        d.a aVar = new d.a();
        aVar.iLN = new ad();
        aVar.iLO = new ae();
        aVar.uri = "/cgi-bin/micromsg-bin/switchpushmail";
        aVar.funcId = 129;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ad adVar = (ad) this.rr.iLK.iLR;
        adVar.BsD = this.eeO ? 1 : 2;
        adVar.BsE = this.BrR;
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(122720);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final boolean uniqueInNetsceneQueue() {
        return true;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 129;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(122721);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.kernel.g.aAh().azQ().set(17, Integer.valueOf(((ae) this.rr.iLL.iLR).BsD));
        }
        updateDispatchId(i2);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(122721);
    }
}
