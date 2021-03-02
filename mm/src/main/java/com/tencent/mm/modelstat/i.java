package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends q implements m {
    private com.tencent.mm.ak.i heq;
    private final d rr;

    public i(int i2, String str, int i3) {
        AppMethodBeat.i(94871);
        d.a aVar = new d.a();
        aVar.iLN = new bx();
        aVar.iLO = new by();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
        aVar.funcId = 1295;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cg cgVar = new cg();
        cgVar.KGy = i2;
        cgVar.KGz = new b(str.getBytes());
        cgVar.xvg = (long) i3;
        ((bx) this.rr.iLK.iLR).KFY.add(cgVar);
        Log.i("MicroMsg.NetSceneAdDataReport", "init logId:%d, logStr:%s", Integer.valueOf(i2), str);
        AppMethodBeat.o(94871);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(94872);
        by byVar = (by) this.rr.iLL.iLR;
        Log.i("MicroMsg.NetSceneAdDataReport", "onGYNetEnd, errType = %d, errCode = %d, ret=%d, msg=%s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(byVar.ret), byVar.msg);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(94872);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1295;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(94873);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(94873);
        return dispatch;
    }
}
