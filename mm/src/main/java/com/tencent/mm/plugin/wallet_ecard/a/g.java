package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dha;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class g extends r {
    public dhb IpY;
    private i callback;
    private d rr;

    public g() {
        AppMethodBeat.i(71701);
        d.a aVar = new d.a();
        aVar.iLN = new dha();
        aVar.iLO = new dhb();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/qrycancelecarddesc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((dha) this.rr.iLK.iLR).MLx = 1;
        AppMethodBeat.o(71701);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(71702);
        Log.i("MicroMsg.NetSceneQryECardLogout", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.IpY = (dhb) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneQryECardLogout", "retcode: %s, retmsg: %s", Integer.valueOf(this.IpY.pTZ), this.IpY.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(71702);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        dhb dhb = (dhb) ((d) sVar).iLL.iLR;
        this.RtZ = dhb.pTZ;
        this.Rua = dhb.pUa;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2931;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(71703);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(71703);
        return dispatch;
    }
}
