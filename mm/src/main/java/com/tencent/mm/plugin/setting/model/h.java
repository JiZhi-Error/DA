package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bwh;
import com.tencent.mm.protocal.protobuf.bwi;
import com.tencent.mm.sdk.platformtools.Log;

public final class h extends q implements m {
    private i callback;

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(73769);
        updateDispatchIdNew(i2);
        if (!(i3 == 0 && i4 == 0)) {
            Log.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(73769);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 869;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(73770);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new bwh();
        aVar.iLO = new bwi();
        aVar.uri = "/cgi-bin/micromsg-bin/gettrustedfriends";
        aVar.funcId = 869;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        int dispatch = dispatch(gVar, aVar.aXF(), this);
        AppMethodBeat.o(73770);
        return dispatch;
    }
}
