package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.protobuf.dw;
import com.tencent.mm.plugin.game.protobuf.dx;
import com.tencent.mm.sdk.platformtools.Log;

public final class au extends q implements m {
    private i callback;
    public final d hhm;

    public au(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(41625);
        d.a aVar = new d.a();
        aVar.iLN = new dw();
        aVar.iLO = new dx();
        aVar.uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        dw dwVar = (dw) this.hhm.iLK.iLR;
        dwVar.hik = str;
        dwVar.xLl = str2;
        dwVar.xIG = str3;
        dwVar.xIT = z;
        AppMethodBeat.o(41625);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(41626);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(41626);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(41627);
        Log.i("MicroMsg.NetSceneGameSubscription", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(41627);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1219;
    }
}
