package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.czm;
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.f;

public class h extends w implements j {
    private i callback;
    public d rr;

    public h(PayReq payReq, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(71822);
        d.a aVar = new d.a();
        aVar.iLN = new czm();
        aVar.iLO = new czn();
        aVar.uri = getUri();
        aVar.funcId = getType();
        aVar.iLP = 188;
        aVar.respCmdId = 1000000188;
        aVar.routeInfo = f.bpA(payReq.prepayId);
        this.rr = aVar.aXF();
        czm czm = (czm) this.rr.iLK.iLR;
        czm.jfi = payReq.appId;
        czm.MEM = payReq.partnerId;
        czm.LQv = payReq.prepayId;
        czm.Lkp = payReq.nonceStr;
        czm.MEN = payReq.timeStamp;
        czm.Lkq = payReq.packageValue;
        czm.Lkr = payReq.sign;
        czm.Lks = payReq.signType;
        czm.MEO = str;
        czm.xuk = str2;
        czm.xMq = str3;
        czm.Lcc = k.fQy();
        czm.MEQ = str4;
        AppMethodBeat.o(71822);
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        AppMethodBeat.i(71823);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(71823);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(71824);
        Log.d("MicroMsg.NetScenePayAuthApp", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(71824);
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return 397;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/payauthapp";
    }
}
