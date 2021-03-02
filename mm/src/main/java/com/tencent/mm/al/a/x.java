package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.elr;
import com.tencent.mm.protocal.protobuf.els;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.sdk.platformtools.Log;

public final class x extends q implements m {
    private i callback;
    Object data;
    public d rr;

    public x(String str, nt ntVar, Object obj) {
        AppMethodBeat.i(124325);
        d.a aVar = new d.a();
        aVar.iLN = new elr();
        aVar.iLO = new els();
        aVar.uri = "/cgi-bin/mmocbiz-bin/updatebizchat";
        aVar.funcId = 1356;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        elr elr = (elr) this.rr.iLK.iLR;
        elr.KTt = str;
        elr.LPp = ntVar;
        this.data = obj;
        AppMethodBeat.o(124325);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124326);
        Log.d("MicroMsg.brandservice.NetSceneUpdateBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124326);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1356;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124327);
        this.callback = iVar;
        Log.i("MicroMsg.brandservice.NetSceneUpdateBizChat", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124327);
        return dispatch;
    }
}
