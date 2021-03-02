package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bpz;
import com.tencent.mm.protocal.protobuf.bqa;
import com.tencent.mm.sdk.platformtools.Log;

public final class n extends q implements m {
    private boolean HPM;
    private bpz HPP;
    public bqa HPQ;
    private i callback;
    private d hJu;

    public n(String str, boolean z) {
        AppMethodBeat.i(69917);
        this.HPM = z;
        d.a aVar = new d.a();
        aVar.iLN = new bpz();
        aVar.iLO = new bqa();
        if (z) {
            aVar.funcId = 2803;
            aVar.uri = "/cgi-bin/mmpay-bin/mktgetf2flottery";
        } else {
            aVar.funcId = 2508;
            aVar.uri = "/cgi-bin/mmpay-bin/mktgetlottery";
        }
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.HPP = (bpz) this.hJu.iLK.iLR;
        this.HPP.LXU = str;
        Log.i("MicroMsg.NetSceneMktGetLottery", "NetSceneMktGetLottery, getLotteryParams: %s, isF2f: %s", str, Boolean.valueOf(z));
        AppMethodBeat.o(69917);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        if (this.HPM) {
            return 2803;
        }
        return 2508;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69918);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(69918);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69919);
        Log.i("MicroMsg.NetSceneMktGetLottery", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.HPQ = (bqa) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(69919);
    }
}
