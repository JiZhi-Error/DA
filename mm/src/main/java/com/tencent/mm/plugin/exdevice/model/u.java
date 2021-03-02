package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dse;
import com.tencent.mm.protocal.protobuf.dsf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tavkit.component.TAVPlayer;

public final class u extends q implements m {
    private i callback = null;
    d rr = null;

    public u(String str) {
        AppMethodBeat.i(23410);
        d.a aVar = new d.a();
        aVar.iLN = new dse();
        aVar.iLO = new dsf();
        aVar.uri = "/cgi-bin/micromsg-bin/searchharddevice";
        aVar.funcId = TAVPlayer.VIDEO_PLAYER_WIDTH;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((dse) this.rr.iLK.iLR).MUJ = str;
        AppMethodBeat.o(23410);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23411);
        Log.i("MicroMsg.exdevice.NetSceneSearchHardDevice", "onGYNetEnd netId = " + i2 + " errType = " + i3 + " errCode = " + i4 + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23411);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TAVPlayer.VIDEO_PLAYER_WIDTH;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23412);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23412);
        return dispatch;
    }
}
