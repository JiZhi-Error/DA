package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.protocal.protobuf.czf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;

public final class u extends q implements m {
    public czf IDC;
    public cze IDD;
    private i callback;
    private d iUB;

    public u(cze cze) {
        AppMethodBeat.i(117620);
        this.IDD = cze;
        this.IDD.MEt = ao.isDarkMode() ? 1 : 0;
        cze.MlQ = ai.clJ();
        cze.MlR = ai.fYd();
        this.IDC = new czf();
        d.a aVar = new d.a();
        aVar.funcId = 1076;
        aVar.uri = "/cgi-bin/mmsearch-bin/pardussearch";
        aVar.iLN = cze;
        aVar.iLO = this.IDC;
        this.iUB = aVar.aXF();
        AppMethodBeat.o(117620);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1076;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(117621);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(117621);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(117622);
        Log.i("MicroMsg.FTS.NetScenePardusSearch", "netId %d errType %d errCode %d errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(117622);
    }

    public final czf fXO() {
        return this.IDC;
    }
}
