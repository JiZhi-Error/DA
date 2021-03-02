package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends q implements m {
    private i callback;
    private com.tencent.mm.ak.d rr = null;
    private bxu yrt = null;
    public bxv yru = null;

    public d() {
        AppMethodBeat.i(25460);
        d.a aVar = new d.a();
        aVar.iLN = new bxu();
        aVar.iLO = new bxv();
        aVar.funcId = 288;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcogiftcardlist";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.yrt = (bxu) this.rr.iLK.iLR;
        Log.i("MicroMsg.NetSceneIPCallGetGiftCardList", "NetSceneIPCallGetGiftCardList");
        AppMethodBeat.o(25460);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 288;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(25461);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(25461);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(25462);
        Log.i("MicroMsg.NetSceneIPCallGetGiftCardList", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.yru = (bxv) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(25462);
    }
}
