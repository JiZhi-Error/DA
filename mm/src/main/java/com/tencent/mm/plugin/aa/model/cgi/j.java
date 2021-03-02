package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.sdk.platformtools.Log;

public final class j extends q implements m, com.tencent.mm.wallet_core.c.j {
    private i callback;
    private d hJu;
    private com.tencent.mm.protocal.protobuf.q jTm = ((com.tencent.mm.protocal.protobuf.q) this.hJu.iLK.iLR);
    public r jTn;

    public j(String str, long j2, int i2, String str2, String str3) {
        AppMethodBeat.i(212948);
        d.a aVar = new d.a();
        aVar.iLN = new com.tencent.mm.protocal.protobuf.q();
        aVar.iLO = new r();
        aVar.funcId = 1629;
        aVar.uri = "/cgi-bin/mmpay-bin/newaapay";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.jTm.KBs = str;
        this.jTm.KBK = j2;
        this.jTm.scene = i2;
        this.jTm.KBt = str2;
        this.jTm.KBL = str3;
        Log.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", this.jTm.KBs, Long.valueOf(this.jTm.KBK), Integer.valueOf(this.jTm.scene), this.jTm.KBt);
        AppMethodBeat.o(212948);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1629;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63389);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(63389);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(63390);
        Log.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        this.jTn = (r) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", Integer.valueOf(this.jTn.dDN), this.jTn.qwn, this.jTn.dXf);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(63390);
    }
}
