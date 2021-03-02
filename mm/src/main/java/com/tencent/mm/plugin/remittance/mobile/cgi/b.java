package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ejt;
import com.tencent.mm.protocal.protobuf.eju;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends a {
    public eju ClP;
    private String ClQ;
    private final String TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    public int bDZ;

    public b(int i2, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(174407);
        d.a aVar = new d.a();
        aVar.iLN = new ejt();
        aVar.iLO = new eju();
        aVar.funcId = 2694;
        aVar.uri = "/cgi-bin/mmpay-bin/transferphonecheckname";
        this.rr = aVar.aXF();
        ejt ejt = (ejt) this.rr.iLK.iLR;
        ejt.bDZ = i2;
        ejt.Njb = str;
        ejt.Njc = str2;
        ejt.Cru = str3;
        ejt.Njd = str4;
        ejt.Nje = str5;
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitCheckName reason:%s rcvrOpenid:%s rcvrToken:%s inputName:%s getRcvrExt:%s", Integer.valueOf(i2), str, str2, str3, str4);
        this.ClQ = str3;
        this.bDZ = i2;
        AppMethodBeat.o(174407);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67627);
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ClP = (eju) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.ClP.pTZ), this.ClP.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67627);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        eju eju = (eju) ((d) sVar).iLL.iLR;
        this.RtZ = eju.pTZ;
        this.Rua = eju.pUa;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2694;
    }
}
