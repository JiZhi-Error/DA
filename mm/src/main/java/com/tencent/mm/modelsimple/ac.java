package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.ekp;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ac extends q implements m {
    private i callback;
    private final d rr;

    public ac(String str, int i2, LinkedList<eg> linkedList) {
        AppMethodBeat.i(150960);
        Log.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + str + "; scene = " + i2);
        d.a aVar = new d.a();
        aVar.iLN = new ekp();
        aVar.iLO = new ekq();
        aVar.uri = "/cgi-bin/mmbiz-bin/translatelink";
        aVar.funcId = 1200;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ekp ekp = (ekp) this.rr.iLK.iLR;
        ekp.link = str;
        ekp.scene = i2;
        ekp.NjP = linkedList;
        AppMethodBeat.o(150960);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1200;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150961);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150961);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150962);
        Log.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(150962);
    }

    public final String bfC() {
        ekq ekq = (ekq) this.rr.iLL.iLR;
        if (ekq == null) {
            return null;
        }
        return ekq.NjQ;
    }

    public final ekq bfD() {
        if (this.rr == null || this.rr.iLL.iLR == null) {
            return null;
        }
        return (ekq) this.rr.iLL.iLR;
    }
}
