package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ekj;
import com.tencent.mm.protocal.protobuf.ekk;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends a {
    public ekk Cma;
    private final String TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage";

    public e(String str, String str2, String str3, String str4, int i2, String str5, String str6) {
        AppMethodBeat.i(67651);
        d.a aVar = new d.a();
        aVar.iLN = new ekj();
        aVar.iLO = new ekk();
        aVar.funcId = 1903;
        aVar.uri = "/cgi-bin/mmpay-bin/transferphonesuccpage";
        this.rr = aVar.aXF();
        ekj ekj = (ekj) this.rr.iLK.iLR;
        ekj.KBM = str;
        ekj.KHN = str2;
        ekj.Njb = str3;
        ekj.Njc = str4;
        ekj.yRL = i2;
        ekj.Njt = str5;
        ekj.NjB = str6;
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "do scene NetSceneMobileRemitGetSuccPage out_trade_no:%s trans_id:%s rcvr_openid:%s rcvr_token:%s amount:%s placeorder_token:%s placeorder_ext:%s", str, str2, str3, str4, Integer.valueOf(i2), str5, str6);
        AppMethodBeat.o(67651);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67652);
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.Cma = (ekk) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetSuccPage", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.Cma.pTZ), this.Cma.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67652);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        ekk ekk = (ekk) ((d) sVar).iLL.iLR;
        this.RtZ = ekk.pTZ;
        this.Rua = ekk.pUa;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1903;
    }
}
