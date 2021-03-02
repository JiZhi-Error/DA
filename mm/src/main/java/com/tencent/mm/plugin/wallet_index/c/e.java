package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bgp;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class e extends w {
    public String IqL;
    public String IqM;
    private i callback;
    private d rr;

    public e(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, int i3, String str9) {
        AppMethodBeat.i(71813);
        d.a aVar = new d.a();
        aVar.iLN = new bgp();
        aVar.iLO = new bgq();
        aVar.uri = "/cgi-bin/mmpay-bin/genmallprepay";
        aVar.funcId = 2755;
        aVar.iLP = 189;
        aVar.respCmdId = 1000000189;
        this.rr = aVar.aXF();
        bgp bgp = (bgp) this.rr.iLK.iLR;
        bgp.jfi = str;
        bgp.Lkq = str4;
        bgp.Lkp = str3;
        bgp.Lkr = str5;
        bgp.Lks = str2;
        bgp.KPJ = str6;
        bgp.Ljk = str7;
        bgp.LQu = str8;
        bgp.KCx = i2;
        bgp.xNU = str9;
        if (i3 > 0) {
            bgp.Scene = i3;
        }
        Log.d("MicroMsg.NetSceneGenMallPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", str, str4, str3, str5, str2, str6, str7, str8, Integer.valueOf(i2), Integer.valueOf(i3)));
        AppMethodBeat.o(71813);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(71814);
        Log.d("MicroMsg.NetSceneGenMallPrepay", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        bgq bgq = (bgq) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", Integer.valueOf(bgq.rBL), bgq.rBM);
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneGenMallPrepay", "rr " + bgq.LQv);
            this.IqL = bgq.LQv;
            this.IqM = bgq.LQw;
        }
        String str2 = bgq.rBM;
        this.callback.onSceneEnd(i3, bgq.rBL, str2, this);
        AppMethodBeat.o(71814);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2755;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(71815);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(71815);
        return dispatch;
    }
}
