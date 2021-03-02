package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ahz;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.sdk.platformtools.Log;

public final class l extends q implements m {
    private ahz HPK;
    public aia HPL;
    private boolean HPM;
    private i callback;
    private d hJu;

    public l(String str, int i2, boolean z) {
        AppMethodBeat.i(69911);
        this.HPM = z;
        d.a aVar = new d.a();
        aVar.iLN = new ahz();
        aVar.iLO = new aia();
        if (z) {
            aVar.funcId = 1859;
            aVar.uri = "/cgi-bin/mmpay-bin/mktdrawf2flottery";
        } else {
            aVar.funcId = 2547;
            aVar.uri = "/cgi-bin/mmpay-bin/mktdrawlottery";
        }
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.HPK = (ahz) this.hJu.iLK.iLR;
        this.HPK.LrG = str;
        this.HPK.LrH = i2;
        Log.i("MicroMsg.NetSceneMktDrawLottery", "NetSceneMktDrawLottery, drawLotteryParams: %s, drawLotteryType: %s, isF2f: %s", str, Integer.valueOf(i2), Boolean.valueOf(z));
        AppMethodBeat.o(69911);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        if (this.HPM) {
            return 1859;
        }
        return 2547;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69912);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(69912);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69913);
        Log.i("MicroMsg.NetSceneMktDrawLottery", "onGYNetEnd netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.HPL = (aia) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(69913);
    }
}
