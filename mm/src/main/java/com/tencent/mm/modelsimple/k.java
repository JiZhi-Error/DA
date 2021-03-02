package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends q implements m {
    private i callback;
    private final d rr;

    public k(String str, int i2, String str2, byte[] bArr) {
        AppMethodBeat.i(20617);
        Log.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", str, Integer.valueOf(i2), str2);
        d.a aVar = new d.a();
        aVar.iLN = new ajp();
        aVar.iLO = new ajq();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
        aVar.funcId = 1066;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        if (str2 == null) {
            str2 = "";
        } else if (str2.length() > 32 && i2 != 19) {
            str2 = str2.substring(0, 32);
        }
        ajp ajp = (ajp) this.rr.iLK.iLR;
        ajp.KSV = str;
        ajp.xub = i2;
        ajp.Lte = b.bfZ(str2);
        if (bArr == null) {
            ajp.Lqr = b.cD(new byte[0]);
        } else {
            ajp.Lqr = b.cD(bArr);
        }
        Log.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", str, Integer.valueOf(i2), Integer.valueOf(ajp.Lqr.zy.length));
        AppMethodBeat.o(20617);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1066;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20618);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(20618);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20619);
        Log.i("MicroMsg.NetSceneEnterTempSession", "onGYNetEnd: %d, %d, %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20619);
    }
}
