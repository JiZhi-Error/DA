package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.sdk.platformtools.Log;

public final class aj extends q implements m {
    private i callback;
    public boolean idt;
    public String pTY;
    public b pUz;
    private final d rr;

    public aj(String str, int i2, String str2, String str3, int i3, String str4, String str5, String str6, b bVar) {
        AppMethodBeat.i(112864);
        d.a aVar = new d.a();
        aVar.iLN = new bil();
        aVar.iLO = new bim();
        aVar.uri = "/cgi-bin/micromsg-bin/getavailablecard";
        aVar.funcId = 1059;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bil bil = (bil) this.rr.iLK.iLR;
        bil.app_id = str;
        bil.qcJ = i2;
        bil.qcK = str2;
        bil.qcL = str3;
        bil.time_stamp = i3;
        bil.qcM = str4;
        bil.pRX = str5;
        bil.qcN = str6;
        bil.pUz = bVar;
        if ("INVOICE".equalsIgnoreCase(str6)) {
            bil.LSC = 1;
            AppMethodBeat.o(112864);
            return;
        }
        bil.LSC = 0;
        AppMethodBeat.o(112864);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1059;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112865);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112865);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112866);
        Log.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + i3 + " errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            bim bim = (bim) this.rr.iLL.iLR;
            this.pTY = bim.pTY;
            this.pUz = bim.pUz;
            this.idt = bim.LSD != 0;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112866);
    }
}
