package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cyz;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.sdk.platformtools.Log;

public final class t extends q implements m {
    public cza IDB = new cza();
    private i callback;
    private d iUB;

    public t(cyz cyz) {
        AppMethodBeat.i(117617);
        cyz.MlQ = ai.clJ();
        cyz.MlR = ai.fYd();
        d.a aVar = new d.a();
        aVar.funcId = 1417;
        aVar.uri = "/cgi-bin/mmsearch-bin/parduspresearch";
        aVar.iLN = cyz;
        aVar.iLO = this.IDB;
        this.iUB = aVar.aXF();
        AppMethodBeat.o(117617);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1417;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(117618);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(117618);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(117619);
        Log.i("MicroMsg.FTS.NetScenePardusPreSearch", "netId %d errType %d errCode %d errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(117619);
    }
}
