package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.protocal.protobuf.dup;
import com.tencent.mm.protocal.protobuf.ewh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class m extends q implements com.tencent.mm.network.m {
    private i callback;
    private d rr = null;
    private duo yrM = null;
    public dup yrN = null;

    public m(int i2, int i3, LinkedList<ewh> linkedList) {
        AppMethodBeat.i(25487);
        d.a aVar = new d.a();
        aVar.iLN = new duo();
        aVar.iLO = new dup();
        aVar.funcId = 871;
        aVar.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.yrM = (duo) this.rr.iLK.iLR;
        this.yrM.Mvj = i3;
        this.yrM.MVU = linkedList;
        this.yrM.MVT = linkedList.size();
        this.yrM.MVV = i2;
        Log.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(25487);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 871;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(25488);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(25488);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(25489);
        Log.i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.yrN = (dup) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(25489);
    }
}
