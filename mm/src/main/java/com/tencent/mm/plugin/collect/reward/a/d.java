package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wj;
import com.tencent.mm.protocal.protobuf.wk;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardPayCheck";
    private i callback;
    private wk qxD;
    private com.tencent.mm.ak.d rr;

    public d(String str, String str2, String str3, int i2, String str4, String str5) {
        AppMethodBeat.i(63899);
        d.a aVar = new d.a();
        aVar.iLN = new wj();
        aVar.iLO = new wk();
        aVar.funcId = 1960;
        aVar.uri = "/cgi-bin/mmpay-bin/rewardqrcodepaycheck";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        wj wjVar = (wj) this.rr.iLK.iLR;
        wjVar.dNQ = str;
        wjVar.LhB = str2;
        wjVar.KHN = str3;
        wjVar.yRL = i2;
        wjVar.Lhz = str4;
        wjVar.Lhy = str5;
        Log.i("MicroMsg.NetSceneQrRewardPayCheck", "rewardid: %s, amt: %s", str2, Integer.valueOf(i2));
        AppMethodBeat.o(63899);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1960;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63900);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(63900);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.collect.reward.a.a
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(63901);
        Log.i("MicroMsg.NetSceneQrRewardPayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.qxD = (wk) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneQrRewardPayCheck", "retcode: %s, retmsg: %s", Integer.valueOf(this.qxD.dDN), this.qxD.qwn);
        if (!this.qxx && this.qxD.dDN != 0) {
            this.qxy = true;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(63901);
    }
}
