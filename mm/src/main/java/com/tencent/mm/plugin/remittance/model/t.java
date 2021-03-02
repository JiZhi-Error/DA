package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wy;
import com.tencent.mm.protocal.protobuf.wz;
import com.tencent.mm.sdk.platformtools.Log;

public final class t extends q implements m {
    public wz CoT;
    private i callback;
    private d hJu;

    public t(String str, String str2, String str3, String str4, long j2, String str5) {
        AppMethodBeat.i(67877);
        d.a aVar = new d.a();
        aVar.iLN = new wy();
        aVar.iLO = new wz();
        aVar.funcId = 1779;
        aVar.uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        wy wyVar = (wy) this.hJu.iLK.iLR;
        wyVar.dNQ = str;
        wyVar.CpQ = str2;
        wyVar.CpP = str3;
        wyVar.CpJ = str4;
        wyVar.CrW = j2;
        wyVar.Lhy = str5;
        Log.i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", str, str2, Long.valueOf(j2));
        AppMethodBeat.o(67877);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1779;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67878);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(67878);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(67879);
        Log.i("MicroMsg.NetSceneRemittancePayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.CoT = (wz) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.CoT.dDN), this.CoT.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(67879);
    }
}
