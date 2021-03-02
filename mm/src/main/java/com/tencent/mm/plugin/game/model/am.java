package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.protobuf.bj;
import com.tencent.mm.plugin.game.protobuf.bk;
import com.tencent.mm.sdk.platformtools.Log;

public final class am extends q implements m {
    private i callback;
    public final d hhm;

    public am(String str, String str2, boolean z) {
        AppMethodBeat.i(41598);
        d.a aVar = new d.a();
        aVar.iLN = new bj();
        aVar.iLO = new bk();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        bj bjVar = (bj) this.hhm.iLK.iLR;
        bjVar.xLl = str;
        bjVar.hik = str2;
        bjVar.xLo = z;
        bjVar.xLq = true;
        AppMethodBeat.o(41598);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(41599);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(41599);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(41600);
        Log.i("MicroMsg.NetSceneGetGameDetailNew", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(41600);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1217;
    }
}
