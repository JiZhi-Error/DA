package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class r extends q implements m {
    private i callback;
    public d hJu;

    public r(String str) {
        AppMethodBeat.i(198606);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        w wVar = new w();
        wVar.Bsf = str;
        aVar.iLN = wVar;
        aVar.iLO = new x();
        aVar.uri = "/cgi-bin/micromsg-bin/preparebindxmail";
        Log.i("MicroMsg.NetScenePrepareBindXmail", "bindQQMail %s", str);
        this.hJu = aVar.aXF();
        AppMethodBeat.o(198606);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3848;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(198607);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(198607);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(198608);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(198608);
    }
}
