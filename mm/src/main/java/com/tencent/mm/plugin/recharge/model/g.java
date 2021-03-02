package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.storage.e;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.efa;
import com.tencent.mm.protocal.protobuf.efb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;

public final class g extends w implements j {
    public PayInfo BDB;
    private i callback;
    public String mAppId;
    private d rr;

    public g(MallRechargeProduct mallRechargeProduct, String str) {
        this(mallRechargeProduct.appId, mallRechargeProduct.kHR, mallRechargeProduct.productId, str);
    }

    public g(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(67113);
        d.a aVar = new d.a();
        aVar.iLN = new efa();
        aVar.iLO = new efb();
        aVar.uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
        aVar.funcId = e.CTRL_INDEX;
        aVar.iLP = 230;
        aVar.respCmdId = 1000000230;
        this.rr = aVar.aXF();
        efa efa = (efa) this.rr.iLK.iLR;
        Log.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", str4);
        this.mAppId = str;
        efa.LOt = str;
        efa.LOs = str2;
        efa.LXc = str3;
        efa.LOu = str4;
        efa.Bri = c.fSg().aVu(str2);
        AppMethodBeat.o(67113);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(67114);
        this.BDB = new PayInfo();
        efb efb = (efb) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + efb.KKR);
            this.BDB.appId = this.mAppId;
            this.BDB.IqM = efb.LQw;
            this.BDB.dDL = efb.KKR;
        }
        if (i4 == 0) {
            i4 = efb.LOv;
        }
        if (Util.isNullOrNil(str)) {
            str = efb.LOw;
        }
        this.BDB.Kxt = String.valueOf(i4);
        this.BDB.errMsg = str != null ? String.valueOf(str) : "";
        Log.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "errCode " + i4 + ", errMsg " + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(67114);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return e.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(67115);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67115);
        return dispatch;
    }
}
