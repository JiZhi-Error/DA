package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.sdk.platformtools.Log;

public final class m extends q implements com.tencent.mm.network.m {
    private i callback = null;
    public int dYx;
    public String ixZ;
    public String rCB;
    private d rr = null;

    public m(String str, String str2, int i2, String str3) {
        AppMethodBeat.i(23534);
        this.rCB = str3;
        this.ixZ = str2;
        this.dYx = i2;
        this.rCB = str3;
        d.a aVar = new d.a();
        aVar.iLN = new cic();
        aVar.iLO = new cid();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/addlike";
        aVar.funcId = 1041;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cic cic = (cic) this.rr.iLK.iLR;
        cic.rJH = str2;
        cic.username = str;
        cic.dYx = i2;
        cic.ixr = str3;
        AppMethodBeat.o(23534);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1041;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23535);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23535);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23536);
        Log.d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23536);
    }
}
