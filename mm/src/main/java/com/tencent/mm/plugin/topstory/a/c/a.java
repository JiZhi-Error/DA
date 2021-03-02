package com.tencent.mm.plugin.topstory.a.c;

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

public final class a extends q implements m {
    private i callback;
    public String dPI;
    private d rr;
    private long uOV = System.currentTimeMillis();

    public a(String str, String str2) {
        AppMethodBeat.i(88477);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchwebcomm";
        aVar.iLN = new faa();
        aVar.iLO = new fab();
        this.rr = aVar.aXF();
        faa faa = (faa) this.rr.iLK.iLR;
        faa.NvY = str2;
        faa.dPI = str;
        this.dPI = str;
        AppMethodBeat.o(88477);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2582;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(88478);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(88478);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(88479);
        Log.i("MicroMsg.TopStory.NetSceneSearchWebComm", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(System.currentTimeMillis() - this.uOV));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(88479);
    }

    public final fab fxY() {
        return (fab) this.rr.iLL.iLR;
    }
}
