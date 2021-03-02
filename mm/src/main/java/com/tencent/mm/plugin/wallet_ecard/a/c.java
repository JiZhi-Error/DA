package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.lv;
import com.tencent.mm.protocal.protobuf.lw;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    public lw IpR;
    private i callback;
    private d rr;

    public c(String str, String str2, String str3, String str4, int i2) {
        AppMethodBeat.i(71688);
        d.a aVar = new d.a();
        aVar.iLN = new lv();
        aVar.iLO = new lw();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/bindecard";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        lv lvVar = (lv) this.rr.iLK.iLR;
        lvVar.KPu = str;
        lvVar.KPv = str2;
        lvVar.IaW = str3;
        lvVar.KPw = str4;
        lvVar.dUS = i2;
        Log.i("MicroMsg.NetSceneBindECard", "cardType: %s, reqSerial: %s, openScene: %s, verifyCode: %s, bindToken: %s", str, str2, Integer.valueOf(i2), str3, str4);
        AppMethodBeat.o(71688);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(71689);
        Log.i("MicroMsg.NetSceneBindECard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.IpR = (lw) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBindECard", "ret_code: %d, ret_msg: %s", Integer.valueOf(this.IpR.pTZ), this.IpR.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(71689);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1986;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(71690);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(71690);
        return dispatch;
    }
}
