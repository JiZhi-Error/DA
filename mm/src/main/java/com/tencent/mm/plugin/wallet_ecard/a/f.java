package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends q implements m {
    public dgz IpX;
    private i callback;
    private d rr;

    public f(String str, int i2) {
        AppMethodBeat.i(71698);
        d.a aVar = new d.a();
        aVar.iLN = new dgy();
        aVar.iLO = new dgz();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/qryecardbanklist4bind";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dgy dgy = (dgy) this.rr.iLK.iLR;
        dgy.KPu = str;
        dgy.dUS = i2;
        Log.i("MicroMsg.NetSceneQryBankList4Bind", "cardType: %s, openScene: %s", str, Integer.valueOf(i2));
        AppMethodBeat.o(71698);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(71699);
        Log.i("MicroMsg.NetSceneQryBankList4Bind", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.IpX = (dgz) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneQryBankList4Bind", "ret_code: %d, ret_msg: %s", Integer.valueOf(this.IpX.pTZ), this.IpX.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(71699);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1988;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(71700);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(71700);
        return dispatch;
    }
}
