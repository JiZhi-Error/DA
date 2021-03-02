package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wq;
import com.tencent.mm.protocal.protobuf.wr;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardScanCode";
    private i callback;
    public wr qxF;
    private d rr;

    public f(String str, int i2, String str2) {
        AppMethodBeat.i(63905);
        d.a aVar = new d.a();
        aVar.iLN = new wq();
        aVar.iLO = new wr();
        aVar.funcId = 1516;
        aVar.uri = "/cgi-bin/mmpay-bin/scanrewardqrcode";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        wq wqVar = (wq) this.rr.iLK.iLR;
        wqVar.qwo = str;
        wqVar.channel = i2;
        wqVar.LhJ = str2;
        AppMethodBeat.o(63905);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1516;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63906);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(63906);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.collect.reward.a.a
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(63907);
        Log.i("MicroMsg.NetSceneQrRewardScanCode", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.qxF = (wr) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneQrRewardScanCode", "retcode: %s, retmsg: %s", Integer.valueOf(this.qxF.dDN), this.qxF.qwn);
        if (!this.qxx && this.qxF.dDN != 0) {
            this.qxy = true;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(63907);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.collect.reward.a.a
    public final boolean czP() {
        return false;
    }
}
