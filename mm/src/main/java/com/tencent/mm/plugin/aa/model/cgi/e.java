package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends q implements m {
    private i callback;
    private d hJu;
    private com.tencent.mm.protocal.protobuf.d jTc = ((com.tencent.mm.protocal.protobuf.d) this.hJu.iLK.iLR);
    public com.tencent.mm.protocal.protobuf.e jTd;
    public int scene;

    public e(String str, int i2, String str2) {
        AppMethodBeat.i(63375);
        d.a aVar = new d.a();
        aVar.iLN = new com.tencent.mm.protocal.protobuf.d();
        aVar.iLO = new com.tencent.mm.protocal.protobuf.e();
        aVar.funcId = 1530;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaclose";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.jTc.KBt = str2;
        this.jTc.KBs = str;
        this.jTc.scene = i2;
        this.scene = i2;
        Log.d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", this.jTc.KBs, Integer.valueOf(i2));
        AppMethodBeat.o(63375);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1530;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63376);
        Log.i("MicroMsg.NetSceneAAClose", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(63376);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(63377);
        Log.i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        this.jTd = (com.tencent.mm.protocal.protobuf.e) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", Integer.valueOf(this.jTd.dDN), this.jTd.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(63377);
    }
}
