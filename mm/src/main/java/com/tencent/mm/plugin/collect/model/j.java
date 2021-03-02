package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.vm;
import com.tencent.mm.protocal.protobuf.vn;
import com.tencent.mm.sdk.platformtools.Log;

public final class j extends q implements m {
    private i callback;
    private d hJu;
    public vn qwi;

    public j() {
        AppMethodBeat.i(63822);
        d.a aVar = new d.a();
        aVar.iLN = new vm();
        aVar.iLO = new vn();
        aVar.funcId = 1256;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fannounce";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        Log.d("MicroMsg.NetSceneF2fAnnouce", "do cgi");
        AppMethodBeat.o(63822);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1256;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63823);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(63823);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(63824);
        Log.i("MicroMsg.NetSceneF2fAnnouce", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.qwi = (vn) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(63824);
    }
}
