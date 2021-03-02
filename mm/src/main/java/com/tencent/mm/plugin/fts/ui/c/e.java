package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.doe;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends q implements m {
    private i callback;
    private d iUB;
    private dof xeJ = new dof();

    public e(doe doe) {
        AppMethodBeat.i(112160);
        d.a aVar = new d.a();
        aVar.iLN = doe;
        aVar.iLO = this.xeJ;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportsearchwxa";
        aVar.funcId = 2678;
        this.iUB = aVar.aXF();
        Log.i("MicroMsg.FTS.NetSceneWeAppSearchReport", "Query %s SearchId %s Scene %d SearchId: %d SessionId: %d", doe.jfi, Long.valueOf(doe.MRu), Integer.valueOf(doe.Scene), Long.valueOf(doe.MRu), Long.valueOf(doe.MRz));
        AppMethodBeat.o(112160);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2678;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112161);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(112161);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112162);
        Log.i("MicroMsg.FTS.NetSceneWeAppSearchReport", "netId %d errType %d errCode %d errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112162);
    }
}
