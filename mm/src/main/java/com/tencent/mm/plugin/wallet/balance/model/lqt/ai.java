package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.sdk.platformtools.Log;

public final class ai extends q implements m {
    private cwv HuU = ((cwv) this.hJu.iLK.iLR);
    public cww HuV;
    private i callback;
    private d hJu;

    public ai(String str, String str2) {
        AppMethodBeat.i(68553);
        d.a aVar = new d.a();
        aVar.iLN = new cwv();
        aVar.iLO = new cww();
        aVar.funcId = 2996;
        aVar.uri = "/cgi-bin/mmpay-bin/openlqbaccount";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.HuU.KPu = str;
        this.HuU.KUp = str2;
        this.HuU.HuS = ag.fNb();
        Log.i("MicroMsg.NetSceneOpenLqbAccount", "NetSceneOpenLqbAccount, eCardType: %s, extraData: %s", str, str2);
        AppMethodBeat.o(68553);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2996;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(68554);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(68554);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(68555);
        Log.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        this.HuV = (cww) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, retcode: %s, retmsg: %s", Integer.valueOf(this.HuV.pTZ), this.HuV.pUa);
        if (this.HuV.pTZ == 0) {
            ag.aUH(this.HuV.HuS);
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(68555);
    }
}
