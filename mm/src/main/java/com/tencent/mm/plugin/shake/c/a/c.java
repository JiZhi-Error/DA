package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dwt;
import com.tencent.mm.protocal.protobuf.dwu;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    e Dhq;
    private i callback;
    private final d rr;

    public c(float f2, float f3, int i2, String str) {
        AppMethodBeat.i(28185);
        d.a aVar = new d.a();
        aVar.iLN = new dwt();
        aVar.iLO = new dwu();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/shakecard";
        aVar.funcId = 1250;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dwt dwt = (dwt) this.rr.iLK.iLR;
        dwt.latitude = f3;
        dwt.dTj = f2;
        dwt.scene = i2;
        dwt.MWO = str;
        AppMethodBeat.o(28185);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1250;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(28186);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(28186);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(28187);
        Log.i("MicroMsg.NetSceneShakeCard", "onGYNetEnd, getType = " + getType() + " errType = " + i3 + " errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            dwu dwu = (dwu) this.rr.iLL.iLR;
            if (dwu != null) {
                this.Dhq = new e();
                this.Dhq.pTI = dwu.pTI;
                this.Dhq.pRX = dwu.pRX;
                this.Dhq.eaP = dwu.eaP;
                this.Dhq.title = dwu.title;
                this.Dhq.pRY = dwu.pRY;
                this.Dhq.pRZ = dwu.pRZ;
                this.Dhq.gTG = dwu.gTG;
                this.Dhq.iwv = dwu.iwv;
                this.Dhq.ixw = dwu.ixw;
                this.Dhq.Dhr = dwu.Dhr;
                this.Dhq.Dhu = dwu.Dhu;
                this.Dhq.Dhv = dwu.Dhv;
                this.Dhq.Dhw = dwu.Dhw;
                this.Dhq.Dhx = dwu.Dhx;
                this.Dhq.Dhy = dwu.Dhy;
                this.Dhq.pSb = dwu.pSb;
                this.Dhq.Dhz = dwu.Dhz;
                this.Dhq.DhA = dwu.DhA;
                com.tencent.mm.plugin.shake.b.m.eUs().Dht = this.Dhq.Dhy;
            } else {
                this.Dhq = new e();
                this.Dhq.pTI = 3;
                this.Dhq.Dhy = com.tencent.mm.plugin.shake.b.m.eUs().Dht;
            }
        } else {
            this.Dhq = new e();
            this.Dhq.pTI = 3;
            this.Dhq.Dhy = com.tencent.mm.plugin.shake.b.m.eUs().Dht;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(28187);
    }
}
