package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cec;
import com.tencent.mm.protocal.protobuf.ced;
import com.tencent.mm.sdk.platformtools.Log;

public final class s extends q implements m {
    private i heq;
    public final d rr;

    public s(String str, String str2) {
        AppMethodBeat.i(78894);
        d.a aVar = new d.a();
        aVar.iLN = new cec();
        aVar.iLO = new ced();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetuseropenid";
        aVar.funcId = 1566;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cec cec = (cec) this.rr.iLK.iLR;
        cec.UserName = str2;
        cec.jfi = str;
        AppMethodBeat.o(78894);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(78895);
        Log.i("MicroMsg.NetSceneGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78895);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1566;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78896);
        Log.i("MicroMsg.NetSceneGetUserOpenId", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78896);
        return dispatch;
    }
}
