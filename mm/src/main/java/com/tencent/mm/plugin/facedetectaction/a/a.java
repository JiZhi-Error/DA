package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    private i callback;
    private d rr;
    private bne sXf = ((bne) this.rr.iLK.iLR);
    public bnf sXg;

    public a(int i2, String str, String str2) {
        AppMethodBeat.i(104195);
        d.a aVar = new d.a();
        aVar.iLN = new bne();
        aVar.iLO = new bnf();
        aVar.funcId = 2696;
        aVar.uri = "/cgi-bin/mmpay-bin/getfacecheckaction";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.sXf.scene = i2;
        this.sXf.qGp = str;
        this.sXf.LVM = str2;
        Log.i("MicroMsg.NetSceneGetFaceCheckAction", "create GetFaceCheckAction, scene: %s, packageName: %s, packageSign: %s", Integer.valueOf(i2), str, str2);
        AppMethodBeat.o(104195);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2696;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(104196);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(104196);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(104197);
        Log.i("MicroMsg.NetSceneGetFaceCheckAction", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.sXg = (bnf) ((d) sVar).iLL.iLR;
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(104197);
    }
}
