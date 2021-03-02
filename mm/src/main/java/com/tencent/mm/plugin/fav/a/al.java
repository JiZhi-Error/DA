package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bnm;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.platformtools.Log;

public final class al extends q implements m {
    private i callback = null;
    private final d rr;

    public al() {
        AppMethodBeat.i(103480);
        d.a aVar = new d.a();
        aVar.iLN = new bnm();
        aVar.iLO = new bnn();
        aVar.uri = "/cgi-bin/micromsg-bin/getfavinfo";
        aVar.funcId = 438;
        aVar.iLP = 217;
        aVar.respCmdId = 1000000217;
        this.rr = aVar.aXF();
        AppMethodBeat.o(103480);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(103481);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103481);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(103482);
        Log.d("MicroMsg.NetSceneGetFavInfo", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (i3 == 0 && i4 == 0) {
            bnn bnn = (bnn) ((d) sVar).iLL.iLR;
            Log.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", Long.valueOf(bnn.KHg), Long.valueOf(bnn.oTV), Integer.valueOf(bnn.LWb), Integer.valueOf(bnn.LWa), Integer.valueOf(bnn.LVZ));
            b.DH(bnn.KHg);
            b.DI(bnn.oTV);
            b.DK((long) bnn.LWb);
            b.DL((long) bnn.LWa);
            b.DM((long) bnn.LVZ);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(103482);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 438;
    }
}
