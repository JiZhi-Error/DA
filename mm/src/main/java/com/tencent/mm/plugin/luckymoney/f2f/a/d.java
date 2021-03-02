package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.alp;
import com.tencent.mm.protocal.protobuf.alq;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;

public final class d extends q implements m, j {
    private i callback;
    public String dDL;
    private com.tencent.mm.ak.d hJu;
    public String yQE;
    private alp yRU = ((alp) this.hJu.iLK.iLR);
    public alq yRV;
    public String yRW;

    public d(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(65044);
        d.a aVar = new d.a();
        aVar.iLN = new alp();
        aVar.iLO = new alq();
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
        this.hJu = aVar.aXF();
        this.yRU.qwe = i2;
        this.yRU.Bbl = i3;
        this.yRU.egY = i4;
        this.yRU.Luu = i5;
        bf fQy = k.fQy();
        if (fQy != null) {
            this.yRU.latitude = fQy.latitude;
            this.yRU.longitude = fQy.longitude;
        }
        AppMethodBeat.o(65044);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(65045);
        Log.i("NetSceneF2FLuckyMoneyPrepare", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.yRV = (alq) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        this.dDL = this.yRV.wFL;
        this.yQE = this.yRV.yQE;
        this.yRW = this.yRV.yXL;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(65045);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1970;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(65046);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(65046);
        return dispatch;
    }
}
