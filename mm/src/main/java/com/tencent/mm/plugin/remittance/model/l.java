package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.d.d;

public final class l extends q implements m, j, d {
    public ro CoG;
    private rn CoH;
    private i callback;
    public String dDL;
    private com.tencent.mm.ak.d hJu;
    public boolean hasRetried = false;
    public boolean rop = false;

    public l(eig eig, du duVar, String str, int i2, String str2, String str3) {
        AppMethodBeat.i(67860);
        d.a aVar = new d.a();
        aVar.iLN = new rn();
        aVar.iLO = new ro();
        aVar.funcId = 2682;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fzerocallback";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.CoH = (rn) this.hJu.iLK.iLR;
        this.CoH.KYe = duVar;
        this.CoH.KYA = eig;
        this.CoH.KYB = str;
        this.CoH.KYY = i2;
        this.CoH.token = str2;
        this.dDL = str3;
        Log.i("MicroMsg.NetSceneBusiF2fZeroCallback", "NetSceneBusiF2fZeroCallback, token %s AfterPlaceOrderCommReq %s zero_pay_extend: %s", str2, a.a(duVar), str);
        AppMethodBeat.o(67860);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2682;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67861);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(67861);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(67862);
        Log.i("MicroMsg.NetSceneBusiF2fZeroCallback", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.CoG = (ro) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBusiF2fZeroCallback", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.CoG.pTZ), this.CoG.pUa);
        if (this.callback != null) {
            if (this.CoG.KYZ == 1) {
                z = true;
            } else {
                z = false;
            }
            this.rop = z;
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(67862);
    }

    @Override // com.tencent.mm.wallet_core.d.d
    public final boolean getHasRetried() {
        return this.hasRetried;
    }
}
