package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private i callback;
    public String pTY;
    private final d rr;

    public c(String str) {
        AppMethodBeat.i(112960);
        d.a aVar = new d.a();
        aVar.iLN = new bvf();
        aVar.iLO = new bvg();
        aVar.uri = "/cgi-bin/micromsg-bin/getsharecard";
        aVar.funcId = 1051;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((bvf) this.rr.iLK.iLR).eaO = str;
        AppMethodBeat.o(112960);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112961);
        Log.i("MicroMsg.NetSceneGetShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(getType()), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            bvg bvg = (bvg) this.rr.iLL.iLR;
            Log.v("MicroMsg.NetSceneGetShareCard", "json:" + bvg.pTY);
            this.pTY = bvg.pTY;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112961);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1051;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112962);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112962);
        return dispatch;
    }
}
