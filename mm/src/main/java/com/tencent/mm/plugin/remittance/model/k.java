package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.rl;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends q implements m {
    public rm CoF;
    private i callback;
    private d hJu;

    public k(du duVar, String str) {
        AppMethodBeat.i(67857);
        d.a aVar = new d.a();
        aVar.iLN = new rl();
        aVar.iLO = new rm();
        aVar.funcId = 2702;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2funlockfavor";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        rl rlVar = (rl) this.hJu.iLK.iLR;
        rlVar.KYe = duVar;
        rlVar.KYw = str;
        h.INSTANCE.dN(886, 0);
        Log.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "NetSceneBusiF2fUnlockFavor, f2fId: %s, transId: %s, amount: %s", duVar.KHM, duVar.KHN, Integer.valueOf(duVar.KHQ));
        AppMethodBeat.o(67857);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2702;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67858);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(67858);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(67859);
        Log.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.CoF = (rm) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.CoF.pTZ), this.CoF.pUa);
        h.INSTANCE.dN(886, 1);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(67859);
    }
}
