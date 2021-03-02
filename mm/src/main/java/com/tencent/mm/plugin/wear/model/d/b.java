package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bp;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ezq;
import com.tencent.mm.protocal.protobuf.ezr;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    private i callback;
    private d iUB;

    public b(String str) {
        AppMethodBeat.i(30057);
        d.a aVar = new d.a();
        aVar.funcId = 976;
        aVar.uri = "/cgi-bin/micromsg-bin/sendyo";
        aVar.iLN = new ezq();
        aVar.iLO = new ezr();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iUB = aVar.aXF();
        ezq ezq = (ezq) this.iUB.iLK.iLR;
        ezq.xNG = str;
        ezq.MuU = ezq.CreateTime;
        ezq.CreateTime = (int) bp.Kw(str);
        ezq.oUv = 63;
        ezq.NvO = 1;
        ezq.oTz = 1;
        AppMethodBeat.o(30057);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(30058);
        Log.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + i2 + " errType = " + i3 + " errCode = " + i4 + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(30058);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 976;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(30059);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(30059);
        return dispatch;
    }
}
