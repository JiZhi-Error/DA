package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.sdk.platformtools.Log;

public final class o extends q implements m {
    private i callback;
    Object data;
    public d rr;

    public o(String str, bfs bfs, Object obj) {
        AppMethodBeat.i(124298);
        d.a aVar = new d.a();
        aVar.iLN = new aeb();
        aVar.iLO = new aec();
        aVar.uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
        aVar.funcId = 1355;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        aeb aeb = (aeb) this.rr.iLK.iLR;
        aeb.KTt = str;
        aeb.Lpw = bfs;
        this.data = obj;
        AppMethodBeat.o(124298);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124299);
        Log.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124299);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1355;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124300);
        this.callback = iVar;
        Log.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124300);
        return dispatch;
    }

    public final aec baD() {
        if (this.rr == null || this.rr.iLL.iLR == null) {
            return null;
        }
        return (aec) this.rr.iLL.iLR;
    }

    public final aeb baE() {
        if (this.rr == null || this.rr.iLK.iLR == null) {
            return null;
        }
        return (aeb) this.rr.iLK.iLR;
    }
}
