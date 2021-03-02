package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.sdk.platformtools.Log;

public final class h extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardSetPhotoWord";
    private i callback;
    public String pqv;
    public wt qxH;
    private d rr;

    public h(String str) {
        AppMethodBeat.i(63911);
        d.a aVar = new d.a();
        aVar.iLN = new ws();
        aVar.iLO = new wt();
        aVar.funcId = 1649;
        aVar.uri = "/cgi-bin/mmpay-bin/setrewardqrcodephotoword";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((ws) this.rr.iLK.iLR).pqv = str;
        this.pqv = str;
        if (str.length() <= 0 || str.length() > 3) {
            if (str.length() > 3) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(724, 1, 1, false);
            }
            AppMethodBeat.o(63911);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(724, 0, 1, false);
        AppMethodBeat.o(63911);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1649;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63912);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(63912);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.collect.reward.a.a
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(63913);
        Log.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.qxH = (wt) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "retcode: %s, retmsg: %s", Integer.valueOf(this.qxH.dDN), this.qxH.qwn);
        if (!this.qxx && this.qxH.dDN != 0) {
            this.qxy = true;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(63913);
    }
}
