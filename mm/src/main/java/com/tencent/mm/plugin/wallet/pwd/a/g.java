package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ejr;
import com.tencent.mm.protocal.protobuf.ejs;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends q implements m {
    public ejs HIi;
    private i callback;
    private final d rr;

    public g(int i2, int i3) {
        AppMethodBeat.i(182518);
        d.a aVar = new d.a();
        ejr ejr = new ejr();
        ejr.NiY = i2;
        ejr.NiZ = i3;
        aVar.iLN = ejr;
        aVar.iLO = new ejs();
        aVar.uri = "/cgi-bin/mmpay-bin/transferphonechangeswitch";
        aVar.funcId = 1724;
        this.rr = aVar.aXF();
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitChangeSwitch", "NetSceneMobileRemitChangeSwitch() switchChangeType:%s", Integer.valueOf(i2));
        AppMethodBeat.o(182518);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1724;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(69539);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69539);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69540);
        Log.w("MicroMsg.mobileRemit.NetSceneMobileRemitChangeSwitch", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.HIi = (ejs) ((d) sVar).iLL.iLR;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(69540);
    }
}
