package com.tencent.mm.plugin.wallet_index.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.day;
import com.tencent.mm.protocal.protobuf.daz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class a extends w {
    public String IqL;
    public String IqM;
    private i callback;
    private d rr;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        AppMethodBeat.i(71849);
        d.a aVar = new d.a();
        aVar.iLN = new day();
        aVar.iLO = new daz();
        aVar.uri = "/cgi-bin/mmpay-bin/payugenprepay";
        aVar.funcId = 1521;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        day day = (day) this.rr.iLK.iLR;
        day.jfi = str;
        day.Lkq = str4;
        day.Lkp = str3;
        day.Lkr = str5;
        day.Lks = str2;
        day.KPJ = str6;
        day.Ljk = str7;
        day.LQu = str8;
        day.KCx = i2;
        Log.d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", str, str4, str3, str5, str2, str6, str7, str8));
        AppMethodBeat.o(71849);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(71850);
        Log.d("MicroMsg.NetScenePayUGenPrepay", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        daz daz = (daz) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetScenePayUGenPrepay", "rr " + daz.LQv);
            this.IqL = daz.LQv;
            this.IqM = daz.LQw;
        }
        this.callback.onSceneEnd(i3, i4, daz.rBM, this);
        AppMethodBeat.o(71850);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1521;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(71851);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(71851);
        return dispatch;
    }
}
