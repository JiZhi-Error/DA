package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfe;
import com.tencent.mm.protocal.protobuf.cff;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    private i callback;
    public int errCode;
    public String errMsg;
    public int errType;
    private Runnable jkz;
    public String qwG;
    public final d rr;
    public String yFs = "";

    public b(String str) {
        AppMethodBeat.i(55788);
        d.a aVar = new d.a();
        aVar.iLN = new cfe();
        aVar.iLO = new cff();
        aVar.uri = "/cgi-bin/micromsg-bin/jointrackroom";
        aVar.funcId = 490;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((cfe) this.rr.iLK.iLR).Mls = str;
        Log.d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:".concat(String.valueOf(str)));
        AppMethodBeat.o(55788);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 490;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(55789);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(55789);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        cff cff;
        AppMethodBeat.i(55790);
        this.errType = i3;
        this.errCode = i4;
        this.errMsg = str;
        if (((d) sVar).iLL.iLR != null) {
            cff = (cff) ((d) sVar).iLL.iLR;
        } else {
            cff = null;
        }
        Log.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i3), Integer.valueOf(i4));
        if ((i4 == 0 || i4 >= 1000) && cff != null) {
            this.yFs = cff.Ltk;
            Log.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", this.yFs);
        }
        if (cff != null) {
            this.qwG = cff.KOu;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        if (this.jkz != null) {
            this.jkz.run();
        }
        AppMethodBeat.o(55790);
    }
}
