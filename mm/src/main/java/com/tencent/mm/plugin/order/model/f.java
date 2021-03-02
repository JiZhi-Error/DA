package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class f extends w {
    private i callback;
    private d rr;

    public f(String str, String str2, int i2) {
        AppMethodBeat.i(66683);
        d.a aVar = new d.a();
        aVar.iLN = new aju();
        aVar.iLO = new ajv();
        aVar.uri = "/cgi-bin/micromsg-bin/evaluateorder";
        aVar.funcId = 583;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        aju aju = (aju) this.rr.iLK.iLR;
        aju.Lti = str;
        aju.jfi = str2;
        aju.Cyb = i2;
        aju.Lcc = k.fQy();
        AppMethodBeat.o(66683);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(66684);
        Log.d("MicroMsg.NetSceneEvaluateOrder", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(66684);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 583;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(66685);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(66685);
        return dispatch;
    }
}
