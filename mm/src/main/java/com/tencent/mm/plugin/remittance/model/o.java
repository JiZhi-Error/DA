package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.sdk.platformtools.Log;

public final class o extends q implements m {
    private wh CoL = ((wh) this.hJu.iLK.iLR);
    private i callback;
    private d hJu;

    public o(String str, String str2, String str3, String str4, int i2) {
        AppMethodBeat.i(67865);
        d.a aVar = new d.a();
        aVar.iLN = new wh();
        aVar.iLO = new wi();
        aVar.funcId = 1273;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fpaycheck";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.CoL.KHM = str;
        this.CoL.KHN = str2;
        this.CoL.Lhy = str3;
        this.CoL.Lhz = str4;
        this.CoL.yRL = i2;
        Log.d("MicroMsg.NetSceneF2fPayCheck", "NetSceneF2fPayCheck, f2fId: %s, transId: %s, extendStr: %s, amount: %s", str, str2, str3, Integer.valueOf(i2));
        AppMethodBeat.o(67865);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1273;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67866);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(67866);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(67867);
        Log.i("MicroMsg.NetSceneF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(67867);
    }
}
