package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.rj;
import com.tencent.mm.protocal.protobuf.rk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class j extends q implements m {
    public rk CoE;
    private i callback;
    private d hJu;

    public j(du duVar, String str, int i2, int i3, long j2) {
        AppMethodBeat.i(67854);
        d.a aVar = new d.a();
        aVar.iLN = new rj();
        aVar.iLO = new rk();
        aVar.funcId = 2504;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        rj rjVar = (rj) this.hJu.iLK.iLR;
        rjVar.KYe = duVar;
        rjVar.KYv = str;
        rjVar.KYN = i2;
        if (Util.isEqual(i2, 1)) {
            rjVar.KYO = i3;
            rjVar.KYP = j2;
        }
        Log.i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s fault_flag %s fault_retry_cnt %s fault_retry_client_time %s", str, a.a(duVar), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
        AppMethodBeat.o(67854);
    }

    public j(du duVar, String str) {
        this(duVar, str, 0, 0, 0);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2504;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67855);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(67855);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(67856);
        Log.i("MicroMsg.NetSceneBusiF2fSucpage", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.CoE = (rk) ((d) sVar).iLL.iLR;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.CoE.Iah != null) {
            stringBuffer.append("response: " + this.CoE.KYQ);
            stringBuffer.append("is_show_btn: " + this.CoE.Iah.Ltn);
            if (this.CoE.Iah.Ltm != null) {
                stringBuffer.append("single_exposure_info_list " + this.CoE.Iah.Ltm.size());
            }
        }
        Log.i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", Integer.valueOf(this.CoE.pTZ), this.CoE.pUa, stringBuffer.toString());
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(67856);
    }
}
