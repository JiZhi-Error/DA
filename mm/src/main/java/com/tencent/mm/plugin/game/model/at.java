package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dsc;
import com.tencent.mm.protocal.protobuf.dsd;
import com.tencent.mm.sdk.platformtools.Log;

public final class at extends q implements m {
    private i callback;
    final d hhm;

    public at(int i2, int i3) {
        AppMethodBeat.i(41622);
        Log.i("MicroMsg.NetSceneSearchGameList", "offset: %d, limit: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        d.a aVar = new d.a();
        aVar.iLN = new dsc();
        aVar.iLO = new dsd();
        aVar.uri = "/cgi-bin/mmgame-bin/searchgamelist";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        dsc dsc = (dsc) this.hhm.iLK.iLR;
        dsc.xLV = i2;
        dsc.xLW = i3;
        AppMethodBeat.o(41622);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(41623);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(41623);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(41624);
        Log.i("MicroMsg.NetSceneSearchGameList", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(41624);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1215;
    }
}
