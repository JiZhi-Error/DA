package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.protocal.protobuf.exi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public class f extends w implements j {
    public String IqL;
    public String IqM;
    public exi IqN;
    public String IqO = "";
    private i callback;
    private d rr;

    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, int i3, int i4, String str9) {
        AppMethodBeat.i(71816);
        d.a aVar = new d.a();
        aVar.iLN = new bgr();
        aVar.iLO = new bgs();
        aVar.uri = getUri();
        aVar.funcId = getType();
        aVar.iLP = 189;
        aVar.respCmdId = 1000000189;
        aVar.routeInfo = com.tencent.mm.wallet_core.ui.f.bpA(str4);
        this.rr = aVar.aXF();
        this.IqO = str7;
        e flM = com.tencent.mm.plugin.soter.d.d.flM();
        String str10 = flM.FhU;
        String str11 = flM.hFF;
        bgr bgr = (bgr) this.rr.iLK.iLR;
        bgr.jfi = str;
        bgr.Lkq = str4;
        bgr.Lkp = str3;
        bgr.Lkr = str5;
        bgr.Lks = str2;
        bgr.KPJ = str6;
        bgr.Ljk = str7;
        bgr.LQu = str8;
        bgr.KCx = i2;
        bgr.LQy = str10;
        bgr.LQx = str11;
        bgr.Lcc = k.fQy();
        if (i3 > 0) {
            bgr.Scene = i3;
        }
        bgr.LQz = i4;
        bgr.LQA = str9;
        Log.d("MicroMsg.NetSceneGenPrepay", "appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s,WxAppScene:%s,cookie:%s", str, str4, str3, str5, str2, str6, str7, str8, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str9);
        AppMethodBeat.o(71816);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(71817);
        Log.d("MicroMsg.NetSceneGenPrepay", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        bgs bgs = (bgs) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", Integer.valueOf(bgs.rBL), bgs.rBM);
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneGenPrepay", "rr " + bgs.LQv);
            this.IqL = bgs.LQv;
            this.IqM = bgs.LQw;
            this.IqN = bgs.LQB;
        }
        String str2 = bgs.rBM;
        this.callback.onSceneEnd(i3, bgs.rBL, str2, this);
        AppMethodBeat.o(71817);
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return 398;
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        AppMethodBeat.i(71818);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(71818);
        return dispatch;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/genprepay";
    }
}
