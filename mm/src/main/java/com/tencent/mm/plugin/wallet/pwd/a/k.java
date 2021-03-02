package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dwo;
import com.tencent.mm.protocal.protobuf.dwp;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends q implements m {
    public dwo HIn;
    private dwp HIo;
    private i callback;
    private final d rr;

    public k(boolean z) {
        AppMethodBeat.i(69553);
        d.a aVar = new d.a();
        dwo dwo = new dwo();
        dwo.KBz = System.currentTimeMillis();
        if (z) {
            dwo.MWM = 1;
        } else {
            dwo.MWM = 0;
        }
        this.HIn = dwo;
        aVar.iLN = dwo;
        aVar.iLO = new dwp();
        aVar.uri = "/cgi-bin/mmpay-bin/setwalletentrancebalanceswitchstate";
        aVar.funcId = 2554;
        this.rr = aVar.aXF();
        AppMethodBeat.o(69553);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2554;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69554);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69554);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69555);
        Log.w("MicroMsg.NetSceneSetWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.HIo = (dwp) ((d) sVar).iLL.iLR;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(69555);
    }

    public final dwp fOP() {
        AppMethodBeat.i(69556);
        if (this.HIo == null) {
            dwp dwp = new dwp();
            AppMethodBeat.o(69556);
            return dwp;
        }
        dwp dwp2 = this.HIo;
        AppMethodBeat.o(69556);
        return dwp2;
    }
}
