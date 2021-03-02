package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.protobuf.bx;
import com.tencent.mm.plugin.game.protobuf.by;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class ar extends q implements m {
    private i callback;
    public final d hhm;

    public ar(int i2, int i3, int i4) {
        AppMethodBeat.i(41613);
        Log.i("MicroMsg.NetSceneGetMoreGameList", "offset: %d, limit: %d, type: %d, cat: %d", Integer.valueOf(i2), 15, Integer.valueOf(i3), Integer.valueOf(i4));
        d.a aVar = new d.a();
        aVar.iLN = new bx();
        aVar.iLO = new by();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetmoregamelist";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        bx bxVar = (bx) this.hhm.iLK.iLR;
        bxVar.xLV = i2;
        bxVar.xLW = 15;
        bxVar.xLl = LocaleUtil.getApplicationLanguage();
        bxVar.xMd = i3;
        bxVar.xMe = i4;
        AppMethodBeat.o(41613);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(41614);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(41614);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(41615);
        Log.i("MicroMsg.NetSceneGetMoreGameList", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(41615);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1220;
    }
}
