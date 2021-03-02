package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.clb;
import com.tencent.mm.protocal.protobuf.clc;
import com.tencent.mm.sdk.platformtools.Log;

public final class h extends q implements m {
    private i callback;
    public d rr;

    public h(String str) {
        AppMethodBeat.i(5574);
        d.a aVar = new d.a();
        aVar.iLN = new clb();
        aVar.iLO = new clc();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/getallrecvtmpmsgoption";
        aVar.funcId = 1031;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((clb) this.rr.iLK.iLR).Mis = str;
        AppMethodBeat.o(5574);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(5575);
        Log.d("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(5575);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1031;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(5576);
        this.callback = iVar;
        Log.i("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(5576);
        return dispatch;
    }
}
