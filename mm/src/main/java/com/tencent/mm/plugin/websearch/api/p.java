package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.protocal.protobuf.but;

public final class p extends a implements m {
    private v IDt;
    private but IDu;
    private i callback;
    private d iUB;

    public p(v vVar) {
        AppMethodBeat.i(187823);
        this.IDt = vVar;
        aWX(this.IDt.dPI);
        bus bus = new bus();
        bus.Scene = vVar.scene;
        bus.MaX = vVar.dDL;
        bus.MaY = ai.aft(0);
        b.i("MicroMsg.WebSearch.NetSceneGetSearchResult", "create NetSceneGetSearchResult scene:%s requestKey:%s", Integer.valueOf(vVar.scene), vVar.dDL);
        d.a aVar = new d.a();
        aVar.funcId = 1003;
        aVar.uri = "/cgi-bin/mmsearch-bin/getsearchresult";
        aVar.iLN = bus;
        aVar.iLO = new but();
        this.iUB = aVar.aXF();
        AppMethodBeat.o(187823);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(187824);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(187824);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1003;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(187825);
        b.i("MicroMsg.WebSearch.NetSceneGetSearchResult", "netId: %s errType:%s errCode:%s errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.IDu = (but) this.iUB.iLL.iLR;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(187825);
    }

    @Override // com.tencent.mm.plugin.websearch.api.a
    public final String fXC() {
        if (this.IDu != null) {
            return this.IDu.MaZ;
        }
        return null;
    }

    @Override // com.tencent.mm.plugin.websearch.api.a
    public final int fXD() {
        return 0;
    }
}
