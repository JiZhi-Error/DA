package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ekf;
import com.tencent.mm.protocal.protobuf.ekg;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends q implements m {
    private ekg Cmb;
    private final String TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";
    private i callback;
    private d hJu;

    public f(String str, String str2, String str3, String str4, long j2, String str5, String str6, String str7) {
        AppMethodBeat.i(67653);
        d.a aVar = new d.a();
        aVar.iLN = new ekf();
        aVar.iLO = new ekg();
        aVar.funcId = 2817;
        aVar.uri = "/cgi-bin/mmpay-bin/transferphonepaycheck";
        this.hJu = aVar.aXF();
        ekf ekf = (ekf) this.hJu.iLK.iLR;
        ekf.dNQ = str;
        ekf.CpQ = str2;
        ekf.CpP = str3;
        ekf.CpJ = str4;
        ekf.CrW = j2;
        ekf.Lhy = str5;
        ekf.Njc = str6;
        ekf.Njt = str7;
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitPayCheck reqKey:%s transferId:%s transactionId:%s receiverOpenid:%s fee:%s extendStr:%s rcvrToken:%s placeorderToken:%s", str, str2, str3, str4, Long.valueOf(j2), str5, str6, str7);
        AppMethodBeat.o(67653);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(67654);
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.Cmb = (ekg) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.Cmb.dDN), this.Cmb.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(67654);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2817;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67655);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(67655);
        return dispatch;
    }
}
