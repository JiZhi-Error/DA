package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bni;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private i callback;
    private d rr;
    public bnj sXj;

    public c(int i2, String str, String str2) {
        AppMethodBeat.i(186389);
        d.a aVar = new d.a();
        aVar.iLN = new bni();
        aVar.iLO = new bnj();
        aVar.funcId = 1108;
        aVar.uri = "/cgi-bin/mmpay-bin/getfacecontractstatus";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bni bni = (bni) this.rr.iLK.iLR;
        bni.scene = i2;
        bni.LVV = str;
        bni.LVM = str2;
        Log.i("MicroMsg.FaceAgreementUICGI", "[cgi-request]NetSceneGetFaceContract scene:%s,userInfo:%s,sign:%s", Integer.valueOf(i2), str, str2);
        AppMethodBeat.o(186389);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1108;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(186390);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(186390);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(186391);
        Log.i("MicroMsg.FaceAgreementUICGI", "[cgi-ret]onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.sXj = (bnj) ((d) sVar).iLL.iLR;
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(186391);
    }
}
