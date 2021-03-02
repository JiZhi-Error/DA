package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.rf;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.sdk.platformtools.Log;

public final class h extends q implements m {
    public rg CoA;
    private i callback;
    private d hJu;

    public h(du duVar, String str) {
        AppMethodBeat.i(67846);
        d.a aVar = new d.a();
        aVar.iLN = new rf();
        aVar.iLO = new rg();
        aVar.funcId = 1241;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fpaycheck";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        rf rfVar = (rf) this.hJu.iLK.iLR;
        rfVar.KYe = duVar;
        rfVar.KYf = str;
        Log.i("MicroMsg.NetSceneBusiF2fPayCheck", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s req: %s", duVar.KHM, duVar.KHN, Integer.valueOf(duVar.KHQ), a.a(duVar));
        AppMethodBeat.o(67846);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1241;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67847);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(67847);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(67848);
        Log.i("MicroMsg.NetSceneBusiF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.CoA = (rg) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBusiF2fPayCheck", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.CoA.pTZ), this.CoA.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(67848);
    }
}
