package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agw;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    private i callback;
    private d rr;

    public a(int i2) {
        AppMethodBeat.i(20765);
        d.a aVar = new d.a();
        aVar.iLN = new agv();
        aVar.iLO = new agw();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
        aVar.funcId = 1194;
        this.rr = aVar.aXF();
        agv agv = (agv) this.rr.iLK.iLR;
        agv.Lqy = "invoice_info";
        agv.Lqz = i2;
        agv.source = 2;
        AppMethodBeat.o(20765);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20766);
        Log.d("MicroMsg.NetSceneDeleteUserAutoFillInfo", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.NetSceneDeleteUserAutoFillInfo", "");
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20766);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1194;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20767);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(20767);
        return dispatch;
    }
}
