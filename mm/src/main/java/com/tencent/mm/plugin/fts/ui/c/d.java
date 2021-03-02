package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dsy;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends q implements m {
    private i callback;
    private com.tencent.mm.ak.d iUB;
    public dsz xeI;

    public d(dsy dsy) {
        AppMethodBeat.i(112157);
        d.a aVar = new d.a();
        aVar.iLN = dsy;
        aVar.iLO = new dsz();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/searchwxa";
        aVar.funcId = 2599;
        this.iUB = aVar.aXF();
        Log.i("MicroMsg.FTS.NetSceneWeAppSearch", "Query %s Scene %d SearchId: %d SessionId: %d", dsy.KXA, Long.valueOf(dsy.MVa), Long.valueOf(dsy.MRu), Long.valueOf(dsy.MRz));
        AppMethodBeat.o(112157);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2599;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112158);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(112158);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112159);
        Log.i("MicroMsg.FTS.NetSceneWeAppSearch", "netId %d errType %d errCode %d errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.xeI = (dsz) this.iUB.iLL.iLR;
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112159);
    }
}
