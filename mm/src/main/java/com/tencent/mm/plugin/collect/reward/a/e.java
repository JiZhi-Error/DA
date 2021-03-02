package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wo;
import com.tencent.mm.protocal.protobuf.wp;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
    private i callback;
    public wp qxE;
    private d rr;

    public e(int i2, int i3, String str, String str2, String str3, int i4, String str4, String str5, String str6, String str7, String str8, int i5) {
        AppMethodBeat.i(63902);
        d.a aVar = new d.a();
        aVar.iLN = new wo();
        aVar.iLO = new wp();
        aVar.funcId = 1336;
        aVar.uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        wo woVar = (wo) this.rr.iLK.iLR;
        woVar.yRL = i2;
        woVar.LhH = i3;
        woVar.LhF = str;
        woVar.LhG = str2;
        woVar.CpD = str3;
        woVar.channel = i4;
        woVar.LhI = str4;
        woVar.Lhz = str5;
        woVar.LhJ = str6;
        woVar.LhK = str7;
        woVar.LhL = str8;
        woVar.LhM = i5;
        AppMethodBeat.o(63902);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1336;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63903);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(63903);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.collect.reward.a.a
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(63904);
        Log.i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.qxE = (wp) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", Integer.valueOf(this.qxE.dDN), this.qxE.qwn);
        if (!this.qxx && this.qxE.dDN != 0) {
            this.qxy = true;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(63904);
    }
}
