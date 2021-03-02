package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.x;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends q implements m {
    private i callback;
    private d hJu;
    private x jTo = ((x) this.hJu.iLK.iLR);
    public y jTp;

    public k(String str, int i2, String str2, String str3, int i3) {
        AppMethodBeat.i(63391);
        d.a aVar = new d.a();
        aVar.iLN = new x();
        aVar.iLO = new y();
        aVar.funcId = 1695;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerydetail";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.jTo.KBs = str;
        this.jTo.scene = i2;
        this.jTo.KBt = str2;
        if (i2 == 5) {
            Log.i("MicroMsg.NetSceneAAQueryDetail", "set sign and ver");
            this.jTo.sign = str3;
            this.jTo.ver = i3;
        }
        Log.i("MicroMsg.NetSceneAAQueryDetail", "NetSceneAAQueryDetail, billNo: %s, scene: %s, groupId: %s", str, Integer.valueOf(i2), str2);
        AppMethodBeat.o(63391);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(63392);
        Log.i("MicroMsg.NetSceneAAQueryDetail", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        this.jTp = (y) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneAAQueryDetail", "retcode: %s, retmsg: %s", Integer.valueOf(this.jTp.dDN), this.jTp.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(63392);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1695;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63393);
        Log.i("MicroMsg.NetSceneAAQueryDetail", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(63393);
        return dispatch;
    }
}
