package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.sdk.platformtools.Log;

public final class p extends q implements m {
    private i callback;
    boolean iQA = false;
    public d rr;

    public p(String str, String str2) {
        AppMethodBeat.i(124301);
        d.a aVar = new d.a();
        aVar.iLN = new bjl();
        aVar.iLO = new bjm();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfo";
        aVar.funcId = 1352;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bjl bjl = (bjl) this.rr.iLK.iLR;
        bjl.KTl = str;
        bjl.KTt = str2;
        this.iQA = true;
        AppMethodBeat.o(124301);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124302);
        Log.d("MicroMsg.brandservice.NetSceneGetBizChatInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124302);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1352;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124303);
        this.callback = iVar;
        Log.i("MicroMsg.brandservice.NetSceneGetBizChatInfo", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124303);
        return dispatch;
    }
}
