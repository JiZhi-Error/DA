package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends q implements m {
    private com.tencent.mm.ak.i callback;
    private d hJu;
    private o jTk = ((o) this.hJu.iLK.iLR);
    public p jTl;

    public i() {
        AppMethodBeat.i(63385);
        d.a aVar = new d.a();
        aVar.iLN = new o();
        aVar.iLO = new p();
        aVar.funcId = 1698;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaoperation";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        AppMethodBeat.o(63385);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1698;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(63386);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(63386);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(63387);
        Log.i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        this.jTl = (p) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", Integer.valueOf(this.jTl.dDN), this.jTl.qwn, Integer.valueOf(this.jTl.jTs), Integer.valueOf(this.jTl.jTt), Integer.valueOf(this.jTl.jTu), Long.valueOf(this.jTl.jTv), Long.valueOf(this.jTl.jTw), this.jTl.jTx, this.jTl.jTy);
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(63387);
    }
}
