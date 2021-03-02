package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fan;
import com.tencent.mm.protocal.protobuf.fao;

public final class aa extends a implements m {
    private v IDt;
    private fan IEe = new fan();
    private fao IEf;
    private i callback;
    private d iUB;

    public aa(v vVar) {
        AppMethodBeat.i(187838);
        this.IDt = vVar;
        aWX(this.IDt.dPI);
        this.IEe.type = 1;
        this.IEe.KRB = vVar.content;
        this.IEf = new fao();
        b.i("MicroMsg.WebSearch.NetSceneWebSearchAiScanImageRetrieval", "create NetSceneWebSearchAiScanImageRetrieval scene:%s requestKey:%s", Integer.valueOf(vVar.scene), vVar.dDL);
        d.a aVar = new d.a();
        aVar.funcId = 1532;
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_retrieval";
        aVar.iLN = this.IEe;
        aVar.iLO = this.IEf;
        this.iUB = aVar.aXF();
        AppMethodBeat.o(187838);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(187839);
        b.i("MicroMsg.WebSearch.NetSceneWebSearchAiScanImageRetrieval", "netId: %s errType:%s errCode:%s errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 || i4 == 0) {
            this.IEf = (fao) this.iUB.iLL.iLR;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(187839);
    }

    @Override // com.tencent.mm.plugin.websearch.api.a
    public final String fXC() {
        return this.IEf.KRB;
    }

    @Override // com.tencent.mm.plugin.websearch.api.a
    public final int fXD() {
        return 0;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1532;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(187840);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(187840);
        return dispatch;
    }

    public final fao fXS() {
        return this.IEf;
    }

    public final v fXN() {
        return this.IDt;
    }
}
