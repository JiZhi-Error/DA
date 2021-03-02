package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.protocal.protobuf.bvc;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends q implements m {
    private i callback;
    public String pTY;
    public int pTZ;
    public String pUa;
    private final com.tencent.mm.ak.d rr;

    public d(String str, String str2, String str3) {
        AppMethodBeat.i(112963);
        d.a aVar = new d.a();
        aVar.iLN = new bvb();
        aVar.iLO = new bvc();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getsharecardconsumedinfo";
        aVar.funcId = b.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bvb bvb = (bvb) this.rr.iLK.iLR;
        bvb.eaO = str;
        bvb.scene = 20;
        bvb.pRX = str2;
        bvb.code = str3;
        AppMethodBeat.o(112963);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112964);
        Log.i("MicroMsg.NetSceneGetShareCardConsumedInfo", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(getType()), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            bvc bvc = (bvc) this.rr.iLL.iLR;
            Log.v("MicroMsg.NetSceneGetShareCardConsumedInfo", "json:" + bvc.pTY);
            this.pTY = bvc.pTY;
            this.pUa = bvc.pUa;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112964);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return b.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112965);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112965);
        return dispatch;
    }
}
