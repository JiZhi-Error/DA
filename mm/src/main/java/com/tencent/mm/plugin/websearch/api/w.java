package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.faa;
import com.tencent.mm.protocal.protobuf.fab;
import com.tencent.mm.sdk.platformtools.Log;

public final class w extends q implements m {
    private i callback;
    public String dPI;
    public int dVL;
    private d rr;
    private long uOV = System.currentTimeMillis();

    public w(String str, String str2, int i2) {
        AppMethodBeat.i(117624);
        this.dVL = i2;
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchwebquery";
        aVar.iLN = new faa();
        aVar.iLO = new fab();
        this.rr = aVar.aXF();
        faa faa = (faa) this.rr.iLK.iLR;
        faa.NvY = str2;
        faa.dPI = str;
        this.dPI = str;
        AppMethodBeat.o(117624);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2975;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(117625);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(117625);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(117626);
        Log.i("MicroMsg.WebSearch.NetSceneSearchWebQuery", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(System.currentTimeMillis() - this.uOV));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(117626);
    }

    public final fab fxY() {
        return (fab) this.rr.iLL.iLR;
    }

    public final String fXP() {
        return this.dPI;
    }

    public final int fXQ() {
        return this.dVL;
    }
}
