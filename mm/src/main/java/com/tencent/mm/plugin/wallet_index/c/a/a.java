package com.tencent.mm.plugin.wallet_index.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.w;

public final class a extends w {
    public String IqM;
    public String Irb;
    private i callback;
    public String jumpUrl;
    public String prepayId;
    private d rr;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        AppMethodBeat.i(71846);
        d.a aVar = new d.a();
        aVar.iLN = new daa();
        aVar.iLO = new dab();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggenprepay";
        aVar.funcId = 1563;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        daa daa = (daa) this.rr.iLK.iLR;
        daa.jfi = str;
        daa.Lkq = str4;
        daa.Lkp = str2;
        daa.Lkr = str5;
        daa.Lks = str6;
        daa.KPJ = str3;
        daa.Ljk = str7;
        daa.LQu = str8;
        daa.KCx = i2;
        Log.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", str, str4, str2, str5, str6, str3, str7, str8));
        AppMethodBeat.o(71846);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(71847);
        Log.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay raw net errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        dab dab = (dab) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", Integer.valueOf(dab.rBL), dab.rBM);
            str = dab.rBM;
            i4 = dab.rBL;
            this.jumpUrl = dab.xIy;
            this.prepayId = dab.LQv;
            this.IqM = dab.LQw;
            this.Irb = dab.MFk;
        } else {
            Log.e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
            this.jumpUrl = null;
        }
        if (Util.isNullOrNil(str)) {
            str = MMApplicationContext.getContext().getString(R.string.ibn);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(71847);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1563;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(71848);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(71848);
        return dispatch;
    }
}
