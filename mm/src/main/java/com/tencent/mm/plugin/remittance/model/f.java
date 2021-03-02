package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.qz;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends q implements m {
    public ra Cot;
    private i callback;
    private d hJu;

    public f(String str, String str2, String str3, int i2, b bVar, String str4) {
        AppMethodBeat.i(67840);
        d.a aVar = new d.a();
        aVar.iLN = new qz();
        aVar.iLO = new ra();
        aVar.funcId = 1680;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2factqry";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        qz qzVar = (qz) this.hJu.iLK.iLR;
        qzVar.CpJ = str3;
        qzVar.KHM = str;
        qzVar.KHN = str2;
        qzVar.KHQ = i2;
        qzVar.KXS = bVar;
        qzVar.KHO = str4;
        Log.i("MicroMsg.NetSceneBusiF2fActQry", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s", str, str2, Integer.valueOf(i2));
        AppMethodBeat.o(67840);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1680;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67841);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(67841);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(67842);
        Log.i("MicroMsg.NetSceneBusiF2fActQry", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.Cot = (ra) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBusiF2fActQry", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.Cot.pTZ), this.Cot.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(67842);
    }
}
